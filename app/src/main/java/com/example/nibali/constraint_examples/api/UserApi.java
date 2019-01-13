package com.example.nibali.constraint_examples.api;

import com.example.nibali.constraint_examples.pojo.ApiResponse;
import com.vk.sdk.api.VKResponse;
import com.vk.sdk.api.model.VKApiUser;
import com.vk.sdk.api.model.VKList;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface UserApi {

    //fields=photo_big&v=5.92&access_token=
    @GET("users.get?fields=photo_big&v=5.92")
    Call<ApiResponse<List<VKApiUser>>> getProfileInfo(@Query("access_token") String token);

}
