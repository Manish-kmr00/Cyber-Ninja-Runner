package sg.bigo.ads.ad.interstitial;

import android.os.SystemClock;
import java.lang.reflect.Array;

/* JADX INFO: loaded from: classes8.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f12841a = 1;
    int b = 2;
    int c = 3;
    int d = 4;
    int e = 5;
    int f = 6;
    int g = 7;
    int h = 8;
    int i = 1;
    int j = 2;
    long k = 0;
    long l = 0;
    long m = 0;
    int[] n = new int[10];
    long[] o = new long[10];
    long[] p = new long[10];
    boolean[][] q = (boolean[][]) Array.newInstance((Class<?>) Boolean.TYPE, 10, 10);
    boolean[][] r = (boolean[][]) Array.newInstance((Class<?>) Boolean.TYPE, 10, 10);
    boolean s = false;

    private int a() {
        return (this.k == 0 || SystemClock.elapsedRealtime() - this.k > 5000) ? this.j : this.i;
    }

    private void a(sg.bigo.ads.api.core.c cVar, int i, int i2) {
        try {
            boolean[] zArr = this.r[i2];
            if (zArr[i]) {
                return;
            }
            zArr[i] = true;
            sg.bigo.ads.core.d.b.a(cVar, i, i2, SystemClock.elapsedRealtime() - this.p[i]);
        } catch (Exception unused) {
        }
    }

    private void a(sg.bigo.ads.api.core.c cVar, int i, int i2, int i3, int i4, int i5, int i6) {
        long jElapsedRealtime;
        long j;
        try {
            if (this.s) {
                return;
            }
            boolean[] zArr = this.q[i2];
            if (zArr[i]) {
                return;
            }
            zArr[i] = true;
            long jElapsedRealtime2 = SystemClock.elapsedRealtime() - this.o[i];
            if (i == this.f12841a) {
                jElapsedRealtime = SystemClock.elapsedRealtime();
                j = this.o[i];
            } else {
                jElapsedRealtime = SystemClock.elapsedRealtime();
                j = this.l;
            }
            sg.bigo.ads.core.d.b.a(cVar, i, i2, jElapsedRealtime2, jElapsedRealtime - j, i3, i4, i5, i6);
        } catch (Exception unused) {
        }
    }

    final void a(int i) {
        try {
            long[] jArr = this.o;
            if (jArr[i] == 0) {
                jArr[i] = SystemClock.elapsedRealtime();
            }
        } catch (Exception unused) {
        }
    }

    final void a(sg.bigo.ads.api.core.c cVar, int i) {
        try {
            long[] jArr = this.o;
            if (jArr[i] == 0) {
                jArr[i] = SystemClock.elapsedRealtime();
            }
            if (this.p[i] != 0) {
                int[] iArr = this.n;
                int i2 = iArr[i];
                iArr[i] = 0;
                a(cVar, i, i2);
            }
        } catch (Exception unused) {
        }
    }

    final void a(sg.bigo.ads.api.core.c cVar, int i, int i2, int i3, int i4, int i5) {
        try {
            this.p[i] = SystemClock.elapsedRealtime();
            this.n[i] = a();
            a(cVar, i, this.n[i], i2, i3, i4, i5);
        } catch (Exception unused) {
        }
    }
}
