package com.example.sriven.second;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by sriven on 4/24/2018.
 */

public class Home_fragment extends Fragment {
    ArrayList<Data> items=new ArrayList<Data>();

    ProgressBar progressBar;
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup group, Bundle savedinstance){
        View view=inflater.inflate(R.layout.home_layout,group,false);


       /* items.add(new Data("First","https://res.cloudinary.com/hlkdbdswu/image/upload/v1525129044/Services/icons/Photography.png"));
        items.add(new Data("Second","https://res.cloudinary.com/hlkdbdswu/image/upload/v1525129044/Services/icons/Photography.png"));
        items.add(new Data("Third","https://res.cloudinary.com/hlkdbdswu/image/upload/v1525129044/Services/icons/Photography.png"));
        items.add(new Data("Fourth","https://res.cloudinary.com/hlkdbdswu/image/upload/v1525129044/Services/icons/Photography.png"));
        items.add(new Data("Fifth","https://res.cloudinary.com/hlkdbdswu/image/upload/v1525129044/Services/icons/Photography.png"));
        items.add(new Data("sixth","https://res.cloudinary.com/hlkdbdswu/image/upload/v1525129044/Services/icons/Photography.png"));
        items.add(new Data("Seventh","https://res.cloudinary.com/hlkdbdswu/image/upload/v1525129044/Services/icons/Photography.png"));
        items.add(new Data("Eight","https://res.cloudinary.com/hlkdbdswu/image/upload/v1525129044/Services/icons/Photography.png"));
        items.add(new Data("Ninth","https://res.cloudinary.com/hlkdbdswu/image/upload/v1525129044/Services/icons/Photography.png"));*/


        RecyclerView recyclerView=(RecyclerView)view.findViewById(R.id.recyclerview);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        final Recycler_adapter recycler_adapter=new Recycler_adapter(getContext(),items);
        recyclerView.setAdapter(recycler_adapter);

        progressBar = (ProgressBar) view.findViewById(R.id.homeprogress);
        //adding items
        progressBar.setVisibility(View.GONE);

        String url = Session.SERVER_URL+"services/getServices";
        JSONObject req = new JSONObject();
        try {
            req.put("sessionId", "50e21930-7592-11e8-8ac1-174c145645c2");
        } catch (JSONException e) {
            e.printStackTrace();
        };

        JsonObjectRequest request = new JsonObjectRequest( Request.Method.POST,url,req,new Response.Listener<JSONObject>(){

            @Override
            public void onResponse(JSONObject response_obj) {
                progressBar.setVisibility(View.GONE);

                Log.e("response",response_obj.toString());

                JSONArray response = new JSONArray();
                try {
                    response = response_obj.getJSONArray("services");
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                for (int i=0;i<response.length();i++){
                    try {
                        JSONObject temp=response.getJSONObject(i);
                        Data catagories=new Data(temp);
                        items.add(catagories);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                recycler_adapter.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            error.printStackTrace();
                progressBar.setVisibility(View.GONE);
            }
        }){

       /*     @Override
            protected Map<String,String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("sessionId", "0210eed0-4c57-11e8-b981-53d55b3a3dba");

                return params;
            }*/
//            @Override
//            public Map<String, String> getHeaders() throws AuthFailureError {
//                Map<String,String> params = new HashMap<String, String>();
//                params.put("Content-Type","application/x-www-form-urlencoded");
//                return params;
//            }
        };

        ApplicationController.getInstance().getRequestQueue().add(request);
        progressBar.setVisibility(View.VISIBLE);

        return view;
    }
    public Home_fragment(){}
}
