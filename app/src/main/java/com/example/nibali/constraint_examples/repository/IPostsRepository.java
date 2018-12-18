package com.example.nibali.constraint_examples.repository;

import com.example.nibali.constraint_examples.pojo.Post;
import com.example.nibali.constraint_examples.pojo.User;

import java.util.List;

public interface IPostsRepository {
    List<Post> getPosts();
}
