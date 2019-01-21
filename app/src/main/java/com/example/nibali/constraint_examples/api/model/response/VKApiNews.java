package com.example.nibali.constraint_examples.api.model.response;

import com.vk.sdk.api.model.VKApiNote;
import com.vk.sdk.api.model.VKApiPhoto;
import com.vk.sdk.api.model.VKApiPlace;
import com.vk.sdk.api.model.VKApiPost;

import java.util.ArrayList;
import java.util.List;

public class VKApiNews {

    public String type;
    public int source_id;
    public long date;
    public int post_id;
    public String post_type;
    public String text;
    public VkAttachmentDTO attachment;


    public VKApiNews() {
    }
}



