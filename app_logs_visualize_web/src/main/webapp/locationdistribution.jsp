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
    <script src="js/china.js"></script>

    <script src="js/jquery-2.1.4.min.js" type="text/javascript"></script>
    <link href="js/bootstrap-3.3.7-dist/css/bootstrap.css" rel="stylesheet">
    <script src="js/bootstrap-3.3.7-dist/js/bootstrap.js"></script>


    <script>

        function initChart() {
            var myChart = echarts.init(document.getElementById('div-chart'), 'shine');
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
                    grid: {
                        x: 25,
                        y: 45,
                        x2: 5,
                        y2: 20,
                        borderWidth: 1
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
                            data: []

                        },

                    ]
                };
                $.each(d.list, function (i, item) {

                    console.log(item);
                    option.series[0].data.push({"name": item.province, "value": item.count});
                });
                myChart.setOption(option);
            });
        }

        $(function () {
            initChart();
        });
    </script>
</head>
<body>

<div class="container">
    <div class="row">
        <div class="row" id="div-chart" style="width: 1000px;height: 400px;margin-top: 20px"></div>
    </div>
</div>

</body>
</html>
