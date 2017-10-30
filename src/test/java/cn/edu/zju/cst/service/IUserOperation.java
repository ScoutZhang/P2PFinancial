package cn.edu.zju.cst.service;

import cn.edu.zju.cst.domain.User;

import java.util.List;

/**
 * Created by jolivan on 2017/10/30.
 */
public interface IUserOperation {

    public User selectUserByID(int id);

    public List<User> selectUsersByName(String userName);

    public void addUser(User user);

    public void updateUser(User user);

    public void deleteUser(int id);

}