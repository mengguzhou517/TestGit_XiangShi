package com.nick.administrator.xiangshi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nick.administrator.xiangshi.R;
import com.nick.administrator.xiangshi.bean.GridBean;

import java.util.List;

/**
 * Created by Administrator on 2016/7/1.
 */
public class MyGridAdapter extends BaseAdapter{
    private List<GridBean> mList;
    private LayoutInflater minflater;

    public MyGridAdapter(Context context,List<GridBean> mList){
        this.mList = mList;
        minflater = LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return mList == null?0 : mList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView==null){
            convertView = minflater.inflate(R.layout.item_gridview,null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        GridBean bean = mList.get(position);
        viewHolder.getImageView().setImageResource(bean.getResIdIcon());
        viewHolder.getTextView().setText(bean.getTextname());
        return convertView;
    }

    private class ViewHolder{
        private ImageView imageView;
        private TextView textView;
        private View root;

        public ViewHolder(View root){
            this.root = root;
        }

        public ImageView getImageView(){
            if (imageView == null && root != null){
                imageView = (ImageView) root.findViewById(R.id.image_gridView);
            }
            return imageView;
        }

        public TextView getTextView(){
            if (textView == null&& root != null){
                textView = (TextView) root.findViewById(R.id.text_gridView);
            }
            return textView;
        }
    }
}
