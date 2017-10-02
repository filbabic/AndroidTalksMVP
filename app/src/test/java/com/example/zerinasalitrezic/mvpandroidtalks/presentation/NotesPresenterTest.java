package com.example.zerinasalitrezic.mvpandroidtalks.presentation;

import com.example.zerinasalitrezic.mvpandroidtalks.data.models.NoteModel;
import com.example.zerinasalitrezic.mvpandroidtalks.data.data_manager.DatabaseInterface;
import com.example.zerinasalitrezic.mvpandroidtalks.ui.notes.NotesInterface;
import com.example.zerinasalitrezic.mvpandroidtalks.utils.TestUtils;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyListOf;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;

/**
 * Created by Zerina Salitrezic on 08/09/2017.
 */

@RunWith(MockitoJUnitRunner.class)
public class NotesPresenterTest {

    private NotesPresenter presenter;

    @Mock
    NotesInterface.View view;

    @Mock
    DatabaseInterface database;

    @Before
    public void setUp() throws Exception {
        // inicijalizira polja koja imaju Mockito anotacije, ali to ne treba kad imamo @RunWith
        // MockitoAnnotations.initMocks(this);
        presenter = new NotesPresenter(database);
        presenter.setView(view);
    }

    @Test
    public void getNotesNullNotes() throws Exception {
        when(database.getNotes()).thenReturn(null);
        presenter.getNotes();

        verify(database).getNotes();
        verify(view).showNoData();
        verifyNoMoreInteractions(view, database);
    }

    @Test
    public void getNotesEmptyNotes() throws Exception {
        when(database.getNotes()).thenReturn(new ArrayList<NoteModel>());
        presenter.getNotes();

        verify(database).getNotes();
        verify(view).showNoData();
        verifyNoMoreInteractions(view, database);
    }

    @Test
    public void getNotesValidNotes() throws Exception {
        when(database.getNotes()).thenReturn(TestUtils.mockNotesList());
        presenter.getNotes();

        verify(database).getNotes();
        verify(view).hideNoData();
        verify(view).showNotes(anyListOf(NoteModel.class));
        verifyNoMoreInteractions(view, database);
    }

    @Test
    public void clickedAddButtonShouldOpenAddNoteActivity() throws Exception {
        presenter.clickedAddButton();

        verify(view).openAddNoteActivity();
        verifyNoMoreInteractions(view, database);
    }

    @Test
    public void longClickedNoteItemNullNoteModel() throws Exception {
        presenter.longClickedNoteItem(null);

        verifyZeroInteractions(view, database);
    }

    @Test
    public void longClickedNoteItemValidNoteModel() throws Exception {
        presenter.longClickedNoteItem(TestUtils.mockNoteModel());

        verify(view).showDeleteNoteDialog(any(NoteModel.class));
        verifyNoMoreInteractions(view, database);
    }

    @Test
    public void deleteNoteShouldDeleteNoteFromDatabaseUpdateList() throws Exception {
        presenter.clickedDeleteNote(TestUtils.NOTE_ID);

        verify(database).deleteNote(anyInt());
        verify(view).updateNotesList(anyInt());
        verifyNoMoreInteractions(view, database);
    }
}