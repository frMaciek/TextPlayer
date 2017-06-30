package com.example.android.textplayer;

import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnBufferingUpdateListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import java.io.IOException;

public class stream extends AppCompatActivity implements View.OnClickListener {

    //Defininition of variable needed for stream
    private ProgressBar playSeekBar;

    private Button buttonPlay;

    private Button buttonStopPlay;

    private MediaPlayer player;
    //End of definiton

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stream);

        //Find the view that shows the colors category
        Button reverse = (Button) findViewById(R.id.reverse);

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
        Button lowerLeftButton = (Button) findViewById(R.id.st_lower_left_button);

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
        Button lowerRightButton = (Button) findViewById(R.id.st_lower_right_button);

        //set a clickListener on that View
        lowerRightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent equalizerIntent = new Intent(com.example.android.textplayer.stream.this, com.example.android.textplayer.equalizer.class);

                //start the new activity
                startActivity(equalizerIntent);
            }
        });

        //Begin code of stream function
        initializeUIElements();

        initializeMediaPlayer();

    }

    //code responsible for UI elements
    private void initializeUIElements() {

        playSeekBar = (ProgressBar) findViewById(R.id.progressBar1);
        playSeekBar.setMax(100);
        playSeekBar.setVisibility(View.INVISIBLE);

        buttonPlay = (Button) findViewById(R.id.buttonPlay);
        buttonPlay.setOnClickListener(this);

        buttonStopPlay = (Button) findViewById(R.id.buttonStopPlay);
        buttonStopPlay.setEnabled(false);
        buttonStopPlay.setOnClickListener(this);

    }

    public void onClick(View v) {
        if (v == buttonPlay) {
            startPlaying();
        } else if (v == buttonStopPlay) {
            stopPlaying();
        }
    }

    private void startPlaying() {
        buttonStopPlay.setEnabled(true);
        buttonPlay.setEnabled(false);

        playSeekBar.setVisibility(View.VISIBLE);

        player.prepareAsync();

        player.setOnPreparedListener(new OnPreparedListener() {

            public void onPrepared(MediaPlayer mp) {
                player.start();
            }
        });

    }

    private void stopPlaying() {
        if (player.isPlaying()) {
            player.stop();
            player.release();
            initializeMediaPlayer();
        }

        buttonPlay.setEnabled(true);
        buttonStopPlay.setEnabled(false);
        playSeekBar.setVisibility(View.INVISIBLE);
    }

    private void initializeMediaPlayer() {
        player = new MediaPlayer();
        try {
            player.setDataSource("http://15903.live.streamtheworld.com/WFFRFM.mp3");
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        player.setOnBufferingUpdateListener(new OnBufferingUpdateListener() {

            public void onBufferingUpdate(MediaPlayer mp, int percent) {
                playSeekBar.setSecondaryProgress(percent);
                Log.i("Buffering", "" + percent);
            }
        });


    }

    @Override
    protected void onPause() {
        super.onPause();
        if (player.isPlaying()) {
            player.stop();
        }
    }
}