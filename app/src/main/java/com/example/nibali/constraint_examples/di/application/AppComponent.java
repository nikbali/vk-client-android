package com.example.nibali.constraint_examples.di.application;

import com.example.nibali.constraint_examples.di.user.UserComponent;
import com.example.nibali.constraint_examples.di.user.UserModule;

import javax.inject.Singleton;

import dagger.Component;


@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {

    UserComponent plus(UserModule userModule);
}
