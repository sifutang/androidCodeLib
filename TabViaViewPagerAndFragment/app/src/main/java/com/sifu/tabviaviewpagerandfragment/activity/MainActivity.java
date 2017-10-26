package com.sifu.tabviaviewpagerandfragment.activity;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.sifu.tabviaviewpagerandfragment.R;
import com.sifu.tabviaviewpagerandfragment.fragment.HomeFragment;
import com.sifu.tabviaviewpagerandfragment.fragment.PersonCenterFragment;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewPager mViewPager;
    private FragmentPagerAdapter mAdapter;
    private ImageButton mHomeBtn;
    private ImageButton mPersonCenterBtn;
    private TextView mTitleTextView;

    private HomeFragment mHomeFragment;
    private PersonCenterFragment mPersonCenterFragment;

    private List<Fragment> fragmentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initEvent();
        setSelect(0);
    }

    private void initEvent() {
        mHomeBtn.setOnClickListener(this);
        mPersonCenterBtn.setOnClickListener(this);
    }

    private void initView() {
        mViewPager = (ViewPager) findViewById(R.id.view_pager);
        mHomeBtn = (ImageButton) findViewById(R.id.id_tab_home_img);
        mPersonCenterBtn = (ImageButton)findViewById(R.id.id_tab_setting_img);
        mTitleTextView = (TextView) findViewById(R.id.tv_title);

        mHomeFragment = new HomeFragment();
        mPersonCenterFragment = new PersonCenterFragment();

        fragmentList = new ArrayList<>();
        fragmentList.add(mHomeFragment);
        fragmentList.add(mPersonCenterFragment);

        mAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public android.support.v4.app.Fragment getItem(int position) {
                return fragmentList.get(position);
            }

            @Override
            public int getCount() {
                return fragmentList.size();
            }
        };

        mViewPager.setAdapter(mAdapter);
        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                resetImage();
                switch (position) {
                    case 0:
                        mHomeBtn.setImageResource(R.drawable.tab_weixin_pressed);
                        mViewPager.setCurrentItem(0);
                        break;
                    case 1:
                        mPersonCenterBtn.setImageResource(R.drawable.tab_settings_pressed);
                        mViewPager.setCurrentItem(1);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.id_tab_home_img:
                setSelect(0);
                break;
            case R.id.id_tab_setting_img:
                setSelect(1);
                break;
        }
    }

    private void resetImage() {
        mHomeBtn.setImageResource(R.drawable.tab_weixin_normal);
        mPersonCenterBtn.setImageResource(R.drawable.tab_settings_normal);
    }

    private void setSelect(int select) {
        switch (select) {
            case 0:
                mHomeBtn.setImageResource(R.drawable.tab_weixin_pressed);
                mViewPager.setCurrentItem(0);
                break;
            case 1:
                mPersonCenterBtn.setImageResource(R.drawable.tab_settings_pressed);
                mViewPager.setCurrentItem(1);
                break;
        }
    }
}
