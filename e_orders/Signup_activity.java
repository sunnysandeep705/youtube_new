package com.example.sriven.e_orders;

/**
 * Created by sriven on 5/23/2018.
 */


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;
import java.util.HashMap;
import java.util.Map;

public class Signup_activity extends AppCompatActivity {

    private static final String TAG = "RegisterActivity";
    private static final String URL_FOR_REGISTRATION = "http://clients.yellowsoft.in/wedding/api/member.php";
    ProgressDialog progressDialog;

    private EditText signupInputName, signupInputEmail, signupInputPassword, signupInputLastname,signupInputAddress,
            signupInputCity,signupInputState,signupInputCountry,signupInputPincode,signupInputPhonenumber;
//    private Button ;
    TextView btnLinkLogin,btnSignUp;
    private RadioGroup genderRadioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.createaccount_screen);

        // Progress dialog
        progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(false);

        signupInputName = (EditText) findViewById(R.id.name);
        signupInputEmail = (EditText) findViewById(R.id.emailtext);
        signupInputPassword = (EditText) findViewById(R.id.password_text);
        signupInputLastname = (EditText) findViewById(R.id.lname_text);
        signupInputAddress = (EditText) findViewById(R.id.address_text);
      /*  signupInputCity = (EditText) findViewById(R.id.city_text);
        signupInputState = (EditText) findViewById(R.id.state_text);
        signupInputCountry = (EditText) findViewById(R.id.county_text);
        signupInputPincode = (EditText) findViewById(R.id.pincode_text);*/
        signupInputPhonenumber=(EditText)findViewById(R.id.phone_text);

        btnSignUp = (TextView) findViewById(R.id.createact_btn);
        btnLinkLogin = (TextView) findViewById(R.id.login_crtact);


        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // submitForm();
                Intent intent = new Intent(Signup_activity.this,Admin_screen.class);
                startActivity(intent);
            }
        });
        btnLinkLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               Intent i = new Intent(getApplicationContext(),LoginScreen_Activity.class);
                startActivity(i);
               // Toast.makeText(getApplicationContext(),"asdfasdfsdfd",Toast.LENGTH_LONG).show();

            }
        });
    }

    private void submitForm() {

      /*  int selectedId = genderRadioGroup.getCheckedRadioButtonId();
        String gender;
        if(selectedId == R.id.female_radio_btn)
            gender = "Female";
        else
            gender = "Male";*/
      if(signupInputName.getText().toString().equals("")){
          Toast.makeText(getApplicationContext(),"Please enter first name",Toast.LENGTH_SHORT).show();
      }else if(signupInputEmail.getText().toString().equals("")){

      }

        registerUser(signupInputName.getText().toString(),
                signupInputEmail.getText().toString(),
                signupInputPassword.getText().toString(),
                signupInputAddress.getText().toString(),
                signupInputCountry.getText().toString(),
                signupInputCity.getText().toString(),
                signupInputLastname.getText().toString(),
                signupInputState.getText().toString(),
                signupInputPincode.getText().toString(),
                signupInputPhonenumber.getText().toString());
    }

    private void registerUser(final String name, final String email, final String password, final String phonenumber , final String lastname, final String country, final String address, final String city, final String state, final String pincode) {
        // Tag used to cancel the request
        String cancel_req_tag = "register";

        progressDialog.setMessage("Adding you ...");
        showDialog();
        Toast.makeText(getApplicationContext(), "something is cooking!", Toast.LENGTH_SHORT).show();
        StringRequest strReq = new StringRequest(Request.Method.POST, URL_FOR_REGISTRATION, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                Log.d(TAG, "Register Response: " + response);
                progressDialog.setMessage("still adding you");
                hideDialog();
                try {
                    JSONObject jObj = new JSONObject(response);
                    String error = jObj.getString("status");
                    if(error.equals("Failed")){
                        Toast.makeText(getApplicationContext(),jObj.getString("message"),Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(getApplicationContext(),jObj.getString("message"),Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Signup_activity.this, LoginScreen_Activity.class);
                        startActivity(intent);
                        finish();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, "Registration Error: " + error.getMessage());
                Toast.makeText(getApplicationContext(),
                        error.getMessage(), Toast.LENGTH_LONG).show();
                hideDialog();
            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                // Posting params to register url
                Map<String, String> params = new HashMap<String, String>();
                params.put("fname", name);
                params.put("email", email);
                params.put("password", password);
                params.put("lname",lastname);
                params.put("address",address);
                params.put("city",city);
                params.put("state",state);
                params.put("country",country);
                params.put("pincode",pincode);
                params.put("phone",phonenumber);

                return params;
            }
        };
        // Adding request to request queue
        ApplicationController.getInstance().addToRequestQueue(strReq,cancel_req_tag);
    }

    private void showDialog() {
        if (!progressDialog.isShowing())
            progressDialog.show();
    }

    private void hideDialog() {
        if (progressDialog.isShowing())
            progressDialog.dismiss();
    }
}
