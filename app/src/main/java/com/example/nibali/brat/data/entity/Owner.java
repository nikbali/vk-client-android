package com.example.nibali.brat.data.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * Абстрактный класс для сущностей: пользователь/группа/страница
 */
@NoArgsConstructor
@EqualsAndHashCode
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
