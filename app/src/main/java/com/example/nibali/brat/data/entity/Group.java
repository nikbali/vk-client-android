package com.example.nibali.brat.data.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@EqualsAndHashCode
@Data
public class Group extends Owner{

    public Group(int id, String name, String photo) {
        super(id, name, photo);
    }
}
