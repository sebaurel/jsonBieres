package fr.wildcodeschool.jsonbiere;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DAOJsonRecherche {
    private static List<Biere> listeBiere = new ArrayList<>();


    public static Biere rechercheBiere() throws IOException {
        return null;

    }
    public static Biere rechercheBiere(String nom) throws IOException {
        return null;

    }
    public static Biere rechercheBiere(int id) throws IOException {
        return rechercheParId(id);

    }
    public static Biere rechercheBiere(String ingredient, double quantite) throws IOException {
        return null;

    }

    private static List<Biere> rechercheParNom(String rechercheNom) throws IOException {

        listeBiere = DAOJsonConnect.recupereToutesLesBieresJson();

        List<Biere> bieresAvecNom = new ArrayList<>();
        Biere biere = null;
        boolean found = false;

        for (Biere b : listeBiere) {
            if (b.getName().equals(rechercheNom) ){
                biere = b;
                found = true;
            }
        }
        return bieresAvecNom;
    }

    private static Biere rechercheParId(int rechercheId) throws IOException {

        listeBiere = DAOJsonConnect.recupereToutesLesBieresJson();
        Biere biere = null;
        boolean found = false;
        for (Biere b : listeBiere) {
            if (b.getId() == rechercheId){
                biere = b;
                found = true;
            }
        }

        return biere;

    }

    private static List<Biere> rechercheParIngredient(String rechercheIngredient, double rechercheQuantite) throws IOException {

        listeBiere = DAOJsonConnect.recupereToutesLesBieresJson();
        List<Biere> bieresAvecIngredient = new ArrayList<>();
        /*for (Biere b : listeBiere) {
            for(Malt m : b.ingredients.malt) {
                if (m.getName().equals(rechercheIngredient) && m.amount.getValue() >= rechercheQuantite){
                    bieresAvecIngredient.add(b);
                }
            }
        }*/
        return bieresAvecIngredient;
    }
}
