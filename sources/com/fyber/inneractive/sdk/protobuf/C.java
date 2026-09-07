package com.fyber.inneractive.sdk.protobuf;

import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes13.dex */
public final class C {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final B f2252a;

    public C(B b) {
        Charset charset = AbstractC3205m0.f2291a;
        if (b == null) {
            throw new NullPointerException("output");
        }
        this.f2252a = b;
        b.f2250a = this;
    }

    public final void a(int i, float f) {
        B b = this.f2252a;
        b.getClass();
        b.a(i, Float.floatToRawIntBits(f));
    }

    public final void a(int i, double d) {
        B b = this.f2252a;
        b.getClass();
        b.a(i, Double.doubleToRawLongBits(d));
    }

    public final void a(int i, int i2) {
        this.f2252a.d(i, B.d(i2));
    }

    public final void a(int i, long j) {
        this.f2252a.b(i, B.b(j));
    }

    public final void a(int i, Object obj, U0 u0) {
        B b = this.f2252a;
        b.c(i, 3);
        u0.a(obj, b.f2250a);
        b.c(i, 4);
    }
}
