package com.example.nibali.constraint_examples.di.user;

import com.example.nibali.constraint_examples.repository.IPostsRepository;
import com.example.nibali.constraint_examples.repository.IUsersRepository;
import com.example.nibali.constraint_examples.repository.impl.PostsRepository;
import com.example.nibali.constraint_examples.repository.impl.UsersRepository;
import com.vk.sdk.VKAccessToken;
import com.vk.sdk.api.model.VKApiUser;
import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;


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

    @Provides
    @UserScope
    IPostsRepository provideIPostsRepository(Retrofit retrofit) {
        return new PostsRepository(token, retrofit);
    }

    @Provides
    @UserScope
    IUsersRepository provideIUsersRepository(Retrofit retrofit) {
        return new UsersRepository(token, retrofit);
    }

}
