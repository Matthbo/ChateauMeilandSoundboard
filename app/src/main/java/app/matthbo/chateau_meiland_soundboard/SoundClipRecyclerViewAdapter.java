package app.matthbo.chateau_meiland_soundboard;

import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SectionIndexer;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class SoundClipRecyclerViewAdapter extends RecyclerView.Adapter<SoundClipRecyclerViewAdapter.ViewHolder> implements SectionIndexer {

    private final SoundManager.SoundClip[] mValues;
    private final SoundPlayer soundPlayer;
    private Integer[] mSectionPositions;

    public SoundClipRecyclerViewAdapter(SoundManager.SoundClip[] items, SoundPlayer soundPlayer) {
        mValues = items;
        this.soundPlayer = soundPlayer;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_view_sound_item, parent, false);
        return new ViewHolder(view);
    }

    private void playSound(int resourceId){
        if(!soundPlayer.isPlaying() || resourceId != soundPlayer.getCurrentTrackResourceId())
            soundPlayer.play(resourceId);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.title.setText(mValues[position].getName());
        holder.playBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(mValues[position].getResourceId());
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.length;
    }

    @Override
    public Object[] getSections() {
        List<String> sections = new ArrayList<>(27);
        ArrayList<Integer> sectionPositions = new ArrayList<>(27);
        for (int i = 0, size = mValues.length; i < size; i++) {
            String section = String.valueOf(mValues[i].getName().charAt(0)).toUpperCase();
            if("1234567890".contains(section)) section = "#";
            if (!sections.contains(section)) {
                sections.add(section);
                sectionPositions.add(i);
            }
        }
        mSectionPositions = sectionPositions.toArray(new Integer[0]);
        return sections.toArray(new String[0]);
    }

    @Override
    public int getPositionForSection(int sectionIndex) {
        return mSectionPositions[sectionIndex];
    }

    @Override
    public int getSectionForPosition(int position) {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView title;
        public final Button playBtn;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            title = view.findViewById(R.id.textView_fragmentSound_title);
            playBtn = view.findViewById(R.id.button_fragmentSound_play);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + title.getText() + "'";
        }
    }
}
