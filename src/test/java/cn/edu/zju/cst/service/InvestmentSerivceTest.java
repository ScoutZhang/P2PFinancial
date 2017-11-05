package cn.edu.zju.cst.service;

import cn.edu.zju.cst.baseTest.SpringTestCase;
import cn.edu.zju.cst.dto.InterestResultDTO;
import cn.edu.zju.cst.dto.RegularResultDTO;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by DEAN on 2017/11/5.
 */
public class InvestmentSerivceTest extends SpringTestCase{
    @Autowired
    private IInvestmentService investmentService;

    Logger logger = Logger.getLogger(InvestmentSerivceTest.class);

    @Test
    public void testCalculateInterest(){
        //测试 每日还本付息 投资项目计算结果
        //本金:10000、年利率:0.05、投资期限:30、还款方式:rdm、计息方式:daily、复利情况:t
        InterestResultDTO interestResultDTO1 = investmentService.calculateInterest(10000,0.05,30,"rdm","daily","t");
        //期望结果：整体收益:41.18、平均每日收益:1.37、银行活期收益对比:2.88、余额宝收益对比:31.97
        logger.debug("每日还本付息计算结果："+interestResultDTO1);

        //测试 一次性还本付息 投资项目计算结果
        //本金:10000、年利率:0.12、投资期限:60、还款方式:rdm、计息方式:monthly、复利情况:f
        InterestResultDTO interestResultDTO2 = investmentService.calculateInterest(10000,0.12,60,"rdm","monthly","f");
        //期望结果：整体收益:200、平均每日收益:3.33
        logger.debug("一次性还本付息计算结果："+interestResultDTO2);

        //测试 按月付息到期付本 项目
        //本金:10000、年利率:0.1、投资期限:30、还款方式:mpmd、计息方式:monthly、复利情况:f
        InterestResultDTO interestResultDTO3 = investmentService.calculateInterest(10000,0.1,30,"rdm","monthly","f");
        //期望结果：整体收益:83.33、平均每日收益:2.78
        logger.debug("按月付息到期付本计算结果："+interestResultDTO3);

        //测试 等额本金 项目
        //本金:10000、年利率:0.0665、投资期限:3600、还款方式:acm、计息方式:monthly、复利情况:f
        InterestResultDTO interestResultDTO4 = investmentService.calculateInterest(10000,0.0665,3600,"acm","monthly","f");
        //期望结果：整体收益:3352.71、平均每日收益:0.93
        logger.debug("等额本金计算结果："+interestResultDTO4);

        //测试 等额本息 项目
        //本金:10000、年利率:0.12、投资期限:180、还款方式:acpim、计息方式:monthly、复利情况:f
        InterestResultDTO interestResultDTO5 = investmentService.calculateInterest(10000,0.12,180,"acpim","monthly","f");
        //期望结果：整体收益:352.91、平均每日收益:1.96
        logger.debug("等额本息计算结果："+interestResultDTO5);
    }

    @Test
    public void testCalculateAcpim(){
        //测试 等额本息（acpim）详情
        //本金:10000、年利率:0.12、投资期限:180
        RegularResultDTO regularResultDTO = investmentService.calculateAcpim(10000,0.12,180);
        //预计每月回款时间、每月回款本金、每月回款利息、每月回款总额
        //期望结果
        //每月回款时间：2017-12-06 2018-01-06 2018-02-06 2018-03-06 2018-04-06 2018-05-06
        logger.debug("每月回款时间："+regularResultDTO.getReturnMoneyTime());
        //每月回款本金：1625.48 1641.73 1658.15 1674.73 1691.48 1708.43
        logger.debug("每月回款本金："+regularResultDTO.getReturnPrincipal());
        //每月回款利息：100 83.75 67.33 50.75 34 17.08
        logger.debug("每月回款利息："+regularResultDTO.getReturnInterest());
        //每月回款总额：1725.48 1725.48 1725.48 1725.48 1725.48 1725.51
        logger.debug("每月回款总额："+regularResultDTO.getReturnMoney());
    }

    @Test
    public void testCalculateAcm(){
        //测试 等额本金（acm）详情
        //本金:10000、年利率:0.108、投资期限:360
        RegularResultDTO regularResultDTO = investmentService.calculateAcm(10000,0.108,360);
        //预计每月回款时间、每月回款本金、每月回款利息、每月回款总额
        //期望结果
        //每月回款时间：2017-12-06 2018-01-06 2018-02-06 2018-03-06 2018-04-06 ... 2018-11-06
        logger.debug("每月回款时间："+regularResultDTO.getReturnMoneyTime());
        //每月回款本金：833.33
        logger.debug("每月回款本金："+regularResultDTO.getReturnPrincipal());
        //每月回款利息
        List<Double> interest = regularResultDTO.getReturnInterest();
        double totalInterest=0;
        logger.debug("每月回款利息："+regularResultDTO.getReturnInterest());
        for(int i=0;i<interest.size();++i){
            totalInterest+=interest.get(i);
        }
        logger.debug("总利息："+totalInterest);
        //每月回款总额
        logger.debug("每月回款总额："+regularResultDTO.getReturnMoney());
    }

    @Test
    public void testCalculateMpmd(){
        //测试 按月付息到期付本（mpmd）详情
        //本金:10000、年利率:0.12、投资期限:360
        RegularResultDTO regularResultDTO = investmentService.calculateMpmd(10000,0.12,360);
        //预计每月回款时间、每月回款本金、每月回款利息、每月回款总额
        //期望结果
        //每月回款时间：2017-12-06 2018-01-06 2018-02-06 2018-03-06 2018-04-06 ... 2018-11-06
        logger.debug("每月回款时间："+regularResultDTO.getReturnMoneyTime());
        //每月回款本金：0  最后一个月：10000
        logger.debug("每月回款本金："+regularResultDTO.getReturnPrincipal());
        //每月回款利息：100
        logger.debug("每月回款利息："+regularResultDTO.getReturnInterest());
        //每月回款总额：100 最后一个月：10100
        logger.debug("每月回款总额："+regularResultDTO.getReturnMoney());
    }

    @Test
    public void testGetInvestmentOverview(){
        logger.debug("等额本息："+investmentService.getInvestmentOverview("acpim"));
        logger.debug("等额本金："+investmentService.getInvestmentOverview("acm"));
        logger.debug("按月付息到期付本："+investmentService.getInvestmentOverview("mpmd"));
        logger.debug("一次性还本付息："+investmentService.getInvestmentOverview("rdm"));
    }

    @Test
    public void testGetInvestmentDetail(){
        logger.debug("等额本息6个月："+investmentService.getInvestmentDetail("acpim",180));
        logger.debug("每日还本付息："+investmentService.getInvestmentDetail("rdm",0));
        logger.debug("一次性还本付息3个月："+investmentService.getInvestmentDetail("rdm",90));
    }
}
