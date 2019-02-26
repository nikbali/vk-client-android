package com.example.nibali.brat.data.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@EqualsAndHashCode
@Data
public abstract class Attachment {
    private AttachmentType type;
    private int id;
}
