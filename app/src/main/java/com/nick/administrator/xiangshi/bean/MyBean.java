package com.nick.administrator.xiangshi.bean;

import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/6/30.
 */
public class MyBean {
    private int resIdIcon;
    private String TextName;

    public int getResIdIcon() {
        return resIdIcon;
    }

    public void setResIdIcon(int resIdIcon) {
        this.resIdIcon = resIdIcon;
    }

    public String getTextName() {
        return TextName;
    }

    public void setTextName(String textName) {
        TextName = textName;
    }

    @Override
    public String toString() {
        return "MyBean{" +
                "resIdIcon=" + resIdIcon +
                ", TextName='" + TextName + '\'' +
                '}';
    }
}
