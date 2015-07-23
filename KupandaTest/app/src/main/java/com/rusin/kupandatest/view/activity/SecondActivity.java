package com.rusin.kupandatest.view.activity;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;

import com.rusin.kupandatest.KuApp;
import com.rusin.kupandatest.R;
import com.rusin.kupandatest.model.ItemsModel;
import com.rusin.kupandatest.view.fragment.PageFragment;

public class SecondActivity extends BaseActivity{
    public static final String POSITION = "position";
    private ViewPager pager;
    private PagerAdapter pagerAdapter;
    private ItemsModel mModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        int position = getIntent().getIntExtra(POSITION, 0);
        mModel = KuApp.getManagerModel().getItemsModel();
        pager = (ViewPager) findViewById(R.id.pager);
        pagerAdapter = new KuFragmentPagerAdapter(getSupportFragmentManager());
        pager.setAdapter(pagerAdapter);
        pager.setCurrentItem(position);
    }

    private class KuFragmentPagerAdapter extends FragmentPagerAdapter {

        public KuFragmentPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            PageFragment fragment = PageFragment.newInstance(position);
            fragment.setContent(mModel.getItem(position));
            return fragment;
        }

        @Override
        public int getCount() {
            return 20; // mModel.size();
        }

    }

}


