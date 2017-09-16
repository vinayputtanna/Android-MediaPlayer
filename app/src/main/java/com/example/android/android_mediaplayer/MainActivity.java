package com.example.android.android_mediaplayer;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // create MediaPlayer object and set the music file to be played from res\raw folder
        mediaPlayer=MediaPlayer.create(this, R.raw.shuffle);

        final Button playButton=(Button)findViewById(R.id.play);
        final Button pauseButton=(Button)findViewById(R.id.pause);
        final Button seekButton=(Button)findViewById(R.id.seek);

        /**
         * Set OnClickListener interface on play button
         */
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.start();
                playButton.setEnabled(false);
                pauseButton.setEnabled(true);
                seekButton.setEnabled(true);
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        Toast.makeText(MainActivity.this, "Song completed!", Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });

        /**
         * Set OnClickListener interface on pause button
         */
        pauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.pause();
                playButton.setEnabled(true);
                pauseButton.setEnabled(false);
                seekButton.setEnabled(false);

            }
        });

        /**
         * Set OnClickListener interface on seek button
         */
        seekButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.seekTo(mediaPlayer.getDuration()/2);
                playButton.setEnabled(false);
                pauseButton.setEnabled(true);
            }
        });
    }

}
