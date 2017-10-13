package com.example.zerinasalitrezic.mvpandroidtalks.di.injector;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

import com.example.zerinasalitrezic.mvpandroidtalks.App;

import dagger.android.AndroidInjection;
import dagger.android.support.AndroidSupportInjection;

/**
 * Created by Filip Babic @cobe
 */

public class AppInjector implements Application.ActivityLifecycleCallbacks {

    private static AppInjector instance = new AppInjector();

    private AppInjector() {
        //this is a singleton for instantiating automatic injection
    }

    public static void inject(App app) {
        app.registerActivityLifecycleCallbacks(instance);
    }

    @Override
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
        if (activity instanceof Injectable) {
            AndroidInjection.inject(activity);
        } // we check whether or not we can Inject in this Activity

        if (activity instanceof FragmentActivity) {
            ((FragmentActivity) activity).getSupportFragmentManager()
                    .registerFragmentLifecycleCallbacks(instance.getFragmentCallbacks(), true);
        } // we do the same for fragments, check below
    }

    @Override
    public void onActivityStarted(Activity activity) {
    }

    @Override
    public void onActivityResumed(Activity activity) {
    }

    @Override
    public void onActivityPaused(Activity activity) {
    }

    @Override
    public void onActivityStopped(Activity activity) {
    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
    }

    @Override
    public void onActivityDestroyed(Activity activity) {
    }

    private FragmentManager.FragmentLifecycleCallbacks getFragmentCallbacks() {
        return new FragmentManager.FragmentLifecycleCallbacks() {
            @Override
            public void onFragmentCreated(FragmentManager fm, Fragment fragment, Bundle savedInstanceState) {
                super.onFragmentCreated(fm, fragment, savedInstanceState);

                if (fragment instanceof Injectable) {
                    AndroidSupportInjection.inject(fragment);
                }
            }
        };
    }
}
