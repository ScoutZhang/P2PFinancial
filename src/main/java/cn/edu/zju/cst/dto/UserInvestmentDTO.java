package cn.edu.zju.cst.dto;

/**
 * Created by DEAN on 2017/11/9.
 * 用户投资信息，包括：项目ID、项目名称、年化率（百分比形式）、投资期限（月）、开始日期、结束日期、在投本金、在投利息、可提取本金、可提取利息
 */
public class UserInvestmentDTO {
    private int userInvestmentId;
    private String investmentName;
    private String annualInterestRate;
    private int investmentHorizon;
    private String startTime;
    private String endTime;
    private double lockPrincipal;
    private double lockInterest;
    private double principal;
    private double interest;

    public int getUserInvestmentId() {
        return userInvestmentId;
    }

    public void setUserInvestmentId(int userInvestmentId) {
        this.userInvestmentId = userInvestmentId;
    }

    public String getInvestmentName() {
        return investmentName;
    }

    public void setInvestmentName(String investmentName) {
        this.investmentName = investmentName;
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

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public double getLockPrincipal() {
        return lockPrincipal;
    }

    public void setLockPrincipal(double lockPrincipal) {
        this.lockPrincipal = lockPrincipal;
    }

    public double getLockInterest() {
        return lockInterest;
    }

    public void setLockInterest(double lockInterest) {
        this.lockInterest = lockInterest;
    }

    public double getPrincipal() {
        return principal;
    }

    public void setPrincipal(double principal) {
        this.principal = principal;
    }

    public double getInterest() {
        return interest;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }

    @Override
    public String toString() {
        return "UserInvestmentDTO{" +
                "userInvestmentId=" + userInvestmentId +
                ", investmentName='" + investmentName + '\'' +
                ", annualInterestRate='" + annualInterestRate + '\'' +
                ", investmentHorizon=" + investmentHorizon +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", lockPrincipal=" + lockPrincipal +
                ", lockInterest=" + lockInterest +
                ", principal=" + principal +
                ", interest=" + interest +
                '}';
    }
}
