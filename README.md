# BottomTab
底部导航

            <com.gyr.widget.BottomTab
        android:background="#999"
        android:orientation="horizontal"
        android:id="@+id/bottomTab"
        android:layout_width="match_parent"
        android:layout_height="40dp"/>



        BottomTab bottomTab = (BottomTab) findViewById(R.id.bottomTab);
        String[] texts = {"首页", "项目列表", "搜索", "用户中心"};
        int[] drawables = {R.drawable.bottom_home, R.drawable.bottom_news, R.drawable.bottom_repository, R.drawable.bottom_user};
        bottomTab.createTabItem(texts, drawables, R.layout.bottom_tab_item, 0)
                .setOnItemClickListener(new BottomTab.OnItemClickListener() {
                    @Override
                    public void onClick(View v, int itemPosition) {
                        Toast.makeText(MainActivity.this, itemPosition + "", Toast.LENGTH_SHORT).show();
                    }
                });
                
                
         
         
XML  R.layout.bottom_tab_item

<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="0dp"
    android:layout_weight="1"
    android:layout_height="wrap_content"
    android:gravity="center"
    android:orientation="vertical">

    <ImageView
        android:background="@drawable/home"
        android:layout_width="20dp"
        android:layout_height="20dp"
        android:scaleType="centerInside" />

    <TextView
        android:text="测试"
        android:textColor="@color/bottom_tab_textview"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginTop="2dp"
        android:textSize="12sp" />
</LinearLayout>
