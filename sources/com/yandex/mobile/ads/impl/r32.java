package com.yandex.mobile.ads.impl;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;

/* JADX INFO: loaded from: classes11.dex */
public final class r32 implements hp {
    @Override // com.yandex.mobile.ads.impl.hp
    public final long a() {
        return SystemClock.uptimeMillis();
    }

    @Override // com.yandex.mobile.ads.impl.hp
    public final long b() {
        return SystemClock.elapsedRealtime();
    }

    @Override // com.yandex.mobile.ads.impl.hp
    public final ef0 a(Looper looper, Handler.Callback callback) {
        return new t32(new Handler(looper, callback));
    }

    protected r32() {
    }
}
