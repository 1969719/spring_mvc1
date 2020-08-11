package org.lanqiao.mvc.service.impl;

import org.lanqiao.mvc.dao.IBusinessDao;
import org.lanqiao.mvc.dao.Impl.BusinessImpl;
import org.lanqiao.mvc.pojo.Business;
import org.lanqiao.mvc.pojo.Condition;
import org.lanqiao.mvc.service.IBusinessService;

import java.sql.SQLException;
import java.util.List;

public class BusinessServiceImpl implements IBusinessService {
    IBusinessDao businessDao = new BusinessImpl();
    @Override
    public int addBusiness(Business business) throws SQLException {
        businessDao.addBusiness(business);
        return 0;
    }

    @Override
    public List<Business> findAll() throws SQLException {
       return businessDao.getAll();

    }

    @Override
    public List<Business> getListById(int id) throws SQLException {
        return businessDao.getListById(id);

    }

    @Override
    public void drop(int id) throws SQLException {
        businessDao.delete(id);
    }

    @Override
    public List<Business> serchBusiness(Condition condition) throws SQLException {
        return businessDao.findByCondition(condition);
    }


}
