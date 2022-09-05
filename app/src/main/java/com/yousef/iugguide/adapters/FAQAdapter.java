package com.yousef.iugguide.adapters;

import android.animation.LayoutTransition;
import android.content.Context;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.yousef.iugguide.databinding.ItemFaqBinding;
import com.yousef.iugguide.models.FAQ;

import java.util.ArrayList;

public class FAQAdapter extends RecyclerView.Adapter<FAQAdapter.MyViewHolder> {

    Context context;
    ArrayList<FAQ> data;

    public FAQAdapter(Context context, ArrayList<FAQ> faqArrayList) {
        this.context = context;
        this.data = faqArrayList;
    }

    @NonNull
    @Override
    public FAQAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemFaqBinding binding = ItemFaqBinding.inflate(LayoutInflater.from(context), parent, false);
        return new FAQAdapter.MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull FAQAdapter.MyViewHolder holder, int position) {
        LinearLayout layout = holder.binding.layout;
        layout.getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);

        LinearLayout details = holder.binding.details;

        holder.binding.doctorCard.setOnClickListener(view -> {
                    int v = (details.getVisibility() == View.GONE) ? View.VISIBLE : View.GONE;
                    TransitionManager.beginDelayedTransition(layout, new AutoTransition());
                    details.setVisibility(v);
                }
        );

        holder.binding.doctorName.setText(data.get(position).getQuestion());
        holder.binding.specialty.setText(data.get(position).getAnswer());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ItemFaqBinding binding;

        public MyViewHolder(@NonNull ItemFaqBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
