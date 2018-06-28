package com.example.sriven.second;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by sriven on 5/11/2018.
 */

public class Sub_data {
String name,id;

public Sub_data(String name,String id){
    this.id=id;
    this.name=name;
}
public Sub_data(JSONObject jsonObject){
    try {
        this.id=jsonObject.getString("_id");
        this.name=jsonObject.getString("subServiceName");

    } catch (JSONException e) {
        e.printStackTrace();
    }

}
}
