package cn.edu.zju.cst.service;

import cn.edu.zju.cst.dao.*;
import cn.edu.zju.cst.domain.Investment;
import cn.edu.zju.cst.domain.UserAccount;
import cn.edu.zju.cst.domain.UserInvestment;
import cn.edu.zju.cst.dto.UserAccountDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by DEAN on 2017/11/1.
 */
@Service("userInvestmentService")
public class UserInvestmentServiceImpl implements IUserInvestmentService {
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    @Autowired
    IInvestmentDao investmentDao;
    @Autowired
    IUserInvestmentDao userInvestmentDao;
    @Autowired
    IUserAccountDao userAccountDao;

    @Override
    public String setUserInvestment(int userId, int investmentId, double principal) {
        //判断投资是否符合最低起购金额、最大购买额度
        Investment investment = investmentDao.selectInvestmentById(investmentId);
        int minimumPurchase = investment.getMinimumPurchase();
        int maximumPurchase = investment.getMaximumPurchase();
        if(principal<minimumPurchase){
            return "投资失败，不符合最低起购金额";
        }else if(principal>maximumPurchase){
            return "投资失败，不符合最大购买额度";
        }
        //判断账户余额是否足够支付本次投资
        UserAccount userAccount = userAccountDao.selectUserAccountByUserId(userId);
        double accountBalance = userAccount.getAccountBalance();
        if(principal>accountBalance){
            return "投资失败，账户余额不足";
        }
        //生成投资
        UserInvestment userInvestment = new UserInvestment();
        Calendar calendar = Calendar.getInstance();
        //投资开始时间为次日
        calendar.add(Calendar.DAY_OF_MONTH,1);
        String startTime = dateFormat.format(calendar.getTime());
        userInvestment.setStartTime(startTime);
        int investmentHorizon = investment.getInvestmentHorizon();
        String endTime;
        if(investmentHorizon==0){
            //无投资期限的投资，结束时间为5年后
            calendar.add(Calendar.YEAR,5);
            endTime = dateFormat.format(calendar.getTime());
        }else{
            calendar.add(Calendar.MONTH,investmentHorizon/30);
            endTime = dateFormat.format(calendar.getTime());
        }
        userInvestment.setEndTime(endTime);
        //更新累计参与该项目的人次
        int numberOfPeopleAdded = investment.getNumberOfPeopleAdded()+1;
        investmentDao.updatePeopleById(investmentId,numberOfPeopleAdded);
        //更新账户余额
        userAccountDao.updateAccountBalanceByUserId(userId,accountBalance-principal);
        //设置其它参数
        userInvestment.setUserId(userId);
        userInvestment.setInvestmentId(investmentId);
        userInvestment.setLockPrincipal(principal);
        userInvestment.setLockInterest(0);
        userInvestment.setPrincipal(0);
        userInvestment.setInterest(0);
        userInvestmentDao.insertUserInvestment(userInvestment);
        return "投资成功，将从次日起开始计息";
    }

    @Override
    public List<UserInvestment> getUserInvestments(int userId) {
        List<UserInvestment> userInvestmentList;
        userInvestmentList = userInvestmentDao.selectUserInvestmentsByUserId(userId);
        return userInvestmentList;
    }

    @Override
    public String extractMoneyToAccount(int userInvestmentId) {
        UserInvestment userInvestment = userInvestmentDao.selectUserInvestmentById(userInvestmentId);
        UserAccount userAccount = userAccountDao.selectUserAccountByUserId(userInvestment.getUserId());
        double accountBalance = userAccount.getAccountBalance();
        double accruedInterest = userAccount.getAccruedInterest();
        double lockPrincipal = userInvestment.getLockPrincipal();
        double lockInterest = userInvestment.getLockInterest();
        double principal = userInvestment.getPrincipal();
        double interest = userInvestment.getInterest();
        double money = principal+interest;
        if(money==0){
            return "无可提取本金、利息";
        }else{
            userAccountDao.updateAccountBalanceByUserId(userInvestment.getUserId(),money+accountBalance);
            userAccountDao.updateAccruedInterestByUserId(userInvestment.getUserId(),interest+accruedInterest);
            if(lockPrincipal==0&&lockInterest==0){
                //该投资项目已到期，且本金、利息都已提取到用户账户，则删除该项目
                userInvestmentDao.deleteUserInvestmentById(userInvestmentId);
                return "已提取本金、利息至账户，该投资项目已到期结束";
            }else{
                userInvestmentDao.updatePrincipalAndInterestById(userInvestmentId,lockPrincipal,lockInterest,0,0);
                return "已提取本金、利息至账户，该投资项目将继续投资";
            }
        }
    }

