package com.bytedance.sdk.component.utils;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: loaded from: classes14.dex */
public class SD {
    private static volatile Handler pA;

    public static Handler pA() {
        return com.bytedance.sdk.component.omh.pA.pA.pA().Og();
    }

    public static Handler Og() {
        if (pA == null) {
            synchronized (SD.class) {
                if (pA == null) {
                    pA = new Handler(Looper.getMainLooper());
                }
            }
        }
        return pA;
    }
}
