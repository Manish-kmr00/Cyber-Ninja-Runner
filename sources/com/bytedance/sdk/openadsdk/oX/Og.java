package com.bytedance.sdk.openadsdk.oX;

import android.content.Context;
import android.os.Handler;
import java.util.List;

/* JADX INFO: loaded from: classes8.dex */
public interface Og {
    Context getContext();

    Handler getHandler();

    int getOnceLogCount();

    int getOnceLogInterval();

    int getUploadIntervalTime();

    boolean isMonitorOpen();

    void onMonitorUpload(List<com.bytedance.sdk.openadsdk.oX.Og.pA> list);
}
