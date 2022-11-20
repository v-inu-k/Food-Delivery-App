package com.example.fakeubereats.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Item{
    private int foodID;
    private String foodName;
    private String foodPrice;
    private String foodDescription;
    private int restaurantID;
    private int foodImage;

    public Item(int foodID, String foodName, String foodPrice, String foodDescription, int restaurantID, int foodImage) {

        this.foodID = foodID;
        this.foodName = foodName;
        this.foodPrice = foodPrice;
        this.foodDescription = foodDescription;
        this.restaurantID = restaurantID;
        this.foodImage = foodImage;
    }

    public int getFoodID() {
        return foodID;
    }

    public String getFoodName() {
        return foodName;
    }

    public String getFoodPrice() {
        return foodPrice;
    }

    public String getFoodDescription() {
        return foodDescription;
    }

    public int getRestaurantID() {
        return restaurantID;
    }

    public int getFoodImage() {
        return foodImage;
    }


}
