package com.smaato.sdk.core.openmeasurement;

import android.view.View;

/* JADX INFO: loaded from: classes8.dex */
public interface ViewabilityTracker {
    void registerFriendlyObstruction(View view);

    void removeFriendlyObstruction(View view);

    void startTracking();

    void stopTracking();

    void trackImpression();

    void trackLoaded();
}
