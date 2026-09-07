package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class ga implements n81 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final dc0 f8981a;

    public ga(dc0 noticeForceClickController) {
        Intrinsics.checkNotNullParameter(noticeForceClickController, "noticeForceClickController");
        this.f8981a = noticeForceClickController;
    }

    @Override // com.yandex.mobile.ads.impl.n81
    public final void a(mk0 eventsObservable) {
        Intrinsics.checkNotNullParameter(eventsObservable, "eventsObservable");
        this.f8981a.a(eventsObservable);
    }
}
