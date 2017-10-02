package com.example.zerinasalitrezic.mvpandroidtalks.common.utils;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;

import com.example.zerinasalitrezic.mvpandroidtalks.R;
import com.example.zerinasalitrezic.mvpandroidtalks.ui.listeners.OnConfirmDeletingListener;

/**
 * Created by Zerina Salitrezic on 11/09/2017.
 */

public class DialogUtils {

    public static void showInfoDialog(Context context, final int noteId, final OnConfirmDeletingListener onConfirmDeletingListener) {
        if (context != null) {
            AlertDialog dialog = new AlertDialog.Builder(context)
                    .setCancelable(true)
                    .setMessage(R.string.delete_note_message)
                    .setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            if (onConfirmDeletingListener != null) {
                                onConfirmDeletingListener.onClickedDelete(noteId);
                            }
                        }
                    })
                    .setNegativeButton(R.string.cancel, null)
                    .create();
            dialog.show();
        }
    }
}
