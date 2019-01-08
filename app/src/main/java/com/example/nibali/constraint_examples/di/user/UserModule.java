package com.example.nibali.constraint_examples.di.user;

import com.vk.sdk.VKAccessToken;
import com.vk.sdk.api.model.VKApiUser;
import dagger.Module;
import dagger.Provides;


@Module
public class UserModule {

    private final VKApiUser user;
    private final VKAccessToken token;

    public UserModule(final VKApiUser user, final VKAccessToken token) {
        this.user = user;
        this.token = token;
    }

    @Provides
    @UserScope
    VKApiUser provideApiUser() {
        return user;
    }

    @Provides
    @UserScope
    VKAccessToken provideAccessToken() {
        return token;
    }

}
