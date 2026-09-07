package com.yandex.mobile.ads.impl;

import java.io.IOException;
import kotlin.jvm.internal.Intrinsics;
import okio.BufferedSink;

/* JADX INFO: loaded from: classes8.dex */
public final class qp1 extends rp1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ yw0 f10042a;
    final /* synthetic */ int b;
    final /* synthetic */ byte[] c;
    final /* synthetic */ int d;

    qp1(yw0 yw0Var, byte[] bArr, int i, int i2) {
        this.f10042a = yw0Var;
        this.b = i;
        this.c = bArr;
        this.d = i2;
    }

    @Override // com.yandex.mobile.ads.impl.rp1
    public final yw0 b() {
        return this.f10042a;
    }

    @Override // com.yandex.mobile.ads.impl.rp1
    public final long a() {
        return this.b;
    }

    @Override // com.yandex.mobile.ads.impl.rp1
    public final void a(BufferedSink sink) throws IOException {
        Intrinsics.checkNotNullParameter(sink, "sink");
        sink.write(this.c, this.d, this.b);
    }
}
