package com.martin.mvc.legaltalk;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.martin.mvc.legaltalk.R;
import com.martin.mvc.fragment.LawHallFragment;
import com.martin.mvc.fragment.MeFragment;
import com.martin.mvc.fragment.NewsFragment;
import com.martin.mvc.fragment.SearchLawyerFragment;
import com.martin.mvc.base_util.BaseActivity;
import com.martin.mvc.adapter.MainFragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainPageActivity extends BaseActivity implements View.OnClickListener {

    private FrameLayout main_foot_bar1, main_foot_bar2, main_foot_bar3, main_foot_bar4;
    private TextView text1, text11, text2, text22, text3, text33, text4, text44;
    private MainFragmentPagerAdapter adapter;
    private List<TextView> mTable, mTable0;
    private ViewPager viewPager;
    private List<Fragment> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        //初始化
        initView();
        initData();

        adapter = new MainFragmentPagerAdapter(getSupportFragmentManager(), list);
        viewPager.setAdapter(adapter);

        viewPager.setOffscreenPageLimit(3);//设置默认加载3个fragment页面

        ViewPagerChange();//滑动viewpager更新UI

        doClick();//点击
    }

    private void doClick() {
        main_foot_bar1.setOnClickListener(this);
        main_foot_bar2.setOnClickListener(this);
        main_foot_bar3.setOnClickListener(this);
        main_foot_bar4.setOnClickListener(this);

    }

    private void initData() {
        list = new ArrayList<>();
        mTable = new ArrayList<>();
        mTable0 = new ArrayList<>();

        list.add(new LawHallFragment());
        list.add(new SearchLawyerFragment());
        list.add(new NewsFragment());
        list.add(new MeFragment());

        mTable.add(text1);
        mTable.add(text2);
        mTable.add(text3);
        mTable.add(text4);
        mTable0.add(text11);
        mTable0.add(text22);
        mTable0.add(text33);
        mTable0.add(text44);
    }

    private void initView() {
        viewPager = findViewById(R.id.main_viewpager);

        text1 = findViewById(R.id.main_foot_text1);
        text11 = findViewById(R.id.main_foot_text11);
        text2 = findViewById(R.id.main_foot_text2);
        text22 = findViewById(R.id.main_foot_text22);
        text3 = findViewById(R.id.main_foot_text3);
        text33 = findViewById(R.id.main_foot_text33);
        text4 = findViewById(R.id.main_foot_text4);
        text44 = findViewById(R.id.main_foot_text44);

        main_foot_bar1 = findViewById(R.id.main_foot_bar1);
        main_foot_bar2 = findViewById(R.id.main_foot_bar2);
        main_foot_bar3 = findViewById(R.id.main_foot_bar3);
        main_foot_bar4 = findViewById(R.id.main_foot_bar4);

    }

    @Override
    public void onClick(View view) {

        //还原底部导航栏
        for (int i = 0; i < mTable0.size(); i++) {
            mTable0.get(i).setAlpha(0);
            mTable.get(i).setAlpha(1);
        }

        switch (view.getId()) {
            //点击底部导航栏改变viewpager
            case R.id.main_foot_bar1:
                viewPager.setCurrentItem(0, false);
                text1.setAlpha(0);
                text11.setAlpha(1);
                break;
            case R.id.main_foot_bar2:
                viewPager.setCurrentItem(1, false);
                text2.setAlpha(0);
                text22.setAlpha(1);
                break;
            case R.id.main_foot_bar3:
                viewPager.setCurrentItem(2, false);
                text3.setAlpha(0);
                text33.setAlpha(1);
                break;
            case R.id.main_foot_bar4:
                viewPager.setCurrentItem(3, false);
                text4.setAlpha(0);
                text44.setAlpha(1);
                break;
        }
    }

    //滑动viewpager时，更新视图
    private void ViewPagerChange() {
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if (positionOffset > 0) {

                    //渐变色设置
                    TextView left1 = mTable.get(position);
                    TextView left2 = mTable0.get(position);
                    TextView right1 = mTable.get(position + 1);
                    TextView right2 = mTable0.get(position + 1);
                    left1.setAlpha(positionOffset);
                    left2.setAlpha(1 - positionOffset);
                    right1.setAlpha(1 - positionOffset);
                    right2.setAlpha(positionOffset);
                }
            }

            @Override
            public void onPageSelected(int position) {
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }
}
