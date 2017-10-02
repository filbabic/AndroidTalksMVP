package com.example.zerinasalitrezic.mvpandroidtalks.common.utils;

/**
 * Created by Zerina Salitrezic on 04/09/2017.
 */

public class StringUtils {

    public static boolean isEmpty(String... text) {
        for (String current : text) {
            if (current == null || current.isEmpty() || current.trim().isEmpty()) {
                return true;
            }
        }
        return false;
    }
}
