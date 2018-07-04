package com.example.sriven.eodersconsumer;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by sriven on 7/4/2018.
 */

public class Tutorial_tabs extends FragmentStatePagerAdapter {
  public Tutorial_tabs(FragmentManager fragmentManager){
		super(fragmentManager);
	}
	@Override
	public Fragment getItem(int pos){
		if (pos==0){
			return new Slider_One();
		}
		else
			return new Slider_Two();
		}
	@Override
	public int getCount(){
		return 2;
	}
}
