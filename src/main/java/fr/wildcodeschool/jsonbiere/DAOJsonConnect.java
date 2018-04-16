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

public class DAOJsonConnect {

    public static List<Biere> recupereToutesLesBieresJson() throws IOException {

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

                    biere = new Biere();
                    biere.setId(jsonObject.getInt("id"));
                    biere.setName(jsonObject.getString("name"));
                    biere.setFirstBrewed(jsonObject.getString("first_brewed"));
                    biere.setDescription(jsonObject.getString("description"));

                    JsonObject jsonObjectIngredients = jsonObject.getJsonObject("ingredients");

                    List<List<Ingredient>> listIngredients = new ArrayList<>();

                    JsonArray jsonArrayMalts = jsonObjectIngredients.getJsonArray("malt");
                    List<Ingredient> listMalts = new ArrayList<>();
                    for (int j = 0 ; j < jsonArrayMalts.size(); j++){
                        Malt malt = new Malt();

                        JsonObject jsonMalt = jsonArrayMalts.getJsonObject(j);
                        malt.setName(jsonMalt.getString("name"));
                        JsonObject jsonAmount = jsonMalt.getJsonObject("amount");

                        String amountUnit = jsonAmount.getString("unit");
                        double amountValue = jsonAmount.getJsonNumber("value").doubleValue();
                        malt.setAmount(amountUnit , amountValue);

                        listMalts.add(malt);
                    }
                    listIngredients.add(listMalts);

                    JsonArray jsonArrayHops = jsonObjectIngredients.getJsonArray("hops");
                    List<Ingredient> listHops = new ArrayList<>();
                    for (int j = 0 ; j < jsonArrayHops.size(); j++){
                        Hops hops = new Hops();

                        JsonObject jsonHops = jsonArrayHops.getJsonObject(j);
                        hops.setName(jsonHops.getString("name"));
                        JsonObject jsonAmount = jsonHops.getJsonObject("amount");


                        String amountUnit = jsonAmount.getString("unit");
                        double amountValue = jsonAmount.getJsonNumber("value").doubleValue();
                        hops.setAmount(amountUnit , amountValue);

                        listHops.add(hops);
                    }
                    listIngredients.add(listHops);



                    List<Ingredient> listYeast = new ArrayList<>();

                    //JsonObject jsonYeast= jsonObjectIngredients.getJsonObject("yeast");
                    //String jsonYeastString = jsonYeast.isNull("yeast");
                    String  valueYeast = null;
                    if (!jsonObjectIngredients.isNull("yeast")){
                        valueYeast = String.valueOf(jsonObjectIngredients.get("yeast"));
                    }
                    Yeast yeast = new Yeast();
                    yeast.setName(valueYeast);
                    listYeast.add(yeast);
                    listIngredients.add(listYeast);



                    biere.setIngredients(listIngredients);

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

}
