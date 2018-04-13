package fr.wildcodeschool.jsonbiere;

import javax.json.JsonObject;

public class Amount {

    double value;
    String unit;

    public Amount(JsonObject amount) {
        setValue(amount.getJsonNumber("value").doubleValue());
        setUnit(amount.getString("unit"));
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}
