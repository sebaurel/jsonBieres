package fr.wildcodeschool.jsonbiere;

import javax.json.JsonObject;



abstract class Ingredient {
    private String name;
    protected Amount amount;

    public Ingredient(JsonObject malt) {
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
