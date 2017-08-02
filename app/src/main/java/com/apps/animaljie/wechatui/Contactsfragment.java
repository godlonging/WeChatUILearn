package com.apps.animaljie.wechatui;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by animaljie on 2017/7/21.
 */

public class Contactsfragment extends android.support.v4.app.Fragment {


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        //return inflater.inflate(R.layout.tab2,container,false);
        final List<Itembean_tab2> itembean_tab2List=new ArrayList<>();
        for (int i='A';i<='z';i++){
            itembean_tab2List.add(new Itembean_tab2(R.mipmap.tab2_icon,""+(char)i));
        }
        View view=inflater.inflate(R.layout.tab2,null);
        RecyclerView recyclerView= (RecyclerView) view.findViewById(R.id.recyclerview_tab2);
        RecyclerView.Adapter rececyleradapter=new MyRecyclerAdapter(this.getActivity(),itembean_tab2List);
        recyclerView.setAdapter(rececyleradapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity(),LinearLayoutManager.VERTICAL,false));
        return view;
    }
}
