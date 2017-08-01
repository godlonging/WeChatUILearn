package com.apps.animaljie.wechatui;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by animaljie on 2017/7/31.
 */

public class MyBaseAdapter extends BaseAdapter {
    private List<Itembean> mlist;
    //先要创建layoutinflate对象，才能使用inflate方法
    private LayoutInflater inflater;


     public  MyBaseAdapter(Context context,List<Itembean> list){
             mlist=list;
             inflater=LayoutInflater.from(context);
         }
    @Override
    public int getCount() {
        return mlist.size();
    }

    @Override
    public Object getItem(int position) {
        return mlist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView==null){
            convertView=inflater.inflate(R.layout.listview_tab1,null);
            viewHolder =new ViewHolder();
            viewHolder.imageView=(ImageView)convertView.findViewById(R.id.image_list);
            viewHolder.name=(TextView)convertView.findViewById(R.id.name);
            viewHolder.time=(TextView)convertView.findViewById(R.id.times);
            viewHolder.meaasge=(TextView)convertView.findViewById(R.id.message);
            convertView.setTag(viewHolder);
        }else {
            viewHolder=(ViewHolder) convertView.getTag();
        }
        Itembean bean=mlist.get(position);
        viewHolder.imageView.setImageResource(bean.item_imageresid);
        viewHolder.name.setText(bean.item_name);
        viewHolder.time.setText(bean.item_time);
        viewHolder.meaasge.setText(bean.item_message);
        return convertView;
    }
    class ViewHolder{
        public ImageView imageView;
        public TextView name;
        public TextView time;
        public TextView meaasge;
    }
}
