package com.yandex.mobile.ads.impl;

import java.io.EOFException;
import java.io.IOException;

/* JADX INFO: loaded from: classes9.dex */
public final class o40 implements t52 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final byte[] f9779a = new byte[4096];

    @Override // com.yandex.mobile.ads.impl.t52
    public final void a(long j, int i, int i2, int i3, t52.a aVar) {
    }

    @Override // com.yandex.mobile.ads.impl.t52
    public final void a(gc0 gc0Var) {
    }

    @Override // com.yandex.mobile.ads.impl.t52
    public final void b(int i, wf1 wf1Var) {
        wf1Var.f(i);
    }

    @Override // com.yandex.mobile.ads.impl.t52
    public final int a(nv nvVar, int i, boolean z) throws IOException {
        int i2 = nvVar.read(this.f9779a, 0, Math.min(this.f9779a.length, i));
        if (i2 != -1) {
            return i2;
        }
        if (z) {
            return -1;
        }
        throw new EOFException();
    }
}
