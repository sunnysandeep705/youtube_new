package com.example.sriven.second;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Newlayout_activity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newlayout);
        ViewPager viewPager=(ViewPager)findViewById(R.id.pager);



        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());

        // Add Fragments to adapter one by one
        adapter.addFragment(new Myfavorites_fragment(), "PRICE");
        adapter.addFragment(new Fragment_three(), "ORDERS");
        adapter.addFragment(new Fragment_three(), "FINISHED");
        viewPager.setAdapter(adapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
       // tabLayout.getTabAt(0).setIcon(R.drawable.attherate_icon);
      //  tabLayout.getTabAt(1).setIcon(R.drawable.person_icon);
       // tabLayout.getTabAt(2).setIcon(R.drawable.phone_icon);

        TextView textView=(TextView)LayoutInflater.from(this).inflate(R.layout.textfor_tabs,null);
        textView.setText("Price");
        textView.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.person_icon,0,0,0);
        tabLayout.getTabAt(0).setCustomView(textView);

        TextView textView2=(TextView)LayoutInflater.from(this).inflate(R.layout.textfor_tabs,null);
        textView2.setText("Orders");
        textView2.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.phone_icon,0,0,0);
        tabLayout.getTabAt(1).setCustomView(textView2);

        TextView textView3=(TextView)LayoutInflater.from(this).inflate(R.layout.textfor_tabs,null);
        textView3.setText("Finished");
        textView3.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.attherate_icon,0,0,0);
        tabLayout.getTabAt(2).setCustomView(textView3);

    }
     class ViewPagerAdapter extends FragmentPagerAdapter{
        private final List<Fragment> fragmentList=new ArrayList<>();
         private final List<String> stringList=new ArrayList<>();

         public ViewPagerAdapter(FragmentManager fragmentManager){
             super(fragmentManager);
         }
         public Fragment getItem(int position){
             return fragmentList.get(position);
         }
         public int getCount(){
             return fragmentList.size();
         }

         public void addFragment(Fragment addfragments,String title){
             fragmentList.add(addfragments);
             stringList.add(title);
         }

         public CharSequence getPageTitle(int position){
             return stringList.get(position);
         }
    }


}
