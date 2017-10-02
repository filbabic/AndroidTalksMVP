package com.example.zerinasalitrezic.mvpandroidtalks.utils;

import com.example.zerinasalitrezic.mvpandroidtalks.data.models.NoteModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zerina Salitrezic on 12/09/2017.
 */

public class TestUtils {

    public static final String TITLE = "title";
    public static final String DESCRIPTION = "description";
    public static final long DATE_MILLISECONDS = 43523L;
    public static int NOTE_ID = 5;

    public static NoteModel mockNoteModel() {
        return new NoteModel(TITLE, DESCRIPTION, DATE_MILLISECONDS);
    }

    public static List<NoteModel> mockNotesList() {
        List<NoteModel> notes = new ArrayList<>();
        notes.add(mockNoteModel());
        return notes;
    }
}
