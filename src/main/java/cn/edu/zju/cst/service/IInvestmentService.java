package cn.edu.zju.cst.service;

import cn.edu.zju.cst.domain.Investment;
import cn.edu.zju.cst.dto.InvestmentDetailDTO;
import cn.edu.zju.cst.dto.InvestmentOverviewDTO;
import cn.edu.zju.cst.dto.RegularResultDTO;
import cn.edu.zju.cst.dto.InterestResultDTO;

/**
 * Created by DEAN on 2017/10/31.
 */
public interface IInvestmentService {
    //利息计算器
    //传入参数：本金、年利率、投资期限、还款方式（acpim、acm、mpmd、rdm四种）、计息方式（也称为结息日）、复利情况（t、f两种）
    //返回参数：InterestResultDTO类实例
    InterestResultDTO calculateInterest(double principal, double annualInterestRate, int investmentHorizon, String investmentRepayment, String interestExpiryDate, String investmentCompound);

    //等额本息（acpim）详细计算
    //传入参数：本金、年利率、投资期限
    //返回参数：RegularResultDTO类实例
    RegularResultDTO calculateAcpim(double principal, double annualInterestRate, int investmentHorizon);

    //等额本金（acm）详细计算
    //传入参数：本金、年利率、投资期限
    //返回参数：RegularResultDTO类实例
    RegularResultDTO calculateAcm(double principal, double annualInterestRate, int investmentHorizon);

    //按月付息到期付本（mpmd）详细计算
    //传入参数：本金、年利率、投资期限
    //返回参数：RegularResultDTO类实例
    RegularResultDTO calculateMpmd(double principal, double annualInterestRate, int investmentHorizon);

    //返回同类投资项目的列表
    //传入参数：还款方式（acpim、acm、mpmd、rdm四种）
    //返回参数：InvestmentOverviewDTO类实例
    InvestmentOverviewDTO getInvestmentOverview(String investmentRepayment);

    //返回具体投资项目的详情
    //传入参数：还款方式（acpim、acm、mpmd、rdm四种）、投资期限
    InvestmentDetailDTO getInvestmentDetail(String investmentRepayment, int investmentHorizon);

    Investment getInvestmentById(int id);
}
