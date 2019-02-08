package com.example.nibali.constraint_examples.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Group extends Owner{

    public Group(int id, String name, String photo) {
        super(id, name, photo);
    }
}
