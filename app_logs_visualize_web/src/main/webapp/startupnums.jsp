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
            var appId = $('#appidselect option:selected').val();
            var myChart = echarts.init(document.getElementById('div-chart'));
            $.getJSON("stat/numofstartup?appId=" + appId, function (d) {
                var option = {
                    tooltip: {
                        trigger: 'axis'
                    },
                    legend: {
                        data: ['最高', '最低']
                    },
                    toolbox: {
                        show: true,
                        feature: {
                            mark: {show: true},
                            dataZoom: {show: true},
                            dataView: {show: true},
                            magicType: {show: true, type: ['line', 'bar', 'stack', 'tiled']},
                            restore: {show: true},
                            saveAsImage: {show: true}
                        }
                    },
                    calculable: true,
                    dataZoom: {
                        show: true,
                        realtime: true,
                        start: 20,
                        end: 80
                    },
                    xAxis: [
                        {
                            type: 'category',
                            boundaryGap: false,
                            data: d.time
                        }
                    ],
                    yAxis: [
                        {
                            type: 'value'
                        }
                    ],
                    series: []
                };
                option.legend.data = d.version;
                option.xAxis[0].data = d.time;

                $.each(d.version, function (i, item) {
                    console.log(item);
                    option.series.push({
                        name: '',
                        type: 'line',
                        data: 0
                    });
                    option.series[i].name = item;
                    option.series[i].data = d.data[item];

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
