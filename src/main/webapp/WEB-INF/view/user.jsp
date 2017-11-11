<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: chacha
  Date: 2017/11/7 0007
  Time: 16:38
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
    <title>个人信息</title>

    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />

    <link href="/static/bootstrap3/css/bootstrap.css" rel="stylesheet" />
    <link href="/static/assets/css/gsdk.css" rel="stylesheet" />
    <link href="/static/assets/css/demo.css" rel="stylesheet" />

    <link href="/static/bootstrap3/css/font-awesome.css" rel="stylesheet">
    <link href='http://fonts.googleapis.com/css?family=Grand+Hotel' rel='stylesheet' type='text/css'>

    <script type="text/javascript">
        function init(){
            if('<%=session.getAttribute("extractResult")%>'!="null"){
                var msg = '<%=session.getAttribute("extractResult")%>';
                alert(msg);
                <%session.removeAttribute("extractResult");%>
            }
            if('<%=session.getAttribute("investmentResult")%>'!="null"){
                var msg = '<%=session.getAttribute("investmentResult")%>';
                alert(msg);
                <%session.removeAttribute("investmentResult");%>
            }
        }

        function out() {
            var msa = "您确认退出吗？\n\n请确认！";
            if (confirm(msa) == true) {
                return true;
            } else {
                return false;
            }
        }

        function extractMoney() {
            var msa = "您确认提取本息吗？\n\n请确认！";
            if (confirm(msa) == true) {
                return true;
            } else {
                return false;
            }
        }
    </script>
</head>
<body onload="init()">
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
                    <li><a href="/index">首页</a></li>
                    <li><a href="/investmentOverview?investNum=1">一次性返还本息</a></li>
                    <li><a href="/investmentDetail?investmentRepayment=rdm&investmentHorizon=0&annualInterestRate=0.037&interestExpiryDate=daily&investmentCompound=t&principal=10000">每日返还本息</a></li>
                    <li><a href="/investmentOverview?investNum=3">等额本金</a></li>
                    <li><a href="/investmentOverview?investNum=4">等额本息</a></li>
                    <li><a href="/investmentOverview?investNum=5">按月付息</a></li>
                </ul>

                <div class="text-right" style="margin-top: 1%;margin-right: 5%;">
                    <a href="/logout" onclick="return out();" class="btn btn-round btn-default">退出</a>
                </div>
            </div><!-- /.navbar-collapse -->
        </div><!-- /.container-fluid -->
    </nav>
</div>
<div class="container-fluid">
    <div class="row">
        <div class="col-md-3">
            <div style="margin-left: 20%;margin-top: 13%;">
                <div class="text-center">
                    <img src="/static/img/user.jpg" alt="Circle Image" class="img-circle" style="width: 20%;height: 20%">
                </div>
                <div class="content">
                    <div class="text-center">
                        <h4 class="title">@${user.userAccount}<br></h4>
                    </div>
                    <br>
                    <p class="description text-left" style="margin-left: 5%;font-size: 100%;">
                        身份证号：${user.userIdentity}<br>
                        个人电话：${user.userPhone}<br>
                        个人邮箱：${user.userEmail}
                    </p>
                </div>
            </div>
        </div>
        <div class="col-md-1">
            <div class="text-center" style="float:left;width: 1px;height: 320px; background: #dbdbdb;"></div>
        </div>
        <div class="col-md-3">
            <div class="text-center" style="margin-top: 10%;margin-right: 20%;">
                <h5><small>账户余额</small></h5><p class="h1" style="color: #ec971f;">${userAccount.accountBalance}<a class="h5">&emsp;元</a></p>
            </div>
            <br><br>
            <div class="row" style="margin-right: 10%">
                <div class="col-md-6">
                    <button onclick="window.location.href='/testDayByDay'" type="button" class="btn btn-block btn-lg btn-fill btn-round btn-warning">充值</button>
                </div>
                <div class="col-md-6">
                    <button type="button" class="btn btn-block btn-lg btn-round btn-warning">提现</button>
                </div>
            </div>
        </div>
        <div class="col-md-1">
            <div class="text-center" style="float:left;width: 1px;height: 320px; background: #dbdbdb;"></div>
        </div>
        <div class="col-md-4">
            <div style="margin-right: 20%;margin-top: 3%;">
                <div class="text-center">
                    <h5><small>累计获得收益</small></h5><p class="h1" style="color: #ec971f;">${userAccount.accruedInterest}<a class="h5">&emsp;元</a></p>
                </div>
                <hr>
                <div class="row">
                    <div class="col-md-6">
                        <div class="text-center">
                            <h5><small>目前在投金额</small></h5><p class="h4" style="color: #ec971f;">${userAccount.lockMoney}<a class="h5">&emsp;元</a></p>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="text-center">
                            <h5><small>目前可提金额</small></h5><p class="h4" style="color: #ec971f;">${userAccount.money}<a class="h5">&emsp;元</a></p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<hr>
<div class="container">
    <div class="tim-title" style="margin-left: 18%;">
        <h3>在投项目列表</h3>
    </div>
    <div class="content">
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-12">
                    <div class="card" style="margin-left: 0%;">
                        <div class="content table-responsive table-full-width">
                            <table class="table table-striped">
                                <thead>
                                <tr><th>项目名称</th>
                                    <th>年化率</th>
                                    <th>投资期限（月）</th>
                                    <th>开始日期</th>
                                    <th>结束日期</th>
                                    <th>在投本金</th>
                                    <th>在投利息</th>
                                    <th>可提取本金</th>
                                    <th>可提取利息</th>
                                    <th> </th>
                                </tr></thead>
                                <tbody>
                                <c:choose>
                                    <c:when test="${!empty userInvestmentList}">
                                        <c:forEach var="userInverstment" items="${userInvestmentList}">
                                            <tr>
                                                <td>${userInverstment.investmentName}</td>
                                                <td>${userInverstment.annualInterestRate}</td>
                                                <td>${userInverstment.investmentHorizon}</td>
                                                <td>${userInverstment.startTime}</td>
                                                <td>${userInverstment.endTime}</td>
                                                <td>${userInverstment.lockPrincipal}</td>
                                                <td>${userInverstment.lockInterest}</td>
                                                <td>${userInverstment.principal}</td>
                                                <td>${userInverstment.interest}</td>
                                                <td><button onclick="return extractMoney(),window.location.href='/extractMoney?userInvestmentId='+${userInverstment.userInvestmentId};" type="button" class="btn btn-block btn-sm btn-round btn-warning" style="margin-top: 1%;">提取本息</button></td>
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
