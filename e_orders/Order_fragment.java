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
import android.widget.Toast;



/**
 * Created by sriven on 4/24/2018.
 */

public class Order_fragment extends Fragment {
    Button changebutton, myButton;
    EditText changetext;
    String s1;
    TextView t1,lastchange_price,onlypricetext;
    PopupWindow popupWindow;
    LinearLayout cancelbutton,okaybutton;





    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup group, Bundle savedinstance){
        View view = inflater.inflate(R.layout.orders_customer, group, false);

        onlypricetext=(TextView)view.findViewById(R.id.price);
        onlypricetext.setSelected(true);





    return view;
    }
    public Order_fragment() {

    }

    public void popupp() {
        LayoutInflater inflater = (LayoutInflater) Order_fragment.this.getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.popup_layput, null);
        popupWindow = new PopupWindow(view, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        // popupWindow.showAtLocation(b1, Gravity.CENTER, 0, 0);
        popupWindow.showAsDropDown(changetext,0,0);
        cancelbutton=(LinearLayout)view.findViewById(R.id.cancel);

        okaybutton=(LinearLayout)view.findViewById(R.id.yes);

        t1=(TextView) view.findViewById(R.id.chabgable_text);
        t1.setText(changetext.getText().toString());
        popupWindow.update();

      //  TextView textView=(TextView)view.findViewById(R.id.chabgable_text);
      //  textView.setText(s1);

       cancelbutton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               popupWindow.dismiss();
           }
       });
       okaybutton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               lastchange_price.setText(changetext.getText().toString());
               popupWindow.dismiss();
           }
       });

    }


}

