package com.example.zerinasalitrezic.mvpandroidtalks;

import android.app.Application;

import com.example.zerinasalitrezic.mvpandroidtalks.di.component.AppComponent;
import com.example.zerinasalitrezic.mvpandroidtalks.di.component.DaggerAppComponent;

import io.realm.Realm;

/**
 * Created by Zerina Salitrezic on 04/09/2017.
 */

public class App extends Application {

    private static App instance;
    private static AppComponent appComponent;

    private static void setInstance(App app) {
        instance = app;
    }

    public static App getInstance() {
        return instance;
    }

    public static AppComponent getAppComponent() {
        return appComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        setInstance(this);
        Realm.init(this);

        appComponent = DaggerAppComponent.builder().build();

        appComponent.inject(this);
    }
}
