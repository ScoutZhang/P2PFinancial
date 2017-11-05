package cn.edu.zju.cst.service;

import cn.edu.zju.cst.domain.User;

/**
 * Created by DEAN on 2017/10/26.
 * 与用户基本信息相关的服务
 */
public interface IUserService {
    //通过id查询单条用户信息
    //传入参数：用户id
    //返回参数：User类实例
    User getUserById(int id);

    //通过账户和密码查找单条用户信息
    //传入参数：用户账户、用户密码
    //返回参数：User类实例
    User getUserByAccountAndPassword(String userAccount, String userPassword);

    //通过账户查找单条用户信息
    //传入参数：用户账户
    //返回参数：User类实例
    User getUserByAccount(String userAccount);

    //保存一条新增的用户信息
    //传入参数：User类实例
    //返回参数：操作结果状态
    int setUser(User user);
}
