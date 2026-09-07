package com.yandex.mobile.ads.impl;

import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class r62 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final v9 f10078a;

    public r62(v9 adTracker) {
        Intrinsics.checkNotNullParameter(adTracker, "adTracker");
        this.f10078a = adTracker;
    }

    public final void a(List<String> trackingUrls) {
        Intrinsics.checkNotNullParameter(trackingUrls, "trackingUrls");
        Iterator<T> it = trackingUrls.iterator();
        while (it.hasNext()) {
            this.f10078a.a((String) it.next(), s62.d);
        }
    }
}
