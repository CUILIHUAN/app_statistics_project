<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>基于Hadoop的手机APP日志数据分析系统</title>
    <link rel="stylesheet"
          href="//apps.bdimg.com/libs/jqueryui/1.10.4/css/jquery-ui.min.css">
    <link rel="stylesheet" href="css/init.css">
    <script src="//apps.bdimg.com/libs/jquery/1.10.2/jquery.min.js"></script>
    <script src="//apps.bdimg.com/libs/jqueryui/1.10.4/jquery-ui.min.js"></script>
    <script src="js/echarts.js"></script>
    <script src="js/china.js"></script>
    <script>
        $(function () {
            //手风琴特效
            $("#accordion").accordion();

            //菜单鼠标悬停
            $("#accordion a").mouseenter(function () {
                //重置所有连接的颜色
                $("#accordion a").css("background-color", "white");
                $(this).css("background-color", "#EAEAEA");
            });

            //鼠标移除
            $("#accordion a").click(function () {
                //重置所有连接的颜色
                $("#accordion a").css("color", "#6a6a6a");
                $(this).css("background-color", "#EAEAEA");
                $(this).css("color", "#3DA1A7");
            });

            $("#a_newusers").click(function () {
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
            });

            $("#a_activeusers").click(function () {

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
            });

            $("#a_silenceusers").click(function () {
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
            });

            $("#a_startupnum").click(function () {
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


            });

            $("#a_locationdistribution").click(function () {
                var myChart = echarts.init(document.getElementById('div-chart'), 'shine');

                function randomData() {
                    return Math.round(Math.random() * 1000);
                }

                $.getJSON("stat/provinceofnum", function (d) {
                    var option = {
                        title: {
                            text: '使用人数的分布',
                            subtext: '中国大陆地区',
                            left: 'center'
                        },
                        tooltip: {
                            trigger: 'item'
                        },
                        legend: {

                            orient: 'vertical',
                            left: 'left',
                            data: ['每省的人数']
                        },
                        grid:{
                            x:25,
                            y:45,
                            x2:5,
                            y2:20,
                            borderWidth:1
                        },
                        visualMap: {
                            min: 0,
                            max: d.maxnum,
                            left: 'left',
                            top: 'bottom',
                            text: ['高', '低'],   // 文本，默认为数值文本
                            calculable: true
                        },
                        toolbox: {
                            show: true,
                            feature: {
                                mark: {show: true},
                                restore: {show: true},
                                saveAsImage: {show: true}
                            }
                        },
                        series: [
                            {
                                itemStyle: {
                                    normal: {
                                        color: function (params) {
                                            var colorList = [
                                                '#f04834', '#B5C334', '#FCCE10', '#E87C25', '#27727B',
                                                '#FE8463', '#9BCA63', '#FAD860', '#F3A43B', '#60C0DD',
                                                '#D7504B', '#C6E579', '#F4E001', '#F0805A', '#3378c0'
                                            ];
                                            return colorList[params.dataIndex]
                                        },

                                    }
                                },
                                name: '每省的人数',
                                type: 'map',
                                mapType: 'china',
                                roam: false,
                                label: {
                                    normal: {
                                        show: true
                                    },
                                    emphasis: {
                                        show: true
                                    }
                                },
                                data: [
                                ]

                            },

                        ]
                    };
                    $.each(d.list, function (i, item) {

                        console.log(item);
                        option.series[0].data.push( {"name": item.province,"value": item.count});
                    });
                    myChart.setOption(option);
                });

            });
        });
    </script>

</head>
<body>
<div id="div-top">
    <ul>
        <li><a href="#"> </a></li>
        <li><a href="#">首页</a></li>
        <li><a href="#">产品</a></li>
        <li><a href="#">报告</a></li>
        <li><a href="#">开发者中心</a></li>
        <li><a href="#">论坛</a></li>
        <li><a href="#">活动</a></li>
    </ul>
</div>
<div id="div-banner">
    <form action="" method="post">
        <select name="appid" id="appidselect">
            <option value="sdk34734">微信</option>
            <option value="sdk34735">QQ</option>
            <option value="sdk34736">UC</option>
        </select>
    </form>
    <ul>
        <li><a href="#">统计分析</a></li>
        <li><a href="#">组件</a></li>
        <li><a href="#">管理</a></li>
    </ul>
</div>
<div id="accordion">
    <h3>概况</h3>
    <div>
        <a href="#">实时统计</a>
        <a id="a_locationdistribution" href="javascript:">整体分析</a>
    </div>
    <h3>用户分析</h3>
    <div>
        <a id="a_newusers" href='javascript:'>新增用户</a>
        <a id="a_activeusers" href="javascript:">活跃用户</a>
        <a id="a_silenceusers" href="javascript:">沉默用户</a>
        <a id="a_startupnum" href="javascript:">启动次数</a>
        <a href="a_version">版本分布</a>
    </div>
    <h3>用户构成</h3>
    <div>
        <a href="#">周用户构成</a>
        <a href="#">用户成分转化</a>
        <a href="#">变化系数分析</a>
    </div>
    <h3>留存分析</h3>
    <div>
        <a href="#">留存用户</a>
        <a href="#">用户新鲜度</a>
        <a href="#">用户活跃度</a>
    </div>
</div>
<div id="div-stat-header">
    新增用户趋势
</div>
<div id="div-chart">

</div>
<script type="application/javascript">
    // 基于准备好的dom，初始化echarts实例

    // 指定图表的配置项和数据


</script>
</body>
</html>
