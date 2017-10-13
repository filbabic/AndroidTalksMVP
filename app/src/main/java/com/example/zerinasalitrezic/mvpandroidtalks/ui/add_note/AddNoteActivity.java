package com.example.zerinasalitrezic.mvpandroidtalks.ui.add_note;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.example.zerinasalitrezic.mvpandroidtalks.App;
import com.example.zerinasalitrezic.mvpandroidtalks.R;
import com.example.zerinasalitrezic.mvpandroidtalks.common.utils.ValidationUtils;
import com.example.zerinasalitrezic.mvpandroidtalks.ui.listeners.OnFormValidationListener;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Zerina Salitrezic on 07/10/2017.
 */

public class AddNoteActivity extends AppCompatActivity implements OnFormValidationListener {

    @BindView(R.id.title)
    TextView title;

    @BindView(R.id.description)
    TextView description;

    @BindString(R.string.empty_error)
    String emptyError;

    @BindString(R.string.success_added_note)
    String successAddedNote;

    public static Intent getLaunchIntent(Context from) {
        return new Intent(from, AddNoteMvpActivity.class);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);
        initUi();
    }

    private void initUi() {
        ButterKnife.bind(this);
    }

    @OnClick(R.id.save)
    void onClickSaveButton() { //comment the database out because we dont provide through the app anymore
//        DatabaseInterface database = App.getDatabaseManager();
        String titleInput = title.getText().toString();
        String descriptionInput = description.getText().toString();
        boolean isFormValid = ValidationUtils.isFormValid(titleInput, descriptionInput, this);
        if (isFormValid) {
//            database.addNote(new NoteModel(titleInput, descriptionInput, System.currentTimeMillis()));
            Toast.makeText(App.getInstance(), successAddedNote, Toast.LENGTH_SHORT).show();
            finish();
        }
    }

    @OnClick(R.id.icon_back)
    void onClickIconBack() {
        finish();
    }

    @Override
    public void onTitleInvalid() {
        title.setError(emptyError);
    }

    @Override
    public void onDescriptionInvalid() {
        description.setError(emptyError);
    }
}