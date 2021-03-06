package cn.edu.zju.cst.controller;

import cn.edu.zju.cst.domain.Investment;
import cn.edu.zju.cst.dto.*;
import cn.edu.zju.cst.service.IInvestmentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import static cn.edu.zju.cst.util.RegularResultDTOUtil.*;

/**
 * Created by jolivan on 2017/11/6.
 */
@Controller
public class InvestmentController {
    @Resource
    private IInvestmentService investmentService;

    @RequestMapping("/investmentOverview")
    public String getInvestmentOverview1(@RequestParam("investNum")int investNum) {
        if(investNum==1){
            return "invest_1";
        }else if(investNum==3){
            return "invest_3";
        }else if(investNum==4){
            return "invest_4";
        }else{
            return "invest_5";
        }
    }

    //动态返回投资项目下的子项目
    @RequestMapping("/investment/{investmentRepayment}")
    public String getInvestmentOverview2(@PathVariable(value = "investmentRepayment")String investmentRepayment, Model model){
        InvestmentOverviewDTO investmentOverviewDTO = investmentService.getInvestmentOverview(investmentRepayment);
        model.addAttribute("investmentList", investmentOverviewDTO);
        return "investmentOverview";
    }

    //返回子项目详情
    @RequestMapping("/investmentDetail")
    public String getProjectDetail(Investment investment, double principal, Model model){
        String investmentRepayment = investment.getInvestmentRepayment();
        int investmentHorizon = investment.getInvestmentHorizon();
        double annualInterestRate = investment.getAnnualInterestRate();
        String interestExpiryDate = investment.getInterestExpiryDate();
        String investmentCompound = investment.getInvestmentCompound();

        RegularResultDTO regularResultDTO=null;

        InvestmentDetailDTO investmentDetailDTO = investmentService.getInvestmentDetail(investmentRepayment,investmentHorizon);
        model.addAttribute("investmentDetail", investmentDetailDTO);

        if(investmentRepayment.equals("acpim")) {
            regularResultDTO = investmentService.calculateAcpim(principal,annualInterestRate,investmentHorizon);
        }
        else if(investmentRepayment.equals("acm")) {
            regularResultDTO = investmentService.calculateAcm(principal,annualInterestRate,investmentHorizon);
        }
        else if(investmentRepayment.equals("mpmd")) {
            regularResultDTO = investmentService.calculateMpmd(principal,annualInterestRate,investmentHorizon);
        }
        model.addAttribute("regularResult",convertToSecondModel(regularResultDTO));

        InterestResultDTO interestResultDTO = investmentService.calculateInterest(principal, annualInterestRate, investmentHorizon, investmentRepayment, interestExpiryDate, investmentCompound);
        model.addAttribute("interestResult",interestResultDTO);

        return "detail";
    }

    //利息计算器
    @RequestMapping("/getInvestmentCalculator2")
    public String getInvestmentCalculator2(double principal, double annualInterestRate,
                                                  int investmentHorizon, String investmentRepayment,
                                                  String interestExpiryDate, String investmentCompound, int investNum, Model model){
        InterestResultDTO interestResultDTO = investmentService.calculateInterest(principal, annualInterestRate, investmentHorizon, investmentRepayment, interestExpiryDate, investmentCompound);
        model.addAttribute("interestResult", interestResultDTO);
        if(investNum==1){
            return "invest_1";
        }else if(investNum==3){
            return "invest_3";
        }else if(investNum==4){
            return "invest_4";
        }else{
            return "invest_5";
        }
    }

    //利息计算器,JSON格式
    @RequestMapping(value="/getInvestmentCalculator",method = RequestMethod.POST)
    @ResponseBody
    public InterestResultDTO getInvestmentCalculator(@RequestBody CalculatorDTO calculatorDTO){
        System.err.println(calculatorDTO);
        InterestResultDTO interestResultDTO = investmentService.calculateInterest(calculatorDTO.getPrincipal(), calculatorDTO.getAnnualInterestRate(), calculatorDTO.getInvestmentHorizon(),
                calculatorDTO.getInvestmentRepayment(), calculatorDTO.getInterestExpiryDate(), calculatorDTO.getInvestmentCompound());
        System.err.println(interestResultDTO);
        return interestResultDTO;
    }
}
