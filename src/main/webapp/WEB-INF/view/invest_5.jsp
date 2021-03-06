<%--
  Created by IntelliJ IDEA.
  User: chacha
  Date: 2017/11/10 0010
  Time: 0:14
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
    <title>按月付息</title>

    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />

    <link href="/static/bootstrap3/css/bootstrap.css" rel="stylesheet" />
    <link href="/static/assets/css/gsdk.css" rel="stylesheet" />
    <link href="/static/assets/css/demo.css" rel="stylesheet" />

    <link href="/static/bootstrap3/css/font-awesome.css" rel="stylesheet">
    <link href='http://fonts.googleapis.com/css?family=Grand+Hotel' rel='stylesheet' type='text/css'>

    <script type="text/javascript">
        function calculator() {
            $.ajax({
                cache:true,
                type:"POST",
                contentType: "application/json; charset=utf-8",
                url:"/getInvestmentCalculator",
                data:JSON.stringify(GetJsonData()),
                async:false,
                error:function (request) {
                    alert("Connection Error")
                },
                success:function (interestResultDTO) {
                    $("#totalInterest").html(interestResultDTO.totalInterest);
                    $("#averageInterest").html(interestResultDTO.averageInterest);
                    $("#depositBankInterest").html(interestResultDTO.depositBankInterest);
                    $("#yuebaoInterest").html(interestResultDTO.yuebaoInterest);
                }
            })
        }

        function GetJsonData() {
            var principal=document.getElementById("principal").value
            var annualInterestRate=document.getElementById("annualInterestRate").value
            var investmentHorizon=document.getElementById("investmentHorizon").value
            var json = {
                "principal": principal,
                "annualInterestRate": annualInterestRate,
                "investmentHorizon": investmentHorizon,
                "investmentRepayment":"mpmd",
                "interestExpiryDate":"monthly",
                "investmentCompound":"f"
            };
            return json;
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
                    <li><a href="/index">首页</a></li>
                    <li><a href="/investmentOverview?investNum=1">一次性返还本息</a></li>
                    <li><a href="/investmentDetail?investmentRepayment=rdm&investmentHorizon=0&annualInterestRate=0.037&interestExpiryDate=daily&investmentCompound=t&principal=10000">每日返还本息</a></li>
                    <li><a href="/investmentOverview?investNum=3">等额本金</a></li>
                    <li><a href="/investmentOverview?investNum=4">等额本息</a></li>
                    <li class="active"><a href="/investmentOverview?investNum=5">按月付息</a></li>
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
<div class="parallax-pro">
    <div class="img-src" style="background-image: url('/static/img/index_3.jpg');"></div>
    <div class="container">
        <div class="space-100"></div>
        <div class="space-100"></div>
        <div class="space-100"></div>
    </div>
</div>
<div class="container">
    <div class="row">
        <div class="col-md-3">
            <div class="card card-user">
                <div class="text-center">
                    <h4>
                        <a><small><i class="fa fa-clock-o" style="margin-right: 2px"></i>1个月</small></a>
                    </h4>
                    <hr>
                    <div class="text-center">
                        <p class="h1" style="color: #ec971f;">6.2%</p><h5><small>预期年化利率</small></h5>
                    </div>
                    <div class="space-30"></div>
                    <hr>
                    <div class="actions">
                        <a class="btn btn-lg btn-warning btn-fill" href="/investmentDetail?investmentRepayment=mpmd&investmentHorizon=30&annualInterestRate=0.062&interestExpiryDate=monthly&investmentCompound=f&principal=10000">查看详情</a>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-md-3">
            <div class="card card-user">
                <div class="text-center">
                    <h4>
                        <a><small><i class="fa fa-clock-o" style="margin-right: 2px"></i>3个月</small></a>
                    </h4>
                    <hr>
                    <div class="text-center">
                        <p class="h1" style="color: #ec971f;">6.5%</p><h5><small>预期年化利率</small></h5>
                    </div>
                    <div class="space-30"></div>
                    <hr>
                    <div class="actions">
                        <a class="btn btn-lg btn-warning btn-fill" href="/investmentDetail?investmentRepayment=mpmd&investmentHorizon=90&annualInterestRate=0.065&interestExpiryDate=monthly&investmentCompound=f&principal=10000">查看详情</a>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-md-3">
            <div class="card card-user">
                <div class="text-center">
                    <h4>
                        <a><small><i class="fa fa-clock-o" style="margin-right: 2px"></i>6个月</small></a>
                    </h4>
                    <hr>
                    <div class="text-center">
                        <p class="h1" style="color: #ec971f;">7.5%</p><h5><small>预期年化利率</small></h5>
                    </div>
                    <div class="space-30"></div>
                    <hr>
                    <div class="actions">
                        <a class="btn btn-lg btn-warning btn-fill" href="/investmentDetail?investmentRepayment=mpmd&investmentHorizon=180&annualInterestRate=0.075&interestExpiryDate=monthly&investmentCompound=f&principal=10000">查看详情</a>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-md-3">
            <div class="card card-user">
                <div class="text-center">
                    <h4>
                        <a><small><i class="fa fa-clock-o" style="margin-right: 2px"></i>12个月</small></a>
                    </h4>
                    <hr>
                    <div class="text-center">
                        <p class="h1" style="color: #ec971f;">8.7%</p><h5><small>预期年化利率</small></h5>
                    </div>
                    <div class="space-30"></div>
                    <hr>
                    <div class="actions">
                        <a class="btn btn-lg btn-warning btn-fill" href="/investmentDetail?investmentRepayment=mpmd&investmentHorizon=360&annualInterestRate=0.087&interestExpiryDate=monthly&investmentCompound=f&principal=10000">查看详情</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<hr>
<div class="container">
    <div class="tim-title" style="margin-left: 5%;">
        <h3>收益计算器</h3>
    </div>
    <div class="row">
        <div class="col-md-8">
            <div class="tab-pane active" id="calculator" style="margin-left: 7%;margin-right: 5%;">
                <form id="calculatorForm">
                    <div class="row">
                        <div class="col-md-9">
                            <div class="form-group">
                                <input id="principal" name="principal" type="text" value="" placeholder="请输入您的本金" class="form-control">
                            </div>
                            <div class="form-group">
                                <input id="annualInterestRate" name="annualInterestRate" type="text" value="" placeholder="请输入您的年利率" class="form-control">
                            </div>
                            <div class="form-group">
                                <input id="investmentHorizon" name="investmentHorizon" type="text" value="" placeholder="请输入您的投资期限" class="form-control">
                            </div>
                            <div class="form-group">
                                <input name="investmentRepayment" type="hidden" value="mpmd" class="form-control">
                            </div>
                            <div class="form-group">
                                <input name="interestExpiryDate" type="hidden" value="monthly" class="form-control">
                            </div>
                            <div class="form-group">
                                <input name="investmentCompound" type="hidden" value="f" class="form-control">
                            </div>
                        </div>
                        <div class="col-md-3">
                            <div class="text-left" style="margin-top: 3%;">
                                <button  type="button" class="btn btn-block btn-lg btn-round btn-warning" onclick="calculator()">计算</button>
                            </div>
                            <br>
                            <div class="text-left">
                                <button type="reset" class="btn btn-block btn-lg btn-round btn-warning">重置</button>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div>
        <div class="col-md-4">
            <div class="text-center">
                <p id="totalInterest" style="color: #ec971f;font-size: 600%;">0000.00</p>
            </div>
        </div>
    </div>
    <hr>
    <div class="row">
        <div class="col-md-4">
            <div class="text-center">
                <h5><small>平均每日收益</small></h5><p id="averageInterest" class="h2" style="color: #ec971f;">0<a class="h5">&emsp;元</a></p>
            </div>
        </div>
        <div class="col-md-4">
            <div class="text-center">
                <h5><small>银行活期收益</small></h5><p id="depositBankInterest" class="h2" style="color: #ec971f;">0<a class="h5">&emsp;元</a></p>
            </div>
        </div>
        <div class="col-md-4">
            <div class="text-center">
                <h5><small>余额宝收益</small></h5><p id="yuebaoInterest" class="h2" style="color: #ec971f;">0<a class="h5">&emsp;元</a></p>
            </div>
        </div>
    </div>
    <div class="space-30"></div>
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
