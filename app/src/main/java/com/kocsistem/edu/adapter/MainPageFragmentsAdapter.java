package com.kocsistem.edu.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.kocsistem.edu.view.fragments.FragmentA;
import com.kocsistem.edu.view.fragments.FragmentB;
import com.kocsistem.edu.view.fragments.FragmentC;
import com.kocsistem.edu.view.fragments.MainFragment;

/**
 * Created by umutboz on 09,May,2018
 */
public class MainPageFragmentsAdapter extends FragmentStatePagerAdapter {
    public MainPageFragmentsAdapter(FragmentManager fm) {
        super(fm);
    }
    MainFragment fragment = null;
    @Override
    public Fragment getItem(int position) {

        switch (position)
        {
            case  0:
            {
                fragment = new FragmentA();
                break;
            }
            case  1:
            {
                fragment = new FragmentB();
                break;
            }
            case  2:
            {
                fragment = new FragmentC();
                break;
            }
            default:
                fragment = new FragmentA();
                break;
        }
        return fragment;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0: {
                return "ONE";
            }
            case 1: {
                return "TWO";
            }
            case 2: {
                return "THREE";
            }
            default:
                return "";
        }
    }



    @Override
    public int getCount() {
        return 3;
    }
}
