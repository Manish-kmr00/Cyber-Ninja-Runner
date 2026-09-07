package com.amazon.device.ads;

import android.app.Activity;

/* JADX INFO: loaded from: classes8.dex */
interface DTBActivityListener {
    void onActivityDestroyed(Activity activity);

    void onActivityPaused(Activity activity);

    void onActivityResumed(Activity activity);

    void onActivityStopped(Activity activity);
}
