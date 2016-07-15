package com.nick.administrator.xiangshi.fragments;


import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.nick.administrator.xiangshi.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeRangeFragment extends Fragment {


    private TabLayout homeTablayout;
    private List<Fragment> fragmentList;
    private ViewPager homeViewPager;
    private Button btnHomeSearch;
    private Button btnRightImage01;
    private Button btnRightImage02;


    public HomeRangeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home_range, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        homeTablayout = ((TabLayout) view.findViewById(R.id.home_tablayout));
        homeViewPager = ((ViewPager) view.findViewById(R.id.home_viewpager));
        btnHomeSearch = ((Button) view.findViewById(R.id.btn_home_search));
        btnRightImage01 = ((Button) view.findViewById(R.id.btn_right_home));
        btnRightImage02 = ((Button) view.findViewById(R.id.btn_right_home01));
        initFragment();

        TabLayout.Tab tabTopic = homeTablayout.newTab().setIcon(R.drawable.home_topic_selector).setText("话题");
        TabLayout.Tab tabFriend = homeTablayout.newTab().setIcon(R.drawable.friend_home_selector).setText("食友");
        TabLayout.Tab tabDynamic = homeTablayout.newTab().setIcon(R.drawable.dynamic_home_selector).setText("动态");
        homeTablayout.addTab(tabTopic);
        homeTablayout.addTab(tabFriend);
        homeTablayout.addTab(tabDynamic);

        homeTablayout.setTabTextColors(Color.BLACK,Color.YELLOW);
        homeTablayout.setSelectedTabIndicatorHeight(0);
        homeTablayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override //没选中到选中状态
            public void onTabSelected(TabLayout.Tab tab) {
               showFragmentByIndex(tab.getPosition());
                if (tab.getPosition() == 0){
                    btnHomeSearch.setHint("搜话题");
                    btnRightImage01.setBackgroundDrawable(new BitmapDrawable());
                    btnRightImage02.setBackgroundResource(R.drawable.btn_header_edit);
                }
                if (tab.getPosition() == 1){
                    btnHomeSearch.setHint("搜豆友");
                    btnRightImage01.setBackgroundResource(R.drawable.btn_auxiliary_add);
                    btnRightImage02.setBackgroundResource(R.drawable.btn_auxiliary_filter);
                }
                if (tab.getPosition() == 2){
                    btnHomeSearch.setHint("搜Topic");
                    btnRightImage01.setBackgroundDrawable(new BitmapDrawable());
                    btnRightImage02.setBackgroundResource(R.drawable.btn_header_photo);
                }
            }

            @Override//选中到没选中状态
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override//选中和上次一样的选项卡
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    public void initFragment(){
        fragmentList = new ArrayList<Fragment>();
        fragmentList.add(new TopicFragment());
        fragmentList.add(new FrientFragment());
        fragmentList.add(new DynamicFragment());
        showFragmentByIndex(0);
    }

    public void showFragmentByIndex(int index){
        FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
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
