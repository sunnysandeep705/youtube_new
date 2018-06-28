package com.example.sriven.e_orders;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by sriven on 4/26/2018.
 */

public class Drawerexample_adapter extends BaseAdapter {
ArrayList<Data_activity> data_items;
private Context context;
private  LayoutInflater inflater = null;
   Activity activity;

public Drawerexample_adapter(Context context, ArrayList<Data_activity> data_items){
    this.data_items=data_items;
    this.context=context;
    inflater = LayoutInflater.from(context);
}
@Override
        public int getCount()
{
    return data_items.size();
}
        @Override
        public Object getItem(int position){
    return position;
}
        @Override
        public long getItemId(int position){
    return position;
}
        public class Holder{
           TextView title;
           ImageView image_icon;
}
               @Override
                 public View getView(final int position, View convertview, ViewGroup parent){
                   Holder holder=new Holder();
                   View view;
                   view= inflater.inflate(R.layout.listview_conent,null);
                   holder.image_icon=(ImageView)view.findViewById(R.id.image_icon);
                   holder.title=(TextView)view.findViewById(R.id.title);

                      Data_activity item= data_items.get(position);

                       holder.title.setText(item.menuname);
                       holder.image_icon.setImageResource(item.images);
                          //  Picasso.with(activity.getApplicationContext()).load(items.images[position]).into(holder.image_icon);
                            return view;
                    }

                }
