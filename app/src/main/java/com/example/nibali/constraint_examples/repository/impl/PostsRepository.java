package com.example.nibali.constraint_examples.repository.impl;

import com.example.nibali.constraint_examples.pojo.Post;
import com.example.nibali.constraint_examples.pojo.User;
import com.example.nibali.constraint_examples.repository.IPostsRepository;
import com.example.nibali.constraint_examples.repository.IUsersRepository;
import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.List;

public class PostsRepository implements IPostsRepository {
    private IUsersRepository iUsersRepository = new UsersRepository();

    @Override
    public List<Post> getPosts() {

        return Lists.newArrayList(
                new Post(iUsersRepository.getUsers().get(0), 1L, "Dec 13", "Очень длинное описание твита 1",
                        4L, 4L, "https://www.w3schools.com/w3css/img_fjords.jpg"),

                new Post(iUsersRepository.getUsers().get(0), 2L, "Dec 12", "Очень длинное описание твита 2",
                        5L, 5L, "https://www.w3schools.com/w3images/lights.jpg"),

                new Post(iUsersRepository.getUsers().get(0), 3L, "Dec 11", "Очень длинное описание твита 3",
                        6L, 6L, "https://www.w3schools.com/css/img_mountains.jpg")
        );
    }

}

