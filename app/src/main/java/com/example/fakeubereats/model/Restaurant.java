package com.example.fakeubereats.model;

public class Restaurant {
    private  int RestaurantID;
    private  String RestaurantName;
    private  String RestaurantAddress;
    private  String RestaurantRating;
    private  int RestaurantLogo;


    public Restaurant(int restaurantID, String restaurantName, String restaurantAddress, String restaurantRating, int restaurantLogo) {
        RestaurantID = restaurantID;
        RestaurantName = restaurantName;
        RestaurantAddress = restaurantAddress;
        RestaurantRating = restaurantRating;
        RestaurantLogo = restaurantLogo;
    }

    public int getRestaurantID() {
        return RestaurantID;
    }

    public void setRestaurantID(int restaurantID) {
        RestaurantID = restaurantID;
    }

    public String getRestaurantName() {
        return RestaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        RestaurantName = restaurantName;
    }

    public String getRestaurantAddress() {
        return RestaurantAddress;
    }

    public void setRestaurantAddress(String restaurantAddress) {
        RestaurantAddress = restaurantAddress;
    }

    public String getRestaurantRating() {
        return RestaurantRating;
    }

    public void setRestaurantRating(String restaurantRating) {
        RestaurantRating = restaurantRating;
    }

    public int getRestaurantLogo() {
        return RestaurantLogo;
    }

    public void setRestaurantLogo(int restaurant_Logo) {
        RestaurantLogo = restaurant_Logo;
    }
}

