package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes6.dex */
public final class wt0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final g10 f10591a;

    public /* synthetic */ wt0() {
        this(new g10(0));
    }

    public wt0(g10 deviceInfoProvider) {
        Intrinsics.checkNotNullParameter(deviceInfoProvider, "deviceInfoProvider");
        this.f10591a = deviceInfoProvider;
    }

    public final boolean a() {
        this.f10591a.getClass();
        return StringsKt.equals("Xiaomi", g10.a(), true);
    }
}
