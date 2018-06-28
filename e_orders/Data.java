package com.example.sriven.e_orders;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by sriven on 5/1/2018.
 */

public class Data {
    String title;
    String images;



    public Data(String title, String images){
        this.images=images;
        this.title=title;

    }
    public Data(JSONObject jsonObject){

        try {
            this.images=jsonObject.getString("image");
            this.title=jsonObject.getString("title");
        } catch (JSONException e) {
            e.printStackTrace();
        }


    }
}
