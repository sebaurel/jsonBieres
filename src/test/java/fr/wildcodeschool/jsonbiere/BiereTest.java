package fr.wildcodeschool.jsonbiere;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;


public class BiereTest {


    @Test
    public void testId() throws IOException {
       assertEquals("Magic Stone Dog (w/Magic Rock & Stone Brewing Co.)", Biere.rechercheParId(61));
    }

    @Test
    public void testNom() throws IOException {
        assertEquals(80, Biere.rechercheParNom("AB:04"));
    }

    @Test
    public void testongredient() throws IOException {
        assertEquals("Buzz", Biere.rechercheParIngredient("Maris Otter Extra Pale", 2.0));
    }
}
