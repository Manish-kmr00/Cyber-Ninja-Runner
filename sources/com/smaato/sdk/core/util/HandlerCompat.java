package com.smaato.sdk.core.util;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;

/* JADX INFO: loaded from: classes12.dex */
public abstract class HandlerCompat {
    public static Handler create(Looper looper) {
        if (Build.VERSION.SDK_INT >= 28) {
            return Handler.createAsync(Looper.getMainLooper());
        }
        return new Handler(Looper.getMainLooper());
    }
}
