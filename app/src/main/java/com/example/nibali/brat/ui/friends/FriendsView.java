package com.example.nibali.brat.ui.friends;

import android.support.annotation.NonNull;

import com.example.nibali.brat.data.entity.User;
import com.example.nibali.brat.ui.base.MvpView;

import java.util.List;

public interface FriendsView extends MvpView {

    void showFriends(@NonNull List<User> movies);

}
