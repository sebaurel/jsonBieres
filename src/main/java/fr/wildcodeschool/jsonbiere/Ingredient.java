package fr.wildcodeschool.jsonbiere;

import javax.json.JsonArray;
import javax.json.JsonObject;
import java.util.ArrayList;
import java.util.List;

public class Ingredient {

    protected String yeast;
    protected List<Malt> malt;

    public Ingredient(JsonObject ingredient) {
        setYeast(ingredient.getString("yeast"));
        setMalt(ingredient.getJsonArray("malt"));

    }

    public String getYeast() {
        return yeast;
    }

    public void setYeast(String yeast) {
        this.yeast = yeast;
    }

    public List<Malt> getMalt() {
        return malt;
    }

    public void setMalt(JsonArray JsonListMalt) {

        List<Malt> listeMalt = new ArrayList<>();

        for (int i = 0 ; i < JsonListMalt.size(); i++){
            JsonObject jsonObject = JsonListMalt.getJsonObject(i);

            Malt malt = new Malt(jsonObject);
            listeMalt.add(malt);

        }

        this.malt = listeMalt;
    }
}
