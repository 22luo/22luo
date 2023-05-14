<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/4/6
  Time: 14:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Document</title>
  <script src="js/jquery-3.5.1.min.js">
  </script>
  <style>
    /* *{
        padding: 0px;
        margin: 0px;
    } */
    table{
      width: 100%;
      margin-top: 4px;
      border: 1px solid black;
      border-collapse: collapse;
    }
    /*tr:hover:not(.bor){*/
      /*background-color: #979797;*/

    /*}*/
    .bor td{
      border: 0;
      text-align: center;
    }
  </style>
</head>
<body>
<div style="width: 55%;">
  <table border="2">
    <tr class="bor">
      <th colspan="8"><h2>社区人员概率系统</h2></th>
    </tr>
    <tr class="bor">
      <th>编号</th>
      <th>书名</th>
      <th>作者</th>
      <th>价格</th>
      <th>出版社</th>
      <th>图书状态</th>
      <th>添加时间</th>
      <th>操作</th>
    </tr>
    <c:forEach var="o" items="${list}" varStatus="sta">
          <tr style="<c:if test="${o.book_state==1}">background-color:#7d7976;</c:if>">
            <td>${sta.index+1}</td>
            <td>${o.book_name}</td>
            <td>${o.book_author}</td>
            <td>${o.book_price}</td>
            <td>${o.book_publisher}</td>
            <td><c:if test="${o.book_state==1}">已借出</c:if>
              <c:if test="${o.book_state==0}">未借出</c:if>
            </td>
            <td>${o.add_time}</td>
            <td><a style="<c:if test="${o.book_state==1}">visibility: hidden;</c:if>" href="javascript:void(0);" onclick=jy("${o.book_id}")>借阅</a></td>
          </tr>
    </c:forEach>
<%--    <tr>--%>
<%--      <td>1</td>--%>
<%--      <td>A4纸</td>--%>
<%--      <td>办公类型</td>--%>
<%--      <td>2021-2-4</td>--%>
<%--      <td>300</td>--%>
<%--      <td><a href="javascript:void(0);" onclick="test(${id})">删除</a></td>--%>
<%--    </tr>--%>
    <tr class="bor">
      <td></td>
      <td></td>
      <td></td>
      <td>共计${list.size()}条数据</td>
      <td><a href="add.jsp">添加新书</a></td>
      <td></td>
      <td></td>
      <td></td>
    </tr>
  </table>
  <script>
    function jy(book_id) {
      if(confirm("你真的要借阅吗？")){
        window.location.href="tbBookServlet?type=update&id="+book_id;
      }
    }
  </script>
</div>
</body>

</html>