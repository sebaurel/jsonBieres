package fr.wildcodeschool.jsonbiere;



abstract class Ingredient {
    private String name;
    protected Amount amount;

    protected Ingredient() {
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

    public void setAmount(String unit, double value) {

        this.amount = new Amount(unit, value);
    }


    /*public Yeast getYeast() {
        return yeast;
    }

    public void setYeast(String yeast) {
        this.yeast = new Yeast(yeast);
    }*/
}
