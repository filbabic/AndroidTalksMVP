package com.example.zerinasalitrezic.mvpandroidtalks.ui.notes;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.zerinasalitrezic.mvpandroidtalks.App;
import com.example.zerinasalitrezic.mvpandroidtalks.R;
import com.example.zerinasalitrezic.mvpandroidtalks.common.utils.DialogUtils;
import com.example.zerinasalitrezic.mvpandroidtalks.data.models.NoteModel;
import com.example.zerinasalitrezic.mvpandroidtalks.presentation.NotesPresenter;
import com.example.zerinasalitrezic.mvpandroidtalks.ui.add_note.AddNoteMvpActivity;
import com.example.zerinasalitrezic.mvpandroidtalks.ui.listeners.OnConfirmDeletingListener;
import com.example.zerinasalitrezic.mvpandroidtalks.ui.listeners.OnItemLongClickListener;
import com.example.zerinasalitrezic.mvpandroidtalks.ui.notes.list.NotesAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Zerina Salitrezic on 12/09/2017.
 */

public class NotesMvpActivity extends AppCompatActivity implements OnItemLongClickListener, OnConfirmDeletingListener, NotesInterface.View {

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    @BindView(R.id.no_data)
    TextView noData;

    private NotesAdapter notesAdapter;
    private NotesInterface.Presenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);
        initUi();
    }

    private void initUi() {
        ButterKnife.bind(this);
        setAdapter();
        setPresenter();
    }

    private void setAdapter() {
        notesAdapter = new NotesAdapter();
        notesAdapter.setOnItemLongClickListener(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(notesAdapter);
    }

    private void setPresenter() {
        presenter = new NotesPresenter(App.getDatabaseManager());
        presenter.setView(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.getNotes();
    }

    @Override
    public void onItemLongClick(int noteId) {
        presenter.longClickedNoteItem(noteId);
    }

    @Override
    public void showNotes(List<NoteModel> notes) {
        notesAdapter.setNotes(notes);
    }

    @Override
    public void showNoData() {
        noData.setVisibility(View.VISIBLE);
    }

    @OnClick(R.id.add_button)
    void onClickAddButton() {
        presenter.clickedAddButton();
    }

    @Override
    public void openAddNoteActivity() {
        startActivity(AddNoteMvpActivity.getLaunchIntent(this));
    }

    @Override
    public void hideNoData() {
        noData.setVisibility(View.GONE);
    }

    @Override
    public void showDeleteNoteDialog(int noteId) {
        DialogUtils.showInfoDialog(this, noteId, this);
    }

    @Override
    public void onClickedDelete(int noteId) {
        presenter.clickedDeleteNote(noteId);
    }

    @Override
    public void updateNotesList(int noteId) {
        notesAdapter.deleteNote(noteId);
    }

}
