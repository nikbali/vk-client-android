package com.example.nibali.constraint_examples.di.user;


import com.example.nibali.constraint_examples.ui.activity.MainActivity;
import com.example.nibali.constraint_examples.ui.fragment.friends.FriendsFragment;
import com.example.nibali.constraint_examples.ui.fragment.news.NewsfeedFragment;

import dagger.Subcomponent;


@UserScope
@Subcomponent(modules = UserModule.class)
public interface UserComponent {
    void inject(MainActivity mainActivity);
    void inject(NewsfeedFragment newsfeedFragment);
    void inject(FriendsFragment friendsFragment);
}
