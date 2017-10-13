package com.example.zerinasalitrezic.mvpandroidtalks.di.binds;

import com.example.zerinasalitrezic.mvpandroidtalks.presentation.AddNotePresenter;
import com.example.zerinasalitrezic.mvpandroidtalks.presentation.NotesPresenter;
import com.example.zerinasalitrezic.mvpandroidtalks.ui.add_note.AddNoteInterface;
import com.example.zerinasalitrezic.mvpandroidtalks.ui.notes.NotesInterface;

import dagger.Binds;
import dagger.Module;

/**
 * Created by Filip Babic @cobe
 */

@Module(includes = DatabaseBindings.class)
public abstract class PresentationBindings {

    //we define which constructors will be used for Presenter creations, so that when we change
    //a constructor, we do not have to change the "provider" method, dagger does that for us

    @Binds
    public abstract NotesInterface.Presenter notesPresenter(NotesPresenter notesPresenter);

    @Binds
    public abstract AddNoteInterface.Presenter addNotePresenter(AddNotePresenter addNotePresenter);
}
