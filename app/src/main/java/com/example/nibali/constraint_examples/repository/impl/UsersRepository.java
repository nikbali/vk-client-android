package com.example.nibali.constraint_examples.repository.impl;

import android.util.Log;

import com.example.nibali.constraint_examples.pojo.User;
import com.example.nibali.constraint_examples.repository.IUsersRepository;
import com.google.common.collect.Lists;
import com.vk.sdk.api.VKApi;
import com.vk.sdk.api.VKApiConst;
import com.vk.sdk.api.VKError;
import com.vk.sdk.api.VKParameters;
import com.vk.sdk.api.VKRequest;
import com.vk.sdk.api.VKResponse;
import com.vk.sdk.api.model.VKPhotoArray;

import org.json.JSONException;

import java.util.List;

public class UsersRepository implements IUsersRepository {

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
                    user.setDescription(response.json.get("id").toString());
                    user.setImageUrl(response.json.get("photo").toString());

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
    public List<User> getUsers() {
        return Lists.newArrayList(new User(
                        1L,
                        "http://i.imgur.com/DvpvklR.png",
                        "DevColibri",
                        "devcolibri",
                        "Sample description",
                        "USA",
                        42,
                        42
                ),
                new User(
                        2L,
                        "https://pp.userapi.com/c637516/v637516384/1994a/t3blBbHdXBA.jpg",
                        "Жека Лаврентьев",
                        "geka",
                        "Shwaps man",
                        "Ukraine",
                        42,
                        42
                ));
    }


}
