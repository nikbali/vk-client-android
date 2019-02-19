package com.example.nibali.constraint_examples.di.application;


import com.example.nibali.constraint_examples.ui.activity.LoginActivity;
import com.example.nibali.constraint_examples.di.net.NetModule;
import com.example.nibali.constraint_examples.di.user.UserComponent;
import com.example.nibali.constraint_examples.di.user.UserModule;

import javax.inject.Singleton;

import dagger.Component;


@Singleton
@Component(modules={AppModule.class, NetModule.class})
public interface AppComponent {

    UserComponent plusUserComponent(UserModule userModule);
    void inject(LoginActivity activity);


}
