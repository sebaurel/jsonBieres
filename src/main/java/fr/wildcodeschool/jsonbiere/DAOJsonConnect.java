package fr.wildcodeschool.jsonbiere;


import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

public class DAOJsonConnect {

    public static List<Biere> recupereLesBieresJson(String stringEntree) throws IOException {

        boolean uneBiere = true;
        int page = 1;
        List<Biere> listeBiere = new ArrayList<>();
        JsonArray jsonArray = null;
        String urlString = "";


        while (uneBiere) {
            URL url = null;
            try {
                if (stringEntree == "all"){
                    urlString = "https://api.punkapi.com/v2/beers?page=" + page + "&per_page=80 ";
                }
                else{
                    urlString = stringEntree ;
                }
                url = new URL(urlString);
            } catch (MalformedURLException e) {
                uneBiere = false;
            }
            try {
                InputStream streamUrl = url.openStream();
                JsonReader reader = Json.createReader(streamUrl);
                jsonArray = reader.readArray();

                for (int i = 0 ; i < jsonArray.size() ; i++){
                    JsonObject jsonObject = jsonArray.getJsonObject(i);

                    listeBiere.add(buildBiere(jsonObject));
                }
                if(jsonArray.size() == 0 || stringEntree != "all"){
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


    private static Biere buildBiere (JsonObject jsonObject){
        Biere biere = new Biere();
        biere.setId(jsonObject.getInt("id"));
        biere.setName(jsonObject.getString("name"));
        biere.setFirstBrewed(jsonObject.getString("first_brewed"));
        biere.setDescription(jsonObject.getString("description"));

        JsonObject jsonObjectIngredients = jsonObject.getJsonObject("ingredients");
        Map<String, List<Ingredient>> mapIngredients = new LinkedHashMap<>();


        JsonArray jsonArrayMalts = jsonObjectIngredients.getJsonArray("malt");
        List<Ingredient> listeMalt = new ArrayList<>();

        for (int j = 0 ; j < jsonArrayMalts.size(); j++){
            Malt malt = new Malt();

            JsonObject jsonMalt = jsonArrayMalts.getJsonObject(j);
            malt.setName(jsonMalt.getString("name"));

            JsonObject jsonAmount = jsonMalt.getJsonObject("amount");
            Amount amount = buildAmount(jsonAmount);
            malt.setAmount(amount);

            listeMalt.add(malt);
        }
        mapIngredients.put("Malt",listeMalt);

        JsonArray jsonArrayHops = jsonObjectIngredients.getJsonArray("hops");
        List<Ingredient> listeHops = new ArrayList<>();

        for (int j = 0 ; j < jsonArrayHops.size(); j++){
            Hops hops = new Hops();

            JsonObject jsonHops = jsonArrayHops.getJsonObject(j);
            hops.setName(jsonHops.getString("name"));

            JsonObject jsonAmount = jsonHops.getJsonObject("amount");
            Amount amount = buildAmount(jsonAmount);
            hops.setAmount(amount);

            listeHops.add(hops);
        }
        mapIngredients.put("Hops",listeHops);

        List<Ingredient> listYeast = new ArrayList<>();

        String  valueYeast = null;
        if (!jsonObjectIngredients.isNull("yeast")){
            valueYeast = String.valueOf(jsonObjectIngredients.get("yeast"));
        }
        Yeast yeast = new Yeast();
        yeast.setName(valueYeast);
        listYeast.add(yeast);
        mapIngredients.put("Yeast",listYeast);


        biere.setIngredients(mapIngredients);

        return biere;
    }
    private static Amount buildAmount(JsonObject jsonAmount){

        String amountUnit = jsonAmount.getString("unit");
        double amountValue = jsonAmount.getJsonNumber("value").doubleValue();
        Amount amount = new Amount(amountUnit, amountValue);

        return amount;
    }
}
