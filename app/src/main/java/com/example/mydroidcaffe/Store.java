package com.example.mydroidcaffe;

public class Store {

    private final int storeImage;
    private String storeTitle;
    private String storeDescription;
    /*
    Create a Constructor for the recipe data model
    Pass the parameter recipeImage, recipeTitle and recipeDescription
     */
    Store(int storeImage, String storeTitle, String storeDescription){
        this.storeImage= storeImage;
        this.storeTitle = storeTitle;
        this.storeDescription = storeDescription;
    }
    /*
    Create the getters and return the specific object
     */
    public int getStoreImage(){
        return storeImage;
    }
    public String getStoreTitle(){
        return storeTitle;
    }
    public String getStoreDescription(){
        return storeDescription;
    }
}
