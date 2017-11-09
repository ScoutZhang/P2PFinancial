package cn.edu.zju.cst.controller;

import cn.edu.zju.cst.domain.User;
import cn.edu.zju.cst.dto.UserAccountDTO;
import cn.edu.zju.cst.dto.UserInvestmentDTO;
import cn.edu.zju.cst.service.IUserInvestmentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
/**
 * Created by jolivan on 2017/11/6.
 */
@Controller
public class UserInvestmentController {
    @Resource
    private IUserInvestmentService userInvestmentService;

    @RequestMapping("/NewInvestment")
    public String NewInvestment() {
        return "setInvestment";
    }

    //新增投资
    @RequestMapping("/setNewInvestment")
    public void setNewInvestment(HttpSession session, int investmentId, double principal){
        User user = (User) session.getAttribute("user");
        String result=null;
        if(user!=null){
            result = userInvestmentService.setUserInvestment(user.getId(),investmentId,principal);
        }
        session.setAttribute("investmentResult",result);
    }

    //个人信息页面
    @RequestMapping("/userInfor")
    public String userInfor(HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        List<UserInvestmentDTO> userInvestmentList = userInvestmentService.getUserInvestments(user.getId());
        model.addAttribute("userInvestmentList",userInvestmentList);
        UserAccountDTO userAccountDTO = userInvestmentService.getUserAccount(user.getId());
        model.addAttribute("userAccount",userAccountDTO);

        return "user";
    }

    @RequestMapping("/extractMoney")
    public String extractMoney(int userInvestmentId, HttpSession session, Model model){
        User user = (User) session.getAttribute("user");
        String result = userInvestmentService.extractMoneyToAccount(userInvestmentId);
        session.setAttribute("extractResult",result);
        List<UserInvestmentDTO> userInvestmentList = userInvestmentService.getUserInvestments(user.getId());
        model.addAttribute("userInvestmentList",userInvestmentList);
        UserAccountDTO userAccountDTO = userInvestmentService.getUserAccount(user.getId());
        model.addAttribute("userAccount",userAccountDTO);

        return "user";
    }


    //测试
    @RequestMapping("/testDayByDay")
    public void testDayByDay(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try{
            date = dateFormat.parse("2018-01-06");
            userInvestmentService.testDayByDay(date);
        }catch(ParseException e){
            e.printStackTrace();
        }
    }
}
