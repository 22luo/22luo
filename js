<script>

        $(function () {
            $(":text").blur(function () {
                //对比账号是否有十一位
                if ($(this).val().length == 11
                //对比账号开头是否是1
                    && $(this).val().substring(0, 1) == "1"
                    // 对比账号是否是全数字
                    && parseInt($(this).val()) == $(this).val()) {
                    $(this).next().hide()
                } else {
                    $(this).next().show()
                }
            })
            //验证账号密码是否正确
            $("form").submit(function () {
                // 设置账号密码
                if ($(":text").val() == "15266668888" && (":password").val() == "123") {
                    // 密码正确返回true
                    return true;
                } else
                //错误返回false
                    alert("账号密码不正确")
                return false;
            })
        })


    //      //先声明可以登录的账号和密码
    // var username = '15078777390';
    // var password = '123';

    // //声明登录函数  返回true form表单会正常提交 返回false 终止提交S
    // function A() {
    //     if ($(":text").val() == username && $(":password").val() == password) {
    //         return true;
    //     }
    //     alert('账号密码不正确');
    //     return false;
    // }

//在form后添加
    // <form action="index.html"onsubmit="return A()">



        $(function () {
            // $(".nav-menu-item").mouseover(function () {
            //     $(this).find('ul').slideDown();
            // })

            // $(".nav-menu-item").mouseout(function () {
            //     $(this).find('ul').slideUp();
            // })

            $(".nav-menu-item").hover(function () {
                $(this).find('ul').slideToggle();
            })
            //调用重新统计购物车的数据
            total();
            //为所有选购按钮绑定单击事件
            $("#content :button").click(function () {
                //获取商品信息，并且封装成一个新的tr标签
                $tr = $(`<tr>
                        <td><input type="checkbox" onchange="checkChange(this)"></td>
                        <td>${$(this).prev('span').prev('span').prev('span').find('label').html()}</td>
                        <td>${$(this).prev('span').prev('span').find('label').html()}</td>
                        <td>${$(this).prev('span').html().substring(1, $(this).prev('span').html().length)}</td>
                        <td>1</td>
                        <td>${$(this).prev('span').html().substring(1, $(this).prev('span').html().length)}</td>
                        <td><a href="javascript:void(0)" onclick="del(this)">删除</a></td>
                    </tr>`
                );
                //将新建的tr追加到购物车table中
                $(".ShoppingCart table").append($tr);
                //重新统计购物车数据
                total();
                //调用判断是否要勾选全选按钮的函数
                checkAll();
            })
            //为全选按钮绑定单击事件
            $("#checkAll").click(function () {
                if ($(this).is(':checked')) {
                    //  attr 用于操作value等于字符串的属性
                    //  prop  其他情况
                    $(".ShoppingCart :checkbox").prop('checked', true);
                } else {
                    $(".ShoppingCart :checkbox").prop('checked', false);
                }
            })
            //为批量删除按钮绑定单击事件
            $("#delAll").click(function () {
                $(".ShoppingCart :checked:not(#checkAll)").each(function () {
                    $(this).parent().parent().remove();
                    //重新统计购物车数据
                    total();
                    //调用判断是否要勾选全选按钮的函数
                    checkAll();
                })
            })
            //初始化省份下拉框
            initProvince();
            //初始化城市下拉框
            initCity('广西省');
            //为省份下拉框绑定change事件
            $("#province").change(function () {
                //修改城市下拉框的值
                initCity($(this).val())
            })
        })
        //商品列表中复选框的单击事件
        function checkChange(obj) {
            //调用判断是否要勾选全选按钮的函数
            checkAll();
        }
        //判断是否要勾选全选按钮的函数
        function checkAll() {
            var checkAll = true;// 用于标记所有商品是否被选中 true为被选中 false为不是全部被选中
            $(".ShoppingCart :checkbox:not(#checkAll)").each(function () {
                if (!$(this).is(':checked')) {
                    checkAll = false;
                }
            })
            //当checkAll的值为true，应该勾选全选按钮，否则取消全选按钮
            //console.log(checkAll);
            if (checkAll) {
                $("#checkAll").prop('checked', true);
            } else {
                $("#checkAll").prop('checked', false);
            }
        }
        //重新统计购物车的数据
        function total() {
            //调用统计总商品数的函数
            totalCount();
            //调用统计总商价格的函数
            totalPrice();
        }
        //声明一个统计总商品数的函数
        function totalCount() {
            var count = 0;//用于累加商品数量
            //找到购物车中所有的行（除了第一行以外），遍历所有行，进行统计
            $("table tr:gt(0)").each(function () {
                count += parseInt($(this).find('td').eq(4).html())
            })
            //将统计结果赋到下面
            $("#totalCountSpan").html(count);
        }
        //声明一个统计总商价格的函数
        function totalPrice() {
            var count = 0;//用于累加商品数量
            //找到购物车中所有的行（除了第一行以外），遍历所有行，进行统计
            $("table tr:gt(0)").each(function () {
                count += parseInt($(this).find('td').eq(5).html())
            })
            //将统计结果赋到下面
            $("#totalPriceSpan").html(count);
        }
        //声明一个删除商品的函数
        function del(obj) {
            //  obj是一个DOM对象
            $(obj).parent().parent().remove();
            //重新统计购物车数据
            total();
            //调用判断是否要勾选全选按钮的函数
            checkAll();
        }
        //声明一个二维数组存放省市级联数据
        var arr = [];
        arr['广西省'] = ['南宁市', '百色市', '玉林市'];
        arr['广东省'] = ['广州市', '湛江市', '佛山市'];
        //封装并且更新省份下拉框
        function initProvince() {
            //强遍历 i代指arr的下标
            for (var i in arr) {
                //console.log(i);
                $option = $(`<option value='${i}'>${i}</option>`)
                $("#province").append($option);
            }
        }
        //封装并且更新城市下拉框
        function initCity(province) {
            //先清空城市下拉框的值
            $("#city").html('');
            //强遍历 i代指arr的下标
            for (var i in arr[province]) {
                //console.log(i);
                $option = $(`<option value='${arr[province][i]}'>${arr[province][i]}</option>`)
                $("#city").append($option);
            }
        }


        $(function () {
            // $(".nav-menu-item").mouseover(function () {
            //     $(this).find('ul').slideDown();
            // })

            // $(".nav-menu-item").mouseout(function () {
            //     $(this).find('ul').slideUp();
            // })

            $(".nav-menu-item").hover(function () {
                $(this).find('ul').slideToggle();
            })
            //调用重新统计购物车的数据
            total();
            //为所有选购按钮绑定单击事件
            $("#content :button").click(function () {
                //获取商品信息，并且封装成一个新的tr标签
                $tr = $(`<tr>
                        <td><input type="checkbox" onchange="checkChange(this)"></td>
                        <td>${$(this).prev('span').prev('span').prev('span').find('label').html()}</td>
                        <td>${$(this).prev('span').prev('span').find('label').html()}</td>
                        <td>${$(this).prev('span').html().substring(1, $(this).prev('span').html().length)}</td>
                        <td>1</td>
                        <td>${$(this).prev('span').html().substring(1, $(this).prev('span').html().length)}</td>
                        <td><a href="javascript:void(0)" onclick="del(this)">删除</a></td>
                    </tr>`
                );
                //将新建的tr追加到购物车table中
                $(".ShoppingCart table").append($tr);
                //重新统计购物车数据
                total();
                //调用判断是否要勾选全选按钮的函数
                checkAll();
            })
            //为全选按钮绑定单击事件
            $("#checkAll").click(function () {
                if ($(this).is(':checked')) {
                    //  attr 用于操作value等于字符串的属性
                    //  prop  其他情况
                    $(".ShoppingCart :checkbox").prop('checked', true);
                } else {
                    $(".ShoppingCart :checkbox").prop('checked', false);
                }
            })
            //为批量删除按钮绑定单击事件
            $("#delAll").click(function () {
                $(".ShoppingCart :checked:not(#checkAll)").each(function () {
                    $(this).parent().parent().remove();
                    //重新统计购物车数据
                    total();
                    //调用判断是否要勾选全选按钮的函数
                    checkAll();
                })
            })
            //初始化省份下拉框
            initProvince();
            //初始化城市下拉框
            initCity('广西省');
            //为省份下拉框绑定change事件
            $("#province").change(function () {
                //修改城市下拉框的值
                initCity($(this).val())
            })
        })
        //商品列表中复选框的单击事件
        function checkChange(obj) {
            //调用判断是否要勾选全选按钮的函数
            checkAll();
        }
        //判断是否要勾选全选按钮的函数
        function checkAll() {
            var checkAll = true;// 用于标记所有商品是否被选中 true为被选中 false为不是全部被选中
            $(".ShoppingCart :checkbox:not(#checkAll)").each(function () {
                if (!$(this).is(':checked')) {
                    checkAll = false;
                }
            })
            //当checkAll的值为true，应该勾选全选按钮，否则取消全选按钮
            //console.log(checkAll);
            if (checkAll) {
                $("#checkAll").prop('checked', true);
            } else {
                $("#checkAll").prop('checked', false);
            }
        }
        //重新统计购物车的数据
        function total() {
            //调用统计总商品数的函数
            totalCount();
            //调用统计总商价格的函数
            totalPrice();
        }
        //声明一个统计总商品数的函数
        function totalCount() {
            var count = 0;//用于累加商品数量
            //找到购物车中所有的行（除了第一行以外），遍历所有行，进行统计
            $("table tr:gt(0)").each(function () {
                count += parseInt($(this).find('td').eq(4).html())
            })
            //将统计结果赋到下面
            $("#totalCountSpan").html(count);
        }
        //声明一个统计总商价格的函数
        function totalPrice() {
            var count = 0;//用于累加商品数量
            //找到购物车中所有的行（除了第一行以外），遍历所有行，进行统计
            $("table tr:gt(0)").each(function () {
                count += parseInt($(this).find('td').eq(5).html())
            })
            //将统计结果赋到下面
            $("#totalPriceSpan").html(count);
        }
        //声明一个删除商品的函数
        function del(obj) {
            //  obj是一个DOM对象
            $(obj).parent().parent().remove();
            //重新统计购物车数据
            total();
            //调用判断是否要勾选全选按钮的函数
            checkAll();
        }
        //声明一个二维数组存放省市级联数据
        var arr = [];
        arr['广西省'] = ['南宁市', '百色市', '玉林市'];
        arr['广东省'] = ['广州市', '湛江市', '佛山市'];
        //封装并且更新省份下拉框
        function initProvince() {
            //强遍历 i代指arr的下标
            for (var i in arr) {
                //console.log(i);
                $option = $(`<option value='${i}'>${i}</option>`)
                $("#province").append($option);
            }
        }
        //封装并且更新城市下拉框
        function initCity(province) {
            //先清空城市下拉框的值
            $("#city").html('');
            //强遍历 i代指arr的下标
            for (var i in arr[province]) {
                //console.log(i);
                $option = $(`<option value='${arr[province][i]}'>${arr[province][i]}</option>`)
                $("#city").append($option);
            }
        }
    </script>
