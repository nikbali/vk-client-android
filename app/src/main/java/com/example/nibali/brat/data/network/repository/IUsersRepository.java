package com.example.nibali.brat.data.network.repository;


import com.example.nibali.brat.data.entity.User;

import java.util.List;

import io.reactivex.Observable;

public interface IUsersRepository {
    Observable<List<User>> getFriends();
    User getCurrentUser();
}
