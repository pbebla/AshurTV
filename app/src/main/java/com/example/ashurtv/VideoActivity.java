/*
 * Copyright (c) 2020. Pauldin Bebla
 */

package com.example.ashurtv;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;


import com.google.firebase.analytics.FirebaseAnalytics;

import java.io.IOException;

import javax.sql.DataSource;

public class VideoActivity extends AppCompatActivity {
    private FirebaseAnalytics mFirebaseAnalytics;
    VideoView videoView;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_video);
        videoView = findViewById(R.id.videoView3);

        String url = "http://ashur.tv/hls/stream.m3u8";
        videoView.setVideoPath(url);
        MediaController mediaController = new
                MediaController(this);
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);
        videoView.start();
    }

    @Override
    protected void onStop(){
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
    @Override
    public void onBackPressed() {
        Bundle bundle = new Bundle();
        bundle.putString(FirebaseAnalytics.Param.ITEM_ID, "stream");
        bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, "closed");
        bundle.putString(FirebaseAnalytics.Param.CONTENT_TYPE, "video");
        mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle);
        super.onBackPressed();
    }
}
