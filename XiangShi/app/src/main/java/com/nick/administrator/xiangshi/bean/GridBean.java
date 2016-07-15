package com.nick.administrator.xiangshi.bean;

/**
 * Created by Administrator on 2016/7/1.
 */
public class GridBean {
    private String textname;
    private int resIdIcon;

    public String getTextname() {
        return textname;
    }

    public void setTextname(String textname) {
        this.textname = textname;
    }

    public int getResIdIcon() {
        return resIdIcon;
    }

    public void setResIdIcon(int resIdIcon) {
        this.resIdIcon = resIdIcon;
    }

    @Override
    public String toString() {
        return "GridBean{" + "textname='" + textname + '\'' + ", resIdIcon=" + resIdIcon + '}';
    }
}
