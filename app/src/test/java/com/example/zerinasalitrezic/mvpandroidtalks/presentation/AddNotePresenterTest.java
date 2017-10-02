package com.example.zerinasalitrezic.mvpandroidtalks.presentation;

import com.example.zerinasalitrezic.mvpandroidtalks.data.models.NoteModel;
import com.example.zerinasalitrezic.mvpandroidtalks.data.data_manager.DatabaseInterface;
import com.example.zerinasalitrezic.mvpandroidtalks.ui.add_note.AddNoteInterface;
import com.example.zerinasalitrezic.mvpandroidtalks.utils.TestUtils;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

/**
 * Created by Zerina Salitrezic on 08/09/2017.
 */

@RunWith(MockitoJUnitRunner.class)
public class AddNotePresenterTest {

    private AddNotePresenter presenter;

    @Mock
    private AddNoteInterface.View view;

    @Mock
    private DatabaseInterface database;

    @Before
    public void setUp() throws Exception {
        presenter = new AddNotePresenter(database);
        presenter.setView(view);
    }

    @Test
    public void clickedSaveButton() throws Exception {
        presenter.clickedSaveButton(TestUtils.TITLE, TestUtils.DESCRIPTION);

        verify(database).addNote(any(NoteModel.class));
        verify(view).showNoteSuccessAdded();
        verify(view).goBack();
        verifyNoMoreInteractions(view, database);
    }

    @Test
    public void onTitleInvalid() throws Exception {
        presenter.onTitleInvalid();

        verify(view).showTitleError();
        verifyNoMoreInteractions(view, database);
    }

    @Test
    public void onDescriptionInvalid() throws Exception {
        presenter.onDescriptionInvalid();

        verify(view).showDescriptionError();
        verifyNoMoreInteractions(view, database);
    }

    @Test
    public void clickedIconBackShouldGoBack() throws Exception {
        presenter.clickedIconBack();

        verify(view).goBack();
        verifyNoMoreInteractions(view, database);
    }
}