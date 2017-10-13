package com.example.zerinasalitrezic.mvpandroidtalks.di.component;

import android.content.Context;

import com.example.zerinasalitrezic.mvpandroidtalks.App;
import com.example.zerinasalitrezic.mvpandroidtalks.di.contributors.ActivityContributorModule;
import com.example.zerinasalitrezic.mvpandroidtalks.di.scope.ApplicationScope;
import com.example.zerinasalitrezic.mvpandroidtalks.ui.add_note.AddNoteMvpActivity;
import com.example.zerinasalitrezic.mvpandroidtalks.ui.notes.NotesMvpActivity;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;

/**
 * Created by Filip Babic @cobe
 */

//we include the AndroidInjector for setup, and ActivityContributors
//for automatic injection in said activities

@Component(modules = {AndroidInjectionModule.class, ActivityContributorModule.class})
@ApplicationScope
public interface AppComponent {

    @Component.Builder
    interface Builder {

        //this means that wherever we use Context we do not have to provide it, we use the App
        //it's just here for showcase, we don't need context for now
        @BindsInstance
        Builder app(Context app);

        AppComponent build();
    }

    //standard injections

    void inject(App app);

    void inject(NotesMvpActivity app);

    void inject(AddNoteMvpActivity addNoteMvpActivity);
}
