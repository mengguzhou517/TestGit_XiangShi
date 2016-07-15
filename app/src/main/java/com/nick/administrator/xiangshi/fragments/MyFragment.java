package com.nick.administrator.xiangshi.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import com.nick.administrator.xiangshi.R;
import com.nick.administrator.xiangshi.activities.LoginActivity;
import com.nick.administrator.xiangshi.activities.RegisterActivity;
import com.nick.administrator.xiangshi.adapter.MyGridAdapter;
import com.nick.administrator.xiangshi.bean.GridBean;
import com.pkmmte.view.CircularImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyFragment extends Fragment {
    private GridView gridView;
    private List<GridBean> mList;
    String[] names;
    int[] pics;
    private Button myLoginButton;
    private Button mySignButton;
    private CircularImageView imageIcon;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    public MyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        gridView = (GridView) view.findViewById(R.id.gridView_myFragment);
        myLoginButton = ((Button) view.findViewById(R.id.my_login_button));
        mySignButton = ((Button) view.findViewById(R.id.my_sign_button));
        imageIcon = ((CircularImageView) view.findViewById(R.id.image_icon));

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getActivity(),LoginActivity.class);
                startActivity(intent);
            }
        };
        imageIcon.setOnClickListener(listener);
        myLoginButton.setOnClickListener(listener);

        mySignButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getActivity(), RegisterActivity.class);
                startActivity(intent);
            }
        });

        initData();

        MyGridAdapter adapter = new MyGridAdapter(getActivity(),mList);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getActivity(),"生当做人杰",Toast.LENGTH_SHORT).show();

            }
        });
    }

    public void initData(){
        names = new String[]{"我的发布","站内信","我的收藏",
                "草稿箱","买菜清单","我的订单","离线包","系统设置",};
        pics = new int[]{
                R.drawable.myspace_pub,
                R.drawable.myspace_message,
                R.drawable.myspace_collections,
                R.drawable.myspace_cgx,
                R.drawable.myspace_mcqd,
                R.drawable.myspace_orders,
                R.drawable.myspace_lxb,
                R.drawable.myspace_settings,};
        mList = new ArrayList<GridBean>();
        for (int i = 0; i <names.length ; i++) {
            GridBean bean = new GridBean();
            String name = names[i];
            int pic = pics[i];
            bean.setTextname(name);
            bean.setResIdIcon(pic);
            mList.add(bean);
        }
    }
}
