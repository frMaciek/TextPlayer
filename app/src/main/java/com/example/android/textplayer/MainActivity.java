package com.example.android.textplayer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // setting proper TextView as release for toast message
        final Button forward = (Button) findViewById(R.id.forward_button);

        forward.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,
                        "this button will play next song", Toast.LENGTH_SHORT).show();
            }
        });

        final Button rewind = (Button) findViewById(R.id.rewind_button);

        rewind.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,
                        "this button will play previous song", Toast.LENGTH_SHORT).show();
            }
        });

        final Button play = (Button) findViewById(R.id.main_text);

        play.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,
                        "this button will play current song", Toast.LENGTH_SHORT).show();
            }
        });


        // Set the content of the activity to use the activity_main.xml layout file

        //Find the view that shows the colors category
        Button settings = (Button) findViewById(R.id.settings);

        //set a clickListener on that View
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent settingsIntent = new Intent(MainActivity.this, mySettingsActivity.class);

                //start the new activity
                startActivity(settingsIntent);
            }
        });

        //Find the view that shows the colors category
        Button playlist = (Button) findViewById(R.id.playlist);

        //set a clickListener on that View
        playlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent playlistIntent = new Intent(MainActivity.this, com.example.android.textplayer.playlist.class);

                //start the new activity
                startActivity(playlistIntent);
            }
        });

        //Find the view that shows the colors category
        final Button equalizer = (Button) findViewById(R.id.equalizer);

        //set a clickListener on that View
        equalizer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent equalizerIntent = new Intent(MainActivity.this, com.example.android.textplayer.equalizer.class);

                //start the new activity
                startActivity(equalizerIntent);
            }
        });

        //Find the view that shows the colors category
        Button stream = (Button) findViewById(R.id.stream);

        //set a clickListener on that View
        stream.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent streamIntent = new Intent(MainActivity.this, com.example.android.textplayer.stream.class);

                //start the new activity
                startActivity(streamIntent);
            }
        });


    }

}
