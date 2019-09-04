package app.matthbo.chateau_meiland_soundboard;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.util.Log;

import java.io.IOException;

public class SoundPlayer {

    private MediaPlayer mPlayer;
    private Context context;
    private int currentTrackResourceId = 0;
    private static final String TAG = "SoundPlayer";

    public SoundPlayer(Context context){
        this.context = context;
    }

    private void initPlayer(){
        if(this.mPlayer == null){
            this.mPlayer = new MediaPlayer();
            this.mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    currentTrackResourceId = 0;
                    mPlayer.reset();
                    Log.d(TAG, "Completed playing");
                }
            });
        }
    }

    private void loadMedia(int resourceId, MediaPlayer.OnPreparedListener callback) throws IOException, IllegalArgumentException, IllegalStateException {
        if(this.mPlayer == null) this.initPlayer();

        AssetFileDescriptor mediaDescriptor = context.getResources().openRawResourceFd(resourceId);
        this.mPlayer.setDataSource(mediaDescriptor.getFileDescriptor(), mediaDescriptor.getStartOffset(), mediaDescriptor.getLength());
        mediaDescriptor.close();

        this.mPlayer.prepareAsync();
        Log.d(TAG, String.format("Preparing async with resourceId %d", resourceId));

        this.mPlayer.setOnPreparedListener(callback);
    }

    public boolean isPlaying() {
        if (this.mPlayer != null) {
            return this.mPlayer.isPlaying();
        }
        return false;
    }

    public void play(int resourceId){
        if(this.mPlayer != null && this.mPlayer.isPlaying()) this.reset();
        this.currentTrackResourceId = resourceId;

        try {
            this.loadMedia(resourceId, new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    Log.d(TAG, "Start playing");
                    mp.start();
                }
            });
        }catch (Exception e){
            this.reset();
            Log.e(TAG, e.toString());
        }

    }

    public void reset(){
        if(this.mPlayer != null){
            if(this.mPlayer.isPlaying()) this.mPlayer.stop();
            this.mPlayer.reset();
            this.currentTrackResourceId = 0;
        }
        else {
            Log.w(TAG, "No need resetting!");
        }
    }

    public void release() {
        if (this.mPlayer != null) {
            this.mPlayer.release();
            this.mPlayer = null;
            this.currentTrackResourceId = 0;
        }
    }

    public int getCurrentTrackResourceId(){
        return this.currentTrackResourceId;
    }
}
