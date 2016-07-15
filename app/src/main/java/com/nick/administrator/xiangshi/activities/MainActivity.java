package com.nick.administrator.xiangshi.activities;

import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.nick.administrator.xiangshi.R;
import com.nick.administrator.xiangshi.fragments.HomeRangeFragment;
import com.nick.administrator.xiangshi.fragments.MarketFragment;
import com.nick.administrator.xiangshi.fragments.MenuFragment;
import com.nick.administrator.xiangshi.fragments.MyFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private List<Fragment> fragmentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = ((TabLayout) findViewById(R.id.main_tabs));

        //设置图片（该图片是有选择器功能的图片）
        //可以使用自定义的
        //菜单（Menu）    商城（Market）  生活圈（HomeRange） 我的(My)
    TabLayout.Tab tabMenu = tabLayout.newTab().setIcon(R.drawable.bottom_menu_selector).setText("菜谱");
    TabLayout.Tab tabMarket = tabLayout.newTab().setIcon(R.drawable.bottom_market_selector).setText("商场");
    TabLayout.Tab tabLife = tabLayout.newTab().setIcon(R.drawable.bottom_homerange_selector).setText("生活圈");
    TabLayout.Tab tabMy = tabLayout.newTab().setIcon(R.drawable.botton_my_selector).setText("我的");
    tabLayout.addTab(tabMenu);
    tabLayout.addTab(tabMarket);
    tabLayout.addTab(tabLife);
    tabLayout.addTab(tabMy);
        //设置选中和没选中的颜色
        tabLayout.setTabTextColors(Color.GRAY,Color.GREEN);
        //设置高度为0
        tabLayout.setSelectedTabIndicatorHeight(0);
        //监听
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
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
        initFragment();
    }

    public void initFragment(){
        fragmentList = new ArrayList<Fragment>();
        fragmentList.add(new MenuFragment());
        fragmentList.add(new MarketFragment());
        fragmentList.add(new HomeRangeFragment());
        fragmentList.add(new MyFragment());
        showFragmentByIndex(0);
    }

    public void showFragmentByIndex(int index){
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        for (int i = 0; i <fragmentList.size() ; i++) {
            Fragment f = fragmentList.get(i);
            if (!f.isAdded()){
                ft.add(R.id.main_fragment_container,f);
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
