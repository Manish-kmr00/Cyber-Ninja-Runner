package com.yandex.mobile.ads.impl;

import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public final class gp implements lw0, lw0.a {
    public final lw0 b;
    private lw0.a c;
    private a[] d = new a[0];
    private long e;
    long f;
    long g;

    @Override // com.yandex.mobile.ads.impl.lw0
    public final long readDiscontinuity() {
        long j = this.e;
        if (j != -9223372036854775807L) {
            this.e = -9223372036854775807L;
            long discontinuity = readDiscontinuity();
            return discontinuity != -9223372036854775807L ? discontinuity : j;
        }
        long discontinuity2 = this.b.readDiscontinuity();
        if (discontinuity2 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        if (discontinuity2 < this.f) {
            throw new IllegalStateException();
        }
        long j2 = this.g;
        if (j2 == Long.MIN_VALUE || discontinuity2 <= j2) {
            return discontinuity2;
        }
        throw new IllegalStateException();
    }

    public gp(lw0 lw0Var, boolean z, long j, long j2) {
        this.b = lw0Var;
        this.e = z ? j : -9223372036854775807L;
        this.f = j;
        this.g = j2;
    }

    @Override // com.yandex.mobile.ads.impl.lw0
    public final void maybeThrowPrepareError() throws IOException {
        this.b.maybeThrowPrepareError();
    }

    @Override // com.yandex.mobile.ads.impl.lw0
    public final s52 getTrackGroups() {
        return this.b.getTrackGroups();
    }

    @Override // com.yandex.mobile.ads.impl.lw0
    public final void discardBuffer(long j, boolean z) {
        this.b.discardBuffer(j, z);
    }

    @Override // com.yandex.mobile.ads.impl.fx1
    public final void reevaluateBuffer(long j) {
        this.b.reevaluateBuffer(j);
    }

    @Override // com.yandex.mobile.ads.impl.fx1
    public final long getBufferedPositionUs() {
        long bufferedPositionUs = this.b.getBufferedPositionUs();
        if (bufferedPositionUs != Long.MIN_VALUE) {
            long j = this.g;
            if (j == Long.MIN_VALUE || bufferedPositionUs < j) {
                return bufferedPositionUs;
            }
        }
        return Long.MIN_VALUE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0032, code lost:
    
        if (r0 > r6) goto L17;
     */
    @Override // com.yandex.mobile.ads.impl.lw0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final long seekToUs(long r6) {
        /*
            r5 = this;
            r0 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r5.e = r0
            com.yandex.mobile.ads.impl.gp$a[] r0 = r5.d
            int r1 = r0.length
            r2 = 0
            r3 = r2
        Lc:
            if (r3 >= r1) goto L18
            r4 = r0[r3]
            if (r4 == 0) goto L15
            com.yandex.mobile.ads.impl.gp.a.m6694$$Nest$fputb(r4, r2)
        L15:
            int r3 = r3 + 1
            goto Lc
        L18:
            com.yandex.mobile.ads.impl.lw0 r0 = r5.b
            long r0 = r0.seekToUs(r6)
            int r6 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r6 == 0) goto L3b
            long r6 = r5.f
            int r6 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r6 < 0) goto L35
            long r6 = r5.g
            r2 = -9223372036854775808
            int r2 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r2 == 0) goto L3b
            int r6 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r6 > 0) goto L35
            goto L3b
        L35:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            r6.<init>()
            throw r6
        L3b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yandex.mobile.ads.impl.gp.seekToUs(long):long");
    }

    @Override // com.yandex.mobile.ads.impl.lw0
    public final long a(long j, yw1 yw1Var) {
        long j2 = this.f;
        if (j == j2) {
            return j2;
        }
        int i = x82.f10629a;
        long jMax = Math.max(0L, Math.min(yw1Var.f10776a, j - j2));
        long j3 = yw1Var.b;
        long j4 = this.g;
        long jMax2 = Math.max(0L, Math.min(j3, j4 == Long.MIN_VALUE ? Long.MAX_VALUE : j4 - j));
        if (jMax != yw1Var.f10776a || jMax2 != yw1Var.b) {
            yw1Var = new yw1(jMax, jMax2);
        }
        return this.b.a(j, yw1Var);
    }

    @Override // com.yandex.mobile.ads.impl.fx1
    public final long getNextLoadPositionUs() {
        long nextLoadPositionUs = this.b.getNextLoadPositionUs();
        if (nextLoadPositionUs != Long.MIN_VALUE) {
            long j = this.g;
            if (j == Long.MIN_VALUE || nextLoadPositionUs < j) {
                return nextLoadPositionUs;
            }
        }
        return Long.MIN_VALUE;
    }

    @Override // com.yandex.mobile.ads.impl.fx1
    public final boolean continueLoading(long j) {
        return this.b.continueLoading(j);
    }

    @Override // com.yandex.mobile.ads.impl.fx1
    public final boolean isLoading() {
        return this.b.isLoading();
    }

    @Override // com.yandex.mobile.ads.impl.fx1.a
    public final void a(fx1 fx1Var) {
        lw0.a aVar = this.c;
        aVar.getClass();
        aVar.a(this);
    }

    private final class a implements et1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final et1 f9025a;
        private boolean b;

        public a(et1 et1Var) {
            this.f9025a = et1Var;
        }

        @Override // com.yandex.mobile.ads.impl.et1
        public final boolean d() {
            return gp.this.e == -9223372036854775807L && this.f9025a.d();
        }

        @Override // com.yandex.mobile.ads.impl.et1
        public final void a() throws IOException {
            this.f9025a.a();
        }

        @Override // com.yandex.mobile.ads.impl.et1
        public final int a(hc0 hc0Var, oy oyVar, int i) {
            if (gp.this.e != -9223372036854775807L) {
                return -3;
            }
            if (this.b) {
                oyVar.d(4);
                return -4;
            }
            int iA = this.f9025a.a(hc0Var, oyVar, i);
            if (iA == -5) {
                gc0 gc0Var = hc0Var.b;
                gc0Var.getClass();
                int i2 = gc0Var.C;
                if (i2 != 0 || gc0Var.D != 0) {
                    gp gpVar = gp.this;
                    if (gpVar.f != 0) {
                        i2 = 0;
                    }
                    hc0Var.b = gc0Var.a().d(i2).e(gpVar.g == Long.MIN_VALUE ? gc0Var.D : 0).a();
                }
                return -5;
            }
            gp gpVar2 = gp.this;
            long j = gpVar2.g;
            if (j == Long.MIN_VALUE || ((iA != -4 || oyVar.f < j) && !(iA == -3 && gpVar2.getBufferedPositionUs() == Long.MIN_VALUE && !oyVar.e))) {
                return iA;
            }
            oyVar.b();
            oyVar.d(4);
            this.b = true;
            return -4;
        }

        @Override // com.yandex.mobile.ads.impl.et1
        public final int a(long j) {
            if (gp.this.e != -9223372036854775807L) {
                return -3;
            }
            return this.f9025a.a(j);
        }
    }

    @Override // com.yandex.mobile.ads.impl.lw0.a
    public final void a(lw0 lw0Var) {
        lw0.a aVar = this.c;
        aVar.getClass();
        aVar.a((lw0) this);
    }

    @Override // com.yandex.mobile.ads.impl.lw0
    public final void a(lw0.a aVar, long j) {
        this.c = aVar;
        this.b.a(this, j);
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x007b, code lost:
    
        if (r1 > r3) goto L32;
     */
    @Override // com.yandex.mobile.ads.impl.lw0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final long a(com.yandex.mobile.ads.impl.e70[] r16, boolean[] r17, com.yandex.mobile.ads.impl.et1[] r18, boolean[] r19, long r20) {
        /*
            r15 = this;
            r0 = r15
            r8 = r16
            r9 = r18
            int r1 = r9.length
            com.yandex.mobile.ads.impl.gp$a[] r1 = new com.yandex.mobile.ads.impl.gp.a[r1]
            r0.d = r1
            int r1 = r9.length
            com.yandex.mobile.ads.impl.et1[] r10 = new com.yandex.mobile.ads.impl.et1[r1]
            r11 = 0
            r1 = r11
        Lf:
            int r2 = r9.length
            r12 = 0
            if (r1 >= r2) goto L24
            com.yandex.mobile.ads.impl.gp$a[] r2 = r0.d
            r3 = r9[r1]
            com.yandex.mobile.ads.impl.gp$a r3 = (com.yandex.mobile.ads.impl.gp.a) r3
            r2[r1] = r3
            if (r3 == 0) goto L1f
            com.yandex.mobile.ads.impl.et1 r12 = r3.f9025a
        L1f:
            r10[r1] = r12
            int r1 = r1 + 1
            goto Lf
        L24:
            com.yandex.mobile.ads.impl.lw0 r1 = r0.b
            r2 = r16
            r3 = r17
            r4 = r10
            r5 = r19
            r6 = r20
            long r1 = r1.a(r2, r3, r4, r5, r6)
            long r3 = r0.e
            r5 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 == 0) goto L65
            long r3 = r0.f
            int r7 = (r20 > r3 ? 1 : (r20 == r3 ? 0 : -1))
            if (r7 != 0) goto L65
            r13 = 0
            int r3 = (r3 > r13 ? 1 : (r3 == r13 ? 0 : -1))
            if (r3 == 0) goto L65
            int r3 = r8.length
            r4 = r11
        L4c:
            if (r4 >= r3) goto L65
            r7 = r8[r4]
            if (r7 == 0) goto L62
            com.yandex.mobile.ads.impl.gc0 r7 = r7.e()
            java.lang.String r13 = r7.m
            java.lang.String r7 = r7.j
            boolean r7 = com.yandex.mobile.ads.impl.s01.a(r13, r7)
            if (r7 != 0) goto L62
            r5 = r1
            goto L65
        L62:
            int r4 = r4 + 1
            goto L4c
        L65:
            r0.e = r5
            int r3 = (r1 > r20 ? 1 : (r1 == r20 ? 0 : -1))
            if (r3 == 0) goto L84
            long r3 = r0.f
            int r3 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r3 < 0) goto L7e
            long r3 = r0.g
            r5 = -9223372036854775808
            int r5 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r5 == 0) goto L84
            int r3 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r3 > 0) goto L7e
            goto L84
        L7e:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            r1.<init>()
            throw r1
        L84:
            int r3 = r9.length
            if (r11 >= r3) goto Laa
            r3 = r10[r11]
            if (r3 != 0) goto L90
            com.yandex.mobile.ads.impl.gp$a[] r3 = r0.d
            r3[r11] = r12
            goto La1
        L90:
            com.yandex.mobile.ads.impl.gp$a[] r4 = r0.d
            r5 = r4[r11]
            if (r5 == 0) goto L9a
            com.yandex.mobile.ads.impl.et1 r5 = r5.f9025a
            if (r5 == r3) goto La1
        L9a:
            com.yandex.mobile.ads.impl.gp$a r5 = new com.yandex.mobile.ads.impl.gp$a
            r5.<init>(r3)
            r4[r11] = r5
        La1:
            com.yandex.mobile.ads.impl.gp$a[] r3 = r0.d
            r3 = r3[r11]
            r9[r11] = r3
            int r11 = r11 + 1
            goto L84
        Laa:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yandex.mobile.ads.impl.gp.a(com.yandex.mobile.ads.impl.e70[], boolean[], com.yandex.mobile.ads.impl.et1[], boolean[], long):long");
    }

    public final void a(long j) {
        this.f = 0L;
        this.g = j;
    }
}
