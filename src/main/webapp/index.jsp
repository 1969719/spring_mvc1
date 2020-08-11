<%@ page import="org.lanqiao.mvc.pojo.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>首页---</title>
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" type="text/css" href="css/iconfont.css"/>
    <link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.css"/>
    <script src="js/jquery-3.1.1.min.js" type="text/javascript" charset="utf-8"></script>
    <script src="js/mobile-util.js" type="text/javascript" charset="utf-8"></script>
    <script src="/js/swipeSlide.min.js" type="text/javascript" charset="utf-8"></script>
    <script src="js/global.js"></script>
    <script src="js/layer.js"  type="text/javascript" ></script>
    <link rel="shortcut icon" type="image/x-icon" href="images/6.png" media="screen"/>
    <style>
        .wrapper03 {display:inline-block;position:relative;height: 2rem;width: 100%;overflow: hidden;margin:0 auto;border-bottom:1px solid #ccc}
        .wrapper03 .scroller {position:absolute}
        .wrapper03 .scroller li {height: 2rem;color:#333;float: left;line-height: 2rem;font-size: .6rem;text-align: center}
        .wrapper03 .scroller li a{color:#333;display:block;margin:0 .3rem;padding:0 .1rem}
        .wrapper03 .scroller li.cur a{color:#1cbb9b;height:1.9rem;border-bottom:.1rem solid #1cbb9b}
        /*.aa{*/
            /*background: url(images/25.jpg);*/
            /*background-repeat:no-repeat ;*/
            /*background-size:100% 100%;*/
            /*background-attachment: fixed;*/
        /*}*/
    </style>
    <script type="text/javascript">
        var   a=screen.availWidth;
        var   b=screen.availHeight;
        window.moveTo(0,0);
        window.resizeTo(a,b);

        function check() {
            var inputusername = document.getElementById("inputusername");
            var inputTel = document.getElementById("inputTel").value;
            var inputXinxi = document.getElementById("inputXinxi");
            var bixuan =document.getElementsByClassName("product1").value;
            var myreg = /^[1][3,4,5,7,8][0-9]{9}$/;
            <% if(session.getAttribute("user") == null){%>
            alert("请登录");
            return false;
            <%}%>

            product1: $(".product1").prop("checked")?$(".product1").val():"";
            if($(".product1:checked").length==0) {
                alert("复选框必须选择一项");
                return false;
            }else if (inputusername.value == "") {
                alert("请输入姓名");
                return false;
            }else if (inputTel == "") {
                alert("请输入您的手机号");
                return false;
            } else if (!myreg.test(inputTel)) {
                alert("请输入正确的手机号");
                return false;
            } else if (inputXinxi.value == "") {
                alert("请输入具体描述");
                return false;
            }
            // else if(bixuan.length =0) {
            //     alert("请至少选择一项需求");
            //     return false;
            // }
                else{
                alert("提交成功");
                return true;
            }
        }
        //获取当前时间
        window.onload = function(){
            var nowDate = new Date();
            var str = nowDate.getFullYear()+"-"+(nowDate.getMonth() + 1)+"-"+nowDate.getDate();
            document.getElementById("hiredate").value=str;
        }

        function exit() {
            var url = "/empAll.do/exit";
            window.location.href = url;
        }



        var phoneWidth = parseInt(window.screen.width);
        var phoneScale = phoneWidth/640;
        var ua = navigator.userAgent;
        if (/Android (\d+\.\d+)/.test(ua)){
            var version = parseFloat(RegExp.$1);
            if(version>2.3){
                document.write('<meta name="viewport" content="width=640, minimum-scale = '+phoneScale+', maximum-scale = '+phoneScale+', target-densitydpi=device-dpi">');
            }else{
                document.write('<meta name="viewport" content="width=640, target-densitydpi=device-dpi">');
            }
        } else {
            document.write('<meta name="viewport" content="width=640, user-scalable=no, target-densitydpi=device-dpi">');
        }


    </script>
</head>
<body style="width: 100%" class="aa">

<!--顶部滚动广告栏-s-->
<div class="banner ban1">
    <div class="mslide" id="slideTpshop">
        <%--<img src="images/jin.png" title="" style="float: left" alt="">--%>

        <ul>
            <!--广告表-->
            <li>
                <img src="images/1.jpg" title="" style="display: inline-block" alt="">
            </li>
        </ul>
    </div>
</div>
<!--猜您喜欢-start-->
<div class="floor guesslike m-b-0" background="images/27.jpg">
    <div class="banner banner_imgs" id="q">
        <% if(session.getAttribute("user") != null){%>
        <div class="content" style="text-align: right;float: none;height: 50px;font-size: 25px">当前用户：<%=((User)session.getAttribute("user")).getUsername()%></div>
        <%}%>
        <%--<div class="content" style="text-align: right;float: none;height: 30px">当前用户id：<%=session.getAttribute("uid")%></div>--%>
        <form action="/empAll.do?method=getBusiness" method="post" id="regFrom" class="form-horizontal form-control" onsubmit="return check()">
            <center>
                <div style="height: 60px;font-size: 25px" class="form-contro">
                    <label class="checkbox inline">
                        <%--<input type="checkbox" id="inlineCheckbox1" class="product1" value="财务需求" name="finance" onclick="this.value=(this.value==1)?1:' '"> 财务需求--%>
                        <input type="checkbox" id="inlineCheckbox1" class="product1" value="财务需求" name="finance" style="zoom:150%"> 财务需求
                    </label>&nbsp&nbsp
                    <label class="checkbox inline">
                        <input type="checkbox" id="inlineCheckbox2" class="product1" value="业务需求" name="business" style="zoom:150%"> 业务需求
                    </label>&nbsp&nbsp
                    <label class="checkbox inline">
                        <input type="checkbox" id="inlineCheckbox3" class="product1" value="薪资需求" name="pay" style="zoom:150%"> 薪资需求
                    </label>&nbsp&nbsp
                    <label class="checkbox inline">
                        <input type="checkbox" id="inlineCheckbox4" class="product1" value="OA需求" name="oa" style="zoom:150%"> OA需求
                    </label><br>
                </div>

                <div style="height: 60px;font-size: 25px" class="form-contro">
                    <label class="checkbox inline">
                        <input type="checkbox" id="inlineCheckbox5" class="product1" value="生产需求" name="production" style="zoom:150%"> 生产需求
                    </label>&nbsp&nbsp
                    <label class="checkbox inline">
                        <input type="checkbox" id="inlineCheckbox6" class="product1" value="网站需求" name="website" style="zoom:150%"> 网站需求
                    </label>&nbsp&nbsp
                    <label class="checkbox inline">
                        <input type="checkbox" id="inlineCheckbox7" class="product1" value="税酬需求" name="taxes" style="zoom:150%"> 税酬需求
                    </label>&nbsp&nbsp
                    <label class="checkbox inline">
                        <input type="checkbox" id="inlineCheckbox8" class="product1" value="其他" name="other" style="zoom:150%"> 其&nbsp&nbsp&nbsp&nbsp&nbsp他
                    </label>
                </div>
            </center>
            <br>
            <center>
                <div class="form-group">
                    <div class="col-sm-10">
                        <div style="height: 60px;font-size: 25px"> 姓  &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp 名：&nbsp<input type="username" class="form-control" id="inputusername" placeholder="必填" name="name"><br><br></div>
                        <div style="height: 60px;font-size: 25px">联系方式：&nbsp<input type="telphone" class="form-control" id="inputTel" placeholder="必填" name="phone"><br><br></div>
                        <div style="height: 60px;font-size: 25px">渠  &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp 道：&nbsp<input type="qudao" class="form-control" id="inputQudao" placeholder="选填" name="channel"></div>
                        <div style="height: 60px;font-size: 25px">描  &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp 述：&nbsp<input type="xinxi" class="form-control" id="inputXinxi" placeholder="必填" name="miaoshu"></div>
                        <div hidden><input type="text" name="hiredate" id="hiredate" value="" style=" display:none"></div>
                        <div class="loginsingup-input">
                            <div class="lsu-submit">
                                <input type="submit" name="" id="inputSubmit" onclick="checkSubmit()" value="提交"/><br>


                            </div>
                            <br> <br> <br> <br> <br> <br>


                        </div>
                    </div>
                </div>
            </center>
            <br>
        </form>


        <form action="/empAll.do?method=exit" method="post" class="form-horizontal form-control">
            <div class="loginsingup-input" style="height: 180px">
                <div class="lsu-submit">
                    <input type="submit"   value="退出登录"/>
                </div>
            </div>
        </form>
        <div>
            <center>
                <p style="font-size: 25px;color:blue;height: 30px">温馨提示：请登录后再提交！！！</p><br>
            </center>
        </div>
    </div>
</div>


<div>
    <center>
        <p style="font-size: 25px;color:blue">咨询电话：郭女士 186-0083-5845</p><br>
    </center>
</div>
<div class="likeshop " >
    <div id="J_ItemList">
        <ul class="product single_item info">
        </ul>
    </div>
</div>
<%--<a onclick="$('html,body').animate({'scrollTop':0},600)" style="display: block;width: 1.5rem;height:1.5rem;position: fixed; bottom: 3rem;right:0.4rem; background-color: rgba(243,241,241,0.5);border: 1px solid #CCC;-webkit-border-radius: 50%;-moz-border-radius: 50%;border-radius: 50%;" id="topup">--%>
<%--<img src="images/topup.png" style="display: block;width: 1.45rem;height:1.45rem;">--%>
<%--</a>--%>
<div class="foohi">
    <div class="footer">
        <ul>
            <li>
                <a class="yello"   href="index.jsp">
                    <div class="icon">
                        <div class="icon_tp1 icon_tps"><img src="images/home1.png"/> </div>
                        <div class="icon_tp2 icon_tps"><img src="images/home2.png"/> </div>
                        <p>首页</p>
                    </div>
                </a>
            </li>
            <li>
                <a  href="/empAll.do?method=getBusinessCar">
                    <div class="icon">
                        <div class="icon_tp1 icon_tps"><img src="images/cart1.png"/> </div>
                        <div class="icon_tp2 icon_tps"><img src="images/cart2.png"/> </div>
                        <p>信息列表</p>
                    </div>
                </a>
            </li>
            <li>
                <a  href="login.jsp">
                    <div class="icon">
                        <div class="icon_tp1 icon_tps"><img src="images/category1.png"/> </div>
                        <div class="icon_tp2 icon_tps"><img src="images/category2.png"/> </div>
                        <p>登录</p>
                    </div>
                </a>
            </li>
            <li>
                <a  href="register.jsp">
                    <div class="icon">
                        <div class="icon_tp1 icon_tps"><img src="images/user1.png"/> </div>
                        <div class="icon_tp2 icon_tps"><img src="images/user2.png"/> </div>
                        <p>注册</p>
                    </div>
                </a>
            </li>
        </ul>
    </div>
</div>

</body>


</html>