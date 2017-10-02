package com.example.zerinasalitrezic.mvpandroidtalks.ui.notes;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.zerinasalitrezic.mvpandroidtalks.R;
import com.example.zerinasalitrezic.mvpandroidtalks.common.utils.DialogUtils;
import com.example.zerinasalitrezic.mvpandroidtalks.data.models.NoteModel;
import com.example.zerinasalitrezic.mvpandroidtalks.data.data_manager.DatabaseInterface;
import com.example.zerinasalitrezic.mvpandroidtalks.data.data_manager.DatabaseManager;
import com.example.zerinasalitrezic.mvpandroidtalks.ui.add_note.AddNoteActivity;
import com.example.zerinasalitrezic.mvpandroidtalks.ui.listeners.OnConfirmDeletingListener;
import com.example.zerinasalitrezic.mvpandroidtalks.ui.listeners.OnItemLongClickListener;
import com.example.zerinasalitrezic.mvpandroidtalks.ui.notes.list.NotesAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.realm.Realm;

/**
 * Created by Zerina Salitrezic on 04/09/2017.
 */

public class NotesActivity extends AppCompatActivity implements OnItemLongClickListener, OnConfirmDeletingListener {

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    @BindView(R.id.no_data)
    TextView noData;

    private NotesAdapter notesAdapter;
    private DatabaseInterface database;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);
        initUi();
    }

    private void initUi() {
        ButterKnife.bind(this);
        setAdapter();
    }

    private void setAdapter() {
        notesAdapter = new NotesAdapter();
        notesAdapter.setOnItemLongClickListener(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(notesAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        getNotesFromDatabase();
    }

    private void getNotesFromDatabase() {
        database = new DatabaseManager(Realm.getDefaultInstance());
        List<NoteModel> notes = database.getNotes();
        if (notes != null && !notes.isEmpty()) {
            noData.setVisibility(View.GONE);
            notesAdapter.setNotes(notes);
        } else {
            noData.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onItemLongClick(NoteModel noteModel) {
        if (noteModel != null) {
            DialogUtils.showInfoDialog(this, noteModel.getId(), this);
        }
    }

    @Override
    public void onClickedDelete(int noteId) {
        database.deleteNote(noteId);
        notesAdapter.deleteNote(noteId);
    }

    @OnClick(R.id.add_button)
    void onClickAddButton() {
        startActivity(AddNoteActivity.getLaunchIntent(this));
    }
}
