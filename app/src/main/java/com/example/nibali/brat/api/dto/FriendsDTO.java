package com.example.nibali.brat.api.dto;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class FriendsDTO implements Serializable {
    @SerializedName("items")
    private List<UserDTO> items;
}