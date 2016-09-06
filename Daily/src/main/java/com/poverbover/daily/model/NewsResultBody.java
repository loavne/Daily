package com.poverbover.daily.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by void on 2016/9/6.
 */
public class NewsResultBody implements Serializable{

    private String channel;
    private List<NewsBean> article;

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public List<NewsBean> getArticle() {
        return article;
    }

    public void setArticle(List<NewsBean> article) {
        this.article = article;
    }
}
