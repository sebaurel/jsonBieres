package fr.wildcodeschool.jsonbiere;


import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Biere {

    static Scanner entree = new Scanner(System.in);

    private int id ;
    private String name;
    private String first_brewed;
    private String description;
    private Ingredients ingredients;
    private static List<Biere> listeBiere = new ArrayList<>();


    private Biere(JsonObject jsonObject) {


        setId(jsonObject.getInt("id"));
        setName(jsonObject.getString("name"));
        setFirst_brewed(jsonObject.getString("first_brewed"));
        setDescription(jsonObject.getString("description"));
        setIngredients(jsonObject.getJsonObject("ingredients"));


    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getFirst_brewed() {
        return first_brewed;
    }
    public void setFirst_brewed(String first_brewed) {
        this.first_brewed = first_brewed;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Object getIngredients() {
        return ingredients;
    }

    public void setIngredients(JsonObject ingredients) {
        this.ingredients =  new Ingredients(ingredients);
    }

    /*private static List<Biere> recupereToutesLesBieres() throws IOException {
        int i = 1;
        boolean uneBiere = true;
        List<Biere> listeBiere = new ArrayList<>();
        Biere biere = null;
        while (uneBiere) {
            String urlBiere = "https://api.punkapi.com/v2/beers/" + i;
            URL url = null;
            try {
                url = new URL(urlBiere);
            } catch (MalformedURLException e) {
                uneBiere = false;
            }
            InputStream streamUrl = null;
            try {
                streamUrl = url.openStream();
                JsonReader reader = Json.createReader(streamUrl);
                JsonArray jsonArray = reader.readArray();
                JsonObject jsonObject = jsonArray.getJsonObject(0);
                biere = new Biere(jsonObject);
                listeBiere.add(biere);
            }
            catch (java.io.FileNotFoundException e){
                uneBiere = false;
            }
            i++;
        }
        return listeBiere;

    }*/

    private static List<Biere> recupereToutesLesBieresParPaquet() throws IOException {

        boolean uneBiere = true;
        int page = 1;
        List<Biere> listeBiere = new ArrayList<>();
        Biere biere = null;
        JsonArray jsonArray = null;

        while (uneBiere) {
            String urlBiere = "https://api.punkapi.com/v2/beers?page=" + page + "&per_page=80 ";
            URL url = null;
            try {
                url = new URL(urlBiere);
            } catch (MalformedURLException e) {
                uneBiere = false;
            }
            try {
                InputStream streamUrl = url.openStream();
                JsonReader reader = Json.createReader(streamUrl);
                jsonArray = reader.readArray();

                for (int i = 0 ; i < jsonArray.size() ; i++){
                    JsonObject jsonObject = jsonArray.getJsonObject(i);
                    biere = new Biere(jsonObject);
                    //System.out.println(biere.getName());
                    listeBiere.add(biere);
                }
                if(jsonArray.size() == 0 ){
                    uneBiere = false;
                }
                else{
                    page++;
                }
            } catch (java.io.FileNotFoundException e) {
                uneBiere = false;
            }
        }

        return listeBiere;
    }


    private static String formatBiere(Biere biere){
        String pourAfficher = "";

        pourAfficher += "\nRéference : " + biere.getId()
                + "\nThe beer " + biere.getName() + " was brewed in " + biere.getFirst_brewed()
                + "\n" + biere.getDescription();

        pourAfficher += "\nMalt :";
        for(Malt m : biere.ingredients.malt) {
            pourAfficher += "\n\t" + m.getName() + " : " + m.getAmount().getValue() + " " + m.getAmount().getUnit();
        }
        pourAfficher += "\nHops :";
        for(Hops h : biere.ingredients.hops) {
            pourAfficher += "\n\t" + h.getName() + " : " + h.getAmount().getValue() + " " + h.getAmount().getUnit();
        }
        pourAfficher += "\nYeast : " + biere.ingredients.getYeast();

        if (pourAfficher == ""){
            return "No beer";
        }
        else{
            return pourAfficher;
        }
    }

    private static String formatListe(List<Biere> listeBiere){
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

    public static String rechercheParNom(String rechercheNom) throws IOException {

        listeBiere = recupereToutesLesBieresParPaquet();
        Biere biere = null;
        boolean found = false;

        for (Biere b : listeBiere) {
            if (b.getName().equals(rechercheNom) ){
                biere = b;
                found = true;
            }
        }

        if (found) {
            return formatBiere(biere);
        }
        else{
            return "No beer";
        }
    }

    public static String rechercheParId(int rechercheId) throws IOException {

        listeBiere = recupereToutesLesBieresParPaquet();
        Biere biere = null;
        boolean found = false;
        for (Biere b : listeBiere) {
            if (b.getId() == rechercheId){
                biere = b;
                found = true;
            }
        }

        if (found) {
            return formatBiere(biere);
        }
        else{
            return "No beer";
        }
    }

    public static String rechercheParIngredient(String rechercheIngredient, double rechercheQuantite) throws IOException {

        listeBiere = recupereToutesLesBieresParPaquet();
        List<Biere> bieresAvecIngredient = new ArrayList<>();
        for (Biere b : listeBiere) {
            for(Malt m : b.ingredients.malt) {
                if (m.getName().equals(rechercheIngredient) && m.amount.getValue() >= rechercheQuantite){
                    bieresAvecIngredient.add(b);
                }
            }
        }
        return formatListe(bieresAvecIngredient);
    }
}
