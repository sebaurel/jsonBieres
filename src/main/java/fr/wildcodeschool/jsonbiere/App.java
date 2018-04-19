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

       //recupere toute une biere au hazard
        Biere biere = DAOJsonRecherche.rechercheBiere();
        System.out.println(formatBiere(biere));
 /*
        //recupere la biere avec l'id 61
        Biere biere = DAOJsonRecherche.rechercheBiere(61);
        System.out.println(formatBiere(biere));

        //recupere les bieres contenant le mot beer
        List<Biere> listeBiere1 = DAOJsonRecherche.rechercheBiere("Weisse");
        System.out.println(formatListe(listeBiere1));

        //recupere les bieres contenant les ingredients
        List<Biere> listeBiere2 = DAOJsonRecherche.rechercheBiere("Malt", "Extra Pale", 10.0);
        System.out.println(formatListe(listeBiere2));
*/

    }

    public static String rechercheParNom(String nom) throws IOException {
        //recupere les bieres contenant le mot beer
        List<Biere> listeBiere = DAOJsonRecherche.rechercheBiere(nom);
        return(formatListe(listeBiere));

    }
    public static String rechercheParId(int id) throws IOException {
        //recupere la biere avec l'id
        Biere biere = DAOJsonRecherche.rechercheBiere(id);
        if (biere != null) {
            return biere.getName();
        } else{
            return null;
        }
    }
    public static String rechercheParIngredient(String type, String nom, double id) throws IOException {
        //recupere les bieres contenant les ingredients
        List<Biere> listeBiere = DAOJsonRecherche.rechercheBiere(type, nom, id);
        return(formatListe(listeBiere));
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
