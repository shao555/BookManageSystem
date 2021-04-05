<%--
  Created by IntelliJ IDEA.
  User: 15278
  Date: 2021/4/1
  Time: 17:04
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>登录</title>



<%--    <script src="${pageContext.request.contextPath}/js/jquery-1.12.4.js"></script>--%>
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="https://ajax.aspnetcdn.com/ajax/jquery/jquery-3.5.1.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/login.js"></script>
    <script type="text/javascript">




    </script>
</head>
<body>

<div id="div1"></div>


<%--<form name="loginForm" method="post" action="${pageContext.request.contextPath}/adminc/login.do" id="mytab">--%>


<%--    <table align="center" border="1px">--%>
<%--        <tr>--%>
<%--            <td>账号</td>--%>
<%--            <td><input type="text" name="admin_Phone" id="admin_Phone"></td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <td>密码</td>--%>
<%--            <td><input type="password" name="admin_Pwd" id="admin_Pwd"></td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <td colspan="2"><input type="submit" value="登录" align="center"></td>--%>

<%--&lt;%&ndash;                <input&ndash;%&gt;--%>
<%--&lt;%&ndash;                    type="reset" value="重置">&ndash;%&gt;--%>

<%--        </tr>--%>
<%--    </table>--%>
<%--</form>--%>


<form style="width:180px" name="loginForm" method="post" action="${pageContext.request.contextPath}/adminc/alogin.do" id="mytab">
    <div class="form-group">
        <label for="admin_Phone">Email address</label>
        <input type="text" class="form-control" name="admin_Phone" id="admin_Phone" aria-describedby="emailHelp">
    </div>
    <div class="form-group">
        <label for="admin_Pwd">Password</label>
        <input type="password" class="form-control" name="admin_Pwd" id="admin_Pwd">
    </div>
    <div class="form-group form-check">
<%--        <input type="checkbox" class="form-check-input" id="exampleCheck1">--%>
<%--        <label class="form-check-label" for="exampleCheck1">Check me out</label>--%>
    </div>
    <button type="submit" class="btn btn-primary">登录</button>
    <button type="button" class="btn btn-primary" onclick="">注册</button>
</form>

</body>
</html>
