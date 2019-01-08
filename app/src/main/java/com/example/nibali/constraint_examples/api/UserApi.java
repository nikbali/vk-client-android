package com.example.nibali.constraint_examples.api;

import com.vk.sdk.api.model.VKApiUser;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface UserApi {

    @GET("users.get?fields=photo_big")
    Call<List<VKApiUser>> getProfileInfo();

}
