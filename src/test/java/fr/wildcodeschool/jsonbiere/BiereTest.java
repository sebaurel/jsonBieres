package fr.wildcodeschool.jsonbiere;

import org.junit.Test;
import java.io.IOException;
import static org.junit.Assert.assertEquals;


public class BiereTest {


    @Test
    public void testId() throws IOException {
       assertEquals("\nRéference : 61\n" +
               "The beer Magic Stone Dog (w/Magic Rock & Stone Brewing Co.) was brewed in 06/2014\n" +
               "A session IPA brewed with a diverse grain bill, hopped with Simcoe and Amarillo and fermented with saison yeast, for an incredible level of depth in a low ABV beer. Spicy, fruity, complex, refreshing and dry.\n" +
               "Malt :\n" +
               "\tExtra Pale : 2.38 kilograms\n" +
               "\tWheat : 0.44 kilograms\n" +
               "\tTorrified Wheat : 0.44 kilograms\n" +
               "\tRye : 0.19 kilograms\n" +
               "\tFlaked Oats : 0.44 kilograms\n" +
               "\tAmber : 0.19 kilograms\n" +
               "Hops :\n" +
               "\tSimcoe : 25.0 grams\n" +
               "\tAmarillo : 25.0 grams\n" +
               "Yeast : Wyeast 3711 - French Saison™", Biere.rechercheParId(61));
    }

    @Test
    public void testIdHorsZone() throws IOException {
        assertEquals("No beer", Biere.rechercheParId(250));
    }

    @Test
    public void testNom() throws IOException {
        assertEquals("\nRéference : 80\n" +
                "The beer AB:04 was brewed in 08/2010\n" +
                "Imperial Stout brewed with coffee, cocoa, Naga chillies (the hottest in the world), and champagne yeast. Possibly our most acclaimed Abstrakt yet.\n" +
                "Malt :\n" +
                "\tPale Ale Malt : 10.0 kilograms\n" +
                "\tWheat Malt : 0.94 kilograms\n" +
                "\tFlaked Oat Malt : 1.88 kilograms\n" +
                "\tDark Crystal 350 : 1.25 kilograms\n" +
                "\tChocolate : 0.94 kilograms\n" +
                "\tBlack Patent : 0.94 kilograms\n" +
                "Hops :\n" +
                "\tFirst Gold : 75.0 grams\n" +
                "\tFuggles : 75.0 grams\n" +
                "\tFuggles : 62.5 grams\n" +
                "\tCoffee Beans : 37.5 grams\n" +
                "Yeast : Wyeast 1272 - American Ale II™", Biere.rechercheParNom("AB:04"));
    }

    @Test
    public void testNomFaux() throws IOException {
        assertEquals("No beer", Biere.rechercheParNom("Street - beer02"));
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
                "- 185 -> Tactical Nuclear Penguin\n", Biere.rechercheParIngredient("Extra Pale", 10.0));
    }

    @Test
    public void testIngredientHorsImpossible() throws IOException {
        assertEquals("No beer", Biere.rechercheParIngredient("Crystal 150", 5.8));
    }
}
