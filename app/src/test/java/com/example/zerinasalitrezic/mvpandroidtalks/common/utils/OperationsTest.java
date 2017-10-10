package com.example.zerinasalitrezic.mvpandroidtalks.common.utils;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertTrue;

/**
 * Created by Zerina Salitrezic on 07/10/2017.
 */

public class OperationsTest {

    private Operations operations;

    @Before
    public void setUp() throws Exception {
        operations = new Operations();
    }

    @Test
    public void sum() throws Exception {
        float result = operations.sum(3, 2);
        assertTrue(result == 5);
    }

    @Test
    public void minus() throws Exception {
        float result = operations.minus(2, 10);
        assertTrue(result == -8);
    }

    @Test
    public void multiply() throws Exception {
        float result = operations.multiply(-2, 10);
        assertTrue(result == -20);
    }

    @Test
    public void divide() throws Exception {
        float result = operations.divide(20, 5);
        assertTrue(result == 4);
    }

    @Test(expected = IllegalArgumentException.class)
    public void divideWithException() throws Exception {
        operations.divide(5, 0);
    }

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void divideWithCatchingException() throws Exception {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Divide by zero!");
        operations.divide(5, 0);
    }
}