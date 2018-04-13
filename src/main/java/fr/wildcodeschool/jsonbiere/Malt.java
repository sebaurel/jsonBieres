package fr.wildcodeschool.jsonbiere;

import javax.json.JsonObject;


public class Malt {
    private String name;

    public Malt(JsonObject malt) {
        setName(malt.getString("name"));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
