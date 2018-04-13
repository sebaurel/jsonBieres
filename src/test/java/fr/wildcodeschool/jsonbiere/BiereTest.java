package fr.wildcodeschool.jsonbiere;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;


public class BiereTest {


    @Test
    public void testId() throws IOException {
       assertEquals("Buzz", Biere.rechercheParId(1));
    }

    @Test
    public void testNom() throws IOException {
        assertEquals(80, Biere.rechercheParNom("AB:04"));
    }
}
