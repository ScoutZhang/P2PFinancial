package cn.edu.zju.cst.dao;

import cn.edu.zju.cst.domain.UserInvestment;

import java.util.List;

/**
 * Created by DEAN on 2017/11/1.
 */
public interface IUserInvestmentDao {
    //通过id查询单条记录
    UserInvestment selectUserInvestmentById(int id);
    //获得指定用户的所有投资项目记录
    List<UserInvestment> selectUserInvestmentsByUserId(int userId);
    //插入一条记录
    int insertUserInvestment(UserInvestment userInvestment);
    //通过id删除一条记录
    int deleteUserInvestmentById(int id);
    //通过id更新本金、利息相关信息
    int updatePrincipalAndInterestById(int id, double lockPrincipal, double lockInterest, double principal, double interest);
    //获得所有记录
    List<UserInvestment> selectAllUserInvestments();
}
