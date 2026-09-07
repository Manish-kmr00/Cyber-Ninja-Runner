package com.fyber.inneractive.sdk.player.exoplayer2.upstream;

import java.util.Arrays;

/* JADX INFO: loaded from: classes9.dex */
public final class l implements InterfaceC3164b {
    public int b;
    public int c;
    public int d = 0;
    public C3163a[] e = new C3163a[100];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C3163a[] f2164a = new C3163a[1];

    public final synchronized void a(int i) {
        boolean z = i < this.b;
        this.b = i;
        if (z) {
            a();
        }
    }

    public final synchronized void a(C3163a[] c3163aArr) {
        int i = this.d;
        int length = c3163aArr.length + i;
        C3163a[] c3163aArr2 = this.e;
        if (length >= c3163aArr2.length) {
            this.e = (C3163a[]) Arrays.copyOf(c3163aArr2, Math.max(c3163aArr2.length * 2, i + c3163aArr.length));
        }
        for (C3163a c3163a : c3163aArr) {
            byte[] bArr = c3163a.f2148a;
            if (bArr != null && bArr.length != 65536) {
                throw new IllegalArgumentException();
            }
            C3163a[] c3163aArr3 = this.e;
            int i2 = this.d;
            this.d = i2 + 1;
            c3163aArr3[i2] = c3163a;
        }
        this.c -= c3163aArr.length;
        notifyAll();
    }

    public final synchronized void a() {
        int i = this.b;
        int i2 = com.fyber.inneractive.sdk.player.exoplayer2.util.z.f2192a;
        int iMax = Math.max(0, ((i + 65535) / 65536) - this.c);
        int i3 = this.d;
        if (iMax >= i3) {
            return;
        }
        Arrays.fill(this.e, iMax, i3, (Object) null);
        this.d = iMax;
    }
}
