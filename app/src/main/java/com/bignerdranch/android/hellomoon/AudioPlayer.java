package com.bignerdranch.android.hellomoon;

import android.content.Context;
import android.media.MediaPlayer;

/**
 * Created by Vahe on 4/24/2015.
 */
public class AudioPlayer {
    private MediaPlayer mPlayer;


    public void stop(){
        if(mPlayer != null){
            mPlayer.release();
            mPlayer = null;
        }
    }

    public void play(Context c){
        stop();
        mPlayer = MediaPlayer.create(c, R.raw.one_small_step);

        mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                stop();
            }
        });

        mPlayer.start();
    }

    public void Pause(){
        if(mPlayer != null)
        {
            if(mPlayer.isPlaying()) {
                mPlayer.pause();
                return;
            }
            else{
                mPlayer.start();
            }
        }
    }

    public boolean isPlaying(){
        if(mPlayer != null)
        return   mPlayer.isPlaying();
        else return false;
    }
}
