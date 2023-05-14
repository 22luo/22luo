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
        height: 30px;
    }
    .td{
        text-align: right;
    }
    input{
        margin-left: 5px;
    }
</style>
<body>
       <%--//action="ServletInsert"--%>
<form style="border:1px solid red;width: 25%;margin: auto" action="ServletInsert" method="post" onsubmit="return test()">
    <table width="100%" style="border-collapse: collapse;margin: auto;">
        <tr>
            <th colspan="2" style="font-size: 25px">新图书录入</th>
        </tr>
        <tr>
            <td class="td">书名：</td>
            <td><input name="name" type="text">(必填)</td>
        </tr>
        <tr>
            <td class="td">作者：</td>
            <td><input name="zz" type="text">(必填)</td>
        </tr>
        <tr>
            <td class="td">价格：</td>
            <td><input name="price" type="text">(必填)</td>
        </tr>
        <tr>
            <td class="td">出版社：</td>
            <td><input name="cbs" type="text"></td>
        </tr>
        <tr>
            <td class="td" style="border: 0;"><input  type="submit" value="保存图书"></td>
            <td style="border: 0;"><input type="reset" value="清空表单"></td>
        </tr>
    </table>
</form>
</body>
<script>
    // 校验数据完整
       function test(){
           if(document.getElementsByName("name")[0].value==""){
               alert("请输入书名")
                return false;
           }
           if(document.getElementsByName("zz")[0].value==""){
               alert("请输入作者")
                   return false;
           }
           if(document.getElementsByName("price")[0].value==""){
               alert("请输入现价格")
                      return false;
           }
       }
</script>
</html>
