package com.example.android.textplayer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class mySettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_settings);


        //Find the view that shows the colors category
        Button reverse = (Button) findViewById(R.id.reverse);

        //set a clickListener on that View
        reverse.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View view) {
                Intent reverseIntent = new Intent(com.example.android.textplayer.mySettingsActivity.this, MainActivity.class);

                //start the new activity
                startActivity(reverseIntent);
            }
        });

        //Find the view that shows the proper label
        Button lowerLeftButton = (Button) findViewById(R.id.eq_lower_left_button);

        //set a clickListener on that View
        lowerLeftButton.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View view) {
                Intent playlistIntent = new Intent(com.example.android.textplayer.mySettingsActivity.this, com.example.android.textplayer.playlist.class);

                //start the new activity
                startActivity(playlistIntent);
            }
        });

        //Find the view that shows the proper label
        Button lowerRightButton = (Button) findViewById(R.id.eq_lower_right_button);

        //set a clickListener on that View
        lowerRightButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent streamIntent = new Intent(com.example.android.textplayer.mySettingsActivity.this, com.example.android.textplayer.stream.class);


                //start the new activity
                startActivity(streamIntent);
            }
        });
    }
}
