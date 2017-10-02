package com.example.zerinasalitrezic.mvpandroidtalks.data.data_manager;

import com.example.zerinasalitrezic.mvpandroidtalks.data.models.NoteModel;

import java.util.List;

/**
 * Created by Zerina Salitrezic on 04/09/2017.
 */

public interface DatabaseInterface {

    void addNote(NoteModel noteModel);

    List<NoteModel> getNotes();

    void deleteNote(int noteId);
}
