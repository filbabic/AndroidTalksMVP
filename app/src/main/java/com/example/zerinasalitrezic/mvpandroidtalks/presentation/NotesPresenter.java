package com.example.zerinasalitrezic.mvpandroidtalks.presentation;

import com.example.zerinasalitrezic.mvpandroidtalks.data.models.NoteModel;
import com.example.zerinasalitrezic.mvpandroidtalks.data.data_manager.DatabaseInterface;
import com.example.zerinasalitrezic.mvpandroidtalks.ui.notes.NotesInterface;

import java.util.List;

/**
 * Created by Zerina Salitrezic on 04/09/2017.
 */

public class NotesPresenter implements NotesInterface.Presenter {

    // ne zelimo stvoriti memory leak ukoliko Activity bude unisten u bilo kojem trenutku
    private NotesInterface.View view;
    private DatabaseInterface databaseManager;

    public NotesPresenter(DatabaseInterface databaseInterface) {
        databaseManager = databaseInterface;
    }

    @Override
    public void setView(NotesInterface.View view) {
        this.view = view;
    }

    @Override
    public void getNotes() {
        List<NoteModel> notes = databaseManager.getNotes();
        if (notes != null && !notes.isEmpty()) {
            view.hideNoData();
            view.showNotes(notes);
        } else {
            view.showNoData();
        }
    }

    @Override
    public void clickedAddButton() {
        view.openAddNoteActivity();
    }

    @Override
    public void longClickedNoteItem(NoteModel noteModel) {
        if (noteModel != null) {
            view.showDeleteNoteDialog(noteModel);
        }
    }

    @Override
    public void clickedDeleteNote(int noteId) {
        databaseManager.deleteNote(noteId);
        view.updateNotesList(noteId);
    }
}
