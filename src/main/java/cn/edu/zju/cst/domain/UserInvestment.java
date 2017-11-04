package cn.edu.zju.cst.domain;

/**
 * Created by DEAN on 2017/11/1.
 */
public class UserInvestment {
    private int id;
    private int userId;
    private int investmentId;
    private String startTime;
    private String endTime;
    private double lockPrincipal;
    private double lockInterest;
    private double principal;
    private double interest;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getInvestmentId() {
        return investmentId;
    }

    public void setInvestmentId(int investmentId) {
        this.investmentId = investmentId;
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
        return "UserInvestment{" +
                "id=" + id +
                ", userId=" + userId +
                ", investmentId=" + investmentId +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", lockPrincipal=" + lockPrincipal +
                ", lockInterest=" + lockInterest +
                ", principal=" + principal +
                ", interest=" + interest +
                '}';
    }
}
