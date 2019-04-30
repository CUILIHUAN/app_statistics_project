<%--
  Created by IntelliJ IDEA.
  User: cui
  Date: 2019/4/30
  Time: 17:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>基于Hadoop的手机APP日志数据分析系统</title>


    <script src="js/jquery-2.1.4.min.js" type="text/javascript"></script>
    <link href="js/bootstrap-3.3.7-dist/css/bootstrap.css" rel="stylesheet">

    <%--日期插件--%>
    <script src="js/laydate/laydate.js"></script>

    <script src="js/highcharts.js"></script>
    <script src="js/exporting.js"></script>
    <script src="js/drilldown.js"></script>
    <script src="js/oldie.js"></script>

    <script src="js/themes/grid-light.js"></script>


    <script>
        $(function () {

            //获取日期插件
            //执行一个laydate实例
            laydate.render({
                elem: '#timeframe'
            });


            //前台分页的样子
            function inittable() {
                var time = $("#timeframe").val();
                var appidselect = $("#appidselect option:selected").val();
                $.getJSON("stat/usagetimes?time=" + time + "&&appId=" + appidselect, function (d) {
                    console.log(d);
                    Highcharts.chart('container', {
                        chart: {
                            type: 'bar'
                        },
                        title: {
                            text: '堆叠条形图'
                        },
                        xAxis: {
                            categories: d.categories
                        },
                        yAxis: {
                            min: 0,
                            title: {
                                text: '浏览页面时长'
                            }
                        },
                        legend: {
                            /* 图例显示顺序反转
                             * 这是因为堆叠的顺序默认是反转的，可以设置
                             * yAxis.reversedStacks = false 来达到类似的效果
                             */
                            reversed: true
                        },
                        plotOptions: {
                            series: {
                                stacking: 'normal'
                            }
                        },
                        series:d.data
                    });
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
        <form class="form-inline col-md-offset-3" style="margin-bottom: 20px">
            <div class="form-group" style="margin-right: 20px">
                <label for="timeframe">时间</label>
                <input type="text" class="form-control" id="timeframe" placeholder="2019-04-23"
                      value="2019-04-23" style="width: 110px">
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
    <div class="row">
        <div id="container" style="min-width:400px;height:400px"></div>
    </div>


</div>
</body>
</html>

