package com.android.gatofalante.armario.adapters;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;

import com.android.gatofalante.armario.utilities.SelectionFragment;

/**
 * Created by gatofalante on 1/16/18.
 */

public class PagerAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public PagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                Log.i("PAGER", "Tops and 0");
                Bundle tops = new Bundle();
                tops.putString("category", "Tops");
                SelectionFragment tab1 = new SelectionFragment();
                tab1.setArguments(tops);
                return tab1;
            case 1:
                Log.i("PAGER", "B and 1");
                Bundle bottoms = new Bundle();
                bottoms.putString("category", "Bottoms");
                SelectionFragment tab2 = new SelectionFragment();
                tab2.setArguments(bottoms);
                return tab2;
            case 2:
                Log.i("PAGER", "s and 2");
                Bundle shoes = new Bundle();
                shoes.putString("category", "Shoes");
                SelectionFragment tab3 = new SelectionFragment();
                tab3.setArguments(shoes);
                return tab3;
            case 3:
                Log.i("PAGER", "a and 3");
                Bundle acc = new Bundle();
                acc.putString("category", "Accessories");
                SelectionFragment tab4 = new SelectionFragment();
                tab4.setArguments(acc);
                return tab4;
            default:
                Log.i("PAGER", "NULL");
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}