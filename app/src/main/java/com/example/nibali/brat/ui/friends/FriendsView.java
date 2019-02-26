package com.example.nibali.brat.ui.friends;

import android.support.annotation.NonNull;

import com.example.nibali.brat.data.entity.User;

import java.util.List;

public interface FriendsView {

    void showFriends(@NonNull List<User> movies);

    void showError(String s);

    void showLoadingIndicator();

    void hideLoadingIndicator();

}
