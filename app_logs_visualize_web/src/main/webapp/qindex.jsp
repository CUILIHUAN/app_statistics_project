<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<title>后台管理中心</title>
<link rel="stylesheet" href="css/pintuer.css">
<link rel="stylesheet" href="css/admin.css">
</head>
<body style="background-color:#f2f9fd;">
<div class="header bg-main">
    <div class="logo margin-big-left fadein-top">
        <h1><img src="images/y.jpg" class="radius-circle rotate-hover" height="50" alt="" />手机APP日志信息分析系统</h1>
    </div>
    <div class="head-l"><a class="button button-little bg-green" href="qindex.jsp" target="_blank">
        <span class="icon-home"></span> 前台首页</a> &nbsp;&nbsp;<a href="##" class="button button-little bg-blue">
        <span class="icon-wrench"></span> 清除缓存</a> &nbsp;&nbsp;<a class="button button-little bg-red" href="../index.jsp">
        <span class="icon-power-off"></span> 退出登录</a>
    </div>
</div>
<div class="leftnav">
    <div class="leftnav-title"><strong><span class="icon-list"></span>菜单列表</strong></div>

    <h2><span class="icon-pencil-square-o"></span>概括</h2>
    <ul style="display:none">
        <li><a href="noshowroom.jsp" target="right"><span class="icon-caret-right"></span>实时统计</a></li>
        <li><a href="locationdistribution.jsp" target="right"><span class="icon-caret-right"></span>使用位置分布</a></li>
    </ul>

    <h2><span class="icon-search"></span>用户分析</h2>
    <ul style="display:none">
        <li><a href="newusers.jsp" target="right"><span class="icon-caret-right"></span>新增用户</a></li>
        <li><a href="activeusers.jsp" target="right"><span class="icon-caret-right"></span>活跃用户</a></li>
        <li><a href="silenceusers.jsp" target="right"><span class="icon-caret-right"></span>沉默用户</a></li>
        <li><a href="startupnums.jsp" target="right"><span class="icon-caret-right"></span>启动次数</a></li>
        <li><a href="exchangeroom.jsp" target="right"><span class="icon-caret-right"></span>版本分布</a></li>
    </ul>

    <h2><span class="icon-user"></span>用户构成</h2>
    <ul>
        <li><a href="searchvipinfo.jsp" target="right"><span class="icon-caret-right"></span>周用户构成</a></li>
        <li><a href="addvip.jsp" target="right"><span class="icon-caret-right"></span>用户成分转化</a></li>
        <li><a href="addvip.jsp" target="right"><span class="icon-caret-right"></span>变化系数分析</a></li>
    </ul>

    <h2><span class="icon-shopping-cart"></span>留存分析</h2>
    <ul>
        <li><a href="retentionanalysis.jsp" target="right"><span class="icon-caret-right"></span>留存用户</a></li>
        <li><a href="searchgoodsinfo.jsp" target="right"><span class="icon-caret-right"></span>用户新鲜度</a></li>
        <li><a href="searchgoodsinfo.jsp" target="right"><span class="icon-caret-right"></span>用户活跃度</a></li>
    </ul>

</div>


<ul class="bread">
    <li><a href="index.jsp" target="right" class="icon-home"> 首页</a></li>
    <li><a href="##" id="a_leader_txt">网站信息</a></li>
</ul>
<div class="admin">
    <iframe scrolling="auto" rameborder="0" src="index.jsp" name="right" width="100%" height="100%"></iframe>
</div>

    <%--js开始的部分--%>
    <script src="js/jquery-2.1.4.min.js"></script>
    <script type="text/javascript">
        $(function(){
            $(".leftnav h2").click(function(){
                $(this).next().slideToggle(200);
//                $(this).toggleClass("on");
            })
            $(".leftnav ul li a").click(function(){
                $("#a_leader_txt").text($(this).text());
                $(".leftnav ul li a").removeClass("on");
                $(this).addClass("on");
            })
        });
    </script>
    <%--js结束的部分--%>
</body>

</html>
