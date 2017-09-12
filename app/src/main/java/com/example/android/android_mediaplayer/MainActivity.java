package com.example.android.android_mediaplayer;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mediaPlayer=MediaPlayer.create(this, R.raw.shuffle);

        final Button playButton=(Button)findViewById(R.id.play);
        final Button pauseButton=(Button)findViewById(R.id.pause);
        final Button seekButton=(Button)findViewById(R.id.seek);
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.start();
                playButton.setEnabled(false);
                pauseButton.setEnabled(true);

            }
        });


        pauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.pause();
                playButton.setEnabled(true);
                pauseButton.setEnabled(false);

            }
        });

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
