
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--//引入c标签--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Document</title>
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

    <%--//遍历数据库的数据--%>
    <c:forEach items="${list}" var="list" varStatus="add">
      <tr style="<c:if test="${list.book_state==1}">background-color: #979797;</c:if>" >
        <td>${add.index+1}</td>
        <td>${list.book_name}</td>
        <td>${list.book_author}</td>
        <td>${list.book_price}</td>
        <td>${list.book_publisher}</td>
        <td><c:if test="${list.book_state==1}">已借出</c:if>
          <c:if test="${list.book_state==0}">未借出</c:if>
        </td>
        <td>${list.add_time}</td>
        <td><a style="<c:if test="${list.book_state==1}">visibility: hidden;</c:if>" href="javascript:void(0);" onclick=test("${list.book_id}")>借阅</a></td>
      </tr>
    </c:forEach>

    <tr class="bor">
      <td></td>
      <td></td>
      <td></td>
      <%--填入数据库有多少条数据--%>
      <td>共计${list.size()}条数据</td>
      <td><a href="add.jsp">添加新书</a></td>
      <td></td>
      <td></td>
      <td></td>
    </tr>
  </table>
</div>
</body>
<script>
  // 判断是否借阅
    function test(id){
        if(confirm("确认借阅")){
            window.location.href="ServletUpdate?var="+id;
        }
    }
</script>
</html>
</html>