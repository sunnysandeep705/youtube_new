package com.example.sriven.e_orders;


import android.app.Dialog;
import android.content.Context;
import android.graphics.BlurMaskFilter;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
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

public class Pricechange_fragment extends Fragment {
    Button changebutton, myButton;
    EditText changetext;
    String s1;
    TextView t1,lastchange_price,onlypricetext;
    PopupWindow popupWindow;
    LinearLayout cancelbutton,okaybutton,blurlayout;





    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup group, Bundle savedinstance){
        View view = inflater.inflate(R.layout.changeprice_fragment, group, false);

       // blurlayout = (LinearLayout)view.findViewById(R.id.blur_layout);
        onlypricetext=(TextView)view.findViewById(R.id.scrollingtext);
        onlypricetext.setSelected(true);
        lastchange_price=(TextView)view.findViewById(R.id.lastchangedprice);
        final EditText editText=(EditText)view.findViewById(R.id.changepricetext);
        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if(i== EditorInfo.IME_ACTION_DONE){
                  //  popupp();
					alert();

                }

                return false;
            }
        });

    changetext=(EditText)view.findViewById(R.id.changepricetext);
       //s1= e1.toString();
        changebutton=(Button)view.findViewById(R.id.change_button);
       // TextView t2=(TextView)view.findViewById(R.id.changepricetext);


       // t2.setText(s1);
        changebutton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
          //     blurlayout.setVisibility(View.VISIBLE);
               //AlertDialog alertDialog = new AlertDialog(Pricechange_fragment.this);
				alert();
             //  popupp();
                changetext.getText().toString();



            }
        });

        return view;
    }
    public  Pricechange_fragment() {

    }
    public void alert(){
		final Dialog dialog = new Dialog(getContext());
		dialog.setContentView(R.layout.popup_layput);
		cancelbutton=(LinearLayout)dialog.findViewById(R.id.cancel);

		okaybutton=(LinearLayout)dialog.findViewById(R.id.yes);
		t1=(TextView) dialog.findViewById(R.id.chabgable_text);
		t1.setText(changetext.getText().toString());

		cancelbutton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				//  blurlayout.setVisibility(View.INVISIBLE);
				// popupWindow.dismiss();

			}
		});
		okaybutton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				// blurlayout.setVisibility(View.INVISIBLE);
				lastchange_price.setText(changetext.getText().toString());
				Toast.makeText(getContext(),"Price changed to "+changetext.getText().toString()+" / kilo",Toast.LENGTH_SHORT).show();
				// popupWindow.dismiss();
			}
		});
dialog.show();
	}

    public void popupp() {
        LayoutInflater inflater = (LayoutInflater) Pricechange_fragment.this.getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
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
             //  blurlayout.setVisibility(View.INVISIBLE);
               popupWindow.dismiss();
           }
       });
       okaybutton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
              // blurlayout.setVisibility(View.INVISIBLE);
               lastchange_price.setText(changetext.getText().toString());
               Toast.makeText(getContext(),"Price changed to "+changetext.getText().toString()+" / kilo",Toast.LENGTH_SHORT).show();
               popupWindow.dismiss();
           }
       });

    }


}

