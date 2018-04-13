package fr.wildcodeschool.jsonbiere;

import javax.json.JsonArray;
import javax.json.JsonObject;
import java.util.ArrayList;
import java.util.List;


public class Malt {
    private String name;
    private Amount amount;

    public Malt(JsonObject malt) {
        setName(malt.getString("name"));
        setAmount(malt.getJsonObject("amount"));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Amount getAmount() {
        return amount;
    }

    public void setAmount(JsonObject jsonAmount) {


        Amount amount = new Amount(jsonAmount);

        this.amount = amount;
    }
}
