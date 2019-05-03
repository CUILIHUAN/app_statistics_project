<%--
  Created by IntelliJ IDEA.
  User: cui
  Date: 2019/5/1
  Time: 10:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>基于Hadoop的手机APP日志数据分析系统</title>


    <script src="js/jquery-2.1.4.min.js" type="text/javascript"></script>
    <link href="js/bootstrap-3.3.7-dist/css/bootstrap.css" rel="stylesheet">

    <link rel="stylesheet" href="css/pintuer.css">
    <script src="js/pintuer.js" type="text/javascript"></script>

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
                $.getJSON("stat/usagerate?time=" + time + "&&appId=" + appidselect, function (d) {

                     Highcharts.chart('container1', {
                        chart: {
                            type: 'column'
                        },
                        title: {
                            text: '日使用频率折叠图'
                        },
                        xAxis: {
                            categories: d.result0.categories
                        },
                        yAxis: {
                            min: 0,
                            title: {
                                text: '启动人次'
                            },
                            stackLabels: {  // 堆叠数据标签
                                enabled: true,
                                style: {
                                    fontWeight: 'bold',
                                    color: (Highcharts.theme && Highcharts.theme.textColor) || 'gray'
                                }
                            }
                        },
                        legend: {
                            align: 'right',
                            x: -30,
                            verticalAlign: 'top',
                            y: 25,
                            floating: true,
                            backgroundColor: (Highcharts.theme && Highcharts.theme.background2) || 'white',
                            borderColor: '#CCC',
                            borderWidth: 1,
                            shadow: false
                        },
                        tooltip: {
                            formatter: function () {
                                return '<b>' + this.x + '</b><br/>' +
                                    this.series.name + ': ' + this.y + '<br/>' +
                                    '总量: ' + this.point.stackTotal;
                            }
                        },
                        plotOptions: {
                            column: {
                                stacking: 'normal',
                                dataLabels: {
                                    enabled: true,
                                    color: (Highcharts.theme && Highcharts.theme.dataLabelsColor) || 'white',
                                    style: {
                                        // 如果不需要数据标签阴影，可以将 textOutline 设置为 'none'
                                        textOutline: '1px 1px black'
                                    }
                                }
                            }
                        },
                        series: d.result0.data
                    });

                    Highcharts.chart('container2', {
                        chart: {
                            type: 'column'
                        },
                        title: {
                            text: '周使用频率折叠图'
                        },
                        xAxis: {
                            categories: d.result1.categories
                        },
                        yAxis: {
                            min: 0,
                            title: {
                                text: '启动人次'
                            },
                            stackLabels: {  // 堆叠数据标签
                                enabled: true,
                                style: {
                                    fontWeight: 'bold',
                                    color: (Highcharts.theme && Highcharts.theme.textColor) || 'gray'
                                }
                            }
                        },
                        legend: {
                            align: 'right',
                            x: -30,
                            verticalAlign: 'top',
                            y: 25,
                            floating: true,
                            backgroundColor: (Highcharts.theme && Highcharts.theme.background2) || 'white',
                            borderColor: '#CCC',
                            borderWidth: 1,
                            shadow: false
                        },
                        tooltip: {
                            formatter: function () {
                                return '<b>' + this.x + '</b><br/>' +
                                    this.series.name + ': ' + this.y + '<br/>' +
                                    '总量: ' + this.point.stackTotal;
                            }
                        },
                        plotOptions: {
                            column: {
                                stacking: 'normal',
                                dataLabels: {
                                    enabled: true,
                                    color: (Highcharts.theme && Highcharts.theme.dataLabelsColor) || 'white',
                                    style: {
                                        // 如果不需要数据标签阴影，可以将 textOutline 设置为 'none'
                                        textOutline: '1px 1px black'
                                    }
                                }
                            }
                        },
                        series: d.result1.data
                    });

                    Highcharts.chart('container3', {
                        chart: {
                            type: 'column'
                        },
                        title: {
                            text: '月使用频率折叠图'
                        },
                        xAxis: {
                            categories: d.result2.categories
                        },
                        yAxis: {
                            min: 0,
                            title: {
                                text: '启动人次'
                            },
                            stackLabels: {  // 堆叠数据标签
                                enabled: true,
                                style: {
                                    fontWeight: 'bold',
                                    color: (Highcharts.theme && Highcharts.theme.textColor) || 'gray'
                                }
                            }
                        },
                        legend: {
                            align: 'right',
                            x: -30,
                            verticalAlign: 'top',
                            y: 25,
                            floating: true,
                            backgroundColor: (Highcharts.theme && Highcharts.theme.background2) || 'white',
                            borderColor: '#CCC',
                            borderWidth: 1,
                            shadow: false
                        },
                        tooltip: {
                            formatter: function () {
                                return '<b>' + this.x + '</b><br/>' +
                                    this.series.name + ': ' + this.y + '<br/>' +
                                    '总量: ' + this.point.stackTotal;
                            }
                        },
                        plotOptions: {
                            column: {
                                stacking: 'normal',
                                dataLabels: {
                                    enabled: true,
                                    color: (Highcharts.theme && Highcharts.theme.dataLabelsColor) || 'white',
                                    style: {
                                        // 如果不需要数据标签阴影，可以将 textOutline 设置为 'none'
                                        textOutline: '1px 1px black'
                                    }
                                }
                            }
                        },
                        series: d.result2.data
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
                <label for="timeframe">时间：</label>
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


        <div class="tab">
            <div class="tab-head">
                <strong>频率选择</strong>
                <ul class="tab-nav">
                    <li class="active"><a href="#tab-start" style="text-decoration:none">日启动次数公布</a></li>
                    <li><a href="#tab-css" style="text-decoration:none">周启动次数分布</a></li>
                    <li><a href="#tab-units" style="text-decoration:none">月启动次数分布</a></li>
                </ul>
            </div>
            <div class="tab-body">
                <div class="tab-panel active" id="tab-start">
                    <div id="container1" style="min-width:400px;height:400px"></div>
                </div>
                <div class="tab-panel" id="tab-css">
                    <div id="container2" style="min-width:400px;height:400px"></div>
                </div>
                <div class="tab-panel" id="tab-units">
                    <div id="container3" style="min-width:400px;height:400px"></div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>

