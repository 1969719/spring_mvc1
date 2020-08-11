<%@ page import="org.lanqiao.mvc.pojo.Business" %>
<%@ page import="java.util.List" %>
<%@ page import="org.lanqiao.mvc.pojo.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html style="font-size: 80px;" data-dpr="1">
<head>
    <title>信息列表---</title>
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" type="text/css" href="css/iconfont.css"/>
    <link rel="stylesheet" type="text/css" href="css/bootstrap-datetimepicker.css"/>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.css"/>
    <script src="js/jquery-3.1.1.min.js" type="text/javascript" charset="utf-8"></script>
    <script src="js/mobile-util.js" type="text/javascript" charset="utf-8"></script>
    <script src="/js/swipeSlide.min.js" type="text/javascript" charset="utf-8"></script>
    <script src="js/global.js"></script>
    <script src="js/layer.js"  type="text/javascript" ></script>
    <link rel="shortcut icon" type="image/x-icon" href="images/6.png" media="screen"/>
<style type="text/css">
    table {
        font-size:18px;
        align:"center";
        width: 100%;
        height: 50px;
    }
    table.altrowstable {
        font-family: verdana,arial,sans-serif;
        font-size:16px;
        color:#333333;
        border-width: 1px;
        border-color: #a9c6c9;
        border-collapse: collapse;
    }
    table.altrowstable th {
        border-width: 1px;
        padding: 8px;
        border-style: solid;
        border-color: #a9c6c9;
    }
    table.altrowstable td {
        border-width: 1px;
        padding: 8px;
        border-style: solid;
        border-color: #a9c6c9;
    }
    .oddrowcolor{
        background-color:#d4e3e5;
    }
    .evenrowcolor{
        background-color:#c3dde0;
    }
</style>
    <script>
        function altRows(id){
            if(document.getElementsByTagName){

                var table = document.getElementById(id);
                var rows = table.getElementsByTagName("tr");

                for(i = 0; i < rows.length; i++){
                    if(i % 2 == 0){
                        rows[i].className = "evenrowcolor";
                    }else{
                        rows[i].className = "oddrowcolor";
                    }
                }
            }
        }

        window.onload=function(){
            altRows('alternatecolor');
        }
    </script>
</head>
<body style="width: 100%">
<div class="aa">
<%--<form action="/empAll.do?method=serch" method="post">--%>
    <%--<h4>查询条件</h4><br>--%>
    <%--<div class="form-group">--%>
        <%--<label  class="control-label">姓名:</label>--%>
        <%--<input type="text" id="sername" class="form-control" name="sername" placeholder="请输入姓名">--%>
    <%--</div>--%>

    <%--&lt;%&ndash;<div class="form-group">&ndash;%&gt;--%>
        <%--&lt;%&ndash;<label for="job" class="control-label">职位:</label>&ndash;%&gt;--%>
        <%--&lt;%&ndash;<select class="form-control" id = "serjob" name="serjob">&ndash;%&gt;--%>

        <%--&lt;%&ndash;</select>&ndash;%&gt;--%>
    <%--&lt;%&ndash;</div>&ndash;%&gt;--%>
    <%--<center>--%>
        <%--<button class="btn-success" type="submit" value="搜索" style="font-size: 25px">检索</button>--%>
    <%--</center>--%>
<%--</form>--%>

    <% if(session.getAttribute("user") != null){%>
<%--<div class="content" style="text-align: right;float: left;height: 30px;color: red;font-size: 40px">当前用户：<%=((User)session.getAttribute("user")).getUsername()%></div>--%>
    <%}%>

    <table class="table table-hover altrowstable"id="alternatecolor" style="width: 1822px; max-width: 100%;margin-bottom: 20px;"  border="3" align="center">
    <thead class="element" >
    <%--<th>序号</th>--%>
    <th hidden>uid</th>
    <th>姓名</th>
    <th>电话</th>
    <th>渠道</th>
    <th>描述</th>
    <th>财务</th>
    <th>业务</th>
    <th>薪资</th>
    <th>oa</th>
    <th>生产</th>
    <th>网站</th>
    <th>税酬</th>
    <th>其他</th>
    <th>进度</th>
    <th>提交时间</th>
    <th>佣金</th>
    </thead>
    <tbody class="element">
    <%
        List<Business> businessList = (List<Business>) request.getAttribute("businessList");
        for (Business business : businessList){
    %>

    <tr>
        <%--<td><%=business.getId()%></td>--%>
        <td hidden><%=business.getUid()%></td>
        <td><%=business.getName()%></td>
        <td><%=business.getPhone()%></td>
        <td><%=business.getChannel()%></td>
        <td><%=business.getMiaoshu()%></td>
        <td><% if(business.getFinance() != null){%>
            <%=business.getFinance()%>
            <%}%>
        </td>
        <td><% if(business.getBusiness() != null){%>
            <%=business.getBusiness()%>
            <%}%>
        </td>
        <td><% if(business.getPay() != null){%>
            <%=business.getPay()%>
            <%}%>
        </td>
        <td><% if(business.getOa() != null){%>
            <%=business.getOa()%>
            <%}%>
        </td>
        <td><% if(business.getProduction() != null){%>
            <%=business.getProduction()%>
            <%}%>
        </td>
        <td><% if(business.getWebsite() != null){%>
            <%=business.getWebsite()%>
            <%}%>
        </td>
        <td><% if(business.getTaxes() != null){%>
            <%=business.getTaxes()%>
            <%}%>
        </td>
        <td><% if(business.getOther() != null){%>
            <%=business.getOther()%>
            <%}%>
        </td>
        <td><% if(business.getPlan() != null){%>
            <%=business.getPlan()%>
            <%}%>
        </td>
        <td><% if(business.getHiredate() != null){%>
            <%=business.getHiredate()%>
            <%}%>
        </td>
        <td><% if(business.getSal() != null){%>
            <%=business.getSal()%>
            <%}%>
        </td>
    </tr>
    <%
        }
    %>

    </tbody>
</table>
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
