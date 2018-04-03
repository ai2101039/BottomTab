package com.gyr.widget;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * @author 高延荣
 * @date 2018/4/3 15:28
 * 描述:  底部导航
 */

public class BottomTab extends LinearLayout {
    private Context context;
    private ViewGroup selectItem;

    public BottomTab(Context context) {
        super(context);
        this.context = context;
    }

    public BottomTab(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
    }

    /**
     * 创建TabItem
     *
     * @param texts                    tabItem文字，如 {"首页","新闻页","用户中心"}
     * @param drawables                tabItem背景图片，可进行 select 变化
     * @param layoutResID              tabItem资源ID
     * @param normalSelectItemPosition 默认选择Item
     * @return 返回 this
     */
    public BottomTab createTabItem(String[] texts, int[] drawables, @LayoutRes int layoutResID, int normalSelectItemPosition) {
        int length = texts.length;
        for (int i = 0; i < length; i++) {
            ViewGroup tabItem = (ViewGroup) inflate(context, layoutResID, this);

            ImageView imageView = (ImageView) tabItem.getChildAt(0);
            TextView textView = (TextView) tabItem.getChildAt(1);

            imageView.setBackgroundResource(drawables[i]);
            textView.setText(texts[i]);
            imageView.setClickable(false);
            textView.setClickable(false);

            tabItem.setTag(i);

            if (normalSelectItemPosition == i) {
                selectItem = tabItem;
                selectItem.setSelected(true);
            }
        }

        return this;
    }

    //////////////////////////////////////////////////////////////////////////////
    public interface OnItemClickListener {
        void onClick(View v, int itemPosition);
    }

    private OnItemClickListener onItemClickListener;

    public BottomTab setOnItemClickListener(final OnItemClickListener onItemClickListener) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            getChildAt(i).setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = (int) v.getTag();
                    if (selectItem != null) {
                        selectItem.setSelected(false);
                    }
                    selectItem = (ViewGroup) v;
                    selectItem.setSelected(true);

                    onItemClickListener.onClick(v, position);
                }
            });
        }
        return this;
    }

}
