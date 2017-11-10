package cn.edu.zju.cst.dto;

/**
 * Created by DEAN on 2017/11/10.
 * 等额本息、等额本金、按月付息到期付本三种投资的计算详情，包括预计每月回款时间、每月回款本金、每月回款利息、每月回款总额
 */
public class RegularResultDTO2 {
    private String returnMoneyTime;
    private Double returnPrincipal;
    private Double returnInterest;
    private Double returnMoney;

    public String getReturnMoneyTime() {
        return returnMoneyTime;
    }

    public void setReturnMoneyTime(String returnMoneyTime) {
        this.returnMoneyTime = returnMoneyTime;
    }

    public Double getReturnPrincipal() {
        return returnPrincipal;
    }

    public void setReturnPrincipal(Double returnPrincipal) {
        this.returnPrincipal = returnPrincipal;
    }

    public Double getReturnInterest() {
        return returnInterest;
    }

    public void setReturnInterest(Double returnInterest) {
        this.returnInterest = returnInterest;
    }

    public Double getReturnMoney() {
        return returnMoney;
    }

    public void setReturnMoney(Double returnMoney) {
        this.returnMoney = returnMoney;
    }

    @Override
    public String toString() {
        return "RegularResultDTO2{" +
                "returnMoneyTime='" + returnMoneyTime + '\'' +
                ", returnPrincipal=" + returnPrincipal +
                ", returnInterest=" + returnInterest +
                ", returnMoney=" + returnMoney +
                '}';
    }
}
