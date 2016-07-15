package com.nick.administrator.xiangshi.activities;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.nick.administrator.xiangshi.R;
import com.nick.administrator.xiangshi.app.MyApp;

public class SplashActivity extends AppCompatActivity {
    private ImageView imageView;
    private static final int MSG_TURN = 0X00;
    private int duration = 1000;
    private int count = 1;
    private TextView countMinusText;

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == MSG_TURN) {
                count--;
                countMinusText.setText(count + "秒，点击跳过");
                if (count <= 0) {
                    if (handler.hasMessages(MSG_TURN))
                        handler.removeMessages(MSG_TURN);
                    Intent intent = new Intent();
                    if (MyApp.isFirstLogin()) {
                        intent.setClass(SplashActivity.this, Welcome_Activity.class);
                    } else {
                        intent.setClass(SplashActivity.this, MainActivity.class);
                    }
                    startActivity(intent);
                    finish();
                } else {
                    handler.sendEmptyMessageDelayed(MSG_TURN, duration);
                }
            }
        }
    };
    private Button burnToMain;

    public void countTextClick(View v){
        if(handler.hasMessages(MSG_TURN))
            handler.removeMessages(MSG_TURN);
        Intent intent = new Intent();
        if(MyApp.isFirstLogin()){
            intent.setClass(SplashActivity.this,Welcome_Activity.class);
        }else{
            intent.setClass(SplashActivity.this,MainActivity.class);
        }
        startActivity(intent);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        imageView = ((ImageView) findViewById(R.id.splash_img));
        countMinusText = (TextView) findViewById(R.id.count_minus_text);
        burnToMain = ((Button) findViewById(R.id.burn_to_main));


        imageView.setImageResource(R.drawable.p3);
        countMinusText.setText(count + "秒，点击跳过");

        handler.sendEmptyMessage(MSG_TURN);


    }
}
