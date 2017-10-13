package com.example.zerinasalitrezic.mvpandroidtalks.di.module;

import com.example.zerinasalitrezic.mvpandroidtalks.data.data_manager.DatabaseInterface;
import com.example.zerinasalitrezic.mvpandroidtalks.data.data_manager.DatabaseManager;
import com.example.zerinasalitrezic.mvpandroidtalks.di.scope.ApplicationScope;

import dagger.Module;
import dagger.Provides;
import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by Filip Babic @cobe
 */

@Module
@ApplicationScope
public class DatabaseModule {

    @Provides
    public RealmConfiguration provideRealmConfiguration() {
        return new RealmConfiguration.Builder().build();
    }

    @Provides
    public Realm provideRealm(RealmConfiguration configuration) {
        return Realm.getInstance(configuration);
    }

    @Provides
    public DatabaseInterface provideDatabase(Realm realm) {
        return new DatabaseManager(realm);
    }

}
