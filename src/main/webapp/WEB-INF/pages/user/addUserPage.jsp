<%--
  Created by IntelliJ IDEA.
  User: wicker
  Date: 2017/6/28
  Time: 10:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加用户页面</title>
</head>
<body>
<form action="/mybatisStudy/userManage/insertUser.do", method="post">
        <table>
            <tr>
                <td>姓名：</td>
                <td><input type="text" name="username"/></td>
            </tr>
            <tr>
                <td>年龄：</td>
                <td><input type="text" name="userage"/></td>
            </tr>
        </table>
        <input type="submit" value="提交"/>
    </form>
</body>
</html>
