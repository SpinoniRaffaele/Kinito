package com.example.kinito;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.airbnb.lottie.LottieAnimationView;
import com.google.android.gms.ads.MobileAds;

import java.util.Objects;

public class IntroActivity extends AppCompatActivity {

    private long mLastClickTime = 0;

    private final int initialDelay = 1700;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        Objects.requireNonNull(getSupportActionBar()).hide();
        TextView rules = findViewById(R.id.rules);
        TextView credits = findViewById(R.id.credits);
        ImageView logo = findViewById(R.id.logo);
        ConstraintLayout context = findViewById(R.id.context);
        LottieAnimationView animation = findViewById(R.id.animationIntro);
        rules.setClipToOutline(true);
        credits.setClipToOutline(true);
        logo.setClipToOutline(true);

        new Handler().postDelayed(() -> {
            Animation fadeInAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fadein);
            logo.startAnimation(fadeInAnimation);
            credits.startAnimation(fadeInAnimation);
            rules.startAnimation(fadeInAnimation);
            logo.setVisibility(View.VISIBLE);
            credits.setVisibility(View.VISIBLE);
            rules.setVisibility(View.VISIBLE);

            rules.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(), Rules.class)));

            credits.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(), Credits.class)));

            context.setOnClickListener(v -> {
                if (SystemClock.elapsedRealtime() - mLastClickTime < 1500){
                    return;
                }
                mLastClickTime = SystemClock.elapsedRealtime();
                String errorToast = "Tocca la cassa di birre per iniziare";
                Toast toast = Toast.makeText(getApplicationContext(), errorToast, Toast.LENGTH_SHORT);
                toast.show();
            });

            animation.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(), MainActivity.class)));

        },initialDelay);
    }
}