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
    <%--<script src="js/bootstrap-3.3.7-dist/js/bootstrap.js"></script>--%>

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

            var data = [
                {
                    "time": "2019-4-12",
                    "adduser": "78",
                    "afteroneday": "12%",
                    "aftertwoday": "6%",
                    "afterthreeday": "7%",
                    "afterfoueday": "8%",
                    "afterfiveday": "9%",
                    "aftersixday": "10%",
                    "aftersevenday": "11%",
                    "afterfourtyday": "2%",
                    "aftermonthday": "3%"
                }, {
                    "time": "2019-4-12",
                    "adduser": "78",
                    "afteroneday": "12%",
                    "aftertwoday": "6%",
                    "afterthreeday": "7%",
                    "afterfoueday": "8%",
                    "afterfiveday": "9%",
                    "aftersixday": "10%",
                    "aftersevenday": "11%",
                    "afterfourtyday": "2%",
                    "aftermonthday": "3%"
                }
            ];

            //前台分页的样子
            function inittable() {
                $('#histroyBox').CJJTable({
                    'title': ["时间", "新增用户", "1天后", "2天后", "3天后", "4天后", "5天后", "6天后", "7天后", "14天后", "30天后"],//thead中的标题 必填
                    'body': ["time", "adduser", "afteroneday", "aftertwoday", "afterthreeday", "afterfoueday", "afterfiveday", "aftersixday", "aftersevenday", "afterfourtyday", "aftermonthday"],//tbody td 取值的字段 必填
                    'display': [1, 1, 1, 1, 1, 2],//隐藏域，1显示，2隐藏 必填
                    'pageNUmber': 10,//每页显示的条数 选填
                    'pageLength': data.length,//选填
                    'url': data,//数据源 必填
                    dbTrclick: function (e) {//双击tr事件
                        alert(e.find('.taskCode').html())
                    }
                });
                $("th").css("text-align", "center");
            }




            $("button").click(function () {
                var timeframe = $("#timeframe").val();
                var appidselect = $("#appidselect option:selected").val();
                var versionselect = $("#versionselect option:selected").val();
                $.getJSON("stat/retentionanalaysis?timeframe=" + timeframe + "&&appidselect=" + appidselect + "&&versionselect=" + versionselect, function (d) {
                    data = d;
                    inittable();

                });
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
                <input type="text" class="form-control" id="timeframe" placeholder="2019-4-5 - 2019-6-7"
                       style="width: 200px">
            </div>
            <div class="form-group" style="margin-right: 20px">
                <label for="appidselect">应用：</label>
                <select name="appid" id="appidselect" class="form-control ">
                    <option value="sdk34734">微信</option>
                    <option value="sdk34735">QQ</option>
                    <option value="sdk34736">UC</option>
                </select>
            </div>
            <div class="form-group" style="margin-right: 10px">
                <label for="versionselect">全部版本：</label>
                <select name="versionid" id="versionselect" class="form-control ">
                    <option value="3.2.1">V3.2.1</option>
                    <option value="3.2.2">V3.2.2</option>
                    <option value="3.2.3">V3.2.3</option>
                </select>
            </div>
            <button type="submit" class="btn btn-default">提交</button>
        </form>
    </div>
    <div class="row">
        <div id="histroyBox"></div>
    </div>


</div>
</body>
</html>
