<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录---</title>
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" type="text/css" href="css/iconfont.css"/>
    <script src="js/jquery-3.1.1.min.js" type="text/javascript" charset="utf-8"></script>
    <script src="js/mobile-util.js" type="text/javascript" charset="utf-8"></script>
    <script src="/js/swipeSlide.min.js" type="text/javascript" charset="utf-8"></script>
    <script src="js/global.js"></script>
    <script src="js/layer.js"  type="text/javascript" ></script>
    <link rel="shortcut icon" type="image/x-icon" href="images/6.png" media="screen"/>

</head>
<body background="images/25.jpg" style=" background-repeat:no-repeat ;
background-size:100% 100%;
background-attachment: fixed;"
>
<script type="text/javascript">
    function check() {
        <%
        Object message = session.getAttribute("message");
        if(message!=null && !"".equals(message)){

        %>
        alert("<%=message%>");

        <%} %>
    }

</script>


<div class="logo-wrap-bg">
</div>
<div class="loginsingup-input" background="images/25.jpg">
    <form action="/empAll.do?method=getUser" method="POST">
        <div class="lsu">
            <span class="ico ico-telephone"></span>
            <input type="text" name="phone"  value="" placeholder="请输入手机号"  class="c-form-txt-normal">
        </div>
        <div class="lsu">
            <span class="ico ico-username"></span>
            <input type="password" name="password"  value="" placeholder="请输入密码"  class="c-form-txt-normal">
            <span id="mobile_phone_notice"></span>
        </div>
        <div class="lsu-submit">
            <input onclick="checkSubmit()" type="submit" value="登 录"/><br>
        </div>
        <div class="lsu-submit">
            <input type="button" value="忘记密码" onclick='location.href=("updatePwd.jsp")' />
        </div>
    </form>
</div>
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
