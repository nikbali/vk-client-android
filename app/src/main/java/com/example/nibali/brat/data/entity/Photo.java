package com.example.nibali.brat.data.entity;

import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@EqualsAndHashCode
@Data
public class Photo extends Attachment{
    private Date date;
    private String photo_75;
    private String photo_130;
    private String photo_604;
    private String photo_807;
    private String photo_1280;
    private String photo_2560;

}
