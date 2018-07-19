package com.pikchillytechnologies.mmmuzik;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class PlayerActivity extends AppCompatActivity {

    ImageView selectedImage;
    ImageButton homeButton;
    ImageButton backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        selectedImage = findViewById(R.id.selectedImage); // init a ImageView
        Intent intent = getIntent(); // get Intent which we set from Previous Activity
        selectedImage.setImageResource(intent.getIntExtra("image", 0)); // get image from Intent and set it in ImageView

        homeButton = findViewById(R.id.button_Home);
        backButton = findViewById(R.id.button_Back);

        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PlayerActivity.this, MainActivity.class));
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backIntent = new Intent(PlayerActivity.this, MusicActivity.class);
                backIntent.putExtra("genre","true");
                backIntent.putExtra("album","true");
                backIntent.putExtra("artist","true");
                backIntent.putExtra("tracks","true");
                startActivity(backIntent);
            }
        });
    }
}
