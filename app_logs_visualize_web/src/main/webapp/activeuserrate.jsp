<%--
  Created by IntelliJ IDEA.
  User: cui
  Date: 2019/4/28
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
    <script src="js/oldie.js"></script>
    <script src="js/themes/grid-light.js"></script>

    <script>
        $(function () {
            var chart = null;
            function initChart() {
                var appId = $('#appidselect option:selected').val();
                $.getJSON('stat/activerateofday?appId=' + appId, function (data) {
                    console.log(data);
                    chart = Highcharts.chart('container', {
                        chart: {
                            zoomType: 'x'
                        },
                        title: {
                            text: '用户日活跃度图'
                        },
                        subtitle: {
                            text: document.ontouchstart === undefined ?
                                '鼠标拖动可以进行缩放' : '手势操作进行缩放'
                        },
                        xAxis: {
                            type: 'datetime',
                            dateTimeLabelFormats: {
                                millisecond: '%H:%M:%S.%L',
                                second: '%H:%M:%S',
                                minute: '%H:%M',
                                hour: '%H:%M',
                                day: '%m-%d',
                                week: '%m-%d',
                                month: '%Y-%m',
                                year: '%Y'
                            }
                        },
                        yAxis: {
                            title: {
                                text: '比例'
                            }
                        },
                        legend: {
                            enabled: true
                        },
                        plotOptions: {
                            area: {
                                fillColor: {
                                    linearGradient: {
                                        x1: 0,
                                        y1: 0,
                                        x2: 0,
                                        y2: 1
                                    },
                                    stops: [
                                        [0, Highcharts.getOptions().colors[0]],
                                        [1, Highcharts.Color(Highcharts.getOptions().colors[0]).setOpacity(0).get('rgba')]
                                    ]
                                },
                                marker: {
                                    radius: 2
                                },
                                lineWidth: 1,
                                states: {
                                    hover: {
                                        lineWidth: 1
                                    }
                                },
                                threshold: null
                            }
                        },
                        series: [{
                            type: 'area',
                            name: '用户活跃度',
                            data: data
                        }]
                    });
                    console.log(data);
                    $(".highcharts-credits").remove();
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
        <div id="container" class="col-md-14" style="min-width:400px;height:430px"></div>
    </div>
</div>
</body>
</html>
