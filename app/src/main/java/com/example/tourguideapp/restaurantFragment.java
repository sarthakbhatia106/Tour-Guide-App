package com.example.tourguideapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class restaurantFragment extends Fragment {


    public restaurantFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview=inflater.inflate(R.layout.item_list,container,false);

        final ArrayList<item> items= new ArrayList<item>();
        items.add(new item("Big Chill","Known For Italian food and desserts.","geo:0,0?q=Big Chill,B-40, Rajiv Chowk, Connaught Place, Delhi 110001"));
        items.add(new item("Bukhara Restaurant","7-time winner of the 'Restaurant Magazine Award' for being amongst the Best 50 Restaurants in the World & Best in Asia","geo:0,0?q=ITC Maurya, Sardar Patel Marg, Chanakyapuri, Delhi 110021"));
        items.add(new item("Sorrento", "Italian cuisine is that of the best ingredients prepared in an unpretentious manner; bold and satisfying without being too heavy","geo:0,0?q=Ground Level ShangriLa's Hotel, Ashoka Road, Connaught Place, New Delhi, Delhi 110001"));
        items.add(new item("Imly","Authentic street food with some quirky presentation from all across India under one roof, in a pleasant ambiance.","geo:0,0?q=Imly,F-20, T Sohanlal Marg, Near Hog Market, Rajendra Place, New Delhi, Delhi 110008"));
        items.add(new item("Ama Cafe","Known for its american breakfast and Cheese Cakes","geo:0,0?q=House No. 6, First Floor, Majnu Ka Tila, New Aruna Nagar, Delhi 110054"));
        items.add(new item("Wood Box Cafe","Rustic, wooden design cafe popular with students, serving Chinese, Italian & fast food.","geo:0,0?q=woodbox cafe, Huson Lane, Near Vijay Nagar, New Delhi, Delhi 110009"));
        items.add(new item("Diggin","One of the most beautiful looking cafe situated in Anand Lok, Delhi","geo:0,0?q=diggin,Anand Lok Shopping Center, Anand Lok, New Delhi, Delhi 110049"));
        items.add(new item("Karnataka Food Center","Bustling casual eatery with community tables offering traditional vegetarian South Indian cuisine.","geo:0,0?q=Karnataka Food Center, Sector 12, Rama Krishna Puram, New Delhi, Delhi 110022"));


        itemAdaptor adaptor= new itemAdaptor(getActivity(),items,R.color.restaurants);

        ListView listView= (ListView)rootview.findViewById(R.id.list);

        listView.setAdapter(adaptor);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                item idx= items.get(i);
                String coor= idx.getCoor();
                Uri gmmIntentUri = Uri.parse(coor);
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            }
        });
        return rootview;
    }
}
