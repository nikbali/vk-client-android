package com.example.nibali.brat.data.network.dto;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Структура ответа метода newsfeed.get (список новостей)
 */
@NoArgsConstructor
@Data
public class NewsfeedDTO implements Serializable {
    @SerializedName("items")
    private List<VKNewsDTO> items;

    @SerializedName("groups")
    private List<VKGroupDTO> groups;

    @SerializedName("next_from")
    private String nextFrom;
}
