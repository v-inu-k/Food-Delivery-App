package com.example.fakeubereats.adapter;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fakeubereats.Activity.RestaurantActivity;
import com.example.fakeubereats.R;
import com.example.fakeubereats.model.Browse1Model;

import java.util.List;

public class Browse1Adapter extends RecyclerView.Adapter<Browse1Adapter.Browse1ViewHolder> {

    List<Browse1Model> browse1ModelList;
    Context context;

    public Browse1Adapter(Context context, List<Browse1Model> browse1ModelList) {
        this.context = context;
        this.browse1ModelList = browse1ModelList;
    }

    @Override
    public Browse1ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.browse_list_style, parent, false);
        return new Browse1ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(Browse1ViewHolder holder, int position) {
        holder.FoodName.setText(browse1ModelList.get(position).getFoodName());
        holder.FoodDescription.setText(browse1ModelList.get(position).getFoodDescription());
        holder.FoodImage.setImageResource(browse1ModelList.get(position).getFoodImage());
    }

    @Override
    public int getItemCount() {
        return browse1ModelList.size();
    }

    public class Browse1ViewHolder extends RecyclerView.ViewHolder {

        TextView FoodName, FoodDescription;
        ImageView FoodImage;

        public Browse1ViewHolder(View itemView) {
            super(itemView);
            FoodName = itemView.findViewById(R.id.Food_Name);
            FoodDescription = itemView.findViewById(R.id.Food_Description);
            FoodImage = itemView.findViewById(R.id.Food_Image);

        }
    }
}
