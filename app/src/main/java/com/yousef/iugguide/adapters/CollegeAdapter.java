package com.yousef.iugguide.adapters;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.yousef.iugguide.AppClass;
import com.yousef.iugguide.databinding.ItemCollegeBinding;
import com.yousef.iugguide.models.College;
import com.yousef.iugguide.ui.colleges.CollegeDetails;

import java.util.ArrayList;

public class CollegeAdapter extends RecyclerView.Adapter<CollegeAdapter.MyViewHolder> {

    Context context;
    ArrayList<College> data;

    public CollegeAdapter(Context context, ArrayList<College> colleges) {
        this.context = context;
        this.data = colleges;
    }

    @NonNull
    @Override
    public CollegeAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemCollegeBinding binding = ItemCollegeBinding.inflate(LayoutInflater.from(context), parent, false);
        return new CollegeAdapter.MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CollegeAdapter.MyViewHolder holder, int position) {
        final ImageView imageView = holder.binding.collegeImage;
        Resources resources = context.getResources();
        final int resourceId = resources.getIdentifier("img_"+data.get(position).getImageUrl(), "drawable", context.getPackageName());
        imageView.setImageDrawable(ResourcesCompat.getDrawable(resources, resourceId, null));

        imageView.setOnClickListener(v->{
            AppClass.chosenCollege = data.get(position);
            Intent intent = new Intent(context, CollegeDetails.class);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ItemCollegeBinding binding;

        public MyViewHolder(@NonNull ItemCollegeBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
