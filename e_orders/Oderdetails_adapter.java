package com.example.sriven.e_orders;


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

public class Oderdetails_adapter extends RecyclerView.Adapter<Oderdetails_adapter.MyViewHolder> {
    Context context;
    ArrayList<Oders_data> items;

    public Oderdetails_adapter(Context context, ArrayList<Oders_data> items){
        this.context=context;
        this.items=items;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent,int viewtype){
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.order_details,parent,false);
        MyViewHolder myViewHolder=new MyViewHolder(v);
        return myViewHolder;
    }
    @Override
    public void onBindViewHolder(MyViewHolder holder,final int position){
      //  holder.name.setText(items.get(position).title);
        holder.username.setText(items.get(position).usernames);
        holder.email.setText(items.get(position).emails);
        holder.dates.setText(items.get(position).date);
        Picasso.with(context).load(items.get(position).images_).into(holder.imageView);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,items.get(position).usernames,Toast.LENGTH_SHORT).show();
                final Intent intent;
                if (position==0){

                }
                else {

                }

            }
        });
    }
    public int getItemCount(){
        return items.size();
    }

    public  class MyViewHolder extends RecyclerView.ViewHolder
    {

        ImageView imageView;
        TextView name,username,email,dates;
        public MyViewHolder(View itemView){
            super(itemView);

           // name=(TextView)itemView.findViewById(R.id.titles);
            imageView=(ImageView)itemView.findViewById(R.id.circularimageview);
            username=(TextView)itemView.findViewById(R.id.usr_name);
            email=(TextView)itemView.findViewById(R.id.email);
            dates=(TextView)itemView.findViewById(R.id.date);

        }
    }
}