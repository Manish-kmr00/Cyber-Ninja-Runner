package com.bytedance.sdk.component.JG.pA.Og;

import android.content.Context;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import com.bytedance.sdk.component.JG.pA.omh;
import com.bytedance.sdk.component.JG.pA.pA.ML;

/* JADX INFO: loaded from: classes6.dex */
public class pA {
    public static long pA(int i, Context context) {
        return Og(i, context);
    }

    private static long Og(int i, Context context) {
        if (context == null) {
            return i;
        }
        Runtime runtime = Runtime.getRuntime();
        long jFreeMemory = runtime.freeMemory() / PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
        long jMaxMemory = (runtime.maxMemory() / PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) - (runtime.totalMemory() / PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED);
        if (jMaxMemory <= 0) {
            if (jFreeMemory <= 2) {
                return 1L;
            }
            if (jFreeMemory <= 10) {
                return Math.min(i, 10);
            }
            return Math.min((jFreeMemory / 2) * 10, i);
        }
        long j = ((jFreeMemory + jMaxMemory) - 10) / 2;
        if (j <= 2) {
            return 1L;
        }
        if (j <= 10) {
            return Math.min(i, 10);
        }
        return Math.min(j * 10, i);
    }

    public static boolean pA() {
        ML mlZZv = omh.SD().ZZv();
        return (mlZZv == null || TextUtils.isEmpty(mlZZv.pA())) ? false : true;
    }

    public static boolean Og() {
        ML mlZZv = omh.SD().ZZv();
        return (mlZZv == null || TextUtils.isEmpty(mlZZv.Og())) ? false : true;
    }

    public static boolean KZx() {
        ML mlZZv = omh.SD().ZZv();
        return (mlZZv == null || TextUtils.isEmpty(mlZZv.ZZv())) ? false : true;
    }

    public static boolean ZZv() {
        ML mlZZv = omh.SD().ZZv();
        return (mlZZv == null || TextUtils.isEmpty(mlZZv.ML())) ? false : true;
    }

    public static boolean ML() {
        ML mlZZv = omh.SD().ZZv();
        return (mlZZv == null || TextUtils.isEmpty(mlZZv.KZx())) ? false : true;
    }

    public static boolean JG() {
        ML mlZZv = omh.SD().ZZv();
        return (mlZZv == null || TextUtils.isEmpty(mlZZv.JG())) ? false : true;
    }
}
