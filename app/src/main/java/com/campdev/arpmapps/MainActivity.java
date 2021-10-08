package com.campdev.arpmapps;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

public class MainActivity extends AppCompatActivity {
    private int waktu_loading = 3000;
    ImageView splashimg;
    LottieAnimationView lottieAnimationView;
    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //splashimg = findViewById(R.id.img);
        lottieAnimationView = findViewById(R.id.lottie);
        textView = findViewById(R.id.tetx);
        Animation animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.bounce);
        textView.setAnimation(animation);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent home = new Intent(MainActivity.this, HomeActivity.class);
                startActivity(home);
                overridePendingTransition(R.anim.righttoleft, R.anim.lefttoright);
                overridePendingTransition(R.anim.lefttoright, R.anim.righttoleft);

            }
        },waktu_loading);
    }
}