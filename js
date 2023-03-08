//登录界面
<script>
var uname = 'admin';
    var upwd = '123456';
    function A() {
        if ($(":text").val() == uname && $(":password").val() == upwd) {
            return true;
        } else if ($(":text").val() == "") {
            alert('账号不能为空!');
            return false;
        } else if ($(":password").val() == "") {
            alert('密码不能为空!');
            return false;
        } else if ($(":text").val() != uname || $(":password").val() != upwd) {
            alert('账号或密码不正确!');
            return false;
        }

    }

</script>
     <form class="w-50" style="margin:auto" method="get" action="index.html"onsubmit="return A()">



//主页面

<script>
        $(function () {
            $(".gr").hover(function () {
                $(this).next('ul').slideToggle();
            })

            $(".btn-buy:button").click(function () {

                $tr = $(
                    `<tr>
                        <td><input type="checkbox" onchange="checkChange(this)"></td>
                        <td>${$(this).prev().find('label').html()}</td>
                        <td>${$(this).prev().find('p').next('p').find('label').html()}</td>
                        <td>${$(this).prev('div').find('p').next('p').next('p').html().replace('惊爆价：￥', '')}</td>
                        <td>1</td>
                        <td>${$(this).prev('div').find('p').next('p').next('p').html().replace('惊爆价：￥', '')}</td>
                        <td><a href=" " onclick="del(this)">删除</a ></td>
                    </tr>`


                )
                $(".ShoppingCart table").append($tr);

            })
    //全选
            $(".CheckAll").click(function () {
                if ($(this).prop('checked')) {
                    $(".ShoppingCart :checkbox:not(.CheckAll)").prop('checked', true);
                } else {
                    $(".ShoppingCart :checkbox:not(.CheckAll)").prop('checked', false);
                }
                checkChanged();
            })
            // 批量删除
            $(".delel").click(function () {
                $(".ShoppingCart :checkbox:not(.CheckAll)").parent().parent().remove();
                checkChanged();
            })

        });

// 取消全选
        function checkChange(obj) {
            if ($(obj).prop('checked')) {
                $(obj).parent().parent().addClass('bgc');
            } else {
                $(obj).parent().parent().removeClass('bgc');
            }
            if ($(".ShoppingCart table input:checked").length == $(".ShoppingCart table input").length) {
                $(".CheckAll").prop('checked', true);
            } else {
                $(".CheckAll").prop('checked', false);
            }
        }

        function del(obj) {
            $(obj).parent().parent().remove();
            return false;
        }
      
    </script>
