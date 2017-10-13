package com.example.zerinasalitrezic.mvpandroidtalks.di.providers;

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
public class DatabaseProviders {

    //standard definition of providers, used only for things that do not have a regular constructor
    //or that cannot be created with us (such as Context, or Realm in this case)

    @Provides
    public RealmConfiguration provideRealmConfiguration() {
        return new RealmConfiguration.Builder().build();
    }

    @Provides
    public Realm provideRealm(RealmConfiguration configuration) {
        return Realm.getInstance(configuration);
    }
}
