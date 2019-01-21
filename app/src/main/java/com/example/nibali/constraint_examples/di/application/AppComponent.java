package com.example.nibali.constraint_examples.di.application;


import android.content.Context;
import android.content.SharedPreferences;

import com.example.nibali.constraint_examples.activity.LoginActivity;
import com.example.nibali.constraint_examples.activity.MainActivity;
import com.example.nibali.constraint_examples.di.net.NetModule;
import com.example.nibali.constraint_examples.di.user.UserComponent;
import com.example.nibali.constraint_examples.di.user.UserModule;
import com.example.nibali.constraint_examples.fragment.NewsfeedFragment;

import javax.inject.Singleton;

import dagger.Component;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;


@Singleton
@Component(modules={AppModule.class, NetModule.class})
public interface AppComponent {

    UserComponent plusUserComponent(UserModule userModule);
    void inject(LoginActivity activity);


}
