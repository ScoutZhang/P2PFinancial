<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: chacha
  Date: 2017/11/6 0006
  Time: 19:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <link rel="apple-touch-icon" sizes="76x76" href="/static/assets/img/apple-icon.png">
    <link rel="icon" type="image/png" href="/static/assets/img/favicon.png">

    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <title>投资详情</title>

    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />

    <link href="/static/bootstrap3/css/bootstrap.css" rel="stylesheet" />
    <link href="/static/assets/css/gsdk.css" rel="stylesheet" />
    <link href="/static/assets/css/demo.css" rel="stylesheet" />

    <link href="/static/bootstrap3/css/font-awesome.css" rel="stylesheet">
    <link href='http://fonts.googleapis.com/css?family=Grand+Hotel' rel='stylesheet' type='text/css'>

    <script type="text/javascript">
        function invest() {
            var msa = "您确认进行投资吗？\n\n请确认！";
            if (confirm(msa) == true) {
                return true;
            } else {
                return false;
            }
        }
    </script>
</head>
<body>
<div id="navbar">
    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a href="/index">
                    <img src="/static/img/logo.png" class="img-rounded" style="margin-left:40px; margin-top:10px; height:90px; width:80px;">
                </a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav" style="margin-top: 1%">
                    <li class="active"><a href="/index">首页</a></li>
                    <li><a href="/investmentOverview?investNum=1">一次性返还本息</a></li>
                    <li><a href="/invest">每日返还本息</a></li>
                    <li><a href="/investmentOverview?investNum=3">等额本金</a></li>
                    <li><a href="/investmentOverview?investNum=4">等额本息</a></li>
                    <li><a href="/investmentOverview?investNum=5">按月付息</a></li>
                </ul>

                <%if(session.getAttribute("user")==null){%>
                <div class="text-right" style="margin-top: 1%;margin-right: 5%;">
                    <a href="/login" class="btn btn-round btn-default">登录/注册</a>
                </div>
                <%}else{%>
                <div class="text-right" style="margin-top: 1%;margin-right: 5%;">
                    <a href="/userInfor" class="btn btn-round btn-default">个人信息</a>
                </div>
                <%}%>
            </div><!-- /.navbar-collapse -->
        </div><!-- /.container-fluid -->
    </nav>
</div>
<div class="container">
    <div class="row">
        <div class="col-md-7">
            <div class="row">
                <div class="col-md-6">
                    <div class="text-center">
                        <p class="h1" style="color: #ec971f;">${investmentDetail.annualInterestRate}</p><h5><small>预期年化利率</small></h5>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="text-center">
                        <p class="h1" style="color: #ec971f;">${investmentDetail.investmentHorizon}个月</p><h5><small>投资期限</small></h5>
                    </div>
                </div>
            </div>
            <br>
            <div class="tab-pane active" id="inverst" style="margin-left: 7%;margin-right: 5%;">
                <form action="/setNewInvestment" method="post">
                    <div class="form-group" style="width: 80%;margin-left: 10%;">
                        <input name="principal" type="text" value="" placeholder="请输入您的投资金额" class="form-control">
                    </div>
                    <div class="form-group" style="width: 80%;margin-left: 10%;">
                        <input name="investmentId" type="hidden" value=${investmentDetail.investmentId} class="form-control">
                    </div>
                    <%if(session.getAttribute("user")==null){%>
                    <div class="text-center" style="width: 50%;margin-left: 25%;">
                        <button onclick="window.location.href='/login';" type="button" class="btn btn-block btn-lg btn-fill btn-round btn-warning">一键投资</button>
                    </div>
                    <%}else{%>
                    <div class="text-center" style="width: 50%;margin-left: 25%;">
                        <button onclick="return invest()" type="submit" class="btn btn-block btn-lg btn-fill btn-round btn-warning">一键投资</button>
                    </div>
                    <%}%>
                    <br>
                    <div class="text-center">
                        <h5><small>加入下限：${investmentDetail.minimumPurchase}&emsp;&emsp;加入上限：${investmentDetail.maximumPurchase}</small></h5>
                    </div>
                </form>
            </div>
        </div>
        <div class="col-md-1">
            <div class="text-center" style="float:left;width: 1px;height: 350px; background: #dbdbdb;"></div>
        </div>
        <div class="col-md-4">
            <div class="text-center" style="margin-top: 20%;">
                <h5><small>已累计招募</small></h5><p style="color: #ec971f;font-size: 500%">${investmentDetail.numberOfPeopleAdded}<a class="h5">&emsp;人</a></p>
            </div>
        </div>
    </div>
