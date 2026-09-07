package com.yandex.mobile.ads.impl;

import android.os.SystemClock;

/* JADX INFO: loaded from: classes8.dex */
public final class qo1 implements po1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Long f10041a;

    @Override // com.yandex.mobile.ads.impl.po1
    public final void a() {
        this.f10041a = Long.valueOf(SystemClock.elapsedRealtime());
    }

    @Override // com.yandex.mobile.ads.impl.po1
    public final long b() {
        Long l = this.f10041a;
        if (l == null) {
            return 0L;
        }
        return SystemClock.elapsedRealtime() - l.longValue();
    }
}
