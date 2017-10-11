package com.example.zerinasalitrezic.mvpandroidtalks.presentation;

import com.example.zerinasalitrezic.mvpandroidtalks.data.data_manager.DatabaseInterface;
import com.example.zerinasalitrezic.mvpandroidtalks.data.models.NoteModel;
import com.example.zerinasalitrezic.mvpandroidtalks.ui.notes.NotesInterface;
import com.example.zerinasalitrezic.mvpandroidtalks.utils.TestUtils;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyListOf;
import static org.mockito.Mockito.*;

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
        presenter = new NotesPresenter(database);
        presenter.setView(view);
    }

    @Test
    public void getNotesNullNotes() throws Exception {
        //arrange 
        when(database.getNotes()).thenReturn(null);

        //act
        presenter.getNotes();

        //assert
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
    public void longClickedNoteItem() throws Exception {
        presenter.longClickedNoteItem(TestUtils.NOTE_ID);

        verify(view).showDeleteNoteDialog(anyInt());
        verifyNoMoreInteractions(view, database);
    }

    @Test
    public void deleteNoteShouldDeleteNoteFromDatabaseUpdateList() throws Exception {
        when(database.deleteNote(TestUtils.NOTE_ID)).thenReturn(true);
        presenter.clickedDeleteNote(TestUtils.NOTE_ID);

        verify(database).deleteNote(anyInt());
        verify(view).updateNotesList(anyInt());
        verifyNoMoreInteractions(view, database);
    }
}