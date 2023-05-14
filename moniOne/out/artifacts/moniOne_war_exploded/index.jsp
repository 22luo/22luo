
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="css/index.css">
    <script src="js/jquery-3.5.1.min.js"></script>
    <script>
        function like() {
            $("#one").submit();
        }

        function del(id) {
            if(confirm("您真的的要删除这条数据吗？")){
                window.location.href="tbSourceServlet?type=del&id="+id;
            }
            //提交id进行删除

        }

    </script>
</head>
<body>
<div id="main">
    <fieldset>
        <legend>搜索</legend>
        <form id="one" action="tbSourceServlet?type=like" method="post">
            名称：<input id="name" name="name" type="text" value="${name}" onblur="like()"/>
        </form>
    </fieldset>
    <table>
        <tr>
            <th>编号</th>
            <th>名称</th>
            <th>类型</th>
            <th>采购时间</th>
            <th>价格</th>
            <th>操作</th>
        </tr>
        <c:forEach var="o" items="${list}" varStatus="sta">
            <tr>
                <td>${sta.index+1}</td>
                <td>${o.name}</td>
                <td>${o.type}</td>
                <td>${o.buyDate}</td>
                <td>${o.price}</td>
                <td><a href="javascript:void(0)" onclick="del(${o.id})">删除</a></td>
            </tr>
        </c:forEach>

        <tr>
            <td colspan="6">
                <a href="add.jsp">新增</a>
                共计${list.size()}条数据
            </td>
        </tr>
    </table>
</div>
</body>
</html>
