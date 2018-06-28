package com.example.sriven.second;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Createaccount_activity extends AppCompatActivity {
    Button createaccount;
    EditText firstname,lastname,mobilenumber,emailid,password,confirmpassword;
    LinearLayout linearLayout;
    boolean validation=true;
    TextView backto_login;
    String url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.createaccount_screen);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow();
            w.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
            w.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
        url="http://clients.yellowsoft.in/wedding/api/member.php";
        Log.v("url details","postURL"+url);
        linearLayout=(LinearLayout)findViewById(R.id.linear_layout);
        firstname=(EditText)findViewById(R.id.firstname);
        lastname=(EditText)findViewById(R.id.lastname_crtact);
        mobilenumber=(EditText)findViewById(R.id.mobilenum_crtact);
        emailid=(EditText)findViewById(R.id.emailid_crtact);
        password=(EditText)findViewById(R.id.password_crtact);
        confirmpassword=(EditText)findViewById(R.id.passwordcfm_crtact);



        createaccount=(Button)findViewById(R.id.createact_btn);
        createaccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                homeactivity();
            }
        });
       backto_login=(TextView)findViewById(R.id.login_crtact);
       backto_login.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               finish();
           }
       });

    }
    public void homeactivity(){

        if (firstname.getText().toString().length() < 6) {
                if (firstname.getText().toString().length() <= 0) {
                    Snackbar.make(linearLayout, "First Name should not be empty", Snackbar.LENGTH_SHORT).show();
                } else
                    Snackbar.make(linearLayout, "First Name should not be minimum 6 ch", Snackbar.LENGTH_SHORT).show();


            }
            else if (lastname.getText().toString().length() <= 0) {
                Snackbar.make(linearLayout, "Last Name should not be empty", Snackbar.LENGTH_SHORT).show();

            } else if (mobilenumber.getText().toString().length() <= 0) {
                Snackbar.make(linearLayout, "Mobile Number should not be empty", Snackbar.LENGTH_SHORT).show();

            } else if (emailid.getText().toString().length() <= 0) {
                Snackbar.make(linearLayout, "Email ID should not be empty", Snackbar.LENGTH_SHORT).show();

            } else if (password.getText().toString().length() < 6) {
            if (password.getText().toString().length() <= 0) {
                Snackbar.make(linearLayout, "Password should not be empty", Snackbar.LENGTH_SHORT).show();
            } else
                Snackbar.make(linearLayout, "Password should be minimum 6 charcters", Snackbar.LENGTH_SHORT).show();
        }
//            } else if (confirmpassword.getText().toString().length() < 6) {
//
//                if (confirmpassword.getText().toString().length() <= 0) {
//                    Snackbar.make(linearLayout, "Confirm password should not be empty", Snackbar.LENGTH_SHORT).show();
//                } else
//                    Snackbar.make(linearLayout, "Confirm Password should be minimum 6 charcters", Snackbar.LENGTH_SHORT).show();
//
//
//            }
        else if (password.getText().toString().equals(confirmpassword.getText().toString())){
            Snackbar.make(linearLayout, "confirm password should match password", Snackbar.LENGTH_SHORT).show();

        }
            else {
                Intent intent = new Intent(getApplicationContext(), Drawerexample_activity.class);
                startActivity(intent);
            }

        }


}





