package com.example.zerinasalitrezic.mvpandroidtalks.di.module;

import com.example.zerinasalitrezic.mvpandroidtalks.data.data_manager.DatabaseInterface;
import com.example.zerinasalitrezic.mvpandroidtalks.presentation.AddNotePresenter;
import com.example.zerinasalitrezic.mvpandroidtalks.presentation.NotesPresenter;
import com.example.zerinasalitrezic.mvpandroidtalks.ui.add_note.AddNoteInterface;
import com.example.zerinasalitrezic.mvpandroidtalks.ui.notes.NotesInterface;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Filip Babic @cobe
 */

@Module(includes = DatabaseModule.class)
public class PresentationModule {

    @Provides
    public NotesInterface.Presenter provideNotesPresenter(DatabaseInterface databaseInterface) {
        return new NotesPresenter(databaseInterface);
    }

    @Provides
    public AddNoteInterface.Presenter provideAddNotePresenter(DatabaseInterface databaseInterface) {
        return new AddNotePresenter(databaseInterface);
    }
}
