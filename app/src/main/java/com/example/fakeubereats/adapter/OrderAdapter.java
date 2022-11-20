package com.example.fakeubereats.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.fakeubereats.DB.DBModel;
import com.example.fakeubereats.R;

import java.util.ArrayList;
import java.util.List;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.ViewHolder>{

    ArrayList<BasketAdapter> basket;
    DBModel dbModel = new DBModel();


    public OrderAdapter(ArrayList<BasketAdapter> basket) {
        this.basket = basket;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.order_list, parent, false);
    return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String NameOfFood = basket.get(position).getFoodName();
        String PriceOfFood = basket.get(position).getFoodPrice();
        String QuantityOfFood = basket.get(position).getFoodQuantity();

        holder.foodName.setText(NameOfFood);
        holder.foodPrice.setText(PriceOfFood);
        holder.foodQuantity.setText(QuantityOfFood);

        holder.add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int quantity = Integer.parseInt(holder.foodQuantity.getText().toString());
                quantity++;
                holder.foodQuantity.setText(String.valueOf(quantity));
            }
        });

        holder.minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int quantity = Integer.parseInt(holder.foodQuantity.getText().toString());
                if (quantity > 0) {
                    quantity--;
                    holder.foodQuantity.setText(String.valueOf(quantity));
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return basket.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView foodName, foodPrice, foodQuantity, total;
        Button add, minus, checkout;

        public ViewHolder(View itemView) {
            super(itemView);
            foodName = itemView.findViewById(R.id.Food_Name);
            foodPrice = itemView.findViewById(R.id.Food_Price);
            foodQuantity = itemView.findViewById(R.id.Food_Quantity);
            total = itemView.findViewById(R.id.Basket_Total);
            checkout = itemView.findViewById(R.id.Checkout);
            add = itemView.findViewById(R.id.Order_Add_Button);
            minus = itemView.findViewById(R.id.Order_Minus_Button);

        }
    }


}
