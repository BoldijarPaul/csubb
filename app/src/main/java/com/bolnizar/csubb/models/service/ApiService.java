package com.bolnizar.csubb.models.service;

import com.bolnizar.csubb.models.NewsResponse;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Paul on 6/27/2016.
 */
public interface ApiService {
    @GET("")
    Call<NewsResponse> getNewsResponse();
}
