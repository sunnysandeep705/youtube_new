package com.example.sriven.second;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;

/**
 * Created by sriven on 4/27/2018.
 */

public class Tabs_adapter extends FragmentStatePagerAdapter {

    public Tabs_adapter(FragmentManager fragmentManager){
        super(fragmentManager);
    }
    @Override
    public Fragment getItem(int position){
       // Log.e("pos", String.valueOf(position));

        if (position==0){
            return new Home_fragment();
        }
        else if (position==1){
            return new Myfavorites_fragment() ;
        }
        else if (position==2){
            return new ServiceRequest_fragment();
        }
        else if (position==3)
            return new Notifiactions_fragment();
        else if (position==4)
 return new Referafriend_fragment();
        else
            return new Settings_fragment();

    }
    @Override
    public int getCount(){
        return 6;
    }

}
