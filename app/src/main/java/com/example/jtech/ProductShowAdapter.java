package com.example.jtech;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.List;


public class ProductShowAdapter extends RecyclerView.Adapter<ProductShowAdapter.ViewHolder> {
    private List<CPU> cpuList;

    public ProductShowAdapter(List<CPU> cpuList) {
        this.cpuList = cpuList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_show_adapter_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if (cpuList == null || cpuList.isEmpty()) {
            // Handle the case where cpuList is null or empty (e.g., show a message or hide the RecyclerView)
            Log.d("ProductShowAdapter", "cpuList is null or empty");
            return;
        }

        CPU cpu = cpuList.get(position);

        if (cpu == null || cpu.getSpecs() == null) {
            // Handle the case where cpu or specs is null (e.g., set default values or hide the view)
            // For example:
            Log.d("ProductShowAdapter", "cpu or specs is null at position " + position);
            holder.cpuName.setText("N/A");
            holder.cpuPrice.setText("Price: $0");
            holder.cpuImage.setImageResource(R.drawable.ic_launcher_background); // Provide a default image resource
            return;
        }

        // Add logging to check if data is present
        Log.d("ProductShowAdapter", "CPU Name: " + cpu.getSpecs().getName());
        Log.d("ProductShowAdapter", "CPU Price: $" + cpu.getSpecs().getPrice());
        Log.d("ProductShowAdapter", "CPU Image URL: " + cpu.getSpecs().getImage());

        // Bind data to the ViewHolder's views
        holder.cpuName.setText(cpu.getSpecs().getName());
        holder.cpuPrice.setText("Price: $" + cpu.getSpecs().getPrice());

        // Load the image using Glide
        Glide.with(holder.itemView.getContext())
                .load(cpu.getSpecs().getImage())
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.cpuImage);
    }



    @Override
    public int getItemCount() {
        return cpuList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView cpuImage;
        TextView cpuName;
        TextView cpuPrice;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cpuImage = itemView.findViewById(R.id.productImage);
            cpuName = itemView.findViewById(R.id.productName);
            cpuPrice = itemView.findViewById(R.id.productPrice);
        }
    }
}
