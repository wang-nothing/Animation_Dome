package com.example.admin.animation_dome;

import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main2Activity extends AppCompatActivity {
    private Button mbtn_value;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        mbtn_value=(Button) findViewById(R.id.main);
        mbtn_value.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //ofInt（）方法表示数值从60变化到0
                ValueAnimator animator=ValueAnimator.ofInt(60,0);
                //设置变化时间
                animator.setDuration(60000);
                //为Animator设置刷新监听
                animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        //获取每次变化的数值
                        Integer i=(Integer) animation.getAnimatedValue();
                        //赋给button按钮            mbtn_value.setText(""+i);
                        mbtn_value.setText(""+i);
                    }
                });
                //注：记得开启ValueAnimator
                animator.start();
            }
        });
    }


}
