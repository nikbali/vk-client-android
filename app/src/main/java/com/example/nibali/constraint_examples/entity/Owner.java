package com.example.nibali.constraint_examples.entity;

import com.vk.sdk.api.model.VKApiOwner;

import org.json.JSONObject;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Абстрактный класс для сущностей: пользователь/группа/страница
 */
@NoArgsConstructor
@Data
public abstract class Owner {
    private int     id;
    private String  name;
    private String  photo;

    public Owner(int id, String name, String photo) {
        this.id = id;
        this.name = name;
        this.photo = photo;
    }
}
