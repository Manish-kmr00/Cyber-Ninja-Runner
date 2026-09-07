package io.bidmachine.models;

import android.content.Context;

/* JADX INFO: loaded from: classes12.dex */
public interface DeviceInfo {
    String getHttpAgent(Context context);

    String getIfa(Context context);

    boolean isLimitAdTrackingEnabled();
}
