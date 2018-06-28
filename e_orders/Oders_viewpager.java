package com.example.sriven.e_orders;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by sriven on 4/27/2018.
 */

public class Oders_viewpager extends FragmentStatePagerAdapter {

    public Oders_viewpager(FragmentManager fragmentManager){
        super(fragmentManager);
    }
    @Override
    public Fragment getItem(int position){
       // Log.e("pos", String.valueOf(position));

        if (position==0){
            return new WithoutImage();
        }
        else if (position==1){
            return new WithImage();
        }

        else
            return new Oderdetails_fragment();

    }
    @Override
    public int getCount(){
        return 3;
    }

}
