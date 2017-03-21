package com.project.umang.filterlist;

import android.app.Activity;
import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by UMANG on 11/11/2016.
 */
public class customadapter extends ArrayAdapter<listcomp>{


    public  customadapter(Context ctx,int res, ArrayList<listcomp> list1)
    {
        super(ctx,res,list1);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.listcomp, parent, false);
        }

        listcomp object = getItem(position);

        ImageView imm = (ImageView)convertView.findViewById(R.id.imm);
        imm.setImageResource(object.getim());

        TextView text = (TextView)convertView.findViewById(R.id.textView);
        text.setText(object.gettext1());

        TextView text2 = (TextView)convertView.findViewById(R.id.textView2);
        text2.setText(object.gettext2());
        return convertView;
    }
}
