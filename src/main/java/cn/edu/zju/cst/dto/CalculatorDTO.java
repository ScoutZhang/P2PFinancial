package cn.edu.zju.cst.dto;

/**
 * Created by DEAN on 2017/11/9.
 * 计算器功能传入参数对象：本金、年利率、投资期限(天)、还款方式、计息方式、复利计算情况
 */
public class CalculatorDTO {
    double principal;
    double annualInterestRate;
    int investmentHorizon;
    String investmentRepayment;
    String interestExpiryDate;
    String investmentCompound;

    public double getPrincipal() {
        return principal;
    }

    public void setPrincipal(double principal) {
        this.principal = principal;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public int getInvestmentHorizon() {
        return investmentHorizon;
    }

    public void setInvestmentHorizon(int investmentHorizon) {
        this.investmentHorizon = investmentHorizon;
    }

    public String getInvestmentRepayment() {
        return investmentRepayment;
    }

    public void setInvestmentRepayment(String investmentRepayment) {
        this.investmentRepayment = investmentRepayment;
    }

    public String getInterestExpiryDate() {
        return interestExpiryDate;
    }

    public void setInterestExpiryDate(String interestExpiryDate) {
        this.interestExpiryDate = interestExpiryDate;
    }

    public String getInvestmentCompound() {
        return investmentCompound;
    }

    public void setInvestmentCompound(String investmentCompound) {
        this.investmentCompound = investmentCompound;
    }

    @Override
    public String toString() {
        return "CalculatorDTO{" +
                "principal=" + principal +
                ", annualInterestRate=" + annualInterestRate +
                ", investmentHorizon=" + investmentHorizon +
                ", investmentRepayment='" + investmentRepayment + '\'' +
                ", interestExpiryDate='" + interestExpiryDate + '\'' +
                ", investmentCompound='" + investmentCompound + '\'' +
                '}';
    }
}
