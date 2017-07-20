<%--
  Created by IntelliJ IDEA.
  User: wicker
  Date: 2017/7/20
  Time: 14:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>首页</title>
    <link rel="stylesheet" type="text/css" href="/easyuiLayout/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="/easyuiLayout/themes/icon.css">
    <script type="text/javascript" src="/easyuiLayout/js/jquery.min.js"></script>
    <script type="text/javascript" src="/easyuiLayout/js/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="/easyuiLayout/js/firstPage.js"></script>
</head>
<body class="easyui-layout" onload="onLoad()">
<div region="north" border="false" class="rtitle">
    jQuery EasyUI RSS Reader Demo
</div>
<div region="west" title="系统菜单" split="true" border="false" style="width:200px;background:#EAFDFF;">
    <ul id="catalogTree"/>
</div>
<div region="center" border="false">
    <div class="easyui-layout" fit="true">
        <div region="north" split="true" border="false" style="height:200px">
      eeee
        </div>
        <div region="center" border="false" style="overflow:hidden">
            <iframe id="cc" scrolling="auto" frameborder="0" style="width:100%;height:100%"></iframe>
        </div>
    </div>
</div>
</body>
</html>
