package com.example.admin.animation_dome;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button main_translate,mian_scale,main_rotate,main_alpha,main_set;
    private ImageView mian_image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        mian_image = findViewById(R.id.mian_image);
        main_translate = findViewById(R.id.main_translate);
        mian_scale = findViewById(R.id.mian_scale);
        main_rotate = findViewById(R.id.main_rotate);
        main_alpha = findViewById(R.id.main_alpha);
        main_set = findViewById(R.id.main_set);
        initListener();
    }

    private void initListener() {
        main_translate.setOnClickListener(this);
        mian_scale.setOnClickListener(this);
        main_rotate.setOnClickListener(this);
        main_alpha.setOnClickListener(this);
        main_set.setOnClickListener(this);
        mian_image.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.main_translate:
                ObjectAnimator translationX = ObjectAnimator.ofFloat(mian_image, "translationX", 0.0f, 350.0f);
                translationX.setDuration(1000);
                translationX.start();

                break;

            case R.id.mian_scale:
                ObjectAnimator scale = ObjectAnimator.ofFloat(mian_image, "scaleX", 1.0f, 0.5f);
                scale.setDuration(1000);
                scale.start();

                break;

            case R.id.main_rotate:
                ObjectAnimator rotationX = ObjectAnimator.ofFloat(mian_image, "rotationX", 0.0f, 360.0f);
                rotationX.setDuration(1000);
                rotationX.start();
                break;

            case R.id.main_alpha:
                ObjectAnimator alpha = ObjectAnimator.ofFloat(mian_image, "alpha", 1.0f, 0.5f);
                alpha.setDuration(1000);
                alpha.start();
                break;

            case R.id.main_set:
                    AnimatorSet animatorSet = new AnimatorSet();
                    ObjectAnimator translationX1 = ObjectAnimator.ofFloat(mian_image, "translationX", 0.0f, 350.0f);
                    ObjectAnimator scale1 = ObjectAnimator.ofFloat(mian_image, "scaleX", 1.0f, 0.5f, 1.0f);
                    ObjectAnimator rotationX1 = ObjectAnimator.ofFloat(mian_image, "rotationX", 0.0f, 360.0f, 0.0f);
                    ObjectAnimator alpha1 = ObjectAnimator.ofFloat(mian_image, "alpha", 1.0f, 0.5f, 1.0f);
                    animatorSet.play(translationX1).with(scale1).with(rotationX1).after(alpha1);
                    animatorSet.setDuration(2000);
                    animatorSet.start();
                break;

            case R.id.mian_image:
                Toast.makeText(MainActivity.this,"啥呀，图片", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this, Main2Activity.class));
                break;

        }
    }
}
