package net.pubnative.lite.sdk.visibility;

import android.util.Log;
import android.view.View;
import java.util.ArrayList;
import java.util.List;
import net.pubnative.lite.sdk.models.AdSize;

/* JADX INFO: loaded from: classes11.dex */
public class ImpressionManager {
    private static final String TAG = "ImpressionManager";
    private static ImpressionManager instance;
    protected List<ImpressionTracker> mTrackers;

    private ImpressionManager() {
    }

    public static ImpressionManager getInstance() {
        if (instance == null) {
            ImpressionManager impressionManager = new ImpressionManager();
            instance = impressionManager;
            impressionManager.mTrackers = new ArrayList();
        }
        return instance;
    }

    public static void startTrackingView(View view, Integer num, Double d, ImpressionTracker.Listener listener) {
        startTrackingView(view, null, num, d, listener);
    }

    public static void startTrackingView(View view, AdSize adSize, Integer num, Double d, ImpressionTracker.Listener listener) {
        getInstance().addView(view, adSize, num, d, listener);
    }

    public static void stopTrackingAll(ImpressionTracker.Listener listener) {
        getInstance().stopTracking(listener);
    }

    public static void stopTrackingView(View view) {
        getInstance().removeView(view);
    }

    protected void addView(View view, AdSize adSize, Integer num, Double d, ImpressionTracker.Listener listener) {
        ImpressionTracker impressionTracker;
        if (view == null) {
            Log.w(TAG, "trying to start tracking null view, dropping this calll");
            return;
        }
        if (listener == null) {
            Log.w(TAG, "trying to start tracking with null listener");
            return;
        }
        if (containsTracker(view)) {
            if (!this.mTrackers.get(indexOfTracker(view)).equals(listener)) {
                removeView(view);
            }
        }
        if (containsTracker(listener)) {
            impressionTracker = this.mTrackers.get(indexOfTracker(view));
        } else {
            ImpressionTracker impressionTracker2 = new ImpressionTracker(num, d);
            if (adSize != null) {
                impressionTracker2.setAdSize(adSize, d);
            }
            impressionTracker2.setListener(listener);
            this.mTrackers.add(impressionTracker2);
            impressionTracker = impressionTracker2;
        }
        impressionTracker.addView(view);
    }

    protected void stopTracking(ImpressionTracker.Listener listener) {
        if (listener == null) {
            Log.w(TAG, "trying to remove all views from null listener, dropping this call");
        } else if (containsTracker(listener)) {
            this.mTrackers.get(indexOfTracker(listener)).clear();
            this.mTrackers.remove(listener);
        }
    }

    protected void removeView(View view) {
        if (view == null) {
            Log.w(TAG, "trying to remove null view, dropping this call");
            return;
        }
        if (containsTracker(view)) {
            ImpressionTracker impressionTracker = this.mTrackers.get(indexOfTracker(view));
            impressionTracker.removeView(view);
            if (impressionTracker.isEmpty()) {
                impressionTracker.clear();
                this.mTrackers.remove(impressionTracker);
            }
        }
    }

    protected boolean containsTracker(View view) {
        return indexOfTracker(view) >= 0;
    }

    protected int indexOfTracker(View view) {
        for (int i = 0; i < this.mTrackers.size(); i++) {
            if (this.mTrackers.get(i).equals(view)) {
                return i;
            }
        }
        return -1;
    }

    protected boolean containsTracker(ImpressionTracker.Listener listener) {
        return indexOfTracker(listener) >= 0;
    }

    protected int indexOfTracker(ImpressionTracker.Listener listener) {
        for (int i = 0; i < this.mTrackers.size(); i++) {
            if (this.mTrackers.get(i).equals(listener)) {
                return i;
            }
        }
        return -1;
    }
}
