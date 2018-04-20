package fr.wildcodeschool.jsonbiere;



public abstract class Ingredient {
    private String name;
    private Amount amount;

    public Ingredient() {
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

    public void setAmount(Amount amount) {
        this.amount = amount;
    }


}
