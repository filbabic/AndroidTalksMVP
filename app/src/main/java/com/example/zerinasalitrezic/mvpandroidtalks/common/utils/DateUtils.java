package com.example.zerinasalitrezic.mvpandroidtalks.common.utils;

import com.example.zerinasalitrezic.mvpandroidtalks.common.constants.Constants;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/**
 * Created by Zerina Salitrezic on 04/09/2017.
 */

public class DateUtils {

    public static String getDateStringFormat(long dateInMilliseconds) {
        SimpleDateFormat formatter = new SimpleDateFormat(Constants.DATE_FORMAT, Locale.getDefault());
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(dateInMilliseconds);
        return formatter.format(calendar.getTime());
    }
}
