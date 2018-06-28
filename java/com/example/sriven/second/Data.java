package com.example.sriven.second;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

/**
 * Created by sriven on 5/1/2018.
 */

public class Data  implements Serializable{
    String title;
    String images,id;



    public Data(String title,String images){
        this.images=images;
        this.title=title;

    }
    public Data(JSONObject jsonObject){

        try {
            this.images=jsonObject.getString("serviceLogo");
            this.title=jsonObject.getString("name");
            this.id=jsonObject.getString("_id");
        } catch (JSONException e) {
            e.printStackTrace();
        }


    }
//    public Data(JSONObject jsonObjects){
//        try {
//            this.oder_type=jsonObjects.getString("");
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//
//    }
}
