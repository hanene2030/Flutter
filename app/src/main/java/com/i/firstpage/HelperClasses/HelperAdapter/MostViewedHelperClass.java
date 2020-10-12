package com.i.firstpage.HelperClasses.HelperAdapter;


public class MostViewedHelperClass {


    int image;
    String title, description;
    float rating;
int color;
    public MostViewedHelperClass(int image, String title, String description, float rating,int color) {
        this.image = image;
        this.title = title;
        this.rating = rating ;
        this.description = description;
        this.color =color;
    }

    public float getRating(){return rating;};
    public int getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getColor() {
        return color;
    }
}
