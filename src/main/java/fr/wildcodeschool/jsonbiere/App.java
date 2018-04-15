package fr.wildcodeschool.jsonbiere;

import java.io.IOException;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {

        //listeBiere = recupereToutesLesBieres();
        //System.out.println(rechercheParIngredient("Extra Pale", 10.0));
        //System.out.println(rechercheParNom("Galaxy"));
        try {
            System.out.println(Biere.rechercheParIngredient("Extra Pale", 10.0));
            System.out.println(Biere.rechercheParNom("AB:04"));
            System.out.println(Biere.rechercheParId(61));
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
