package com.example.nibali.constraint_examples.di.user;


import com.example.nibali.constraint_examples.activity.LoginActivity;
import com.example.nibali.constraint_examples.activity.MainActivity;
import com.example.nibali.constraint_examples.di.net.NetComponent;

import dagger.Component;
import dagger.Subcomponent;


@UserScope
@Component(dependencies = NetComponent.class,
        modules = {UserModule.class})
public interface UserComponent {
    void inject(MainActivity mainActivity);
}
