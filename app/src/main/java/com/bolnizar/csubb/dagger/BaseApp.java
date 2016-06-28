package com.bolnizar.csubb.dagger;

import android.content.Context;

import com.orm.SugarApp;

/**
 * Created by Paul on 6/27/2016.
 */
public class BaseApp extends SugarApp {

    private AppGraph mGraph;

    @Override
    public void onCreate() {
        super.onCreate();

        mGraph = AppComponent.Initializer.init(this);
        mGraph.inject(this);
    }

    public AppGraph graph() {
        return mGraph;
    }

    public static BaseApp get(Context context) {
        return (BaseApp) context.getApplicationContext();
    }
}
