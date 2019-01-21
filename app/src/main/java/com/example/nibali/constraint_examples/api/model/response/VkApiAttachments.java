package com.example.nibali.constraint_examples.api.model.response;

import com.google.gson.annotations.SerializedName;
import com.vk.sdk.api.model.VKApiPhoto;

import java.util.List;

public class VkApiAttachments {
    @SerializedName("type")
    String type;

    @SerializedName("photo")
    VKApiPhoto photo;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public VKApiPhoto getPhoto() {
        return photo;
    }

    public void setPhoto(VKApiPhoto photo) {
        this.photo = photo;
    }
}
