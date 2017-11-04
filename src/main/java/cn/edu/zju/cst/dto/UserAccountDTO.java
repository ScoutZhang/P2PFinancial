package cn.edu.zju.cst.dto;

/**
 * Created by DEAN on 2017/11/1.
 * 用户账户信息，包括：账户余额、绑定的银行卡信息、目前在投金额、目前可提至账户金额、累计获得收益
 */
public class UserAccountDTO {
    private double accountBalance;
    private String bankCard;
    private double lockMoney;
    private double money;
    private double accruedInterest;

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

    public double getLockMoney() {
        return lockMoney;
    }

    public void setLockMoney(double lockMoney) {
        this.lockMoney = lockMoney;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public double getAccruedInterest() {
        return accruedInterest;
    }

    public void setAccruedInterest(double accruedInterest) {
        this.accruedInterest = accruedInterest;
    }

    @Override
    public String toString() {
        return "UserAccountDTO{" +
                "accountBalance=" + accountBalance +
                ", bankCard='" + bankCard + '\'' +
                ", lockMoney=" + lockMoney +
                ", money=" + money +
                ", accruedInterest=" + accruedInterest +
                '}';
    }
}
