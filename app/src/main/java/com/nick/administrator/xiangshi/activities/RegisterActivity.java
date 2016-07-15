package com.nick.administrator.xiangshi.activities;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.nick.administrator.xiangshi.R;

public class RegisterActivity extends AppCompatActivity {

    private TextView selectorRegister;
    private ImageView imageBackRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register2);

        selectorRegister = ((TextView) findViewById(R.id.selector_register));
        imageBackRegister = ((ImageView) findViewById(R.id.image_back_register));

        SpannableStringBuilder builder = new SpannableStringBuilder(selectorRegister.getText().toString());

        ForegroundColorSpan graySpan = new ForegroundColorSpan(Color.GRAY);
        ForegroundColorSpan blackSpan = new ForegroundColorSpan(Color.BLACK);

        builder.setSpan(graySpan,0,2, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        builder.setSpan(blackSpan,2,10,Spanned.SPAN_EXCLUSIVE_INCLUSIVE);

        selectorRegister.setText(builder);

        imageBackRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
