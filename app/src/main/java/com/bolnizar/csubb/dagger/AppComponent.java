package com.bolnizar.csubb.dagger;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Paul on 6/27/2016.
 */
@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent extends AppGraph {
    final class Initializer {
        private Initializer() {
        } // No instances

        public static AppGraph init(BaseApp app) {
            return DaggerAppComponent.builder()
                    .appModule(new AppModule(app))
                    .build();
        }
    }
}
