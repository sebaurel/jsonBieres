package fr.wildcodeschool.jsonbiere;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) throws IOException {

        //recupere toute les bieres
        //List<Biere> listeBiere = DAOJsonRecherche.rechercheBiere();
        //System.out.println(formatListe(listeBiere));

        //recupere la biere avec l'id 61
        //Biere biere = DAOJsonRecherche.rechercheBiere(61);
        //System.out.println(formatBiere(biere));

        //recupere les bieres contenant le mot beer
        //List<Biere> listeBiere = DAOJsonRecherche.rechercheBiere("Weisse");
        //System.out.println(formatListe(listeBiere));

        //recupere les bieres contenant les ingredients
        List<Biere> listeBiere = DAOJsonRecherche.rechercheBiere("Extra Pale", 6.0);
        System.out.println(formatListe(listeBiere));


    }


    protected static String formatBiere(Biere biere){
        String pourAfficher = "";

        pourAfficher += "\nRéference : " + biere.getId()
                + "\nThe beer " + biere.getName() + " was brewed in " + biere.getFirstBrewed()
                + "\n" + biere.getDescription();

        pourAfficher += "\nIngredients :";


        Iterator<Map.Entry<String, List<Ingredient>>> iterator = biere.getIngredients().entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String, List<Ingredient>> entry = iterator.next();
            pourAfficher += "\n\t" + entry.getKey() + " : ";

            for (Ingredient list : entry.getValue()) {
                pourAfficher += "\n\t\t" + list.getName();
                if (list.getAmount() != null) {
                    pourAfficher += " : " + list.getAmount().getValue() + " " + list.getAmount().getUnit();
                }
            }

        }
            return pourAfficher;

    }

    protected static String formatListe(List<Biere> listeBiere){
        String pourAfficher = "";
        if ( listeBiere != null) {
            for (Biere b : listeBiere) {
                pourAfficher += "- " + b.getId() + " -> " + b.getName() + "\n";
            }
        }
        return pourAfficher;

    }

}
