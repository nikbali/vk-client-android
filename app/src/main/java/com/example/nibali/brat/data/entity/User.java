package com.example.nibali.brat.data.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@EqualsAndHashCode
@Data
public class User extends Owner{

    private String  first_name;
    private String  last_name;

}
