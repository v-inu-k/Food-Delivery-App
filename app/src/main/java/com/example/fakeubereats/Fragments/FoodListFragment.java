package com.example.fakeubereats.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.fakeubereats.DB.DBModel;
import com.example.fakeubereats.R;
import com.example.fakeubereats.adapter.FoodListAdapter;
import com.example.fakeubereats.model.Item;

import java.util.ArrayList;
import java.util.List;

public class FoodListFragment extends Fragment{

    List<Item> FoodList;

    public static FoodListFragment newInstance() {
        FoodListFragment fragment = new FoodListFragment();
        return fragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_food_list, container, false);

        DBModel dbModel = new DBModel();
        dbModel.load(getContext());

        TextView restaurantName = view.findViewById(R.id.NameOfRestaurant);
        restaurantName.setText("Pizza Hut");
        TextView restaurantAddress = view.findViewById(R.id.AddressOfRestaurant);
        restaurantAddress.setText("134/1, Colombo Road, Negombo");


        FoodList = new ArrayList<>();
        initFood();
        initRecyclerView(view);


        return view;
    }

    public void initRecyclerView(View view){
        RecyclerView recyclerView = view.findViewById(R.id.FoodList_RecyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());


        recyclerView.setLayoutManager(linearLayoutManager);
        FoodListAdapter adapter = new FoodListAdapter(FoodList, this);
        recyclerView.setAdapter(adapter);


    }

    public void initFood(){
        FoodList.add(new Item(1, "Meat Lovers - Beef","1600","Burger with cheese", 1, R.drawable.pizzahut_meatloversbeef));
        FoodList.add(new Item(2, "Tandoori Chicken","1600","Burger with cheese", 1, R.drawable.pizzahut_tandoorichicken));
        FoodList.add(new Item(3, "Double Chicken and cheese Fiesta","1600","Burger with cheese", 1, R.drawable.pizzahut_doublechickenandcheesefiesta));
        FoodList.add(new Item(4, "Double Chicken Surprise","1600","Burger with cheese", 1, R.drawable.pizzahut_doublechickensurprise));
        FoodList.add(new Item(5, "Butter Chicken Masala","1600","Burger with cheese", 1, R.drawable.pizzahut_butterchickenmasala));
    }
}
