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
<form style="border:1px solid red;width: 25%;margin: auto" action="ServletInsert" method="post" onsubmit="return test()">
    <table width="100%" style="border-collapse: collapse;margin: auto;">
        <tr>
            <th colspan="2" style="font-size: 25px">社区人员录入</th>
        </tr>
        <tr>
            <td class="td">姓名：</td>
            <td><input name="name" type="text">(必填)</td>
        </tr>
        <tr>
            <td class="td">性别：</td>
            <td><input name="sex" type="radio" value="男" checked="checked">男
                <input name="sex" type="radio" value="女">女
            </td>
        </tr>
        <tr>
            <td class="td">生日：</td>
            <td><input name="date" type="date"></td>
        </tr>
        <tr>
            <td class="td">身份证号码：</td>
            <td><input name="sfz" type="text">(必填)</td>
        </tr>
        <tr>
            <td class="td">现居地：</td>
            <td><input name="xjd" type="text">(必填)</td>
        </tr>
        <tr>
            <td class="td">是否为本地户口：</td>
            <td><input name="hk" type="radio" value="1" checked="checked">是
                <input name="hk" type="radio" value="0">否
            </td>
        </tr>
        <tr>
            <td class="td" style="border: 0;"><input  type="submit" value="确认录入"></td>
            <td style="border: 0;"><input type="reset" value="清空表单"></td>
        </tr>
    </table>
</form>
</body>
<script>
       function test(){
           if(document.getElementsByName("name")[0].value==""){
               alert("请输入名称")
                return false;
           }
           if(document.getElementsByName("sfz")[0].value==""){
               alert("请输入身份证")
                   return false;
           }
           if(document.getElementsByName("xjd")[0].value==""){
               alert("请输入现居地")
                      return false;
           }
       }
</script>
</html>
