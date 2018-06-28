package com.example.sriven.second;


import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by sriven on 3/27/2018.
 */

public class Recycler_adapter extends RecyclerView.Adapter<Recycler_adapter.MyViewHolder> {
    Context context;
    ArrayList<Data> items;

    public Recycler_adapter(Context context,ArrayList<Data> items){
        this.context=context;
        this.items=items;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent,int viewtype){
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view,parent,false);
        MyViewHolder myViewHolder=new MyViewHolder(v);
        return myViewHolder;
    }
    @Override
    public void onBindViewHolder(MyViewHolder holder,final int position){
        holder.name.setText(items.get(position).title);
        Picasso.with(context).load(items.get(position).images).into(holder.imageView);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent;
                intent =  new Intent(context, Order_type.class);
               intent.putExtra("service",items.get(position));
                context.startActivity(intent);

            }

        });

    }
    public int getItemCount(){
        return items.size();
    }

    public  class MyViewHolder extends RecyclerView.ViewHolder
    {

        ImageView imageView;
        TextView name;
        public MyViewHolder(View itemView){
            super(itemView);

            name=(TextView)itemView.findViewById(R.id.titles);
            imageView=(ImageView)itemView.findViewById(R.id.titleimage);
        }
    }
}