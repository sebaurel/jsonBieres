package fr.wildcodeschool.jsonbiere;

import javax.json.JsonArray;
import javax.json.JsonObject;
import java.util.ArrayList;
import java.util.List;

public class Ingredients {

    protected String yeast;
    protected List<Malt> malt;
    protected List<Hops> hops;

    public Ingredients(JsonObject ingredients) {
        try {
            setYeast(ingredients.getString("yeast"));
        }
        catch (java.lang.ClassCastException e){
            yeast = null;
        }

        setMalt(ingredients.getJsonArray("malt"));
        setHops(ingredients.getJsonArray("hops"));
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

    public List<Hops> getHops() {
        return hops;
    }

    public void setHops(JsonArray JsonListHops) {
        List<Hops> listeHops = new ArrayList<>();

        for (int i = 0 ; i < JsonListHops.size(); i++){
            JsonObject jsonObject = JsonListHops.getJsonObject(i);

            Hops hops = new Hops(jsonObject);
            listeHops.add(hops);

        }

        this.hops = listeHops;
    }
}
