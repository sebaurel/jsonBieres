package fr.wildcodeschool.jsonbiere;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DAOJsonRecherche {
    private static List<Biere> listeBiere = new ArrayList<>();


    public static List<Biere> rechercheBiere() throws IOException {
        return DAOJsonConnect.recupereLesBieresJson("all");

    }
    public static List<Biere> rechercheBiere(String nom) throws IOException {
        return rechercheParNom(nom);

    }
    public static Biere rechercheBiere(int id) throws IOException {
        return rechercheParId(id);

    }
    public static List<Biere> rechercheBiere(String ingredient, double quantite) throws IOException {
        return rechercheParIngredient(ingredient, quantite);

    }

    private static List<Biere> rechercheParNom(String rechercheNom) throws IOException {

        String urlBiere = "https://api.punkapi.com/v2/beers?beer_name=" + rechercheNom;

        List<Biere> listeBiere = DAOJsonConnect.recupereLesBieresJson(urlBiere);

        return listeBiere;
    }

    private static Biere rechercheParId(int rechercheId) throws IOException {
        String recherche = "https://api.punkapi.com/v2/beers/" + rechercheId;

        List<Biere> listeBiere = DAOJsonConnect.recupereLesBieresJson(recherche);
        Biere biere = listeBiere.get(0);

        return biere;

    }

    private static List<Biere> rechercheParIngredient(String rechercheIngredient, double rechercheQuantite) throws IOException {

        listeBiere = DAOJsonConnect.recupereLesBieresJson("all");
        List<Biere> bieresAvecIngredient = new ArrayList<>();
        for (Biere b : listeBiere) {
            for (int i = 0 ; i < b.getIngredients().size() ; i++){


                //Revoir la selection des ingrediant en s'inspirant de la methode de l'app formatBiere

                Ingredient ingredient = (Ingredient)b.getIngredients().get(0);

                if (ingredient.getName().equals(rechercheIngredient) && ingredient.getAmount().getValue() >= rechercheQuantite){
                    bieresAvecIngredient.add(b);
                }
            }
        }
        return bieresAvecIngredient;
    }
}
