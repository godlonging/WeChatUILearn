package com.apps.animaljie.wechatui;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.Menu;
import android.view.ViewGroup;

import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jauker.widget.BadgeView;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity {

    private ViewPager viewPager;
    private FragmentPagerAdapter fragmentPagerAdapter;
    private List<Fragment> datas;

    private TextView chat;
    private TextView contact;
    private TextView moments;

    private BadgeView badgeView;
    private LinearLayout linearLayout;

    private int screen;
    private ImageView imageView;

    private int currentPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initlines();
        initfragment();
        initview();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    private void initlines() {
        imageView=(ImageView)findViewById(R.id.lines);
        //获取屏幕信息
        Display display= getWindow().getWindowManager().getDefaultDisplay();
        DisplayMetrics metrics=new DisplayMetrics();
        display.getMetrics(metrics);
        screen=metrics.widthPixels/3;
        ViewGroup.LayoutParams layoutParams =imageView.getLayoutParams();
        layoutParams.width=screen;
        imageView.setLayoutParams(layoutParams);
    }

    private void initfragment(){
        viewPager=(ViewPager)findViewById(R.id.viewpager);
        datas=new ArrayList<Fragment>();
        Chatfragment tab1=new Chatfragment();
        Contactsfragment tab2=new Contactsfragment();
        Momentsfragment tab3=new Momentsfragment();
        datas.add(tab1);
        datas.add(tab2);
        datas.add(tab3);
        fragmentPagerAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return datas.get(position);
            }

            @Override
            public int getCount() {
                return datas.size();
            }
        };
        viewPager.setAdapter(fragmentPagerAdapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                //通过imageview的margin参数改变图片的位置
                //利用当前位置加上滑动偏移位置模拟手指跟随效果
                LinearLayout.LayoutParams layoutParams= (LinearLayout.LayoutParams) imageView.getLayoutParams();
                if(currentPage==0&&position==0){
                    layoutParams.leftMargin= (int) (positionOffset*screen+currentPage*screen);

                }else if(currentPage==1&&position==0){
                    layoutParams.leftMargin=(int)(currentPage*screen+(positionOffset-1)*screen);
                }else if(currentPage==1&&position==1){
                    layoutParams.leftMargin= (int) (positionOffset*screen+currentPage*screen);

                }else if(currentPage==2&&position==1){
                    layoutParams.leftMargin=(int)(currentPage*screen+(positionOffset-1)*screen);
                }

                imageView.setLayoutParams(layoutParams);


            }

            @Override
            public void onPageSelected(int position) {
                resetTextview();
                switch (position){
                    case 0:
                        if(badgeView!=null){
                            linearLayout.removeView(badgeView);
                        }
                        badgeView=new BadgeView(MainActivity.this);
                        badgeView.setBadgeCount(8);
                        linearLayout.addView(badgeView);
                        chat.setTextColor(Color.parseColor("#008000"));break;
                    case 1:contact.setTextColor(Color.parseColor("#008000"));break;
                    case 2:moments.setTextColor(Color.parseColor("#008000"));break;

                }
                currentPage=position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }
    private  void initview(){
        viewPager=(ViewPager)findViewById(R.id.viewpager);
        chat=(TextView)findViewById(R.id.chats);
        contact=(TextView)findViewById(R.id.contacts);
        moments=(TextView)findViewById(R.id.moment);
        linearLayout=(LinearLayout) findViewById(R.id.ll);
    }

    @Override
    public boolean onMenuOpened(int featureId, Menu menu) {
       if (featureId== Window.FEATURE_ACTION_BAR&&menu!=null){
           if (menu.getClass().getSimpleName().equals("MenuBuilder")){
               try {
                   Method method=menu.getClass().getDeclaredMethod("setOptionalIconsVisble",Boolean.TYPE);
                   method.setAccessible(true);
                   method.invoke(menu,true);
               }catch (Exception e){
                    System.out.println("fail");
               }
           }
       }
        return super.onMenuOpened(featureId, menu);
    }

    protected void  resetTextview(){
        initview();
        chat.setTextColor(Color.BLACK);
        contact.setTextColor(Color.BLACK);
        moments.setTextColor(Color.BLACK);
    }
}
