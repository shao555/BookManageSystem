<%--
  Created by IntelliJ IDEA.
  User: 15278
  Date: 2020/11/1
  Time: 19:42
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>主页</title>
    <script src="${pageContext.request.contextPath}/js/jquery-1.12.4.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/show.js"></script>
    <script type="text/javascript">
        function delBook(bookID) {
            var flag = confirm("确定删除?")
            if (flag == true) {
                location.href = "/book/delBook.do?book_ID=" + bookID;
            }
        }




    </script>

    <style type="text/css">
        ul {
            margin: 0 auto;
            text-align: center;
            list-style: none;
            /*display: inline-block;*/

            padding-left: 0;
        }

        li {

            display: inline-block;
            /*width:140px;*/

            heigth: 51px;

            text-align: center;

            margin: 0 auto;

            line-height: 51px;

        }
        #mytab{

            /*display: inline-block;*/
            margin: 0 auto;
        }



    </style>


</head>
<body>

<p align="center"><a href="${pageContext.request.contextPath}/addBook"><input type="button" value="添加"></a></p>
<p align="center">共有&nbsp;${bCount}&nbsp;条结果</p>
<form action="${pageContext.request.contextPath}/findByBookName" method="post">
    <p align="center"><input type="text" id ="book_Name" name="book_Name"> <input type="submit" value="查询"></p>
</form>


<table align="center" border="1px" id="mytab">
    <tr>
        <td colspan="7" align="center"><h1>图书列表</h1></td>
    </tr>
    <tr>
        <td>图书编号</td>
        <td>书名</td>
        <td>作者</td>
        <td>出版社</td>
        <td colspan="3">操作</td>
    </tr>

    <c:forEach items="${blist}" var="b">
        <tr>
            <td>${b.book_ID}</td>
            <td>${b.book_Name}</td>
            <td>${b.book_Author}</td>
            <td>${b.book_Publisher}</td>
            <td><a href="${pageContext.request.contextPath}/update?book_ID=${b.book_ID}"><input type="button"
                                                                                                value="修改"></a></td>
            <td><a href="${pageContext.request.contextPath}/check?book_ID=${b.book_ID}"><input type="button"
                                                                                                value="查看"></a></td>
            <td>
                <input type="button" value="删除" id="book_ID" onclick="delBook(${b.book_ID})">
            </td>
        </tr>
    </c:forEach>

</table>

<ul class="pagination">
    <li><a href="${pageContext.request.contextPath}/show?page=1">首页</a></li>
    <li <c:if test="${pageInfo.pageNum==1}">class="disabled"</c:if>><a
            href="${pageContext.request.contextPath}/show?page=${pageInfo.pageNum-1 }">上一页</a></li>
     <c:forEach begin="1" end="${pageInfo.pages}" step="1" var="pageNo">
    <li <c:if test="${pageInfo.pageNum==pageNo}">class="active"</c:if>>
        <a href="${pageContext.request.contextPath}/show?page=${pageNo}">${pageNo}</a></li>
</c:forEach>
    <li <c:if test="${pageInfo.pageNum==pageInfo.pages}">class="disabled"</c:if>><a
            href="${pageContext.request.contextPath}/show?page=${pageInfo.pageNum+1}">下一页</a></li>
    <li><a href="${pageContext.request.contextPath}/show?page=${pageInfo.pages}">尾页</a></li>
</ul>
</body>
</html>
