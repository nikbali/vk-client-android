package com.example.nibali.brat.ui.news;

import com.example.nibali.brat.ui.base.MvpPresenter;

public interface NewsfeedPresenter<V extends NewsfeedView>  extends MvpPresenter<V> {
    void showPosts();
}
