package com.irap.T_Recipies;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.irap.T_Recipies.R;

public class MainActivity extends AppCompatActivity {
    public static  int SPLASH_SCREEN=5000;
    Animation top,bottom;
    ImageView image;
    TextView t1,t2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        top = AnimationUtils.loadAnimation(this, R.anim.top_animation);
        bottom = AnimationUtils.loadAnimation(this, R.anim.bottom_animation);

        image = findViewById(R.id.splashimage);
        t1 = findViewById(R.id.splasht1);
        t2 = findViewById(R.id.splasht2);

        image.setAnimation(top);
        t1.setAnimation(bottom);
        t2.setAnimation(bottom);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i= new Intent(MainActivity.this,Login.class);
                startActivity(i);
                finish();
            }
        },SPLASH_SCREEN);



    }
}
