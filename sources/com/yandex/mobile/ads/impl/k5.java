package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class k5 implements n81 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ec0 f9379a;

    public k5(ec0 forceImpressionTrackingListener) {
        Intrinsics.checkNotNullParameter(forceImpressionTrackingListener, "forceImpressionTrackingListener");
        this.f9379a = forceImpressionTrackingListener;
    }

    @Override // com.yandex.mobile.ads.impl.n81
    public final void a(mk0 eventsObservable) {
        Intrinsics.checkNotNullParameter(eventsObservable, "eventsObservable");
        eventsObservable.a(this.f9379a);
    }
}
