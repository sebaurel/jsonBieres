package fr.wildcodeschool.jsonbiere;



abstract class Ingredient {
    private String name;
    private Amount amount;

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

    public void setAmount(Amount amount) {
        this.amount = amount;
    }


}
