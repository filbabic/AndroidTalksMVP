package com.example.zerinasalitrezic.mvpandroidtalks.di.contributors;

import com.example.zerinasalitrezic.mvpandroidtalks.di.binds.PresentationBindings;
import com.example.zerinasalitrezic.mvpandroidtalks.ui.add_note.AddNoteMvpActivity;
import com.example.zerinasalitrezic.mvpandroidtalks.ui.notes.NotesMvpActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by Filip Babic @cobe
 */

@Module(includes = PresentationBindings.class)
public abstract class ActivityContributorModule {

    //we define which activities will be drawn in the dagger graph for automatic injection

    @ContributesAndroidInjector
    abstract NotesMvpActivity notesMvpActivity();

    @ContributesAndroidInjector
    abstract AddNoteMvpActivity addNoteMvpActivity();
}
