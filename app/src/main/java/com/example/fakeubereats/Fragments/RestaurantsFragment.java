package com.example.fakeubereats.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fakeubereats.DB.DBHelper;
import com.example.fakeubereats.DB.DBModel;
import com.example.fakeubereats.DB.InsertData;
import com.example.fakeubereats.R;
import com.example.fakeubereats.adapter.RestaurantAdapter;
import com.example.fakeubereats.model.Restaurant;


import java.util.ArrayList;
import java.util.List;

public class RestaurantsFragment extends Fragment {

    RecyclerView recyclerView;
    ArrayList<Restaurant> restaurantList;
    DBHelper myDB;
    DBModel dbModel;
    RestaurantAdapter restaurantAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_restaurants, container, false);


        restaurantList = new ArrayList<>();
        displayRestaurant();


        recyclerView = view.findViewById(R.id.RestaurantRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(null));
        restaurantAdapter = new RestaurantAdapter(getContext(), restaurantList);
        recyclerView.setAdapter(restaurantAdapter);


        return view;
    }
/*    public void displayRestaurant() {
        myDB = new DBHelper(getContext());
        restaurantList = myDB.getAllRestaurants();
    }*/

    public void displayRestaurant(){
        restaurantList.add(new Restaurant(1, "Pizza Hut", "Fast Food", "4.5", R.drawable.pizzahut));
        restaurantList.add(new Restaurant(2, "Burger King", "Fast Food", "4.5", R.drawable.bk));
        restaurantList.add(new Restaurant(3, "Dominos", "Fast Food", "4.5", R.drawable.dominos));
        restaurantList.add(new Restaurant(4, "KFC", "Fast Food", "4.5", R.drawable.kfc));
        restaurantList.add(new Restaurant(5, "Taco Bell", "Fast Food", "4.5", R.drawable.tacobell));
    }
}