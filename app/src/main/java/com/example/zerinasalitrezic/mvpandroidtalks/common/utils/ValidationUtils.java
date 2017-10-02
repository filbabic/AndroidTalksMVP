package com.example.zerinasalitrezic.mvpandroidtalks.common.utils;

import com.example.zerinasalitrezic.mvpandroidtalks.ui.listeners.OnFormValidationListener;

/**
 * Created by Zerina Salitrezic on 04/09/2017.
 */

public class ValidationUtils {

    public static boolean isFormValid(String title, String description, OnFormValidationListener listener) {
        boolean isValidTitle;
        boolean isValidDescription;

        if (StringUtils.isEmpty(title)) {
            isValidTitle = false;
            listener.onTitleInvalid();
        } else {
            isValidTitle = true;
        }

        if (StringUtils.isEmpty(description)) {
            isValidDescription = false;
            listener.onDescriptionInvalid();
        } else {
            isValidDescription = true;
        }

        return isValidTitle && isValidDescription;
    }
}
