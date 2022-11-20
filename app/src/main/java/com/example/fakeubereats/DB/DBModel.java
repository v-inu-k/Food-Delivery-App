package com.example.fakeubereats.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.fakeubereats.DB.DBSchema.RestaurantTable;
import com.example.fakeubereats.DB.DBSchema.ItemTable;
import com.example.fakeubereats.DB.DBSchema.OrderTable;


import com.example.fakeubereats.model.Item;
import com.example.fakeubereats.model.Order;
import com.example.fakeubereats.model.Restaurant;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class DBModel {
    SQLiteDatabase db;

    public void load(Context context){
        this.db = new DBHelper(context).getWritableDatabase();
    }

    public void addRestaurant(Restaurant restaurant) {
        ContentValues cv = new ContentValues();
        cv.put(RestaurantTable.Cols.RESTAURANT_ID, restaurant.getRestaurantID());
        cv.put(RestaurantTable.Cols.RESTAURANT_NAME, restaurant.getRestaurantName());
        cv.put(RestaurantTable.Cols.RESTAURANT_LOGO, restaurant.getRestaurantLogo());
        cv.put(RestaurantTable.Cols.RESTAURANT_ADDRESS, restaurant.getRestaurantAddress());
        cv.put(RestaurantTable.Cols.RESTAURANT_RATING, restaurant.getRestaurantRating());
        db.insert(RestaurantTable.NAME, null, cv);
    }

    public ArrayList<Restaurant> getAllRestaurants() {
        ArrayList<Restaurant> restaurantList = new ArrayList<>();
        Cursor cursor = db.rawQuery("SELECT * FROM restaurants", null);
        DBCursor dbCursor = new DBCursor(cursor);

            try {
                dbCursor.moveToFirst();
                while (!dbCursor.isAfterLast()) {
                    restaurantList.add(dbCursor.getRestaurant());
                    dbCursor.moveToNext();
                }
            } finally {
                cursor.close();
            }
        return restaurantList;
    }

    public Restaurant getRestaurantByID(String restaurantID) {
        Restaurant restaurant;
        String[] selectionArgs = {restaurantID};
        Cursor cursor = db.rawQuery("SELECT * FROM restaurants WHERE restaurantID=?", selectionArgs);
        DBCursor dbCursor = new DBCursor(cursor);

        if (cursor != null && cursor.getCount() > 0) {
            try {
                dbCursor.moveToFirst();
                restaurant = dbCursor.getRestaurant();
            } finally {
                cursor.close();
            }
        } else restaurant = null;

        return restaurant;
    }

    public void addItem(Item item) {
        try {
            ContentValues cv = new ContentValues();
            cv.put(ItemTable.Cols.FOOD_ID, item.getFoodID());
            cv.put(ItemTable.Cols.FOOD_NAME, item.getFoodName());
            cv.put(ItemTable.Cols.FOOD_PRICE, item.getFoodPrice());
            cv.put(ItemTable.Cols.FOOD_DESCRIPTION, item.getFoodDescription());
            cv.put(ItemTable.Cols.FOOD_IMAGE_PATH, item.getFoodImage());
            cv.put(ItemTable.Cols.RESTAURANT_ID, item.getRestaurantID());
            db.insert(ItemTable.NAME, null, cv);
        } catch (Exception e) {
            Log.d("SQL error :", e.getMessage());
        }
    }

    public ArrayList<Item> getFoodItems(String[] restaurantID) {

        ArrayList<Item> foodList = new ArrayList<>();
        Cursor cursor = db.rawQuery("SELECT * FROM items WHERE restaurantID=?", restaurantID);
        DBCursor dbCursor = new DBCursor(cursor);

        if (cursor != null && cursor.getCount() > 0) {
            try {
                dbCursor.moveToFirst();
                while (!dbCursor.isAfterLast()) {
                    foodList.add(dbCursor.getItem());
                    dbCursor.moveToNext();
                }
            } finally {
                cursor.close();
            }
        }
        return foodList;
    }

    public Item getFoodByID(int foodID){
        Item item;
        Cursor cursor = db.rawQuery("SELECT * FROM "+ItemTable.NAME+" WHERE "+ItemTable.Cols.FOOD_ID+" = "+foodID+" LIMIT 1", null);
        DBCursor dbCursor = new DBCursor(cursor);

        if (cursor != null && cursor.getCount() > 0) {
            try {
                dbCursor.moveToFirst();
                item = dbCursor.getItem();
            } finally {
                cursor.close();
            }
        } else item = null;

        return item;
    }

    public ArrayList<Item> getBrowseFoodItems(){
        ArrayList<Item> foodList = new ArrayList<>();
        Cursor cursor = db.rawQuery("SELECT * FROM items ORDER BY RANDOM() LIMIT 20",null);
        DBCursor dbCursor = new DBCursor(cursor);

        try {
            dbCursor.moveToFirst();
            while (!dbCursor.isAfterLast()) {
                foodList.add(dbCursor.getItem());
                dbCursor.moveToNext();
            }
        } finally {
            cursor.close();
        }

        return foodList;
    }


    public void addOrderItem(Order order, String userID){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");

        ContentValues cv = new ContentValues();
        cv.put(OrderTable.Cols.USER_ID, userID);
        cv.put(OrderTable.Cols.FOOD_ITEM, order.getFoodItem());
        cv.put(OrderTable.Cols.RESTAURANT_ID, order.getRestaurantID());
        cv.put(OrderTable.Cols.UNIT_PRICE, order.getUnitPrice());
        cv.put(OrderTable.Cols.AMOUNT, order.getAmount());
        cv.put(OrderTable.Cols.TOTAL_PRICE, order.getTotalPrice());
        cv.put(OrderTable.Cols.DATE, dtf.format(LocalDateTime.now()));
        db.insert(OrderTable.NAME, null, cv);
    }

    public ArrayList<Order> getOrderListByEmail(String USER_ID){
        ArrayList<Order> orderList = new ArrayList<>();
        String[] selectionArgs = {USER_ID};
        Cursor cursor = db.rawQuery("SELECT * FROM orders WHERE USER_ID=?", selectionArgs);
        DBCursor dbCursor = new DBCursor(cursor);

        if (cursor != null && cursor.getCount() > 0) {
            try {
                dbCursor.moveToFirst();
                while (!dbCursor.isAfterLast()) {
                    orderList.add(dbCursor.getOrder());
                    dbCursor.moveToNext();
                }
            } finally {
                cursor.close();
            }
        }
        return orderList;
    }


    public int getRestaurantName() {
        int restaurantName;
        Cursor cursor = db.rawQuery("SELECT * FROM restaurants", null);
        DBCursor dbCursor = new DBCursor(cursor);

        if (cursor != null && cursor.getCount() > 0) {
            try {
                dbCursor.moveToFirst();
                restaurantName = Integer.parseInt(dbCursor.getRestaurant().getRestaurantName());
            } finally {
                cursor.close();
            }
        } else restaurantName = 0;

        return restaurantName;
    }
}
