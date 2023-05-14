<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2023/5/10
  Time: 15:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="css/add.css">
</head>
<body>
<div id="main">
    <form action="tbSourceServlet?type=add" method="post">
        <table>
            <tr>
                <th colspan="2">添加信息</th>
            </tr>
            <tr>
                <td>名称：</td>
                <td><input type="text" id="name" name="name"></td>
            </tr>
            <tr>
                <td>类型：</td>
                <td><input type="type" id="type" name="name"></td>
            </tr>
            <tr>
                <td>采购时间：</td>
                <td><input type="date" id="buyDate" name="buyDate"></td>
            </tr>
            <tr>
                <td>价格：</td>
                <td><input type="text" id="price" name="price"></td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="添加"/>
                    <input type="reset" value="重置"/>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
