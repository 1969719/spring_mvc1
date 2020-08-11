package org.lanqiao.mvc.dao;

import org.lanqiao.mvc.pojo.User;

import java.sql.SQLException;
import java.util.List;

public interface IUserDao {
    //查找用户
    public User getUser(String phone,String password) throws SQLException;
    // 添加用户
    public int adduser(User user) throws SQLException;
    //修改密码
    public int updatePwd(User user);
    //防止重复注册
    public int repeat(User user) throws SQLException;
//    //查询手机号是否存在
//    public boolean findUserByPhone(String phone) throws SQLException;
}
