package com.example.sriven.e_orders;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

;

/**
 * Created by sriven on 4/24/2018.
 */
//this is not in use

public class Changeprice_fragment extends Fragment {
    Button changebutton, myButton;
    EditText changetext;
    String s1;
    TextView t1,lastchange_price,scroolingtext;
    PopupWindow popupWindow;
    LinearLayout cancelbutton,okaybutton;





    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup group, Bundle savedinstance){
        View view = inflater.inflate(R.layout.changeprice_fragment, group, false);

        scroolingtext=(TextView)view.findViewById(R.id.scrollingtext);
        scroolingtext.setSelected(true);

        final EditText editText=(EditText)view.findViewById(R.id.changepricetext);
        editText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if ((keyEvent.getAction() == KeyEvent.KEYCODE_NUMPAD_ENTER) && (i == KeyEvent.KEYCODE_ENTER)){
                    popupp();
                    changetext.getText().toString();
                }
                return false;
            }
        });

        changetext=(EditText)view.findViewById(R.id.changepricetext);
       //s1= e1.toString();
        changebutton=(Button)view.findViewById(R.id.change_button);
       // TextView t2=(TextView)view.findViewById(R.id.changepricetext);

        lastchange_price=(TextView)view.findViewById(R.id.lastchangedprice);
       // t2.setText(s1);
        changebutton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
                popupp();
                changetext.getText().toString();
               Toast.makeText(getContext(),"sdasdasdasdd",Toast.LENGTH_SHORT).show();

            }
        });


        return view;
    }
    public Changeprice_fragment() {

    }

    public void popupp() {
        LayoutInflater inflater = (LayoutInflater) Changeprice_fragment.this.getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
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

