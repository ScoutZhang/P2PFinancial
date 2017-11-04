package cn.edu.zju.cst.domain;

/**
 * Created by DEAN on 2017/11/1.
 */
public class UserAccount {
    private int id;
    private int userId;
    private double accountBalance;
    private String bankCard;
    private double accruedInterest;

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

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public String getBankCard() {
        return bankCard;
    }

    public void setBankCard(String bankCard) {
        this.bankCard = bankCard;
    }

    public double getAccruedInterest() {
        return accruedInterest;
    }

    public void setAccruedInterest(double accruedInterest) {
        this.accruedInterest = accruedInterest;
    }

    @Override
    public String toString() {
        return "UserAccount{" +
                "id=" + id +
                ", userId=" + userId +
                ", accountBalance=" + accountBalance +
                ", bankCard='" + bankCard + '\'' +
                ", accruedInterest=" + accruedInterest +
                '}';
    }
}
