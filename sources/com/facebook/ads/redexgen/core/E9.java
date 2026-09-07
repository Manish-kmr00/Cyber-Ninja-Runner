package com.facebook.ads.redexgen.core;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.Pair;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import com.google.android.exoplayer2.Timeline;
import com.vungle.ads.internal.protos.Sdk;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class E9 extends AbstractC2079Zl implements ZQ {
    public static byte[] A0n;
    public static String[] A0o = {"iBNHMNbHG0fKAf2eT5kteN1U39G3EcaH", "qXz", "R2ftQy6AiucGxM1Guxwgd25aR6ARlJ6P", "MxLPYGObrf", "8LF26nOw5DTYaTjfwiGKhulxAaOiFxz", "XeMY99wdFq", "3rP", "hv8hVuouCW0CllFLblAVrkZkkmaGvgpz"};
    public float A00;
    public int A01;
    public int A02;
    public int A03;
    public int A04;
    public int A05;
    public int A06;
    public long A07;
    public long A08;
    public C2080Zm A09;
    public EK A0A;
    public ZC A0B;
    public ZC A0C;
    public ZC A0D;
    public Q9 A0E;
    public C2064Yv A0F;
    public C2062Yt A0G;
    public C1859Qn A0H;
    public Y2 A0I;
    public InterfaceC2151az A0J;
    public C1851Qf A0K;
    public C2454fx A0L;
    public boolean A0M;
    public boolean A0N;
    public boolean A0O;
    public boolean A0P;
    public boolean A0Q;
    public boolean A0R;
    public boolean A0S;
    public final C2062Yt A0T;
    public final long A0U;
    public final long A0V;
    public final long A0W;
    public final Handler A0X;
    public final Handler A0Y;
    public final Looper A0Z;
    public final ZO A0a;
    public final E8 A0b;
    public final QQ A0c;
    public final C2050Yh A0d;
    public final InterfaceC2041Xx A0e;
    public final AbstractC2289dG A0f;
    public final C2290dH A0g;
    public final InterfaceC2395ez A0h;
    public final C2398f2 A0i;
    public final CopyOnWriteArraySet<OU> A0j;
    public final CopyOnWriteArraySet<QJ> A0k;
    public final boolean A0l;
    public final InterfaceC2059Yq[] A0m;

    public static String A04(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0n, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 18);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A06() {
        byte[] bArr = {111, -86, 110, -95, -104, 121, -107, -118, -94, -114, -101, 114, -106, -103, -107, -49, 2, -7, -38, -10, -21, 3, -17, -4, -42, -13, -20, -71, -68, -72, -62, -72, -69, -76, -39, -44, -33, -117, -54, -26, -37, -13, -33, -20, -102, -29, -19, -102, -37, -35, -35, -33, -19, -19, -33, -34, -102, -23, -24, -102, -18, -30, -33, -102, -15, -20, -23, -24, -31, -102, -18, -30, -20, -33, -37, -34, -88, -124, -67, -17, -20, -20, -33, -24, -18, -102, -18, -30, -20, -33, -37, -34, -76, -102, -95, -97, -19, -95, -124, -65, -14, -22, -33, -35, -18, -33, -34, -102, -18, -30, -20, -33, -37, -34, -76, -102, -95, -97, -19, -95, -124, -51, -33, -33, -102, -30, -18, -18, -22, -19, -76, -87, -87, -33, -14, -23, -22, -26, -37, -13, -33, -20, -88, -34, -33, -16, -87, -29, -19, -19, -17, -33, -19, -87, -22, -26, -37, -13, -33, -20, -89, -37, -35, -35, -33, -19, -19, -33, -34, -89, -23, -24, -89, -15, -20, -23, -24, -31, -89, -18, -30, -20, -33, -37, -34, -44, -25, -18, -25, -29, -11, -25, -94, -116, -74, 121, -76, -40, -41, -71, -43, -54, -30, -50, -37, -68, -35, -54, -35, -50, -84, -47, -54, -41, -48, -50, -51, -39, -53, -53, -47, -70, -43, -122, -49, -51, -44, -43, -40, -53, -54, -122, -56, -53, -55, -57, -37, -39, -53, -122, -57, -44, -122, -57, -54, -122, -49, -39, -122, -42, -46, -57, -33, -49, -44, -51};
        if (A0o[2].charAt(13) == 'n') {
            throw new RuntimeException();
        }
        A0o[4] = "kGOG9Dkm6QjnckS7AaOGsbFtb9YG94o";
        A0n = bArr;
    }

    static {
        A06();
    }

    public E9(InterfaceC2059Yq[] interfaceC2059YqArr, AbstractC2289dG abstractC2289dG, PC pc, InterfaceC2301dS interfaceC2301dS, InterfaceC2395ez interfaceC2395ez) {
        this(interfaceC2059YqArr, abstractC2289dG, pc, interfaceC2301dS, interfaceC2395ez, false, false, false, false, false, false, 0L, false, 0, false, false, false, false, false, false, false, null);
    }

    public E9(@MetaExoPlayerCustomization("qe_android_video_exoplayer2.update_loading_priority_exo2 is consistently false. We do not need to port this in the upgrade") InterfaceC2059Yq[] interfaceC2059YqArr, @MetaExoPlayerCustomization("Introduced in D13513334 and also used in loop playing for IG: D38285740") AbstractC2289dG abstractC2289dG, @MetaExoPlayerCustomization("Currently used to load chunks while seeking on pause D13827150") PC pc, @MetaExoPlayerCustomization("D40987428 Brought in for clippingmediasource") InterfaceC2301dS interfaceC2301dS, @MetaExoPlayerCustomization("D45597293 for Oculus - allowing the start renderer offset to not be 0; Eventually changed in Exo: https://github.com/google/ExoPlayer/commit/9f352434c72da527d1fa7963447c3cf680db884f") InterfaceC2395ez interfaceC2395ez, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, long j, boolean z7, int i, boolean z8, boolean z9, boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, QQ qq) {
        QQ qq2 = qq;
        Log.i(A04(2, 13, 23), A04(33, 5, 89) + Integer.toHexString(System.identityHashCode(this)) + A04(0, 2, 61) + A04(15, 18, 120) + A04(194, 3, 71) + AbstractC2471gE.A04 + A04(193, 1, 29));
        this.A0i = new C2398f2();
        try {
            this.A0M = z13;
            AbstractC2388es.A08(interfaceC2059YqArr.length > 0);
            this.A0m = (InterfaceC2059Yq[]) AbstractC2388es.A01(interfaceC2059YqArr);
            this.A0f = (AbstractC2289dG) AbstractC2388es.A01(abstractC2289dG);
            this.A0Q = false;
            this.A00 = 1.0f;
            this.A05 = 0;
            this.A0B = ZC.A0Z;
            this.A0C = ZC.A0Z;
            this.A0D = ZC.A0Z;
            this.A0S = false;
            this.A0V = 0L;
            this.A09 = C2080Zm.A07;
            this.A0W = 0L;
            this.A0k = new CopyOnWriteArraySet<>();
            this.A0U = 0L;
            InterfaceC2041Xx analyticsCollector = InterfaceC2041Xx.A00;
            this.A0e = analyticsCollector;
            this.A0H = C1859Qn.A04;
            this.A06 = 1;
            this.A0a = new ZO(null);
            this.A0g = new C2290dH(new C1857Ql[interfaceC2059YqArr.length], new QD[interfaceC2059YqArr.length], Y4.A02, null);
            this.A0d = new C2050Yh();
            this.A0T = new QE().A03(1, 2, 3, 13, 14, 15, 16, 17, 18, 19, 31, 20, 30, 21, 22, 23, 24, 25, 26, 27, 28).A01(29, abstractC2289dG.A0Y()).A04();
            this.A0G = new QE().A02(this.A0T).A00(4).A00(10).A04();
            this.A0K = C1851Qf.A03;
            this.A0F = C2064Yv.A06;
            this.A0Z = Looper.myLooper();
            this.A0X = new HandlerC1798Oa(this, Looper.myLooper() != null ? Looper.myLooper() : Looper.getMainLooper());
            this.A0h = interfaceC2395ez;
            this.A0c = qq2 == null ? this : qq2;
            this.A0E = new Q9(Timeline.A02, 0L, C1863Qs.A06, this.A0g);
            this.A0b = new E8(interfaceC2059YqArr, abstractC2289dG, this.A0g, pc, interfaceC2301dS, this.A0Q, this.A05, this.A0S, this.A0X, interfaceC2395ez, z, z2, z3, z4, z5, z6, j, z7, i, z8, z9, z10, z11, z12, z14, RK.A03);
            this.A0I = Y2.A05;
            this.A0L = C2454fx.A04;
            this.A0Y = new Handler(this.A0b.A1A());
            this.A0j = new CopyOnWriteArraySet<>();
        } finally {
            this.A0i.A04();
        }
    }

    private long A00(long j) {
        long jA01 = O5.A01(j);
        if (!this.A0E.A06.A00()) {
            Timeline timeline = this.A0E.A04;
            R5 r5 = this.A0E.A06;
            if (A0o[4].length() != 31) {
                throw new RuntimeException();
            }
            String[] strArr = A0o;
            strArr[5] = "nyIUf2bdJl";
            strArr[3] = "LlTu7Wlurx";
            timeline.A0J(r5.A04, this.A0d);
            long positionMs = this.A0d.A0B();
            return jA01 + positionMs;
        }
        return jA01;
    }

    private long A01(Timeline timeline, R5 r5, long j) {
        timeline.A0J(r5.A04, this.A0d);
        return j + this.A0d.A0C();
    }

    private Q9 A02(boolean z, boolean z2, int i) {
        C2290dH c2290dH;
        if (z) {
            this.A02 = 0;
            this.A01 = 0;
            this.A08 = 0L;
            this.A07 = 0L;
        } else {
            this.A02 = A7X();
            this.A01 = A7S();
            this.A08 = A7U();
            this.A07 = A0J();
        }
        Timeline timeline = z2 ? Timeline.A02 : this.A0E.A04;
        R5 r5 = this.A0E.A06;
        long j = this.A0E.A02;
        long j2 = this.A0E.A01;
        C1863Qs c1863Qs = z2 ? C1863Qs.A06 : this.A0E.A07;
        if (z2) {
            c2290dH = this.A0g;
        } else {
            c2290dH = this.A0E.A08;
        }
        return new Q9(timeline, r5, j, j2, i, false, c1863Qs, c2290dH, this.A0E.A06, this.A0E.A02, 0L, this.A0E.A02);
    }

    private QT A03(QS qs) {
        int iA7X = A7X();
        E8 e8 = this.A0b;
        Timeline timeline = this.A0E.A04;
        if (iA7X == -1) {
            iA7X = 0;
        }
        return new QT(e8, qs, timeline, iA7X, this.A0h, this.A0b.A1A());
    }

    private void A05() {
        if (!this.A0M) {
            return;
        }
        this.A0i.A01();
        if (Thread.currentThread() != A0K().getThread()) {
            String strA0n = AbstractC2471gE.A0n(A04(38, 147, 104), Thread.currentThread().getName(), A0K().getThread().getName());
            if (!this.A0l) {
                Log.w(A04(2, 13, 23), strA0n, this.A0N ? null : new IllegalStateException());
                this.A0N = true;
                return;
            }
            throw new IllegalStateException(strA0n);
        }
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0050  */
    /* JADX WARN: Code duplicated, block: B:17:0x0058  */
    /* JADX WARN: Code duplicated, block: B:19:0x0072  */
    /* JADX WARN: Code duplicated, block: B:26:0x0093  */
    private void A07(Q9 q9, int i, boolean seekProcessed, int i2) {
        String[] strArr;
        int i3;
        Q9 playbackInfo = q9;
        this.A03 -= i;
        if (this.A03 == 0) {
            if (playbackInfo.A02 == -9223372036854775807L) {
                playbackInfo = playbackInfo.A06(playbackInfo.A06, 0L, playbackInfo.A01, playbackInfo.A0D);
            }
            if (this.A0E.A04.A0N()) {
                boolean z = this.A0O;
                if (A0o[4].length() != 31) {
                    throw new RuntimeException();
                }
                A0o[2] = "a7vDULVL14joxcWmr2PyM3EB0dFebfQO";
                if (z) {
                    if (playbackInfo.A04.A0N()) {
                        this.A01 = 0;
                        this.A02 = 0;
                        strArr = A0o;
                        if (strArr[0].charAt(20) != strArr[7].charAt(20)) {
                            throw new RuntimeException();
                        }
                        A0o[4] = "6QAk8ka7eu8kTDBPRqcCrP3aTyr4lMJ";
                        this.A08 = 0L;
                        this.A07 = 0L;
                    }
                }
            } else if (playbackInfo.A04.A0N()) {
                this.A01 = 0;
                this.A02 = 0;
                strArr = A0o;
                if (strArr[0].charAt(20) != strArr[7].charAt(20)) {
                    throw new RuntimeException();
                }
                A0o[4] = "6QAk8ka7eu8kTDBPRqcCrP3aTyr4lMJ";
                this.A08 = 0L;
                this.A07 = 0L;
            }
            if (this.A0O) {
                i3 = 0;
            } else {
                i3 = 2;
            }
            boolean z2 = this.A0P;
            this.A0O = false;
            this.A0P = false;
            A08(playbackInfo, seekProcessed, i2, i3, z2);
        }
    }

    private void A08(Q9 q9, boolean z, int i, int i2, boolean z2) {
        boolean z3 = this.A0E.A04 != q9.A04;
        boolean z4 = this.A0E.A00 != q9.A00;
        boolean playbackStateChanged = this.A0E.A0A;
        boolean timelineChanged = q9.A0A;
        boolean z5 = playbackStateChanged != timelineChanged;
        C2290dH c2290dH = this.A0E.A08;
        C2290dH c2290dH2 = q9.A08;
        if (A0o[4].length() != 31) {
            throw new RuntimeException();
        }
        String[] strArr = A0o;
        strArr[6] = "LCg";
        strArr[1] = "Lju";
        boolean z6 = c2290dH != c2290dH2;
        this.A0E = q9;
        if (z3 || i2 == 0) {
            Iterator<QJ> it = this.A0k.iterator();
            while (timelineChanged) {
                it.next().AFI(this.A0E.A04, i2);
            }
        }
        if (z) {
            Iterator<QJ> it2 = this.A0k.iterator();
            while (timelineChanged) {
                it2.next();
            }
        }
        if (z6) {
            AbstractC2289dG abstractC2289dG = this.A0f;
            Q9 q10 = this.A0E;
            if (A0o[4].length() != 31) {
                throw new RuntimeException();
            }
            A0o[2] = "aRRbzviZA4HqNHRNhXqpTQXRKjR4EpcF";
            abstractC2289dG.A0c(q10.A08.A02);
            Iterator<QJ> it3 = this.A0k.iterator();
            while (timelineChanged) {
                QJ next = it3.next();
                Q9 q11 = this.A0E;
                String[] strArr2 = A0o;
                if (strArr2[5].length() != strArr2[3].length()) {
                    next.AFM(q11.A08.A01);
                } else {
                    String[] strArr3 = A0o;
                    strArr3[5] = "tFEpBpCR9O";
                    strArr3[3] = "RPAeiaXWVU";
                    next.AFM(q11.A08.A01);
                }
            }
        }
        if (z5) {
            Iterator<QJ> it4 = this.A0k.iterator();
            while (timelineChanged) {
                it4.next();
            }
        }
        if (z4) {
            Iterator<QJ> it5 = this.A0k.iterator();
            while (timelineChanged) {
                QJ next2 = it5.next();
                boolean playbackStateChanged2 = this.A0R;
                next2.AEZ(playbackStateChanged2, this.A0E.A00);
            }
        }
        if (z2) {
            Iterator<QJ> it6 = this.A0k.iterator();
            while (timelineChanged) {
                it6.next().AF3();
            }
        }
    }

    @MetaExoPlayerCustomization("D31846300; Custom MediaSessionEventListener")
    private final void A09(boolean z, boolean z2) {
        if (this.A0Q != z) {
            this.A0Q = z;
            this.A04++;
            this.A0b.A1F(z);
            Q9 q9 = this.A0E;
            if (!z) {
                this.A0R = z;
                for (QJ qj : this.A0k) {
                    if (0 != 0) {
                        throw new NullPointerException(A04(197, 20, 87));
                    }
                    qj.AEZ(z, q9.A00);
                }
            }
        }
    }

    private boolean A0A() {
        return this.A0E.A04.A0N() || this.A03 > 0;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC2079Zl
    public final void A0H(int i, long j) {
        long jA00;
        Timeline timeline = this.A0E.A04;
        if (i < 0 || (!timeline.A0N() && i >= timeline.A07())) {
            throw new P8(timeline, i, j);
        }
        this.A0P = true;
        this.A03++;
        if (AAS()) {
            Log.w(A04(2, 13, 23), A04(Sdk.SDKError.Reason.AD_RESPONSE_TIMED_OUT_VALUE, 39, 84));
            this.A0X.obtainMessage(0, 1, -1, this.A0E).sendToTarget();
            return;
        }
        this.A02 = i;
        boolean zA0N = timeline.A0N();
        if (A0o[2].charAt(13) != 'n') {
            A0o[4] = "XkvMJy8fgea2EYhPlO8IB7F7OucCVTK";
            if (zA0N) {
                this.A08 = j == -9223372036854775807L ? 0L : j;
                this.A01 = 0;
            } else {
                if (j == -9223372036854775807L) {
                    C2048Yf c2048Yf = super.A00;
                    String[] strArr = A0o;
                    if (strArr[5].length() == strArr[3].length()) {
                        String[] strArr2 = A0o;
                        strArr2[0] = "lvCZD1vSIIBmuJq22VWNoiUGZov24790";
                        strArr2[7] = "Xs2HyPeL7rSNTNRKWZSchYRt5D3JM17V";
                        jA00 = timeline.A0K(i, c2048Yf).A05();
                    }
                } else {
                    jA00 = O5.A00(j);
                }
                Pair pairA0D = timeline.A0D(super.A00, this.A0d, i, jA00);
                this.A08 = O5.A01(jA00);
                this.A01 = timeline.A0A(pairA0D.first);
            }
            this.A0b.A1D(timeline, i, O5.A00(j));
            Iterator<QJ> it = this.A0k.iterator();
            while (it.hasNext()) {
                it.next();
            }
            return;
        }
        throw new RuntimeException();
    }

    public final long A0I() {
        if (A0A()) {
            return this.A08;
        }
        if (this.A0E.A05.A03 != this.A0E.A06.A03) {
            return this.A0E.A04.A0K(A7X(), super.A00).A06();
        }
        long jA0D = this.A0E.A0B;
        if (this.A0E.A05.A00()) {
            C2050Yh c2050YhA0J = this.A0E.A04.A0J(this.A0E.A05.A04, this.A0d);
            jA0D = c2050YhA0J.A0D(this.A0E.A05.A00);
            if (jA0D == Long.MIN_VALUE) {
                jA0D = c2050YhA0J.A01;
            }
        }
        long contentBufferedPositionUs = A01(this.A0E.A04, this.A0E.A05, jA0D);
        return AbstractC2471gE.A0P(contentBufferedPositionUs);
    }

    public final long A0J() {
        if (A0A()) {
            return this.A07;
        }
        return O5.A01(this.A0E.A0C);
    }

    public final Looper A0K() {
        return this.A0Z;
    }

    public final QT A0L(QS qs) {
        A05();
        return A03(qs);
    }

    public final void A0M() {
        StringBuilder sbAppend = new StringBuilder().append(A04(185, 8, 112)).append(Integer.toHexString(System.identityHashCode(this))).append(A04(0, 2, 61)).append(A04(15, 18, 120));
        String strA04 = A04(194, 3, 71);
        Log.i(A04(2, 13, 23), sbAppend.append(strA04).append(AbstractC2471gE.A04).append(strA04).append(PS.A00()).append(A04(193, 1, 29)).toString());
        this.A0J = null;
        this.A0b.A1B();
        this.A0X.removeCallbacksAndMessages(null);
        this.A0E = A02(false, false, 1);
        this.A0K = C1851Qf.A03;
    }

    public final void A0N(Message message) {
        Iterator<QJ> it;
        switch (message.what) {
            case 0:
                A07((Q9) message.obj, message.arg1, message.arg2 != -1, message.arg2);
                return;
            case 1:
                C2064Yv c2064Yv = (C2064Yv) message.obj;
                C2064Yv playbackParameters = this.A0F;
                if (!playbackParameters.equals(c2064Yv)) {
                    this.A0F = c2064Yv;
                    Iterator<QJ> it2 = this.A0k.iterator();
                    while (true) {
                        boolean zHasNext = it2.hasNext();
                        if (A0o[4].length() == 31) {
                            A0o[4] = "8hk7OZfix4PEHRcTxo5SSQ62D05q6DL";
                            if (!zHasNext) {
                                return;
                            }
                        } else if (!zHasNext) {
                            return;
                        }
                        QJ next = it2.next();
                        String[] strArr = A0o;
                        if (strArr[6].length() != strArr[1].length()) {
                            next.AEV(c2064Yv);
                        } else {
                            A0o[2] = "oQIWwqluEBkDPEyoSxBHoh1XtEd9Y8j5";
                            next.AEV(c2064Yv);
                        }
                    }
                } else {
                    return;
                }
                break;
            case 2:
                EK ek = (EK) message.obj;
                this.A0A = ek;
                Iterator<QJ> it3 = this.A0k.iterator();
                while (it3.hasNext()) {
                    it3.next().AEX(ek);
                }
                return;
            case 3:
                int i = this.A04;
                if (A0o[4].length() != 31) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A0o;
                strArr2[6] = "O6N";
                strArr2[1] = "3Jg";
                this.A04 = i - 1;
                if (this.A04 == 0) {
                    Boolean bool = (Boolean) message.obj;
                    if (A0o[4].length() != 31) {
                        this.A0R = bool.booleanValue();
                        it = this.A0k.iterator();
                    } else {
                        String[] strArr3 = A0o;
                        strArr3[6] = "xhu";
                        strArr3[1] = "AZi";
                        this.A0R = bool.booleanValue();
                        it = this.A0k.iterator();
                    }
                    while (true) {
                        boolean zHasNext2 = it.hasNext();
                        if (A0o[2].charAt(13) == 'n') {
                            throw new RuntimeException();
                        }
                        A0o[2] = "bAI18KErgcwB1pfOUQtZ8fNOffY6wi9I";
                        if (zHasNext2) {
                            QJ next2 = it.next();
                            if (this.A0R) {
                                next2.AEZ(this.A0R, this.A0E.A00);
                            }
                        } else {
                            return;
                        }
                    }
                } else {
                    return;
                }
                break;
            case 4:
                Iterator<QJ> it4 = this.A0k.iterator();
                while (it4.hasNext()) {
                    it4.next();
                }
                return;
            case 5:
                Iterator<QJ> it5 = this.A0k.iterator();
                while (it5.hasNext()) {
                    it5.next();
                }
                return;
            default:
                throw new IllegalStateException();
        }
    }

    public final void A0O(QJ qj) {
        this.A0k.add(qj);
    }

    public final void A0P(InterfaceC2151az interfaceC2151az, boolean z, boolean z2) {
        this.A0A = null;
        this.A0J = interfaceC2151az;
        Q9 q9A02 = A02(z, z2, 2);
        this.A0O = true;
        this.A03++;
        this.A0b.A1E(interfaceC2151az, z, z2);
        A08(q9A02, false, 4, 1, false);
    }

    public final void A0Q(boolean z) {
        A09(z, false);
    }

    public final boolean A0R() {
        return this.A0Q;
    }

    @Override // com.facebook.ads.redexgen.core.QQ
    public final long A6x() {
        if (AAS()) {
            if (this.A0E.A05.equals(this.A0E.A06)) {
                Q9 q9 = this.A0E;
                String[] strArr = A0o;
                if (strArr[6].length() != strArr[1].length()) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A0o;
                strArr2[6] = "cTy";
                strArr2[1] = "5QM";
                return O5.A01(q9.A0B);
            }
            return A7i();
        }
        return A0I();
    }

    @Override // com.facebook.ads.redexgen.core.QQ
    public final long A7J() {
        if (AAS()) {
            this.A0E.A04.A0J(this.A0E.A06.A04, this.A0d);
            return this.A0d.A0B() + O5.A01(this.A0E.A01);
        }
        return A7U();
    }

    @Override // com.facebook.ads.redexgen.core.QQ
    public final int A7O() {
        if (!AAS()) {
            return -1;
        }
        Q9 q9 = this.A0E;
        if (A0o[4].length() != 31) {
            throw new RuntimeException();
        }
        String[] strArr = A0o;
        strArr[0] = "iAenHVt0sdYq3dou0rh4IyL2WiJjdGoB";
        strArr[7] = "l93O9csCcOzaoJJ8aFC8NUoFiQVq9Rur";
        return q9.A06.A00;
    }

    @Override // com.facebook.ads.redexgen.core.QQ
    public final int A7P() {
        if (AAS()) {
            return this.A0E.A06.A01;
        }
        return -1;
    }

    @Override // com.facebook.ads.redexgen.core.QQ
    @MetaExoPlayerCustomization("getCurrentWindowIndex needs to be upgraded to getCurrentWindowIndexInternal")
    public final int A7R() {
        A05();
        int iA7X = A7X();
        if (iA7X == -1) {
            return 0;
        }
        return iA7X;
    }

    @Override // com.facebook.ads.redexgen.core.QQ
    public final int A7S() {
        if (A0A()) {
            return this.A01;
        }
        return this.A0E.A04.A0A(this.A0E.A06.A04);
    }

    @Override // com.facebook.ads.redexgen.core.QQ
    public final long A7U() {
        if (A0A()) {
            long j = this.A08;
            String[] strArr = A0o;
            if (strArr[5].length() != strArr[3].length()) {
                throw new RuntimeException();
            }
            A0o[4] = "DlIXmqb8kELGbb1APDesckXZZTp9JUX";
            return j;
        }
        Q9 q9 = this.A0E;
        String[] strArr2 = A0o;
        if (strArr2[0].charAt(20) == strArr2[7].charAt(20)) {
            throw new RuntimeException();
        }
        A0o[2] = "wr3YTayWHPF5AKauEOyQEp0syJahAkEO";
        if (q9.A06.A00()) {
            return O5.A01(this.A0E.A0C);
        }
        return A00(this.A0E.A0C);
    }

    @Override // com.facebook.ads.redexgen.core.QQ
    public final Timeline A7W() {
        return this.A0E.A04;
    }

    @Override // com.facebook.ads.redexgen.core.QQ
    public final int A7X() {
        if (A0A()) {
            int i = this.A02;
            String[] strArr = A0o;
            if (strArr[5].length() != strArr[3].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0o;
            strArr2[6] = "5sA";
            strArr2[1] = "wYH";
            return i;
        }
        return this.A0E.A04.A0J(this.A0E.A06.A04, this.A0d).A00;
    }

    @Override // com.facebook.ads.redexgen.core.QQ
    public final long A7i() {
        Timeline timeline = this.A0E.A04;
        if (timeline.A0N()) {
            return -9223372036854775807L;
        }
        if (AAS()) {
            R5 r5 = this.A0E.A06;
            timeline.A0J(r5.A04, this.A0d);
            return O5.A01(this.A0d.A0E(r5.A00, r5.A01));
        }
        return timeline.A0K(A7X(), super.A00).A06();
    }

    @Override // com.facebook.ads.redexgen.core.QQ
    public final long A99() {
        return Math.max(0L, O5.A01(this.A0E.A0D));
    }

    @Override // com.facebook.ads.redexgen.core.QQ
    public final boolean AAS() {
        return !A0A() && this.A0E.A06.A00();
    }

    @Override // com.facebook.ads.redexgen.core.QQ
    public final void AJL(boolean z) {
        if (z) {
            this.A0A = null;
            this.A0J = null;
        }
        Q9 q9A02 = A02(z, z, 1);
        this.A03++;
        this.A0b.A1G(z);
        A08(q9A02, false, 4, 1, false);
        this.A0K = new C1851Qf(MetaExoPlayerCustomizedCollections.A01(), q9A02.A0C);
    }
}
