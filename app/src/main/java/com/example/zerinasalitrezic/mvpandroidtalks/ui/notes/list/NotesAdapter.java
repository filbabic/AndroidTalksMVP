package com.example.zerinasalitrezic.mvpandroidtalks.ui.notes.list;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zerinasalitrezic.mvpandroidtalks.R;
import com.example.zerinasalitrezic.mvpandroidtalks.data.models.NoteModel;
import com.example.zerinasalitrezic.mvpandroidtalks.ui.listeners.OnItemLongClickListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zerina Salitrezic on 04/09/2017.
 */

public class NotesAdapter extends RecyclerView.Adapter<NotesViewHolder> {

    private List<NoteModel> notes = new ArrayList<>();
    private OnItemLongClickListener onItemLongClickListener;

    public void setOnItemLongClickListener(OnItemLongClickListener onItemLongClickListener) {
        this.onItemLongClickListener = onItemLongClickListener;
    }

    public void setNotes(List<NoteModel> notes) {
        this.notes.clear();
        this.notes.addAll(notes);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    @Override
    public NotesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_note, parent, false);
        return new NotesViewHolder(view, onItemLongClickListener);
    }

    @Override
    public void onBindViewHolder(NotesViewHolder holder, int position) {
        NoteModel noteModel = notes.get(position);
        if (noteModel != null) {
            holder.setNoteData(noteModel);
        }
    }

    public void deleteNote(int noteId) {
        for (int i = 0; i < notes.size(); i++) {
            if (notes.get(i).getId() == noteId) {
                notes.remove(notes.get(i));
                notifyItemRemoved(i);
            }
        }
    }
}
