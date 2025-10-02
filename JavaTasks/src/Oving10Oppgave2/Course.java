package Oving10Oppgave2;

import java.util.Arrays;

public class Course {
    // Object Variables
    private String name;
    private String type;
    private String recipe;
    private double price;

    // Constructor and toString
    public Course(String name, String type, String recipe, double price){
        this.name = name;
        this.type = type;
        this.recipe = recipe;
        this.price = price;
    }
    @Override
    public String toString() {
        return Arrays.toString(new Object[]{this.name, this.type, this.recipe, this.price});
    }

    // Get methods
    public String getName(){
        return this.name;
    }
    public String getType(){
        return this.type;
    }
    public String getRecipe(){
        return this.recipe;
    }
    public double getPrice(){
        return this.price;
    }
}
