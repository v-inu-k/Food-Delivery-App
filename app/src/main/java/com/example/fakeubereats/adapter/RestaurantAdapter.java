package com.example.fakeubereats.adapter;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.fakeubereats.R;
import com.example.fakeubereats.Activity.RestaurantActivity;
import com.example.fakeubereats.model.Restaurant;

import java.util.ArrayList;
import java.util.List;

public class RestaurantAdapter extends RecyclerView.Adapter<RestaurantAdapter.RestaurantViewHolder> {

    ArrayList<Restaurant> restaurantList;
    Context context;

    public RestaurantAdapter(Context context, ArrayList<Restaurant> restaurantList) {
        this.context = context;
        this.restaurantList = restaurantList;

    }

    @Override
    public RestaurantViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.restaurant_list_style, parent, false);
        return new RestaurantViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RestaurantViewHolder holder, int position) {

        holder.RestaurantName.setText(restaurantList.get(position).getRestaurantName());
        holder.RestaurantAddress.setText(restaurantList.get(position).getRestaurantAddress());
        holder.RestaurantRating.setText(restaurantList.get(position).getRestaurantRating());
        holder.RestaurantLogo.setImageResource(restaurantList.get(position).getRestaurantLogo());

    }

    @Override
    public int getItemCount() {
        return restaurantList.size();
    }

    public class RestaurantViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView RestaurantLogo;
        TextView RestaurantName, RestaurantAddress, RestaurantRating;

        public RestaurantViewHolder(View itemView) {
            super(itemView);
            RestaurantLogo = itemView.findViewById(R.id.Restaurant_Logo);
            RestaurantName = itemView.findViewById(R.id.Restaurant_Name);
            RestaurantAddress = itemView.findViewById(R.id.Restaurant_Address);
            RestaurantRating = itemView.findViewById(R.id.Restaurant_rating);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            if (position >= 0){
                Intent intent = new Intent(context, RestaurantActivity.class);
                context.startActivity(intent);
            }
        }
    }

}
