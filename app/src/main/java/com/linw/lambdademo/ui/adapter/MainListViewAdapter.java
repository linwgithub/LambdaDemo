package com.linw.lambdademo.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.linw.lambdademo.R;

import java.util.ArrayList;

/**
 * 作者: linw
 * 时间: 16/5/30
 * 内容:
 */
public class MainListViewAdapter extends BaseAdapter {

    private LayoutInflater layoutInflater;
    private ArrayList<String> labelStrs;

    public MainListViewAdapter(Context context, ArrayList<String> labelStrs) {
        this.layoutInflater = LayoutInflater.from(context);
        this.labelStrs = labelStrs;
    }

    @Override
    public int getCount() {
        return labelStrs.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        TextView label;
        if (view == null) {
            view = layoutInflater.inflate(R.layout.item_main_list, null);
            label = (TextView) view.findViewById(R.id.tv_item_main_list);
            view.setTag(label);
        } else {
            label = (TextView) view.getTag();
        }

        label.setText(labelStrs.get(i));
        return view;
    }
}
