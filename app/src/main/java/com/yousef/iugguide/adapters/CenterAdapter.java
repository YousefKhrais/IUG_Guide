package com.yousef.iugguide.adapters;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.yousef.iugguide.databinding.ItemCenterBinding;
import com.yousef.iugguide.models.Center;

import java.util.ArrayList;

public class CenterAdapter extends RecyclerView.Adapter<CenterAdapter.MyViewHolder> {

    private ArrayList<Center> data;
    private Context context;

    public CenterAdapter(Context context, ArrayList<Center> centers) {
        this.context = context;
        this.data = centers;
    }

    @NonNull
    @Override
    public CenterAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CenterAdapter.MyViewHolder(ItemCenterBinding.inflate(LayoutInflater.from(context), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CenterAdapter.MyViewHolder holder, int position) {
        final ImageView imageView = holder.binding.buildingImage;

        holder.binding.cardViewImageTitle.setText(data.get(position).getTitle());

        Resources resources = context.getResources();
        final int resourceId = resources.getIdentifier(data.get(position).getImageUrl(), "drawable", context.getPackageName());
        holder.binding.buildingImage.setImageDrawable(ResourcesCompat.getDrawable(resources, resourceId, null));

        holder.itemView.setOnClickListener(v -> {
            Toast.makeText(context, data.get(position).getTitle(), Toast.LENGTH_SHORT).show();
//            AppClass.chosenCenter = data.get(position);
//            Intent intent = new Intent(context, BuildingDetails.class);
//            context.startActivity(intent);
//            System.out.println(data.get(position).toString());
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ItemCenterBinding binding;

        public MyViewHolder(@NonNull ItemCenterBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
