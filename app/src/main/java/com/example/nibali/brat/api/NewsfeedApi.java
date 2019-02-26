package com.example.nibali.brat.api;

import com.example.nibali.brat.api.dto.NewsfeedDTO;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NewsfeedApi {

    @GET("newsfeed.get")
    Observable<BaseResponse<NewsfeedDTO>> getNewsfeed(@Query("filters") String filters,
                                                       @Query("access_token") String token,
                                                       @Query("count") Integer count,
                                                       @Query("version") String version);
    }
