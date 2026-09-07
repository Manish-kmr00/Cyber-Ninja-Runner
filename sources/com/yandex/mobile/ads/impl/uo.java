package com.yandex.mobile.ads.impl;

import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class uo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LinkedHashMap f10410a = new LinkedHashMap();

    public final void a(int i, to clickConnector) {
        Intrinsics.checkNotNullParameter(clickConnector, "clickConnector");
        this.f10410a.put(Integer.valueOf(i), clickConnector);
    }

    public final LinkedHashMap a() {
        return this.f10410a;
    }
}
