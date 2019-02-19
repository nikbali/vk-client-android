package com.example.nibali.constraint_examples.repository.impl;

import android.graphics.Movie;
import android.util.Log;

import com.example.nibali.constraint_examples.api.BaseResponse;
import com.example.nibali.constraint_examples.api.NewsfeedApi;
import com.example.nibali.constraint_examples.api.UserApi;
import com.example.nibali.constraint_examples.api.dto.FriendsDTO;
import com.example.nibali.constraint_examples.api.dto.NewsfeedDTO;
import com.example.nibali.constraint_examples.api.dto.UserDTO;
import com.example.nibali.constraint_examples.entity.Post;
import com.example.nibali.constraint_examples.entity.User;
import com.example.nibali.constraint_examples.repository.IUsersRepository;
import com.google.common.collect.Lists;
import com.vk.sdk.VKAccessToken;
import com.vk.sdk.api.VKApiConst;
import com.vk.sdk.api.VKError;
import com.vk.sdk.api.VKParameters;
import com.vk.sdk.api.VKRequest;
import com.vk.sdk.api.VKResponse;
import com.vk.sdk.api.model.VKApiUser;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import lombok.Data;
import retrofit2.Call;
import retrofit2.Retrofit;

@Data
public class UsersRepository implements IUsersRepository {

    Retrofit retrofit;
    VKAccessToken token;

    @Inject
    public UsersRepository(VKAccessToken vkAccessToken, Retrofit retrofit) {
        this.token = vkAccessToken;
        this.retrofit = retrofit;
    }

    @Override
    public User getCurrentUser(){
        User user = new User();
        VKRequest request = new VKRequest("users.get",
                VKParameters.from(VKApiConst.PHOTO));
        request.executeWithListener(new VKRequest.VKRequestListener() {
            @Override
            public void onComplete(VKResponse response) {
                super.onComplete(response);
                Log.i(UsersRepository.class.getSimpleName(), String.format("Получен ответ: %s", response.responseString));
                try {
                    user.setName(response.json.get("last_name") + " " + response.json.get("first_name"));
                    user.setFirst_name(response.json.get("first_name").toString());
                    user.setLast_name(response.json.get("last_name").toString());
                    user.setPhoto(response.json.get("photo").toString());
                    user.setId((int)response.json.get("id"));

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onError(VKError error) {
                super.onError(error);
            }
        });
        return user;

    }

    @Override
    public Observable<List<User>> getFriends() {
        Observable<BaseResponse<FriendsDTO>> friends = retrofit
                .create(UserApi.class)
                .getFriends(token.accessToken, 20)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

        return friends
                .map(BaseResponse::getResponse)
                .map(FriendsDTO::getItems)
                .map(this::mapVkUserApiToUser);

    }

    private List<User> mapVkUserApiToUser(List<UserDTO> dtoList){
        return dtoList.stream()
                .filter(Objects::nonNull)
                .map(this::mapa)
                .collect(Collectors.toList());
    }
    private User mapa(UserDTO dto){
        User user = new User();
        user.setName(dto.getFirst_name() + " " + dto.getLast_name());
        user.setFirst_name(dto.getFirst_name());
        user.setLast_name(dto.getLast_name());
        user.setPhoto(dto.getPhoto_50());
        user.setId(dto.getId());
        return user;
    }

}
