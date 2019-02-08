package com.example.nibali.constraint_examples.api;

import com.example.nibali.constraint_examples.api.dto.NewsfeedDTO;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NewsfeedApi {

    @GET("newsfeed.get")
    Call<BaseResponse<NewsfeedDTO>> getNewsfeed(@Query("filters") String filters,
                                                @Query("access_token") String token,
                                                @Query("count") Integer count,
                                                @Query("version") String version);
    }
