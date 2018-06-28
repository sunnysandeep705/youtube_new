package com.example.sriven.second;


import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by sriven on 3/27/2018.
 */

public class Odertype_adapter extends RecyclerView.Adapter <Odertype_adapter.MyViewHolder>{
    Context context;
    ArrayList<Sub_data> titles;

    public Odertype_adapter(Context context,ArrayList<Sub_data> titles){
        this.context=context;
        this.titles=titles;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent,int viewtype){
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.order_type,parent,false);
        MyViewHolder myViewHolder=new MyViewHolder(v);
        return myViewHolder;
    }
    @Override
    public void onBindViewHolder(MyViewHolder holder,final int position){
        holder.names.setText(titles.get(position).name);

       // Picasso.with(context).load(items.get(position).images).into(holder.imageView);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,Location_activity.class);
                context.startActivity(intent);
            }
        });
    }
    public int getItemCount(){
        return titles.size();
    }

    public  class MyViewHolder extends RecyclerView.ViewHolder
    {

       // ImageView imageView;
        TextView names;
        public MyViewHolder(View itemView){
            super(itemView);

           names=(TextView)itemView.findViewById(R.id.odertype_text);
           // imageView=(ImageView)itemView.findViewById(R.id.titleimage);
        }
    }
}