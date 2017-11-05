package cn.edu.zju.cst.service;

import cn.edu.zju.cst.baseTest.SpringTestCase;
import cn.edu.zju.cst.domain.User;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by DEAN on 2017/10/26.
 */
public class UserServiceTest extends SpringTestCase{
    @Autowired
    private IUserService userService;

    Logger logger = Logger.getLogger(UserServiceTest.class);

    @Test
    public void testGetUserById(){
        //测试id值为2的用户的信息是否可以完整读取到
        User user = userService.getUserById(2);
        if(user.getUserPhone()==null){
            logger.debug("userPhone为null");
        }else if(user.getUserPhone().equals("")){
            logger.debug("userPhone为空字符串");
        }
        //控制台输出结果
        logger.debug("查找结果："+user);
    }

    @Test
    public void testSetUser(){
        //插入一条新的用户信息，并通过账户和密码信息、账户信息查找对比
        User user = new User();
        user.setUserAccount("zengshuang01");
        user.setUserPassword("123456");
        user.setUserIdentity("22242619950000005X");
        user.setUserType("admin");
        if(userService.getUserByAccount("zengshuang01")==null){
            userService.setUser(user);
        }
        User getUser1 = userService.getUserByAccountAndPassword("zengshuang01","123456");
        User getUser2 = userService.getUserByAccount("zengshuang01");
        if(getUser1!=null){
            if(getUser1.equals(getUser2)){
                logger.debug("Equal:getUser1 and getUser2");
            }else{
                logger.debug("Not Equal:getUser1 and getUser2");
                logger.debug("getUser1:"+getUser1);
                logger.debug("getUser2:"+getUser2);
            }
        }else{
            logger.debug("getUser1 is null");
        }
    }

    @Test
    public void testGetUserByAccount(){
        //查找一个不存在的用户账户，返回应当为null
        User user = userService.getUserByAccount("noExistUser01");
        logger.debug("查找结果："+user);
    }
}
