package com.example.zerinasalitrezic.mvpandroidtalks.ui.operations;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertTrue;

/**
 * Created by Zerina Salitrezic on 08/09/2017.
 */

public class OperationsTest {

    private Operations operations;

    @Before
    public void setUp() throws Exception {
        //pocetni Operations objekt, da ne dupliramo u svakom testu (@Before znaci da ce se pokrenuti svaki put prije svakog testa)
        //postoji i @After koji je suprotnost @Before
        //ponekad trebamo pokrenuti samo jednom - @BeforeClass ili @AfterClass (moraju biti static)
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

    //divide metoda baca exception ako je broj s kojim dijelimo 0 (nema rijesenja, beskonacno je)
    // moramo dodati ocekivanu Exception klasu
    @Test(expected = IllegalArgumentException.class)
    public void divideWithException() throws Exception {
        operations.divide(5, 0);
    }

    @Rule
    public ExpectedException exception = ExpectedException.none();

    // ili ako zelimo uhvatiti exception poruku, trebamo koristiti ExpectedException rule (pravilo)
    // i dodati ocekivanu exception klasu i poruku prije izvodjenja metode
    @Test
    public void divideWithCatchingException() throws Exception {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Divide by zero!");
        operations.divide(5, 0);
    }
}