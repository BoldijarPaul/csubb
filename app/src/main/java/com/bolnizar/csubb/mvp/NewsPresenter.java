package com.bolnizar.csubb.mvp;

import android.content.Context;

import com.bolnizar.csubb.dagger.BaseApp;
import com.bolnizar.csubb.dagger.qualifiers.ApiRo;
import com.bolnizar.csubb.models.NewsResponse;
import com.bolnizar.csubb.models.service.ApiService;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Paul on 6/27/2016.
 */
public class NewsPresenter {

    @Inject
    @ApiRo
    ApiService mApiService;

    private NewsView mNewsView;

    public NewsPresenter(Context context, NewsView newsView) {
        BaseApp.get(context).graph().inject(this);
        mNewsView = newsView;
    }

    public void loadFromServer() {
        Call<NewsResponse> response = mApiService.getNewsResponse();
        response.enqueue(new Callback<NewsResponse>() {
            @Override
            public void onResponse(Call<NewsResponse> call, Response<NewsResponse> response) {
                if (response.body() == null || !"ok".equals(response.body().status)) {
                    mNewsView.showError();
                } else {
                    newsLoadedFromServer(response.body());
                }
            }

            @Override
            public void onFailure(Call<NewsResponse> call, Throwable t) {
                mNewsView.showError();
            }
        });
    }

    private void newsLoadedFromServer(NewsResponse body) {

    }
}
