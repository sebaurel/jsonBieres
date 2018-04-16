package fr.wildcodeschool.jsonbiere;

import java.util.List;

public class Biere {

    private int id ;
    private String name;
    private String firstBrewed;
    private String description;
    private List<List<Ingredient>> ingredients;


    protected Biere() {

    }

    public int getId() { return id; }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstBrewed() {
        return firstBrewed;
    }

    public void setFirstBrewed(String firstBrewed) {
        this.firstBrewed = firstBrewed;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<List<Ingredient>> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<List<Ingredient>> ingredients) {
        this.ingredients = ingredients;
    }

}
