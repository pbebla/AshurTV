/*
 * Copyright (c) 2020. Pauldin Bebla
 */

package com.example.ashurtv;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.os.Bundle;

import com.google.firebase.analytics.FirebaseAnalytics;

import java.io.IOException;

public class MainActivity extends AppCompatActivity{
    private FirebaseAnalytics mFirebaseAnalytics;
    ImageButton play;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Obtain the FirebaseAnalytics instance.
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
        setContentView(R.layout.activity_main);
        play = findViewById(R.id.playButton);
    }

    public void onPlay(View view) {
        Bundle bundle = new Bundle();
        bundle.putString(FirebaseAnalytics.Param.ITEM_ID, "stream");
        bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, "started");
        bundle.putString(FirebaseAnalytics.Param.CONTENT_TYPE, "video");
        mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle);
        Intent intent = new Intent(this, VideoActivity.class);
        startActivity(intent);
    }

}
