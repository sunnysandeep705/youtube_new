package com.example.sriven.e_orders;


import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Admin_Login extends AppCompatActivity {

    Button loginbtn;
    TextView userbtn,newuserbtn;
   EditText logintext,passwordtext;
    ProgressDialog progressDialog;
    private static final String TAG = "SignInActivity";
    Session session;


    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String Email = "emailKey";

    SharedPreferences sharedpreferences;

    Context context;
    private static final String URL_FOR_LOGIN = "http://clients.yellowsoft.in/wedding/api/login.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_login);


        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        session = new Session(getApplicationContext());




        loginbtn = (Button)findViewById(R.id.login_btn_admin);
        userbtn = (TextView)findViewById(R.id.user_login_admin);
        newuserbtn = (TextView)findViewById(R.id.register_text_admin);

        // Progress dialog
        progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(false);

        logintext = (EditText)findViewById(R.id.et_email_login_admin);
        passwordtext = (EditText)findViewById(R.id.et_password_login_admin);


        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login_user();
            }
        });

        userbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
        //   Snackbar.make(adminbtn,"asdasdasd",Snackbar.LENGTH_SHORT).show();
                Intent intent = new Intent(Admin_Login.this, LoginScreen_Activity.class);
                startActivity(intent);
              //  intent.putExtra("username", finalLoginstring);
            }
        });
        newuserbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Admin_Login.this,Signup_activity.class);
                    startActivity(intent);
            }
        });
    }
    public void login_user(){
        login( logintext.getText().toString(),
                passwordtext.getText().toString());
         if (logintext.getText().toString().equals("")){
               Toast.makeText(getApplicationContext(),"enterusername",Toast.LENGTH_SHORT).show();
         }
         else if (passwordtext.getText().toString().length()<6){
             Toast.makeText(getApplicationContext(),"password must be minimum 6 characters",Toast.LENGTH_SHORT).show();
         }
         else{

         }
    }
    public void login(String loginstring, final String passwordstring){

        loginstring = logintext.getText().toString();
        final String finalLoginstring = loginstring;
        final String finalLoginstring1 = loginstring;
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_FOR_LOGIN, new Response.Listener<String>() {

                @Override
                public void onResponse(String response) {
                    Log.d(TAG, "Register Response: " + response);
                    Toast.makeText(getApplicationContext(),""+response,Toast.LENGTH_LONG).show();

                    try {
                        JSONObject jsonObject  = new JSONObject(response);
                        String error = jsonObject.getString("status");
                        if (error.equals("Failure")){
                            Toast.makeText(getApplicationContext(),"Login Failed",Toast.LENGTH_SHORT).show();

                        }
                        else {
                            Toast.makeText(getApplicationContext(), "Login Success", Toast.LENGTH_SHORT).show();
                            String mem_id = jsonObject.getString("member_id");


                            session.createLoginSession(finalLoginstring, "loginstring");
                            Intent intent = new Intent(Admin_Login.this, Admin_screen.class);
                           intent.putExtra("username", finalLoginstring);

                            startActivity(intent);
                          //  Toast.makeText(getApplicationContext(), "Welcome " + finalLoginstring, Toast.LENGTH_SHORT).show();
                            boolean yes = true;
                            if (yes) {
                                finish();
                                Log.e("yougotnoerror", "YOU GOT NO ERROR");
                                Toast.makeText(getApplicationContext(),""+mem_id,Toast.LENGTH_SHORT).show();
                            } else {
                                Log.e("YOUGOTANERROR", "YOU G   OT AN ERROR");
                            }
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                }
            }){
                @Override
                protected Map<String,String> getParams(){
                    Map<String,String> params = new HashMap<String, String>();
                    params.put("email", finalLoginstring1);
                    params.put("password",passwordstring);
                    return params;
                }
            };
            ApplicationController.getInstance().getRequestQueue().add(stringRequest);

        }


}
