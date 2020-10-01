package com.example.tourguideapp;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;

public class itemAdaptor extends ArrayAdapter<item> {

    private int mcolourId;

    public itemAdaptor(Context context, ArrayList<item> items, int colour){
        super(context,0,items);
        mcolourId=colour;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View itemView=convertView;
        if(itemView==null){
            itemView= LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);
        }
        final item currentItem= getItem(position);

        TextView name=(TextView)itemView.findViewById(R.id.name);
        name.setText(currentItem.getName());

        TextView address= (TextView)itemView.findViewById(R.id.address);
        address.setText(currentItem.getAdd());

        View textContainer= itemView.findViewById(R.id.textContainer);
        int color= ContextCompat.getColor(getContext(),mcolourId);
        textContainer.setBackgroundColor(color);

        return itemView;

    }
}
