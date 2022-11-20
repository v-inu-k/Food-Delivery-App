package com.example.fakeubereats.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.fakeubereats.Activity.MainActivity;
import com.example.fakeubereats.Activity.UserActivity;
import com.example.fakeubereats.R;
import com.example.fakeubereats.adapter.OrderAdapter;
import com.example.fakeubereats.adapter.BasketAdapter;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class BasketFragment extends Fragment {

    ArrayList<BasketAdapter> basket;
    RecyclerView recyclerView;
    OrderAdapter orderAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_basket, container, false);

        basket = new ArrayList<>();
        addFoodToBasket();


        recyclerView = view.findViewById(R.id.BasketRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(null));
        orderAdapter = new OrderAdapter(basket);
        recyclerView.setAdapter(orderAdapter);
        Button checkoutButton = view.findViewById(R.id.Checkout);
        checkoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (MainActivity.username == null){
                    Intent intent = new Intent(getActivity(), UserActivity.class);
                    startActivity(intent);
                }
                else {
                    Snackbar.make(v, "Order placed", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();

                    //Hide all the information in the basket
                    basket.clear();
                }
            }
        });

        return view;
    }

    public void addFoodToBasket(){
        basket.add(new BasketAdapter("BK Whooper", "LKR 2300", "1"));
        basket.add(new BasketAdapter("Butter Chicken Masala", "LKR 1600", "1"));
        basket.add(new BasketAdapter("The Godfather", "LKR 1200", "1"));;
    }
}