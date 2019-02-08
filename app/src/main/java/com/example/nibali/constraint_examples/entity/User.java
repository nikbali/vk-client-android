package com.example.nibali.constraint_examples.entity;

import android.support.annotation.NonNull;

import com.google.common.base.*;

import org.json.JSONObject;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class User extends Owner{

    private String  first_name;
    private String  last_name;

}
