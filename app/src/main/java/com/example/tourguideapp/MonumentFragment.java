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

public class MonumentFragment extends Fragment {


    public MonumentFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview=inflater.inflate(R.layout.item_list,container,false);

        final ArrayList<item> items= new ArrayList<item>();
        items.add(new item("India Gate","The India Gate is a war memorial located astride the Rajpath","geo:0,0?q=Rajpath, India Gate, New Delhi, Delhi 110001"));
        items.add(new item("Qutab Minar","Qutab Minar is a minaret that forms part of the Qutb complex, a UNESCO World Heritage Site","geo:0,0?q=Qutab Minar,Seth Sarai, Mehrauli, New Delhi, Delhi 110030"));
        items.add(new item("Lotus Temple", "Lotus Temple is a Baháʼí House of Worship that was dedicated in December 1986.","geo:0,0?q=Lotus Temple, Lotus Temple Rd, Bahapur, Shambhu Dayal Bagh, Kalkaji, New Delhi, Delhi 110019"));
        items.add(new item("War Memorial","War memorial is spread over 40 acres of land and is built around the existing chhatri near India Gate","geo:0,0?q=C - Hexagon, India Gate, New Delhi, Delhi 110001"));
        items.add(new item("Jantar Mantar","The Jantar Mantar is an equinoctial sundial, consisting of a gigantic triangular gnomon with the hypotenuse parallel to the Earth's axis","geo:0,0?q=Jantar Mantar,Connaught Place, Sansad Marg, New Delhi, Delhi 110001"));
        items.add(new item("Red Fort","The Red Fort is a historic fort in the city of Delhi (in Old Delhi) in India that served as the main residence of the Mughal Emperors","geo:0,0?q=Red Fort,Netaji Subhash Marg, Lal Qila, Chandni Chowk, New Delhi, Delhi 110006"));
        items.add(new item("Jama Masjid","The Masjid-i Jehan Numa commonly known as the Jama Masjid of Delhi, is one of the largest mosques in India","geo:0,0?q=Jama Masjid,Jama Masjid Rd, Chandni Chowk, New Delhi, Delhi 110006"));
        items.add(new item("Lodhi Garden","Lodi Gardens is a city park situated in New Delhi, India , spread over 90 acres","geo:0,0?q=Lodhi Rd, Lodhi Gardens, Lodhi Estate, New Delhi, Delhi 110003"));


        itemAdaptor adaptor= new itemAdaptor(getActivity(),items,R.color.monuments);

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