package com.example.app1;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Reference to the box (View)
        View box = findViewById(R.id.box);

        // References to the arrow buttons
        Button arrowUp = findViewById(R.id.arrowUp);
        Button arrowDown = findViewById(R.id.arrowDown);
        Button arrowLeft = findViewById(R.id.arrowLeft);
        Button arrowRight = findViewById(R.id.arrowRight);

        // Set click listeners for each button
        arrowUp.setOnClickListener(v -> {
            Animation animation = AnimationUtils.loadAnimation(this, R.anim.flip_up);
            box.startAnimation(animation);
        });

        arrowDown.setOnClickListener(v -> {
            Animation animation = AnimationUtils.loadAnimation(this, R.anim.flip_down);
            box.startAnimation(animation);
        });

        arrowLeft.setOnClickListener(v -> {
            Animation animation = AnimationUtils.loadAnimation(this, R.anim.flip_left);
            box.startAnimation(animation);
        });

        arrowRight.setOnClickListener(v -> {
            Animation animation = AnimationUtils.loadAnimation(this, R.anim.flip_right);
            box.startAnimation(animation);
        });
    }
}
