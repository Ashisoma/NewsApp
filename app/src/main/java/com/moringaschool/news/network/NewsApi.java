package com.moringaschool.news.network;

import com.moringaschool.news.models.NewsSearchResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NewsApi {

    @GET("top-headlines")
    Call<NewsSearchResponse> getArticles(
            @Query("q") String search
    );
}
