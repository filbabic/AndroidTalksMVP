package com.example.zerinasalitrezic.mvpandroidtalks.ui.notes;

import com.example.zerinasalitrezic.mvpandroidtalks.data.models.NoteModel;

import java.util.List;

/**
 * Created by Zerina Salitrezic on 04/09/2017.
 */

public interface NotesInterface {

    interface View {

        void showNotes(List<NoteModel> notes);

        void openAddNoteActivity();

        void showNoData();

        void hideNoData();

        void showDeleteNoteDialog(NoteModel noteModel);

        void updateNotesList(int noteId);
    }

    interface Presenter {

        void setView(View view);

        void getNotes();

        void clickedAddButton();

        void longClickedNoteItem(NoteModel noteModel);

        void clickedDeleteNote(int noteId);
    }
}
