package com.example.nibali.constraint_examples.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public abstract class Attachment {
    private AttachmentType type;
    private int id;
}
