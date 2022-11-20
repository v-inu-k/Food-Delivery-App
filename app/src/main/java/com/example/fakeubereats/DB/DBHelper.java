package com.example.fakeubereats.DB;

import static java.lang.reflect.Array.getInt;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.fakeubereats.DB.DBSchema.UserTable;
import com.example.fakeubereats.DB.DBSchema.RestaurantTable;
import com.example.fakeubereats.DB.DBSchema.ItemTable;
import com.example.fakeubereats.DB.DBSchema.OrderTable;


public class DBHelper extends SQLiteOpenHelper {

    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "Bow'd.db";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase myDB) {
        myDB.execSQL("create table " + UserTable.NAME +
                "(" + UserTable.Cols.EMAIL + " Text PRIMARY KEY, " +
                UserTable.Cols.NAME + " Text, " +
                UserTable.Cols.PASSWORD + " Text);");

        myDB.execSQL("create table " +
                RestaurantTable.NAME +
                "(" + RestaurantTable.Cols.RESTAURANT_ID + " INTEGER PRIMARY KEY, " +
                RestaurantTable.Cols.RESTAURANT_NAME + " Text," +
                RestaurantTable.Cols.RESTAURANT_ADDRESS + " Text," +
                RestaurantTable.Cols.RESTAURANT_RATING + " Text," +
                RestaurantTable.Cols.RESTAURANT_LOGO + " INTEGER);");

        myDB.execSQL("create table " + ItemTable.NAME +
                "(" + ItemTable.Cols.FOOD_ID + " INTEGER, " +
                ItemTable.Cols.FOOD_NAME + " Text, " +
                ItemTable.Cols.FOOD_PRICE + " Text, " +
                ItemTable.Cols.FOOD_DESCRIPTION + " Text, " +
                ItemTable.Cols.RESTAURANT_ID + " INTEGER,  " +
                ItemTable.Cols.FOOD_IMAGE_PATH + " INTEGER, " +
                "FOREIGN KEY (" + ItemTable.Cols.RESTAURANT_ID + ") REFERENCES " + RestaurantTable.NAME + " (" + RestaurantTable.Cols.RESTAURANT_ID +
                "), PRIMARY KEY (" + ItemTable.Cols.FOOD_ID + ", " + ItemTable.Cols.RESTAURANT_ID + ") );");

        myDB.execSQL("create table " + OrderTable.NAME +
                "(" + OrderTable.Cols.ORDER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                OrderTable.Cols.USER_ID + " Text, " +
                OrderTable.Cols.FOOD_ITEM + " Text, " +
                OrderTable.Cols.RESTAURANT_ID + " Text, " +
                OrderTable.Cols.UNIT_PRICE + " Text," +
                OrderTable.Cols.AMOUNT + " Text," +
                OrderTable.Cols.TOTAL_PRICE + " Text," +
                OrderTable.Cols.DATE + " Date, " +
                "FOREIGN KEY (" + OrderTable.Cols.RESTAURANT_ID + ") REFERENCES " + RestaurantTable.NAME + " (" + RestaurantTable.Cols.RESTAURANT_ID + ")," +
                "FOREIGN KEY (" + OrderTable.Cols.USER_ID + ") REFERENCES " + UserTable.NAME + " (" + UserTable.Cols.EMAIL +
                ") );");    }

    @Override
    public void onUpgrade(SQLiteDatabase myDB, int oldVersion, int newVersion) {
        myDB.execSQL("drop Table if exists User");
        myDB.execSQL("drop Table if exists Restaurant");
        myDB.execSQL("drop Table if exists FoodItem");
        myDB.execSQL("drop Table if exists Purchase");
    }


public boolean insertUser(String email, String password, String name) {
        SQLiteDatabase myDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("email", email);
        contentValues.put("password", password);
        contentValues.put("name", name);
        long result = myDB.insert("User", null, contentValues);

        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public boolean checkUserPassword(String email, String password) {
        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("Select * from User where email = ? and password = ?", new String[]{email, password});
        if (cursor.getCount() > 0) {
            cursor.close();
            return true;

        } else {
            cursor.close();
            return false;

        }

    }

    public boolean checkEmail(String email) {
        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("Select * from User where email = ?", new String[]{email});
        if (cursor.getCount() > 0) {
            cursor.close();
            return true;
        } else {
            cursor.close();
            return false;
        }
    }


    /*------------------------------------------------------------------------------------------------------------------------*/

    public void addRestaurant(int restID, String name, String address, double rating, int logoRef) {
        SQLiteDatabase myDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("restaurantID", restID);
        contentValues.put("name", name);
        contentValues.put("address", address);
        contentValues.put("rating", rating);
        contentValues.put("LogoRef", logoRef);
        myDB.insert("Restaurant", null, contentValues);
        close();
    }

    public void addFoodItem(int foodID, int restID, String name, double price, String description, int foodImage) {
        SQLiteDatabase myDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("FoodID", foodID);
        contentValues.put("restaurantID", restID);
        contentValues.put("name", name);
        contentValues.put("price", price);
        contentValues.put("description", description);
        contentValues.put("FoodImage", foodImage);
        myDB.insert("FoodItem", null, contentValues);
        close();
    }


    public void addPurchase(int foodID, int count, String email) {
        SQLiteDatabase myDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("FoodID", foodID);
        contentValues.put("Count", count);
        contentValues.put("email", email);
        contentValues.put("Date_Time", "CURRENT_TIMESTAMP");
        myDB.insert("Purchase", null, contentValues);
        close();
    }
}
