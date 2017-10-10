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
import com.example.zerinasalitrezic.mvpandroidtalks.presentation.AddNotePresenter;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Zerina Salitrezic on 04/09/2017.
 */

public class AddNoteMvpActivity extends AppCompatActivity implements AddNoteInterface.View {

    @BindView(R.id.title)
    TextView title;

    @BindView(R.id.description)
    TextView description;

    @BindString(R.string.empty_error)
    String emptyError;

    @BindString(R.string.success_added_note)
    String successAddedNote;

    private AddNoteInterface.Presenter presenter;

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
        setPresenter();
    }

    private void setPresenter() {
        presenter = new AddNotePresenter(App.getDatabaseManager());
        presenter.setView(this);
    }

    @OnClick(R.id.save)
    void onClickSaveButton() {
        presenter.clickedSaveButton(title.getText().toString(), description.getText().toString());
    }

    @OnClick(R.id.icon_back)
    void onClickIconBack() {
        presenter.clickedIconBack();
    }

    @Override
    public void showTitleError() {
        title.setError(emptyError);
    }

    @Override
    public void showDescriptionError() {
        description.setError(emptyError);
    }

    @Override
    public void showNoteSuccessAdded() {
        Toast.makeText(App.getInstance(), successAddedNote, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void goBack() {
        finish();
    }
}
