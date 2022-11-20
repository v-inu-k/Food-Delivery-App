package com.example.fakeubereats.model;

public class Browse1Model {
    String FoodName;
    String FoodDescription;
    int FoodImage;

    public Browse1Model(String foodName, String foodDescription, int foodImage) {
        FoodName = foodName;
        FoodDescription = foodDescription;
        FoodImage = foodImage;
    }



    public String getFoodName() {
        return FoodName;
    }

    public String getFoodDescription() {
        return FoodDescription;
    }

    public int getFoodImage() {
        return FoodImage;
    }


}
