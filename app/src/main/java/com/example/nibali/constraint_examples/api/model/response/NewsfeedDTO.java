package com.example.nibali.constraint_examples.api.model.response;

import com.google.gson.annotations.SerializedName;
import com.vk.sdk.api.model.VKApiCommunity;
import com.vk.sdk.api.model.VKApiUser;

import java.util.List;

/**
 * Структура ответа метода newsfeed.get
 */
public class NewsfeedDTO {
    @SerializedName("items")
    public List<VKApiNews> items;

    @SerializedName("profiles")
    public List<VKApiUser> profiles;

    @SerializedName("groups")
    public List<VKApiCommunity> groups;

    @SerializedName("next_from")
    public String nextFrom;
}
