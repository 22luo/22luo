package com.mhys.model;

import java.io.Serializable;

public class TbCategory implements Serializable {
    private int id;
    private String cname;//分类名称

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    @Override
    public String toString() {
        return "TbCategory{" +
                "id=" + id +
                ", cname='" + cname + '\'' +
                '}';
    }
}
