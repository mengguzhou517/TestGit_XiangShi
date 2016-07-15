package com.nick.administrator.xiangshi.activities;

import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.nick.administrator.xiangshi.R;
import com.nick.administrator.xiangshi.fragments.ListFragment;
import com.nick.administrator.xiangshi.fragments.MarketFragment;
import com.nick.administrator.xiangshi.fragments.ProductFragment;

import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends AppCompatActivity {

    private ImageView imageBackSearch;
    private EditText editTextSearch;
    private TabLayout searchTabs;
    private List<Fragment> fragmentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        imageBackSearch = ((ImageView) findViewById(R.id.image_back_search));
        editTextSearch = ((EditText) findViewById(R.id.editText_search));
        searchTabs = ((TabLayout) findViewById(R.id.search_tabs));

        imageBackSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        TabLayout.Tab tabProduct = searchTabs.newTab().setText("单品");
        TabLayout.Tab tabList = searchTabs.newTab().setText("清单");
        searchTabs.addTab(tabProduct);
        searchTabs.addTab(tabList);
        //设置选中和没选中的颜色
        searchTabs.setTabTextColors(Color.GRAY,Color.BLACK);
        //设置高度为0
        searchTabs.setSelectedTabIndicatorHeight(0);
        //监听
        searchTabs.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                //获取Tab选项卡的下标
                showFragmentByIndex(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        initFragments();
    }

    public void initFragments(){
        fragmentList = new ArrayList<Fragment>();
        fragmentList.add(new ProductFragment());
        fragmentList.add(new ListFragment());
        showFragmentByIndex(0);
    }

    public void showFragmentByIndex(int index){
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        for (int i = 0; i <fragmentList.size() ; i++) {
            Fragment f = fragmentList.get(i);
            if (!f.isAdded()){
                ft.add(R.id.search_fragment_container,f);
            }
            if (i == index){
                ft.show(f);
            }else{
                ft.hide(f);
            }
        }
        ft.commit();
    }
}
