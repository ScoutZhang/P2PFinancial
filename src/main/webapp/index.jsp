<%--
  Created by IntelliJ IDEA.
  User: chacha
  Date: 2017/11/4 0004
  Time: 16:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <link rel="apple-touch-icon" sizes="76x76" href="static/assets/img/apple-icon.png">
    <link rel="icon" type="image/png" href="static/assets/img/favicon.png">

    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <title>首页</title>

    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />

    <link href="static/bootstrap3/css/bootstrap.css" rel="stylesheet" />
    <link href="static/assets/css/gsdk.css" rel="stylesheet" />
    <link href="static/assets/css/demo.css" rel="stylesheet" />

    <link href="static/bootstrap3/css/font-awesome.css" rel="stylesheet">
    <link href='http://fonts.googleapis.com/css?family=Grand+Hotel' rel='stylesheet' type='text/css'>
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
                <a href="/index.jsp">
                    <img src="/static/img/logo.png" class="img-rounded" style="margin-left:40px; margin-top:10px; height:90px; width:80px;">
                </a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav" style="margin-top: 1%">
                    <li class="active"><a href="/index.jsp">首页</a></li>
                    <li><a href="/jsp/invest_1.jsp">一次性返还本息</a></li>
                    <li><a href="/jsp/invest_2.jsp">每日返还本息</a></li>
                    <li><a href="/jsp/invest_3.jsp">等额本金</a></li>
                    <li><a href="/jsp/invest_4.jsp">等额本息</a></li>
                    <li><a href="/jsp/user.jsp">按月付息</a></li>
                </ul>

                <div class="text-right" style="margin-top: 1%;margin-right: 5%;">
                    <a href="/jsp/login.jsp" class="btn btn-round btn-default">登录/注册</a>
                </div>
            </div><!-- /.navbar-collapse -->
        </div><!-- /.container-fluid -->
    </nav>
</div>
<div id="carousel">
    <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
        <!-- Indicators -->
        <ol class="carousel-indicators">
            <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
            <li data-target="#carousel-example-generic" data-slide-to="1"></li>
            <li data-target="#carousel-example-generic" data-slide-to="2"></li>
        </ol>

        <!-- Wrapper for slides -->
        <div class="carousel-inner">
            <div class="item active">
                <img src="/static/img/index_1.jpg" alt="Awesome Image">
            </div>
            <div class="item">
                <img src="/static/img/index_2.jpg" alt="Awesome Image">
            </div>
            <div class="item">
                <img src="/static/img/index_3.png" alt="Awesome Image">
            </div>
        </div>

        <!-- Controls -->
        <a class="left carousel-control" href="#carousel-example-generic" data-slide="prev">
            <span class="fa fa-angle-left"></span>
        </a>
        <a class="right carousel-control" href="#carousel-example-generic" data-slide="next">
            <span class="fa fa-angle-right"></span>
        </a>
    </div>
</div> <!-- end carousel -->
<div class="space-30"></div>
<div class="container">
    <div class="row">
        <div class="col-md-12">
            <img src="static/img/insurance.PNG" style="margin-top:10px;">
        </div>
    </div>
</div>

</body>

<script src="static/jquery/jquery-1.10.2.js" type="text/javascript"></script>
<script src="static/assets/js/jquery-ui-1.10.4.custom.min.js" type="text/javascript"></script>

<script src="static/bootstrap3/js/bootstrap.js" type="text/javascript"></script>
<script src="static/assets/js/gsdk-checkbox.js"></script>
<script src="static/assets/js/gsdk-radio.js"></script>
<script src="static/assets/js/gsdk-bootstrapswitch.js"></script>
<script src="static/assets/js/get-shit-done.js"></script>
<script src="static/assets/js/custom.js"></script>

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
</html>
