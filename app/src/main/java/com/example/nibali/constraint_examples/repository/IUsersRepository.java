package com.example.nibali.constraint_examples.repository;

import com.example.nibali.constraint_examples.pojo.User;

import java.util.List;

public interface IUsersRepository {
    List<User> getUsers();
    User getCurrentUser();
}
