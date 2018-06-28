package com.example.sriven.second;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by sriven on 4/24/2018.
 */

public class Myfavorites_fragment extends Fragment {
    ArrayList<Oders_data> oders_data=new ArrayList<Oders_data>();

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup group, Bundle savedinstance){
        View view=inflater.inflate(R.layout.orders_layout,group,false);

         oders_data.add(new Oders_data("https://res.cloudinary.com/hlkdbdswu/image/upload/v1525129044/Services/icons/Photography.png","257","ssss","vijayawada","4.1","23$/hour","Carpenter"));
        oders_data.add(new Oders_data("https://res.cloudinary.com/hlkdbdswu/image/upload/v1525129044/Services/icons/Photography.png","2447","tttt","vijayawada","4.5","29$/hour","Mechanic"));
        oders_data.add(new Oders_data("https://res.cloudinary.com/hlkdbdswu/image/upload/v1525129044/Services/icons/Photography.png","53","ooo","vijayawada","3.1","15$/hour","Carpenter"));
        oders_data.add(new Oders_data("https://res.cloudinary.com/hlkdbdswu/image/upload/v1525129044/Services/icons/Photography.png","257","ssss","vijayawada","4.1","23$/hour","Carpenter"));
        RecyclerView recyclerView=(RecyclerView)view.findViewById(R.id.oder_recycler);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        // recyclerView.findViewHolderForAdapterPosition(pos);

        final  Oderdetails_adapter odertype_adapter=new Oderdetails_adapter(getContext(),oders_data);
        recyclerView.setAdapter(odertype_adapter);

        return view;

    }
    public Myfavorites_fragment(){}
}
