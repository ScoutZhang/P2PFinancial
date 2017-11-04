package cn.edu.zju.cst.dao;

import cn.edu.zju.cst.domain.Investment;

import java.util.List;

/**
 * Created by DEAN on 2017/11/1.
 */
public interface IInvestmentDao {
    //通过id查询单条记录
    Investment selectInvestmentById(int id);

    //通过还款方式、复利情况来得到满足要求的投资项目记录
    List<Investment> selectInvestmentsByRepayAndCompound(String investmentRepayment, String investmentCompound);

    //通过还款方式、投资期限来得到满足要求的投资项目记录
    Investment selectInvestmentByRepayAndHorizon(String investmentRepayment, int investmentHorizon);

    //通过id更新累计参与该项目的人次
    int updatePeopleById(int id, int numberOfPeopleAdded);
}
