package com.example.zerinasalitrezic.mvpandroidtalks.di.binds;

import com.example.zerinasalitrezic.mvpandroidtalks.data.data_manager.DatabaseInterface;
import com.example.zerinasalitrezic.mvpandroidtalks.data.data_manager.DatabaseManager;
import com.example.zerinasalitrezic.mvpandroidtalks.di.providers.DatabaseProviders;

import dagger.Binds;
import dagger.Module;

/**
 * Created by Filip Babic @cobe
 */

@Module(includes = DatabaseProviders.class)
public abstract class DatabaseBindings {

    @Binds
    public abstract DatabaseInterface database(DatabaseManager databaseManager);
}
