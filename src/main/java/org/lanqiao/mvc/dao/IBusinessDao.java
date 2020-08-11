package org.lanqiao.mvc.dao;



import org.lanqiao.mvc.pojo.Business;
import org.lanqiao.mvc.pojo.Condition;
import org.lanqiao.mvc.pojo.User;

import java.sql.SQLException;
import java.util.List;

public interface IBusinessDao {
    //插入
    public void addBusiness(Business business) throws SQLException;
    //获取列表信息
    public List<Business> getAll() throws SQLException;

    public List<Business> getListById(int id) throws SQLException;
    //删除
    public void delete(int id) throws SQLException;
    //条件查询
    public List<Business> findByCondition(Condition condition) throws SQLException;
}
