package com.example.nibali.constraint_examples.api.dto;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class VkAttachmentDTO implements Serializable {
    private String type;
    private VkPhotoDTO photo;
}
