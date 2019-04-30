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

                $.getJSON('stat/deviceanalysis?appId=' + appId, function (data) {
                    var arr1 = [];
                    var arr2 = [];
                    $.each(data, function (i, item) {
                        var json = {
                            "name": item.name,
                            "y": item.y,
                            "drilldown": item.name
                        };
                        arr1.push(json);
                        arr2.push(item.drilldrilldown);
                    });


                    Highcharts.chart('container', {
                        chart: {
                            type: 'column'
                        },
                        title: {
                            text: '设备终端机型'
                        },
                        xAxis: {
                            type: 'category'
                        },
                        yAxis: {
                            title: {
                                text: '各个机型的比率'
                            }
                        },
                        legend: {
                            enabled: false
                        },
                        plotOptions: {
                            series: {
                                borderWidth: 0,
                                dataLabels: {
                                    enabled: true,
                                    format: '{point.y:.1f}%'
                                }
                            }
                        },
                        tooltip: {
                            headerFormat: '<span style="font-size:11px">{series.name}</span><br>',
                            pointFormat: '<span style="color:{point.color}">{point.name}</span>: <b>{point.y:.2f}%</b> of total<br/>'
                        },
                        series: [{
                            name: '手机品牌',
                            colorByPoint: true,
                            data: arr1
                        }],
                        drilldown: {
                            series: arr2
                        }
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
