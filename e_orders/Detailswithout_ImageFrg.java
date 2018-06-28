package com.example.sriven.e_orders;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;


/**
 * Created by sriven on 4/24/2018.
 */

public class Detailswithout_ImageFrg extends Fragment {
    Button changebutton, myButton;
    EditText changetext;
    String s1;
    TextView t1,lastchange_price,onlypricetext;
    PopupWindow popupWindow;
    LinearLayout cancelbutton,okaybutton;





    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup group, Bundle savedinstance){
        View view = inflater.inflate(R.layout.details_of_oder_without_image, group, false);

      //  onlypricetext=(TextView)view.findViewById(R.id.price);
       // onlypricetext.setSelected(true);





    return view;
    }
    public Detailswithout_ImageFrg() {

    }



}

