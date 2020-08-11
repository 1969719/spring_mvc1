package org.lanqiao.mvc.pojo;

import java.util.Date;

public class Business {
    private int id;
    private String uid;
    private String miaoshu;//描述
    private String finance;//财务
    private String business;//业务
    private String pay;//薪资
    private String oa;
    private String production;//生产
    private String website;//网站
    private String taxes;//税酬
    private String name;//姓名
    private String phone;//电话
    private String channel;//渠道
    private Date hiredate;//当前时间
    private String other;
    private String plan;//进度
    private String sal;//佣金
    public Business() {
    }

    public Business(String uid, String miaoshu, String finance, String business, String pay, String oa, String production, String website, String taxes, String name, String phone, String channel, Date hiredate, String other, String plan) {
        this.uid = uid;
        this.miaoshu = miaoshu;
        this.finance = finance;
        this.business = business;
        this.pay = pay;
        this.oa = oa;
        this.production = production;
        this.website = website;
        this.taxes = taxes;
        this.name = name;
        this.phone = phone;
        this.channel = channel;
        this.hiredate = hiredate;
        this.other = other;
        this.plan = plan;
    }

    public Business(String miaoshu, String finance, String business, String pay, String oa, String production, String website, String taxes, String name, String phone, String channel, Date hiredate, String other, String plan, String sal) {
        this.miaoshu = miaoshu;
        this.finance = finance;
        this.business = business;
        this.pay = pay;
        this.oa = oa;
        this.production = production;
        this.website = website;
        this.taxes = taxes;
        this.name = name;
        this.phone = phone;
        this.channel = channel;
        this.hiredate = hiredate;
        this.other = other;
        this.plan = plan;
        this.sal = sal;
    }

    public Business(String miaoshu, String finance, String business, String pay, String oa, String production, String website, String taxes, String name, String phone, String channel, Date hiredate, String other) {
        this.miaoshu = miaoshu;
        this.finance = finance;
        this.business = business;
        this.pay = pay;
        this.oa = oa;
        this.production = production;
        this.website = website;
        this.taxes = taxes;
        this.name = name;
        this.phone = phone;
        this.channel = channel;
        this.hiredate = hiredate;
        this.other = other;
    }

    public Business(String miaoshu, String finance, String business, String pay, String oa, String production, String website, String taxes, String name, String phone, String channel, Date hiredate, String other, String plan) {
        this.miaoshu = miaoshu;
        this.finance = finance;
        this.business = business;
        this.pay = pay;
        this.oa = oa;
        this.production = production;
        this.website = website;
        this.taxes = taxes;
        this.name = name;
        this.phone = phone;
        this.channel = channel;
        this.hiredate = hiredate;
        this.other = other;
        this.plan = plan;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getMiaoshu() {
        return miaoshu;
    }

    public void setMiaoshu(String miaoshu) {
        this.miaoshu = miaoshu;
    }

    public String getFinance() {
        return finance;
    }

    public void setFinance(String finance) {
        this.finance = finance;
    }

    public String getBusiness() {
        return business;
    }

    public void setBusiness(String business) {
        this.business = business;
    }

    public String getPay() {
        return pay;
    }

    public void setPay(String pay) {
        this.pay = pay;
    }

    public String getOa() {
        return oa;
    }

    public void setOa(String oa) {
        this.oa = oa;
    }

    public String getProduction() {
        return production;
    }

    public void setProduction(String production) {
        this.production = production;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getTaxes() {
        return taxes;
    }

    public void setTaxes(String taxes) {
        this.taxes = taxes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public Date getHiredate() {
        return hiredate;
    }

    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }

    public String getSal() {
        return sal;
    }

    public void setSal(String sal) {
        this.sal = sal;
    }

    @Override
    public String toString() {
        return "Business{" +
                "id=" + id +
                ", uid=" + uid +
                ", miaoshu='" + miaoshu + '\'' +
                ", finance='" + finance + '\'' +
                ", business='" + business + '\'' +
                ", pay='" + pay + '\'' +
                ", oa='" + oa + '\'' +
                ", production='" + production + '\'' +
                ", website='" + website + '\'' +
                ", taxes='" + taxes + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", channel='" + channel + '\'' +
                ", hiredate=" + hiredate +
                ", other='" + other + '\'' +
                ", plan='" + plan + '\'' +
                ", sal='" + sal + '\'' +
                '}';
    }

    public Business(String uid, String miaoshu, String finance, String business, String pay, String oa, String production, String website, String taxes, String name, String phone, String channel, Date hiredate, String other) {
        this.uid = uid;
        this.miaoshu = miaoshu;
        this.finance = finance;
        this.business = business;
        this.pay = pay;
        this.oa = oa;
        this.production = production;
        this.website = website;
        this.taxes = taxes;
        this.name = name;
        this.phone = phone;
        this.channel = channel;
        this.hiredate = hiredate;
        this.other = other;
    }

    public Object setUid(Object uid) {
        return business.toString();
    }
}
