package edu.temple.temple;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;


public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    ArrayList<Fragment> fragments;

    public ViewPagerAdapter(FragmentManager fragmentManager, ArrayList<Fragment> fragmentArrayList) {
        super(fragmentManager);
        fragments = fragmentArrayList;
    }

    @Override
    public Fragment getItem(int i) {
        return fragments.get(i);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}