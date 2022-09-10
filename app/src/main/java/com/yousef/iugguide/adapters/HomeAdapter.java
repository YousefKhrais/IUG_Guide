package com.yousef.iugguide.adapters;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.yousef.iugguide.R;
import com.yousef.iugguide.helpers.SharedPreferenceHelper;
import com.yousef.iugguide.models.HomeItem;

import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {

    private List<HomeItem> homeItems;
    private LayoutInflater inflater;
    private View.OnClickListener onClickListener;
    private Context context;

    public HomeAdapter(Context ctx, List<HomeItem> homeItems, View.OnClickListener onClickListener) {
        this.homeItems = homeItems;
        this.inflater = LayoutInflater.from(ctx);
        this.onClickListener = onClickListener;
        this.context = ctx;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(R.layout.item_home, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.title.setText(homeItems.get(position).getTitle());
        holder.gridIcon.setImageResource(homeItems.get(position).getImageResId());
        holder.itemView.setTag(homeItems.get(position).getTag());

        Drawable unwrappedDrawable = AppCompatResources.getDrawable(context, homeItems.get(position).getImageResId());
        Drawable wrappedDrawable = DrawableCompat.wrap(unwrappedDrawable);

        int iconColor = SharedPreferenceHelper.getIconsColor(context);
        if (iconColor != 0) {
            DrawableCompat.setTint(wrappedDrawable, iconColor);
        } else {
            DrawableCompat.setTint(wrappedDrawable, context.getResources().getColor(R.color.icons_color));
        }

        int backgroundColor = SharedPreferenceHelper.getBackgroundColor(context);
        if (backgroundColor != 0) {
            holder.cardView.setBackgroundTintList(ColorStateList.valueOf(backgroundColor));
        } else {
            holder.cardView.setBackgroundTintList(ColorStateList.valueOf(context.getResources().getColor(R.color.white)));
        }

        int fontColor = SharedPreferenceHelper.getFontColor(context);
        if (fontColor != 0) {
            holder.title.setTextColor(ColorStateList.valueOf(fontColor));
        }

        holder.gridIcon.setImageDrawable(wrappedDrawable);
    }

    @Override
    public int getItemCount() {
        return homeItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView title;
        private ImageView gridIcon;
        private CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.textView2);
            gridIcon = itemView.findViewById(R.id.imageView2);
            cardView = itemView.findViewById(R.id.card_viwe);
            itemView.setOnClickListener(onClickListener);
        }
    }
}