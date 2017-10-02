package com.example.zerinasalitrezic.mvpandroidtalks.ui.notes.list;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.zerinasalitrezic.mvpandroidtalks.R;
import com.example.zerinasalitrezic.mvpandroidtalks.common.utils.DateUtils;
import com.example.zerinasalitrezic.mvpandroidtalks.common.utils.StringUtils;
import com.example.zerinasalitrezic.mvpandroidtalks.data.models.NoteModel;
import com.example.zerinasalitrezic.mvpandroidtalks.ui.listeners.OnItemLongClickListener;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnLongClick;

/**
 * Created by Zerina Salitrezic on 04/09/2017.
 */

public class NotesViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.title)
    TextView title;

    @BindView(R.id.description)
    TextView description;

    @BindView(R.id.date)
    TextView date;

    private OnItemLongClickListener onItemLongClickListener;
    private NoteModel noteModel;

    public NotesViewHolder(View itemView, OnItemLongClickListener onItemLongClickListener) {
        super(itemView);
        this.onItemLongClickListener = onItemLongClickListener;
        ButterKnife.bind(this, itemView);
    }

    public void setNoteData(NoteModel noteModel) {
        if (noteModel != null) {
            this.noteModel = noteModel;
            setTitle(noteModel.getTitle());
            setDescription(noteModel.getDescription());
            setDate(noteModel.getDate());
        }
    }

    private void setTitle(String titleText) {
        if (!StringUtils.isEmpty(titleText)) {
            title.setText(titleText);
        }
    }

    private void setDescription(String descriptionText) {
        if (!StringUtils.isEmpty(descriptionText)) {
            description.setText(descriptionText);
        }
    }

    private void setDate(long dateInMilliseconds) {
        String formattedDate = DateUtils.getDateStringFormat(dateInMilliseconds);
        if (!StringUtils.isEmpty(formattedDate)) {
            date.setText(formattedDate);
        }
    }

    @OnLongClick(R.id.note_layout)
    boolean onLongClickArticleLayout() {
        if (onItemLongClickListener != null && noteModel != null) {
            onItemLongClickListener.onItemLongClick(noteModel);
        }
        return false;
    }
}