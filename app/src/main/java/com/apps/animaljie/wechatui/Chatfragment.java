package com.apps.animaljie.wechatui;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by animaljie on 2017/7/21.
 */


public class Chatfragment extends android.support.v4.app.Fragment {


    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable final ViewGroup container, Bundle savedInstanceState) {
        //return inflater.inflate(R.layout.tab1, container, false);

        List<Itembean> itembeanList=new ArrayList<>();
        for (int i=0;i<20;i++){
            itembeanList.add(new Itembean(R.mipmap.image,"联系人"+i,"2017-7-"+(i+1),"你有"+i+"条新消息"));
        }


        View view=inflater.inflate(R.layout.tab1,null);
        RefreshLayout refreshLayout= (RefreshLayout) view.findViewById(R.id.refresh);
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                refreshlayout.finishRefresh(2000);
            }
        });
        refreshLayout.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                refreshlayout.finishLoadmore(2000);
            }
        });
        ListView listView= (ListView) view.findViewById(R.id.lv_tab1);
        listView.setAdapter(new MyBaseAdapter(getActivity(),itembeanList));
        return view;
    }

}


