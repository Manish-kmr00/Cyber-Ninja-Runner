package com.yandex.mobile.ads.impl;

import com.yandex.mobile.ads.common.ImpressionData;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class ql2 implements ImpressionData {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final t4 f10034a;

    public ql2(t4 impressionData) {
        Intrinsics.checkNotNullParameter(impressionData, "impressionData");
        this.f10034a = impressionData;
    }

    @Override // com.yandex.mobile.ads.common.ImpressionData
    public final String getRawData() {
        return this.f10034a.c();
    }

    public final boolean equals(Object obj) {
        return (obj instanceof ql2) && Intrinsics.areEqual(((ql2) obj).f10034a, this.f10034a);
    }

    public final int hashCode() {
        return this.f10034a.hashCode();
    }
}
