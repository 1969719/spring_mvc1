<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册---</title>
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" type="text/css" href="css/iconfont.css"/>
    <script src="js/jquery-3.1.1.min.js" type="text/javascript" charset="utf-8"></script>
    <script src="js/mobile-util.js" type="text/javascript" charset="utf-8"></script>
    <script src="/js/swipeSlide.min.js" type="text/javascript" charset="utf-8"></script>
    <script src="js/global.js"></script>
    <script src="js/layer.js"  type="text/javascript" ></script>
    <link rel="shortcut icon" type="image/x-icon" href="images/6.png" media="screen"/>
</head>
<body class="aa">

<style>
    #verify_code_img{
        padding: .55467rem .21333rem;
        width: 4.6rem;
        height: 2.9rem;
        color: white;
        border-radius: .128rem;
    }
    .aa{
        background: url(images/25.jpg);
        background-repeat:no-repeat ;
        background-size:100% 100%;
        background-attachment: fixed;
    }
</style>

<script>
    // var flag = true;
    function check() {
        var username =document.getElementById("name").value;
        var mobile =document.getElementById("mobile").value;
        var myreg = /^[1][3,4,5,7,8][0-9]{9}$/;
        var password = document.getElementById("password").value;
        var passwordAgain = document.getElementById("passwordAgain").value;
        if (username == ""){
            alert("请输入姓名");
            return false;
        }else if(!myreg.test(mobile)){
            alert("请输入正确的手机号");
            return false;
        }else if(password.length < 6){
            alert("请输入不少于六位密码");
            return false;
            //二次输入密码验证
        }else if(passwordAgain != password){
            alert("两次输入密码不同，请重新输入")
            return false;
        }
        // else if(url="http://localhost:8080/empAll.do?method=getregister"){
        //     alert("该手机号已被注册")
        //     return false;
        // }
        else{
            // alert("注册成功")
            return true;
        }

        // if (flag == true){
        //     flag = false;
        //     return true;
        // } else {
        //     return false;
        // }
    }
    //点击按钮下次不可用
    // $(function () {
    //     $("#btn").click(function () {
    //         $("#regFrom").submit();
    //         $("#btn").attr("disabled","disabled")
    //     })
    // })
</script>
<div class="logo-wrap-bg">
<from>
<a href="http://localhost:8080/empAll.do?method=getregister"></a>
</from>

</div>
<!--注册表单-s-->
<div class="loginsingup-input">
    <form action="/empAll.do?method=getregister" method="post" id="regFrom" onsubmit="return check()">
        <div class="lsu">
            <span class="ico ico-telephone"></span>
            <input type="text" name="username" id="name" value="" placeholder="请输入真实姓名"  class="c-form-txt-normal">
            <%--<span id="mobile_phone_notice"></span>--%>
        </div>
        <div class="lsu">
            <span class="ico ico-telephone"></span>
            <input type="text" name="phone" id="mobile" value="" placeholder="请输入手机号"  class="c-form-txt-normal">
            <%--<span id="mobile_phone_notice"></span>--%>
        </div>

        <div class="lsu">
            <span class="ico ico-username"></span>
            <input type="password" name="password" id="password" value="" placeholder="请输入不少于6位密码"  class="c-form-txt-normal">
            <span id="mobile_phone_notice"></span>
        </div>
        <div class="lsu">
            <span class="ico ico-username"></span>
            <input type="password" name="password" id="passwordAgain" value="" placeholder="请再次输入密码"  class="c-form-txt-normal">
            <span ></span>
        </div>
        <div class="lsu-submit">
            <input type="submit" name="" id="btn" onclick="checkSubmit()" OnPreRender="btn_PreRender" value="注 册"/>
        </div>
    </form>
    <div>
        <center>
            <p style="font-size: 10px;color:red">温馨提示：点击注册跳转到空白页说明该手机号已被注册！</p><br>
        </center>
    </div>
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
