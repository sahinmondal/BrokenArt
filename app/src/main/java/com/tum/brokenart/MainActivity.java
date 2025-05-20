package com.tum.brokenart;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<WallpaperModel> wallpaperList;

    private AdView adView;
    private InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Initialize AdMob
        MobileAds.initialize(this, initializationStatus -> {});

        // Load Banner Ad
        adView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);

        // Load Interstitial Ad
        InterstitialAd.load(this, "ca-app-pub-7832903149087002/2569829147", adRequest,
                new InterstitialAdLoadCallback() {
                    @Override
                    public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                        mInterstitialAd = interstitialAd;
                        Log.d("AdMob", "Interstitial Ad Loaded");

                        // Show interstitial after load (or trigger on button click)
                        mInterstitialAd.show(MainActivity.this);
                    }

                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        Log.d("AdMob", "Interstitial Failed: " + loadAdError.getMessage());
                        mInterstitialAd = null;
                    }
                });


        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        wallpaperList = new ArrayList<>();

        // 🔗 এখানে ইন্টারনেট থেকে ইমেজ লিংক গুলো দাও
        wallpaperList.add(new WallpaperModel("https://raw.githubusercontent.com/Micro-sys/BrokenkArt/master/wall1.jpg"));
        wallpaperList.add(new WallpaperModel("https://raw.githubusercontent.com/Micro-sys/BrokenkArt/master/wall2.jpg"));
        wallpaperList.add(new WallpaperModel("https://raw.githubusercontent.com/Micro-sys/BrokenkArt/master/wall3.jpg"));
        wallpaperList.add(new WallpaperModel("https://raw.githubusercontent.com/Micro-sys/BrokenkArt/master/wall4.jpg"));
        wallpaperList.add(new WallpaperModel("https://raw.githubusercontent.com/Micro-sys/BrokenkArt/master/wall5.jpg"));
        wallpaperList.add(new WallpaperModel("https://raw.githubusercontent.com/Micro-sys/BrokenkArt/master/wall6.jpg"));
        wallpaperList.add(new WallpaperModel("https://raw.githubusercontent.com/Micro-sys/BrokenkArt/master/wall7.jpg"));
        wallpaperList.add(new WallpaperModel("https://raw.githubusercontent.com/Micro-sys/BrokenkArt/master/wall8.jpg"));
        wallpaperList.add(new WallpaperModel("https://raw.githubusercontent.com/Micro-sys/BrokenkArt/master/wall9.jpg"));
        wallpaperList.add(new WallpaperModel("https://raw.githubusercontent.com/Micro-sys/BrokenkArt/master/wall10.jpg"));
        wallpaperList.add(new WallpaperModel("https://raw.githubusercontent.com/Micro-sys/BrokenkArt/master/wall11.jpg"));
        wallpaperList.add(new WallpaperModel("https://raw.githubusercontent.com/Micro-sys/BrokenkArt/master/wall12.jpg"));
        wallpaperList.add(new WallpaperModel("https://raw.githubusercontent.com/Micro-sys/BrokenkArt/master/wall13.jpg"));
        wallpaperList.add(new WallpaperModel("https://raw.githubusercontent.com/Micro-sys/BrokenkArt/master/wall14.jpg"));
        wallpaperList.add(new WallpaperModel("https://raw.githubusercontent.com/Micro-sys/BrokenkArt/master/wall15.jpg"));
        wallpaperList.add(new WallpaperModel("https://raw.githubusercontent.com/Micro-sys/BrokenkArt/master/wall16.jpg"));
        wallpaperList.add(new WallpaperModel("https://raw.githubusercontent.com/Micro-sys/BrokenkArt/master/wall17.jpg"));
        wallpaperList.add(new WallpaperModel("https://raw.githubusercontent.com/Micro-sys/BrokenkArt/master/wall18.jpg"));
        wallpaperList.add(new WallpaperModel("https://raw.githubusercontent.com/Micro-sys/BrokenkArt/master/wall19.jpg"));
        wallpaperList.add(new WallpaperModel("https://raw.githubusercontent.com/Micro-sys/BrokenkArt/master/wall20.jpg"));
        wallpaperList.add(new WallpaperModel("https://raw.githubusercontent.com/Micro-sys/BrokenkArt/master/wall21.jpg"));
        wallpaperList.add(new WallpaperModel("https://raw.githubusercontent.com/Micro-sys/BrokenkArt/master/wall22.jpg"));
        wallpaperList.add(new WallpaperModel("https://raw.githubusercontent.com/Micro-sys/BrokenkArt/master/wall23.jpg"));
        wallpaperList.add(new WallpaperModel("https://raw.githubusercontent.com/Micro-sys/BrokenkArt/master/wall24.jpg"));
        wallpaperList.add(new WallpaperModel("https://raw.githubusercontent.com/Micro-sys/BrokenkArt/master/wall25.jpg"));
        wallpaperList.add(new WallpaperModel("https://raw.githubusercontent.com/Micro-sys/BrokenkArt/master/wall26.jpg"));
        wallpaperList.add(new WallpaperModel("https://raw.githubusercontent.com/Micro-sys/BrokenkArt/master/wall27.jpg"));
        wallpaperList.add(new WallpaperModel("https://raw.githubusercontent.com/Micro-sys/BrokenkArt/master/wall28.jpg"));
        wallpaperList.add(new WallpaperModel("https://raw.githubusercontent.com/Micro-sys/BrokenkArt/master/wall29.jpg"));
        wallpaperList.add(new WallpaperModel("https://raw.githubusercontent.com/Micro-sys/BrokenkArt/master/wall30.jpg"));
        wallpaperList.add(new WallpaperModel("https://raw.githubusercontent.com/Micro-sys/BrokenkArt/master/wall31.jpg"));
        wallpaperList.add(new WallpaperModel("https://raw.githubusercontent.com/Micro-sys/BrokenkArt/master/wall32.jpg"));
        wallpaperList.add(new WallpaperModel("https://raw.githubusercontent.com/Micro-sys/BrokenkArt/master/wall33.jpg"));
        wallpaperList.add(new WallpaperModel("https://raw.githubusercontent.com/Micro-sys/BrokenkArt/master/wall34.jpg"));
        wallpaperList.add(new WallpaperModel("https://raw.githubusercontent.com/Micro-sys/BrokenkArt/master/wall35.jpg"));
        wallpaperList.add(new WallpaperModel("https://raw.githubusercontent.com/Micro-sys/BrokenkArt/master/wall36.jpg"));
        wallpaperList.add(new WallpaperModel("https://raw.githubusercontent.com/Micro-sys/BrokenkArt/master/wall37.jpg"));
        wallpaperList.add(new WallpaperModel("https://raw.githubusercontent.com/Micro-sys/BrokenkArt/master/wall38.jpg"));
        wallpaperList.add(new WallpaperModel("https://raw.githubusercontent.com/Micro-sys/BrokenkArt/master/wall39.jpg"));
        wallpaperList.add(new WallpaperModel("https://raw.githubusercontent.com/Micro-sys/BrokenkArt/master/wall40.jpg"));
        wallpaperList.add(new WallpaperModel("https://raw.githubusercontent.com/Micro-sys/BrokenkArt/master/wall41.jpg"));
        wallpaperList.add(new WallpaperModel("https://raw.githubusercontent.com/Micro-sys/BrokenkArt/master/wall42.jpg"));
        wallpaperList.add(new WallpaperModel("https://raw.githubusercontent.com/Micro-sys/BrokenkArt/master/wall43.jpg"));
        wallpaperList.add(new WallpaperModel("https://raw.githubusercontent.com/Micro-sys/BrokenkArt/master/wall44.jpg"));
        wallpaperList.add(new WallpaperModel("https://raw.githubusercontent.com/Micro-sys/BrokenkArt/master/wall45.jpg"));
        wallpaperList.add(new WallpaperModel("https://raw.githubusercontent.com/Micro-sys/BrokenkArt/master/wall46.jpg"));
        wallpaperList.add(new WallpaperModel("https://raw.githubusercontent.com/Micro-sys/BrokenkArt/master/wall47.jpg"));
        wallpaperList.add(new WallpaperModel("https://raw.githubusercontent.com/Micro-sys/BrokenkArt/master/wall48.jpg"));
        wallpaperList.add(new WallpaperModel("https://raw.githubusercontent.com/Micro-sys/BrokenkArt/master/wall49.jpg"));
        wallpaperList.add(new WallpaperModel("https://raw.githubusercontent.com/Micro-sys/BrokenkArt/master/wall50.jpg"));
        wallpaperList.add(new WallpaperModel("https://raw.githubusercontent.com/Micro-sys/BrokenkArt/master/wall51.jpg"));
        wallpaperList.add(new WallpaperModel("https://raw.githubusercontent.com/Micro-sys/BrokenkArt/master/wall52.jpg"));
        wallpaperList.add(new WallpaperModel("https://raw.githubusercontent.com/Micro-sys/BrokenkArt/master/wall53.jpg"));
        wallpaperList.add(new WallpaperModel("https://raw.githubusercontent.com/Micro-sys/BrokenkArt/master/wall54.jpg"));
        wallpaperList.add(new WallpaperModel("https://raw.githubusercontent.com/Micro-sys/BrokenkArt/master/wall55.jpg"));
        wallpaperList.add(new WallpaperModel("https://raw.githubusercontent.com/Micro-sys/BrokenkArt/master/wall56.jpg"));
        wallpaperList.add(new WallpaperModel("https://raw.githubusercontent.com/Micro-sys/BrokenkArt/master/wall57.jpg"));
        wallpaperList.add(new WallpaperModel("https://raw.githubusercontent.com/Micro-sys/BrokenkArt/master/wall58.jpg"));
        wallpaperList.add(new WallpaperModel("https://raw.githubusercontent.com/Micro-sys/BrokenkArt/master/wall59.jpg"));
        wallpaperList.add(new WallpaperModel("https://raw.githubusercontent.com/Micro-sys/BrokenkArt/master/wall60.jpg"));




        // অ্যাডাপ্টার সেট করো
        WallpaperAdapter adapter = new WallpaperAdapter(this, wallpaperList);
        recyclerView.setAdapter(adapter);
    }
}