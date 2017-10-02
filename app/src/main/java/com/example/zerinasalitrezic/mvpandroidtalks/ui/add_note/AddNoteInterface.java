package com.example.zerinasalitrezic.mvpandroidtalks.ui.add_note;

/**
 * Created by Zerina Salitrezic on 04/09/2017.
 */

public interface AddNoteInterface {

    interface View {

        void showTitleError();

        void showDescriptionError();

        void showNoteSuccessAdded();

        void goBack();
    }

    interface Presenter {

        void setView(View view);

        void clickedSaveButton(String title, String description);

        void clickedIconBack();
    }
}
