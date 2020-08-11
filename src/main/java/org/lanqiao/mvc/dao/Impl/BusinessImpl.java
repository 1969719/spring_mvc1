package org.lanqiao.mvc.dao.Impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.lanqiao.mvc.Util.JdbcUtils;
import org.lanqiao.mvc.dao.IBusinessDao;
import org.lanqiao.mvc.pojo.Business;
import org.lanqiao.mvc.pojo.Condition;
import org.lanqiao.mvc.pojo.User;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BusinessImpl implements IBusinessDao {
    @Override
    public void addBusiness(Business business) throws SQLException {
        QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
        String sql = "insert into business (uid,miaoshu,finance,business,pay,oa,production,website,taxes,name,phone,channel,hiredate,other) values (?,?,?,?,?,?,?,?,?,?,?,?,now(),?)";
        qr.update(sql,business.getUid(),business.getMiaoshu(),business.getFinance(),business.getBusiness(),business.getPay(),business.getOa(),business.getProduction(),business.getWebsite(),business.getTaxes(),business.getName(),business.getPhone(),business.getChannel(),business.getOther());


//        QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
//        String sql = "insert into business (uid,miaoshu,finance,business,pay,oa,production,website,taxes,name,phone,channel,hiredate,other) values (?,?,?,?,?,?,?,?,?,?,?,?,now(),?) where business.uid = user.id";
//        qr.update(sql,user.getId(),business.getMiaoshu(),business.getFinance(),business.getBusiness(),business.getPay(),business.getOa(),business.getProduction(),business.getWebsite(),business.getTaxes(),business.getName(),business.getPhone(),business.getChannel(),business.getOther());
    }

    @Override
    public List<Business> getAll() throws SQLException {
        QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
        String sql = "select  id,miaoshu,finance,business,pay,oa,production,website,taxes,name,phone,channel,hiredate,other,plan,sal from business";
        List<Business> businessList = (List<Business>) qr.query(sql,new BeanListHandler(Business.class));
        return businessList;
    }

    @Override
    public List<Business> getListById(int id) throws SQLException {
        QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
        String sql = "select  id,miaoshu,finance,business,pay,oa,production,website,taxes,name,phone,channel,hiredate,other,plan,sal from business where uid = ?";
        List<Business> businessList = (List<Business>) qr.query(sql,new BeanListHandler(Business.class),id);
        return businessList;
    }

    @Override
    public void delete(int id) throws SQLException {
            QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
            String sql = "delete from business where id = ?";
            qr.update(sql,id);
        }

    @Override
    public List<Business> findByCondition(Condition condition) throws SQLException {
        QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
        StringBuffer sqlBuff = new StringBuffer("select miaoshu,finance,business,pay,oa,production,website,taxes,name,phone,channel,hiredate,other from business  where 1=1");
        List<Object> paramList = new ArrayList<>();
        if (condition.getName()!=null){
            sqlBuff.append(" and name like ?");
            paramList.add(condition.getName());
        }
        List<Business> serchList = qr.query(sqlBuff.toString(),new BeanListHandler<>(Business.class),paramList.toArray());
        return serchList;
    }




}
