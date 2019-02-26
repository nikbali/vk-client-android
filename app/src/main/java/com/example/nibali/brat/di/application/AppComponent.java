package com.example.nibali.brat.di.application;


import com.example.nibali.brat.ui.activity.LoginActivity;
import com.example.nibali.brat.di.net.NetModule;
import com.example.nibali.brat.di.user.UserComponent;
import com.example.nibali.brat.di.user.UserModule;

import javax.inject.Singleton;

import dagger.Component;


@Singleton
@Component(modules={AppModule.class, NetModule.class})
public interface AppComponent {

    UserComponent plusUserComponent(UserModule userModule);
    void inject(LoginActivity activity);


}
