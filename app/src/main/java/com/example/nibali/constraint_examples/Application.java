package com.example.nibali.constraint_examples;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;

import com.example.nibali.constraint_examples.ui.activity.LoginActivity;
import com.example.nibali.constraint_examples.di.application.AppComponent;
import com.example.nibali.constraint_examples.di.application.AppModule;
import com.example.nibali.constraint_examples.di.application.DaggerAppComponent;
import com.example.nibali.constraint_examples.di.net.NetModule;
import com.example.nibali.constraint_examples.di.user.UserComponent;
import com.example.nibali.constraint_examples.di.user.UserModule;

import com.vk.sdk.VKAccessToken;
import com.vk.sdk.VKAccessTokenTracker;
import com.vk.sdk.VKSdk;
import com.vk.sdk.api.model.VKApiUser;

public class Application extends android.app.Application  {
    private AppComponent appComponent;
    private UserComponent userComponent;

    VKAccessTokenTracker vkAccessTokenTracker = new VKAccessTokenTracker() {
        @Override
        public void onVKAccessTokenChanged(VKAccessToken oldToken, VKAccessToken newToken) {
            if (newToken == null) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        }
    };
    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .netModule(new NetModule("https://api.vk.com/method/"))
                .build();

        vkAccessTokenTracker.startTracking();
        VKSdk.initialize(this);

    }

    public AppComponent getAppComponent() {
        return appComponent;
    }

    public UserComponent getUserComponent() {
        return userComponent;
    }

    public UserComponent createUserComponent(final VKApiUser user,final VKAccessToken vkAccessToken) {
        userComponent = appComponent.plusUserComponent(new UserModule(user, vkAccessToken));
        return userComponent;
    }

    public void releaseUserComponent() {
        userComponent = null;
    }
}
