package com.example.fakeubereats.Fragments;

import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fakeubereats.R;
import com.google.android.material.snackbar.Snackbar;


public class FoodItemFragment extends Fragment {
    Button minus, plus, add_to_cart;
    TextView Quantity, food_name, food_price, food_description;
    ImageView food_image;
    int quantity;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_food_item, container, false);

        minus = view.findViewById(R.id.minus);
        plus = view.findViewById(R.id.plus);
        add_to_cart = view.findViewById(R.id.add_to_cart);
        Quantity = view.findViewById(R.id.Quantity);
        food_name = view.findViewById(R.id.food_name);
        food_price = view.findViewById(R.id.food_price);
        food_description = view.findViewById(R.id.food_description);
        food_image = view.findViewById(R.id.food_image);
        int basePrice = 600;
        food_price.setText("Rs. " + basePrice);
        Quantity.setText("0");

        food_name.setText("Tandoori Chicken Pizza");
        food_image.setImageResource(R.drawable.pizzahut_tandoorichicken);
        food_description.setText("Classic italian pizza with an Indian flavour mix");

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                quantity++;
                displayQuantity();
                int totalPrice = quantity * basePrice;
                add_to_cart.setText("Add Rs. " + totalPrice);
            }
        });

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quantity = Integer.parseInt(Quantity.getText().toString());
                if (quantity == 0) {

                    Toast.makeText(getContext(), "You cannot have less than 0 items", Toast.LENGTH_SHORT).show();
                } else {
                    quantity--;
                    displayQuantity();
                    if (quantity == 0) {
                        add_to_cart.setText("Add to Cart");
                    } else {
                        int totalPrice = quantity * basePrice;
                        add_to_cart.setText("Add Rs. " + totalPrice);
                    }
            }
        }
        });

        add_to_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (quantity == 0) {
                    Toast.makeText(getContext(), "Please select quantity", Toast.LENGTH_SHORT).show();
                } else {

                    Snackbar.make(v, "Added to cart", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            }
        });
        return view;
    }

    private void displayQuantity() {
        Quantity.setText(String.valueOf(quantity));
    }
}