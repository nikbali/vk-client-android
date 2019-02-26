package com.example.nibali.brat.ui.base;


public interface MvpView {

    void showLoading();

    void hideLoading();

    void onError(String message);

}
