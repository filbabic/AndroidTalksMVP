package com.example.zerinasalitrezic.mvpandroidtalks.data.models;

import java.io.Serializable;

import io.realm.RealmObject;

/**
 * Created by Zerina Salitrezic on 04/09/2017.
 */

public class NoteModel extends RealmObject implements Serializable {

    private int id;
    private String title;
    private String description;
    private long date;

    public NoteModel(String title, String description, long date) {
        this.title = title;
        this.description = description;
        this.date = date;
    }

    public NoteModel() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }
}
