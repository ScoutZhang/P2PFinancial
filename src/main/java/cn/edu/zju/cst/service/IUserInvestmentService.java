package cn.edu.zju.cst.service;

import cn.edu.zju.cst.dto.UserAccountDTO;
import cn.edu.zju.cst.dto.UserInvestmentDTO;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

/**
 * Created by DEAN on 2017/11/1.
 * 与用户投资相关的服务
 */
public interface IUserInvestmentService {
    //新增用户投资信息
    //传入参数：用户ID、投资项目ID、投资本金
    //返回参数：投资状态(两种返回参数：投资成功，将从次日起开始计息、投资失败)
    //注：投资失败时，额外返回业务逻辑层面的失败原因
    String setUserInvestment(int userId, int investmentId, double principal);

    //获取用户的所有投资
    //传入参数：用户ID
    //返回参数：UserInvestment类实例列表
    List<UserInvestmentDTO> getUserInvestments(int userId);

    //从指定投资项目中提取出来本金、利息到用户账户
    //传入参数：用户投资项目ID
    //返回参数：操作结果状态说明
    String extractMoneyToAccount(int userInvestmentId);

    //获取用户账户信息
    //传入参数：用户ID
    //返回参数：UserAccountDTO类实例
    UserAccountDTO getUserAccount(int userId);

    //用于测试
    //模拟随着天数的增加，用户投资的项目按要求产生本金、收益方面的变化
    //传入参数：yyyy-MM-dd格式的Date类实例
    //返回参数：操作结果状态说明
    String testDayByDay(Date date) throws ParseException;
}
