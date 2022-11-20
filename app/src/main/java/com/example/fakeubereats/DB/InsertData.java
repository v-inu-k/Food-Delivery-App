package com.example.fakeubereats.DB;

import android.view.View;

import com.example.fakeubereats.R;
import com.example.fakeubereats.model.Item;
import com.example.fakeubereats.model.Restaurant;

import java.util.ArrayList;

public class InsertData {

    private ArrayList<Item> items;

    public InsertData(View view) {

        DBModel dbModel = new DBModel();
        dbModel.load(view.getContext());

        ArrayList<Restaurant> restaurants = dbModel.getAllRestaurants();

        if (restaurants.size() == 0) {
            initRestaurantData(dbModel);
            initFood(dbModel);
        }
    }

    public static void initRestaurantData(DBModel dbModel) {
        ArrayList<Restaurant> restaurants = new ArrayList<>();

        restaurants.add(new Restaurant(1, "Burger King", "1234 Main St", "4.5", R.drawable.bk));
        restaurants.add(new Restaurant(2, "Pizza Hut", "1234 Main St", "4.5", R.drawable.pizzahut));
        restaurants.add(new Restaurant(3, "Dominos", "1234 Main St", "4.5", R.drawable.dominos));
        restaurants.add(new Restaurant(4, "KFC", "1234 Main St", "4.5", R.drawable.kfc));
        restaurants.add(new Restaurant(5, "Taco Bell", "1234 Main St", "4.5", R.drawable.tacobell));

        for(Restaurant restaurant : restaurants) {
            dbModel.addRestaurant(restaurant);
        }
    }

    public static void initFood(DBModel dbModel) {
        ArrayList<Item> items = new ArrayList<>();

        items.add(new Item(1,  "Burger", "1200", "1",1, R.drawable.bk_whooper));
        items.add(new Item(2,  "Fries", "1000", "1",2, R.drawable.bk_chickenroyale));
        items.add(new Item(3,  "Drink", "700", "1",3, R.drawable.bk_doublecheeseburger));
        items.add(new Item(4,  "Pizza", "1450", "1", 4,R.drawable.bk_baconking));
        items.add(new Item(5,  "Drink", "650", "1",5, R.drawable.bk_chickennuggets));
        items.add(new Item(6,  "Pizza", "1460", "1",6, R.drawable.pizzahut_tandoorichicken));
        items.add(new Item(7,  "Drink", "550", "Drinks are nice", 7, R.drawable.pizzahut_meatloversbeef));

        for(Item item : items) {
            dbModel.addItem(item);
        }
    }
}
