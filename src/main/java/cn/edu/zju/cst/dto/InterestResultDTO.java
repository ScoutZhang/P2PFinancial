package cn.edu.zju.cst.dto;

/**
 * Created by DEAN on 2017/10/31.
 * 保存通过计算得到的基本收益情况，包括：整体收益、平均每日收益、银行活期收益对比、余额宝收益对比
 */
public class InterestResultDTO {
    private double totalInterest;
    private double averageInterest;
    private double depositBankInterest;
    private double yuebaoInterest;

    public double getTotalInterest() {
        return totalInterest;
    }

    public void setTotalInterest(double totalInterest) {
        this.totalInterest = totalInterest;
    }

    public double getAverageInterest() {
        return averageInterest;
    }

    public void setAverageInterest(double averageInterest) {
        this.averageInterest = averageInterest;
    }

    public double getDepositBankInterest() {
        return depositBankInterest;
    }

    public void setDepositBankInterest(double depositBankInterest) {
        this.depositBankInterest = depositBankInterest;
    }

    public double getYuebaoInterest() {
        return yuebaoInterest;
    }

    public void setYuebaoInterest(double yuebaoInterest) {
        this.yuebaoInterest = yuebaoInterest;
    }

    @Override
    public String toString() {
        return "InterestResultDTO{" +
                "totalInterest=" + totalInterest +
                ", averageInterest=" + averageInterest +
                ", depositBankInterest=" + depositBankInterest +
                ", yuebaoInterest=" + yuebaoInterest +
                '}';
    }
}
