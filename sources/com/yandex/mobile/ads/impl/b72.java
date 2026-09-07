package com.yandex.mobile.ads.impl;

import java.io.IOException;

/* JADX INFO: loaded from: classes10.dex */
public final class b72 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final byte[] f8481a = new byte[10];
    private boolean b;
    private int c;
    private long d;
    private int e;
    private int f;
    private int g;

    public final void a(t52 t52Var, t52.a aVar) {
        if (this.c > 0) {
            t52Var.a(this.d, this.e, this.f, this.g, aVar);
            this.c = 0;
        }
    }

    public final void a() {
        this.b = false;
        this.c = 0;
    }

    public final void a(t52 t52Var, long j, int i, int i2, int i3, t52.a aVar) {
        if (this.g <= i2 + i3) {
            if (this.b) {
                int i4 = this.c;
                int i5 = i4 + 1;
                this.c = i5;
                if (i4 == 0) {
                    this.d = j;
                    this.e = i;
                    this.f = 0;
                }
                this.f += i2;
                this.g = i3;
                if (i5 >= 16) {
                    a(t52Var, aVar);
                    return;
                }
                return;
            }
            return;
        }
        throw new IllegalStateException("TrueHD chunk samples must be contiguous in the sample queue.");
    }

    public final void a(x70 x70Var) throws IOException {
        if (this.b) {
            return;
        }
        x70Var.a(this.f8481a, 0, 10);
        x70Var.c();
        byte[] bArr = this.f8481a;
        if (bArr[4] == -8 && bArr[5] == 114 && bArr[6] == 111) {
            byte b = bArr[7];
            if ((b & 254) != 186) {
                return;
            }
            if ((40 << ((bArr[(b & 255) == 187 ? '\t' : '\b'] >> 4) & 7)) == 0) {
                return;
            }
            this.b = true;
        }
    }
}
