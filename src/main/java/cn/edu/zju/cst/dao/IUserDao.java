package cn.edu.zju.cst.dao;

import cn.edu.zju.cst.domain.User;

/**
 * Created by DEAN on 2017/10/26.
 */
public interface IUserDao {
    User selectUserById(int id);
}
