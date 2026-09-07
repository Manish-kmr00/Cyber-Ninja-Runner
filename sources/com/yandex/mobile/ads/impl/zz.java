package com.yandex.mobile.ads.impl;

/* JADX INFO: loaded from: classes6.dex */
public final class zz implements yr0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final az f10866a;
    private final long b;
    private final long c;
    private final long d;
    private final long e;
    private final int f;
    private final boolean g;
    private final long h;
    private final boolean i;
    private int j;
    private boolean k;

    @Override // com.yandex.mobile.ads.impl.yr0
    public final void b() {
        int i = this.f;
        if (i == -1) {
            i = 13107200;
        }
        this.j = i;
        this.k = false;
        this.f10866a.d();
    }

    @Override // com.yandex.mobile.ads.impl.yr0
    public final az c() {
        return this.f10866a;
    }

    @Override // com.yandex.mobile.ads.impl.yr0
    public final void d() {
        int i = this.f;
        if (i == -1) {
            i = 13107200;
        }
        this.j = i;
        this.k = false;
        this.f10866a.d();
    }

    @Override // com.yandex.mobile.ads.impl.yr0
    public final void f() {
        int i = this.f;
        if (i == -1) {
            i = 13107200;
        }
        this.j = i;
        this.k = false;
    }

    public zz() {
        this(new az());
    }

    protected zz(az azVar) {
        a(2500, 0, "bufferForPlaybackMs", "0");
        a(5000, 0, "bufferForPlaybackAfterRebufferMs", "0");
        a(50000, 2500, "minBufferMs", "bufferForPlaybackMs");
        a(50000, 5000, "minBufferMs", "bufferForPlaybackAfterRebufferMs");
        a(50000, 50000, "maxBufferMs", "minBufferMs");
        a(0, 0, "backBufferDurationMs", "0");
        this.f10866a = azVar;
        long j = 50000;
        this.b = x82.a(j);
        this.c = x82.a(j);
        this.d = x82.a(2500);
        this.e = x82.a(5000);
        this.f = -1;
        this.j = 13107200;
        this.g = false;
        this.h = x82.a(0);
        this.i = false;
    }

    @Override // com.yandex.mobile.ads.impl.yr0
    public final long e() {
        return this.h;
    }

    private static void a(int i, int i2, String str, String str2) {
        hg.a(str + " cannot be less than " + str2, i >= i2);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.yandex.mobile.ads.impl.yr0
    public final void a(ro1[] ro1VarArr, e70[] e70VarArr) {
        int iMax = this.f;
        if (iMax == -1) {
            int i = 0;
            int i2 = 0;
            while (true) {
                int i3 = 13107200;
                if (i < ro1VarArr.length) {
                    if (e70VarArr[i] != null) {
                        switch (ro1VarArr[i].m()) {
                            case -2:
                                i3 = 0;
                                i2 += i3;
                                break;
                            case -1:
                            default:
                                throw new IllegalArgumentException();
                            case 0:
                                i3 = 144310272;
                                i2 += i3;
                                break;
                            case 1:
                                i2 += i3;
                                break;
                            case 2:
                                i3 = 131072000;
                                i2 += i3;
                                break;
                            case 3:
                            case 4:
                            case 5:
                            case 6:
                                i3 = 131072;
                                i2 += i3;
                                break;
                        }
                    }
                    i++;
                } else {
                    iMax = Math.max(13107200, i2);
                }
            }
        }
        this.j = iMax;
        this.f10866a.a(iMax);
    }

    @Override // com.yandex.mobile.ads.impl.yr0
    public final boolean a() {
        return this.i;
    }

    @Override // com.yandex.mobile.ads.impl.yr0
    public final boolean a(long j, float f) {
        boolean z = true;
        boolean z2 = this.f10866a.c() >= this.j;
        long jMin = this.b;
        if (f > 1.0f) {
            int i = x82.f10629a;
            if (f != 1.0f) {
                jMin = Math.round(jMin * ((double) f));
            }
            jMin = Math.min(jMin, this.c);
        }
        if (j < Math.max(jMin, 500000L)) {
            if (!this.g && z2) {
                z = false;
            }
            this.k = z;
            if (!z && j < 500000) {
                at0.d("DefaultLoadControl", "Target buffer size reached with less than 500ms of buffered media data.");
            }
        } else if (j >= this.c || z2) {
            this.k = false;
        }
        return this.k;
    }

    @Override // com.yandex.mobile.ads.impl.yr0
    public final boolean a(long j, float f, boolean z, long j2) {
        int i = x82.f10629a;
        if (f != 1.0f) {
            j = Math.round(j / ((double) f));
        }
        long jMin = z ? this.e : this.d;
        if (j2 != -9223372036854775807L) {
            jMin = Math.min(j2 / 2, jMin);
        }
        return jMin <= 0 || j >= jMin || (!this.g && this.f10866a.c() >= this.j);
    }
}
