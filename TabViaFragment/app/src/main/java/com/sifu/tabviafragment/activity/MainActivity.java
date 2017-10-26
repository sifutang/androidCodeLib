package com.sifu.tabviafragment.activity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.sifu.tabviafragment.R;
import com.sifu.tabviafragment.fragments.HomeFragment;
import com.sifu.tabviafragment.fragments.PersonCenterFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageButton mHomeBtn;
    private ImageButton mPersonCenterBtn;

    private HomeFragment mHomeFragment;
    private PersonCenterFragment mPersonCenterFragment;

    private TextView mTitleTextView;

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
        mHomeBtn = (ImageButton) findViewById(R.id.id_tab_home_img);
        mPersonCenterBtn = (ImageButton)findViewById(R.id.id_tab_setting_img);

        mTitleTextView = (TextView) findViewById(R.id.tv_title);
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

    private void hideFragment(FragmentTransaction fragmentTransaction) {
        if (mHomeFragment != null) {
            fragmentTransaction.hide(mHomeFragment);
        }

        if (mPersonCenterFragment != null) {
            fragmentTransaction.hide(mPersonCenterFragment);
        }
    }

    private void resetImage() {
        mHomeBtn.setImageResource(R.drawable.tab_weixin_normal);
        mPersonCenterBtn.setImageResource(R.drawable.tab_settings_normal);
    }

    private void setSelect(int select) {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();

        resetImage();
        hideFragment(fragmentTransaction);
        switch (select) {
            case 0:
                mTitleTextView.setText("首页");
                if (mHomeFragment == null) {
                    mHomeFragment = new HomeFragment();
                    fragmentTransaction.add(R.id.id_content, mHomeFragment);
                } else {
                    fragmentTransaction.show(mHomeFragment);
                }
                fragmentTransaction.commit();
                mHomeBtn.setImageResource(R.drawable.tab_weixin_pressed);
                break;
            case 1:
                mTitleTextView.setText("个人中心");
                if (mPersonCenterFragment == null) {
                    mPersonCenterFragment = new PersonCenterFragment();
                    fragmentTransaction.add(R.id.id_content, mPersonCenterFragment);
                } else {
                    fragmentTransaction.show(mPersonCenterFragment);
                }
                fragmentTransaction.commit();
                mPersonCenterBtn.setImageResource(R.drawable.tab_settings_pressed);
                break;
        }
    }
}
