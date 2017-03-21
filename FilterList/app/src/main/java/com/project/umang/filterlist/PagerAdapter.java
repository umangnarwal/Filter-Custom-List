package com.project.umang.filterlist;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by UMANG on 11/9/2016.
 */
public class PagerAdapter extends FragmentPagerAdapter {
    public PagerAdapter(FragmentManager fm)
    {
        super(fm);
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new fragment();
            case 1:
                return new fragmentTwo();
            default:
                break;
        }
        return  null;

    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch(position)
        {
            case 0:
                return "FIRST LIST";
            case 1:
                return "SECOND LIST";
            default:
                return "NOTHING";
        }

    }

}
