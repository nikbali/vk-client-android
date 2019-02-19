package com.example.nibali.constraint_examples.repository;

import com.example.nibali.constraint_examples.entity.Post;

import java.util.List;

import io.reactivex.Observable;

public interface IPostsRepository {
    Observable<List<Post>> getPosts();
}
