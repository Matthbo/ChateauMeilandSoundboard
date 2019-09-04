package app.matthbo.chateau_meiland_soundboard;

import android.database.ContentObserver;
import android.os.Handler;
import android.util.Log;

public class SettingsObserver extends ContentObserver {

    private OnSettingsChangeListener callback;

    public interface OnSettingsChangeListener {
        void onChange();
    }

    public SettingsObserver( OnSettingsChangeListener callback) {
        super(new Handler()); // Not gonna make a whole handler for this right now!
        this.callback = callback;
    }

    /**
     * Creates a content observer.
     *
     * @param handler The handler to run {@link #onChange} on, or null if none.
     */
    //TODO make this the real constructor and use the handler properly!
    public SettingsObserver( Handler handler) {
        super(handler);
    }

    @Override
    public void onChange(boolean selfChange) {
        callback.onChange();
    }
}
