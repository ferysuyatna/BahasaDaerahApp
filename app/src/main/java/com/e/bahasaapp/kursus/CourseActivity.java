package com.e.bahasaapp.kursus;

import android.os.Bundle;

import com.e.bahasaapp.R;
import com.e.bahasaapp.util.YoutubeConfig;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class CourseActivity extends YouTubeBaseActivity {
    private int position = 0;
    private String url = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);

        YouTubePlayerView youTubePlayerView = findViewById(R.id.player);

        Bundle extras = getIntent().getExtras();
        if(extras != null){
            position = extras.getInt("position");
        }


        if(position == 0){
            url = "HkR0vVEQ-MY";
        } else if(position == 1){
            url = "ZeqgxtHoCB4";
        } else if(position == 2){
            url = "NS3kGTln3Bc";
        }

        youTubePlayerView.initialize(YoutubeConfig.getApiKey(),
                new YouTubePlayer.OnInitializedListener() {
                    @Override
                    public void onInitializationSuccess(YouTubePlayer.Provider provider,
                                                        YouTubePlayer youTubePlayer, boolean b) {

                        // do any work here to cue video, play video, etc.
                        youTubePlayer.cueVideo(url);
                    }
                    @Override
                    public void onInitializationFailure(YouTubePlayer.Provider provider,
                                                        YouTubeInitializationResult youTubeInitializationResult) {

                    }
                });
    }
}
