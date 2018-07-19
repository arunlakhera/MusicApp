package com.pikchillytechnologies.mmmuzik;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView_GenreAll;
    TextView textView_AlbumsAll;
    TextView textView_ArtistsAll;
    TextView textView_TracksAll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView_GenreAll = findViewById(R.id.textView_GenreAll);
        textView_AlbumsAll = findViewById(R.id.textView_AlbumsAll);
        textView_ArtistsAll = findViewById(R.id.textView_ArtistsAll);
        textView_TracksAll = findViewById(R.id.textView_TracksAll);

        textView_GenreAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent genreAllIntent = new Intent(MainActivity.this, MusicActivity.class);
                genreAllIntent.putExtra("genre", "true");
                genreAllIntent.putExtra("album", "false");
                genreAllIntent.putExtra("artist", "false");
                genreAllIntent.putExtra("tracks", "false");
                startActivity(genreAllIntent);
            }
        });

        textView_AlbumsAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent genreAllIntent = new Intent(MainActivity.this, MusicActivity.class);
                genreAllIntent.putExtra("genre", "false");
                genreAllIntent.putExtra("album", "true");
                genreAllIntent.putExtra("artist", "false");
                genreAllIntent.putExtra("tracks", "false");
                startActivity(genreAllIntent);
            }
        });

        textView_ArtistsAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent genreAllIntent = new Intent(MainActivity.this, MusicActivity.class);
                genreAllIntent.putExtra("genre", "false");
                genreAllIntent.putExtra("album", "false");
                genreAllIntent.putExtra("artist", "true");
                genreAllIntent.putExtra("tracks", "false");
                startActivity(genreAllIntent);
            }
        });

        textView_TracksAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent genreAllIntent = new Intent(MainActivity.this, MusicActivity.class);
                genreAllIntent.putExtra("genre", "false");
                genreAllIntent.putExtra("album", "false");
                genreAllIntent.putExtra("artist", "false");
                genreAllIntent.putExtra("tracks", "true");
                startActivity(genreAllIntent);
            }
        });


    }
}
