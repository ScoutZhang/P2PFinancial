package cn.edu.zju.cst.service;

import cn.edu.zju.cst.dao.IUserDao;
import cn.edu.zju.cst.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by DEAN on 2017/10/26.
 */
@Service("userService")
public class UserServiceImpl implements IUserService{
    @Autowired
    private IUserDao userDao;

    @Override
    public User getUserById(int id) {
        return userDao.selectUserById(id);
    }

    @Override
    public User getUserByAccountAndPassword(String userAccount, String userPassword) {
        return userDao.selectUserByAccountAndPassword(userAccount,userPassword);
    }

    @Override
    public User getUserByAccount(String userAccount) {
        return userDao.selectUserByAccount(userAccount);
    }

    @Override
    public int setUser(User user) {
        return userDao.insertUser(user);
    }
}
