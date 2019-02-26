package com.example.nibali.brat.data.network;

import com.example.nibali.brat.data.network.dto.FriendsDTO;
import com.vk.sdk.api.model.VKApiUser;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface UserApi {

    @GET("users.get?fields=photo_big&v=5.92")
    Call<BaseResponse<List<VKApiUser>>> getProfileInfo(@Query("access_token") String token);

    @GET("friends.get?fields=photo_50&v=5.92")
    Observable<BaseResponse<FriendsDTO>> getFriends(@Query("access_token") String token, @Query("count")  int count);

}
