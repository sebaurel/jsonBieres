package fr.wildcodeschool.jsonbiere;


import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.json.*;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;



public class Biere {

    int id ;
    String name;
    String first_brewed;
    String description;

    Array ingredients;

    public static void main(String[]args) throws IOException {

        JsonArray jsonArray = fromURL();
        List<Biere> bieresObj = new ArrayList<>();

        for (int i = 0 ; i < jsonArray.size(); i++){
            JsonObject jsonObject = jsonArray.getJsonObject(i);

            Biere biere = new Biere(jsonObject);
            bieresObj.add(biere);

        }


        for (Biere b : bieresObj) {
            System.out.println("\nRéference : " + b.getId()
                    + "\nThe beer " + b.getName()
                    + " was brewed in " + b.getFirst_brewed()
                    + "\n" + b.getDescription());

            
        }
    }


    private Biere(JsonObject jsonObject) {


        setId(jsonObject.getInt("id"));
        setName(jsonObject.getString("name"));
        setFirst_brewed(jsonObject.getString("first_brewed"));
        setDescription(jsonObject.getString("description"));


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

    public Array getIngredients() {
        return ingredients;
    }

    public void setIngredients(Array ingredients) {
        this.ingredients = ingredients;
    }

    private static JsonArray fromURL() throws IOException,javax.json.JsonException {

        URL url = new URL("https://api.punkapi.com/v2/beers ");
        InputStream streamUrl = url.openStream();

        JsonReader reader =  Json.createReader(streamUrl);

        JsonArray jsonArray = reader.readArray();

        reader.close();
        streamUrl.close();
        return jsonArray;

    }


}
