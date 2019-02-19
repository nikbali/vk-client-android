package com.example.nibali.constraint_examples.repository;

import com.example.nibali.constraint_examples.entity.User;

import java.util.List;

import io.reactivex.Observable;

public interface IUsersRepository {
    Observable<List<User>> getFriends();
    User getCurrentUser();
}