    @Override
    public UserAccountDTO getUserAccount(int userId) {
        UserAccountDTO userAccountDTO = new UserAccountDTO();
        UserAccount userAccount = userAccountDao.selectUserAccountByUserId(userId);
        userAccountDTO.setAccountBalance(userAccount.getAccountBalance());
        userAccountDTO.setBankCard(userAccount.getBankCard());
        userAccountDTO.setAccruedInterest(userAccount.getAccruedInterest());
        //计算lockMoney和money的值
        double lockMoney=0;
        double money=0;
        List<UserInvestment> userInvestmentList = userInvestmentDao.selectUserInvestmentsByUserId(userId);
        for(int i=0;i<userInvestmentList.size();++i){
            //对于计息方式为daily的需要特殊处理
            String interestExpiryDate = investmentDao.selectInvestmentById(userInvestmentList.get(i).getInvestmentId()).getInterestExpiryDate();
            if("daily".equals(interestExpiryDate)){
                double part1 = userInvestmentList.get(i).getPrincipal()+userInvestmentList.get(i).getInterest();
                lockMoney+=part1;
                money+=part1;
            }else{
                double part1 = userInvestmentList.get(i).getLockPrincipal()+userInvestmentList.get(i).getLockInterest();
                double part2 = userInvestmentList.get(i).getPrincipal()+userInvestmentList.get(i).getInterest();
                lockMoney+=part1;
                money+=part2;
            }
        }
        userAccountDTO.setLockMoney(lockMoney);
        userAccountDTO.setMoney(money);
        return userAccountDTO;
    }

