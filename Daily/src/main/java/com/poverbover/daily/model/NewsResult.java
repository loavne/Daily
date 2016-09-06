package com.poverbover.daily.model;

import java.io.Serializable;

/**
 * Created by void on 2016/9/6.
 */
public class NewsResult implements Serializable{
    private int code;
    private NewsResultBody data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public NewsResultBody getData() {
        return data;
    }

    public void setData(NewsResultBody data) {
        this.data = data;
    }
}
