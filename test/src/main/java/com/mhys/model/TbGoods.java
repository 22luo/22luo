package com.mhys.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class TbGoods implements Serializable {

    private int id;
    private String title;//标题
    private BigDecimal price;//价格
    private int sale;//销量
    private int cateid;//分类


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getSale() {
        return sale;
    }

    public void setSale(int sale) {
        this.sale = sale;
    }

    public int getCateid() {
        return cateid;
    }

    public void setCateid(int cateid) {
        this.cateid = cateid;
    }

    @Override
    public String toString() {
        return "TbGoods{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", sale=" + sale +
                ", cateid=" + cateid +
                '}';
    }
}
