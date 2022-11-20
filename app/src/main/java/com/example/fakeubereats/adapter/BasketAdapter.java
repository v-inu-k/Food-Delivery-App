package com.example.fakeubereats.adapter;

public class BasketAdapter  {

    String foodName;
    String foodPrice;
    String foodQuantity;


    public BasketAdapter(String foodName, String foodPrice, String foodQuantity) {
        this.foodName = foodName;
        this.foodPrice = foodPrice;
        this.foodQuantity = foodQuantity;

    }

    public String getFoodName() {
        return foodName;
    }

    public String getFoodPrice() {
        return foodPrice;
    }

    public String getFoodQuantity() {
        return foodQuantity;
    }



}
