package com.nick.administrator.xiangshi.activities;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.nick.administrator.xiangshi.R;
import com.nick.administrator.xiangshi.adapter.WelcomeAdapter;
import com.viewpagerindicator.CirclePageIndicator;

import java.util.ArrayList;
import java.util.List;

/**
 * 第一次登录产生的引导页面
 * ViewPager的侧滑实现
 */
public class Welcome_Activity extends AppCompatActivity {
    private ViewPager welcomePager;
    private CirclePageIndicator indicator;
    private List<ImageView> mList;
    private WelcomeAdapter mAdapter;
    private Button burnToMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_);

        welcomePager = (ViewPager) findViewById(R.id.welcome_pager);
        indicator = (CirclePageIndicator) findViewById(R.id.cycle_indicator);
        burnToMain = ((Button) findViewById(R.id.burn_to_main));

        //初始化数据源
        mList = new ArrayList<ImageView>();
        ImageView iv1 = (ImageView) getLayoutInflater().inflate(R.layout.image,null);
        iv1.setImageResource(R.drawable.p1);
        ImageView iv2 = (ImageView) getLayoutInflater().inflate(R.layout.image,null);
        iv2.setImageResource(R.drawable.p2);
        mList.add(iv1);
        mList.add(iv2);

        burnToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(Welcome_Activity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        mAdapter = new WelcomeAdapter(mList);
        welcomePager.setAdapter(mAdapter);
        indicator.setViewPager(welcomePager);
        indicator.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                //切换到最后一页,点击按钮就可以跳转界面(可以动态添加,或者布局文件原来就存在动态显示)
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}
