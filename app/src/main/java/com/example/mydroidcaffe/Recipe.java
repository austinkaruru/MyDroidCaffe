package com.example.mydroidcaffe;

public class Recipe {
    //declare private member variables
    private final int recipeImage;
    private String recipeTitle;
    private String recipeDescription;
    /*
    Create a Constructor for the recipe data model
    Pass the parameter recipeImage, recipeTitle and recipeDescription
     */
    Recipe(int recipeImage, String recipeTitle, String recipeDescription){
        this.recipeImage= recipeImage;
        this.recipeTitle = recipeTitle;
        this.recipeDescription = recipeDescription;
    }
    /*
    Create the getters and return the specific object
     */
    public int getRecipeImage(){
        return recipeImage;
    }
    public String getRecipeTitle(){
        return recipeTitle;
    }
    public String getRecipeDescription(){
        return recipeDescription;
    }
}
