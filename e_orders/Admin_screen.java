package com.example.sriven.e_orders;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.Image;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.wonderkiln.blurkit.BlurLayout;

import java.util.ArrayList;
import java.util.HashMap;

public class Admin_screen extends AppCompatActivity {

    ArrayList<Data_activity> dataitems = new ArrayList<Data_activity>();
    ArrayList<Data> serverdata=new ArrayList<>();
    ImageView i1, popups, i3;
    BlurLayout blurlayout;

    private AutoCompleteTextView nameTV;

    Session session;
    private PopupWindow popupWindow;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        /*if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow();
            w.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
            w.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }*/
        session = new Session(getApplicationContext());
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_screen);



        TextView username = (TextView)findViewById(R.id.welcome_usr);

        Intent intent = new Intent();

//         uname; /*= intent.getStringExtra("username");*/
//        username.setText("Welcome "+uname+" !");
        HashMap<String, String> user = session.getUserDetails();
        final String userid = user.get(Session.KEY_userid);
       final String uname = user.get(Session.KEY_EMAIL);
       username.setText("Welcome "+userid+" !");

        Toast.makeText(this, uname+" Your Welcome", Toast.LENGTH_LONG).show();
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

        Toolbar toolbar = (Toolbar) findViewById(R.id.drawertoolbar);
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

        ImageView menuview = (ImageView)view.findViewById(R.id.menu);

        menuview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                blurlayout.setVisibility(View.VISIBLE);
            }
        });

        getSupportActionBar().setCustomView(view, layoutParams);
        Toolbar parent = (Toolbar) view.getParent();
        parent.setContentInsetsAbsolute(0, 0);

        // Adding items to list view

        dataitems.add(new Data_activity(R.drawable.home_icon, "Home"));
        dataitems.add(new Data_activity(R.drawable.list_icon, "Oders"));
        dataitems.add(new Data_activity(R.drawable.ckeckbox_icon, "Finished"));



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
                    viewPager.setCurrentItem(0);

                } else if (i == 1) {
                    viewPager.setCurrentItem(2);
                } else if (i==2) {
                    viewPager.setCurrentItem(3);
                    session.logoutUser();
                  // String s= getIntent().getStringExtra("uname");


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

                    Toast.makeText(Admin_screen.this,
                            "Clicked item from auto completion list "
                                    + adapterView.getItemAtPosition(i)
                            , Toast.LENGTH_SHORT).show();
                }
            };*/








      /* public void popup(){
         LayoutInflater inflater1=(LayoutInflater)Admin_screen.this.getSystemService(LAYOUT_INFLATER_SERVICE);
         View view1= inflater1.inflate(R.layout.search_popup,null);

          //close
         i3=(ImageView)view1.findViewById(R.id.back);
         i3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popupWindow.dismiss();

              }
          });*/

/*
           popupWindow=new PopupWindow(view1, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
           popupWindow.setFocusable(true);
         popupWindow.showAtLocation(i2,Gravity.TOP,0,0);

           popupWindow.showAsDropDown(popups, 50, -110);*/
public void close(View view){
    finish();
}

    }

