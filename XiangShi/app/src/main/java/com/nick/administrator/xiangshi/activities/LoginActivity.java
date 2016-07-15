package com.nick.administrator.xiangshi.activities;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.nick.administrator.xiangshi.R;

public class LoginActivity extends AppCompatActivity {

    private ImageView backImage;
    private TextView fastRegister;
    private LinearLayout llayoutWeiXin;
    private LinearLayout llayoutQQ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        backImage = ((ImageView) findViewById(R.id.btn_icon_close_press));
        fastRegister = ((TextView) findViewById(R.id.fastRegister));
        llayoutWeiXin = ((LinearLayout) findViewById(R.id.llayout_weixin));
        llayoutQQ = ((LinearLayout) findViewById(R.id.llayout_qq));

        ObjectAnimator objectAnimatorWeiXin = ObjectAnimator.ofFloat(llayoutWeiXin,"TranslationY",500,0);
        objectAnimatorWeiXin.setDuration(1000);
        objectAnimatorWeiXin.start();

        ObjectAnimator objectAnimatorQQ = ObjectAnimator.ofFloat(llayoutQQ,"TranslationY",800,0);
        objectAnimatorQQ.setDuration(1200);
        objectAnimatorQQ.start();


        backImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        fastRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });

    }
}
