package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class ky1 implements ou0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ou0.a f9461a;

    public /* synthetic */ ky1() {
        this(new ou0.a());
    }

    public ky1(ou0.a measureSpecHolder) {
        Intrinsics.checkNotNullParameter(measureSpecHolder, "measureSpecHolder");
        this.f9461a = measureSpecHolder;
    }

    @Override // com.yandex.mobile.ads.impl.ou0
    public final ou0.a a(int i, int i2) {
        ou0.a aVar = this.f9461a;
        aVar.f9859a = i;
        aVar.b = i2;
        return aVar;
    }
}
