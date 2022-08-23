package com.yousef.iugguide.adapters;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.yousef.iugguide.AppClass;
import com.yousef.iugguide.databinding.BuildingItemBinding;
import com.yousef.iugguide.models.Building;
import com.yousef.iugguide.ui.buildings.BuildingDetails;

import java.util.ArrayList;

public class BuildingAdapter extends RecyclerView.Adapter<BuildingAdapter.MyViewHolder> {

    Context context;
    ArrayList<Building> data;

    public BuildingAdapter(Context context, ArrayList<Building> clinics) {
        this.context = context;
        this.data = clinics;
    }

    @NonNull
    @Override
    public BuildingAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        BuildingItemBinding binding = BuildingItemBinding.inflate(LayoutInflater.from(context), parent, false);
        return new BuildingAdapter.MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull BuildingAdapter.MyViewHolder holder, int position) {
        final ImageView imageView = holder.binding.buildingImage;
        Resources resources = context.getResources();
       final int resourceId = resources.getIdentifier("bg_"+data.get(position).getMainImageUrl(), "drawable", context.getPackageName());
       imageView.setImageDrawable(resources.getDrawable(resourceId));
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
        BuildingItemBinding binding;

        public MyViewHolder(@NonNull BuildingItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

}
