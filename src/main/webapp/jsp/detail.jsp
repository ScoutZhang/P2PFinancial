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
    <title>首页</title>

    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />

    <link href="/static/bootstrap3/css/bootstrap.css" rel="stylesheet" />
    <link href="/static/assets/css/gsdk.css" rel="stylesheet" />
    <link href="/static/assets/css/demo.css" rel="stylesheet" />

    <link href="/static/bootstrap3/css/font-awesome.css" rel="stylesheet">
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
                    <li><a href="/index.jsp">首页</a></li>
                    <li><a href="/jsp/invest_1.jsp">一次性返还本息</a></li>
                    <li><a href="/jsp/invest_3.jsp">每日返还本息</a></li>
                    <li><a href="/jsp/invest_4.jsp">等额本金</a></li>
                    <li><a href="/jsp/invest_5.jsp">等额本息</a></li>
                    <li><a href="/jsp/invest_6.jsp">按月付息</a></li>
                </ul>

                <div class="text-right" style="margin-top: 1%;margin-right: 5%;">
                    <a href="/jsp/login.jsp" class="btn btn-round btn-default">登录/注册</a>
                </div>
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
                        <p class="h1" style="color: #ec971f;">8.8%</p><h5><small>预期年化利率</small></h5>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="text-center">
                        <p class="h1" style="color: #ec971f;">1个月</p><h5><small>投资期限</small></h5>
                    </div>
                </div>
            </div>
            <br>
            <div class="tab-pane active" id="inverst" style="margin-left: 7%;margin-right: 5%;">
                <form>
                    <div class="form-group" style="width: 80%;margin-left: 10%;">
                        <input id="invest_prin" type="text" value="" placeholder="请输入您的投资金额" class="form-control">
                    </div>
                    <div class="text-center" style="width: 50%;margin-left: 25%;">
                        <button type="submit" class="btn btn-block btn-lg btn-fill btn-round btn-warning">一键投资</button>
                    </div>
                    <br>
                    <div class="text-center">
                        <h5><small>加入下限：1000&emsp;&emsp;加入上限：100000</small></h5>
                    </div>
                </form>
            </div>
        </div>
        <div class="col-md-1">
            <div class="text-center" style="float:left;width: 1px;height: 350px; background: #dbdbdb;"></div>
        </div>
        <div class="col-md-4">
            <div class="text-center" style="margin-top: 20%;">
                <h5><small>已累计招募</small></h5><p style="color: #ec971f;font-size: 500%">10000<a class="h5">&emsp;人</a></p>
            </div>
        </div>
    </div>
</div>
<hr>
<div class="container">
    <div class="tim-title" style="margin-left: 18%;">
        <h3>项目预期收益计算</h3>
    </div>
    <div class="row">
        <div class="col-md-8">
            <div class="tab-pane active" id="calculator" style="margin-left: 7%;margin-right: 5%;">
                <form>
                    <div class="row">
                        <div class="col-md-9">
                            <div class="form-group" style="margin-top: 15%;">
                                <input id="principal" type="text" value="" placeholder="请输入您的本金" class="form-control">
                            </div>
                            <div class="form-group">
                                <input id="rate" type="hidden" value="8.8%" class="form-control">
                            </div>
                            <div class="form-group">
                                <input id="term" type="hidden" value="1" class="form-control">
                            </div>
                        </div>
                        <div class="col-md-3" style="margin-top: 9%;">
                            <div class="text-left">
                                <button type="submit" class="btn btn-block btn-lg btn-fill btn-round btn-warning">计算</button>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div>
        <div class="col-md-4">
            <div class="text-center">
                <h5><small>总收益：</small></h5><p style="color: #ec971f;font-size: 500%;">0000.00</p>
            </div>
        </div>
    </div>
    <div class="content">
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-12">
                    <div class="card" style="margin-left: 0%;">
                        <div class="content table-responsive table-full-width">
                            <table class="table table-striped">
                                <thead>
                                <tr><th>预计汇款时间</th>
                                    <th>回款本金</th>
                                    <th>回款利息</th>
                                    <th>回款总额</th>
                                </tr></thead>
                                <tbody>
                                <tr>
                                    <td>1</td>
                                    <td>Dakota Rice</td>
                                    <td>$36,738</td>
                                    <td>Niger</td>
                                </tr>
                                <tr>
                                    <td>2</td>
                                    <td>Minerva Hooper</td>
                                    <td>$23,789</td>
                                    <td>Curaçao</td>
                                </tr>
                                <tr>
                                    <td>3</td>
                                    <td>Sage Rodriguez</td>
                                    <td>$56,142</td>
                                    <td>Netherlands</td>
                                </tr>
                                <tr>
                                    <td>4</td>
                                    <td>Philip Chaney</td>
                                    <td>$38,735</td>
                                    <td>Korea, South</td>
                                </tr>
                                <tr>
                                    <td>5</td>
                                    <td>Doris Greene</td>
                                    <td>$63,542</td>
                                    <td>Malawi</td>
                                </tr>
                                <tr>
                                    <td>6</td>
                                    <td>Mason Porter</td>
                                    <td>$78,615</td>
                                    <td>Chile</td>
                                </tr>
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
                                <td><p class="h6" style="color: #ec971f;">名称</p></td>
                                <td>内容</td>
                            </tr>
                            <tr>
                                <td><p class="h6" style="color: #ec971f;">名称</p></td>
                                <td>内容</td>
                            </tr>
                            <tr>
                                <td><p class="h6" style="color: #ec971f;">名称</p></td>
                                <td>内容</td>
                            </tr>
                            <tr>
                                <td><p class="h6" style="color: #ec971f;">名称</p></td>
                                <td>内容</td>
                            </tr>
                            <tr>
                                <td><p class="h6" style="color: #ec971f;">名称</p></td>
                                <td>内容</td>
                            </tr>
                            <tr>
                                <td><p class="h6" style="color: #ec971f;">名称</p></td>
                                <td>内容</td>
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
                                <td>1</td>
                            </tr>
                            <tr>
                                <td>2</td>
                            </tr>
                            <tr>
                                <td>3</td>
                            </tr>
                            <tr>
                                <td>4</td>
                            </tr>
                            <tr>
                                <td>5</td>
                            </tr>
                            <tr>
                                <td>6</td>
                            </tr>
                            </tbody>
                        </table>
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
