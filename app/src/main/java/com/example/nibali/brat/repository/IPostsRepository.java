package com.example.nibali.brat.repository;

import com.example.nibali.brat.entity.Post;

import java.util.List;

import io.reactivex.Observable;

public interface IPostsRepository {
    Observable<List<Post>> getPosts();
}
