package fr.wildcodeschool.jsonbiere;


import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.IOException;
import java.io.InputStream;
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
    private Ingredient ingredient;
    private static List<Biere> listeBiere = new ArrayList<>();

    public static void main(String... args) throws IOException {


        listeBiere = constructionListe();

        for (Biere b : listeBiere) {
            print(b);
        }
    }


    private Biere(JsonObject jsonObject) {


        setId(jsonObject.getInt("id"));
        setName(jsonObject.getString("name"));
        setFirst_brewed(jsonObject.getString("first_brewed"));
        setDescription(jsonObject.getString("description"));
        setIngredient(jsonObject.getJsonObject("ingredients"));


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

    public Object getIngredient() {
        return ingredient;
    }

    public void setIngredient(JsonObject ingredient) {
        this.ingredient =  new Ingredient(ingredient);
    }

    private static List<Biere> constructionListe() throws IOException {
        JsonArray jsonArray = recupereLaListe();
        List<Biere> listeBiere = new ArrayList<>();

        for (int i = 0 ; i < jsonArray.size(); i++){
            JsonObject jsonObject = jsonArray.getJsonObject(i);

            Biere biere = new Biere(jsonObject);
            listeBiere.add(biere);

        }

        return listeBiere;
    }

    private static JsonArray recupereLaListe() throws IOException {

        URL url = new URL("https://api.punkapi.com/v2/beers?page=1&per_page=80");
        InputStream streamUrl = url.openStream();

        JsonReader reader =  Json.createReader(streamUrl);
        JsonArray jsonArray = reader.readArray();

        reader.close();
        streamUrl.close();
        return jsonArray;

    }

    public static int rechercheParNom(String rechercheNom) throws IOException {

        List<Biere> Bieres = constructionListe();

        for (Biere b : Bieres) {
            if (b.getName().equals(rechercheNom) ){
                //print(b);
                return b.getId();
            }
        }
        return 0;
    }

    public static String rechercheParId(int rechercheId) throws IOException {

        List<Biere> Bieres = constructionListe();

        for (Biere b : Bieres) {
            if (b.getId() == rechercheId){
                System.out.println(print(b));
                return b.getName();
            }
        }
        return null;
    }

    public static String print(Biere biere){
        String pourAfficher = "";

        System.out.println("\nRéference : " + biere.getId()
                + "\nThe beer " + biere.getName()
                + " was brewed in " + biere.getFirst_brewed()
                + "\n" + biere.getDescription());

        System.out.println("Malt :");
        for(Malt m : biere.ingredient.malt) {
            System.out.println(m.getName() + " : ");
            System.out.println("\tUnité " + m.getAmount().getValue());
            System.out.println("\tValeur " + m.getAmount().getUnit());

        }
        System.out.println("\n" + biere.ingredient.getYeast());
        System.out.println("");

        return pourAfficher;
    }


}
