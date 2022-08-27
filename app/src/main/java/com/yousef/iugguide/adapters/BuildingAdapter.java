package com.yousef.iugguide.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.yousef.iugguide.AppClass;
import com.yousef.iugguide.databinding.ItemBuildingBinding;
import com.yousef.iugguide.models.Building;
import com.yousef.iugguide.ui.buildings.BuildingDetails;

import java.util.ArrayList;

public class BuildingAdapter extends RecyclerView.Adapter<BuildingAdapter.MyViewHolder> {

    Context context;
    ArrayList<Building> data;

    public BuildingAdapter(Context context, ArrayList<Building> buildings) {
        this.context = context;
        this.data = buildings;
    }

    @NonNull
    @Override
    public BuildingAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemBuildingBinding binding = ItemBuildingBinding.inflate(LayoutInflater.from(context), parent, false);
        return new BuildingAdapter.MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull BuildingAdapter.MyViewHolder holder, int position) {
        final ImageView imageView = holder.binding.buildingImage;
        holder.binding.cardViewImageTitle.setText(data.get(position).getName());
        holder.binding.cardViceTitle.setText(data.get(position).getKey());

        Picasso.get().load(data.get(position).getMainImageUrl()).into(holder.binding.buildingImage);
        imageView.setOnClickListener(v -> {
            AppClass.chosenBuilding = data.get(position);
            Intent intent = new Intent(context, BuildingDetails.class);
            context.startActivity(intent);
            System.out.println(data.get(position).toString());
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        ItemBuildingBinding binding;

        public MyViewHolder(@NonNull ItemBuildingBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

}
