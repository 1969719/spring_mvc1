package org.lanqiao.mvc.service;

import org.lanqiao.mvc.pojo.Business;
import org.lanqiao.mvc.pojo.Condition;


import java.sql.SQLException;
import java.util.List;

public interface IBusinessService {
    public int addBusiness(Business business) throws SQLException;
    public List<Business> findAll() throws SQLException;
    public List<Business> getListById(int id) throws SQLException;
    public void drop(int id) throws SQLException;
    public List<Business> serchBusiness(Condition condition) throws SQLException;

}
