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
    <link rel="stylesheet"
          href="//apps.bdimg.com/libs/jqueryui/1.10.4/css/jquery-ui.min.css">
    <script src="//apps.bdimg.com/libs/jquery/1.10.2/jquery.min.js"></script>
    <script src="//apps.bdimg.com/libs/jqueryui/1.10.4/jquery-ui.min.js"></script>
    <script src="js/echarts.js"></script>
    <script src="js/china.js"></script>

    <script src="js/jquery-2.1.4.min.js" type="text/javascript"></script>
    <link href="js/bootstrap-3.3.7-dist/css/bootstrap.css" rel="stylesheet">
    <script src="js/bootstrap-3.3.7-dist/js/bootstrap.js"></script>

    <%--日期插件--%>
    <script src="js/laydate/laydate.js"></script>

    <script>
        $(function () {

            //获取日期插件
            //执行一个laydate实例
            laydate.render({
                elem: '#timeframe'
                , range: true
            });

        });

    </script>
</head>
<body>
<div class="container">
    <div class="row">
        <form class="form-inline">
            <div class="form-group" style="margin-right: 20px">
                <label for="timeframe">时间范围</label>
                <input type="text" class="form-control" id="timeframe" placeholder="2019/4/5-2019/6/7">
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


</div>
</body>
</html>
