package cn.edu.zju.cst.service;

import cn.edu.zju.cst.baseTest.SpringTestCase;
import cn.edu.zju.cst.domain.UserInvestment;
import cn.edu.zju.cst.dto.InterestResultDTO;
import cn.edu.zju.cst.dto.RegularResultDTO;
import cn.edu.zju.cst.dto.UserAccountDTO;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by DEAN on 2017/11/5.
 */
public class UserInvestmentServiceTest extends SpringTestCase{
    @Autowired
    IUserInvestmentService userInvestmentService;
    @Autowired
    IInvestmentService investmentService;

    Logger logger = Logger.getLogger(UserInvestmentServiceTest.class);

//    @Test
//    public void testSetUserInvestment(){
//        //新增投资
//        //用户id：1  投资项目id：2  投资本金：15000
//        String result = userInvestmentService.setUserInvestment(1,2,15000);
//        logger.debug("新增投资操作结果："+result);
//        //获取用户的所有投资
//        List<UserInvestment> userInvestmentList = userInvestmentService.getUserInvestments(1);
//        for(int i=0;i<userInvestmentList.size();++i){
//            logger.debug("用户投资项目："+userInvestmentList.get(i));
//        }
//        //已更新投资项目的累计人数，项目2起初为0
//        logger.debug("该项目累计人数已更新为："+investmentService.getInvestmentDetail("rdm",90).getNumberOfPeopleAdded());
//        //已更新用户账户余额，用户1起初为50000
//        logger.debug("账户余额为："+userInvestmentService.getUserAccount(1).getAccountBalance());
//    }

//    @Test
//    public void testGetUserInvestments(){
//        //获取用户的所有投资，不存在的用户id，list的size为0
//        List<UserInvestment> userInvestmentList = userInvestmentService.getUserInvestments(555);
//        for(int i=0;i<userInvestmentList.size();++i){
//            logger.debug("用户投资项目："+userInvestmentList.get(i));
//        }
//    }

    @Test
    public void testGetUserAccount(){
        UserAccountDTO userAccountDTO = userInvestmentService.getUserAccount(1);
        logger.debug("用户账户详情："+userAccountDTO);
    }

    @Test
    public void testExtractMoneyToAccount(){
        //测试 从指定投资项目中提取出来本金、利息到用户账户
        //结果为空
        String result1 = userInvestmentService.extractMoneyToAccount(1);
        logger.debug("提款操作结果："+result1);
        //测试 从指定投资项目中提取出来本金、利息到用户账户
        String result2 = userInvestmentService.extractMoneyToAccount(2);
        logger.debug("提款操作结果："+result2);
    }

    @Test
    public void testTestDayByDay(){
        //模拟随着天数的增加，用户投资的项目按要求产生本金、收益方面的变化
        //传入参数：yyyy-MM-dd格式的Date类实例
        //返回参数：操作结果状态说明
        //注意：每次测试前都要初始化数据库中数据，该测试会一次性计算从项目开始时间到输入的测试时间之间的本息情况
        //注意：输入的时间仅在符合项目投资起止时间内有效，超出某个投资项目结束时间的，该项目不会被处理成已经完成，只是不处理
        //测试时间：2018-01-06
        String str = "2018-01-06";
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        String result = null;
        try{
            date = dateFormat.parse(str);
            result = userInvestmentService.testDayByDay(date);
        }catch(ParseException e){
            e.printStackTrace();
        }
        logger.debug(result);
    }

    //testDayByDay计算结果对比
    @Test
    public void testCalculateInterest(){
        //测试 每日还本付息 投资项目计算结果
        //本金:10000、年利率:0.037、投资期限:62、还款方式:rdm、计息方式:daily、复利情况:t
        InterestResultDTO interestResultDTO1 = investmentService.calculateInterest(10000,0.037,62,"rdm","daily","t");
        logger.debug("每日还本付息计算结果："+interestResultDTO1);

        //测试 一次性还本付息 投资项目计算结果
        //本金:15000、年利率:0.068、投资期限:60、还款方式:rdm、计息方式:monthly、复利情况:f
        InterestResultDTO interestResultDTO2 = investmentService.calculateInterest(15000,0.068,60,"rdm","monthly","f");
        logger.debug("一次性还本付息计算结果："+interestResultDTO2);

        //测试 按月付息到期付本 项目
        //本金:10000、年利率:0.065、投资期限:60、还款方式:mpmd、计息方式:monthly、复利情况:f
        InterestResultDTO interestResultDTO3 = investmentService.calculateInterest(10000,0.065,60,"rdm","monthly","f");
        logger.debug("按月付息到期付本计算结果："+interestResultDTO3);
    }

    //testDayByDay计算结果对比
    @Test
    public void testCalculateAcm(){
        //测试 等额本金（acm）详情
        //本金:10000、年利率:0.12、投资期限:360
        RegularResultDTO regularResultDTO = investmentService.calculateAcm(10000,0.12,360);
        //期望结果
        //每月回款本金
        logger.debug("每月回款本金："+regularResultDTO.getReturnPrincipal());
        //每月回款利息
        List<Double> interest = regularResultDTO.getReturnInterest();
        double totalInterest=0;
        logger.debug("每月回款利息："+regularResultDTO.getReturnInterest());
        for(int i=0;i<2;++i){
            totalInterest+=interest.get(i);
        }
        logger.debug("总利息："+totalInterest);
    }

    //testDayByDay计算结果对比
    @Test
    public void testCalculateAcpim(){
        //测试 等额本息（acpim）详情
        //本金:10000、年利率:0.107、投资期限:180
        RegularResultDTO regularResultDTO = investmentService.calculateAcpim(10000,0.107,180);
        //期望结果
        //每月回款本金
        logger.debug("每月回款本金："+regularResultDTO.getReturnPrincipal());
        //每月回款利息
        logger.debug("每月回款利息："+regularResultDTO.getReturnInterest());
    }
}
