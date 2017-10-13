package com.example.zerinasalitrezic.mvpandroidtalks.presentation;

import com.example.zerinasalitrezic.mvpandroidtalks.data.data_manager.DatabaseInterface;
import com.example.zerinasalitrezic.mvpandroidtalks.data.models.NoteModel;
import com.example.zerinasalitrezic.mvpandroidtalks.ui.notes.NotesInterface;

import java.util.List;

/**
 * Created by Zerina Salitrezic on 11/10/2017.
 */

public class NotesPresenter implements NotesInterface.Presenter {

    private NotesInterface.View view;
    private DatabaseInterface databaseManager;

    public NotesPresenter(DatabaseInterface databaseInterface) {
        this.databaseManager = databaseInterface;
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
    public void longClickedNoteItem(int noteId) {
        view.showDeleteNoteDialog(noteId);
    }

    @Override
    public void clickedDeleteNote(int noteId) {
        boolean isNoteDeleted = databaseManager.deleteNote(noteId);

        if (isNoteDeleted) {
            view.updateNotesList(noteId);
        }
    }
}