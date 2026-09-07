package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class md1 implements ec0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final od1 f9628a;

    public md1(a31 noticeTrackingManager) {
        Intrinsics.checkNotNullParameter(noticeTrackingManager, "noticeTrackingManager");
        this.f9628a = noticeTrackingManager;
    }

    @Override // com.yandex.mobile.ads.impl.ec0
    public final void a() {
        this.f9628a.c();
    }
}
