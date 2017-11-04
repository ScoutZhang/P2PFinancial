package cn.edu.zju.cst.dto;

import java.util.List;

/**
 * Created by DEAN on 2017/11/1.
 * 等额本息、等额本金、按月付息到期付本、一次性还本付息这四种项目，每种投资项目的列表概要，包括年化利率(百分比形式)、投资期限（月）
 */
public class InvestmentOverviewDTO {
    private List<String> annualInterestRate;
    private List<Integer> investmentHorizon;

    public List<String> getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setAnnualInterestRate(List<String> annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public List<Integer> getInvestmentHorizon() {
        return investmentHorizon;
    }

    public void setInvestmentHorizon(List<Integer> investmentHorizon) {
        this.investmentHorizon = investmentHorizon;
    }

    @Override
    public String toString() {
        return "InvestmentOverviewDTO{" +
                "annualInterestRate=" + annualInterestRate +
                ", investmentHorizon=" + investmentHorizon +
                '}';
    }
}
