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
  <script src="js/jquery-3.5.1.min.js"></script>
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
    tr:hover:not(.bor){
      background-color: #f32323;
    }
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
      <th colspan="9"><h2>社区人员概率系统</h2></th>
    </tr>
    <tr class="bor">
      <th>编号</th>
      <th>姓名</th>
      <th>性别</th>
      <th>出生日期</th>
      <th>身份证号码</th>
      <th>现住地</th>
      <th>是否为本地户口</th>
      <th>登记时间</th>
      <th>操作</th>
    </tr>

    <c:forEach var="o" items="${list}" varStatus="sta">
          <tr>
            <td>${sta.index+1}</td>
            <td>${o.name}</td>
            <td>${o.sex}</td>
            <td>${o.birthday}</td>
            <td>${o.cardno}</td>
            <td>${o.address}</td>
            <td><c:if test="${o.isLocal==1}">是</c:if>
              <c:if test="${o.isLocal==0}">否</c:if>
            </td>
            <td>${o.writeTime}</td>
            <td><a href="javascript:void(0)" onclick=del("${o.id}")>删除</a></td>
          </tr>
    </c:forEach>
    <script>
      function del(id) {
        if(confirm("您确定要删除？")){
        window.location.href="tbSourceServlet?type=del&id="+id;
        }
      }
    </script>
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
      <td></td>
      <td>共计${list.size()}条数据</td>
      <td><a href="add.jsp">新人员录入</a></td>
      <td></td>
      <td></td>
      <td></td>
    </tr>
  </table>
</div>
</body>
</html>