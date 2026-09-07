package com.facebook.ads.redexgen.core;

import com.google.android.exoplayer2.Timeline;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Pf, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1827Pf {
    public static String[] A0B = {"8fkFqchXUcGM3GB2ba14hXLjxjyP4Idi", "AvOIHvoZOcRClJ0G73Ag8xCmCcxwXM7O", "V5l74qymwUJRk6eelGVqnexfLvPv42ur", "EHuFCJBNSCvpunnAG12EWG8LViJ3DR8Z", "godF8uqaodEh", "1Ds6BMKRJ3GI993NLcR574jhDn4Umkmd", "BbYDBW0PzExgzpSlBB8x1sXiVd4lWXuJ", "X0psFw953nJyWmdp"};
    public int A00;
    public int A01;
    public long A02;
    public long A03;
    public C1822Pa A04;
    public C1822Pa A05;
    public C1822Pa A06;
    public Object A07;
    public boolean A08;
    public final C2050Yh A09 = new C2050Yh();
    public final C2048Yf A0A = new C2048Yf();

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static R5 A06(Timeline timeline, Object obj, long j, long j2, C2050Yh c2050Yh) {
        timeline.A0J(obj, c2050Yh);
        int iA08 = c2050Yh.A08(j);
        return iA08 == -1 ? new R5(obj, j2) : new R5(obj, iA08, c2050Yh.A05(iA08), j2);
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public final C1824Pc A0I(Timeline timeline, C1824Pc c1824Pc) {
        long jA0A;
        long j = c1824Pc.A01;
        boolean zA09 = A09(timeline, c1824Pc.A04, j);
        boolean zA0A = A0A(timeline, c1824Pc.A04, zA09);
        timeline.A0J(c1824Pc.A04.A04, this.A09);
        if (c1824Pc.A04.A00()) {
            jA0A = this.A09.A0E(c1824Pc.A04.A00, c1824Pc.A04.A01);
        } else {
            jA0A = j == Long.MIN_VALUE ? this.A09.A0A() : j;
        }
        return new C1824Pc(c1824Pc.A04, c1824Pc.A03, j, c1824Pc.A02, jA0A, zA09, zA0A);
    }

    private long A00(Timeline timeline, Object obj) {
        int oldFrontPeriodIndex;
        int holderWindowIndex = timeline.A0J(obj, this.A09).A00;
        if (this.A07 != null && (oldFrontPeriodIndex = timeline.A0A(this.A07)) != -1) {
            int windowIndex = timeline.A0H(oldFrontPeriodIndex, this.A09).A00;
            if (windowIndex == holderWindowIndex) {
                return this.A03;
            }
        }
        for (C1822Pa mediaPeriodHolder = A0D(); mediaPeriodHolder != null; mediaPeriodHolder = mediaPeriodHolder.A0I()) {
            if (mediaPeriodHolder.A08.equals(obj)) {
                return mediaPeriodHolder.A00.A04.A03;
            }
        }
        for (C1822Pa c1822PaA0D = A0D(); c1822PaA0D != null; c1822PaA0D = c1822PaA0D.A0I()) {
            int iA0A = timeline.A0A(c1822PaA0D.A08);
            if (iA0A != -1) {
                int windowIndex2 = timeline.A0H(iA0A, this.A09).A00;
                if (windowIndex2 == holderWindowIndex) {
                    return c1822PaA0D.A00.A04.A03;
                }
            }
        }
        long j = this.A02;
        long j2 = 1 + j;
        if (A0B[4].length() != 12) {
            throw new RuntimeException();
        }
        String[] strArr = A0B;
        strArr[5] = "Y2hl0p1SbqGAlNTWcrC2XNi8ndDCDtsR";
        strArr[0] = "Izgfn9uCHIGC9mhSAUVnemVit3EFITb3";
        this.A02 = j2;
        return j;
    }

    private C1824Pc A01(Q9 q9) {
        return A03(q9.A04, q9.A06, q9.A01, q9.A02);
    }

    /* JADX WARN: Code duplicated, block: B:37:0x0104 A[PHI: r3 r13
  0x0104: PHI (r3v17 'nextMediaPeriodHolder' com.facebook.ads.redexgen.X.Pa) = 
  (r3v16 'nextMediaPeriodHolder' com.facebook.ads.redexgen.X.Pa)
  (r3v18 'nextMediaPeriodHolder' com.facebook.ads.redexgen.X.Pa)
 binds: [B:46:0x0147, B:36:0x0102] A[DONT_GENERATE, DONT_INLINE]
  0x0104: PHI (r13v11 long) = (r13v9 long), (r13v12 long) binds: [B:46:0x0147, B:36:0x0102] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:39:0x0117  */
    /* JADX WARN: Code duplicated, block: B:41:0x0125  */
    /* JADX WARN: Code duplicated, block: B:42:0x012e  */
    /* JADX WARN: Code restructure failed: missing block: B:101:?, code lost:
    
        return A04(r20, r1.A04, r13, r14, r3.A02, r1.A03);
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x004d, code lost:
    
        if (r2 == (-1)) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x004f, code lost:
    
        r2 = com.facebook.ads.redexgen.core.C1827Pf.A0B;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0062, code lost:
    
        if (r2[1].charAt(25) == r2[2].charAt(25)) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0064, code lost:
    
        com.facebook.ads.redexgen.core.C1827Pf.A0B[7] = "MqLFMbnT7v3WaWrM";
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x006b, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0079, code lost:
    
        if (r2 == (-1)) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0166, code lost:
    
        r14 = r0.A09.A06(r13, r1.A01);
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x016e, code lost:
    
        if (r14 >= r2) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0176, code lost:
    
        if (r0.A09.A0I(r13, r14) != false) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0178, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0195, code lost:
    
        return A05(r20, r1.A04, r3.A02, r1.A03);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.facebook.ads.redexgen.core.C1824Pc A02(com.google.android.exoplayer2.Timeline r20, com.facebook.ads.redexgen.core.C1822Pa r21, long r22) {
        /*
            Method dump skipped, instruction units count: 638
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.C1827Pf.A02(com.google.android.exoplayer2.Timeline, com.facebook.ads.redexgen.X.Pa, long):com.facebook.ads.redexgen.X.Pc");
    }

    private C1824Pc A03(Timeline timeline, R5 r5, long j, long j2) {
        timeline.A0J(r5.A04, this.A09);
        if (r5.A00()) {
            if (this.A09.A0I(r5.A00, r5.A01)) {
                return A04(timeline, r5.A04, r5.A00, r5.A01, j, r5.A03);
            }
            if (A0B[3].charAt(1) != 'H') {
                throw new RuntimeException();
            }
            A0B[3] = "PH1Tjz7yfLWgyQ6PpM2ZkhsFxtYWDAK0";
            return null;
        }
        return A05(timeline, r5.A04, j2, r5.A03);
    }

    private C1824Pc A04(Timeline timeline, Object obj, int i, int i2, long startPositionUs, long j) {
        long jA09;
        R5 r5 = new R5(obj, i, i2, j);
        boolean zA09 = A09(timeline, r5, Long.MIN_VALUE);
        boolean zA0A = A0A(timeline, r5, zA09);
        long jA0E = timeline.A0J(r5.A04, this.A09).A0E(r5.A00, r5.A01);
        if (i2 == this.A09.A05(i)) {
            jA09 = this.A09.A09();
        } else {
            jA09 = 0;
            if (A0B[3].charAt(1) != 'H') {
                throw new RuntimeException();
            }
            A0B[7] = "xco6TO7esNuLitQ8";
        }
        return new C1824Pc(r5, jA09, Long.MIN_VALUE, startPositionUs, jA0E, zA09, zA0A);
    }

    private C1824Pc A05(Timeline timeline, Object obj, long j, long j2) {
        long jA0D;
        long jA0A;
        R5 r5 = new R5(obj, j2);
        timeline.A0J(r5.A04, this.A09);
        int iA07 = this.A09.A07(j);
        if (iA07 == -1) {
            jA0D = Long.MIN_VALUE;
        } else {
            C2050Yh c2050Yh = this.A09;
            String[] strArr = A0B;
            if (strArr[5].charAt(10) != strArr[0].charAt(10)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0B;
            strArr2[5] = "wDYImplyZDGHJhnx6RPwrAT9qMoadwYR";
            strArr2[0] = "PRFGZvYb4FGWelJr6BRaBG9ua1gE9Tz9";
            jA0D = c2050Yh.A0D(iA07);
        }
        boolean isLastInTimeline = A09(timeline, r5, jA0D);
        boolean zA0A = A0A(timeline, r5, isLastInTimeline);
        String[] strArr3 = A0B;
        if (strArr3[1].charAt(25) != strArr3[2].charAt(25)) {
            A0B[3] = "pHVz8oUC0qhz2c5oWjXi4aXG34tvhkfS";
            if (jA0D == Long.MIN_VALUE) {
                C2050Yh c2050Yh2 = this.A09;
                if (A0B[6].charAt(9) == 'E') {
                    A0B[7] = "mSPpQk354VGonlhD";
                    jA0A = c2050Yh2.A0A();
                }
            } else {
                jA0A = jA0D;
            }
            return new C1824Pc(r5, j, jA0D, -9223372036854775807L, jA0A, isLastInTimeline, zA0A);
        }
        throw new RuntimeException();
    }

    private boolean A07(C1822Pa c1822Pa, C1824Pc c1824Pc) {
        C1824Pc c1824Pc2 = c1822Pa.A00;
        return c1824Pc2.A03 == c1824Pc.A03 && c1824Pc2.A01 == c1824Pc.A01 && c1824Pc2.A04.equals(c1824Pc.A04);
    }

    private boolean A08(Timeline timeline) {
        C1822Pa nextMediaPeriodHolder = A0D();
        if (nextMediaPeriodHolder == null) {
            return true;
        }
        int currentPeriodIndex = timeline.A0A(nextMediaPeriodHolder.A08);
        while (true) {
            currentPeriodIndex = timeline.A09(currentPeriodIndex, this.A09, this.A0A, this.A01, this.A08);
            while (lastValidPeriodHolder != null && !nextMediaPeriodHolder.A00.A07) {
                nextMediaPeriodHolder = nextMediaPeriodHolder.A0I();
            }
            C1822Pa c1822PaA0I = nextMediaPeriodHolder.A0I();
            if (currentPeriodIndex == -1 || c1822PaA0I == null) {
                break;
            }
            int nextPeriodHolderPeriodIndex = timeline.A0A(c1822PaA0I.A08);
            if (A0B[4].length() != 12) {
                throw new RuntimeException();
            }
            A0B[3] = "xHuyMgMzz6KTBKBqxb3PM6zQzphf6McT";
            if (nextPeriodHolderPeriodIndex != currentPeriodIndex) {
                break;
            }
            nextMediaPeriodHolder = c1822PaA0I;
        }
        boolean zA0P = A0P(nextMediaPeriodHolder);
        nextMediaPeriodHolder.A00 = A0I(timeline, nextMediaPeriodHolder.A00);
        return (zA0P && A0N()) ? false : true;
    }

    private boolean A09(Timeline timeline, R5 r5, long j) {
        int adGroupCount = timeline.A0J(r5.A04, this.A09).A03();
        if (adGroupCount == 0) {
            return true;
        }
        int postrollAdCount = adGroupCount - 1;
        boolean zA00 = r5.A00();
        long jA0D = this.A09.A0D(postrollAdCount);
        if (A0B[4].length() != 12) {
            throw new RuntimeException();
        }
        String[] strArr = A0B;
        strArr[1] = "mTqZYkGC43bl3pbhwXvxRYHeHqWw3ZiT";
        strArr[2] = "zIDzl8zmG9PG4lDyHHGti1Q8hXr57aIX";
        if (jA0D != Long.MIN_VALUE) {
            return !zA00 && j == Long.MIN_VALUE;
        }
        int lastAdGroupIndex = this.A09.A04(postrollAdCount);
        if (lastAdGroupIndex == -1) {
            return false;
        }
        if (((zA00 && r5.A00 == postrollAdCount && r5.A01 == lastAdGroupIndex + (-1)) ? 1 : 0) == 0) {
            return !zA00 && this.A09.A05(postrollAdCount) == lastAdGroupIndex;
        }
        return true;
    }

    private boolean A0A(Timeline timeline, R5 r5, boolean z) {
        int iA0A = timeline.A0A(r5.A04);
        return !timeline.A0K(timeline.A0H(iA0A, this.A09).A00, this.A0A).A0D && timeline.A0O(iA0A, this.A09, this.A0A, this.A01, this.A08) && z;
    }

    public final C1822Pa A0B() {
        if (this.A05 != null) {
            if (this.A05 == this.A06) {
                this.A06 = this.A05.A0I();
            }
            this.A05.A0M();
            this.A05 = this.A05.A0I();
            this.A00--;
            if (this.A00 == 0) {
                this.A04 = null;
            }
        } else {
            this.A05 = this.A04;
            this.A06 = this.A04;
        }
        return this.A05;
    }

    public final C1822Pa A0C() {
        AbstractC2388es.A08((this.A06 == null || this.A06.A0I() == null) ? false : true);
        this.A06 = this.A06.A0I();
        return this.A06;
    }

    public final C1822Pa A0D() {
        return A0N() ? this.A05 : this.A04;
    }

    public final C1822Pa A0E() {
        return this.A04;
    }

    public final C1822Pa A0F() {
        return this.A05;
    }

    public final C1822Pa A0G() {
        return this.A06;
    }

    public final C1824Pc A0H(long j, Q9 q9) {
        if (this.A04 == null) {
            return A01(q9);
        }
        return A02(q9.A04, this.A04, j);
    }

    public final R7 A0J(InterfaceC1854Qi[] interfaceC1854QiArr, long j, AbstractC2289dG abstractC2289dG, InterfaceC2295dM interfaceC2295dM, InterfaceC2151az interfaceC2151az, C1824Pc c1824Pc, C2290dH c2290dH) {
        long j2;
        if (this.A04 == null) {
            j2 = c1824Pc.A03 + j;
        } else {
            long jA0B = this.A04.A0B();
            C1822Pa c1822Pa = this.A04;
            if (A0B[3].charAt(1) != 'H') {
                throw new RuntimeException();
            }
            A0B[3] = "zHWg3XufUD4x9owY3MX12sZCE1mX9C1M";
            j2 = jA0B + c1822Pa.A00.A00;
        }
        C1822Pa c1822Pa2 = new C1822Pa(interfaceC1854QiArr, j2, abstractC2289dG, interfaceC2295dM, interfaceC2151az, c1824Pc, c2290dH);
        if (this.A04 != null) {
            AbstractC2388es.A08(A0N());
            this.A04.A0Q(c1822Pa2);
        }
        this.A07 = null;
        this.A04 = c1822Pa2;
        this.A00++;
        return c1822Pa2.A07;
    }

    public final R5 A0K(Timeline timeline, Object obj, long j) {
        return A06(timeline, obj, j, A00(timeline, obj), this.A09);
    }

    public final void A0L(long j) {
        if (this.A04 != null) {
            this.A04.A0P(j);
        }
    }

    public final void A0M(boolean z) {
        C1822Pa c1822PaA0D = A0D();
        if (c1822PaA0D != null) {
            this.A07 = z ? c1822PaA0D.A08 : null;
            this.A03 = c1822PaA0D.A00.A04.A03;
            c1822PaA0D.A0M();
            A0P(c1822PaA0D);
        } else if (!z) {
            this.A07 = null;
        }
        this.A05 = null;
        this.A04 = null;
        this.A06 = null;
        this.A00 = 0;
    }

    public final boolean A0N() {
        return this.A05 != null;
    }

    public final boolean A0O() {
        return this.A04 == null || (!this.A04.A00.A05 && this.A04.A0R() && this.A04.A00.A00 != -9223372036854775807L && this.A00 < 100);
    }

    public final boolean A0P(C1822Pa c1822Pa) {
        AbstractC2388es.A08(c1822Pa != null);
        boolean z = false;
        this.A04 = c1822Pa;
        while (c1822Pa.A0I() != null) {
            c1822Pa = c1822Pa.A0I();
            if (A0B[4].length() != 12) {
                throw new RuntimeException();
            }
            String[] strArr = A0B;
            strArr[5] = "PXXRnlvHglGbwzngMISaT0AmGuSqoNwV";
            strArr[0] = "y6YjVifC3nGC3RRKgqPm31YsH6YO2P7Q";
            if (c1822Pa == this.A06) {
                this.A06 = this.A05;
                z = true;
            }
            c1822Pa.A0M();
            if (A0B[6].charAt(9) != 'E') {
                this.A00--;
            } else {
                A0B[7] = "6bINXvk45MlUDGCq";
                this.A00--;
            }
        }
        this.A04.A0Q(null);
        return z;
    }

    public final boolean A0Q(Timeline timeline, int i) {
        this.A01 = i;
        return A08(timeline);
    }

    public final boolean A0R(Timeline timeline, R5 r5, long j) {
        int iA0A = timeline.A0A(r5.A04);
        C1822Pa c1822Pa = null;
        for (C1822Pa c1822PaA0D = A0D(); c1822PaA0D != null; c1822PaA0D = c1822PaA0D.A0I()) {
            if (c1822Pa == null) {
                C1824Pc c1824PcA0I = A0I(timeline, c1822PaA0D.A00);
                String[] strArr = A0B;
                String str = strArr[1];
                String str2 = strArr[2];
                int iCharAt = str.charAt(25);
                int periodIndex = str2.charAt(25);
                if (iCharAt == periodIndex) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A0B;
                strArr2[5] = "VTjbZelP28G7FA88L37nAoXgiFJBzNYI";
                strArr2[0] = "6KATzOF7QQGaxXxovrpsPaUNZg55Hmbo";
                c1822PaA0D.A00 = c1824PcA0I;
            } else {
                if (iA0A == -1 || !c1822PaA0D.A08.equals(timeline.A0M(iA0A))) {
                    return true ^ A0P(c1822Pa);
                }
                C1824Pc c1824PcA02 = A02(timeline, c1822Pa, j);
                if (c1824PcA02 == null) {
                    return true ^ A0P(c1822Pa);
                }
                C1824Pc c1824Pc = c1822PaA0D.A00;
                if (A0B[7].length() != 16) {
                    c1822PaA0D.A00 = A0I(timeline, c1824Pc);
                    if (!A07(c1822PaA0D, c1824PcA02)) {
                        return true ^ A0P(c1822Pa);
                    }
                } else {
                    A0B[6] = "nYfKrQ9J8EEoOgZWpnsyQE7dAEB6YU7S";
                    c1822PaA0D.A00 = A0I(timeline, c1824Pc);
                    if (!A07(c1822PaA0D, c1824PcA02)) {
                        return true ^ A0P(c1822Pa);
                    }
                }
            }
            if (c1822PaA0D.A00.A07) {
                iA0A = timeline.A09(iA0A, this.A09, this.A0A, this.A01, this.A08);
            }
            c1822Pa = c1822PaA0D;
            String[] strArr3 = A0B;
            String str3 = strArr3[5];
            String str4 = strArr3[0];
            int iCharAt2 = str3.charAt(10);
            int periodIndex2 = str4.charAt(10);
            if (iCharAt2 != periodIndex2) {
                throw new RuntimeException();
            }
            String[] strArr4 = A0B;
            strArr4[5] = "mjwvmj0ClgGUVwwCxWP9gHcghfZdz63j";
            strArr4[0] = "bNbb3gsICTG9njkqttgYr3lisYeg9cbO";
        }
        return true;
    }

    public final boolean A0S(Timeline timeline, boolean z) {
        this.A08 = z;
        return A08(timeline);
    }

    public final boolean A0T(R7 r7) {
        return this.A04 != null && this.A04.A07 == r7;
    }
}
