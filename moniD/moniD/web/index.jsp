
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    tr:hover:not(#bor){
      background-color: black;
      color: white;
    }
    #bor td{
      border: 0;
      text-align: center;
    }
  </style>
</head>
<body>
<div style="width: 30%;">
  <fieldset style="width: 95%;">
    <form action="ServletSelect?var=1" method="post">
    <legend>搜索</legend>
    课程名称：<input name="inpu" type="text">
    </form>
  </fieldset>
  <table border="2">
    <tr style="background-color: rgb(122, 122, 122);color: white;">
      <th>编号</th>
      <th>课程名称</th>
      <th>章节</th>
      <th>开课时间</th>
      <th>结课时间</th>
      <th>讲师</th>
      <th>操作</th>
    </tr>
    <c:forEach items="${list}" var="list" varStatus="inde">
      <tr>
        <td>${inde.index+1}</td>
        <td>${list.name}</td>
        <td>${list.count}</td>
        <td>${list.startDate}</td>
        <td>${list.endDate}</td>
        <td>${list.teacher}</td>
        <td><a href="javascript:void(0);" onclick=test("${list.id}")>删除</a></td>
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
    <tr id="bor">
      <td></td>
      <td></td>
      <td></td>
      <td></td>
      <td></td>
      <td><a href="add.jsp">新增</a></td>
      <td>共计${list.size()}条数据</td>
    </tr>
  </table>
</div>
</body>
<script>
    function test(id){
        if(confirm("确认删除")){
            window.location.href="ServletDelect?var="+id;
        }

    }
</script>
</html>