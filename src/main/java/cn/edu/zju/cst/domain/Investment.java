package cn.edu.zju.cst.domain;

/**
 * Created by DEAN on 2017/11/1.
 */
public class Investment {
    private int id;
    private String investmentName;
    private String investmentIntroduction;
    private double annualInterestRate;
    private int investmentHorizon;
    private int minimumPurchase;
    private int maximumPurchase;
    private String investmentRepayment;
    private String interestExpiryDate;
    private String investmentCompound;
    private int numberOfPeopleAdded;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getNumberOfPeopleAdded() {
        return numberOfPeopleAdded;
    }

    public void setNumberOfPeopleAdded(int numberOfPeopleAdded) {
        this.numberOfPeopleAdded = numberOfPeopleAdded;
    }

    @Override
    public String toString() {
        return "Investment{" +
                "id=" + id +
                ", investmentName='" + investmentName + '\'' +
                ", investmentIntroduction='" + investmentIntroduction + '\'' +
                ", annualInterestRate=" + annualInterestRate +
                ", investmentHorizon=" + investmentHorizon +
                ", minimumPurchase=" + minimumPurchase +
                ", maximumPurchase=" + maximumPurchase +
                ", investmentRepayment='" + investmentRepayment + '\'' +
                ", interestExpiryDate='" + interestExpiryDate + '\'' +
                ", investmentCompound='" + investmentCompound + '\'' +
                ", numberOfPeopleAdded=" + numberOfPeopleAdded +
                '}';
    }
}
