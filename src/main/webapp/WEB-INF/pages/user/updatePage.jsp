<%--
  Created by IntelliJ IDEA.
  User: wicker
  Date: 2017/6/28
  Time: 10:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户信息修改页面</title>
    <script type="text/javascript" src="../js/jquery-3.2.1.js"></script>
    <script type="text/javascript" src="../js/updatePage.js"></script>
</head>
<body>
<div>用户编号：<input type="text" id="ID"/><input type="submit" value="查询" onclick="queryUser()"/></div>
<div>
    <form action="/mybatisStudy/userManage/updateUser.do">
    <table border="1">
        <tr>
            <td>编号</td>
            <td><input type="text" id="inputId" name="inputId" readonly="readonly"></td>
        </tr>
        <tr>
            <td>姓名</td>
            <td><input type="text" id="username" name="username"></td>
        </tr>
        <tr>
            <td>年龄</td>
            <td><input type="text" id="userage" name="userage"/></td>
        </tr>
    </table>
        <input type="submit" value="修改"/>
    </form>
</div>
</body>
</html>
