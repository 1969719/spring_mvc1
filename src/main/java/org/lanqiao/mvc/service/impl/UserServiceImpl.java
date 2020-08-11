package org.lanqiao.mvc.service.impl;

import org.lanqiao.mvc.dao.IUserDao;
import org.lanqiao.mvc.dao.Impl.UserDaoImpl;
import org.lanqiao.mvc.pojo.User;
import org.lanqiao.mvc.service.IUserService;

import java.sql.SQLException;
import java.util.List;


public class UserServiceImpl implements IUserService {
     IUserDao userDao = new UserDaoImpl();


    @Override
    public User getUserService(String phone,String password) throws SQLException {
        return userDao.getUser(phone,password);
    }

    @Override
    public int register(User user) throws SQLException {
        return userDao.adduser(user);

    }

    @Override
    public int updateUser(User user) {
        return userDao.updatePwd(user);
    }

    @Override
    public int repeats(User user) throws SQLException {
        return userDao.repeat(user);
    }

//    @Override
//    public <User getPhone1(User user) throws SQLException {
//        return userDao.getPhone(user);
//    }
}

