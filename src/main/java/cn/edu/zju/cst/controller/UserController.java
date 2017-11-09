package cn.edu.zju.cst.controller;

import cn.edu.zju.cst.domain.User;
import cn.edu.zju.cst.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * Created by DEAN on 2017/10/26.
 */
@Controller
public class UserController {
    @Resource
    private IUserService userService;

    //请求注册/登录页面
    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    //处理用户注册
    @RequestMapping(value = "/signUp", method = RequestMethod.POST)
    public String signUp(User user, HttpSession session) {
        User oldUser = userService.getUserByAccount(user.getUserAccount());
        if(oldUser!=null){
            //已存在同名账号，注册失败，重新跳转到注册/登录页面
            return "forward:/login";
        }else{
            //其它注册信息暂时设置为自动填充
            user.setUserIdentity("222426199501025513");
            user.setUserEmail("123@qq.com");
            user.setUserPhone("18200000000");
            user.setUserType("general");

            if(userService.setUser(user) == 0) {
                session.setAttribute("user", user);
            }else{
                //存储新用户信息失败，重新跳转到注册/登录页面
                return "forward:/login";
            }
        }
        return "forward:/index";
    }

    //请求主页
    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    //登录
    @RequestMapping(value = "/signIn", method = RequestMethod.POST)
    public String signIn(User user, HttpSession httpSession) {
        User tempUser = userService.getUserByAccountAndPassword(user.getUserAccount(), user.getUserPassword());
        if (tempUser != null) {
            httpSession.setAttribute("user", tempUser);
            return "forward:/index";
        }

        return "forward:/login";
    }

    //注销
    @RequestMapping("/logout")
    public String logout(HttpSession httpSession) {
        httpSession.removeAttribute("user");
        return "forward:/login";
    }

    @RequestMapping("/test")
    public ModelAndView getDetail(){
        ModelAndView mav = new ModelAndView("test");
        User user = userService.getUserById(1);
        mav.addObject("user",user);
        return mav;
    }
}
