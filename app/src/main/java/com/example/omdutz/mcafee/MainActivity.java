package com.example.omdutz.mcafee;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView gambar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gambar = (ImageView)findViewById(R.id.logo);
        Animation fade = AnimationUtils.loadAnimation(this,R.anim.fade);
        gambar.startAnimation(fade);
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Animation fade2 = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade2);

                gambar.startAnimation(fade2);
                Intent intent = new Intent(MainActivity.this, Login.class);
                startActivity(intent);
                overridePendingTransition(R.anim.left,R.anim.left_exit);
                finish();
            }
        },3000L);
    }
}
