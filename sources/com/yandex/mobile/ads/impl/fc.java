package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class fc implements zb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f8883a;
    private final Runnable b;

    public fc(String request, Runnable adtuneRequestRunnable) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(adtuneRequestRunnable, "adtuneRequestRunnable");
        this.f8883a = request;
        this.b = adtuneRequestRunnable;
    }

    @Override // com.yandex.mobile.ads.impl.zb
    public final void a() {
        this.b.run();
    }

    @Override // com.yandex.mobile.ads.impl.zb
    public final boolean a(String str, String str2) {
        return Intrinsics.areEqual("mobileads", str) && Intrinsics.areEqual(this.f8883a, str2);
    }
}
