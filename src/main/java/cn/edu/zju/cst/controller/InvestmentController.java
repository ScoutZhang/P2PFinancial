package cn.edu.zju.cst.controller;

import cn.edu.zju.cst.domain.Investment;
import cn.edu.zju.cst.dto.InterestResultDTO;
import cn.edu.zju.cst.dto.InvestmentDetailDTO;
import cn.edu.zju.cst.dto.InvestmentOverviewDTO;
import cn.edu.zju.cst.service.IInvestmentService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * Created by jolivan on 2017/11/6.
 */
public class InvestmentController {

    @Resource
    private IInvestmentService investmentService;
    private String projectcategory = null;

    ModelAndView mav = new ModelAndView("InvestmentController");

    @RequestMapping("/ProjectList")
    public String ProjectList() {
        return "ProjectList";
    }

    /**
     * 项目列表
     *
     *
     * @return
     */
    public InvestmentOverviewDTO getProjectList(String investmentRepayment){
        InvestmentOverviewDTO investmentOverviewDTO = investmentService.getInvestmentOverview(investmentRepayment);
        mav.addObject("InvestmentList", investmentOverviewDTO);
        return investmentOverviewDTO;
    }


    @RequestMapping("/Project")
    public String Project() {
        return "Project";
    }
    /**
     * 确定项目信息
     *
     * @param
     * @return
     */
    public InvestmentDetailDTO getProjectCategory(String projectcategory,String investmentRepayment,
                                         int investmentHorizon){
        InvestmentDetailDTO investmentDetailDTO = investmentService.getInvestmentDetail(investmentRepayment,investmentHorizon);

        mav.addObject("InvestmentDetial", investmentDetailDTO);
        return investmentDetailDTO;
    }




    @RequestMapping("/InvestmentCalculator")
    public String projectName() {
        return "InvestmentCalculator";
    }
    /**
     * 投资计算器
     *
     * @param
     * @return
     */
    @RequestMapping("/getInvestmentCalculator")
    @ResponseBody
    public InterestResultDTO getInvestmentCalculator(double principal, double annualInterestRate,
                                                  int investmentHorizon, String investmentRepayment,
                                                  String interestExpiryDate, String investmentCompound){
        InterestResultDTO interestResultDTO = investmentService.calculateInterest(principal, annualInterestRate, investmentHorizon, investmentRepayment, interestExpiryDate, investmentCompound);
        mav.addObject("InvestmentCalculator", interestResultDTO);
        return interestResultDTO;
    }

}
