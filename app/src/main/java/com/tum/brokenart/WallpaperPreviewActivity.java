package com.tum.brokenart;

import android.app.WallpaperManager;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.google.android.gms.ads.AdView;


import java.io.IOException;

public class WallpaperPreviewActivity extends AppCompatActivity {
    ImageView previewImage;
    Button setWallpaperBtn;
    private AdView adView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wallpaper_preview);


        previewImage = findViewById(R.id.previewImage);
        setWallpaperBtn = findViewById(R.id.setWallpaperBtn);

        // 🔗 Get image URL from intent
        String imageUrl = getIntent().getStringExtra("imageUrl");

        if (imageUrl != null) {
            // Load image into ImageView using Glide
            Glide.with(this)
                    .load(imageUrl)
                    .into(previewImage);
        }

        setWallpaperBtn.setOnClickListener(v -> {
            if (imageUrl != null) {
                // Glide এর মাধ্যমে bitmap নিয়ে সেট করো
                Glide.with(this)
                        .asBitmap()
                        .load(imageUrl)
                        .into(new CustomTarget<Bitmap>() {
                            @Override
                            public void onResourceReady(Bitmap resource, Transition<? super Bitmap> transition) {
                                try {
                                    WallpaperManager wallpaperManager = WallpaperManager.getInstance(getApplicationContext());
                                    wallpaperManager.setBitmap(resource);
                                    Toast.makeText(WallpaperPreviewActivity.this, "Wallpaper set successfully!", Toast.LENGTH_SHORT).show();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                    Toast.makeText(WallpaperPreviewActivity.this, "Failed to set wallpaper", Toast.LENGTH_SHORT).show();
                                }
                            }

                            @Override
                            public void onLoadCleared(@Nullable Drawable placeholder) {
                            }
                        });
            }
        });
    }
}