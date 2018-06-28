package com.example.sriven.e_orders;

import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Orderscustomer_activity extends AppCompatActivity {
    ArrayList<Data_activity> dataitems = new ArrayList<Data_activity>();
    ImageView i1, popups, i3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customer_screen);
       /* if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow();
            w.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
            w.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }*/

        final ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager_customer);
        Tabs_adapter tabs_adapter = new Tabs_adapter(getSupportFragmentManager());
        viewPager.setAdapter(tabs_adapter);
     //  viewPager.endFakeDrag();
        final DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawerlayout_customer);
        final ListView listView = (ListView) findViewById(R.id.listviews);
        Drawerexample_adapter drawerexample_adapter = new Drawerexample_adapter(this, dataitems);


        //Toolbar

        Toolbar toolbar = (Toolbar) findViewById(R.id.drawertoolbar_customer);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayShowTitleEnabled(false);
        getSupportActionBar().setHomeButtonEnabled(false);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayShowCustomEnabled(true);

        ActionBar.LayoutParams layoutParams = new ActionBar.LayoutParams(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.WRAP_CONTENT);
        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.custom_toolbar, null);
        getSupportActionBar().setCustomView(view, layoutParams);
        Toolbar parent = (Toolbar) view.getParent();
        parent.setContentInsetsAbsolute(0, 0);


        dataitems.add(new Data_activity(R.drawable.home_icon, "Home"));
        dataitems.add(new Data_activity(R.drawable.list_icon, "My Oders"));
        dataitems.add(new Data_activity(R.drawable.ckeckbox_icon, "Finished"));
        listView.setAdapter(drawerexample_adapter);

        i1 = (ImageView) view.findViewById(R.id.menu);


        i1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //   i1.startAnimation(rotation);
                drawerLayout.openDrawer(Gravity.START);
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                drawerLayout.closeDrawer(Gravity.START);
                if (i == 0) {
                    viewPager.setCurrentItem(0);

                } else if (i == 1) {
                    viewPager.setCurrentItem(2);
                } else if (i==2) {
                    viewPager.setCurrentItem(3);
                }
                else if(i==3){
                    viewPager.setCurrentItem(4);
                }

                else if(i==4){
                    viewPager.setCurrentItem(5);
                }
                else viewPager.setCurrentItem(6);
            }
        });

    }



}
