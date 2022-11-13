<script>
        //声明一个数组存放级联数据
        var arr = [];
        arr['广西省'] = ['来宾市', '南宁市', '百色市'];
        arr['广东省'] = ['什么市', '不知道', '有啥啊'];
        //初始化省份
        function initCity() {
            for (var i in arr) {
                $option = $(`<option value = ${i}>${i}</option>`);
                $("#city").append($option);
            }
        }
        //初始化城市
        function initShi(a) {
            //清空城市下拉框
            $("#shi").html("");
            for (var i in arr[a]) {
                //模板字符串
                $option = $(`<option value = ${arr[a][i]}>${arr[a][i]}</option>`);
                $("#shi").append($option);
            }
        }
        $(function () {

            $("#city").change(function () {
                initShi($(this).val());
            })
            //调用统计函数
            totoal();
            //鼠标点击li标签添加对应样式
            $(".nav-menu-item").click(function () {
                //去除原有样式
                $(".nav-menu-item").removeClass("style");
                //添加样式
                $(this).addClass("style");
            })
            //鼠标悬浮时展示下拉框
            $(".nav-menu-item").hover(function () {
                $(this).find("ul").slideToggle(1000);
            })
            //切换
            $(".nav-menu-item:eq(0)").click(function () {
                //显示首页
                $(".container").eq(1).show();
                //隐藏购物车
                $(".container").eq(2).hide();
            })
            //切换
            $(".nav-menu-item:eq(1)").click(function () {
                //隐藏首页
                $(".container").eq(1).hide();
                //显示购物车
                $(".container").eq(2).show();
            })
            //为所有图片绑定单击事件
            $("#content dt").click(function () {
                $tr = $(`<tr>
                        <td><input type="checkbox" onchange="checkChange(this)"></td>
                        <td>${$(this).next("dd").prev('span').find('label').html()}</td>
                        <td>${$(this).next("dd").find('label').next('span').find('label').html()}</td>
                        <td>${$(this).next("dd").find('span').next('span').next('span').html().replace('￥', '')}</td>
                        <td>1</td>
                        <td>${$(this).next("dd").find('span').next('span').next('span').html().replace('￥', '')}</td>
                        <td><a href="javascript:void(0)" onclick="del(this)">删除</a></td>
                        </tr>`
                );
                //将新建的tr追加到购物车table中
                $(".ShoppingCart table").append($tr);
                //重新统计购物车数据
                total();
            })
            //使用模板字符串添加表格数据
            $(".content-box :button").click(function () {
                $tr = $(`<tr>
                    <td><input type="checkbox" onchange="checkChange(this)"></td>
                    <td>${$(this).prev().prev().prev("span").find("label").html()}</td>
                    <td>${$(this).prev().prev("span").find("label").html()}</td>
                    <td>${$(this).prev("span").html().replace("￥", "")}</td>
                    <td>1</td>
                    <td>${$(this).prev("span").html().replace("￥", "")}</td>
                    <td><a href="javascript:void(0)" onclick="del(this)">删除</a></td>
                    </tr>`)
                //追加到table表格中
                $(".ShoppingCart table").append($tr);
                //调用统计函数
                totoal();
            });
            //给下单按钮绑定事件
            $("#xd").click(function () {
                //创建时间函数
                var data = new Date();
                var str = `订单编号：5456435 ${data.getFullYear()}年${data.getMonth() + 1}月${data.getDate()}日 ${data.getHours()}时${data.getMinutes()}分${data.getSeconds()}秒`
                alert(str);
            })
            //勾选全选按钮
            $("#quanxuan").click(function () {
                //判断
                if ($(this).is(":checked")) {
                    $(".ShoppingCart :checkbox:not(#quanxuan)").prop("checked", true);
                } else {
                    $(".ShoppingCart :checkbox:not(#quanxuan)").prop("checked", false);
                }
            })
            //批量删除
            $("#delel").click(function () {
                $(".ShoppingCart :checked:not(#quanxuan)").parent().parent('tr').remove();
                checkChange();
            })
            initShi("广西省");
            initCity();
        })
        //取消全选
        function checkChange() {
            if ($(".ShoppingCart :checkbox:not(#quanxuan)").length == 0) {
                $("#quanxuan").prop("checked", false);
                return;
            }
            var flag = true;
            $(".ShoppingCart :checkbox:not(#quanxuan)").each(function () {
                if (!$(this).is(":checked")) {
                    flag = false;
                }
            })
            $("#quanxuan").prop("checked", flag);
        }
        //统计函数
        function totoal() {
            totoalSL();
            totoalJG();
        }
        //统计数量
        function totoalSL() {
            $("#num").html($(".ShoppingCart table tr:gt(0)").length);
        }
        //统计价格
        function totoalJG() {
            //声明变量存储累加和
            var sum = 0;
            $(".ShoppingCart table tr:gt(0)").each(function () {
                sum += parseInt($(this).find("td").eq(5).html());
            })
            $("#zhongjia").html(sum);
        }
        //删除
        function del(obj) {
            if (confirm("您确定要删除吗?")) {
                $(obj).parent().parent("tr").remove();
                totoal();
                checkChange();
            }
        }
    </script>
