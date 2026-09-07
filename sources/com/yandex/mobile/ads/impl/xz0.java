package com.yandex.mobile.ads.impl;

import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class xz0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final wz0 f10688a;

    public xz0(wz0 networksDataProvider) {
        Intrinsics.checkNotNullParameter(networksDataProvider, "networksDataProvider");
        this.f10688a = networksDataProvider;
    }

    public final ArrayList a() {
        int i = iz0.d;
        return this.f10688a.a(iz0.a.a());
    }
}
