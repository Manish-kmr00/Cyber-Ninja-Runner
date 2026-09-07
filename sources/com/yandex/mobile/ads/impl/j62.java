package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class j62 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f9291a;
    private final long b;
    private final int c;
    private final yx1 d;
    private Long e;

    public j62(int i, long j, yx1 showNoticeType, String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(showNoticeType, "showNoticeType");
        this.f9291a = url;
        this.b = j;
        this.c = i;
        this.d = showNoticeType;
    }

    public final String d() {
        return this.f9291a;
    }

    public final long a() {
        return this.b;
    }

    public final int e() {
        return this.c;
    }

    public final yx1 c() {
        return this.d;
    }

    public final Long b() {
        return this.e;
    }

    public final void a(Long l) {
        this.e = l;
    }
}
