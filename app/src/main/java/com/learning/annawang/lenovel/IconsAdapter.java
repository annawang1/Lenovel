package com.learning.annawang.lenovel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.mikepenz.iconics.view.IconicsTextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anna.Wang on 2017/7/27.
 * version: 1.0
 */

public class IconsAdapter extends BaseAdapter {

    private List<String> mList = new ArrayList<String>();

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public String getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    private Context mContext;

    public IconsAdapter(Context context) {

        this.mContext = context;

    }


    public void add(String icon) {

        mList.add(icon);
        notifyDataSetChanged();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        IconsHolder iconsHolder;
        if (null == convertView) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.layout_item_icon, parent, false);
            iconsHolder = new IconsHolder(convertView);
            convertView.setTag(iconsHolder);
        } else {
            iconsHolder = (IconsHolder) convertView.getTag();
        }
        iconsHolder.mItvIcon.setText(getItem(position));

        return convertView;
    }

    class IconsHolder {


        private IconicsTextView mItvIcon;

        IconsHolder(View view) {
            mItvIcon = (IconicsTextView) view.findViewById(R.id.itv_icon);
        }

    }


}
