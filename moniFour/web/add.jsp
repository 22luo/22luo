<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<style>
    td{
        width: 200px;
        height: 30px;
    }
    .td{
        text-align: right;
        width: 150px;
    }
    input{
        margin-left: 5px;
    }
</style>
<body>
<form action="tbCourseServlet?type=add" method="post">
    <table border="1" style="border-collapse: collapse;margin: auto;">
        <tr>
            <th colspan="2"><添加></添加>信息</th>
        </tr>
        <tr>
            <td class="td">名称：</td>
            <td><input name="name" type="text"></td>
        </tr>
        <tr>
            <td class="td">章节：</td>
            <td><input name="typ" type="text"></td>
        </tr>
        <tr>
            <td class="td">开课时间：</td>
            <td><input name="date" type="date"></td>
        </tr>
        <tr>
            <td class="td">结课时间：</td>
            <td><input name="end" type="date"></td>
        </tr>
        <tr>
            <td class="td">讲师：</td>
            <td><input name="js" type="text"></td>
        </tr>
        <tr>
            <td class="td" style="border: 0;"><input type="submit"></td>
            <td style="border: 0;"><input type="reset"></td>
        </tr>
    </table>
</form>
</body>
</html>
