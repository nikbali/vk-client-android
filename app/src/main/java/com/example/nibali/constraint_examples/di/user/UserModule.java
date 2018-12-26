package com.example.nibali.constraint_examples.di.user;

import com.vk.sdk.api.model.VKApiUser;
import dagger.Module;
import dagger.Provides;


@Module
public class UserModule {

    private final VKApiUser user;

    public UserModule(VKApiUser user) {
        this.user = user;
    }

    @Provides
    @UserScope
    VKApiUser provideApiUser() {
        return user;
    }

}
