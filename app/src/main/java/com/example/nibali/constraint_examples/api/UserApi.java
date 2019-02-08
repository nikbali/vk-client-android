package com.example.nibali.constraint_examples.api;

import com.vk.sdk.api.model.VKApiUser;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface UserApi {

    @GET("users.get?fields=photo_big&v=5.92")
    Call<BaseResponse<List<VKApiUser>>> getProfileInfo(@Query("access_token") String token);

}
