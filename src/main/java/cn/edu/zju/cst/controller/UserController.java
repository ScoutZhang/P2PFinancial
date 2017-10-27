package cn.edu.zju.cst.controller;

import cn.edu.zju.cst.domain.User;
import cn.edu.zju.cst.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * Created by DEAN on 2017/10/26.
 */
@Controller
public class UserController {
    @Resource
    private IUserService userService;

    @RequestMapping("/detail")
    public ModelAndView getDetail(){
        ModelAndView mav = new ModelAndView("test");
        User user = userService.getUserById(1);
        mav.addObject("user",user);
        return mav;
    }
}
