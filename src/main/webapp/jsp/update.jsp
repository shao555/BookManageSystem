<%--
  Created by IntelliJ IDEA.
  User: 15278
  Date: 2020/11/3
  Time: 8:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>修改</title>
    <script src="${pageContext.request.contextPath}/js/jquery-1.12.4.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/update.js"></script>
</head>

<body>
<form action="${pageContext.request.contextPath}/update.do" method="get" id="mytab">
    <table width="600" align="center" border="1px">
        <tr>
            <td align="center" colspan="2"><h1>修改图书信息</h1></td>
        </tr>
        <tr>
            <td>图书编号</td>
            <td>${b.book_ID}
                <input type="hidden" name="book_ID" value="${b.book_ID}">
            </td>
        </tr>
        <%--        <tr>--%>
        <%--            <td>新闻分类</td>--%>
        <%--            <td>--%>
        <%--                <select name="select" id="select">--%>
        <%--                    <option value="0">全部</option>--%>
        <%--                    <option value="1">军事</option>--%>
        <%--                    <option value="2">国际</option>--%>
        <%--                    <option value="3">国内</option>--%>
        <%--                </select>--%>
        <%--            </td>--%>
        <%--        </tr>--%>
        <tr>
            <td>书名</td>
            <td>
                <input type="text" name="book_Name" id="book_Name" placeholder="${b.book_Name}">
            </td>
        </tr>
        <tr>
            <td>作者</td>
            <td>
                <input type="text" name="book_Author" id="book_Author" placeholder="${b.book_Author}">
            </td>
        </tr>
        <tr>
            <td>出版社</td>
            <td>
                <input type="text" name="book_Publisher" id="book_Publisher" placeholder="${b.book_Publisher}">
            </td>
        </tr>
        <tr>
            <td align="center" colspan="2">
                <input align="center" type="submit" value="提交">
                <input align="center" type="button" value="返回" onclick="ba()">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
