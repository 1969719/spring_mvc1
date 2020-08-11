<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>修改密码---</title>
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" type="text/css" href="css/iconfont.css"/>
    <script src="js/jquery-3.1.1.min.js" type="text/javascript" charset="utf-8"></script>
    <script src="js/mobile-util.js" type="text/javascript" charset="utf-8"></script>
    <script src="/js/swipeSlide.min.js" type="text/javascript" charset="utf-8"></script>
    <script src="js/global.js"></script>
    <script src="js/layer.js"  type="text/javascript" ></script>
    <link rel="shortcut icon" type="image/x-icon" href="images/6.png" media="screen"/>
    <script type="text/javascript">
        function register() {
            var phone = $("#phone").val();
            var password1 = $("#password1").val();
            var password2 = $("#password2").val();
            if(phone == null || phone == ""){
                alert("请输入手机号");
                return;
            }
            if(password1 == null || password1 == ""){
                alert("请输入密码");
                return;
            }
            if(password2 == null || password2 == ""){
                alert("请再次输入密码");
                return;
            }
            if(password1 != password2){
                alert("两次输入的密码不一致");
                return;
            }
            var url = "/empAll.do?method=updatePwd&phone="+phone+"&password="+password1;
            window.location.href= url;
        }
    </script>
</head>
<body background="images/25.jpg" style=" background-repeat:no-repeat ;
background-size:100% 100%;
background-attachment: fixed;">
<div class="logo-wrap-bg">
</div>
<div class="loginsingup-input" >
<div class="lsu">
    <span class="ico ico-telephone"></span>
    <input type="text" name="phone" id="phone" value="" placeholder="请输入手机号"  class="c-form-txt-normal">
</div>
<div class="lsu">
    <span class="ico ico-username"></span>
    <input type="password" name="password" id="password1" value="" placeholder="请输入密码"  class="c-form-txt-normal">
    <span id="mobile_phone_notice"></span>
</div>
<div class="lsu">
    <span class="ico ico-username"></span>
    <input type="password" name="password" id="password2" value="" placeholder="请再次输入密码"  class="c-form-txt-normal">
    <span ></span>
</div>


<div class="lsu-submit">
    <input type="submit" name="" id="" onclick="register()" value="确认修改"/>
</div></div>
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
