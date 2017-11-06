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
    <link rel="apple-touch-icon" sizes="76x76" href="/static/assets/img/apple-icon.png">
    <link rel="icon" type="image/png" href="/static/assets/img/favicon.png">

    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <title>登录/注册</title>

    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />

    <link href="/static/bootstrap3/css/bootstrap.css" rel="stylesheet" />
    <link href="/static/assets/css/gsdk.css" rel="stylesheet" />
    <link href="/static/assets/css/demo.css" rel="stylesheet" />

    <link href="/static/bootstrap3/css/font-awesome.css" rel="stylesheet">
    <link href='http://fonts.googleapis.com/css?family=Grand+Hotel' rel='stylesheet' type='text/css'>
</head>
<body>
<div class="space-100">
    <a href="/index.jsp">
        <img src="/static/img/logo.png" class="img-rounded" style="margin-left:40px; margin-top:10px; height:90px; width:80px;">
    </a>
</div>
<div id="navbar-full">
    <div class="parallax-pro" style="margin-top: 5px;">
        <div class="img-src" style="background-image: url('/static/img/bg.png');"></div>
        <div class="container">
            <div class="row">
                <div class="col-md-12 text-right">
                    <h1>
                        <small>
                             <a>
                        </a></small><a>
                    </a></h1><a>
                </a></div>
                <div class="col-md-4"></div>
                <div class="col-md-4"></div>
                <div class="col-md-4 text-center">
                    <div class="tabbable" style="background-color:#FFFFFF;">
                        <div class="space-30"></div>
                        <ul class="nav nav-tabs">
                            <li class="active"><a href="#login" data-toggle="tab"> 登录</a>
                            </li>
                            <li><a href="#register" data-toggle="tab"> 注册</a>
                            </li>
                        </ul>
                        <br>
                        <!-- 选项卡相对应的内容 -->
                        <div class="tab-content">
                            <div class="tab-pane active" id="login">
                                <form>
                                    <div class="form-group">
                                        <input id="email" type="text" value="" placeholder="请输入您的邮箱" class="form-group"
                                               style="height:35px;width:280px;">
                                    </div>
                                    <div class="form-group">
                                        <input id="pwd" type="password" value="" placeholder="请输入您的密码" class="form-group" style="height:35px;width:280px;">
                                    </div>
                                    <button type="submit" class="btn btn-block btn-fill btn-info btn-group" contenteditable="true" style="height:40px;width:100px;">登陆</button>
                                </form>
                            </div>
                            <div class="tab-pane" id="register">
                                <form>
                                    <div class="form-group">
                                        <input id="email-re" type="text" value="" placeholder="邮箱" class="form-group"
                                               style="height:35px;width:280px;">
                                    </div>
                                    <div class="form-group">
                                        <input id="pwd-re" type="password" value="" placeholder="密码" class="form-group" style="height:35px;width:280px;">
                                    </div>
                                    <button type="submit" class="btn btn-block btn-fill btn-info btn-group" contenteditable="true" style="height:40px;width:100px;">注册</button>
                                </form>
                            </div>
                        </div>
                        <div class="space-30"></div>
                    </div>
                </div>
            </div>
            <div class="space-100"></div>
        </div>
    </div>

    <div class="space-30"></div>
    <div class="row">
        <div class="col-md-12 text-center">
            <div class="credits">
                © <script>document.write(new Date().getFullYear())</script>2017 Get Shit Done Kit by  Creative Tim, More Templates <a href="http://www.cssmoban.com/" target="_blank" title="模板之家">模板之家</a> - Collect from <a href="http://www.cssmoban.com/" title="网页模板" target="_blank">网页模板</a>.
            </div>
        </div>
    </div>

</div>
</body>

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
</html>