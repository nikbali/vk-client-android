package com.example.nibali.brat.repository;

import com.example.nibali.brat.entity.User;

import java.util.List;

import io.reactivex.Observable;

public interface IUsersRepository {
    Observable<List<User>> getFriends();
    User getCurrentUser();
}
