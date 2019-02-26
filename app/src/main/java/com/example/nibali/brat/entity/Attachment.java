package com.example.nibali.brat.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public abstract class Attachment {
    private AttachmentType type;
    private int id;
}
