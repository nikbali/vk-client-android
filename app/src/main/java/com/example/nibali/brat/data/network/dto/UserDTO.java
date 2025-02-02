package com.example.nibali.brat.data.network.dto;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class UserDTO implements Serializable {
    private String photo_50;
    private int id;
    private String first_name;
    private String last_name;

}