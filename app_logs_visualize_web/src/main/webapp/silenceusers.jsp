<%--
  Created by IntelliJ IDEA.
  User: cui
  Date: 2019/4/26
  Time: 23:46
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
            var appId = $('#appidselect option:selected').val();
            var myChart = echarts.init(document.getElementById('div-chart'));

            $.getJSON("stat/numofsilenceusers?appId=" + appId, function (d) {
                var option = {
                    title: {
                        text: '每个版本的沉默用户',
                        subtext: '统计人数',
                        x: 'center'
                    },
                    tooltip: {
                        trigger: 'item',
                        formatter: "{a} <br/>{b} : {c} ({d}%)"
                    },
                    legend: {
                        orient: 'vertical',
                        x: 'left',
                        data: d.appVersion
                    },
                    toolbox: {
                        show: true,
                        feature: {
                            mark: {show: true},
                            dataView: {show: true, readOnly: false},
                            magicType: {
                                show: true,
                                type: ['pie', 'funnel'],
                                option: {
                                    funnel: {
                                        x: '25%',
                                        width: '50%',
                                        funnelAlign: 'left',
                                        max: 1548
                                    }
                                }
                            },
                            restore: {show: true},
                            saveAsImage: {show: true}
                        }
                    },
                    calculable: true,
                    series: [
                        {
                            name: '访问来源',
                            type: 'pie',
                            radius: '55%',
                            center: ['50%', '60%'],
                            data: [
                                {value: 335, name: '3.2.1'},
                                {value: 310, name: '3.2.2'},
                                {value: 234, name: '3.2.3'},
                            ]
                        }
                    ]
                };
                $.each(d.data, function (i, item) {
                    option.series[0].data[i].value = item;
                    option.series[0].data[i].name = d.appVersion[i];
                });
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