</div>
<hr>
<div class="container">
    <div class="row">
        <div class="col-md-8">
            <div class="tim-title text-center" style="margin-top: 8%;margin-right: 10%;">
                <h3>项目预期收益计算</h3>
            </div>
        </div>
        <div class="col-md-4">
            <div class="text-center">
                <h5><small>本金一万元总收益：</small></h5><p style="color: #ec971f;font-size: 500%;">${interestResult.totalInterest}</p>
            </div>
        </div>
    </div>
    <hr>
    <div class="row">
        <div class="col-md-4">
            <div class="text-center">
                <h5><small>平均每日收益</small></h5><p id="averageInterest" class="h2" style="color: #ec971f;">${interestResult.averageInterest}<a class="h5">&emsp;元</a></p>
            </div>
        </div>
        <div class="col-md-4">
            <div class="text-center">
                <h5><small>银行活期收益</small></h5><p id="depositBankInterest" class="h2" style="color: #ec971f;">${interestResult.depositBankInterest}<a class="h5">&emsp;元</a></p>
            </div>
        </div>
        <div class="col-md-4">
            <div class="text-center">
                <h5><small>余额宝收益</small></h5><p id="yuebaoInterest" class="h2" style="color: #ec971f;">${interestResult.yuebaoInterest}<a class="h5">&emsp;元</a></p>
            </div>
        </div>
    </div>
    <div class="space-30"></div>
    <div class="content">
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-12">
                    <div class="card" style="margin-left: 0%;">
                        <div class="content table-responsive table-full-width">
                            <table class="table table-striped">
                                <thead>
                                <tr><th>预计回款时间</th>
                                    <th>回款本金</th>
                                    <th>回款利息</th>
                                    <th>回款总额</th>
                                </tr></thead>
                                <tbody>
                                <c:choose>
                                    <c:when test="${!empty regularResult}">
                                        <c:forEach var="regularResultDTO" items="${regularResult}">
                                            <tr>
                                                <td>${regularResultDTO.returnMoneyTime}</td>
                                                <td>${regularResultDTO.returnPrincipal}</td>
                                                <td>${regularResultDTO.returnInterest}</td>
                                                <td>${regularResultDTO.returnMoney}</td>
                                            </tr>
                                        </c:forEach>
                                    </c:when>
                                </c:choose>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<hr>
