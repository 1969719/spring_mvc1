package org.lanqiao.mvc.service;

import org.lanqiao.mvc.pojo.User;

import java.sql.SQLException;
import java.util.List;

public interface IUserService {
    //登录
    public User getUserService(String phone,String password) throws SQLException;
    //注册
    public int register(User user) throws SQLException;
    //修改密码
    public int updateUser(User user);
    //防止重复注册
    public int repeats(User user) throws SQLException;
    //查询手机号是否存在
//    public int getPhone1(User user) throws SQLException;
}
