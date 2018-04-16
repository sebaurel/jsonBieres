package fr.wildcodeschool.jsonbiere;

import java.io.IOException;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {

        //List<Biere> listeBiere = DAOJsonConnect.recupereToutesLesBieresJson();
        //System.out.println(formatListe(listeBiere));

        Biere biere = DAOJsonRecherche.rechercheBiere(61);
        System.out.println(formatBiere(biere));

    }


    protected static String formatBiere(Biere biere){
        String pourAfficher = "";

        pourAfficher += "\nRéference : " + biere.getId()
                + "\nThe beer " + biere.getName() + " was brewed in " + biere.getFirstBrewed()
                + "\n" + biere.getDescription();

        pourAfficher += "\nMalt :";
        for (int j = 0 ; j < biere.getIngredients().get(0).size() ; j++) {

            //System.out.println(biere.getIngredients().get(i).get(j).toString());
            pourAfficher += "\n\t" + biere.getIngredients().get(0).get(j).getName() + " : " + biere.getIngredients().get(0).get(j).amount.getValue() + " " + biere.getIngredients().get(0).get(j).amount.getUnit();
        }

        pourAfficher += "\nHops :";
        for (int j = 0 ; j < biere.getIngredients().get(1).size() ; j++) {

            //System.out.println(biere.getIngredients().get(i).get(j).toString());
            pourAfficher += "\n\t" + biere.getIngredients().get(1).get(j).getName() + " : " + biere.getIngredients().get(1).get(j).amount.getValue() + " " + biere.getIngredients().get(1).get(j).amount.getUnit();
        }

        //pourAfficher += "\nYeast : " + biere.getIngredients().get(2).get(0).toString();
        pourAfficher += "\nYeast : " + biere.getIngredients().get(2).get(0).getName();
        //System.out.println(biere.getIngredients().get(2).getString("yeast");
        /*for(Malt m : biere.getIngredients().get(0)) {
            pourAfficher += "\n\t" + m.getName() + " : " + m.getAmount().getValue() + " " + m.getAmount().getUnit();
        }
        pourAfficher += "\nHops :";
        for(Hops h : biere.ingredients.hops) {
            pourAfficher += "\n\t" + h.getName() + " : " + h.getAmount().getValue() + " " + h.getAmount().getUnit();
        }
        pourAfficher += "\nYeast : " + biere.ingredients.getYeast();*/

        if (pourAfficher == ""){
            return "No beer";
        }
        else{
            return pourAfficher;
        }
    }

    protected static String formatListe(List<Biere> listeBiere){
        String pourAfficher = "";
        for (Biere b : listeBiere) {
            pourAfficher += "- " + b.getId()+ " -> "+b.getName() + "\n";
        }
        if (pourAfficher == ""){
            return "No beer";
        }
        else{
            return pourAfficher;
        }
    }

}
