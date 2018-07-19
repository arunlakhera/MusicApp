package com.pikchillytechnologies.mmmuzik;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class AlbumFragment extends Fragment {

    GridView simpleGrid;
    int albums[] = {R.drawable.img1, R.drawable.img2, R.drawable.img3, R.drawable.img4,
            R.drawable.img1, R.drawable.img3, R.drawable.img2, R.drawable.img4};

    public AlbumFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_album, container, false);

        simpleGrid = view.findViewById(R.id.albumGridView); // init GridView
        // Create an object of CustomAdapter and set Adapter to GirdView
        AlbumAdapter albumAdapter = new AlbumAdapter(getActivity(), albums);
        simpleGrid.setAdapter(albumAdapter);
        // implement setOnItemClickListener event on GridView
        simpleGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // set an Intent to Another Activity
                Intent intent = new Intent(getContext(), PlayerActivity.class);
                intent.putExtra("image", albums[position]); // put image data in Intent
                startActivity(intent); // start Intent
            }
        });
        return view;
    }
}
