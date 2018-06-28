package com.example.sriven.second;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by sriven on 4/24/2018.
 */

public class Fragment_three extends Fragment {
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup group, Bundle savedinstance){
        View view=inflater.inflate(R.layout.fragment_three,group,false);
        return view;
    }
    public Fragment_three(){}
}
