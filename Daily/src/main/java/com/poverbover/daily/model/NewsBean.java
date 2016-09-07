package com.poverbover.daily.model;

import com.google.gson.annotations.SerializedName;
import com.poverbover.daily.AppConfig;
import com.poverbover.daily.request.NewsRequest;

import java.io.Serializable;
import java.util.List;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by void on 2016/9/6.
 */
public class NewsBean implements Serializable {
    private String title;
    private String url;
    @SerializedName("img")
    private String imgUrl;
    private String author;
    private long time;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public static void getNews(final OnNewsListListener listener) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(AppConfig.BASE_URL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        NewsRequest request = retrofit.create(NewsRequest.class);
        request.getNews(AppConfig.API_KEY, "popular", 1)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<NewsResult>() {
                    @Override
                    public void call(NewsResult newsResult) {
                        if (newsResult.getCode() == 0)
                            listener.onSuccess(newsResult.getData().getArticle());
                        else listener.onFail(newsResult.getCode());
                    }
                });
    }

    public interface OnNewsListListener {
        void onSuccess(List<NewsBean> list);

        void onFail(int errorCode);
    }
}
