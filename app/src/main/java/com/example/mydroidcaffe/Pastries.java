package com.example.mydroidcaffe;

public class Pastries {
    private final int pastriesImage;
    private String pastriesTitle;
    private String pastriesDescription;

    Pastries(int pastriesImage,String pastriesTitle, String pastriesDescription){
        this.pastriesImage=pastriesImage;
        this.pastriesTitle=pastriesTitle;
        this.pastriesDescription=pastriesDescription;
    }
    public int getPastriesImage(){
        return pastriesImage;

    }
    public String getPastriesTitle(){
        return pastriesTitle;
    }
    public String getPastriesDescription(){
        return pastriesDescription;
    }
}
