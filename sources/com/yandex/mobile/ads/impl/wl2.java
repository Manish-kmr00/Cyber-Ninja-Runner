package com.yandex.mobile.ads.impl;

import com.yandex.mobile.ads.instream.InstreamAdBreakQueue;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class wl2<T> implements InstreamAdBreakQueue<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final qt0<T> f10574a;

    public wl2(qt0<T> manualAdBreakQueue) {
        Intrinsics.checkNotNullParameter(manualAdBreakQueue, "manualAdBreakQueue");
        this.f10574a = manualAdBreakQueue;
    }

    @Override // com.yandex.mobile.ads.instream.InstreamAdBreakQueue
    public final int getCount() {
        return this.f10574a.a();
    }

    @Override // com.yandex.mobile.ads.instream.InstreamAdBreakQueue
    public final T poll() {
        return this.f10574a.b();
    }
}
