package com.example.zerinasalitrezic.mvpandroidtalks.common.utils;

/**
 * Created by Zerina Salitrezic on 08/09/2017.
 */

public class Operations {

    public float sum(float x, float y) {
        return x + y;
    }

    public float minus(float x, float y) {
        return x - y;
    }

    public float multiply(float x, float y) {
        return x * y;
    }

    public float divide(float x, float y) {
        if (y == 0) {
            throw new IllegalArgumentException("Divide by zero!");
        }
        return x / y;
    }
}
