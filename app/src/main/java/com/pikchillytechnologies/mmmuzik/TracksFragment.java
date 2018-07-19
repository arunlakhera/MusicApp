package com.pikchillytechnologies.mmmuzik;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

public class TracksFragment extends Fragment {

    GridView simpleGrid;
    int tracks[] = {R.drawable.img1};

    public TracksFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tracks, container, false);

        simpleGrid = view.findViewById(R.id.tracksGridView); // init GridView
        // Create an object of CustomAdapter and set Adapter to GirdView
        GenreAdapter genreAdapter = new GenreAdapter(getActivity(), tracks);
        simpleGrid.setAdapter(genreAdapter);
        // implement setOnItemClickListener event on GridView
        simpleGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // set an Intent to Another Activity
                Intent intent = new Intent(getContext(), PlayerActivity.class);
                intent.putExtra("image", tracks[position]); // put image data in Intent
                startActivity(intent); // start Intent
            }
        });
        return view;
    }

}
