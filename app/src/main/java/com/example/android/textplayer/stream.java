package com.example.android.textplayer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class stream extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stream);

        //Find the view that shows the colors category
        TextView reverse = (TextView) findViewById(R.id.reverse);

        //set a clickListener on that View
        reverse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent reverseIntent = new Intent(com.example.android.textplayer.stream.this, MainActivity.class);

                //start the new activity
                startActivity(reverseIntent);
            }
        });

        //Find the view that shows the proper label
        TextView lowerLeftButton = (TextView) findViewById(R.id.st_lower_left_button);

        //set a clickListener on that View
        lowerLeftButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent equalizerIntent = new Intent(com.example.android.textplayer.stream.this, com.example.android.textplayer.playlist.class);

                //start the new activity
                startActivity(equalizerIntent);
            }
        });

        //Find the view that shows the proper label
        TextView lowerRightButton = (TextView) findViewById(R.id.st_lower_right_button);

        //set a clickListener on that View
        lowerRightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent equalizerIntent = new Intent(com.example.android.textplayer.stream.this, com.example.android.textplayer.equalizer.class);

                //start the new activity
                startActivity(equalizerIntent);
            }
        });

    }
}
