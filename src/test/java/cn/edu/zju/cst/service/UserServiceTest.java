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
        User user = userService.getUserById(1);
        //控制台输出结果
        logger.debug("查找结果："+user);
    }
}
