<%--
  Created by IntelliJ IDEA.
  User: cui
  Date: 2019/4/26
  Time: 23:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>基于Hadoop的手机APP日志数据分析系统</title>
    <link rel="stylesheet"
          href="//apps.bdimg.com/libs/jqueryui/1.10.4/css/jquery-ui.min.css">
    <%--<link rel="stylesheet" href="css/init.css">--%>
    <script src="//apps.bdimg.com/libs/jquery/1.10.2/jquery.min.js"></script>
    <script src="//apps.bdimg.com/libs/jqueryui/1.10.4/jquery-ui.min.js"></script>
    <script src="js/echarts.js"></script>

    <script src="js/jquery-2.1.4.min.js" type="text/javascript"></script>
    <link href="js/bootstrap-3.3.7-dist/css/bootstrap.css" rel="stylesheet">
    <script src="js/bootstrap-3.3.7-dist/js/bootstrap.js"></script>

    <script>

        function initchart() {
            var selectId = $('#appidselect option:selected').val();
            var myChart = echarts.init(document.getElementById('div-chart'));

            $.getJSON("stat/theweekofactiveusers?appId=" + selectId, function (d) {

                var option = {
                    legend: {
                        data: ['活跃人数与日期的变化关系']
                    },
                    toolbox: {
                        show: true,
                        feature: {
                            mark: {show: true},
                            dataView: {show: true, readOnly: false},
                            magicType: {show: true, type: ['line', 'bar']},
                            restore: {show: true},
                            saveAsImage: {show: true}
                        }
                    },
                    calculable: true,
                    tooltip: {
                        trigger: 'axis',
                        formatter: " <br/>{b} : {c}人"
                    },
                    xAxis: [
                        {
                            type: 'value',
                            axisLabel: {
                                formatter: '{value}'
                            }
                        }
                    ],
                    yAxis: [
                        {
                            type: 'category',
                            axisLine: {onZero: false},
                            axisLabel: {
                                formatter: '{value}'
                            },
                            boundaryGap: false,
                            data: d.time
                        }
                    ],
                    series: [
                        {
                            name: '活跃人数与日期的变化关系',
                            type: 'line',
                            smooth: true,
                            itemStyle: {
                                normal: {
                                    lineStyle: {
                                        shadowColor: 'rgba(0,0,0,0.8)'
                                    }
                                }
                            },
                            data: d.date
                        }
                    ]
                };
                myChart.setOption(option);
            });
        }

        $(function () {
            $("#appidselect").change(function () {
                initchart();
            });
            initchart();

        });


    </script>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-2">
            <select name="appid" id="appidselect" class="form-control ">
                <option value="sdk34734">微信</option>
                <option value="sdk34735">QQ</option>
                <option value="sdk34736">UC</option>
            </select>
        </div>
    </div>
    <div class="row">
        <div class="row" id="div-chart" style="width: 1000px;height: 400px;margin-top: 20px"></div>
    </div>
</div>

</body>
</html>
