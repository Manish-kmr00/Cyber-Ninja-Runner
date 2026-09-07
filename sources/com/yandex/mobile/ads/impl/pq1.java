package com.yandex.mobile.ads.impl;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class pq1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f9944a;
    private final tq1 b;
    private final Map<String, String> c;

    public pq1(int i, tq1 body, Map<String, String> headers) {
        Intrinsics.checkNotNullParameter(body, "body");
        Intrinsics.checkNotNullParameter(headers, "headers");
        this.f9944a = i;
        this.b = body;
        this.c = headers;
    }

    public final int c() {
        return this.f9944a;
    }

    public final tq1 a() {
        return this.b;
    }

    public final Map<String, String> b() {
        return this.c;
    }
}
