<%--
  Created by IntelliJ IDEA.
  User: cui
  Date: 2019/4/27
  Time: 0:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>基于Hadoop的手机APP日志数据分析系统</title>


    <script src="js/jquery-2.1.4.min.js" type="text/javascript"></script>
    <link href="js/bootstrap-3.3.7-dist/css/bootstrap.css" rel="stylesheet">

    <link rel="stylesheet" href="css/pintuer.css">
    <script src="js/pintuer.js" type="text/javascript"></script>

    <%--日期插件--%>
    <script src="js/laydate/laydate.js"></script>

    <%--表格插件--%>
    <script type="text/javascript" src="js/front-endPage.js"></script><!-- 前台分页 -->
    <script type="text/javascript" src="js/shujv2.js"></script>
    <link rel="stylesheet" type="text/css" href="css/table.css">

    <script>
        $(function () {

            //获取日期插件
            //执行一个laydate实例
            laydate.render({
                elem: '#timeframe'
                , range: true
            });

            var data = [];

            //前台分页的样子
            function inittable() {
                var timeframe = $("#timeframe").val();
                var appidselect = $("#appidselect option:selected").val();
                $.getJSON("stat/errordetail?time=" + timeframe + "&&appId=" + appidselect, function (d) {
                    $('#histroyBox').CJJTable({
                        'title': ["创建时间", "标识号", "类型", "系统", "版本号", "错误摘要"],//thead中的标题 必填
                        'body': ["time", "deviceId", "deviceStyle", "appPlatform", "osType", "errorBrief", "errorDetail"],//tbody td 取值的字段 必填
                        'display': [1, 1, 1, 1, 1, 1, 2],//隐藏域，1显示，2隐藏 必填
                        'pageNUmber': 10,//每页显示的条数 选填
                        'pageLength': d.length,//选填
                        'url': d,//数据源 必填
                        dbTrclick: function (e) {//双击tr事件
                            $(".dialog-body").html(e.find('.errorDetail').html());

                            $("#dialog_button").click();
                        }
                    });
                    $("th").css("text-align", "center");
                });
            }


            $("button").click(function () {
                inittable();
                return false;
            });

            inittable();

        });

    </script>
</head>
<body>
<div class="container">
    <div class="row">
        <form class="form-inline col-md-offset-2" style="margin-bottom: 20px">
            <div class="form-group" style="margin-right: 20px">
                <label for="timeframe">时间范围</label>
                <input type="text" class="form-control" id="timeframe" placeholder="2019-04-05 - 2019-05-13"
                       style="width: 200px" value="2019-04-05 - 2019-05-13">
            </div>
            <div class="form-group" style="margin-right: 20px">
                <label for="appidselect">应用：</label>
                <select name="appid" id="appidselect" class="form-control ">
                    <option value="sdk34734">微信</option>
                    <option value="sdk34735">QQ</option>
                    <option value="sdk34736">UC</option>
                </select>
            </div>

            <button type="submit" class="btn btn-default">提交</button>
        </form>
    </div>
    <div class="row" style="width: 1111px;margin-left: -100px">
        <div id="histroyBox"></div>
    </div>


    <button  id="dialog_button" class="button button-big bg-main dialogs" data-toggle="click" data-target="#mydialog" data-mask="1" data-width="50%" style="display: none">
        弹出对话框</button>
    <div id="mydialog">
        <div class="dialog" style="width: 620px;">
            <div class="dialog-head">
                <span class="close rotate-hover"></span><strong>错误详情</strong>
            </div>
            <div class="dialog-body">
                对话框内容</div>
            <div class="dialog-foot">
                <button class="button dialog-close">
                    取消</button>

            </div>
        </div>
    </div>

</div>
</body>
</html>
