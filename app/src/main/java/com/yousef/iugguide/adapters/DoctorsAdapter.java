package com.yousef.iugguide.adapters;

import android.animation.LayoutTransition;
import android.content.Context;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.yousef.iugguide.databinding.DoctorItemBinding;
import com.yousef.iugguide.models.Doctor;

import java.util.ArrayList;

public class DoctorsAdapter extends RecyclerView.Adapter<DoctorsAdapter.MyViewHolder> {

    Context context;
    ArrayList<Doctor> data;

    public DoctorsAdapter(Context context, ArrayList<Doctor> doctors) {
        this.context = context;
        this.data = doctors;
    }

    @NonNull
    @Override
    public DoctorsAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        DoctorItemBinding binding = DoctorItemBinding.inflate(LayoutInflater.from(context), parent, false);
        return new DoctorsAdapter.MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull DoctorsAdapter.MyViewHolder holder, int position) {
        ImageView doctor_details = holder.binding.showDoctorDetails;
        LinearLayout layout = holder.binding.layout;
        layout.getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);
        LinearLayout details = holder.binding.details;

        holder.binding.doctorCard.setOnClickListener(view -> {
            int v = (details.getVisibility() == View.GONE) ? View.VISIBLE : View.GONE;
            TransitionManager.beginDelayedTransition(layout, new AutoTransition());
            details.setVisibility(v);
        });

        holder.binding.doctorName.setText(data.get(position).getName());
        holder.binding.specialty.setText(data.get(position).getDepartment());
        holder.binding.roomNumber.setText(data.get(position).getInsidePhone());
        holder.binding.email.setText(data.get(position).getEmail());

//        private String department;
//        private String degree;
//        private String insidePhone;
//        private String email;

//        holder.binding.roomNumber.setText(data.get(position).getRoomNumber());
//        holder.binding.specialty.setText(data.get(position).getSpecialty());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        DoctorItemBinding binding;

        public MyViewHolder(@NonNull DoctorItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
