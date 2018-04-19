package fr.wildcodeschool.jsonbiere;

import org.junit.Test;
import java.io.IOException;
import static org.junit.Assert.assertEquals;


public class BiereTest {


    @Test
    public void testId() throws IOException {
       assertEquals("Magic Stone Dog (w/Magic Rock & Stone Brewing Co.)",App.rechercheParId(61));
    }

    @Test
    public void testIdHorsZone() throws IOException {
        assertEquals(null, App.rechercheParId(250));
    }

    @Test
    public void testNom() throws IOException {
        assertEquals("- 3 -> Berliner Weisse With Yuzu - B-Sides\n" +
                "- 35 -> Berliner Weisse With Raspberries And Rhubarb - B-Sides\n" +
                "- 36 -> Shipwrecker Circus (w/ Oskar Blues)\n" +
                "- 193 -> Blitz Berliner Weisse\n", App.rechercheParNom("Weisse"));
    }

    @Test
    public void testNomFaux() throws IOException {
        assertEquals("", App.rechercheParNom("ghjksd"));
    }

    @Test
    public void testIngredient() throws IOException {
        assertEquals("- 22 -> Devine Rebel (w/ Mikkeller)\n" +
                "- 24 -> The End Of History\n" +
                "- 32 -> AB:05\n" +
                "- 46 -> Anarchist Alchemist\n" +
                "- 96 -> Lumberjack Stout\n" +
                "- 102 -> Peach Therapy\n" +
                "- 144 -> Tokyo*\n" +
                "- 150 -> AB:13\n" +
                "- 185 -> Tactical Nuclear Penguin\n", App.rechercheParIngredient("Malt", "Extra Pale", 10.0));
    }

    @Test
    public void testIngredientHorsZone() throws IOException {
        assertEquals("", App.rechercheParIngredient("Malt", "Crystal 150", 5.8));
    }

    @Test
    public void testTypeIngredientHorsZone() throws IOException {
        assertEquals("", App.rechercheParIngredient("Pils", "Extra Pale", 5.8));
    }
}
