package com.example.nibali.constraint_examples.repository.impl;

import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;

import com.example.nibali.constraint_examples.api.NewsfeedApi;
import com.example.nibali.constraint_examples.api.UserApi;
import com.example.nibali.constraint_examples.api.dto.FriendsDTO;
import com.example.nibali.constraint_examples.api.dto.NewsfeedDTO;
import com.example.nibali.constraint_examples.api.dto.VKGroupDTO;
import com.example.nibali.constraint_examples.api.dto.VKNewsDTO;
import com.example.nibali.constraint_examples.api.BaseResponse;
import com.example.nibali.constraint_examples.api.dto.VkAttachmentDTO;
import com.example.nibali.constraint_examples.entity.AttachmentType;
import com.example.nibali.constraint_examples.entity.Group;
import com.example.nibali.constraint_examples.entity.Owner;
import com.example.nibali.constraint_examples.entity.Photo;
import com.example.nibali.constraint_examples.entity.Post;
import com.example.nibali.constraint_examples.entity.User;
import com.example.nibali.constraint_examples.repository.IPostsRepository;
import com.google.common.collect.Lists;
import com.vk.sdk.VKAccessToken;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

@Data
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
    public Observable<List<Post>> getPosts() {

        Observable<BaseResponse<NewsfeedDTO>> newsfeed = retrofit
                .create(NewsfeedApi.class)
                .getNewsfeed("post", token.accessToken, 10, "5.92")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

        return newsfeed
                .map(BaseResponse::getResponse)
                .map(this::convertToPost);
    }

    private List<Post> convertToPost(final NewsfeedDTO newsfeedDTO) {
        List<Post> posts = new ArrayList<>();
        Map<Integer, Owner> groupMap = new HashMap<>();

        for (VKGroupDTO group : newsfeedDTO.getGroups()) {
            if (group.getType().equals("page") || group.getType().equals("group")) {
                groupMap.put(group.getGid(),
                        new Group(group.getGid(), group.getName(), group.getPhoto_medium()));
            }
        }
        for (VKNewsDTO vkNewsDTO : newsfeedDTO.getItems()) {
            if (vkNewsDTO.getSource_id() < 0) {
                List<Photo> attachments = Lists.newArrayList();
                if(vkNewsDTO.getAttachments() != null){
                    for (VkAttachmentDTO vkAttachmentDTO : vkNewsDTO.getAttachments()) {
                        if (vkAttachmentDTO.getType().equals(AttachmentType.PHOTO.getDescription())) {
                            Photo photo = new Photo();
                            photo.setType(AttachmentType.PHOTO);
                            photo.setPhoto_604(vkAttachmentDTO.getPhoto().getSrc_big());
                            attachments.add(photo);
                        }
                    }
                }
                posts.add(
                        new Post(vkNewsDTO.getPost_id(),
                                groupMap.get(Math.abs(vkNewsDTO.getSource_id())),
                                new Date(vkNewsDTO.getDate() * 1000L),
                                vkNewsDTO.getText(),
                                0,
                                0,
                                attachments));
            }
        }
        return posts;
    }

}

