package cn.edu.zju.cst.dao;

import cn.edu.zju.cst.domain.UserAccount;

/**
 * Created by DEAN on 2017/11/1.
 */
public interface IUserAccountDao {
    //通过id查询单条记录
    UserAccount selectUserAccountById(int id);
    //通过userId查询单条记录
    UserAccount selectUserAccountByUserId(int userId);
    //更新指定用户的账户余额信息
    int updateAccountBalanceByUserId(int userId, double accountBalance);
    //更新指定用户的累计收益信息
    int updateAccruedInterestByUserId(int userId, double accruedInterest);
    //插入一条记录
    int insertUserAccount(UserAccount userAccount);
}
