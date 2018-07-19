package com.pikchillytechnologies.mmmuzik;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;

public class MusicActivity extends AppCompatActivity {

    FrameLayout simpleFrameLayout;
    TabLayout tabLayout;
    Integer tabPosition = 0;
    Boolean genreFlag;
    Boolean albumFlag;
    Boolean artistFlag;
    Boolean tracksFlag;

    Bundle tabBundle;

    TabLayout.Tab genreTab;
    TabLayout.Tab albumTab;
    TabLayout.Tab artistTab;
    TabLayout.Tab TracksTab;
    ImageButton homeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);

        tabBundle = getIntent().getExtras();

        genreFlag = Boolean.valueOf(tabBundle.getString("genre","false"));
        albumFlag = Boolean.valueOf(tabBundle.getString("album","false"));
        artistFlag = Boolean.valueOf(tabBundle.getString("artist","false"));
        tracksFlag = Boolean.valueOf(tabBundle.getString("tracks","false"));

        // get the reference of FrameLayout and TabLayout
        simpleFrameLayout = findViewById(R.id.musicFrameLayout);
        tabLayout = findViewById(R.id.musicTabLayout);
        homeButton = findViewById(R.id.button_Home);

        // Create a new Tab named "Genre"
        genreTab = tabLayout.newTab();
        genreTab.setText("Genre"); // set the Text for the Genre Tab
        tabLayout.addTab(genreTab); // add  the tab at in the TabLayout

        // Create a new Tab named "Album"
        albumTab = tabLayout.newTab();
        albumTab.setText("Album"); // set the Text for the Album Tab
        tabLayout.addTab(albumTab); // add  the tab at in the TabLayout

        // Create a new Tab named "Artist"
        artistTab = tabLayout.newTab();
        artistTab.setText("Artist"); // set the Text for the Artist Tab
        tabLayout.addTab(artistTab); // add  the tab  in the TabLayout

        // Create a new Tab named "Tracks"
        TracksTab = tabLayout.newTab();
        TracksTab.setText("Tracks"); // set the Text for the Tracks Tab
        tabLayout.addTab(TracksTab); // add  the tab at in the TabLayout

        // Check which Tab was selected and highlight it
        if(genreFlag){
            tabPosition = 0;
            openTab(tabPosition);
            genreTab.select();

        }else if(albumFlag){
            tabPosition = 1;
            openTab(tabPosition);
            albumTab.select();
        }else if(artistFlag){
            tabPosition = 2;
            openTab(tabPosition);
            artistTab.select();
        }else if(tracksFlag){
            tabPosition = 3;
            openTab(tabPosition);
            TracksTab.select();
        }

        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MusicActivity.this, MainActivity.class));
            }
        });

        // perform setOnTabSelectedListener event on TabLayout
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                tabPosition = tab.getPosition();
                openTab(tabPosition);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    public void openTab(Integer tabPosition){

        // get the current selected tab's position and replace the fragment accordingly
        Fragment fragment = null;

        switch (tabPosition) {
            case 0:
                fragment = new GenreFragment();
                break;
            case 1:
                fragment = new AlbumFragment();
                break;
            case 2:
                fragment = new ArtistFragment();
                break;
            case 3:
                fragment = new TracksFragment();
                break;
        }

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.musicFrameLayout, fragment);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        ft.commit();
    }

}
