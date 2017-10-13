package com.example.zerinasalitrezic.mvpandroidtalks.presentation;

import com.example.zerinasalitrezic.mvpandroidtalks.common.utils.ValidationUtils;
import com.example.zerinasalitrezic.mvpandroidtalks.data.data_manager.DatabaseInterface;
import com.example.zerinasalitrezic.mvpandroidtalks.data.models.NoteModel;
import com.example.zerinasalitrezic.mvpandroidtalks.ui.add_note.AddNoteInterface;
import com.example.zerinasalitrezic.mvpandroidtalks.ui.listeners.OnFormValidationListener;

/**
 * Created by Zerina Salitrezic on 04/09/2017.
 */

public class AddNotePresenter implements AddNoteInterface.Presenter, OnFormValidationListener {

    private AddNoteInterface.View view;
    private DatabaseInterface databaseManager;

    public AddNotePresenter(DatabaseInterface databaseInterface) {
        this.databaseManager = databaseInterface;
    }

    @Override
    public void setView(AddNoteInterface.View view) {
        this.view = view;
    }

    @Override
    public void clickedSaveButton(String title, String description) {
        boolean isFormValid = ValidationUtils.isFormValid(title, description, this);

        if (isFormValid) {
            databaseManager.addNote(new NoteModel(title, description, System.currentTimeMillis()));
            view.showNoteSuccessAdded();
            view.goBack();
        }
    }

    @Override
    public void clickedIconBack() {
        view.goBack();
    }

    @Override
    public void onTitleInvalid() {
        view.showTitleError();
    }

    @Override
    public void onDescriptionInvalid() {
        view.showDescriptionError();
    }
}