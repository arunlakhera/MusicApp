package com.pikchillytechnologies.mmmuzik;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class ArtistAdapter extends BaseAdapter {

    Context context;
    int artists[];
    LayoutInflater inflter;

    public ArtistAdapter(Context applicationContext, int[] artists) {
        this.context = applicationContext;
        this.artists = artists;
        inflter = (LayoutInflater.from(applicationContext));
    }

    @Override
    public int getCount() {
        return artists.length;
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
        view = inflter.inflate(R.layout.music_gridview, null); // inflate the layout
        ImageView icon = view.findViewById(R.id.iconAlbum); // get the reference of ImageView
        icon.setImageResource(artists[i]); // set logo images
        return view;
    }
}
