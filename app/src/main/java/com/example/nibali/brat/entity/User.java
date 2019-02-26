package com.example.nibali.brat.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class User extends Owner{

    private String  first_name;
    private String  last_name;

}
