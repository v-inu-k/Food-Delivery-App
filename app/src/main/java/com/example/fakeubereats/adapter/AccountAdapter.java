package com.example.fakeubereats.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fakeubereats.R;

import java.util.ArrayList;

public class AccountAdapter extends RecyclerView.Adapter<AccountAdapter.AccountViewHolder> {

    ArrayList<String> OrderNo, OrderDate, OrderTime, OrderPrice, OrderQuantity;
    Context context;

    public AccountAdapter(Context context, ArrayList<String> OrderNo, ArrayList<String> OrderDate, ArrayList<String> OrderTime, ArrayList<String> OrderPrice, ArrayList<String> OrderQuantity) {
        this.context = context;
        this.OrderNo = OrderNo;
        this.OrderDate = OrderDate;
        this.OrderTime = OrderTime;
        this.OrderPrice = OrderPrice;
        this.OrderQuantity = OrderQuantity;

    }

    @NonNull
    @Override
    public AccountViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.pastorders_list_style, parent, false);
        return new AccountViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AccountViewHolder holder, int position) {
        holder.OrderNo.setText(OrderNo.get(position));
        holder.OrderDate.setText(OrderDate.get(position));
        holder.OrderTime.setText(OrderTime.get(position));
        holder.OrderPrice.setText(OrderPrice.get(position));
        holder.OrderQuantity.setText(OrderQuantity.get(position));

    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public class AccountViewHolder extends RecyclerView.ViewHolder {

        TextView OrderNo, OrderDate, OrderTime, OrderPrice, OrderQuantity;

        public AccountViewHolder(@NonNull View itemView) {
            super(itemView);
            OrderNo = itemView.findViewById(R.id.Order_Number);
            OrderDate = itemView.findViewById(R.id.Order_Date);
            OrderTime = itemView.findViewById(R.id.Order_Time);
            OrderPrice = itemView.findViewById(R.id.Total_Order_Price);
            OrderQuantity = itemView.findViewById(R.id.Quantity);

        }
    }
}
