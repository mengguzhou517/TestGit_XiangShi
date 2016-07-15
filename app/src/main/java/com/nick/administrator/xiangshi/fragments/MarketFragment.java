package com.nick.administrator.xiangshi.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.nick.administrator.xiangshi.R;
import com.nick.administrator.xiangshi.activities.SearchActivity;
import com.nick.administrator.xiangshi.adapter.WelcomeAdapter;
import com.viewpagerindicator.CirclePageIndicator;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class MarketFragment extends Fragment {
    private ViewPager viewPager;
    private List<View> data;

    public static final int  MSG_TURN = 0x11;
    public static final int  MSG_TURN_STOP = 0x12;
    public static final int  MSG_BACK_RESET = 0x99;
    public static final long DURATION_TURN = 2000;

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(android.os.Message msg) {
            switch (msg.what){
                case MSG_TURN://开始轮询消息
                    int pager = viewPager.getCurrentItem();
                    pager++;
                    viewPager.setCurrentItem(pager);
                    handler.sendEmptyMessageDelayed(MSG_TURN, DURATION_TURN);
                    break;
                case MSG_TURN_STOP://停止轮循消息
                    handler.removeMessages(MSG_TURN);//移除轮训的消息
                    break;
                default:
                    break;
            }
        }
    };
    private Button buttonSearch;


    public MarketFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_market, container, false);
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //搜索按钮找控件
        buttonSearch = ((Button) view.findViewById(R.id.button_search));
        buttonSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getActivity(), SearchActivity.class);
                startActivity(intent);
            }
        });

        viewPager = (ViewPager) view.findViewById(R.id.market_pager);
        initData();
        viewPager.setAdapter(new MyPagerAdapter());
        handler.sendEmptyMessageDelayed(MSG_TURN , DURATION_TURN);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {
                switch (state){
                    case ViewPager.SCROLL_STATE_IDLE:
                        if(!handler.hasMessages(MSG_TURN)){
                            handler.sendEmptyMessageDelayed(MSG_TURN, DURATION_TURN);
                        }
                        break;
                    case ViewPager.SCROLL_STATE_DRAGGING:
                        handler.sendEmptyMessage(MSG_TURN_STOP);
                        break;
                    case ViewPager.SCROLL_STATE_SETTLING:
                        break;
                    default:
                        break;
                }
            }
        });

        viewPager.setCurrentItem(Integer.MAX_VALUE/2);
    }

    public void initData(){
        int[] resIds = new int[]{
                R.drawable.caipin1,
                R.drawable.caipin2,
                R.drawable.haizei01,
                R.drawable.haizei02

        };
        data = new ArrayList<View>();
        for (int i = 0; i <resIds.length ; i++) {
            //动态的话就不依赖于layout.xml的文件了
            ImageView imageView = new ImageView(getActivity());
            //宽度高度
              imageView.setLayoutParams(new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, FrameLayout.LayoutParams.WRAP_CONTENT));
            //图片源
            imageView.setImageResource(resIds[i]);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);//拉伸会失真的
            data.add(imageView);
        }
    }

    private class MyPagerAdapter extends PagerAdapter{
        //数据源大小
        @Override
        public int getCount() {
            return Integer.MAX_VALUE;
        }

        //写法固定的，实际的对象View就是最后需要显示的View
        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        /**
         * 视图对象动态绘制 (目的是节省内存的开销,
         * 一般情况加载的图片资源是比较耗内存的) 返回的是Object数据源的对象
         */
        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            int index = position % data.size();
            View view = data.get(index);
            container.addView(view);
            return view;
        }

        /**
         * 视图对象动态删除
         */
        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            int index = position % data.size();
            View view = data.get(index);
            container.removeView(view);
        }
    }
}
