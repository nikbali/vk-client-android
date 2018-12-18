package com.example.nibali.constraint_examples.repository.impl;

import com.example.nibali.constraint_examples.pojo.User;
import com.example.nibali.constraint_examples.repository.IUsersRepository;
import com.google.common.collect.Lists;

import java.util.List;

public class UsersRepository implements IUsersRepository {


    @Override
    public List<User> getUsers() {
        return Lists.newArrayList(new User(
                        1L,
                        "http://i.imgur.com/DvpvklR.png",
                        "DevColibri",
                        "devcolibri",
                        "Sample description",
                        "USA",
                        42,
                        42
                ),
                new User(
                        2L,
                        "https://pp.userapi.com/c637516/v637516384/1994a/t3blBbHdXBA.jpg",
                        "Жека Лаврентьев",
                        "geka",
                        "Shwaps man",
                        "Ukraine",
                        42,
                        42
                ));
    }


}