<div class="main">
    <div class="container tim-container">
        <div>
            <ul class="nav nav-tabs">
                <li class="active"><a href="#detail" data-toggle="tab">计划介绍</a></li>
                <li><a href="#qa" data-toggle="tab">常见问题</a></li>
            </ul>
            <br>
            <div class="tab-content">
                <div class="tab-pane active" id="detail">
                    <div class="content table-responsive table-full-width">
                        <table class="table table-striped">
                            <tbody>
                            <tr>
                                <td>项目名称</td>
                                <td>${investmentDetail.investmentName}</td>
                            </tr>
                            <tr>
                                <td>项目介绍</td>
                                <td>${investmentDetail.investmentIntroduction}</td>
                            </tr>
                            <tr>
                                <td>年化利率（百分比形式）</td>
                                <td>${investmentDetail.annualInterestRate}</td>
                            </tr>
                            <tr>
                                <td>投资期限（月）</td>
                                <td>${investmentDetail.investmentHorizon}</td>
                            </tr>
                            <tr>
                                <td>最低起购金额</td>
                                <td>${investmentDetail.minimumPurchase}</td>
                            </tr>
                            <tr>
                                <td>最大购买额度</td>
                                <td>${investmentDetail.maximumPurchase}</td>
                            </tr>
                            <tr>
                                <td>计息方式</td>
                                <td>${investmentDetail.interestExpiryDate}</td>
                            </tr>
                            <tr>
                                <td>复利情况</td>
                                <td>${investmentDetail.investmentCompound}</td>
                            </tr>
                            <tr>
                                <td>累计参与该项目的人次</td>
                                <td>${investmentDetail.numberOfPeopleAdded}</td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
                <div class="tab-pane" id="qa">
                    <div class="content table-responsive table-full-width">
                        <table class="table table-striped">
                            <tbody>
                            <tr>
                                <td>Q1：U计划安全吗？</td>
                            </tr>
                            <tr>
                                <td>人人贷以严谨负责的态度对每笔借款进行严格筛选，同时具备专业的贷后管理团队和高效的催收流程，最大限度的保护投资者的权益。</td>
                            </tr>
                            <tr>
                                <td>Q2：U计划发布时间？</td>
                            </tr>
                            <tr>
                                <td>U计划主要有5种， U计划A锁定期3个月，U计划B锁定期6个月，U计划C类别有3种不同长度锁定期，不同锁定期长度的U计划预期年化利率不同，具体以当期U计划公布的预期年化利率为准。</td>
                            </tr>
                            <tr>
                                <td>Q3：U计划预期利率有多少？</td>
                            </tr>
                            <tr>
                                <td>U计划主要有5种， U计划A锁定期3个月，U计划B锁定期6个月，U计划C类别有3种不同长度锁定期，不同锁定期长度的U计划预期年化利率不同，具体以当期U计划公布的预期年化利率为准。</td>
                            </tr>
                            <tr>
                                <td>Q4：U计划收益处理方式是什么？</td>
                            </tr>
                            <tr>
                                <td>U计划提供以下两种出借所获利息收益处理方式：再出借，或由用户自行支配。用户在加入U计划时可进行选择，暂不支持中途修改。</td>
                            </tr>
                            <tr>
                                <td>Q5：锁定期是什么？</td>
                            </tr>
                            <tr>
                                <td>U计划有锁定期限制，锁定期内，您可操作提前退出，但会产生相应费用，提前退出费用=加入计划金额*2.0%。锁定期满后自动退出U计划，系统通过转让届时U计划所投债权标的实现您投资资金的回收。</td>
                            </tr>
                            <tr>
                                <td>Q6：U计划到期后，我如何退出并实现收益？</td>
                            </tr>
                            <tr>
                                <td>U计划到期当日，系统将自动通过债权转让为您收回出借本金，转让完成时间一般为1~3个工作日。</td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
            <div class="space-30"></div>
    </div>
</div>

<script src="/static/jquery/jquery-1.10.2.js" type="text/javascript"></script>
<script src="/static/assets/js/jquery-ui-1.10.4.custom.min.js" type="text/javascript"></script>

<script src="/static/bootstrap3/js/bootstrap.js" type="text/javascript"></script>
<script src="/static/assets/js/gsdk-checkbox.js"></script>
<script src="/static/assets/js/gsdk-radio.js"></script>
<script src="/static/assets/js/gsdk-bootstrapswitch.js"></script>
<script src="/static/assets/js/get-shit-done.js"></script>
<script src="/static/assets/js/custom.js"></script>

<script type="text/javascript">

    $('.btn-tooltip').tooltip();
    $('.label-tooltip').tooltip();
    $('.pick-class-label').click(function(){
        var new_class = $(this).attr('new-class');
        var old_class = $('#display-buttons').attr('data-class');
        var display_div = $('#display-buttons');
        if(display_div.length) {
            var display_buttons = display_div.find('.btn');
            display_buttons.removeClass(old_class);
            display_buttons.addClass(new_class);
            display_div.attr('data-class', new_class);
        }
    });
    $( "#slider-range" ).slider({
        range: true,
        min: 0,
        max: 500,
        values: [ 75, 300 ],
    });
    $( "#slider-default" ).slider({
        value: 70,
        orientation: "horizontal",
        range: "min",
        animate: true
    });
    $('.carousel').carousel({
        interval: 4000
    });

</script>

</body>
</html>
