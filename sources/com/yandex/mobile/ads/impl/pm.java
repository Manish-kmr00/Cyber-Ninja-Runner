package com.yandex.mobile.ads.impl;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes5.dex */
final class pm {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f9938a;
    private long b;
    private boolean c;

    pm() {
    }

    public final long a(gc0 gc0Var) {
        return Math.max(0L, ((this.b - 529) * 1000000) / gc0Var.A) + this.f9938a;
    }

    public final void a() {
        this.f9938a = 0L;
        this.b = 0L;
        this.c = false;
    }

    public final long a(gc0 gc0Var, oy oyVar) {
        if (this.b == 0) {
            this.f9938a = oyVar.f;
        }
        if (this.c) {
            return oyVar.f;
        }
        ByteBuffer byteBuffer = oyVar.d;
        byteBuffer.getClass();
        int i = 0;
        for (int i2 = 0; i2 < 4; i2++) {
            i = (i << 8) | (byteBuffer.get(i2) & 255);
        }
        int iB = b21.b(i);
        if (iB == -1) {
            this.c = true;
            this.b = 0L;
            this.f9938a = oyVar.f;
            at0.d("C2Mp3TimestampTracker", "MPEG audio header is invalid.");
            return oyVar.f;
        }
        long jMax = Math.max(0L, ((this.b - 529) * 1000000) / gc0Var.A) + this.f9938a;
        this.b += (long) iB;
        return jMax;
    }
}
