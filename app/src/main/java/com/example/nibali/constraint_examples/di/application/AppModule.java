package com.example.nibali.constraint_examples.di.application;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;



@Module
public class AppModule {

    private final Application application;

    public AppModule(Application application) {
        this.application = application;
    }

    @Provides
    @Singleton
    Context provideApplicationContext() {
        return application;
    }

/*    @Provides
    @Singleton
    AlbumArtProvider provideAlbumArtProvider() {
        return new BingAlbumArtProvider();
    }

    @Provides
    @Singleton
    VkAudioArray providePlaybackQueue() {
        return Paper.book().read("playbackQueue", new VkAudioArray());
    }

    @Provides
    @Singleton
    ObservableField<VKApiAudio> provideCurrentAudio() {
        return Paper.book().read("currentAudio", new ObservableField<>());
    }

    @Provides
    @Singleton
    @Named("shuffle")
    ObservableBoolean provideShuffleSetting() {
        return Paper.book().read("shuffle", new ObservableBoolean());
    }

    @Provides
    @Singleton
    @Named("repeat")
    ObservableBoolean provideRepeatSetting() {
        return Paper.book().read("repeat", new ObservableBoolean());
    }

    @Provides
    @Singleton
    ObservableField<Bitmap> provideCurrentAlbumArt() {
        return new ObservableField<>();
    }

    @Provides
    @Singleton
    Gson provideGson() {
        return new Gson();
    }*/
}
