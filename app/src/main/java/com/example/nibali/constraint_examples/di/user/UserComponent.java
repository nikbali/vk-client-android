package com.example.nibali.constraint_examples.di.user;


import com.example.nibali.constraint_examples.activity.LoginActivity;
import com.example.nibali.constraint_examples.activity.MainActivity;

import dagger.Subcomponent;


@UserScope
@Subcomponent(modules = {UserModule.class})
public interface UserComponent {
    void inject(MainActivity mainActivity);
}
