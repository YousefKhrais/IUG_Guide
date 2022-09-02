package com.yousef.iugguide.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.yousef.iugguide.R;
import com.yousef.iugguide.models.HomeItem;

import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {

    List<HomeItem> homeItems;
    LayoutInflater inflater;
    View.OnClickListener onClickListener;
    Context ctx;

    public HomeAdapter(Context ctx, List<HomeItem> homeItems, View.OnClickListener onClickListener) {
        this.homeItems = homeItems;
        this.inflater = LayoutInflater.from(ctx);
        this.onClickListener = onClickListener;
        this.ctx = ctx;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_home, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.title.setText(homeItems.get(position).getTitle());
        holder.gridIcon.setImageResource(homeItems.get(position).getImageResId());

//        holder.gridIcon.setColorFilter(ContextCompat.getColor(ctx, R.color.teal_200), android.graphics.PorterDuff.Mode.SRC_IN);

        holder.itemView.setTag(homeItems.get(position).getTag());
    }

    @Override
    public int getItemCount() {
        return homeItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        ImageView gridIcon;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.textView2);
            gridIcon = itemView.findViewById(R.id.imageView2);
            itemView.setOnClickListener(onClickListener);
        }
    }
}