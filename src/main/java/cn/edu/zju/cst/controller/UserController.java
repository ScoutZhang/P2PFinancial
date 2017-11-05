package cn.edu.zju.cst.controller;

import cn.edu.zju.cst.domain.User;
import cn.edu.zju.cst.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by DEAN on 2017/10/26.
 */
@Controller
public class UserController {
    @Resource
    private IUserService userService;



    @RequestMapping("/goToSignUp")
    public String goSignUp() {
        return "signup";
    }
    /**
     * 注册用户
     *
     * @param user,session
     * @return
     */
    @RequestMapping("/signUp")
    @ResponseBody
    public boolean signUp(User user, HttpSession session) {
        if(userService.setUser(user) == 0){
            session.setAttribute("user",user);
            return true;
        }
        return false;
    }




    @RequestMapping("/gologin")
    public String gologin() {
        return "login";
    }
    /**
     * 用户登录
     *
     * @param user,httpsession
     * @return
     */
    @RequestMapping("/login")
    @ResponseBody
    public String login(User user, HttpSession httpSession) {
        User tempuser = userService.getUserByAccountAndPassword(user.getUserAccount(), user.getUserPassword());
        if (tempuser != null) {
            httpSession.setAttribute("user", tempuser);
            if(tempuser.getUserAccount().equals("Administrator")) return "Admin";
            return "Normal";
        }
        return "NULL";
    }



    /**
     * 注销用户
     *
     * @param request
     * @return
     */
    @RequestMapping("logout")
    public String logout(HttpServletRequest request) {
        request.getSession().removeAttribute("user");
        return "redirect:../index.html";
    }



    /**
     * 判断是否用户登陆
     *
     * @param request
     * @return
     */
    @RequestMapping("issignin")
    @ResponseBody
    public String issignin(HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        if (user == null)
            return "NULL";
        else if(user.getUserAccount().equals("Administrator"))
            return "Admin";
        else return "Normal";
    }


    @RequestMapping("/test")
    public ModelAndView getDetail(){
        ModelAndView mav = new ModelAndView("test");
        User user = userService.getUserById(1);
        mav.addObject("user",user);
        return mav;
    }
}
