package com.yousef.iugguide;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.yousef.iugguide.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    FloatingActionButton mainFab, instagramFab, facebookFab, twitterFab, telegramFab, youtubeFab, gmailFab;
    Animation fabOpen, fabClose, rotateForward, rotateBackward;
    boolean isOpen = false;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupWithNavController(binding.navView, navController);

        mainFab = binding.mainFab;
        instagramFab = binding.instagramFab;
        facebookFab = binding.facebookFab;
        twitterFab = binding.twitterFab;
        telegramFab = binding.telegramFab;
        youtubeFab = binding.youtubeFab;
        gmailFab = binding.gmailFab;
        ////animation
        fabOpen = AnimationUtils.loadAnimation(this, R.anim.tap_open);
        fabClose = AnimationUtils.loadAnimation(this, R.anim.tap_close);
        rotateBackward = AnimationUtils.loadAnimation(this, R.anim.rotate_backwawrd);
        rotateForward = AnimationUtils.loadAnimation(this, R.anim.rotate_forward);
        mainFab.setOnClickListener(v -> {

            animateFab();
        });

        instagramFab.setOnClickListener(v -> {
            Uri uri = Uri.parse("https://www.instagram.com/iugaza.ps");
            Intent likeIng = new Intent(Intent.ACTION_VIEW, uri);

            likeIng.setPackage("com.instagram.android");

            try {
                startActivity(likeIng);
            } catch (ActivityNotFoundException e) {
                startActivity(new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://www.instagram.com/iugaza.ps")));
            }
        });
        facebookFab.setOnClickListener(v -> {

            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/IUGAZA"));
            startActivity(intent);
        });
        twitterFab.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/iugaza"));
            startActivity(intent);
        });
        telegramFab.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://t.me/iugaza1"));
            startActivity(intent);
        });
        gmailFab.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("mailto:http://public@iugaza.edu.ps"));
            startActivity(intent);
        });
        youtubeFab.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/user/mediaiug/featured"));
            startActivity(intent);
        });
    }

    private void animateFab() {
        if (isOpen) {
            mainFab.startAnimation(rotateBackward);
            instagramFab.startAnimation(fabClose);
            facebookFab.startAnimation(fabClose);
            twitterFab.startAnimation(fabClose);
            telegramFab.startAnimation(fabClose);
            youtubeFab.startAnimation(fabClose);
            gmailFab.startAnimation(fabClose);
            instagramFab.setClickable(false);
            facebookFab.setClickable(false);
            twitterFab.setClickable(false);
            telegramFab.setClickable(false);
            youtubeFab.setClickable(false);
            gmailFab.setClickable(false);
            isOpen = false;
        } else {
            mainFab.startAnimation(rotateForward);
            instagramFab.startAnimation(fabOpen);
            facebookFab.startAnimation(fabOpen);
            twitterFab.startAnimation(fabOpen);
            telegramFab.startAnimation(fabOpen);
            youtubeFab.startAnimation(fabOpen);
            gmailFab.startAnimation(fabOpen);
            instagramFab.setClickable(true);
            facebookFab.setClickable(true);
            twitterFab.setClickable(true);
            telegramFab.setClickable(true);
            youtubeFab.setClickable(true);
            gmailFab.setClickable(true);
            isOpen = true;
        }
    }
}