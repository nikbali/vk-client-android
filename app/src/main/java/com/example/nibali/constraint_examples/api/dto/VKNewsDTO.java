package com.example.nibali.constraint_examples.api.dto;

import java.io.Serializable;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class VKNewsDTO implements Serializable {

    private String type;
    private int source_id;
    private long date;
    private int post_id;
    private String post_type;
    private String text;
    private List<VkAttachmentDTO> attachments;

}



