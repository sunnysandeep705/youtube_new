package com.example.sriven.second;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

public class Popuplayout_activity extends AppCompatActivity {

Button b1;
TextView t1;
LinearLayout l1;

    private PopupWindow popupWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popup_layput);
        //t1=(TextView)findViewById(R.id.chabgable_text);
        //Intent intent=getIntent();
       // t1.setText(""+intent.getStringExtra("username"));

    }



}
