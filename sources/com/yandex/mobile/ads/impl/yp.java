package com.yandex.mobile.ads.impl;

/* JADX INFO: loaded from: classes6.dex */
public final class yp implements f52 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f10760a;
    private long b;

    public final long a() {
        return this.f10760a;
    }

    public final void b() {
        this.f10760a += this.b;
        this.b = 0L;
    }

    @Override // com.yandex.mobile.ads.impl.f52
    public final void a(long j, long j2) {
        this.b = j2;
    }
}
