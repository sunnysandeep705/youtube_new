package com.example.sriven.second;


import android.content.Context;
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
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.myfavorites,parent,false);
        MyViewHolder myViewHolder=new MyViewHolder(v);
        return myViewHolder;
    }
    @Override
    public void onBindViewHolder(MyViewHolder holder,final int position){
      //  holder.name.setText(items.get(position).title);
        holder.username.setText(items.get(position).username);
        holder.address.setText(items.get(position).address);
        holder.distance.setText(items.get(position).distance);
        holder.worktype.setText(items.get(position).worktype);
        holder.wage.setText(items.get(position).wage);
        holder.ratings.setText(items.get(position).ratings);
        Picasso.with(context).load(items.get(position).images_).into(holder.imageView);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,items.get(position).username,Toast.LENGTH_SHORT).show();

             /*  for (int i=0;i<=position;i++) {
                    final Intent intent;
                        intent = new Intent(context, Order_type.class);

                    context.startActivity(intent);
                }*/
            }
        });
    }
    public int getItemCount(){
        return items.size();
    }

    public  class MyViewHolder extends RecyclerView.ViewHolder
    {

        ImageView imageView;
        TextView distance,username,address,ratings,wage,worktype;
        public MyViewHolder(View itemView){
            super(itemView);

           // name=(TextView)itemView.findViewById(R.id.titles);
            imageView=(ImageView)itemView.findViewById(R.id.circularimage_view);
            username=(TextView)itemView.findViewById(R.id.login_usrname);
            address=(TextView)itemView.findViewById(R.id.address_);
            ratings=(TextView)itemView.findViewById(R.id.ratings);
            distance=(TextView)itemView.findViewById(R.id.distance);
            wage=(TextView)itemView.findViewById(R.id.wage_);
            worktype=(TextView)itemView.findViewById(R.id.work_type);

        }
    }
}