package com.example.fakeubereats.model;

public class Order {
    private static String orderID;
    private String userID;
    private String foodItem;
    private String restaurantID;
    private String unitPrice;
    private String amount;
    private String totalPrice;
    private String date;

    public Order(String orderID, String userID, String foodItem, String restaurantID, String unitPrice, String amount, String totalPrice, String date) {
        this.orderID = orderID;
        this.userID = userID;
        this.foodItem = foodItem;
        this.restaurantID = restaurantID;
        this.unitPrice = unitPrice;
        this.amount = amount;
        this.totalPrice = totalPrice;
        this.date = date;
    }

    public static String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getFoodItem() {
        return foodItem;
    }

    public void setFoodItem(String foodItem) {
        this.foodItem = foodItem;
    }

    public String getRestaurantID() {
        return restaurantID;
    }

    public void setRestaurantID(String restaurantID) {
        this.restaurantID = restaurantID;
    }

    public String getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(String unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


}
