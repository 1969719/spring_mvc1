package org.lanqiao.mvc.dao.Impl;

import com.mysql.cj.Session;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.ibatis.transaction.Transaction;
import org.lanqiao.mvc.Util.JdbcUtils;
import org.lanqiao.mvc.dao.IUserDao;
import org.lanqiao.mvc.pojo.User;

import javax.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl implements IUserDao {
    private QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());

    @Override
    public User getUser(String phone,String password) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        User u = null;
        try {
            conn = JdbcUtils.getConnection();
            //找到与浏览器中getConnection输入用户名和密码一致的sql语句，并保存在rs中
            String sql = "select * from user where phone= ? and password = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,phone);
            ps.setString(2, password);
            //得到sql中的结果
            rs = ps.executeQuery();

            while(rs.next())
            {
                //新创建一个user对象，将rs中的属性均赋值给user对象
                //如果之前的rs内容为空的话，那么此时返回的u也为null
                u = new User();
                u.setId(rs.getString(1));
                u.setPhone(rs.getString(2));
                u.setUsername(rs.getString(4));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{

        }
        return u;

    }

    @Override
    public int adduser(User user) throws SQLException {
        QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
        String sql = "insert  into  user(password,username,phone)values(?,?,?) ;";
        qr.update(sql,user.getUsername(),user.getPassword(),user.getPhone());
        return 0;
    }
//忘记密码
    @Override
    public int updatePwd(User user) {
        String sql = "UPDATE user SET password = ? WHERE phone = ?";
        int result = -1;
        try {
            result = qr.execute(sql,user.getPassword(),user.getPhone());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
//重复注册
    @Override
    public int repeat(User user){
        String sql = "select count(*) from user where phone = ?";
        int result = -1;
        try {
            result = qr.execute(sql,user.getPhone());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

//    @Override
//    public boolean findUserByPhone(String phone) throws SQLException {
//        HttpSession session = sessionFactory.getCurrentSession();
//        Transaction tx = session.beginTransaction();
//        List<User> list =null;
//        try{
//            String sql = "select * from user where phone='"+phone+"';";
//            list = session.createSQLQuery(sql).list();
//            System.out.println("findUserByName =="+list);
//            tx.commit();
//            if(list!=null && list.size()>0){
//                return false;
//            }
//        }catch(Exception e){
//            tx.rollback();
//            e.printStackTrace();
//        }
//        return true;
//    }
}

