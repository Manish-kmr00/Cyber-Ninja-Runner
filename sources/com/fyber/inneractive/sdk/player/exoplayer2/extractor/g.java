package com.fyber.inneractive.sdk.player.exoplayer2.extractor;

import com.fyber.inneractive.sdk.player.exoplayer2.upstream.C3163a;
import com.fyber.inneractive.sdk.player.exoplayer2.upstream.InterfaceC3164b;
import com.fyber.inneractive.sdk.player.exoplayer2.util.z;
import java.io.EOFException;
import java.nio.ByteBuffer;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes13.dex */
public final class g implements r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC3164b f2004a;
    public final int b;
    public final e c;
    public final LinkedBlockingDeque d;
    public final d e;
    public final com.fyber.inneractive.sdk.player.exoplayer2.util.n f;
    public final AtomicInteger g;
    public long h;
    public com.fyber.inneractive.sdk.player.exoplayer2.o i;
    public long j;
    public C3163a k;
    public int l;
    public boolean m;
    public f n;

    public g(InterfaceC3164b interfaceC3164b) {
        this.f2004a = interfaceC3164b;
        ((com.fyber.inneractive.sdk.player.exoplayer2.upstream.l) interfaceC3164b).getClass();
        this.b = 65536;
        this.c = new e();
        this.d = new LinkedBlockingDeque();
        this.e = new d();
        this.f = new com.fyber.inneractive.sdk.player.exoplayer2.util.n(32);
        this.g = new AtomicInteger();
        this.l = 65536;
    }

    public final void a(boolean z) {
        int andSet = this.g.getAndSet(z ? 0 : 2);
        a();
        e eVar = this.c;
        eVar.m = Long.MIN_VALUE;
        eVar.n = Long.MIN_VALUE;
        if (andSet == 2) {
            this.i = null;
        }
    }

    public final void b() {
        if (this.g.getAndSet(2) == 0) {
            a();
        }
    }

    public final void c() {
        if (this.g.compareAndSet(1, 0)) {
            return;
        }
        a();
    }

    public final long d() {
        long jMax;
        e eVar = this.c;
        synchronized (eVar) {
            jMax = Math.max(eVar.m, eVar.n);
        }
        return jMax;
    }

    public final com.fyber.inneractive.sdk.player.exoplayer2.o e() {
        com.fyber.inneractive.sdk.player.exoplayer2.o oVar;
        e eVar = this.c;
        synchronized (eVar) {
            oVar = eVar.p ? null : eVar.q;
        }
        return oVar;
    }

    public final void f() {
        long j;
        e eVar = this.c;
        synchronized (eVar) {
            int i = eVar.i;
            if (i == 0) {
                j = -1;
            } else {
                int i2 = eVar.k + i;
                int i3 = eVar.f2001a;
                int i4 = (i2 - 1) % i3;
                eVar.k = i2 % i3;
                eVar.j += i;
                eVar.i = 0;
                j = eVar.c[i4] + ((long) eVar.d[i4]);
            }
        }
        if (j != -1) {
            a(j);
        }
    }

    public final boolean a(boolean z, long j) {
        long j2;
        e eVar = this.c;
        synchronized (eVar) {
            if (eVar.i != 0) {
                long[] jArr = eVar.f;
                int i = eVar.k;
                if (j < jArr[i]) {
                    j2 = -1;
                } else {
                    if (j <= eVar.n || z) {
                        int i2 = -1;
                        int i3 = 0;
                        while (i != eVar.l && eVar.f[i] <= j) {
                            if ((eVar.e[i] & 1) != 0) {
                                i2 = i3;
                            }
                            i = (i + 1) % eVar.f2001a;
                            i3++;
                        }
                        if (i2 != -1) {
                            int i4 = (eVar.k + i2) % eVar.f2001a;
                            eVar.k = i4;
                            eVar.j += i2;
                            eVar.i -= i2;
                            j2 = eVar.c[i4];
                        }
                    }
                    j2 = -1;
                }
            } else {
                j2 = -1;
            }
        }
        if (j2 == -1) {
            return false;
        }
        a(j2);
        return true;
    }

    public final int a(com.fyber.inneractive.sdk.player.exoplayer2.p pVar, com.fyber.inneractive.sdk.player.exoplayer2.decoder.c cVar, boolean z, boolean z2, long j) {
        int iO;
        long j2;
        byte b;
        e eVar = this.c;
        com.fyber.inneractive.sdk.player.exoplayer2.o oVar = this.i;
        d dVar = this.e;
        synchronized (eVar) {
            iO = 1;
            if (eVar.i != 0) {
                if (!z) {
                    com.fyber.inneractive.sdk.player.exoplayer2.o[] oVarArr = eVar.h;
                    int i = eVar.k;
                    if (oVarArr[i] == oVar) {
                        if (cVar.c == null && cVar.e == 0) {
                            b = -3;
                        } else {
                            long j3 = eVar.f[i];
                            cVar.d = j3;
                            cVar.f1993a = eVar.e[i];
                            dVar.f2000a = eVar.d[i];
                            dVar.b = eVar.c[i];
                            dVar.d = eVar.g[i];
                            eVar.m = Math.max(eVar.m, j3);
                            int i2 = eVar.i - 1;
                            eVar.i = i2;
                            int i3 = eVar.k + 1;
                            eVar.k = i3;
                            eVar.j++;
                            if (i3 == eVar.f2001a) {
                                eVar.k = 0;
                            }
                            if (i2 > 0) {
                                j2 = eVar.c[eVar.k];
                            } else {
                                j2 = dVar.b + ((long) dVar.f2000a);
                            }
                            dVar.c = j2;
                            b = -4;
                        }
                    }
                }
                pVar.f2117a = eVar.h[eVar.k];
                b = -5;
            } else if (z2) {
                cVar.f1993a = 4;
                b = -4;
            } else {
                com.fyber.inneractive.sdk.player.exoplayer2.o oVar2 = eVar.q;
                if (oVar2 == null || (!z && oVar2 == oVar)) {
                    b = -3;
                } else {
                    pVar.f2117a = oVar2;
                    b = -5;
                }
            }
        }
        if (b == -5) {
            this.i = pVar.f2117a;
            return -5;
        }
        if (b != -4) {
            if (b == -3) {
                return -3;
            }
            throw new IllegalStateException();
        }
        if (cVar.b(4)) {
            return -4;
        }
        if (cVar.d < j) {
            cVar.f1993a = Integer.MIN_VALUE | cVar.f1993a;
        }
        if (cVar.b(1073741824)) {
            d dVar2 = this.e;
            long j4 = dVar2.b;
            this.f.c(1);
            a(j4, this.f.f2184a, 1);
            long j5 = j4 + 1;
            byte b2 = this.f.f2184a[0];
            boolean z3 = (b2 & 128) != 0;
            int i4 = b2 & 127;
            com.fyber.inneractive.sdk.player.exoplayer2.decoder.b bVar = cVar.b;
            if (bVar.f1992a == null) {
                bVar.f1992a = new byte[16];
            }
            a(j5, bVar.f1992a, i4);
            long j6 = j5 + ((long) i4);
            if (z3) {
                this.f.c(2);
                a(j6, this.f.f2184a, 2);
                j6 += 2;
                iO = this.f.o();
            }
            int i5 = iO;
            com.fyber.inneractive.sdk.player.exoplayer2.decoder.b bVar2 = cVar.b;
            int[] iArr = bVar2.b;
            if (iArr == null || iArr.length < i5) {
                iArr = new int[i5];
            }
            int[] iArr2 = iArr;
            int[] iArr3 = bVar2.c;
            if (iArr3 == null || iArr3.length < i5) {
                iArr3 = new int[i5];
            }
            int[] iArr4 = iArr3;
            if (z3) {
                int i6 = i5 * 6;
                this.f.c(i6);
                a(j6, this.f.f2184a, i6);
                j6 += (long) i6;
                this.f.e(0);
                for (int i7 = 0; i7 < i5; i7++) {
                    iArr2[i7] = this.f.o();
                    iArr4[i7] = this.f.m();
                }
            } else {
                iArr2[0] = 0;
                iArr4[0] = dVar2.f2000a - ((int) (j6 - dVar2.b));
            }
            com.fyber.inneractive.sdk.player.exoplayer2.decoder.b bVar3 = cVar.b;
            bVar3.a(i5, iArr2, iArr4, dVar2.d, bVar3.f1992a);
            long j7 = dVar2.b;
            int i8 = (int) (j6 - j7);
            dVar2.b = j7 + ((long) i8);
            dVar2.f2000a -= i8;
        }
        int i9 = this.e.f2000a;
        ByteBuffer byteBuffer = cVar.c;
        if (byteBuffer == null) {
            cVar.c = cVar.a(i9);
        } else {
            int iCapacity = byteBuffer.capacity();
            int iPosition = cVar.c.position();
            int i10 = i9 + iPosition;
            if (iCapacity < i10) {
                ByteBuffer byteBufferA = cVar.a(i10);
                if (iPosition > 0) {
                    cVar.c.position(0);
                    cVar.c.limit(iPosition);
                    byteBufferA.put(cVar.c);
                }
                cVar.c = byteBufferA;
            }
        }
        d dVar3 = this.e;
        long j8 = dVar3.b;
        ByteBuffer byteBuffer2 = cVar.c;
        int i11 = dVar3.f2000a;
        while (i11 > 0) {
            a(j8);
            int i12 = (int) (j8 - this.h);
            int iMin = Math.min(i11, this.b - i12);
            C3163a c3163a = (C3163a) this.d.peek();
            byteBuffer2.put(c3163a.f2148a, c3163a.b + i12, iMin);
            j8 += (long) iMin;
            i11 -= iMin;
        }
        a(this.e.c);
        return -4;
    }

    public final void a(long j, byte[] bArr, int i) {
        int i2 = 0;
        while (i2 < i) {
            a(j);
            int i3 = (int) (j - this.h);
            int iMin = Math.min(i - i2, this.b - i3);
            C3163a c3163a = (C3163a) this.d.peek();
            System.arraycopy(c3163a.f2148a, c3163a.b + i3, bArr, i2, iMin);
            j += (long) iMin;
            i2 += iMin;
        }
    }

    public final void a(long j) {
        int i = ((int) (j - this.h)) / this.b;
        for (int i2 = 0; i2 < i; i2++) {
            InterfaceC3164b interfaceC3164b = this.f2004a;
            C3163a c3163a = (C3163a) this.d.remove();
            com.fyber.inneractive.sdk.player.exoplayer2.upstream.l lVar = (com.fyber.inneractive.sdk.player.exoplayer2.upstream.l) interfaceC3164b;
            synchronized (lVar) {
                C3163a[] c3163aArr = lVar.f2164a;
                c3163aArr[0] = c3163a;
                lVar.a(c3163aArr);
            }
            this.h += (long) this.b;
        }
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.r
    public final void a(com.fyber.inneractive.sdk.player.exoplayer2.o oVar) {
        boolean z;
        if (oVar == null) {
            oVar = null;
        }
        e eVar = this.c;
        synchronized (eVar) {
            z = true;
            try {
                if (oVar == null) {
                    eVar.p = true;
                } else {
                    eVar.p = false;
                    com.fyber.inneractive.sdk.player.exoplayer2.o oVar2 = eVar.q;
                    int i = z.f2192a;
                    if (!oVar.equals(oVar2)) {
                        eVar.q = oVar;
                    }
                }
                z = false;
            } catch (Throwable th) {
                throw th;
            }
        }
        f fVar = this.n;
        if (fVar == null || !z) {
            return;
        }
        fVar.e();
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.r
    public final int a(b bVar, int i, boolean z) throws InterruptedException, EOFException {
        int iA = 0;
        if (!this.g.compareAndSet(0, 1)) {
            int iMin = Math.min(bVar.f, i);
            bVar.b(iMin);
            if (iMin == 0) {
                iMin = bVar.a(b.g, 0, Math.min(i, 4096), 0, true);
            }
            if (iMin != -1) {
                bVar.c += (long) iMin;
            }
            if (iMin != -1) {
                return iMin;
            }
            if (z) {
                return -1;
            }
            throw new EOFException();
        }
        try {
            int iA2 = a(i);
            C3163a c3163a = this.k;
            byte[] bArr = c3163a.f2148a;
            int i2 = c3163a.b + this.l;
            int i3 = bVar.f;
            if (i3 != 0) {
                int iMin2 = Math.min(i3, iA2);
                System.arraycopy(bVar.d, 0, bArr, i2, iMin2);
                bVar.b(iMin2);
                iA = iMin2;
            }
            if (iA == 0) {
                iA = bVar.a(bArr, i2, iA2, 0, true);
            }
            if (iA != -1) {
                bVar.c += (long) iA;
            }
            if (iA == -1) {
                if (z) {
                    c();
                    return -1;
                }
                throw new EOFException();
            }
            this.l += iA;
            this.j += (long) iA;
            c();
            return iA;
        } catch (Throwable th) {
            c();
            throw th;
        }
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.r
    public final void a(int i, com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar) {
        if (!this.g.compareAndSet(0, 1)) {
            nVar.e(nVar.b + i);
            return;
        }
        while (i > 0) {
            int iA = a(i);
            C3163a c3163a = this.k;
            nVar.a(c3163a.f2148a, c3163a.b + this.l, iA);
            this.l += iA;
            this.j += (long) iA;
            i -= iA;
        }
        c();
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.r
    public final void a(long j, int i, int i2, int i3, byte[] bArr) {
        if (!this.g.compareAndSet(0, 1)) {
            e eVar = this.c;
            synchronized (eVar) {
                eVar.n = Math.max(eVar.n, j);
            }
            return;
        }
        try {
            if (this.m) {
                if ((i & 1) != 0 && this.c.a(j)) {
                    this.m = false;
                }
                return;
            }
            this.c.a(j, i, (this.j - ((long) i2)) - ((long) i3), i2, bArr);
        } finally {
            c();
        }
    }

    public final void a() {
        e eVar = this.c;
        eVar.j = 0;
        eVar.k = 0;
        eVar.l = 0;
        eVar.i = 0;
        eVar.o = true;
        InterfaceC3164b interfaceC3164b = this.f2004a;
        LinkedBlockingDeque linkedBlockingDeque = this.d;
        ((com.fyber.inneractive.sdk.player.exoplayer2.upstream.l) interfaceC3164b).a((C3163a[]) linkedBlockingDeque.toArray(new C3163a[linkedBlockingDeque.size()]));
        this.d.clear();
        ((com.fyber.inneractive.sdk.player.exoplayer2.upstream.l) this.f2004a).a();
        this.h = 0L;
        this.j = 0L;
        this.k = null;
        this.l = this.b;
    }

    public final int a(int i) {
        C3163a c3163a;
        if (this.l == this.b) {
            this.l = 0;
            com.fyber.inneractive.sdk.player.exoplayer2.upstream.l lVar = (com.fyber.inneractive.sdk.player.exoplayer2.upstream.l) this.f2004a;
            synchronized (lVar) {
                lVar.c++;
                int i2 = lVar.d;
                if (i2 > 0) {
                    C3163a[] c3163aArr = lVar.e;
                    int i3 = i2 - 1;
                    lVar.d = i3;
                    c3163a = c3163aArr[i3];
                    c3163aArr[i3] = null;
                } else {
                    c3163a = new C3163a(0, new byte[65536]);
                }
            }
            this.k = c3163a;
            this.d.add(c3163a);
        }
        return Math.min(i, this.b - this.l);
    }
}
