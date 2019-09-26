
package app.matthbo.chateau_meiland_soundboard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import android.content.Context;
import android.media.AudioManager;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.ImageButton;
import android.widget.SeekBar;

import in.myinnos.alphabetsindexfastscrollrecycler.IndexFastScrollRecyclerView;

public class MainActivity extends AppCompatActivity {

    public SoundPlayer soundPlayer = new SoundPlayer(this);
    private AudioManager audioManager;

    private SettingsObserver settingsObserver = new SettingsObserver(new SettingsObserver.OnSettingsChangeListener() {
        @Override
        public void onChange() {
            updateVolumeSlider();
        }
    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SoundManager.loadSounds();

        IndexFastScrollRecyclerView soundClipRecyclerView = findViewById(R.id.recyclerView_main_soundClip);
        soundClipRecyclerView.setHasFixedSize(true);
        soundClipRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        soundClipRecyclerView.setAdapter(new SoundClipRecyclerViewAdapter(SoundManager.getSoundClips(), soundPlayer));
        soundClipRecyclerView.setIndexBarStrokeVisibility(false);
        soundClipRecyclerView.setIndexBarTransparentValue(0.25F);
        soundClipRecyclerView.setPreviewTransparentValue(0.25F);
        soundClipRecyclerView.setIndexbarMargin(10);
        soundClipRecyclerView.setIndexbarWidth(32);

        ImageButton stopBtn = findViewById(R.id.imageButton_main_stop);
        stopBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPlayer.reset();
            }
        });

        audioManager = (AudioManager)getSystemService(Context.AUDIO_SERVICE);
        this.updateVolumeSlider().setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onStopTrackingTouch(SeekBar arg0) {}

            @Override
            public void onStartTrackingTouch(SeekBar arg0) {}

            @Override
            public void onProgressChanged(SeekBar arg0, int arg1, boolean arg2) {
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, arg1, 0);
            }
        });

        getApplicationContext().getContentResolver().registerContentObserver(Settings.System.CONTENT_URI, true, settingsObserver);
    }



    private SeekBar updateVolumeSlider(){
        SeekBar volControl = findViewById(R.id.seekBar_main_volume);
        volControl.setMax(audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC));
        volControl.setProgress(audioManager.getStreamVolume(AudioManager.STREAM_MUSIC));
        return  volControl;
    }

    @Override
    protected void onPause(){
        super.onPause();

        this.soundPlayer.release();
        getApplicationContext().getContentResolver().unregisterContentObserver(settingsObserver);
    }

    @Override
    protected void onResume(){
        super.onResume();

        this.updateVolumeSlider();
        getApplicationContext().getContentResolver().registerContentObserver(Settings.System.CONTENT_URI, true, settingsObserver);
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();

        SoundManager.unload();
    }

}
