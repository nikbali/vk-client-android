package com.example.nibali.constraint_examples;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;

import com.example.nibali.constraint_examples.activity.LoginActivity;
import com.example.nibali.constraint_examples.di.application.AppComponent;
import com.example.nibali.constraint_examples.di.application.AppModule;
import com.example.nibali.constraint_examples.di.net.DaggerNetComponent;
import com.example.nibali.constraint_examples.di.net.NetComponent;
import com.example.nibali.constraint_examples.di.net.NetModule;
import com.example.nibali.constraint_examples.di.user.DaggerUserComponent;
import com.example.nibali.constraint_examples.di.user.UserComponent;
import com.example.nibali.constraint_examples.di.user.UserModule;
import com.mikepenz.materialdrawer.util.AbstractDrawerImageLoader;
import com.mikepenz.materialdrawer.util.DrawerImageLoader;
import com.squareup.picasso.Picasso;
import com.vk.sdk.VKAccessToken;
import com.vk.sdk.VKAccessTokenTracker;
import com.vk.sdk.VKSdk;
import com.vk.sdk.api.model.VKApiUser;

public class Application extends android.app.Application  {
    private NetComponent netComponent;
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

        netComponent = DaggerNetComponent.builder()
                .appModule(new AppModule(this))
                .netModule(new NetModule("https://api.vk.com/method/"))
                .build();


        vkAccessTokenTracker.startTracking();
        VKSdk.initialize(this);

        DrawerImageLoader.init(new AbstractDrawerImageLoader() {
            @Override
            public void set(ImageView imageView, Uri uri, Drawable placeholder, String tag) {
                Picasso.get().load(uri).into(imageView);
            }
        });
    }

    public NetComponent getNetComponent() {
        return netComponent;
    }

    public UserComponent getUserComponent() {
        return userComponent;
    }

    public UserComponent createUserComponent(final VKApiUser user,final VKAccessToken vkAccessToken) {
        userComponent = DaggerUserComponent.builder()
                .netComponent(netComponent)
                .userModule(new UserModule(user, vkAccessToken))
                .build();
        return userComponent;
    }


    public void releaseUserComponent() {
        userComponent = null;
    }
}
