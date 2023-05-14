package com.mhys.model;

import java.io.Serializable;

public class TbBook implements Serializable {
    private Integer book_id;
    private String book_name;
    private String book_author;
    private Float book_price;
    private String book_publisher;
    private Integer book_state;
    private String add_time;

    public Integer getBook_id() {
        return book_id;
    }

    public void setBook_id(Integer book_id) {
        this.book_id = book_id;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public String getBook_author() {
        return book_author;
    }

    public void setBook_author(String book_author) {
        this.book_author = book_author;
    }

    public Float getBook_price() {
        return book_price;
    }

    public void setBook_price(Float book_price) {
        this.book_price = book_price;
    }

    public String getBook_publisher() {
        return book_publisher;
    }

    public void setBook_publisher(String book_publisher) {
        this.book_publisher = book_publisher;
    }

    public Integer getBook_state() {
        return book_state;
    }

    public void setBook_state(Integer book_state) {
        this.book_state = book_state;
    }

    public String getAdd_time() {
        return add_time;
    }

    public void setAdd_time(String add_time) {
        this.add_time = add_time;
    }
}
