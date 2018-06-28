package com.example.sriven.e_orders;


import android.content.Context;
import android.content.Intent;
import android.support.design.widget.BottomSheetDialog;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.wonderkiln.blurkit.BlurLayout;

import java.util.ArrayList;

/**
 * Created by sriven on 3/27/2018.
 */

public class Recycler_adapter extends RecyclerView.Adapter<Recycler_adapter.MyViewHolder> {
    Context context;
    ArrayList<Oders_data> items;
PopupWindow popupWindow;
BlurLayout blurLayout;
    public Recycler_adapter(Context context, ArrayList<Oders_data> items){
        this.context=context;
        this.items=items;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent,int viewtype){
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.order_details,parent,false);

        blurLayout = (BlurLayout)v.findViewById(R.id.blurlayout);
        MyViewHolder myViewHolder=new MyViewHolder(v);

        return myViewHolder;
    }
    @Override
    public void onBindViewHolder(MyViewHolder holder,final int position){
        holder.name.setText(items.get(position).usernames);
        holder.email.setText(items.get(position).emails);
        holder.dates.setText(items.get(position).date);
        Picasso.with(context).load(items.get(position).images_).into(holder.imageView);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popup();
            }

        });

    }
    public int getItemCount(){
        return items.size();
    }

    public  class MyViewHolder extends RecyclerView.ViewHolder
    {

        ImageView imageView;
        TextView name,dates,email;
        public MyViewHolder(View itemView){
            super(itemView);

            name=(TextView)itemView.findViewById(R.id.usr_name);
            email=(TextView)itemView.findViewById(R.id.email_ofoder);
            dates=(TextView)itemView.findViewById(R.id.date_ofoder) ;
            imageView=(ImageView)itemView.findViewById(R.id.circularimageview);
        }
    }
    public void popup(){
       // blurLayout.setVisibility(View.VISIBLE);
        LayoutInflater inflater = (LayoutInflater)this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.details_of_oder_with_image, null);
        /*popupWindow = new PopupWindow(view, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow.showAsDropDown(view, Gravity.BOTTOM, 100, 0);
        ImageView close=(ImageView)view.findViewById(R.id.uploaded_image);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popupWindow.dismiss();
            }
        });
        popupWindow.update();*/

        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(context);
        bottomSheetDialog.setContentView(view);
        bottomSheetDialog.show();
    }
}