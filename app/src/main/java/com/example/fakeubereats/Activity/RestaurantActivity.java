package com.example.fakeubereats.Activity;

import android.app.Activity;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.fakeubereats.Fragments.FoodItemFragment;
import com.example.fakeubereats.Fragments.FoodListFragment;
import com.example.fakeubereats.R;

public class RestaurantActivity extends FragmentActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant);


    }
}
