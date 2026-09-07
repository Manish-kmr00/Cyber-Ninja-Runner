package com.yandex.mobile.ads.impl;

import okio.Buffer;
import okio.BufferedSource;

/* JADX INFO: loaded from: classes10.dex */
public final class rq1 extends sq1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ yw0 f10132a;
    final /* synthetic */ long b;
    final /* synthetic */ BufferedSource c;

    rq1(long j, yw0 yw0Var, Buffer buffer) {
        this.f10132a = yw0Var;
        this.b = j;
        this.c = buffer;
    }

    @Override // com.yandex.mobile.ads.impl.sq1
    public final yw0 b() {
        return this.f10132a;
    }

    @Override // com.yandex.mobile.ads.impl.sq1
    public final long a() {
        return this.b;
    }

    @Override // com.yandex.mobile.ads.impl.sq1
    public final BufferedSource c() {
        return this.c;
    }
}
