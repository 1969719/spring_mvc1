package org.lanqiao.mvc.pojo;

public class Condition {
    private String name;
    private String uid;

    public Condition() {
    }

    public Condition(String name, String uid) {
        this.name = name;
        this.uid = uid;
    }

    public Condition(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    @Override
    public String toString() {
        return "Condition{" +
                "name='" + name + '\'' +
                ", uid='" + uid + '\'' +
                '}';
    }
}