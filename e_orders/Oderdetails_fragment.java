package com.example.sriven.e_orders;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.wonderkiln.blurkit.BlurLayout;

import java.util.ArrayList;

/**
 * Created by sriven on 5/4/2018.
 */

public class Oderdetails_fragment extends Fragment {
    ArrayList<Oders_data> oders_data=new ArrayList<Oders_data>();
    BlurLayout blurLayout;

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup group, Bundle savedinstance){
        View view = inflater.inflate(R.layout.orders_layout, group, false);

  /*      blurLayout = (BlurLayout)view.findViewById(R.id.blurlayout);
        oders_data.add(new Oders_data(" 10 kilos","123@gmail.com","1/2/3","https://res.cloudinary.com/hlkdbdswu/image/upload/v1525129044/Services/icons/Photography.png"));
        oders_data.add(new Oders_data(" 20 kilos","234@gmail.com","2/3/4","https://res.cloudinary.com/hlkdbdswu/image/upload/v1525129044/Services/icons/Photography.png"));
        oders_data.add(new Oders_data(" 25 kilos","345@gmail.com","3/4/5","https://res.cloudinary.com/hlkdbdswu/image/upload/v1525129044/Services/icons/Photography.png"));*/

        /*RecyclerView recyclerView=(RecyclerView)view.findViewById(R.id.oder_recycler);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);


        Oderdetails_adapter oderdetails_adapter=new Oderdetails_adapter(getContext(),oders_data);
        recyclerView.setAdapter(oderdetails_adapter);*/


      /*  RecyclerView recyclerView=(RecyclerView)view.findViewById(R.id.oder_recycler);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
       // recyclerView.findViewHolderForAdapterPosition(pos);

      final   Recycler_adapter odertype_adapter=new Recycler_adapter(getContext(),oders_data);
        recyclerView.setAdapter(odertype_adapter);*/

        final ViewPager viewPager = (ViewPager)view.findViewById(R.id.oders_viewpager);
        Oders_viewpager oders_viewpager = new Oders_viewpager(getFragmentManager());
//        viewPager.beginFakeDrag();

        TextView withoutimage =(TextView)view.findViewById(R.id.withoutimg_tab);
        TextView withimage =(TextView)view.findViewById(R.id.withimg_tab);
        viewPager.setAdapter(oders_viewpager);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        withoutimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager.setCurrentItem(1);
            }
        });
        withimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager.setCurrentItem(2);
            }
        });
        return view;
    }

    public Oderdetails_fragment() {

    }
}
