package com.example.sriven.second;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;


import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Drawerexample_activity extends AppCompatActivity {

    ArrayList<Data_activity> dataitems = new ArrayList<Data_activity>();
    ArrayList<Data> serverdata=new ArrayList<>();
    ImageView i1, popups, i3;

    private AutoCompleteTextView nameTV;

    private PopupWindow popupWindow;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow();
            w.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
            w.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
        setContentView(R.layout.drawer_example);
        /*Animation
        final Animation rotation = AnimationUtils.loadAnimation(this, R.anim.menubar_rotation);
        rotation.setRepeatCount(Animation.RESTART);*/

        //Viepage initialization

        final ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        Tabs_adapter tabs_adapter = new Tabs_adapter(getSupportFragmentManager());
        viewPager.setAdapter(tabs_adapter);
        viewPager.beginFakeDrag();
        final DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawerlayout);
        final ListView listView = (ListView) findViewById(R.id.listviews);
        Drawerexample_adapter drawerexample_adapter = new Drawerexample_adapter(this, dataitems);


        //Toolbar

        final Toolbar toolbar = (Toolbar) findViewById(R.id.drawertoolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayShowTitleEnabled(false);
        getSupportActionBar().setHomeButtonEnabled(false);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayShowCustomEnabled(true);

        ActionBar.LayoutParams layoutParams = new ActionBar.LayoutParams(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.MATCH_PARENT);
        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.custom_toolbar, null);
        getSupportActionBar().setCustomView(view, layoutParams);
        Toolbar parent = (Toolbar) view.getParent();
        parent.setContentInsetsAbsolute(0, 0);

        // Adding items to list view

        dataitems.add(new Data_activity(R.drawable.myfavorites, "My Favorites"));
        dataitems.add(new Data_activity(R.drawable.servicerequest, "Service Request"));
        dataitems.add(new Data_activity(R.drawable.notifications, "Notification"));
        dataitems.add(new Data_activity(R.drawable.referafriend, "Refer a Friend"));

        dataitems.add(new Data_activity(R.drawable.settings, "Settings"));


        listView.setAdapter(drawerexample_adapter);


        //toolbar click listener

        //search

     /*   popups = (ImageView) view.findViewById(R.id.search);
        popups.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popup();
            }
        });*/


        final TextView toolbartitle=(TextView)view.findViewById(R.id.toolbar_titles);
        //menu
        i1 = (ImageView) view.findViewById(R.id.menu);


        i1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             //   i1.startAnimation(rotation);
                drawerLayout.openDrawer(Gravity.LEFT);
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                drawerLayout.closeDrawer(Gravity.LEFT);

                if (i == 0) {

                    toolbartitle.setText("My favorties");
                    viewPager.setCurrentItem(1);

                } else if (i == 1) {

                    toolbartitle.setText("Service Request");
                    viewPager.setCurrentItem(2);
                } else if (i==2) {
                    toolbartitle.setText("Notification");
                    viewPager.setCurrentItem(3);
                }
                else if(i==3){
                    toolbartitle.setText("Refer a friend");
                    viewPager.setCurrentItem(4);
                }

                else if(i==4){
                    toolbartitle.setText("Settings");
                    viewPager.setCurrentItem(5);
                }

                else viewPager.setCurrentItem(6);
            }
        });


      /*  Customlist_adapter adapter = new Customlist_adapter(this,
                R.layout.search_popup, getData());
        nameTV = (AutoCompleteTextView)
                findViewById(R.id.searchtext);

        nameTV.setAdapter(adapter);
        nameTV.setOnItemClickListener(onItemClickListener);*/

    }

   /* private AdapterView.OnItemClickListener onItemClickListener =
            new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                    Toast.makeText(Drawerexample_activity.this,
                            "Clicked item from auto completion list "
                                    + adapterView.getItemAtPosition(i)
                            , Toast.LENGTH_SHORT).show();
                }
            };*/








      /* public void popup(){
         LayoutInflater inflater1=(LayoutInflater)Drawerexample_activity.this.getSystemService(LAYOUT_INFLATER_SERVICE);
         View view1= inflater1.inflate(R.layout.search_popup,null);

          //close
         i3=(ImageView)view1.findViewById(R.id.back);
         i3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popupWindow.dismiss();

              }
          });


           popupWindow=new PopupWindow(view1, ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT);
           popupWindow.setFocusable(true);
         //popupWindow.showAtLocation(i2,Gravity.TOP,0,0);

           popupWindow.showAsDropDown(popups, 50, -110);*/

    }


    /*private List<String> getData(){
        List<String> dataList = new ArrayList<String>();
        dataList.add("Fashion Men");
        dataList.add("Fashion Women");
        dataList.add("Baby");
        dataList.add("Kids");
        dataList.add("Electronics");
        dataList.add("Appliance");
        dataList.add("Travel");
        dataList.add("Bags");
        dataList.add("FootWear");
        dataList.add("Jewellery");
        dataList.add("Sports");
        dataList.add("Electrical");
        dataList.add("Sports Kids");
        return dataList;
    }*/

