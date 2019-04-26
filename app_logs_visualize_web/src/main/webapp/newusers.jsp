<%--
  Created by IntelliJ IDEA.
  User: cui
  Date: 2019/4/26
  Time: 19:12
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

    <script src="js/jquery-2.1.4.min.js" type="text/javascript"></script>
    <link href="js/bootstrap-3.3.7-dist/css/bootstrap.css" rel="stylesheet">
    <script src="js/bootstrap-3.3.7-dist/js/bootstrap.js"></script>


    <script>

        function initChart() {
            var selectId = $('#appidselect option:selected').val();
            var myChart = echarts.init(document.getElementById('div-chart'));
            var option = {
                title: {
                    text: '近一周的用户增长量',
                },
                tooltip: {
                    trigger: 'axis'
                },
                legend: {
                    data: ['3.2.1', '3.2.2', '3.2.3']
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
                xAxis: [
                    {
                        type: 'category',
                        data: ['4月23日', '4月24日', '4月24日', '4月24日', '4月24日', '4月24日', '4月24日']
                    }
                ],
                yAxis: [
                    {
                        type: 'value'
                    }
                ],
                series: [
                    {
                        name: '3.2.1',
                        type: 'bar',
                        data: [2.0, 4, 135, 25, 76, 135, 5],
                        markPoint: {
                            data: [
                                {type: 'max', name: '最大值'},
                                {type: 'min', name: '最小值'}
                            ]
                        },
                        markLine: {
                            data: [
                                {type: 'average', name: '平均值'}
                            ]
                        }
                    },
                    {
                        name: '3.2.2',
                        type: 'bar',
                        data: [2, 34, 32, 8, 26, 70, 35],
                        markPoint: {
                            data: [
                                {name: '年最高', value: 182.2, xAxis: 7, yAxis: 183, symbolSize: 18},
                                {name: '年最低', value: 2.3, xAxis: 11, yAxis: 3}
                            ]
                        },
                        markLine: {
                            data: [
                                {type: 'average', name: '平均值'}
                            ]
                        }
                    },

                    {
                        name: '3.2.3',
                        type: 'bar',
                        data: [100, 23, 67, 43, 3, 23, 6],
                        markPoint: {
                            data: [
                                {name: '年最高', value: 182.2, xAxis: 7, yAxis: 183, symbolSize: 18},
                                {name: '年最低', value: 2.3, xAxis: 11, yAxis: 3}
                            ]
                        },
                        markLine: {
                            data: [
                                {type: 'average', name: '平均值'}
                            ]
                        }
                    }
                ]
            };

            $.getJSON("stat/week1?selectId=" + selectId, function (d) {
                option.xAxis[0].data = d.dayBeforeSeven;
                $.each(d.date, function (i, num) {
                    option.series.name = d.version[i];
                    option.series[i].data = num;
                });
                myChart.setOption(option);
            });
        }

        $(function () {
            initChart();
            $("#appidselect").change(function(){
                initChart();
            });
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
