package com.example.nibali.brat.api;

import com.google.gson.annotations.SerializedName;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *  Класс оборачивает DTO пришедшие с сервера
 * @param <T> тип объекта
 */
@NoArgsConstructor
@Getter
@Setter
public class BaseResponse<T>{
    @Getter
    @Setter
    @SerializedName("response") private T response;
}

