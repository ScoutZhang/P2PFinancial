package cn.edu.zju.cst.dto;

/**
 * Created by DEAN on 2017/11/1.
 * 投资项目详情，包括：项目ID、项目名称、项目介绍、年化利率（百分比形式）、投资期限（月）、最低起购金额、最大购买额度、计息方式（值为按月计息、按日计息等等）、复利情况（值为计算复利、不计算复利两种）、累计参与该项目的人次
 */
public class InvestmentDetailDTO {
    private int investmentId;
    private String investmentName;
    private String investmentIntroduction;
    private String annualInterestRate;
    private int investmentHorizon;
    private int minimumPurchase;
    private int maximumPurchase;
    private String interestExpiryDate;
    private String investmentCompound;
    private int numberOfPeopleAdded;

    public int getInvestmentId() {
        return investmentId;
    }

    public void setInvestmentId(int investmentId) {
        this.investmentId = investmentId;
    }

    public String getInvestmentName() {
        return investmentName;
    }

    public void setInvestmentName(String investmentName) {
        this.investmentName = investmentName;
    }

    public String getInvestmentIntroduction() {
        return investmentIntroduction;
    }

    public void setInvestmentIntroduction(String investmentIntroduction) {
        this.investmentIntroduction = investmentIntroduction;
    }

    public String getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setAnnualInterestRate(String annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public int getInvestmentHorizon() {
        return investmentHorizon;
    }

    public void setInvestmentHorizon(int investmentHorizon) {
        this.investmentHorizon = investmentHorizon;
    }

    public int getMinimumPurchase() {
        return minimumPurchase;
    }

    public void setMinimumPurchase(int minimumPurchase) {
        this.minimumPurchase = minimumPurchase;
    }

    public int getMaximumPurchase() {
        return maximumPurchase;
    }

    public void setMaximumPurchase(int maximumPurchase) {
        this.maximumPurchase = maximumPurchase;
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

    public int getNumberOfPeopleAdded() {
        return numberOfPeopleAdded;
    }

    public void setNumberOfPeopleAdded(int numberOfPeopleAdded) {
        this.numberOfPeopleAdded = numberOfPeopleAdded;
    }

    @Override
    public String toString() {
        return "InvestmentDetailDTO{" +
                "investmentId=" + investmentId +
                ", investmentName='" + investmentName + '\'' +
                ", investmentIntroduction='" + investmentIntroduction + '\'' +
                ", annualInterestRate='" + annualInterestRate + '\'' +
                ", investmentHorizon=" + investmentHorizon +
                ", minimumPurchase=" + minimumPurchase +
                ", maximumPurchase=" + maximumPurchase +
                ", interestExpiryDate='" + interestExpiryDate + '\'' +
                ", investmentCompound='" + investmentCompound + '\'' +
                ", numberOfPeopleAdded=" + numberOfPeopleAdded +
                '}';
    }
}
