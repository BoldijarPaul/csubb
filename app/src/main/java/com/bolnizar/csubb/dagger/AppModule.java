package com.bolnizar.csubb.dagger;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Paul on 6/27/2016.
 */
@Module
public class AppModule {

    private final BaseApp mBaseApp;

    public AppModule(BaseApp baseApp) {
        mBaseApp = baseApp;
    }

    @Provides
    @Singleton
    Application provideApplication() {
        return mBaseApp;
    }
}
