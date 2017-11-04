package cn.edu.zju.cst.dao;

import cn.edu.zju.cst.domain.User;

/**
 * Created by DEAN on 2017/10/26.
 */
public interface IUserDao {
    //通过id查询单条记录
    User selectUserById(int id);
    //通过账户和密码查找单条记录
    User selectUserByAccountAndPassword(String userAccount, String userPassword);
    //通过账户查找单条记录
    User selectUserByAccount(String userAccount);
    //插入一条记录
    int insertUser(User user);
}
