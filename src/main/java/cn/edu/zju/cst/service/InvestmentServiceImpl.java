package cn.edu.zju.cst.service;
import cn.edu.zju.cst.dao.IInvestmentDao;
import cn.edu.zju.cst.domain.Investment;
import cn.edu.zju.cst.dto.InterestResultDTO;
import cn.edu.zju.cst.dto.InvestmentDetailDTO;
import cn.edu.zju.cst.dto.InvestmentOverviewDTO;
import cn.edu.zju.cst.dto.RegularResultDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import static cn.edu.zju.cst.util.DoubleUtil.*;

/**
 * Created by DEAN on 2017/10/31.
 */
@Service("investmentService")
public class InvestmentServiceImpl implements IInvestmentService {
    private DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    @Autowired
    private IInvestmentDao investmentDao;
    @Override
    public InterestResultDTO calculateInterest(double principal, double annualInterestRate, int investmentHorizon, String investmentRepayment, String interestExpiryDate, String investmentCompound) {
        InterestResultDTO interestResultDTO = new InterestResultDTO();
        //银行活期储蓄平均年利率
        double bankInterestRate = 0.0035;
        //余额宝平均年收益率
        double yuebaoInterestRate = 0.0389;
        //计算银行活期储蓄和余额宝收益（余额宝年收益率已经包含了复利计算，不需要再算复利）
        interestResultDTO.setDepositBankInterest(dealWithPoint2(principal*bankInterestRate/365*investmentHorizon));
        interestResultDTO.setYuebaoInterest(dealWithPoint2(principal*yuebaoInterestRate/365*investmentHorizon));
        //判断是否符合 一次性还本付息（rdm）
        if("rdm".equals(investmentRepayment)){
            //判断是否符合 每日还本付息 投资项目
            if("daily".equals(interestExpiryDate)&&"t".equals(investmentCompound)){
                double x = 1 + annualInterestRate/365;
                double y = investmentHorizon;
                double totalMoney = Math.pow(x,y)*principal;
                double totalInterest = totalMoney-principal;
                interestResultDTO.setTotalInterest(dealWithPoint2(totalInterest));
                interestResultDTO.setAverageInterest(dealWithPoint2(totalInterest/investmentHorizon));
                return interestResultDTO;
            }else if("monthly".equals(interestExpiryDate)&&"f".equals(investmentCompound)){
                //符合 一次性还本付息 投资项目
                int numOfMonth = investmentHorizon/30;
                double totalInterest = principal*annualInterestRate/12*numOfMonth;
                interestResultDTO.setTotalInterest(dealWithPoint2(totalInterest));
                interestResultDTO.setAverageInterest(dealWithPoint2(totalInterest/investmentHorizon));
                return interestResultDTO;
            }
        }else if("mpmd".equals(investmentRepayment)&&"monthly".equals(interestExpiryDate)&&"f".equals(investmentCompound)){
            //符合 按月付息到期付本 项目
            int numOfMonth = investmentHorizon/30;
            double totalInterest = principal*annualInterestRate/12*numOfMonth;
            interestResultDTO.setTotalInterest(dealWithPoint2(totalInterest));
            interestResultDTO.setAverageInterest(dealWithPoint2(totalInterest/investmentHorizon));
            return interestResultDTO;
        }else if("acm".equals(investmentRepayment)&&"monthly".equals(interestExpiryDate)&&"f".equals(investmentCompound)){
            //符合 等额本金 项目
            int numOfMonth = investmentHorizon/30;
            double returnPrincipal = principal/numOfMonth;
            double totalInterest = 0;
            for(int i=0;i<numOfMonth;++i){
                totalInterest+=(principal-i*returnPrincipal)*annualInterestRate/12;
            }
            interestResultDTO.setTotalInterest(dealWithPoint2(totalInterest));
            interestResultDTO.setAverageInterest(dealWithPoint2(totalInterest/investmentHorizon));
            return interestResultDTO;
        }else if("acpim".equals(investmentRepayment)&&"monthly".equals(interestExpiryDate)&&"f".equals(investmentCompound)){
            //符合 等额本息 项目
            int numOfMonth = investmentHorizon/30;
            double monthlyInterestRate = annualInterestRate/12;
            //等额本息产生总收益的公式：A×［（B×C－1）×（1十C）ˆB十1］／（（1十C）ˆB－1）
            //参数说明：A:principal  B:numOfMonth  C:monthlyInterestRate
            double part1 = (numOfMonth*monthlyInterestRate-1)*Math.pow(1+monthlyInterestRate,numOfMonth)+1;
            double part2 = principal*part1;
            double part3 = Math.pow(1+monthlyInterestRate,numOfMonth)-1;
            double totalInterest = part2/part3;
            interestResultDTO.setTotalInterest(dealWithPoint2(totalInterest));
            interestResultDTO.setAverageInterest(dealWithPoint2(totalInterest/investmentHorizon));
            return interestResultDTO;
        }
        //以上均不符合，没有对应的项目收益计算
        return null;
    }
    @Override
    public RegularResultDTO calculateAcpim(double principal, double annualInterestRate, int investmentHorizon) {
        //等额本息投资详情
        RegularResultDTO regularResultDTO = new RegularResultDTO();
        List<Double> returnPrincipal = new ArrayList<>();
        List<Double> returnInterest = new ArrayList<>();
        List<Double> returnMoney = new ArrayList<>();
        int numOfMonth = investmentHorizon/30;
        double monthlyInterestRate = annualInterestRate/12;
        regularResultDTO.setReturnMoneyTime(calculateReturnMoneyTime(numOfMonth));
        //第n月回款总额 A×C×（1＋C）ˆB÷（（1＋C）ˆB－1）
        //第n月回款本金 A×C×（1＋C）ˆ（n－1）／（（1＋C）ˆB一1）
        //第n月回款利息 A×C×［（1十C）ˆB－（1＋C）ˆ（n－1）］／（（1＋C）ˆB－1）
        //参数说明：A:principal  B:numOfMonth  C:monthlyInterestRate
        //计算每月回款本金、每月回款利息以及每月回款总额
        for(int n=1;n<=numOfMonth;++n){
            //每月回款本金
            double part1 = Math.pow(1+monthlyInterestRate,n-1)*principal*monthlyInterestRate;
            double part2 = Math.pow(1+monthlyInterestRate,numOfMonth)-1;
            double part3 = part1/part2;
            returnPrincipal.add(dealWithPoint2(part3));
            //每月回款利息
            double part4 = Math.pow(1+monthlyInterestRate,numOfMonth)-Math.pow(1+monthlyInterestRate,n-1);
            double part5 = principal*monthlyInterestRate*part4;
            double part6 = Math.pow(1+monthlyInterestRate,numOfMonth)-1;
            double part7 = part5/part6;
            returnInterest.add(dealWithPoint2(part7));
            //每月回款总额
            double part8 = part3+part7;
            returnMoney.add(dealWithPoint2(part8));
        }
        regularResultDTO.setReturnPrincipal(returnPrincipal);
        regularResultDTO.setReturnInterest(returnInterest);
        regularResultDTO.setReturnMoney(returnMoney);
        return regularResultDTO;
    }
    @Override
    public RegularResultDTO calculateAcm(double principal, double annualInterestRate, int investmentHorizon) {
        //等额本金投资详情
        RegularResultDTO regularResultDTO = new RegularResultDTO();
        List<Double> returnPrincipal = new ArrayList<>();
        List<Double> returnInterest = new ArrayList<>();
        List<Double> returnMoney = new ArrayList<>();
        int numOfMonth = investmentHorizon/30;
        double monthlyInterestRate = annualInterestRate/12;
        regularResultDTO.setReturnMoneyTime(calculateReturnMoneyTime(numOfMonth));
        //计算每月回款本金、每月回款利息以及每月回款总额
        for(int n=0;n<numOfMonth;++n){
            //每月回款本金
            double part1 = principal/numOfMonth;
            returnPrincipal.add(dealWithPoint2(part1));
            //每月回款利息
            double part2 = (principal-part1*n)*monthlyInterestRate;
            returnInterest.add(dealWithPoint2(part2));
            //每月回款总额
            double part3 = part1+part2;
            returnMoney.add(dealWithPoint2(part3));
        }
        regularResultDTO.setReturnPrincipal(returnPrincipal);
        regularResultDTO.setReturnInterest(returnInterest);
        regularResultDTO.setReturnMoney(returnMoney);
        return regularResultDTO;
    }
    @Override
    public RegularResultDTO calculateMpmd(double principal, double annualInterestRate, int investmentHorizon) {
        //按月付息到期付本
        RegularResultDTO regularResultDTO = new RegularResultDTO();
        List<Double> returnPrincipal = new ArrayList<>();
        List<Double> returnInterest = new ArrayList<>();
        List<Double> returnMoney = new ArrayList<>();
        int numOfMonth = investmentHorizon/30;
        double monthlyInterestRate = annualInterestRate/12;
        regularResultDTO.setReturnMoneyTime(calculateReturnMoneyTime(numOfMonth));
        //计算每月回款本金、每月回款利息以及每月回款总额
        for(int n=1;n<=numOfMonth;++n){
            //每月回款本金
            double part1;
            if(n==numOfMonth){
                part1 = principal;
            }else{
                part1 = 0;
            }
            returnPrincipal.add(dealWithPoint2(part1));
            //每月回款利息
            double part2 = principal*monthlyInterestRate;
            returnInterest.add(dealWithPoint2(part2));
            //每月回款总额
            double part3 = part1+part2;
            returnMoney.add(dealWithPoint2(part3));
        }
        regularResultDTO.setReturnPrincipal(returnPrincipal);
        regularResultDTO.setReturnInterest(returnInterest);
        regularResultDTO.setReturnMoney(returnMoney);
        return regularResultDTO;
    }
    //计算预计每月回款时间
    private List<String> calculateReturnMoneyTime(int numOfMonth){
        List<String> returnMoneyTime = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        //默认从投资后的次天开始计息
        calendar.add(Calendar.DAY_OF_MONTH,1);
        calendar.add(Calendar.MONTH,1);
        for(int i=1;i<=numOfMonth;++i){
            returnMoneyTime.add(dateFormat.format(calendar.getTime()));
            calendar.add(Calendar.MONTH,1);
        }
        return returnMoneyTime;
    }
    @Override
    public InvestmentOverviewDTO getInvestmentOverview(String investmentRepayment) {
        InvestmentOverviewDTO investmentOverviewDTO = new InvestmentOverviewDTO();
        List<Investment> investmentList;
        List<String> annualInterestRate = new ArrayList<>();
        List<Integer> investmentHorizon = new ArrayList<>();
        investmentList = investmentDao.selectInvestmentsByRepayAndCompound(investmentRepayment,"f");
        //转换investmentList为InvestmentOverviewDTO类实例
        for(int i=0;i<investmentList.size();++i){
            double part1 = investmentList.get(i).getAnnualInterestRate()*100;
            String part2 = dealWithPoint2(part1)+"%";
            annualInterestRate.add(part2);
            int part3 = investmentList.get(i).getInvestmentHorizon();
            int part4 = part3/30;
            investmentHorizon.add(part4);
        }
        investmentOverviewDTO.setAnnualInterestRate(annualInterestRate);
        investmentOverviewDTO.setInvestmentHorizon(investmentHorizon);
        return investmentOverviewDTO;
    }
    @Override
    public InvestmentDetailDTO getInvestmentDetail(String investmentRepayment, int investmentHorizon) {
        InvestmentDetailDTO investmentDetailDTO = new InvestmentDetailDTO();
        //转换investment为InvestmentDetailDTO类实例
        Investment investment = investmentDao.selectInvestmentByRepayAndHorizon(investmentRepayment,investmentHorizon);
        investmentDetailDTO.setInvestmentId(investment.getId());
        investmentDetailDTO.setInvestmentName(investment.getInvestmentName());
        investmentDetailDTO.setInvestmentIntroduction(investment.getInvestmentIntroduction());
        double part1 = investment.getAnnualInterestRate()*100;
        String part2 = dealWithPoint2(part1)+"%";
        investmentDetailDTO.setAnnualInterestRate(part2);
        int part3 = investment.getInvestmentHorizon();
        int part4 = part3/30;
        investmentDetailDTO.setInvestmentHorizon(part4);
        investmentDetailDTO.setMinimumPurchase(investment.getMinimumPurchase());
        investmentDetailDTO.setMaximumPurchase(investment.getMaximumPurchase());
        //计息方式
        if("monthly".equals(investment.getInterestExpiryDate())){
            investmentDetailDTO.setInterestExpiryDate("按月计息");
        }else if("daily".equals(investment.getInterestExpiryDate())){
            investmentDetailDTO.setInterestExpiryDate("按日计息");
        }else{
            investmentDetailDTO.setInterestExpiryDate("其它计息方式(暂未提供)");
        }
        // 复利情况
        if("t".equals(investment.getInvestmentCompound())){
            investmentDetailDTO.setInvestmentCompound("计算复利");
        }else if("f".equals(investment.getInvestmentCompound())){
            investmentDetailDTO.setInvestmentCompound("不计算复利");
        }else{
            investmentDetailDTO.setInvestmentCompound("参数错误，复利情况不明");
        }
        investmentDetailDTO.setNumberOfPeopleAdded(investment.getNumberOfPeopleAdded());
        return investmentDetailDTO;
    }

    @Override
    public Investment getInvestmentById(int id) {
        return investmentDao.selectInvestmentById(id);
    }
}