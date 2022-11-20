package com.example.fakeubereats.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fakeubereats.R;
import com.example.fakeubereats.adapter.Browse1Adapter;
import com.example.fakeubereats.adapter.Browse2Adapter;
import com.example.fakeubereats.model.Browse1Model;
import com.example.fakeubereats.model.Browse2Model;

import java.util.ArrayList;
import java.util.List;

public class BrowseFragment extends Fragment {

    List<Browse1Model> browse1ModelList;
    List<Browse2Model> browse2ModelList;
    RecyclerView FoodrecyclerView, RestaurantrecyclerView;
    Browse1Adapter browse1Adapter;
    Browse2Adapter browse2Adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_browse, container, false);

        browse1ModelList = new ArrayList<>();
        initBrowseList1();

        FoodrecyclerView = view.findViewById(R.id.BrowseRecyclerView1);
        FoodrecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 1, GridLayoutManager.HORIZONTAL, false));
        browse1Adapter = new Browse1Adapter(getContext(), browse1ModelList);
        FoodrecyclerView.setAdapter(browse1Adapter);


        browse2ModelList = new ArrayList<>();
        initBrowseList2();

        RestaurantrecyclerView = view.findViewById(R.id.BrowseRecyclerView2);
        RestaurantrecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        browse2Adapter = new Browse2Adapter(getContext(), browse2ModelList);
        RestaurantrecyclerView.setAdapter(browse2Adapter);


        return view;
    }

    public void initBrowseList1(){
        browse1ModelList.add(new Browse1Model("Chicken Royale", "Best from Burger King", R.drawable.bk_chickenroyale));
        browse1ModelList.add(new Browse1Model("Tandoori Chicken Pizza", "Pizza Hut at your service", R.drawable.pizzahut_tandoorichicken));
        browse1ModelList.add(new Browse1Model("Hawaiian Pizza", "Best from Burger King", R.drawable.dominos_hawaiian));
        browse1ModelList.add(new Browse1Model("Beefy Cheesy Burrito", "Best from Burger King", R.drawable.tacobell_beefycheesyburrito));
        browse1ModelList.add(new Browse1Model("Garlic Prawns", "Best from Burger King", R.drawable.dominos_garlicprawn));
        browse1ModelList.add(new Browse1Model("Crunchy Taco", "Best from Burger King", R.drawable.tacobell_crunchytaco));
    }

    public void initBrowseList2(){
        browse2ModelList.add(new Browse2Model("Burger King", "Best Burger in Town", R.drawable.bk));
        browse2ModelList.add(new Browse2Model("Pizza Hut", "Best Pizza in Town", R.drawable.pizzahut));
        browse2ModelList.add(new Browse2Model("Dominos", "Best Pizza in Town", R.drawable.dominos));
        browse2ModelList.add(new Browse2Model("Taco Bell", "Best Taco in Town", R.drawable.tacobell));
    }
}