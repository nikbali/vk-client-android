package com.example.nibali.constraint_examples.di.user;


import com.example.nibali.constraint_examples.activity.MainActivity;
import com.example.nibali.constraint_examples.fragment.NewsfeedFragment;
import com.example.nibali.constraint_examples.repository.IPostsRepository;

import dagger.Subcomponent;


@UserScope
@Subcomponent(modules = UserModule.class)
public interface UserComponent {
    void inject(MainActivity mainActivity);
    void inject(NewsfeedFragment newsfeedFragment);

}
