package com.example.fakeubereats.DB;

import android.database.CursorWrapper;
import android.database.Cursor;
import com.example.fakeubereats.DB.DBSchema.UserTable;
import com.example.fakeubereats.DB.DBSchema.RestaurantTable;
import com.example.fakeubereats.DB.DBSchema.ItemTable;
import com.example.fakeubereats.DB.DBSchema.OrderTable;
import com.example.fakeubereats.model.Item;
import com.example.fakeubereats.model.Order;
import com.example.fakeubereats.model.User;
import com.example.fakeubereats.model.Restaurant;

public class DBCursor extends CursorWrapper {

    public DBCursor(Cursor cursor) {
        super(cursor);
    }

    public User getUser() {
        String email = getString(getColumnIndex(UserTable.Cols.EMAIL));
        String name = getString(getColumnIndex(UserTable.Cols.NAME));
        String password = getString(getColumnIndex(UserTable.Cols.PASSWORD));
        return new User(email, name, password);
    }

    public Restaurant getRestaurant(){
        int restaurantID = getInt(getColumnIndex(RestaurantTable.Cols.RESTAURANT_ID));
        String restaurantName = getString(getColumnIndex(RestaurantTable.Cols.RESTAURANT_NAME));
        String restaurantAddress = getString(getColumnIndex(RestaurantTable.Cols.RESTAURANT_ADDRESS));
        String restaurantRating = getString(getColumnIndex(RestaurantTable.Cols.RESTAURANT_RATING));
        int restaurantLogo = getInt(getColumnIndex(RestaurantTable.Cols.RESTAURANT_LOGO));
        return new Restaurant(restaurantID, restaurantName, restaurantAddress, restaurantRating, restaurantLogo);
    }

    public Item getItem(){
        int foodID = getInt(getColumnIndex(ItemTable.Cols.FOOD_ID));
        String foodName = getString(getColumnIndex(ItemTable.Cols.FOOD_NAME));
        String foodPrice = getString(getColumnIndex(ItemTable.Cols.FOOD_PRICE));
        String foodDesc = getString(getColumnIndex(ItemTable.Cols.FOOD_DESCRIPTION));
        int restaurantID = getInt(getColumnIndex(ItemTable.Cols.RESTAURANT_ID));
        int foodImagePath = getInt(getColumnIndex(ItemTable.Cols.FOOD_IMAGE_PATH));
        return new Item(foodID, foodName, foodPrice, foodDesc, restaurantID, foodImagePath);
    }

public Order getOrder(){
        String orderID = getString(getColumnIndex(OrderTable.Cols.ORDER_ID));
        String userID = getString(getColumnIndex(OrderTable.Cols.USER_ID));
        String foodItem = getString(getColumnIndex(OrderTable.Cols.FOOD_ITEM));
        String restaurantID = getString(getColumnIndex(OrderTable.Cols.RESTAURANT_ID));
        String unitPrice = getString(getColumnIndex(OrderTable.Cols.UNIT_PRICE));
        String amount = getString(getColumnIndex(OrderTable.Cols.AMOUNT));
        String totalPrice = getString(getColumnIndex(OrderTable.Cols.TOTAL_PRICE));
        String date = getString(getColumnIndex(OrderTable.Cols.DATE));
        return new Order(orderID, userID, foodItem, restaurantID, unitPrice, amount, totalPrice, date);
    }
}
