package com.xumengran.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Administrator on 2020/07/10.
 */

public class MyAdapter extends BaseAdapter {

    private List<Student> mlist;
    private Context mcontext;

    private LayoutInflater layoutInflater;

    public MyAdapter(Context context,List<Student> mlist){
        this.mcontext=context;
        this.mlist=mlist;
        layoutInflater=LayoutInflater.from(context);
    }


    @Override
    public int getCount() {
        return mlist.size();
    }

    @Override
    public Object getItem(int i) {
        return mlist.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view==null){
            viewHolder=new ViewHolder();
            view=layoutInflater.inflate(R.layout.item,null);
            viewHolder.textView1=(TextView) view.findViewById(R.id.tv1);
            viewHolder.textView2=(TextView) view.findViewById(R.id.tv2);
            viewHolder.textView3=(TextView) view.findViewById(R.id.tv3);
            view.setTag(viewHolder);
        }else {
            viewHolder= (ViewHolder) view.getTag();
        }
        //从list取出对象
        Student bean=mlist.get(i);
        //设置item的内容
        viewHolder.textView1.setText(bean.getName());
        viewHolder.textView2.setText(bean.getAddress());
        viewHolder.textView3.setText(bean.getAge()+"");
        return view;
    }

    public class ViewHolder{
       public TextView textView1,textView2,textView3;
    }
}
