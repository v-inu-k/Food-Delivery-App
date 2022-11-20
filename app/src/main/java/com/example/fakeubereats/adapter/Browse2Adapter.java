package com.example.fakeubereats.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fakeubereats.R;
import com.example.fakeubereats.model.Browse2Model;

import java.util.List;

public class Browse2Adapter extends RecyclerView.Adapter<Browse2Adapter.Browse2ViewHolder> {

    List<Browse2Model> browse2ModelList;

    public Browse2Adapter(Context context, List<Browse2Model> browse2ModelList) {
        this.browse2ModelList = browse2ModelList;
    }

    @NonNull
    @Override
    public Browse2ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.restaurant_list_style, parent, false);
    return new Browse2ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Browse2ViewHolder holder, int position) {

        holder.restaurantName.setText(browse2ModelList.get(position).getRestaurantName());
        holder.restaurantDescription.setText(browse2ModelList.get(position).getRestaurantAddress());
        holder.restaurantLogo.setImageResource(browse2ModelList.get(position).getRestaurantImage());
    }

    @Override
    public int getItemCount() {
        return browse2ModelList.size();
    }

    public class Browse2ViewHolder extends RecyclerView.ViewHolder {

        TextView restaurantName, restaurantDescription;
        ImageView restaurantLogo;
        public Browse2ViewHolder(View itemView) {
            super(itemView);

            restaurantName = itemView.findViewById(R.id.Restaurant_Name);
            restaurantDescription = itemView.findViewById(R.id.Restaurant_Address);
            restaurantLogo = itemView.findViewById(R.id.Restaurant_Logo);
        }
    }
}
