package com.example.sourabh.playmusicexample;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mediaPlayer = MediaPlayer.create(this,R.raw.smile);  //Creating a new media
    }

    //When app close or pause media should be stopped
    @Override
    protected void onPause() {
        mediaPlayer.stop();
        super.onPause();
    }

    //isPalying():Checks whether the MediaPlayer is playing.
    public void play(View view)
    {
        //Restart or recreate the whole media when play button pressed
        if (mediaPlayer.isPlaying()) mediaPlayer.stop();  //First stop if media is playing then recreate media and then start again
        mediaPlayer = MediaPlayer.create(this,R.raw.smile);
        mediaPlayer.start();
    }
    public void pause(View view)
    {
        if(mediaPlayer.isPlaying()){
            mediaPlayer.pause();  //pause():Pauses playback. Call start() to resume.
        }
        else Toast.makeText(this,"Media is already paused",Toast.LENGTH_SHORT).show();
    }
    public void resume(View view)
    {
        if(mediaPlayer.isPlaying()) Toast.makeText(this, "Already playing", Toast.LENGTH_SHORT).show();
            else{
            //mediaPlayer.seekTo(length);
            mediaPlayer.start();
        }

        }
    public void stop(View view)
    {
        if(mediaPlayer.isPlaying()) mediaPlayer.stop();  //Stop the media and hence destroy the created media object so to restart media we have to create an object again
        else Toast.makeText(this, "Media is already stopped", Toast.LENGTH_SHORT).show();
    }
}


