package cn.edu.zju.cst.dto;

import java.util.List;

/**
 * Created by DEAN on 2017/10/31.
 * 等额本息、等额本金、按月付息到期付本三种投资的计算详情，包括预计每月回款时间、每月回款本金、每月回款利息、每月回款总额
 */
public class RegularResultDTO {
    private List<String> returnMoneyTime;
    private List<Double> returnPrincipal;
    private List<Double> returnInterest;
    private List<Double> returnMoney;

    public List<String> getReturnMoneyTime() {
        return returnMoneyTime;
    }

    public void setReturnMoneyTime(List<String> returnMoneyTime) {
        this.returnMoneyTime = returnMoneyTime;
    }

    public List<Double> getReturnPrincipal() {
        return returnPrincipal;
    }

    public void setReturnPrincipal(List<Double> returnPrincipal) {
        this.returnPrincipal = returnPrincipal;
    }

    public List<Double> getReturnInterest() {
        return returnInterest;
    }

    public void setReturnInterest(List<Double> returnInterest) {
        this.returnInterest = returnInterest;
    }

    public List<Double> getReturnMoney() {
        return returnMoney;
    }

    public void setReturnMoney(List<Double> returnMoney) {
        this.returnMoney = returnMoney;
    }

    @Override
    public String toString() {
        return "AcpimResultDTO{" +
                "returnMoneyTime=" + returnMoneyTime +
                ", returnPrincipal=" + returnPrincipal +
                ", returnInterest=" + returnInterest +
                ", returnMoney=" + returnMoney +
                '}';
    }
}
