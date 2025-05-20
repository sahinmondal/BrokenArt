package com.tum.brokenart;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class WallpaperAdapter extends RecyclerView.Adapter<WallpaperAdapter.WallpaperViewHolder>{

    Context context;
    List<WallpaperModel> wallpaperList;

    public WallpaperAdapter(Context context, List<WallpaperModel> wallpaperList) {
        this.context = context;
        this.wallpaperList = wallpaperList;
    }

    @NonNull
    @Override
    public WallpaperViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.wallpaper_item, parent, false);
        return new WallpaperViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WallpaperViewHolder holder, int position) {
        String imageUrl = wallpaperList.get(position).getImageUrl();

        // Glide দিয়ে ইমেজ লোড করো
        Glide.with(context)
                .load(imageUrl)
                .into(holder.imageView);

        // OnClickListener দিয়ে ইমেজ ক্লিক করলে নতুন Activity তে যাও
        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, WallpaperPreviewActivity.class);
            intent.putExtra("imageUrl", imageUrl);  // ইমেজ URL পাস করো
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return wallpaperList.size();
    }

    public static class WallpaperViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;

        public WallpaperViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.wallpaperImage);
        }
    }
}