package com.example.zerinasalitrezic.mvpandroidtalks;

import android.app.Activity;
import android.app.Application;

import com.example.zerinasalitrezic.mvpandroidtalks.di.component.DaggerAppComponent;
import com.example.zerinasalitrezic.mvpandroidtalks.di.injector.AppInjector;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import io.realm.Realm;

/**
 * Created by Zerina Salitrezic on 04/09/2017.
 */

public class App extends Application implements HasActivityInjector {

    private static App instance;

    @Inject
    DispatchingAndroidInjector<Activity> activityAndroidInjector;

    private static void setInstance(App app) {
        instance = app;
    }

    public static App getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        setInstance(this);
        Realm.init(this);

        DaggerAppComponent.builder()
                .app(this)
                .build()
                .inject(this);

        AppInjector.inject(this);
    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return activityAndroidInjector;
    }
}
