package com.yandex.mobile.ads.impl;

import android.support.v4.media.session.PlaybackStateCompat;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes12.dex */
public final class xb0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f10636a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;
    public final int g;
    public final int h;
    public final int i;
    public final long j;
    public final a k;
    private final g01 l;

    private static int a(int i) {
        if (i == 8) {
            return 1;
        }
        if (i == 12) {
            return 2;
        }
        if (i == 16) {
            return 4;
        }
        if (i != 20) {
            return i != 24 ? -1 : 6;
        }
        return 5;
    }

    private static int b(int i) {
        switch (i) {
            case 8000:
                return 4;
            case 16000:
                return 5;
            case 22050:
                return 6;
            case 24000:
                return 7;
            case 32000:
                return 8;
            case 44100:
                return 9;
            case 48000:
                return 10;
            case 88200:
                return 1;
            case 96000:
                return 11;
            case 176400:
                return 2;
            case 192000:
                return 3;
            default:
                return -1;
        }
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long[] f10637a;
        public final long[] b;

        public a(long[] jArr, long[] jArr2) {
            this.f10637a = jArr;
            this.b = jArr2;
        }
    }

    private xb0(int i, int i2, int i3, int i4, int i5, int i6, int i7, long j, a aVar, g01 g01Var) {
        this.f10636a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
        this.e = i5;
        this.f = b(i5);
        this.g = i6;
        this.h = i7;
        this.i = a(i7);
        this.j = j;
        this.k = aVar;
        this.l = g01Var;
    }

    public xb0(int i, byte[] bArr) {
        vf1 vf1Var = new vf1(bArr);
        vf1Var.c(i * 8);
        this.f10636a = vf1Var.b(16);
        this.b = vf1Var.b(16);
        this.c = vf1Var.b(24);
        this.d = vf1Var.b(24);
        int iB = vf1Var.b(20);
        this.e = iB;
        this.f = b(iB);
        this.g = vf1Var.b(3) + 1;
        int iB2 = vf1Var.b(5) + 1;
        this.h = iB2;
        this.i = a(iB2);
        this.j = vf1Var.g();
        this.k = null;
        this.l = null;
    }

    public final xb0 b(List<String> list) {
        g01 g01VarA = yi2.a(list);
        g01 g01Var = this.l;
        if (g01Var != null) {
            g01VarA = g01Var.a(g01VarA);
        }
        return new xb0(this.f10636a, this.b, this.c, this.d, this.e, this.g, this.h, this.j, this.k, g01VarA);
    }

    public final xb0 a(List<fh1> list) {
        g01 g01Var = new g01(list);
        g01 g01Var2 = this.l;
        if (g01Var2 != null) {
            g01Var = g01Var2.a(g01Var);
        }
        return new xb0(this.f10636a, this.b, this.c, this.d, this.e, this.g, this.h, this.j, this.k, g01Var);
    }

    public final long b() {
        long j = this.j;
        if (j == 0) {
            return -9223372036854775807L;
        }
        return (j * 1000000) / ((long) this.e);
    }

    public final long a() {
        long j;
        long j2;
        int i = this.d;
        if (i > 0) {
            j = (((long) i) + ((long) this.c)) / 2;
            j2 = 1;
        } else {
            int i2 = this.f10636a;
            j = ((((i2 != this.b || i2 <= 0) ? PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM : i2) * ((long) this.g)) * ((long) this.h)) / 8;
            j2 = 64;
        }
        return j + j2;
    }

    public final gc0 a(byte[] bArr, g01 g01Var) {
        bArr[4] = -128;
        int i = this.d;
        if (i <= 0) {
            i = -1;
        }
        g01 g01Var2 = this.l;
        if (g01Var2 != null) {
            g01Var = g01Var2.a(g01Var);
        }
        return new gc0.a().e("audio/flac").h(i).c(this.g).l(this.e).a(Collections.singletonList(bArr)).a(g01Var).a();
    }

    public final long a(long j) {
        long j2 = (j * ((long) this.e)) / 1000000;
        long j3 = this.j - 1;
        int i = x82.f10629a;
        return Math.max(0L, Math.min(j2, j3));
    }

    public final xb0 a(a aVar) {
        return new xb0(this.f10636a, this.b, this.c, this.d, this.e, this.g, this.h, this.j, aVar, this.l);
    }
}
