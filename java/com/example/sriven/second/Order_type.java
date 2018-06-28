package com.example.sriven.second;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Order_type extends AppCompatActivity {
    ArrayList<Sub_data> odertype=new ArrayList<Sub_data>();
  //  ArrayList<String> odertype = new ArrayList<String>(Arrays.asList("Person 1", "Person 2", "Person 3", "Person 4", "Person 5", "Person 6", "Person 7"));
Button b1;
TextView t1;
LinearLayout l1;
//public static final String req = DONE;

    private PopupWindow popupWindow;
    Data selected_ser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.odertype_recycler);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow();
            w.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
            w.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
        //t1=(TextView)findViewById(R.id.chabgable_text);
        //Intent intent=getIntent();
       // t1.setText(""+intent.getStringExtra("username"));


       selected_ser= (Data) getIntent().getSerializableExtra("service");

        //Toolbar

        Toolbar toolbar = (Toolbar) findViewById(R.id.ordertype_toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayShowTitleEnabled(false);
       // toolbar.setTitle("Oder Type");
        getSupportActionBar().setHomeButtonEnabled(false);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayShowCustomEnabled(true);

        ActionBar.LayoutParams layoutParams = new ActionBar.LayoutParams(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.MATCH_PARENT);
        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.custom_toolbartwo, null);
        getSupportActionBar().setCustomView(view, layoutParams);
        Toolbar parent = (Toolbar) view.getParent();
        parent.setContentInsetsAbsolute(0, 0);

        TextView toolbartitle=(TextView)view.findViewById(R.id.toolbar_title);
            toolbartitle.setText(selected_ser.title);

        ImageView back=(ImageView)view.findViewById(R.id.location_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
/*
                Intent intent = new Intent(Order_type.this,Drawerexample_activity.class);
                startActivity(intent);*/
                finish();
            }
        });

        final ProgressBar progressbar = (ProgressBar)findViewById(R.id.progressBartwo);


        RecyclerView recyclerView=(RecyclerView)findViewById(R.id.odertyperecycler);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);
      //  recyclerView.findViewHolderForAdapterPosition(pos);

      final  Odertype_adapter odertype_adapter=new Odertype_adapter(Order_type.this,odertype);
        recyclerView.setAdapter(odertype_adapter);


        String url = Session.SERVER_URL+"services/getSubServices";
        JSONObject req = new JSONObject();

       try {
            req.put("sessionId", "50e21930-7592-11e8-8ac1-174c145645c2");
            req.put("serviceId", selected_ser.id);
        } catch (JSONException e) {
            e.printStackTrace();
        };

        JsonObjectRequest request = new JsonObjectRequest( Request.Method.POST,url,req,new Response.Listener<JSONObject>(){

            @Override
            public void onResponse(JSONObject response_obj) {
               progressbar.setVisibility(View.GONE);

                Log.e("response",response_obj.toString());

                JSONArray response = new JSONArray();
                try {
                    response = response_obj.getJSONArray("subServices");
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                for (int i=0;i<response.length();i++){
                    try {
                        JSONObject temp=response.getJSONObject(i);
                        Sub_data catagories=new Sub_data(temp);
                        odertype.add(catagories);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                odertype_adapter.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
                progressbar.setVisibility(View.GONE);
            }
        }){

            @Override
            protected Map<String,String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("sessionId", "0210eed0-4c57-11e8-b981-53d55b3a3dba");

                return params;
            }
//            @Override
//            public Map<String, String> getHeaders() throws AuthFailureError {
//                Map<String,String> params = new HashMap<String, String>();
//                params.put("Content-Type","application/x-www-form-urlencoded");
//                return params;
//            }
        };

        ApplicationController.getInstance().getRequestQueue().add(request);
        progressbar.setVisibility(View.VISIBLE);


    }



}
