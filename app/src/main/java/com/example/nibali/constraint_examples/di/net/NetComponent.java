package com.example.nibali.constraint_examples.di.net;

import android.content.SharedPreferences;

import com.example.nibali.constraint_examples.activity.LoginActivity;
import com.example.nibali.constraint_examples.activity.MainActivity;
import com.example.nibali.constraint_examples.di.application.AppModule;

import javax.inject.Singleton;

import dagger.Component;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

@Singleton
@Component(modules={AppModule.class, NetModule.class})
public interface NetComponent {
    void inject(LoginActivity activity);
    Retrofit retrofit();
    OkHttpClient okHttpClient();
    SharedPreferences sharedPreferences();
}
