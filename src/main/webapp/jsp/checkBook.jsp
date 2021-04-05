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
    <title>查看</title>
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="https://ajax.aspnetcdn.com/ajax/jquery/jquery-3.5.1.min.js"></script>
<%--    <script type="text/javascript" src="${pageContext.request.contextPath}/js/update.js"></script>--%>

    <script type="text/javascript">

        function ba() {
            history.back();
        }
        function delBook(bookID) {
            var flag = confirm("确定要删除这本图书吗?")
            if (flag == true) {
                location.href = "/book/bookc/delBook.do?book_ID=" + bookID;
            }
        }
        function lendBook(bookID) {
            var flag = confirm("确定借阅?")
            if (flag == true) {
                alert("借阅成功")
                location.href = "/book/bookc/lendBook.do?book_ID=" + bookID;
            }
        }


    </script>

</head>

<body>
<form action="${pageContext.request.contextPath}/bookc/update.do" method="get" id="mytab">
    <table width="600" align="center" border="1px">
        <tr>
            <td align="center" colspan="2"><h1>图书信息</h1></td>
        </tr>
        <tr>
            <td>图书编号</td>
            <td>${b.book_ID}
                <input type="hidden" name="book_ID" value="${b.book_ID}">
            </td>
        </tr>
        <tr>
            <td>书名</td>
            <td>
<%--                <input type="text" name="book_Name" id="book_Name" placeholder="${b.book_Name}">--%>
                ${b.book_Name}
            </td>
        </tr>
        <tr>
            <td>作者</td>
            <td>
<%--                <input type="text" name="book_Author" id="book_Author" placeholder="${b.book_Author}">--%>
                ${b.book_Author}
            </td>
        </tr>
        <tr>
            <td>出版社</td>
            <td>
<%--                <input type="text" name="book_Publisher" id="book_Publisher" placeholder="${b.book_Publisher}">--%>
                ${b.book_Publisher}
            </td>
        </tr>
        <tr>




            <td align="center" colspan="2">
<%--                <input align="center" type="submit" value="提交">--%>

    <a href="${pageContext.request.contextPath}/bookc/update?book_ID=${b.book_ID}"><input type="button"
                                                                                    value="修改"></a>
<%--    <a href="${pageContext.request.contextPath}/check?book_ID=${b.book_ID}"><input type="button"--%>
<%--                                                                                   value="借阅"></a>--%>
    <input type="button" value="借阅" id="book_ID" onclick="lendBook(${b.book_ID})">
                <input align="center" type="button" value="返回" onclick="ba()">
    <input type="button"  class="btn btn-danger" value="删除" id="book_ID" onclick="delBook(${b.book_ID})">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
