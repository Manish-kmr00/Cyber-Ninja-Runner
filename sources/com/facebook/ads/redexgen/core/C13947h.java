package com.facebook.ads.redexgen.core;

import android.net.Uri;
import android.os.Handler;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import com.google.android.exoplayer2.Metadata;
import com.google.android.exoplayer2.extractor.metadata.icy.IcyHeaders;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.7h, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C13947h implements R7, UL, InterfaceC2338e4<R3>, InterfaceC2342e8, InterfaceC2176bR {
    public static byte[] A0e;
    public static String[] A0f = {"HhHmJF5YcsWodLjf10jFDxaODElYAWQn", "5hQ1HJFIxjmVaMwcXFbTKj8OtZuuy", "kE2D10B6Ev7c6Sgq3nfBneiFw0eHk", "5uBvXgNz7EkQWm0iGI8o4E2FlOofQ", "YwGYH96vbY1RRDrN8jcX0xGsVYMCyKKC", "1BWf5FL3j4tDEkgwTw7oWfxIye2NJtmG", "7n0fNQHsxJP6Ue", "AJcAEryrL7779osUrqyWKoBm5UgSp6kX"};
    public static final ZM A0g;
    public static final Map<String, String> A0h;
    public int A00;
    public int A01;
    public int A02;
    public long A03;
    public long A04;
    public long A05;
    public Uj A06;
    public IcyHeaders A07;
    public R8 A08;
    public C2171bM A09;
    public boolean A0A;
    public boolean A0B;
    public boolean A0C;
    public boolean A0D;
    public boolean A0E;
    public boolean A0F;
    public boolean A0G;
    public boolean A0H;
    public boolean A0I;
    public boolean A0J;
    public C2170bL[] A0K;
    public C1866Qv[] A0L;
    public final long A0M;
    public final Uri A0N;
    public final Handler A0O;
    public final TJ A0P;
    public final TO A0Q;
    public final C2159bA A0R;
    public final InterfaceC2164bF A0S;
    public final InterfaceC2169bK A0T;
    public final InterfaceC2295dM A0U;
    public final Q7 A0V;
    public final InterfaceC2335e1 A0W;
    public final C1831Pj A0X;
    public final C2398f2 A0Y;
    public final Runnable A0Z;
    public final Runnable A0a;
    public final String A0b;
    public final boolean A0c;

    @MetaExoPlayerCustomization(type = {"NEW_CLASS_ARG"})
    public final boolean A0d;

    public static String A0B(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0e, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            int i5 = (bArrCopyOfRange[i4] - i3) - 16;
            if (A0f[4].length() != 32) {
                throw new RuntimeException();
            }
            String[] strArr = A0f;
            strArr[3] = "y68EVoBxdY5TfdR8CpRnFIaUEOMSi";
            strArr[6] = "x3u0FCkiZHZvLp";
            bArrCopyOfRange[i4] = (byte) i5;
        }
        return new String(bArrCopyOfRange);
    }

    public static void A0I() {
        A0e = new byte[]{-114, -102, -76, -54, 126, -98, -74, -59, -78, -107, -78, -59, -78, -59, -24, -38, -35, -34, -21, -77, -55, -21, -24, -32, -21, -34, -20, -20, -30, -17, -34, -58, -34, -35, -30, -38, -55, -34, -21, -30, -24, -35, -60, -25, -39, -36, -31, -26, -33, -104, -34, -31, -26, -31, -21, -32, -35, -36, -104, -38, -35, -34, -25, -22, -35, -104, -24, -22, -35, -24, -39, -22, -39, -20, -31, -25, -26, -104, -31, -21, -104, -37, -25, -27, -24, -28, -35, -20, -35, -90, 123, -98, -112, -109, -104, -99, -106, 79, -107, -104, -99, -104, -94, -105, -108, -109, 79, -111, -108, -107, -98, -95, -108, 79, -97, -95, -108, -97, -112, -95, -112, -93, -104, -98, -99, 79, -104, -94, 79, -110, -98, -100, -97, -101, -108, -93, -108, 93, 79, -124, -127, 120, 105, 79, -28, -13, -13, -17, -20, -26, -28, -9, -20, -14, -15, -78, -5, -80, -20, -26, -4, -122, -128, -106, -102, -95, -104, -104};
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    @Override // com.facebook.ads.redexgen.core.R7
    public final long AIF(QD[] qdArr, boolean[] zArr, InterfaceC2180bV[] interfaceC2180bVArr, boolean[] zArr2, long j) {
        int i;
        int i2;
        A0E();
        C1863Qs c1863Qs = this.A09.A00;
        boolean[] zArr3 = this.A09.A01;
        int i3 = this.A01;
        int i4 = 0;
        while (true) {
            i = 0;
            if (i4 >= qdArr.length) {
                break;
            }
            if (interfaceC2180bVArr[i4] != null && (qdArr[i4] == null || !zArr[i4])) {
                int i5 = ((R1) interfaceC2180bVArr[i4]).A00;
                AbstractC2388es.A08(zArr3[i5]);
                this.A01--;
                zArr3[i5] = false;
                interfaceC2180bVArr[i4] = null;
            }
            i4++;
        }
        boolean z = !this.A0J ? j == 0 : i3 != 0;
        for (int i6 = 0; i6 < qdArr.length; i6++) {
            if (interfaceC2180bVArr[i6] == null && qdArr[i6] != null) {
                QD qd = qdArr[i6];
                AbstractC2388es.A08(qd.length() == 1);
                AbstractC2388es.A08(qd.A87(0) == 0);
                int iA04 = c1863Qs.A04(qd.A9B());
                AbstractC2388es.A08(!zArr3[iA04]);
                this.A01++;
                zArr3[iA04] = true;
                interfaceC2180bVArr[i6] = new R1(this, iA04);
                zArr2[i6] = true;
                if (!z) {
                    C1866Qv c1866Qv = this.A0L[iA04];
                    z = (c1866Qv.A0f(j, true) || c1866Qv.A0O() == 0) ? false : true;
                }
            }
        }
        if (this.A01 != 0) {
            if (z) {
                j = AIE(j, false);
                if (A0f[7].charAt(31) != '4') {
                    A0f[7] = "3IHVhVDJhWfNhoMnKwCP3ugaZG5QyoFr";
                    i2 = 0;
                } else {
                    i2 = 0;
                }
                while (i2 < interfaceC2180bVArr.length) {
                    InterfaceC2180bV interfaceC2180bV = interfaceC2180bVArr[i2];
                    String[] strArr = A0f;
                    if (strArr[3].length() == strArr[6].length()) {
                        throw new RuntimeException();
                    }
                    String[] strArr2 = A0f;
                    strArr2[1] = "6Ls6DGwEhxOsIdfSFdX0Zn86CPQag";
                    strArr2[2] = "4E0A1HTbBIqOovQWzP1hrM6r0OPfy";
                    if (interfaceC2180bV != null) {
                        zArr2[i2] = true;
                    }
                    i2++;
                }
            }
            this.A0J = true;
            return j;
        }
        this.A0F = false;
        this.A0E = false;
        if (this.A0X.A0E()) {
            C1866Qv[] c1866QvArr = this.A0L;
            String[] strArr3 = A0f;
            if (strArr3[1].length() == strArr3[2].length()) {
                String[] strArr4 = A0f;
                strArr4[3] = "qRltZSkGuu5Z2WrcAAqPQRzeNotJM";
                strArr4[6] = "f3Gq0TAmo8XFcO";
                int length = c1866QvArr.length;
                while (i < length) {
                    c1866QvArr[i].A0V();
                    i++;
                }
                this.A0X.A09();
            }
            throw new RuntimeException();
        }
        C1866Qv[] c1866QvArr2 = this.A0L;
        int length2 = c1866QvArr2.length;
        while (i < length2) {
            c1866QvArr2[i].A0Z();
            i++;
        }
        this.A0J = true;
        return j;
    }

    static {
        A0I();
        A0h = A0D();
        A0g = new P5().A0y(A0B(161, 3, 13)).A11(A0B(144, 17, 115)).A14();
    }

    public C13947h(Uri uri, Q7 q7, InterfaceC2164bF interfaceC2164bF, TO to, TJ tj, InterfaceC2335e1 interfaceC2335e1, C2159bA c2159bA, InterfaceC2169bK interfaceC2169bK, InterfaceC2295dM interfaceC2295dM, String str, int i, InterfaceExecutorC2450ft interfaceExecutorC2450ft) {
        C1831Pj c1831Pj;
        this.A0N = uri;
        this.A0V = q7;
        this.A0Q = to;
        this.A0P = tj;
        this.A0W = interfaceC2335e1;
        this.A0R = c2159bA;
        this.A0T = interfaceC2169bK;
        this.A0U = interfaceC2295dM;
        this.A0b = str;
        this.A0M = i;
        if (interfaceExecutorC2450ft != null) {
            c1831Pj = new C1831Pj(interfaceExecutorC2450ft);
        } else {
            c1831Pj = new C1831Pj(A0B(13, 29, 105));
        }
        this.A0X = c1831Pj;
        this.A0S = interfaceC2164bF;
        this.A0Y = new C2398f2();
        this.A0Z = new Runnable() { // from class: com.facebook.ads.redexgen.X.bG
            @Override // java.lang.Runnable
            public final void run() {
                this.A00.A0F();
            }
        };
        this.A0a = new Runnable() { // from class: com.facebook.ads.redexgen.X.bH
            @Override // java.lang.Runnable
            public final void run() {
                this.A00.A0b();
            }
        };
        this.A0O = AbstractC2471gE.A0Y();
        this.A0K = new C2170bL[0];
        this.A0L = new C1866Qv[0];
        this.A05 = -9223372036854775807L;
        this.A03 = -9223372036854775807L;
        this.A00 = 1;
        this.A0d = MetaExoPlayerUpgradeConfig.A03(EnumC1764Mn.A0d) || MetaExoPlayerUpgradeConfig.A03(EnumC1764Mn.A0e) || MetaExoPlayerUpgradeConfig.A03(EnumC1764Mn.A1X);
        this.A0c = MetaExoPlayerUpgradeConfig.A03(EnumC1764Mn.A0g);
    }

    private int A00() {
        int i = 0;
        for (C1866Qv c1866Qv : this.A0L) {
            int extractedSamplesCount = c1866Qv.A0P();
            i += extractedSamplesCount;
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long A03(boolean z) {
        long jMax = Long.MIN_VALUE;
        for (int i = 0; i < this.A0L.length; i++) {
            if (z || ((C2171bM) AbstractC2388es.A01(this.A09)).A01[i]) {
                long largestQueuedTimestampUs = this.A0L[i].A0T();
                jMax = Math.max(jMax, largestQueuedTimestampUs);
            }
        }
        return jMax;
    }

    private C1866Qv A08(C2170bL c2170bL) {
        int length = this.A0L.length;
        for (int i = 0; i < length; i++) {
            if (c2170bL.equals(this.A0K[i])) {
                return this.A0L[i];
            }
        }
        C1866Qv c1866QvA0B = C1866Qv.A0B(this.A0U, this.A0Q, this.A0P);
        c1866QvA0B.A0d(this);
        int trackCount = length + 1;
        C2170bL[] c2170bLArr = (C2170bL[]) Arrays.copyOf(this.A0K, trackCount);
        c2170bLArr[length] = c2170bL;
        this.A0K = (C2170bL[]) AbstractC2471gE.A1H(c2170bLArr);
        int trackCount2 = length + 1;
        C1866Qv[] c1866QvArr = (C1866Qv[]) Arrays.copyOf(this.A0L, trackCount2);
        c1866QvArr[length] = c1866QvA0B;
        this.A0L = (C1866Qv[]) AbstractC2471gE.A1H(c1866QvArr);
        return c1866QvA0B;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.core.InterfaceC2338e4
    /* JADX INFO: renamed from: A09, reason: merged with bridge method [inline-methods] */
    public final C2339e5 ADt(R3 r3, long j, long j2, IOException iOException, int i) {
        C2339e5 c2339e5A01;
        AnonymousClass51 anonymousClass51 = r3.A0A;
        C2143ar c2143ar = new C2143ar(r3.A05, r3.A02, anonymousClass51.A01(), anonymousClass51.A02(), j, j2, anonymousClass51.A00());
        long jA8k = this.A0W.A8k(new C2334e0(c2143ar, new C2146au(1, -1, null, 0, null, AbstractC2471gE.A0P(r3.A00), AbstractC2471gE.A0P(this.A03)), iOException, i));
        if (jA8k == -9223372036854775807L) {
            c2339e5A01 = C1831Pj.A06;
        } else {
            int iA00 = A00();
            boolean z = iA00 > this.A02;
            if (A0U(r3, iA00)) {
                c2339e5A01 = C1831Pj.A01(z, jA8k);
            } else {
                c2339e5A01 = C1831Pj.A05;
            }
        }
        this.A0R.A07(c2143ar, 1, -1, null, 0, null, r3.A00, this.A03, iOException, !c2339e5A01.A02());
        return c2339e5A01;
    }

    public static Map<String, String> A0D() {
        HashMap map = new HashMap();
        map.put(A0B(1, 12, 65), A0B(0, 1, 77));
        Map<String, String> headers = Collections.unmodifiableMap(map);
        return headers;
    }

    @EnsuresNonNull({"trackState", "seekMap"})
    private void A0E() {
        AbstractC2388es.A08(this.A0G);
        AbstractC2388es.A01(this.A09);
        AbstractC2388es.A01(this.A06);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:34:0x0080  */
    /* JADX WARN: Code duplicated, block: B:36:0x0084  */
    /* JADX WARN: Code duplicated, block: B:47:0x00c5  */
    public void A0F() {
        Metadata metadata;
        Metadata metadataA05;
        if (this.A0H || this.A0G || !this.A0I || this.A06 == null) {
            return;
        }
        for (C1866Qv c1866Qv : this.A0L) {
            if (c1866Qv.A0U() == null) {
                return;
            }
        }
        this.A0Y.A02();
        int length = this.A0L.length;
        C2046Yc[] c2046YcArr = new C2046Yc[length];
        boolean[] zArr = new boolean[length];
        for (int i = 0; i < length; i++) {
            ZM zmA14 = (ZM) AbstractC2388es.A01(this.A0L[i].A0U());
            String str = zmA14.A0W;
            boolean zA0C = Q2.A0C(str);
            boolean z = zA0C || Q2.A0F(str);
            zArr[i] = z;
            this.A0A |= z;
            IcyHeaders icyHeaders = this.A07;
            if (icyHeaders != null) {
                if (zA0C) {
                    metadata = zmA14.A0P;
                    if (metadata == null) {
                        metadataA05 = new Metadata(icyHeaders);
                    } else {
                        metadataA05 = metadata.A05(icyHeaders);
                    }
                    zmA14 = zmA14.A07().A0v(metadataA05).A14();
                } else {
                    boolean z2 = this.A0K[i].A01;
                    if (A0f[4].length() != 32) {
                        throw new RuntimeException();
                    }
                    A0f[4] = "VDPkeeOQvw3x7zyzd7KzJaBy1xkVXWXl";
                    if (z2) {
                        metadata = zmA14.A0P;
                        if (metadata == null) {
                            metadataA05 = new Metadata(icyHeaders);
                        } else {
                            metadataA05 = metadata.A05(icyHeaders);
                        }
                        zmA14 = zmA14.A07().A0v(metadataA05).A14();
                    }
                }
                if (zA0C) {
                    int trackCount = zmA14.A04;
                    if (trackCount == -1) {
                        int trackCount2 = zmA14.A0D;
                        if (trackCount2 == -1) {
                            int trackCount3 = icyHeaders.A00;
                            if (trackCount3 != -1) {
                                P5 p5A07 = zmA14.A07();
                                int trackCount4 = icyHeaders.A00;
                                zmA14 = p5A07.A0a(trackCount4).A14();
                            }
                        }
                    }
                }
            }
            c2046YcArr[i] = new C2046Yc(zmA14);
        }
        this.A09 = new C2171bM(new C1863Qs(c2046YcArr), zArr);
        this.A0G = true;
        ((R8) AbstractC2388es.A01(this.A08)).AEd(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0G() {
        this.A0O.post(new Runnable() { // from class: com.facebook.ads.redexgen.X.bI
            @Override // java.lang.Runnable
            public final void run() {
                this.A00.A0c();
            }
        });
    }

    private void A0H() {
        R3 r3 = new R3(this, this.A0N, this.A0V, this.A0S, this, this.A0Y);
        if (this.A0G) {
            AbstractC2388es.A08(A0S());
            if (this.A03 != -9223372036854775807L && this.A05 >= this.A03) {
                this.A0D = true;
                this.A05 = -9223372036854775807L;
                return;
            }
            r3.A04(((Uj) AbstractC2388es.A01(this.A06)).A8r(this.A05).A00.A00, this.A05);
            for (C1866Qv c1866Qv : this.A0L) {
                c1866Qv.A0b(this.A05);
            }
            this.A05 = -9223372036854775807L;
        }
        this.A02 = A00();
        this.A0R.A06(new C2143ar(r3.A05, r3.A02, this.A0X.A08(r3, this, this.A0W.A8P(this.A00))), 1, -1, null, 0, null, r3.A00, this.A03, 0);
    }

    private final void A0J() throws IOException {
        this.A0X.A0B(this.A0W.A8P(this.A00));
    }

    private void A0K(int i) {
        A0E();
        boolean[] zArr = this.A09.A03;
        if (!zArr[i]) {
            ZM zmA08 = this.A09.A00.A05(i).A08(0);
            String[] strArr = A0f;
            if (strArr[3].length() == strArr[6].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0f;
            strArr2[0] = "vc2T8OhAXRcAAc3hAhm1OHzRbXIwU20j";
            strArr2[5] = "1a2wqUy3SsTxWpCxKacNfhORpOU8UVUN";
            this.A0R.A03(Q2.A01(zmA08.A0W), zmA08, 0, null, this.A04);
            zArr[i] = true;
        }
    }

    private void A0L(int i) {
        A0E();
        boolean[] zArr = this.A09.A02;
        if (this.A0F && zArr[i]) {
            if (this.A0L[i].A0g(false)) {
                return;
            }
            this.A05 = 0L;
            this.A0F = false;
            this.A0E = true;
            this.A04 = 0L;
            this.A02 = 0;
            for (C1866Qv c1866Qv : this.A0L) {
                c1866Qv.A0Z();
            }
            ((R8) AbstractC2388es.A01(this.A08)).ACl(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: A0M, reason: merged with bridge method [inline-methods] */
    public void A0e(Uj uj) {
        this.A06 = uj;
        this.A03 = uj.A7j();
        this.A0C = !this.A0B && uj.A7j() == -9223372036854775807L;
        this.A00 = this.A0C ? 7 : 1;
        this.A0T.AF9(this.A03, uj.AAY(), this.A0C);
        if (!this.A0G) {
            A0F();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.core.InterfaceC2338e4
    /* JADX INFO: renamed from: A0N, reason: merged with bridge method [inline-methods] */
    public final void ADs(R3 r3, long j, long j2) {
        long largestQueuedTimestampUs;
        if (this.A03 == -9223372036854775807L && this.A06 != null) {
            boolean zAAY = this.A06.AAY();
            long jA03 = A03(true);
            if (jA03 == Long.MIN_VALUE) {
                largestQueuedTimestampUs = 0;
            } else {
                largestQueuedTimestampUs = 10000 + jA03;
            }
            this.A03 = largestQueuedTimestampUs;
            this.A0T.AF9(this.A03, zAAY, this.A0C);
        }
        AnonymousClass51 anonymousClass51 = r3.A0A;
        this.A0R.A08(new C2143ar(r3.A05, r3.A02, anonymousClass51.A01(), anonymousClass51.A02(), j, j2, anonymousClass51.A00()), 1, -1, null, 0, null, r3.A00, this.A03, r3, null);
        this.A0D = true;
        ((R8) AbstractC2388es.A01(this.A08)).ACl(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.core.InterfaceC2338e4
    /* JADX INFO: renamed from: A0O, reason: merged with bridge method [inline-methods] */
    public final void ADw(R3 r3, long j, long j2, int i) {
        C2143ar c2143ar;
        AnonymousClass51 dataSource = r3.A0A;
        if (i == 0) {
            c2143ar = new C2143ar(r3.A05, r3.A02, j);
        } else {
            c2143ar = new C2143ar(r3.A05, r3.A02, dataSource.A01(), dataSource.A02(), j, j2, dataSource.A00());
        }
        this.A0R.A06(c2143ar, 1, -1, null, 0, null, r3.A00, this.A03, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.core.InterfaceC2338e4
    /* JADX INFO: renamed from: A0P, reason: merged with bridge method [inline-methods] */
    public final void ADq(R3 r3, long j, long j2, boolean z) {
        AnonymousClass51 dataSource = r3.A0A;
        this.A0R.A05(new C2143ar(r3.A05, r3.A02, dataSource.A01(), dataSource.A02(), j, j2, dataSource.A00()), 1, -1, null, 0, null, r3.A00, this.A03);
        if (!z) {
            C1866Qv[] c1866QvArr = this.A0L;
            String[] strArr = A0f;
            if (strArr[1].length() != strArr[2].length()) {
                throw new RuntimeException();
            }
            A0f[7] = "YnZIzTizfMz6VgYwxmvgcnSp4WbTty4b";
            for (C1866Qv c1866Qv : c1866QvArr) {
                c1866Qv.A0Z();
            }
            if (this.A01 > 0) {
                ((R8) AbstractC2388es.A01(this.A08)).ACl(this);
            }
        }
    }

    private boolean A0S() {
        return this.A05 != -9223372036854775807L;
    }

    private boolean A0T() {
        return this.A0E || A0S();
    }

    private boolean A0U(R3 r3, int i) {
        if (this.A0B || (this.A06 != null && this.A06.A7j() != -9223372036854775807L)) {
            this.A02 = i;
            return true;
        }
        if (this.A0G && !A0T()) {
            this.A0F = true;
            return false;
        }
        this.A0E = this.A0G;
        this.A04 = 0L;
        this.A02 = 0;
        for (C1866Qv c1866Qv : this.A0L) {
            c1866Qv.A0Z();
        }
        r3.A04(0L, 0L);
        String[] strArr = A0f;
        if (strArr[0].charAt(7) == strArr[5].charAt(7)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0f;
        strArr2[1] = "yjCUTSJDo3L43308C8DGBBYCvEyZb";
        strArr2[2] = "5jKJJIOTTwVtB9vSmxruxMg3X2EZ9";
        return true;
    }

    private boolean A0V(boolean[] zArr, long j) {
        int length = this.A0L.length;
        for (int i = 0; i < length; i++) {
            if (!this.A0L[i].A0f(j, false)) {
                boolean z = zArr[i];
                String[] strArr = A0f;
                String str = strArr[1];
                String str2 = strArr[2];
                int i2 = str.length();
                int trackCount = str2.length();
                if (i2 != trackCount) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A0f;
                strArr2[3] = "SITNFu75AMDVq0Iha3QdupKHiKZ3f";
                strArr2[6] = "Om4ZIYUVKZUZgG";
                if (!z) {
                    boolean z2 = this.A0A;
                    String[] strArr3 = A0f;
                    String str3 = strArr3[3];
                    String str4 = strArr3[6];
                    int i3 = str3.length();
                    int trackCount2 = str4.length();
                    if (i3 == trackCount2) {
                        throw new RuntimeException();
                    }
                    String[] strArr4 = A0f;
                    strArr4[3] = "dAC8sfy47OtRs99iYTjzGuYCOqiPq";
                    strArr4[6] = "iHcX590VZBgkVW";
                    if (!z2) {
                    }
                }
                return false;
            }
        }
        return true;
    }

    public final int A0X(int i, long j) {
        if (A0T()) {
            return 0;
        }
        A0K(i);
        C1866Qv c1866Qv = this.A0L[i];
        int iA0Q = c1866Qv.A0Q(j, this.A0D);
        c1866Qv.A0a(iA0Q);
        if (iA0Q == 0) {
            A0L(i);
        }
        return iA0Q;
    }

    public final int A0Y(int i, P6 p6, C2014Ww c2014Ww, int i2) {
        if (A0T()) {
            return -3;
        }
        A0K(i);
        int result = this.A0L[i].A0R(p6, c2014Ww, i2, this.A0D);
        if (result == -3) {
            A0L(i);
        }
        return result;
    }

    public final InterfaceC1957Uo A0Z() {
        return A08(new C2170bL(0, true));
    }

    public final void A0a() {
        if (this.A0G) {
            for (C1866Qv c1866Qv : this.A0L) {
                c1866Qv.A0X();
            }
        }
        this.A0X.A0C(this);
        this.A0O.removeCallbacksAndMessages(null);
        this.A08 = null;
        String[] strArr = A0f;
        if (strArr[0].charAt(7) == strArr[5].charAt(7)) {
            throw new RuntimeException();
        }
        A0f[4] = "MVLpl5KepuXzKUIiq8jlMIL6Wjy59Ljt";
        this.A0H = true;
    }

    public final /* synthetic */ void A0b() {
        if (!this.A0H) {
            ((R8) AbstractC2388es.A01(this.A08)).ACl(this);
        }
    }

    public final /* synthetic */ void A0c() {
        this.A0B = true;
    }

    public final void A0d(int i) throws IOException {
        this.A0L[i].A0W();
        A0J();
    }

    public final boolean A0f(int i) {
        if (!A0T()) {
            boolean zA0g = this.A0L[i].A0g(this.A0D);
            String[] strArr = A0f;
            if (strArr[3].length() == strArr[6].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0f;
            strArr2[3] = "XxDgOD8mb6TyNFZSs9dwq1kvHo2ku";
            strArr2[6] = "3TQJKPdccBkaU7";
            if (zA0g) {
                return true;
            }
        }
        return false;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2184bZ
    @MetaExoPlayerCustomization("Added in D19760981 for cancel request")
    public final void A4i(long j) {
    }

    @Override // com.facebook.ads.redexgen.core.R7
    public final boolean A52(long j) {
        if (!this.A0D) {
            boolean zA0D = this.A0X.A0D();
            if (A0f[7].charAt(31) == '4') {
                throw new RuntimeException();
            }
            String[] strArr = A0f;
            strArr[0] = "gwE3QleYkKBsSTL3UZjmguRQKvSEq6BH";
            strArr[5] = "C5V8daFPbEcNHkp1V3F9i9HkA2Rq8mw0";
            if (zA0D || this.A0F) {
                return false;
            }
            if (this.A0G && this.A01 == 0) {
                return false;
            }
            boolean zA04 = this.A0Y.A04();
            boolean continuedLoading = this.A0X.A0E();
            if (!continuedLoading) {
                A0H();
                return true;
            }
            return zA04;
        }
        return false;
    }

    @Override // com.facebook.ads.redexgen.core.R7
    public final void A5q(long j, boolean z) {
        A0E();
        if (A0S()) {
            return;
        }
        boolean[] zArr = this.A09.A01;
        String[] strArr = A0f;
        if (strArr[0].charAt(7) == strArr[5].charAt(7)) {
            throw new RuntimeException();
        }
        A0f[7] = "5ipg9mBpoWMhELrV0qCvKtmQyRgycIrL";
        int length = this.A0L.length;
        for (int trackCount = 0; trackCount < length; trackCount++) {
            this.A0L[trackCount].A0c(j, z, zArr[trackCount]);
        }
    }

    @Override // com.facebook.ads.redexgen.core.UL
    public final void A6E() {
        this.A0I = true;
        this.A0O.post(this.A0Z);
    }

    @Override // com.facebook.ads.redexgen.core.R7
    public final long A6h(long j, C1859Qn c1859Qn) {
        A0E();
        if (!this.A06.AAY()) {
            return 0L;
        }
        C1953Ui c1953UiA8r = this.A06.A8r(j);
        return c1859Qn.A00(j, c1953UiA8r.A00.A01, c1953UiA8r.A01.A01);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2184bZ
    @MetaExoPlayerCustomization(type = {"NEW_METHOD"}, value = "Added in D9949576 for unstall buffer")
    public final long A6w(long j) {
        if (this.A0d && !this.A0G) {
            return 0L;
        }
        if (this.A0D) {
            return this.A03 - j;
        }
        return A6y() - j;
    }

    @Override // com.facebook.ads.redexgen.core.R7
    public final long A6y() {
        A0E();
        if (this.A0D || this.A01 == 0) {
            return Long.MIN_VALUE;
        }
        if (A0S()) {
            return this.A05;
        }
        long largestQueuedTimestampUs = Long.MAX_VALUE;
        if (this.A0A) {
            int i = this.A0L.length;
            for (int i2 = 0; i2 < i; i2++) {
                if (this.A09.A02[i2] && this.A09.A01[i2] && !this.A0L[i2].A0e()) {
                    largestQueuedTimestampUs = Math.min(largestQueuedTimestampUs, this.A0L[i2].A0T());
                }
            }
        }
        if (largestQueuedTimestampUs == Long.MAX_VALUE) {
            largestQueuedTimestampUs = A03(false);
        }
        if (largestQueuedTimestampUs == Long.MIN_VALUE) {
            return this.A04;
        }
        return largestQueuedTimestampUs;
    }

    @Override // com.facebook.ads.redexgen.core.R7
    public final long A8R() {
        return A6y();
    }

    @Override // com.facebook.ads.redexgen.core.R7
    public final C1863Qs A9C() {
        A0E();
        return this.A09.A00;
    }

    @Override // com.facebook.ads.redexgen.core.R7
    public final void ABn() throws IOException {
        A0J();
        if (this.A0D && !this.A0G) {
            if (this.A0c) {
                throw Q6.A01(A0B(90, 54, 31) + (this.A0N != null ? this.A0N.toString() : A0B(164, 4, 28)), null);
            }
            throw Q6.A01(A0B(42, 48, 104), null);
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2342e8
    public final void ADx() {
        for (C1866Qv c1866Qv : this.A0L) {
            c1866Qv.A0Y();
        }
        this.A0S.AGj();
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2176bR
    public final void AFT(ZM zm) {
        this.A0O.post(this.A0Z);
    }

    @Override // com.facebook.ads.redexgen.core.R7
    public final void AGD(R8 r8, long j) {
        this.A08 = r8;
        this.A0Y.A04();
        A0H();
    }

    @Override // com.facebook.ads.redexgen.core.R7
    public final long AGY() {
        if (this.A0E && (this.A0D || A00() > this.A02)) {
            this.A0E = false;
            return this.A04;
        }
        String[] strArr = A0f;
        if (strArr[3].length() == strArr[6].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0f;
        strArr2[3] = "p4tuvMsP4ps7LSohAdGPatWy7tjO5";
        strArr2[6] = "M94GAlCEOW4fph";
        return -9223372036854775807L;
    }

    @Override // com.facebook.ads.redexgen.core.R7
    public final void AGe(long j) {
    }

    @Override // com.facebook.ads.redexgen.core.UL
    public final void AID(final Uj uj) {
        this.A0O.post(new Runnable() { // from class: com.facebook.ads.redexgen.X.bJ
            @Override // java.lang.Runnable
            public final void run() {
                this.A01.A0e(uj);
            }
        });
    }

    @Override // com.facebook.ads.redexgen.core.R7
    public final long AIE(@MetaExoPlayerCustomization long j, boolean z) {
        A0E();
        boolean[] zArr = this.A09.A02;
        if (!this.A06.AAY()) {
            j = 0;
        }
        int i = 0;
        this.A0E = false;
        this.A04 = j;
        if (A0S()) {
            this.A05 = j;
            return j;
        }
        int i2 = this.A00;
        if (A0f[4].length() != 32) {
            throw new RuntimeException();
        }
        A0f[7] = "uBOY0ivsuv8M4GXYtHaE4uN838wHwhse";
        if (i2 != 7 && A0V(zArr, j)) {
            return j;
        }
        this.A0F = false;
        this.A05 = j;
        this.A0D = false;
        if (this.A0X.A0E()) {
            C1866Qv[] c1866QvArr = this.A0L;
            int length = c1866QvArr.length;
            while (i < length) {
                c1866QvArr[i].A0V();
                i++;
            }
            this.A0X.A09();
        } else {
            this.A0X.A0A();
            C1866Qv[] c1866QvArr2 = this.A0L;
            int length2 = c1866QvArr2.length;
            while (i < length2) {
                c1866QvArr2[i].A0Z();
                i++;
            }
        }
        return j;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2184bZ
    @MetaExoPlayerCustomization("Added in D19875605 for error load during pause")
    public final void AIi(boolean z) {
    }

    @Override // com.facebook.ads.redexgen.core.UL
    public final InterfaceC1957Uo AJX(int i, int i2) {
        return A08(new C2170bL(i, false));
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2184bZ
    @MetaExoPlayerCustomization("Added in D13267633 for lower priority during pause")
    public final void AJg(byte b) {
    }
}
