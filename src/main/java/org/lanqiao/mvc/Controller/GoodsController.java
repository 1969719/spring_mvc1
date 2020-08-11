package org.lanqiao.mvc.Controller;

import org.lanqiao.mvc.Util.MD5Utils;
import org.lanqiao.mvc.dao.IUserDao;
import org.lanqiao.mvc.dao.Impl.UserDaoImpl;
import org.lanqiao.mvc.pojo.*;
import org.lanqiao.mvc.service.*;
import org.lanqiao.mvc.service.impl.BusinessServiceImpl;
import org.lanqiao.mvc.service.impl.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.ui.Model;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;

@WebServlet("/empAll.do")
public class GoodsController extends HttpServlet {
    IBusinessService businessService = new BusinessServiceImpl();
    IUserService updateManager = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        switch (method) {
            case "getUser":
                try {
                    getUser(req, resp);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "getregister":
                try {
                    getregister(req, resp);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "getBusiness":
                try {
                    try {
                        getBusiness(req, resp);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "getBusinessCar":
                try {
                    getBusinessCar(req, resp);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "deleteBusiness":
                try {
                    deleteBusiness(req, resp);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "updatePwd":
                updatePwd(req, resp);
                break;
            case "serch":
                try {
                    serch(req, resp);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "exit":
                    exit(req, resp);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        doGet(req, resp);
    }

    //登录
    private void getUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        //设置编码模式
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        //获取表单数据,   并将表单数据存入到login函数中
//        String username = req.getParameter("username");
        String phone = req.getParameter("phone");

        String password = req.getParameter("password");
        String passwordMd5 = MD5Utils.MD5(password);
        User user = new User();

        user.setUsername(phone);
        user.setPassword(passwordMd5);
        //处理业务逻辑，实现login 方法，里面涉及到finduser方法
        IUserService userService = new UserServiceImpl();
        User users = userService.getUserService(phone, passwordMd5);

        //分发转向
        if (users != null) {
            req.setAttribute("phone", phone);
            req.setAttribute("password", passwordMd5);
            HttpSession session = req.getSession();
            session.setAttribute("user", users);
//            session.setAttribute("sucess", "登陆成功！");

            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        } else {
            //实现刷新功能
            out.write("用户名或密码错误，请重新登陆");
            req.getRequestDispatcher("/403.jsp").forward(req, resp);
        }
    }

    //注册
    private void getregister(HttpServletRequest req, HttpServletResponse resp) throws IOException, SQLException, ServletException {
        //设置编码模式
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        IUserService userService = new UserServiceImpl();
        int i = 0;
        //获取表单数据
        String name = req.getParameter("phone");
        String pwd = req.getParameter("password");
        String phone = req.getParameter("username");
        String passwordMd5 = MD5Utils.MD5(pwd);
        User user = new User();
        user.setUsername(name);
        user.setPassword(passwordMd5);
        user.setPhone(phone);
        // 通过手机号查询该数据库是否有该用户 repeats
//        IUserDao userDao = new UserDaoImpl();
//
//     User user1 = new User(phone);
//     i = userDao.repeat(user1);
//        if (i == 0) {
//            req.getRequestDispatcher("/register.jsp").forward(req, resp);
//        }
        try {
            //将获取到的表单数据封装到u中
            User u = new User(name, passwordMd5, phone);
            //对封装在u中的数据进行注册，使其记录在数据库表中
            i = userService.register(u);//这也在上文有解析
            if (i == 0) {
                out.write("注册成功,信息如下：<br>");
                out.write("<br>账号：" + u.getUsername());
                out.write("<br>密码：" + u.getPassword());
                req.getRequestDispatcher("/login.jsp").forward(req, resp);
//                out.write("注册信息不成功");
//                req.getRequestDispatcher("/index.jsp").forward(req, resp);

            } else {
                req.getRequestDispatcher("/index.jsp").forward(req, resp);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //表单提交
    private void getBusiness(HttpServletRequest req, HttpServletResponse resp) throws IOException, SQLException, ServletException, ParseException {
        //设置编码模式
        resp.setContentType("text/html;charset=UTF-8");
           //获取session登录用户
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        //获取用户id
        String uid =user.getId();
// 获取session中所有的键值
        Enumeration<String> attrs = session.getAttributeNames();
// 遍历attrs中的
        while (attrs.hasMoreElements()) {
// 获取session键值
            String name = attrs.nextElement().toString();
            // 根据键值取session中的值
            Object vakue = session.getAttribute(name);
            // 打印结果
            System.out.println("------" + name + ":" + vakue + "--------\n");
        }
        String miaoshu = req.getParameter("miaoshu");
        String finance = req.getParameter("finance");
        String business = req.getParameter("business");
        String pay = req.getParameter("pay");
        String oa = req.getParameter("oa");
        String production = req.getParameter("production");
        String website = req.getParameter("website");
        String taxes = req.getParameter("taxes");
        String channel = req.getParameter("channel");
        String name = req.getParameter("name");
        String phone = req.getParameter("phone");
        String other = req.getParameter("other");
        String hiredate = req.getParameter("hiredate");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date dhiredate = sdf.parse(hiredate);
        Business business11 = new Business(uid,miaoshu, finance, business, pay, oa, production, website, taxes, name, phone, channel, dhiredate, other);
        businessService.addBusiness(business11);
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }

    //管理员查看页面的显示
    private void getBusinessCar(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {
        //-------------
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        if (user == null) {
            req.getRequestDispatcher("/404.jsp").forward(req, resp);
        }
        int id = Integer.parseInt(user.getId());
            //--------------
            System.out.println(user.toString());
            IBusinessService businessService = new BusinessServiceImpl();
            List<Business> businessList = businessService.getListById(id);
            req.setAttribute("businessList", businessList);
            req.getRequestDispatcher("/link.jsp").forward(req, resp);


    }

    //管理员页面的删除商品
    public void deleteBusiness(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {
        String bid = req.getParameter("bid");
        int no = Integer.parseInt(bid);
        businessService.drop(no);
        getBusinessCar(req, resp);
    }

    //忘记密码
    private void updatePwd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String phone = req.getParameter("phone");
        String password = req.getParameter("password");
        String passwordMd5 = MD5Utils.MD5(password);
        User user = new User();
        user.setPhone(phone);
        user.setPassword(passwordMd5);
        updateManager.updateUser(user);
        req.getRequestDispatcher("/login.jsp").forward(req, resp);
    }

    //管理员页面查询
    public void serch(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {
        //获取session登录用户
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        //获取用户id
        String uid =user.getId();


        String serEname = req.getParameter("sername");
        Condition condition = new Condition();
        if (serEname != null && !"".equals(serEname)) {
            condition.setName("%" + serEname + "%");
        }
        List<Business> businessList = businessService.serchBusiness(condition);
        req.setAttribute("businessList", businessList);
        req.getRequestDispatcher("/link.jsp").forward(req, resp);
    }
    //退出登录
    public void exit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.invalidate();
        req.getRequestDispatcher("/login.jsp").forward(req, resp);
    }
}


