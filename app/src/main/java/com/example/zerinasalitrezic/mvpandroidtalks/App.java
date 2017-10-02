package com.example.zerinasalitrezic.mvpandroidtalks;

import android.app.Application;

import com.example.zerinasalitrezic.mvpandroidtalks.data.data_manager.DatabaseInterface;
import com.example.zerinasalitrezic.mvpandroidtalks.data.data_manager.DatabaseManager;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by Zerina Salitrezic on 04/09/2017.
 */

public class App extends Application {

    private static App instance;
    private static DatabaseInterface databaseManager;

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
        setRealm();
        setDatabaseManager();
    }

    private void setRealm() {
        Realm.init(this);
        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder()
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(realmConfiguration);
    }

    public static void setDatabaseManager() {
        databaseManager = new DatabaseManager(Realm.getDefaultInstance());
    }

    public static DatabaseInterface getDatabaseManager() {
        return databaseManager;
    }
}
