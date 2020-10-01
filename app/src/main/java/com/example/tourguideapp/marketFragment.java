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

public class marketFragment extends Fragment {


    public marketFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview=inflater.inflate(R.layout.item_list,container,false);

        final ArrayList<item> items= new ArrayList<item>();
        items.add(new item("Kamla Nagar","Situated next to the North Campus of Delhi University, Kamla Nagar is a lively market and a popular hang-out for college students.","geo:0,0?q=Kamla Nagar, Clock Tower, Delhi- 110007"));
        items.add(new item("Sarojini Nagar","Very famous for road side flea market with top and local brands Shopping tour in Delhi","geo:0,0?q=Sarojini Nagar Market,New Delhi, Delhi- 110023"));
        items.add(new item("Karol Bagh", "A blend of residence and market, every morning the famous market of Delhi opens up to thousands of shoppers looking for a good deal on their purchase","geo:0,0?q=Karol Bagh,New Delhi, Delhi- 110060"));
        items.add(new item("Chandni Chowk","Busy, historic bazaar with clothing, housewares & hardware shops, plus restaurants & snack stalls.","geo:0,0?q=Nai Sadak, Roshanpura, Old Delhi, Delhi- 110007"));
        items.add(new item("Rajouri Garden","Rajouri Garden market is where you’ll find affordable and awesome finds","geo:0,0?q=Rajouri Garden,New Delhi, Delhi- 110027"));
        items.add(new item("Khan Market"," Khan market is much more organized and cleaner than local markets.","geo:0,0?q=Khan Market,Rabindra Nagar, New Delhi, Delhi- 110003"));
        items.add(new item("Janpath","This centrally located market is a hub for traditional as well as authentic clothing","geo:0,0?q=Janpath Rd, Connaught Place, Delhi- 110001"));
        items.add(new item("Lajpat Nagar","Great range of all sorts of indian wear,accesories, kurtas,suits,shoes.","geo:0,0?q=Lajpat Nagar Market,Lajpat Nagar, Delhi- 110024"));
        items.add(new item("Palika Bazar","Palika Bazaar, is an underground market located between the inner and outer circle of Connaught Place","geo:0,0?q=Palika Bazar, Connaught Place, Delhi- 110001"));
        items.add(new item("INA Market","The market is one of the oldest surviving market in Delhi and rightly so, the market offers the best quality products.","geo:0,0?q=INA Market, Delhi- 110023"));


        itemAdaptor adaptor= new itemAdaptor(getActivity(),items,R.color.markets);

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