package com.example.nibali.brat.data.network.repository;

import com.example.nibali.brat.data.entity.Post;

import java.util.List;

import io.reactivex.Observable;

public interface IPostsRepository {
    Observable<List<Post>> getPosts();
}
