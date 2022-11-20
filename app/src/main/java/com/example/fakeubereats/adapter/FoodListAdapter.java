package com.example.fakeubereats.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fakeubereats.Fragments.FoodListFragment;
import com.example.fakeubereats.R;
import com.example.fakeubereats.model.Item;

import java.util.List;

public class FoodListAdapter extends RecyclerView.Adapter<FoodListAdapter.FoodListViewHolder> {

    List<Item> itemTable;
    FoodListFragment context;

    public FoodListAdapter(List<Item> itemTable, FoodListFragment foodListFragment) {
        this.context = context;
        this.itemTable = itemTable;
    }

    @Override
    public FoodListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.food_list_style, parent, false);
        return new FoodListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(FoodListAdapter.FoodListViewHolder holder, int position) {

        holder.foodImage.setImageResource(itemTable.get(position).getFoodImage());
        holder.foodName.setText(itemTable.get(position).getFoodName());
        holder.foodDetails.setText(itemTable.get(position).getFoodDescription());



    }

    @Override
    public int getItemCount() {
        return itemTable.size();
    }


    public class FoodListViewHolder extends RecyclerView.ViewHolder {

        ImageView foodImage;
        TextView foodName, foodDetails;


        public FoodListViewHolder(View itemView) {
            super(itemView);
            foodImage = itemView.findViewById(R.id.Food_Image);
            foodName = itemView.findViewById(R.id.Food_Name);
            foodDetails = itemView.findViewById(R.id.Food_Details);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    NavController navController = Navigation.findNavController(v);
                    navController.navigate(R.id.action_foodListFragment_to_foodItemFragment3);
                }
            });
        }

/*       @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            if (position >= 0) {
                NavController navController = Navigation.findNavController(view);
                navController.navigate(R.id.action_foodListFragment_to_foodItemFragment3);
            }
        }*/
    }
}

