package com.example.nibali.constraint_examples.repository.impl;

import android.content.Intent;
import android.widget.Toast;

import com.example.nibali.constraint_examples.Application;
import com.example.nibali.constraint_examples.activity.LoginActivity;
import com.example.nibali.constraint_examples.activity.MainActivity;
import com.example.nibali.constraint_examples.api.NewsfeedApi;
import com.example.nibali.constraint_examples.api.UserApi;
import com.example.nibali.constraint_examples.api.model.response.NewsfeedDTO;
import com.example.nibali.constraint_examples.api.model.response.VKApiGroup;
import com.example.nibali.constraint_examples.api.model.response.VKApiNews;
import com.example.nibali.constraint_examples.pojo.ApiResponse;
import com.example.nibali.constraint_examples.pojo.Post;
import com.example.nibali.constraint_examples.pojo.User;
import com.example.nibali.constraint_examples.repository.IPostsRepository;
import com.example.nibali.constraint_examples.repository.IUsersRepository;
import com.google.common.collect.Lists;
import com.vk.sdk.VKAccessToken;
import com.vk.sdk.api.model.VKApiCommunity;
import com.vk.sdk.api.model.VKApiUser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class PostsRepository implements IPostsRepository {
    Retrofit retrofit;
    VKAccessToken token;

    @Inject
    public PostsRepository(VKAccessToken vkAccessToken, Retrofit retrofit) {
        this.token = vkAccessToken;
        this.retrofit = retrofit;
    }

    List<Post> postList = new ArrayList<>();

    @Override
    public List<Post> getPosts() {

        Call<ApiResponse<NewsfeedDTO>> newsfeed = retrofit
                .create(NewsfeedApi.class)
                .getNewsfeed("post", token.accessToken, 10, "5.92");

        newsfeed.enqueue(new Callback<ApiResponse<NewsfeedDTO>>() {
            @Override
            public void onResponse(Call<ApiResponse<NewsfeedDTO>> call, Response<ApiResponse<NewsfeedDTO>> response) {
                NewsfeedDTO newsfeedDTOList = null;
                if (response.body() != null) {
                    newsfeedDTOList = response.body().getResponse();
                    postList.addAll(convertToPost(newsfeedDTOList));

                }
            }

            @Override
            public void onFailure(Call<ApiResponse<NewsfeedDTO>> call, Throwable t) {
                throw new RuntimeException(t);
            }
        });
        return postList;
    }

    private List<Post> convertToPost(final NewsfeedDTO newsfeedDTO) {
        List<Post> postList = new ArrayList<>();
        Map<Integer, User> userMap = new HashMap<>();

            for (VKApiGroup group : newsfeedDTO.groups) {
                userMap.put(group.gid, new User(group.gid,
                        group.photo_medium,
                        group.name,
                        group.name,
                        null,
                        null,
                        0,
                        0));
            }
            for (VKApiNews vkApiNews : newsfeedDTO.items) {
                if (vkApiNews.source_id < 0 && vkApiNews.attachment != null && vkApiNews.attachment.type.equals("photo")) {
                        postList.add(new Post(userMap.get(Math.abs(vkApiNews.source_id)),
                                (long) vkApiNews.post_id,
                                String.valueOf(vkApiNews.date),
                                vkApiNews.text,
                                11L,
                                11L,
                                vkApiNews.attachment.photo.src_big));

                }
            }

        return postList;
    }

}

