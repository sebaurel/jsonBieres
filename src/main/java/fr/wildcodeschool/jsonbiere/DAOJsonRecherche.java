package fr.wildcodeschool.jsonbiere;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class DAOJsonRecherche {
    private static List<Biere> listeBiere = new ArrayList<>();

    public DAOJsonRecherche() {
    }

    public static Biere rechercheBiere() throws IOException {
        String recherche = "https://api.punkapi.com/v2/beers/random";

        List<Biere> listeBiere = DAOJsonConnect.recupereLesBieresJson(recherche);
        Biere biere = null;
        if(listeBiere.size()>0) {
            biere = listeBiere.get(0);
        }
        return biere;
    }
    public static List<Biere> rechercheBiere(String nom) throws IOException {
        return rechercheParNom(nom);

    }
    public static Biere rechercheBiere(int id) throws IOException {
        return rechercheParId(id);

    }
    public static List<Biere> rechercheBiere(String type, String ingredient, double quantite) throws IOException {
        return rechercheParIngredient(type, ingredient, quantite);

    }

    private static List<Biere> rechercheParNom(String rechercheNom) throws IOException {

        String urlBiere = "https://api.punkapi.com/v2/beers?beer_name=" + rechercheNom;

        List<Biere> listeBiere = DAOJsonConnect.recupereLesBieresJson(urlBiere);

        return listeBiere;
    }

    private static Biere rechercheParId(int rechercheId) throws IOException {
        String recherche = "https://api.punkapi.com/v2/beers/" + rechercheId;


        List<Biere> listeBiere = DAOJsonConnect.recupereLesBieresJson(recherche);
        Biere biere = null;
        if(listeBiere.size()>0) {
            biere = listeBiere.get(0);
        }
        return biere;

    }

    private static List<Biere> rechercheParIngredient(String typeIngredient, String rechercheIngredient, double rechercheQuantite) throws IOException {

        listeBiere = DAOJsonConnect.recupereLesBieresJson("all");
        List<Biere> bieresAvecIngredient = new ArrayList<>();
        for (Biere b : listeBiere) {

            Iterator<Map.Entry<String, List<Ingredient>>> iterator = b.getIngredients().entrySet().iterator();

            while (iterator.hasNext()){
                Map.Entry<String, List<Ingredient>> entry = iterator.next();
                if (entry.getKey() == typeIngredient){

                    for (Ingredient list : entry.getValue()) {

                        if (list.getAmount() != null) {
                            if (list.getName().equals(rechercheIngredient) && list.getAmount().getValue() >= rechercheQuantite) {
                                bieresAvecIngredient.add(b);
                            }
                        }
                    }
                }
            }
        }
        return bieresAvecIngredient;
    }
}
