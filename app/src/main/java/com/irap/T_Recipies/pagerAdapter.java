package com.irap.T_Recipies;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class pagerAdapter extends FragmentPagerAdapter {
    private int tabNumber;
    public pagerAdapter(@NonNull FragmentManager fm, int behavior,int tabs) {


        super(fm, behavior);
        this.tabNumber=tabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0:
            return new frag_1();
            case 1:
            return new frag_2();
            case 2:
            return new frag_3();
        }
        return null;
    }

    @Override
    public int getCount() {
        return tabNumber;
    }
}
