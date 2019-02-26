package com.example.nibali.brat.di.user;


import com.example.nibali.brat.ui.main.MainActivity;
import com.example.nibali.brat.ui.friends.FriendsFragment;
import com.example.nibali.brat.ui.news.NewsfeedFragment;

import dagger.Subcomponent;


@UserScope
@Subcomponent(modules = UserModule.class)
public interface UserComponent {
    void inject(MainActivity mainActivity);
    void inject(NewsfeedFragment newsfeedFragment);
    void inject(FriendsFragment friendsFragment);
}
