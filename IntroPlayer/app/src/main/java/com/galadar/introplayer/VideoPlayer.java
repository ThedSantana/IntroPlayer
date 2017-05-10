package com.galadar.introplayer;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.VideoView;

public class VideoPlayer extends AppCompatActivity {

    //TODO: MAKE FULLSCREEN
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_player);


        Intent intent = getIntent();
        Bundle data = intent.getExtras();

        final int videoID = data.getInt("ID");
        final boolean clickable = data.getBoolean("Click");

        final VideoView vid = (VideoView)findViewById(R.id.myvideoview);
        vid.setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

        vid.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + videoID));


        vid.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(clickable){
                    vid.stopPlayback();
                    finish();
                    return true;
                }
                return false;
            }
        });


        vid.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                finish();
            }
        });

        vid.start();


    }

}
