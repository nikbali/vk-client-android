package com.example.nibali.constraint_examples.ui.fragment.friends;

import android.support.annotation.NonNull;

import com.example.nibali.constraint_examples.entity.User;

import java.util.List;

public interface FriendsView {

    void showFriends(@NonNull List<User> movies);

    void showError(String s);

    void showLoadingIndicator();

    void hideLoadingIndicator();

}
