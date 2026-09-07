package com.mbridge.msdk.thrid.okhttp.internal.http2;

import java.util.Arrays;

/* JADX INFO: compiled from: Settings.java */
/* JADX INFO: loaded from: classes7.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f5555a;
    private final int[] b = new int[10];

    void a() {
        this.f5555a = 0;
        Arrays.fill(this.b, 0);
    }

    int b() {
        if ((this.f5555a & 2) != 0) {
            return this.b[1];
        }
        return -1;
    }

    int c(int i) {
        return (this.f5555a & 32) != 0 ? this.b[5] : i;
    }

    boolean d(int i) {
        return ((1 << i) & this.f5555a) != 0;
    }

    int b(int i) {
        return (this.f5555a & 16) != 0 ? this.b[4] : i;
    }

    int c() {
        if ((this.f5555a & 128) != 0) {
            return this.b[7];
        }
        return 65535;
    }

    int d() {
        return Integer.bitCount(this.f5555a);
    }

    m a(int i, int i2) {
        if (i >= 0) {
            int[] iArr = this.b;
            if (i < iArr.length) {
                this.f5555a = (1 << i) | this.f5555a;
                iArr[i] = i2;
            }
        }
        return this;
    }

    int a(int i) {
        return this.b[i];
    }

    void a(m mVar) {
        for (int i = 0; i < 10; i++) {
            if (mVar.d(i)) {
                a(i, mVar.a(i));
            }
        }
    }
}
