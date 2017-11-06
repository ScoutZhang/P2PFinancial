package cn.edu.zju.cst.controller;

import cn.edu.zju.cst.domain.Investment;
import cn.edu.zju.cst.domain.User;
import cn.edu.zju.cst.domain.UserInvestment;
import cn.edu.zju.cst.service.IUserInvestmentService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.*;
/**
 * Created by jolivan on 2017/11/6.
 */
public class UserInvestmentController {
    @Resource
    private IUserInvestmentService iUserInvestmentService;
    private double InvestMoney;

    @RequestMapping("/NewInvestment")
    public String NewInvestment() {
        return "setInvestment";
    }
    /**
     * 新增投资项目
     *
     * @param request,investmentId
     * @return
     */
    @RequestMapping("/setNewInvestment")
    @ResponseBody
    public String putNewInvestment(HttpServletRequest request , int investmentId){
        User user = (User) request.getSession().getAttribute("user");
        return iUserInvestmentService.setUserInvestment(user.getId(),investmentId,InvestMoney);
    }


    @RequestMapping("/InvestedProject")
    public String InvestedProject() {
        return "InvestedProject";
    }
    /**
     * 已经投资项目
     *
     * @param request
     * @return
     */
    @RequestMapping("/getInvestedProject")
    @ResponseBody
    public List<UserInvestment> getIvestedProject(HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        return iUserInvestmentService.getUserInvestments(user.getId());
    }



    @RequestMapping("/userBenefits")
    public String userBenefits() {
        return "userBenefits";
    }
    /**
     * 用户累计收益
     *
     * @param request
     * @return
     */
    @RequestMapping("/getUserBenefits")
    @ResponseBody
    public double getUserBenefits(HttpServletRequest request){
        double Benefits = 0.0;
        //User user = (User) request.getSession().getAttribute("user");
        for(UserInvestment userInvestment : getIvestedProject(request)){
            Benefits += userInvestment.getInterest() * userInvestment.getPrincipal();
        }
        return Benefits;
    }


}
