
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
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
      /*background-color: #f32323;*/
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
    <c:forEach items="${list}" var="list" varStatus="index">
<%--      <fmt:parseDate value="${list.writeTime}" pattern="yyyy-MM-dd" var="ddd"/>--%>
<%--      <fmt:formatDate value="${ddd}" pattern="yyyy-MM-dd HH:mm:ss" var="date"/>--%>
<%--      <c:forTokens items="${list.writeTime}" delims="T" var="name">${name}</c:forTokens>--%>
      <tr style="<c:if test="${list.isLocal==0}">background-color: #f32323;</c:if>">
        <td>${index.index+1}</td>
        <td>${list.name}</td>
        <td>${list.sex}</td>
        <td>${list.birthday}</td>
        <td>${list.cardno}</td>
        <td>${list.address}</td>
        <td><c:if test="${list.isLocal==1}">是</c:if>
          <c:if test="${list.isLocal==0}">否</c:if>
        </td>
        <td>
          <c:set var="string2" value="${fn:split(list.writeTime,'T')}" />
<%--          <c:set var="string3" value="${fn:join(string2, ' ')}" />--%>
          ${fn:join(string2, ' ')}
        </td>
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
<script>
    function test(id){
        if(confirm("确认删除")){
            window.location.href="ServletDelect?var="+id;
        }
    }
</script>
</html>