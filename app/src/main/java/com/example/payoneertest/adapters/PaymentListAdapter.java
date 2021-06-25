package com.example.payoneertest.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.payoneertest.R;
import com.example.payoneertest.models.Applicable;

import java.util.List;

// Adapter for list of payment methods

public class PaymentListAdapter extends RecyclerView.Adapter<PaymentListAdapter.PaymentListViewHolder>
{
    Context context;
    List<Applicable> itemList;

    public PaymentListAdapter(Context context, List<Applicable> itemList)
    {
        this.context = context;
        this.itemList = itemList;
    }

    @NonNull
    @org.jetbrains.annotations.NotNull
    @Override
    public PaymentListViewHolder onCreateViewHolder(@NonNull @org.jetbrains.annotations.NotNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.payment_list_item, parent, false);
        return new PaymentListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @org.jetbrains.annotations.NotNull PaymentListViewHolder holder, int position)
    {
        Glide.with(this.context)
                .load(itemList.get(position).getLinks().getLogo())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.payment_item_image);

        holder.payment_item_name.setText(itemList.get(position).getLabel());
    }

    @Override
    public int getItemCount()
    {
        return itemList.size();
    }

    public static class PaymentListViewHolder extends RecyclerView.ViewHolder
    {
        ImageView payment_item_image;
        TextView payment_item_name;

        public PaymentListViewHolder(@NonNull @org.jetbrains.annotations.NotNull View itemView)
        {
            super(itemView);
            payment_item_image = itemView.findViewById(R.id.payment_item_image);
            payment_item_name = itemView.findViewById(R.id.payment_item_name);
        }
    }
}
