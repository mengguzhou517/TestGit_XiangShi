package com.nick.administrator.xiangshi.fragments;


import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nick.administrator.xiangshi.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 标题 + tab选项卡 + 侧滑容器
 * 整个用LinearLayout作为容器
 * 1.标题 (TextView)
 * 2.tab选项卡(RadioGroup)
 * 3.ViewPager
 * a.数据源List<Fragment>
 * 一样结构的Fragment,名字 RecommandGridImageFragment (接收不同的url)
 */
public class MenuFragment extends Fragment {
    //定义标题内容
    String[] titles;
    //数据源
    private List<Fragment> fragmentList;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        titles = new String[]{"美食汇","晒作品","视频","厨房宝典","摇一摇"};
        fragmentList = new ArrayList<Fragment>();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                            Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_menu,container,false);
    }

    @Override
    public void onViewCreated(View view,Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TabLayout tabLayout = ((TabLayout) view.findViewById(R.id.menu_tablayout));
        ViewPager viewPager = ((ViewPager) view.findViewById(R.id.menu_viewpager));

        for (int i = 0; i <titles.length ; i++) {
            String title = titles[i];
            TabLayout.Tab tab = tabLayout.newTab().setText(title);
            tabLayout.addTab(tab);

            tabLayout.setSelectedTabIndicatorColor(Color.BLUE);
            tabLayout.setSelectedTabIndicatorHeight(4);
        }

        //动态添加碎片
        for (int i = 0; i <titles.length ; i++) {

        }
    }
}
