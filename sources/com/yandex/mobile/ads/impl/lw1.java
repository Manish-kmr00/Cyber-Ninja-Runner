package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class lw1 implements i62 {
    @Override // com.yandex.mobile.ads.impl.i62
    public final h62 a(a31 noticeTrackingManager, mo1 renderTrackingManager, yk0 indicatorManager, ch1 phoneStateTracker) {
        Intrinsics.checkNotNullParameter(noticeTrackingManager, "noticeTrackingManager");
        Intrinsics.checkNotNullParameter(renderTrackingManager, "renderTrackingManager");
        Intrinsics.checkNotNullParameter(indicatorManager, "indicatorManager");
        Intrinsics.checkNotNullParameter(phoneStateTracker, "phoneStateTracker");
        return new kw1(noticeTrackingManager, renderTrackingManager, indicatorManager, phoneStateTracker);
    }
}
