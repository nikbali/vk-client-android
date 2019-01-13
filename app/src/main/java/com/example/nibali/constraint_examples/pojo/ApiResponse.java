package com.example.nibali.constraint_examples.pojo;

import com.google.gson.annotations.SerializedName;

public class ApiResponse <T>{
    @SerializedName("response") private T response;

    public T getResponse() {
        return response;
    }

    public void setResponse(T response) {
        this.response = response;
    }
}

