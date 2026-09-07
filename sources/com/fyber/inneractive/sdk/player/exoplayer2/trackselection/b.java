package com.fyber.inneractive.sdk.player.exoplayer2.trackselection;

import android.os.SystemClock;
import com.fyber.inneractive.sdk.player.exoplayer2.o;
import com.fyber.inneractive.sdk.player.exoplayer2.source.y;
import java.util.Arrays;

/* JADX INFO: loaded from: classes11.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final y f2141a;
    public final int b;
    public final int[] c;
    public final o[] d;
    public final long[] e;
    public int f;

    public b(y yVar, int... iArr) {
        if (iArr.length <= 0) {
            throw new IllegalStateException();
        }
        yVar.getClass();
        this.f2141a = yVar;
        int length = iArr.length;
        this.b = length;
        this.d = new o[length];
        int i = 0;
        for (int i2 = 0; i2 < iArr.length; i2++) {
            this.d[i2] = yVar.b[iArr[i2]];
        }
        Arrays.sort(this.d, new a());
        this.c = new int[this.b];
        while (true) {
            int i3 = this.b;
            if (i >= i3) {
                this.e = new long[i3];
                return;
            } else {
                this.c[i] = yVar.a(this.d[i]);
                i++;
            }
        }
    }

    public abstract int a();

    public final boolean a(int i) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        boolean z = this.e[i] > jElapsedRealtime;
        int i2 = 0;
        while (i2 < this.b && !z) {
            z = i2 != i && this.e[i2] <= jElapsedRealtime;
            i2++;
        }
        if (!z) {
            return false;
        }
        long[] jArr = this.e;
        jArr[i] = Math.max(jArr[i], jElapsedRealtime + 60000);
        return true;
    }

    public abstract Object b();

    public abstract int c();

    public abstract void d();

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        return this.f2141a == bVar.f2141a && Arrays.equals(this.c, bVar.c);
    }

    public final int hashCode() {
        if (this.f == 0) {
            this.f = Arrays.hashCode(this.c) + (System.identityHashCode(this.f2141a) * 31);
        }
        return this.f;
    }
}
