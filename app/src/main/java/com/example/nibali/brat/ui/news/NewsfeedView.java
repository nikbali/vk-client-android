package com.example.nibali.brat.ui.news;

import com.example.nibali.brat.data.entity.Post;
import com.example.nibali.brat.ui.base.MvpView;

import java.util.List;

public interface NewsfeedView extends MvpView {

    void setPosts(List<Post> postList);
}
