package com.example.fakeubereats.model;

public class Browse2Model {
    private String RestaurantName;
    private String RestaurantAddress;
    private int RestaurantImage;

    public Browse2Model(String restaurantName, String restaurantAddress, int restaurantImage) {
        RestaurantName = restaurantName;
        RestaurantAddress = restaurantAddress;
        RestaurantImage = restaurantImage;
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

    public int getRestaurantImage() {
        return RestaurantImage;
    }

    public void setRestaurantImage(int restaurantImage) {
        RestaurantImage = restaurantImage;
    }
}