    @Override
    public String testDayByDay(Date date) throws ParseException{
        //注意：每次测试前都要初始化数据库中数据，该测试会一次性计算从项目开始时间到输入的测试时间之间的本息情况
        //注意：输入的时间仅在符合项目投资起止时间内有效，超出某个投资项目结束时间的，该项目不会被处理
        List<UserInvestment> userInvestmentList = userInvestmentDao.selectAllUserInvestments();
        for(int i=0;i<userInvestmentList.size();++i){
            UserInvestment userInvestment = userInvestmentList.get(i);
            Date startTime = dateFormat.parse(userInvestment.getStartTime());
            Date endTime = dateFormat.parse(userInvestment.getEndTime());
            if(date.before(startTime)){
                //该投资项目还未开始计息，
                continue;
            }else if(date.after(endTime)){
                //该投资项目已经结束，不再处理
                continue;
            }else{
                int investmentId = userInvestment.getInvestmentId();
                Investment investment = investmentDao.selectInvestmentById(investmentId);
                String investmentRepayment = investment.getInvestmentRepayment();
                String interestExpiryDate = investment.getInterestExpiryDate();
                String investmentCompound = investment.getInvestmentCompound();
                double annualInterestRate = investment.getAnnualInterestRate();
                //判断是否符合 一次性还本付息（rdm）
                if("rdm".equals(investmentRepayment)){
                    //判断是否符合 每日还本付息 投资项目
                    //每日还本付息第一次计算和后续计算使用的计算字段不同。目前只按第一次计算实现
                    if("daily".equals(interestExpiryDate)&&"t".equals(investmentCompound)){
                        double x = 1 + annualInterestRate/365;
                        double y = TimeUnit.MILLISECONDS.toDays(date.getTime()-startTime.getTime())+1;
                        double principal = userInvestment.getLockPrincipal();
                        double interest = Math.pow(x,y)*principal-principal;
                        userInvestmentDao.updatePrincipalAndInterestById(userInvestment.getId(),0,0,principal,interest);
                    }else if("monthly".equals(interestExpiryDate)&&"f".equals(investmentCompound)){
                        //符合 一次性还本付息 投资项目
                        //如果输入参数正好是最后的投资期限，应当将lockPrincipal和lockInterest一对一转到principal和interest。测试时暂不处理
                        int n = calculateReturnMoneyTime(startTime,investment.getInvestmentHorizon()/30, date);
                        double lockInterest = userInvestment.getLockPrincipal()*annualInterestRate/12*n;
                        userInvestmentDao.updatePrincipalAndInterestById(userInvestment.getId(),userInvestment.getLockPrincipal(),lockInterest,0,0);
                    }
                }else if("mpmd".equals(investmentRepayment)&&"monthly".equals(interestExpiryDate)&&"f".equals(investmentCompound)){
                    //符合 按月付息到期付本 项目
                    int n = calculateReturnMoneyTime(startTime,investment.getInvestmentHorizon()/30, date);
                    double interest = userInvestment.getLockPrincipal()*annualInterestRate/12*n;
                    userInvestmentDao.updatePrincipalAndInterestById(userInvestment.getId(),userInvestment.getLockPrincipal(),0,0,interest);
                }else if("acm".equals(investmentRepayment)&&"monthly".equals(interestExpiryDate)&&"f".equals(investmentCompound)){
                    //符合 等额本金 项目
                    int numOfMonth = investment.getInvestmentHorizon()/30;
                    int n = calculateReturnMoneyTime(startTime,numOfMonth, date);
                    double lockPrincipal = userInvestment.getLockPrincipal();
                    double returnPrincipal = lockPrincipal/numOfMonth;
                    double principal = returnPrincipal*n;
                    double interest = 0;
                    for(int j=0;j<n;++j){
                        interest+=(lockPrincipal-j*returnPrincipal)*annualInterestRate/12;
                    }
                    lockPrincipal-=principal;
                    userInvestmentDao.updatePrincipalAndInterestById(userInvestment.getId(),lockPrincipal,0,principal,interest);
                }else if("acpim".equals(investmentRepayment)&&"monthly".equals(interestExpiryDate)&&"f".equals(investmentCompound)){
                    //符合 等额本息 项目
                    double monthlyInterestRate = investment.getAnnualInterestRate()/12;
                    int numOfMonth = investment.getInvestmentHorizon()/30;
                    int n = calculateReturnMoneyTime(startTime,numOfMonth, date);
                    double lockPrincipal = userInvestment.getLockPrincipal();
                    double principal = 0;
                    double interest = 0;
                    for(int j=1;j<=n;++j){
                        //第j月回款总额 A×C×（1＋C）ˆB÷（（1＋C）ˆB－1）
                        //第j月回款本金 A×C×（1＋C）ˆ（j－1）／（（1＋C）ˆB一1）
                        //第j月回款利息 A×C×［（1十C）ˆB－（1＋C）ˆ（j－1）］／（（1＋C）ˆB－1）
                        //参数说明：A:lockPrincipal  B:numOfMonth  C:monthlyInterestRate
                        //本金
                        double part1 = Math.pow(1+monthlyInterestRate,j-1)*lockPrincipal*monthlyInterestRate;
                        double part2 = Math.pow(1+monthlyInterestRate,numOfMonth)-1;
                        double part3 = part1/part2;
                        principal+=part3;
                        //利息
                        double part4 = Math.pow(1+monthlyInterestRate,numOfMonth)-Math.pow(1+monthlyInterestRate,j-1);
                        double part5 = lockPrincipal*monthlyInterestRate*part4;
                        double part6 = Math.pow(1+monthlyInterestRate,numOfMonth)-1;
                        double part7 = part5/part6;
                        interest+=part7;
                    }
                    lockPrincipal-=principal;
                    userInvestmentDao.updatePrincipalAndInterestById(userInvestment.getId(),lockPrincipal,0,principal,interest);
                }
            }
        }
        return "测试运行完毕，已对user_investment表更新";
    }

    //计算预计每月回款时间，并判断当前测试的日期处于哪个阶段
    private int calculateReturnMoneyTime(Date startTime, int numOfMonth, Date testDate){
        int n = 0;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startTime);
        calendar.add(Calendar.MONTH,1);
        for(int i=1;i<=numOfMonth;++i){
            Date date = calendar.getTime();
            if(testDate.after(date)||testDate.equals(date)){
                ++n;
                calendar.add(Calendar.MONTH,1);
            }else{
                break;
            }
        }
        return n;
    }
}
