package com.example.zerinasalitrezic.mvpandroidtalks.data.data_manager;

import com.example.zerinasalitrezic.mvpandroidtalks.common.constants.Constants;
import com.example.zerinasalitrezic.mvpandroidtalks.data.models.NoteModel;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by Zerina Salitrezic on 04/09/2017.
 */

public class DatabaseManager implements DatabaseInterface {

    private Realm realm;

    public DatabaseManager(Realm realm) {
        this.realm = realm;
    }

    @Override
    public void addNote(NoteModel noteModel) {
        if (noteModel != null) {
            int id;
            realm.beginTransaction();
            if (realm.where(NoteModel.class).count() == 0) {
                id = 0;
            } else {
                id = (realm.where(NoteModel.class).max(Constants.ID).intValue() + 1);
            }
            noteModel.setId(id);

            realm.copyToRealm(noteModel);
            realm.commitTransaction();
        }
    }

    @Override
    public List<NoteModel> getNotes() {
        return realm.copyFromRealm(realm.where(NoteModel.class).findAll());
    }

    @Override
    public boolean deleteNote(int noteId) {
        realm.beginTransaction();
        RealmResults<NoteModel> results = realm.where(NoteModel.class).equalTo(Constants.ID, noteId).findAll();
        boolean isDeleted = results.deleteAllFromRealm();
        realm.commitTransaction();
        return isDeleted;
    }
}
