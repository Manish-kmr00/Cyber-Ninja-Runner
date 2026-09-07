package net.pubnative.lite.sdk.utils;

import android.content.Context;
import android.media.AudioManager;
import net.pubnative.lite.sdk.HyBid;

/* JADX INFO: loaded from: classes13.dex */
public class SoundUtils {
    private static final long CACHE_DURATION_MS = 2000;
    private static final String TAG = "SoundUtils";
    private static long lastCheckedTime = 0;
    private static boolean lastMutedState = true;

    public static boolean isSoundMuted(Context context) {
        if (context == null) {
            return true;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - lastCheckedTime < 2000) {
            Logger.d(TAG, "Returning lastMutedState");
            return lastMutedState;
        }
        try {
            AudioManager audioManager = (AudioManager) context.getSystemService("audio");
            if (audioManager != null) {
                lastMutedState = audioManager.getStreamVolume(2) == 0;
                lastCheckedTime = jCurrentTimeMillis;
                Logger.d(TAG, "Update and return lastMutedState");
                return lastMutedState;
            }
        } catch (SecurityException e) {
            HyBid.reportException((Exception) e);
            Logger.e(TAG, "Security Error fetching sound state: ", e);
        } catch (Exception e2) {
            HyBid.reportException(e2);
            Logger.e(TAG, "Error fetching sound state: ", e2);
        }
        return true;
    }
}
