package com.pikchillytechnologies.mmmuzik;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

public class GenreFragment extends Fragment {

    GridView simpleGrid;
    int genre[] = {R.drawable.img1, R.drawable.img2, R.drawable.img3};

    public GenreFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_genre, container, false);

        simpleGrid = view.findViewById(R.id.genreGridView); // init GridView
        // Create an object of CustomAdapter and set Adapter to GirdView
        GenreAdapter genreAdapter = new GenreAdapter(getActivity(), genre);
        simpleGrid.setAdapter(genreAdapter);
        // implement setOnItemClickListener event on GridView
        simpleGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // set an Intent to Another Activity
                Intent intent = new Intent(getContext(), PlayerActivity.class);
                intent.putExtra("image", genre[position]); // put image data in Intent
                startActivity(intent); // start Intent
            }
        });
        return view;
    }
}