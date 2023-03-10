//登录界面
  <script>
        //声明账号密码
        var uname='123456';
        var upwd='123';
        function A() {
            //校验账号密码是否正确
        if ($(":text").val() == uname && $(":password").val() == upwd) {
            return true;
            //校验账号是否为空
        } else if($(":text").val() == ""){
            alert("账号不能为空");
            return false;
            //校验密码是否为空
        } else if($(":password").val() == ""){
            alert("密码不能为空");
            return false;
            //校验输入框密码是否正确            
        } else if($(":text").val() != uname || $(":password").val() != upwd){
            alert('账号密码不正确');
            return false;
        }
        
    }
    </script>
     <form class="w-50" style="margin:auto" method="get" action="index.html"onsubmit="return A()">



//主页面

<script>
        $(function(){
            //鼠标移动到“个人中心”显示二级菜单,鼠标移出时隐藏,滑动效果
            $(".a").hover(function(){
                $(this).next('ul').slideToggle();
            })

             //点击首页时隐藏购物车
             $(".FirstPage").click(function(){
                //显示首页
                $("#goodscard").show();
                //隐藏购物车
                $(".gwclb").hide();
            })
             //点击购物车时隐藏首页
             $(".ShopCar").click(function(){
                //隐藏首页
                $("#goodscard").hide();
                //显示购物车
                $(".gwclb").show();
            })

            //点击【去下单】按钮，弹出提示框，订单编号固定写“1666921191341”,订单日期取当前日期，日期格式：年-月-日
            $("#xiadan").click(function(){
                var date=new Date();
                var a=`订单编号:1666921191341 下单时间:${date.getFullYear()}年${date.getMonth()}月${date.getDate()}日`
                alert(a);
            })

            //点击【购买】，在表格尾部新增一条数据，正确添加名称、产地、惊爆价
            $(".btn-buy").click(function(){
                $tr=$(`<tr>
                    <td><input type="checkbox"></td>
                        <td>${$(this).prev('div').find('p').find('label').html()}</td>
                        <td>${$(this).prev('div').find('p').next('p').find('label').html()}</td>
                        <td>${$(this).prev('div').find('p').next('p').next('p').html().replace('惊爆价：￥', '')}</td>
                        <td>1</td>
                        <td>${$(this).prev('div').find('p').next('p').next('p').html().replace('惊爆价：￥', '')}</td>
                        <td><a href="javascript:void(0)" onclick="del(this)">删除</a></td>
                </tr>`)
                $(".ShoppingCart table").append($tr);
            })

            $(".nav-menu-item Menus").click(function(){
            $(".nav-menu-item Menus").removeClass('bgc');
            $(this).addClass('bgc');

        })
            //全选
            $(".CheckAll").click(function(){
                if($(this).is(':checked')){
                    $(".ShoppingCart :checkbox:not(.CheckAll)").prop('checked',true)
                }else{
                    $(".ShoppingCart :checkbox:not(.CheckAll)").prop('checked',false)
                }
            })
        // 批量删除
            $(".sc").click(function(){
                alert('是否全部删除');
                $(".ShoppingCart :checked:not(.CheckAll)").each(function(){
 
                    $(this).parent().parent().remove();
                    
                })
            })

        })
        // 单个删除
        function del(shanchu){
            if(confirm('是否删除')){
                $(shanchu).parent().parent().remove();
            }
        }


        
    </script>
