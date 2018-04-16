package fr.wildcodeschool.jsonbiere;


public class Amount {

    private double value;
    private String unit;

    public Amount(String unit, double value) {
        setValue(value);
        setUnit(unit);
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
