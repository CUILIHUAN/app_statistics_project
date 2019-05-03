<%--
  Created by IntelliJ IDEA.
  User: cui
  Date: 2019/5/3
  Time: 14:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <link href="css/common.css" rel="stylesheet">
    <script src="js/jquery-2.1.4.min.js"></script>
    <script src="js/echarts.js"></script>

    <%--<script src="js/trend.js"></script>--%>

    <script>
        $(function () {

            $.getJSON("stat/eachtimeinfo", function (d) {
                console.log(d);
                //传染病发病趋势
                var lineChart1 = echarts.init(document.getElementById('lineChart1'));
                lineChart1.setOption({
                    title: {
                        text: '各个时度启动次数趋势',
                        textStyle:{
                            fontSize:16,
                            color:'#ff7f50'
                        },
                    },
                    color:["#ff7f50"],
                    grid:{
                        left: '15%',
                        right: '5%',
                        bottom: '15%',

                    },
                    tooltip : {
                        trigger: 'item',
                        formatter: "{a}<br/>{b}时<br/>{c}人"
                    },

                    calculable : true,
                    yAxis: [
                        {
                            type: 'value',
                            axisLine:{
                                lineStyle:{
                                    color: '#ff7f50'
                                },
                            },
                            splitLine: {
                                "show": false
                            },
                            axisLabel: {
                                textStyle: {
                                    color: '#fff'
                                },
                                formatter: function (value) {
                                    return value + ""
                                },
                            },
                        }
                    ],
                    xAxis: [
                        {
                            type: 'category',
                            data : d.data,
                            boundaryGap : false,
                            axisLine:{
                                lineStyle:{
                                    color: '#ff7f50'
                                },
                            },
                            splitLine: {
                                "show": false
                            },
                            axisLabel: {
                                // interval:0,
                                // rotate:40,
                                textStyle: {
                                    color: '#fff'
                                },
                                formatter: function (value) {
                                    return value + ""
                                },
                            },
                        }
                    ],
                    series : [
                        {
                            name:'启动次数',
                            type:'line',
                            smooth:true,
                            itemStyle: {normal: {areaStyle: {type: 'default'}}},
                            data:d.dateStartUp
                        },
                    ]

                })


                //疾病发病趋势
                var lineChart2 = echarts.init(document.getElementById('lineChart2'));
                lineChart2.setOption({
                    title: {
                        text: '每个时刻增加人数趋势',
                        textStyle:{
                            fontSize:16,
                            color:'#32cd32'
                        },
                        x:"center"
                    },
                    color:["#32cd32"],
                    grid:{
                        left: '15%',
                        right: '5%',
                        bottom: '25%',

                    },
                    tooltip : {
                        trigger: 'item',
                        formatter: "{a}<br/>{b}<br/>{c}人"
                    },

                    calculable : true,
                    yAxis: [
                        {
                            type: 'value',
                            axisLine:{
                                lineStyle:{
                                    color: '#32cd32'
                                },
                            },
                            splitLine: {
                                "show": false
                            },
                            axisLabel: {
                                textStyle: {
                                    color: '#fff'
                                },
                                formatter: function (value) {
                                    return value + ""
                                },
                            },
                        }
                    ],
                    xAxis: [
                        {
                            type: 'category',
                            data :d.data,
                            boundaryGap : false,
                            axisLine:{
                                lineStyle:{
                                    color: '#32cd32'
                                },
                            },
                            splitLine: {
                                "show": false
                            },
                            axisLabel: {
                                // interval:0,
                                // rotate:40,
                                textStyle: {
                                    color: '#fff'
                                },
                                formatter: function (value) {
                                    return value + ""
                                },
                            },
                        }
                    ],
                    series : [
                        {
                            name:'增加人数',
                            type:'line',
                            smooth:true,
                            itemStyle: {normal: {areaStyle: {type: 'default'}}},
                            data: d.dateAddUsers
                        },
                    ]

                })

                $("#allUsers").html(d.allUsers);
                $("#allStartUp").html(d.allStartUp);
                $("#todayAddUsers").html(d.todayAddUsers);
                $("#addUsersRate").html(d.addUsersRate+"%");
                $("#todayOfStartUpNums").html(d.todayOfStartUpNums);
                $("#addStartUpRate").html(d.addStartUpRate + "%");

            });

        });
    </script>
</head>
<body style="height: 800px">
!--顶部-->
<header class="header left">
    <div class="left nav">
        <ul>
            <li><i class="nav_1"></i><a href="main.jsp">后台详细页面</a> </li>
        </ul>
    </div>
    <div class="header_center left" style="position:relative">

        <h2><strong>数据实时统计展示</strong></h2>

    </div>

</header>
<!--内容部分-->
<div class="con left">
    <!--数据总概-->
    <div class="con_div">
        <div class="con_div_text left">
            <div class="con_div_text01 left">
                <img src="images/info_7.png" class="left text01_img"/>
                <div class="left text01_div">
                    <p>累计用户人数</p>
                    <p id="allUsers">1235</p>
                </div>
            </div>
            <div class="con_div_text01 right">
                <img src="images/info_8.png" class="left text01_img"/>
                <div class="left text01_div">
                    <p>累计启动次数</p>
                    <p id="allStartUp">235</p>
                </div>
            </div>
        </div>
        <div class="con_div_text left">
            <div class="con_div_text01 left">
                <img src="images/info_9.png" class="left text01_img"/>
                <div class="left text01_div">
                    <p>新增用户(今日)</p>
                    <p class="sky" id="todayAddUsers">56</p>
                </div>
            </div>
            <div class="con_div_text01 right">
                <img src="images/info_10.png" class="left text01_img"/>
                <div class="left text01_div">
                    <p>同比昨日</p>
                    <p class="sky" id="addUsersRate">12%</p>
                </div>
            </div>
        </div>
        <div class="con_div_text left">

            <div class="con_div_text01 left">
                <img src="images/info_11.png" class="left text01_img"/>
                <div class="left text01_div">
                    <p>启动次数(今日)</p>
                    <p class="org" id="todayOfStartUpNums">1234</p>
                </div>
            </div>
            <div class="con_div_text01 right">
                <img src="images/info_12.png" class="left text01_img"/>
                <div class="left text01_div">
                    <p>同比昨日</p>
                    <p class="org" id="addStartUpRate">8%</p>
                </div>
            </div>
        </div>
    </div>

</div>

<!--内容部分-->
<div class="con left" style="width:50%;margin-top:-30px">
    <!--统计分析图-->
    <div class="div_any">
        <div class="left div_any01" style="width:100%;">
            <div class="div_any_child" style="width:98%;position:relative;height: 420px;">
                <div class="div_any_title"><img src="images/title_13.png">各时段的启动次数</div>
                <div id="lineChart1"  style="width: 100%;display: inline-block;height: 400px;margin-top: 15px;"></div>
            </div>
        </div>


    </div>
</div>

<div class="con right" style="width:50%;margin-top:-30px" >
    <div class="div_any" >
        <div class="left div_any01" style="width:100%;">
            <div class="div_any_child" style="width:98%;position:relative;height: 420px;">
                <div class="div_any_title"><img src="images/title_17.png">各时段的新增人数</div>
                <div id="lineChart2"  style="width: 100%;display: inline-block;height: 400px;margin-top: 40px;"></div>

            </div>
        </div>

    </div>
</div>

</body>
</html>
