<%--
  Created by IntelliJ IDEA.
  User: cui
  Date: 2019/4/29
  Time: 18:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="js/jquery-2.1.4.min.js"></script>


    <link href="js/bootstrap-3.3.7-dist/css/bootstrap.css" rel="stylesheet">
    <script src="js/bootstrap-3.3.7-dist/js/bootstrap.js"></script>

    <script src="js/highcharts.js"></script>
    <script src="js/exporting.js"></script>
    <script src="js/drilldown.js"></script>
    <script src="js/oldie.js"></script>

    <script src="js/themes/grid-light.js"></script>

    <script>
        $(function () {


            function initChart() {
                var appId = $('#appidselect option:selected').val();

                $.getJSON('stat/networknums?appId=' + appId, function (data) {
                    Highcharts.chart('container', {
                        chart: {
                            type: 'bar'
                        },
                        title: {
                            text: '联网方式'
                        },
                        xAxis: {
                            categories: data.categories,
                            title: {
                                text: null
                            }
                        },
                        yAxis: {
                            min: 0,
                            title: {
                                text: '人口总量',
                                align: 'high'
                            },
                            labels: {
                                overflow: 'justify'
                            }
                        },
                        tooltip: {
                            valueSuffix: ''
                        },
                        plotOptions: {
                            bar: {
                                dataLabels: {
                                    enabled: true,
                                    allowOverlap: true // 允许数据标签重叠
                                }
                            }
                        },
                        legend: {
                            layout: 'vertical',
                            align: 'right',
                            verticalAlign: 'top',
                            x: -40,
                            y: 100,
                            floating: true,
                            borderWidth: 1,
                            backgroundColor: ((Highcharts.theme && Highcharts.theme.legendBackgroundColor) || '#FFFFFF'),
                            shadow: true
                        },
                        series:data.data
                    });
                });
            }


            $("#appidselect").change(function () {
                initChart();
            });
            initChart();

        });
    </script>

</head>
<body>
<div class="container">
    <div class="row" style="margin-bottom: 10px">
        <div class="col-md-2">
            <select name="appid" id="appidselect" class="form-control ">
                <option value="sdk34734">微信</option>
                <option value="sdk34735">QQ</option>
                <option value="sdk34736">UC</option>
            </select>
        </div>
    </div>
    <div class="row">
        <div id="container" style="min-width: 310px; height: 400px; margin: 0 auto"></div>
    </div>
</div>

</body>
</html>
