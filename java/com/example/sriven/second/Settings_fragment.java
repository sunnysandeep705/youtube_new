package com.example.sriven.second;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by sriven on 4/24/2018.
 */

public class Settings_fragment extends Fragment {
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup group, Bundle savedinstance){
        View view=inflater.inflate(R.layout.settings,group,false);

        return view;
    }
    public Settings_fragment(){}
}
