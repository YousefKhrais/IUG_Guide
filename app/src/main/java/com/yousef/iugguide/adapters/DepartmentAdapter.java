package com.yousef.iugguide.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.yousef.iugguide.AppClass;
import com.yousef.iugguide.databinding.ItemDepartmentBinding;
import com.yousef.iugguide.models.Department;
import com.yousef.iugguide.ui.colleges.DepartmentDetails;

import java.util.ArrayList;

public class DepartmentAdapter extends RecyclerView.Adapter<DepartmentAdapter.MyViewHolder> {

    Context context;
    ArrayList<Department> data;

    public DepartmentAdapter(Context context, ArrayList<Department> departments) {
        this.context = context;
        this.data = departments;
    }

    @NonNull
    @Override
    public DepartmentAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemDepartmentBinding binding = ItemDepartmentBinding.inflate(LayoutInflater.from(context), parent, false);
        return new DepartmentAdapter.MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull DepartmentAdapter.MyViewHolder holder, int position) {
        final TextView textView = holder.binding.departmentName;
        textView.setText(data.get(position).getName());
        holder.binding.departmentCardItem.setOnClickListener(v->{
            AppClass.chosenDepartment = data.get(position);
            Intent intent = new Intent(context, DepartmentDetails.class);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        ItemDepartmentBinding binding;

        public MyViewHolder(@NonNull ItemDepartmentBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

}
