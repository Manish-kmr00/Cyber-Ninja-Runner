package androidx.core.app;

import android.app.ActivityManager;

/* JADX INFO: loaded from: classes12.dex */
public final class ActivityManagerCompat {
    private ActivityManagerCompat() {
    }

    public static boolean isLowRamDevice(ActivityManager activityManager) {
        return activityManager.isLowRamDevice();
    }
}
