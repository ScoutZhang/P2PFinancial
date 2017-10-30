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
}
