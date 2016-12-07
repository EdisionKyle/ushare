package com.miles.ushare;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements BottomNavigationBar.OnTabSelectedListener {
    private HomeFragment homeFragment;
    private BookFragment bookFragment;
    private MusicFragment musicFragment;
    private TvFragment tvFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationBar bottomNavigationBar = (BottomNavigationBar) findViewById(R.id.bottom_navigation_bar);
        bottomNavigationBar.setMode(BottomNavigationBar.MODE_FIXED);
        bottomNavigationBar
                .setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC
                );
        bottomNavigationBar.addItem(new BottomNavigationItem(R.mipmap.ic_home_white_24dp, "首页").setActiveColorResource(R.color.orange))
                .addItem(new BottomNavigationItem(R.mipmap.ic_book_white_24dp, "视频").setActiveColorResource(R.color.orange))
                .addItem(new BottomNavigationItem(R.mipmap.ic_music_note_white_24dp, "关注").setActiveColorResource(R.color.orange))
                .addItem(new BottomNavigationItem(R.mipmap.ic_tv_white_24dp, "我的").setActiveColorResource(R.color.orange))
                .setFirstSelectedPosition(0)
                .initialise();
        setDefaultFragment();
        bottomNavigationBar.setTabSelectedListener(this);
    }

    /**
     * 设置默认的
     */
    private void setDefaultFragment() {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        homeFragment = HomeFragment.newInstance();
        transaction.replace(R.id.layFrame, homeFragment);
        transaction.commit();
    }

    @Override
    public void onTabSelected(int position) {
        FragmentManager fm = getSupportFragmentManager();
        //开启事务
        FragmentTransaction transaction = fm.beginTransaction();
        switch (position) {
            case 0:
                if (homeFragment == null) {
                    homeFragment = HomeFragment.newInstance();
                }
                transaction.replace(R.id.layFrame, homeFragment);
                break;
            case 1:
                if (bookFragment == null) {
                    bookFragment = BookFragment.newInstance("Books视频");
                }
                transaction.replace(R.id.layFrame, bookFragment);
                break;
            case 2:
                if (musicFragment == null) {
                    musicFragment = MusicFragment.newInstance("Music关注");
                }
                transaction.replace(R.id.layFrame, musicFragment);
                break;
            case 3:
                if (tvFragment == null) {
                    tvFragment = TvFragment.newInstance("Movies & TV我的");
                }
                transaction.replace(R.id.layFrame, tvFragment);
                break;
            default:
                break;
        }
        // 事务提交
        transaction.commitAllowingStateLoss();
    }

    @Override
    public void onTabUnselected(int position) {
    }

    @Override
    public void onTabReselected(int position) {

    }
}
