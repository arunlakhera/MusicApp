package com.pikchillytechnologies.mmmuzik;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class TracksAdapter extends BaseAdapter {
    Context context;
    int tracks[];
    LayoutInflater inflter;

    public TracksAdapter(Context applicationContext, int[] tracks) {
        this.context = applicationContext;
        this.tracks = tracks;
        inflter = (LayoutInflater.from(applicationContext));
    }
    @Override
    public int getCount() {
        return tracks.length;
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
        icon.setImageResource(tracks[i]); // set logo images
        return view;
    }
}
