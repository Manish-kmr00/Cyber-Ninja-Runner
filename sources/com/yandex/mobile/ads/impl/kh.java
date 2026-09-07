package com.yandex.mobile.ads.impl;

import android.util.Pair;
import androidx.core.internal.view.SupportMenu;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
final class kh {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final byte[] f9414a = x82.c("OpusHead");
    public static final /* synthetic */ int b = 0;

    private interface c {
        int a();

        int b();

        int c();
    }

    private static b a(int i, wf1 wf1Var) {
        wf1Var.e(i + 12);
        wf1Var.f(1);
        a(wf1Var);
        wf1Var.f(2);
        int iT = wf1Var.t();
        if ((iT & 128) != 0) {
            wf1Var.f(2);
        }
        if ((iT & 64) != 0) {
            wf1Var.f(wf1Var.t());
        }
        if ((iT & 32) != 0) {
            wf1Var.f(2);
        }
        wf1Var.f(1);
        a(wf1Var);
        String strA = s01.a(wf1Var.t());
        if ("audio/mpeg".equals(strA) || "audio/vnd.dts".equals(strA) || "audio/vnd.dts.hd".equals(strA)) {
            return new b(strA, null, -1L, -1L);
        }
        wf1Var.f(4);
        long jV = wf1Var.v();
        long jV2 = wf1Var.v();
        wf1Var.f(1);
        int iA = a(wf1Var);
        byte[] bArr = new byte[iA];
        wf1Var.a(bArr, 0, iA);
        return new b(strA, bArr, jV2 > 0 ? jV2 : -1L, jV > 0 ? jV : -1L);
    }

    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f9415a;
        public int b;
        public int c;
        public long d;
        private final boolean e;
        private final wf1 f;
        private final wf1 g;
        private int h;
        private int i;

        public a(wf1 wf1Var, wf1 wf1Var2, boolean z) throws ag1 {
            this.g = wf1Var;
            this.f = wf1Var2;
            this.e = z;
            wf1Var2.e(12);
            this.f9415a = wf1Var2.x();
            wf1Var.e(12);
            this.i = wf1Var.x();
            z70.a(wf1Var.h() == 1);
            this.b = -1;
        }

        public final boolean a() {
            long jV;
            int i = this.b + 1;
            this.b = i;
            if (i == this.f9415a) {
                return false;
            }
            if (this.e) {
                jV = this.f.y();
            } else {
                jV = this.f.v();
            }
            this.d = jV;
            if (this.b == this.h) {
                this.c = this.g.x();
                this.g.f(4);
                int i2 = this.i - 1;
                this.i = i2;
                this.h = i2 > 0 ? this.g.x() - 1 : -1;
            }
            return true;
        }
    }

    private static int a(wf1 wf1Var) {
        int iT = wf1Var.t();
        int i = iT & 127;
        while ((iT & 128) == 128) {
            iT = wf1Var.t();
            i = (i << 7) | (iT & 127);
        }
        return i;
    }

    private static Pair a(int i, int i2, wf1 wf1Var) throws ag1 {
        p52 p52Var;
        Pair pairCreate;
        int i3;
        int i4;
        byte[] bArr;
        int iD = wf1Var.d();
        while (iD - i < i2) {
            wf1Var.e(iD);
            int iH = wf1Var.h();
            if (iH > 0) {
                if (wf1Var.h() == 1936289382) {
                    int i5 = iD + 8;
                    int i6 = 0;
                    int i7 = -1;
                    String strA = null;
                    Integer numValueOf = null;
                    while (i5 - iD < iH) {
                        wf1Var.e(i5);
                        int iH2 = wf1Var.h();
                        int iH3 = wf1Var.h();
                        if (iH3 == 1718775137) {
                            numValueOf = Integer.valueOf(wf1Var.h());
                        } else if (iH3 == 1935894637) {
                            wf1Var.f(4);
                            strA = wf1Var.a(4, ko.c);
                        } else if (iH3 == 1935894633) {
                            i7 = i5;
                            i6 = iH2;
                        }
                        i5 += iH2;
                    }
                    if ("cenc".equals(strA) || "cbc1".equals(strA) || "cens".equals(strA) || "cbcs".equals(strA)) {
                        if (!(numValueOf != null)) {
                            throw ag1.a("frma atom is mandatory", (Exception) null);
                        }
                        if (!(i7 != -1)) {
                            throw ag1.a("schi atom is mandatory", (Exception) null);
                        }
                        int i8 = i7 + 8;
                        while (true) {
                            if (i8 - i7 >= i6) {
                                p52Var = null;
                                break;
                            }
                            wf1Var.e(i8);
                            int iH4 = wf1Var.h();
                            if (wf1Var.h() == 1952804451) {
                                int iH5 = (wf1Var.h() >> 24) & 255;
                                wf1Var.f(1);
                                if (iH5 == 0) {
                                    wf1Var.f(1);
                                    i3 = 0;
                                    i4 = 0;
                                } else {
                                    int iT = wf1Var.t();
                                    int i9 = (iT & 240) >> 4;
                                    i3 = iT & 15;
                                    i4 = i9;
                                }
                                boolean z = wf1Var.t() == 1;
                                int iT2 = wf1Var.t();
                                byte[] bArr2 = new byte[16];
                                wf1Var.a(bArr2, 0, 16);
                                if (z && iT2 == 0) {
                                    int iT3 = wf1Var.t();
                                    byte[] bArr3 = new byte[iT3];
                                    wf1Var.a(bArr3, 0, iT3);
                                    bArr = bArr3;
                                } else {
                                    bArr = null;
                                }
                                p52Var = new p52(z, strA, iT2, bArr2, i4, i3, bArr);
                                break;
                            }
                            i8 += iH4;
                        }
                        if (p52Var != null) {
                            int i10 = x82.f10629a;
                            pairCreate = Pair.create(numValueOf, p52Var);
                        } else {
                            throw ag1.a("tenc atom is mandatory", (Exception) null);
                        }
                    } else {
                        pairCreate = null;
                    }
                    if (pairCreate != null) {
                        return pairCreate;
                    }
                }
                iD += iH;
            } else {
                throw ag1.a("childAtomSize must be positive", (Exception) null);
            }
        }
        return null;
    }

    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f9416a;
        private final byte[] b;
        private final long c;
        private final long d;

        public b(String str, byte[] bArr, long j, long j2) {
            this.f9416a = str;
            this.b = bArr;
            this.c = j;
            this.d = j2;
        }
    }

    static final class d implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f9417a;
        private final int b;
        private final wf1 c;

        public d(jh.b bVar, gc0 gc0Var) {
            wf1 wf1Var = bVar.b;
            this.c = wf1Var;
            wf1Var.e(12);
            int iX = wf1Var.x();
            if ("audio/raw".equals(gc0Var.m)) {
                int iB = x82.b(gc0Var.B, gc0Var.z);
                if (iX == 0 || iX % iB != 0) {
                    at0.d("AtomParsers", "Audio sample size mismatch. stsd sample size: " + iB + ", stsz sample size: " + iX);
                    iX = iB;
                }
            }
            this.f9417a = iX == 0 ? -1 : iX;
            this.b = wf1Var.x();
        }

        @Override // com.yandex.mobile.ads.impl.kh.c
        public final int b() {
            return this.b;
        }

        @Override // com.yandex.mobile.ads.impl.kh.c
        public final int a() {
            return this.f9417a;
        }

        @Override // com.yandex.mobile.ads.impl.kh.c
        public final int c() {
            int i = this.f9417a;
            return i == -1 ? this.c.x() : i;
        }
    }

    static final class e implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final wf1 f9418a;
        private final int b;
        private final int c;
        private int d;
        private int e;

        @Override // com.yandex.mobile.ads.impl.kh.c
        public final int a() {
            return -1;
        }

        public e(jh.b bVar) {
            wf1 wf1Var = bVar.b;
            this.f9418a = wf1Var;
            wf1Var.e(12);
            this.c = wf1Var.x() & 255;
            this.b = wf1Var.x();
        }

        @Override // com.yandex.mobile.ads.impl.kh.c
        public final int b() {
            return this.b;
        }

        @Override // com.yandex.mobile.ads.impl.kh.c
        public final int c() {
            int i = this.c;
            if (i == 8) {
                return this.f9418a.t();
            }
            if (i == 16) {
                return this.f9418a.z();
            }
            int i2 = this.d;
            this.d = i2 + 1;
            if (i2 % 2 == 0) {
                int iT = this.f9418a.t();
                this.e = iT;
                return (iT & 240) >> 4;
            }
            return this.e & 15;
        }
    }

    private static u52 a(o52 o52Var, jh.a aVar, fe0 fe0Var) throws ag1 {
        c eVar;
        boolean z;
        int iX;
        int iX2;
        int iX3;
        int i;
        int i2;
        int i3;
        boolean z2;
        int i4;
        o52 o52Var2;
        int i5;
        long[] jArr;
        int[] iArr;
        long[] jArr2;
        int[] iArr2;
        int i6;
        long j;
        int iH;
        int i7;
        int i8;
        int[] iArr3;
        int i9;
        int i10;
        int i11;
        jh.b bVarC = aVar.c(1937011578);
        if (bVarC != null) {
            eVar = new d(bVarC, o52Var.f);
        } else {
            jh.b bVarC2 = aVar.c(1937013298);
            if (bVarC2 != null) {
                eVar = new e(bVarC2);
            } else {
                throw ag1.a("Track has no sample table size information", (Exception) null);
            }
        }
        int iB = eVar.b();
        if (iB == 0) {
            return new u52(o52Var, new long[0], new int[0], 0, new long[0], new int[0], 0L);
        }
        jh.b bVarC3 = aVar.c(1937007471);
        if (bVarC3 == null) {
            bVarC3 = aVar.c(1668232756);
            bVarC3.getClass();
            z = true;
        } else {
            z = false;
        }
        wf1 wf1Var = bVarC3.b;
        jh.b bVarC4 = aVar.c(1937011555);
        bVarC4.getClass();
        wf1 wf1Var2 = bVarC4.b;
        jh.b bVarC5 = aVar.c(1937011827);
        bVarC5.getClass();
        wf1 wf1Var3 = bVarC5.b;
        jh.b bVarC6 = aVar.c(1937011571);
        wf1 wf1Var4 = bVarC6 != null ? bVarC6.b : null;
        jh.b bVarC7 = aVar.c(1668576371);
        wf1 wf1Var5 = bVarC7 != null ? bVarC7.b : null;
        a aVar2 = new a(wf1Var2, wf1Var, z);
        wf1Var3.e(12);
        int iX4 = wf1Var3.x() - 1;
        int iX5 = wf1Var3.x();
        int iX6 = wf1Var3.x();
        if (wf1Var5 != null) {
            wf1Var5.e(12);
            iX = wf1Var5.x();
        } else {
            iX = 0;
        }
        if (wf1Var4 != null) {
            wf1Var4.e(12);
            iX3 = wf1Var4.x();
            if (iX3 > 0) {
                iX2 = wf1Var4.x() - 1;
            } else {
                iX2 = -1;
                wf1Var4 = null;
            }
        } else {
            iX2 = -1;
            iX3 = 0;
        }
        int iA = eVar.a();
        String str = o52Var.f.m;
        if (iA != -1 && ("audio/raw".equals(str) || "audio/g711-mlaw".equals(str) || "audio/g711-alaw".equals(str)) && iX4 == 0 && iX == 0 && iX3 == 0) {
            int i12 = aVar2.f9415a;
            long[] jArr3 = new long[i12];
            int[] iArr4 = new int[i12];
            while (aVar2.a()) {
                int i13 = aVar2.b;
                jArr3[i13] = aVar2.d;
                iArr4[i13] = aVar2.c;
            }
            mb0.a aVarA = mb0.a(iA, jArr3, iArr4, iX6);
            long[] jArr4 = aVarA.f9620a;
            int[] iArr5 = aVarA.b;
            int i14 = aVarA.c;
            long[] jArr5 = aVarA.d;
            int[] iArr6 = aVarA.e;
            long j2 = aVarA.f;
            o52Var2 = o52Var;
            i5 = iB;
            jArr = jArr4;
            iArr = iArr5;
            i6 = i14;
            jArr2 = jArr5;
            iArr2 = iArr6;
            j = j2;
        } else {
            long[] jArrCopyOf = new long[iB];
            int[] iArrCopyOf = new int[iB];
            long[] jArrCopyOf2 = new long[iB];
            int[] iArrCopyOf2 = new int[iB];
            int iX7 = iX2;
            int i15 = 0;
            int i16 = 0;
            int iH2 = 0;
            int i17 = 0;
            int iX8 = 0;
            long j3 = 0;
            long j4 = 0;
            int i18 = iX;
            int i19 = iX6;
            int i20 = iX5;
            int i21 = iX4;
            int i22 = iX3;
            while (true) {
                i = i21;
                if (i15 >= iB) {
                    i2 = i20;
                    i3 = i17;
                    break;
                }
                long j5 = j4;
                int i23 = i17;
                boolean zA = true;
                while (i23 == 0) {
                    zA = aVar2.a();
                    if (!zA) {
                        break;
                    }
                    int i24 = i20;
                    long j6 = aVar2.d;
                    i23 = aVar2.c;
                    j5 = j6;
                    i20 = i24;
                    i19 = i19;
                    iB = iB;
                }
                int i25 = iB;
                i2 = i20;
                int i26 = i19;
                if (!zA) {
                    at0.d("AtomParsers", "Unexpected end of chunk data");
                    jArrCopyOf = Arrays.copyOf(jArrCopyOf, i15);
                    iArrCopyOf = Arrays.copyOf(iArrCopyOf, i15);
                    jArrCopyOf2 = Arrays.copyOf(jArrCopyOf2, i15);
                    iArrCopyOf2 = Arrays.copyOf(iArrCopyOf2, i15);
                    iB = i15;
                    i3 = i23;
                    break;
                }
                if (wf1Var5 != null) {
                    while (iX8 == 0 && i18 > 0) {
                        iX8 = wf1Var5.x();
                        iH2 = wf1Var5.h();
                        i18--;
                    }
                    iX8--;
                }
                int i27 = iH2;
                jArrCopyOf[i15] = j5;
                int iC = eVar.c();
                iArrCopyOf[i15] = iC;
                if (iC > i16) {
                    i16 = iC;
                }
                jArrCopyOf2[i15] = j3 + ((long) i27);
                iArrCopyOf2[i15] = wf1Var4 == null ? 1 : 0;
                if (i15 == iX7) {
                    iArrCopyOf2[i15] = 1;
                    i22--;
                    if (i22 > 0) {
                        wf1Var4.getClass();
                        iX7 = wf1Var4.x() - 1;
                    }
                }
                int i28 = iX7;
                j3 += (long) i26;
                int iX9 = i2 - 1;
                if (iX9 != 0 || i <= 0) {
                    iH = i26;
                    i7 = i;
                } else {
                    iX9 = wf1Var3.x();
                    iH = wf1Var3.h();
                    i7 = i - 1;
                }
                int i29 = iX9;
                long j7 = j5 + ((long) iArrCopyOf[i15]);
                i17 = i23 - 1;
                i15++;
                j4 = j7;
                iX7 = i28;
                i19 = iH;
                iB = i25;
                iH2 = i27;
                i21 = i7;
                i20 = i29;
            }
            long j8 = j3 + ((long) iH2);
            if (wf1Var5 == null) {
                z2 = true;
                break;
            }
            while (true) {
                if (i18 <= 0) {
                    z2 = true;
                    break;
                }
                if (wf1Var5.x() != 0) {
                    z2 = false;
                    break;
                }
                wf1Var5.h();
                i18--;
            }
            if (i22 == 0 && i2 == 0 && i3 == 0 && i == 0) {
                i4 = iX8;
                if (i4 == 0 && z2) {
                    o52Var2 = o52Var;
                }
                i5 = iB;
                jArr = jArrCopyOf;
                iArr = iArrCopyOf;
                jArr2 = jArrCopyOf2;
                iArr2 = iArrCopyOf2;
                i6 = i16;
                j = j8;
            } else {
                i4 = iX8;
            }
            o52Var2 = o52Var;
            at0.d("AtomParsers", "Inconsistent stbl box for track " + o52Var2.f9783a + ": remainingSynchronizationSamples " + i22 + ", remainingSamplesAtTimestampDelta " + i2 + ", remainingSamplesInChunk " + i3 + ", remainingTimestampDeltaChanges " + i + ", remainingSamplesAtTimestampOffset " + i4 + (!z2 ? ", ctts invalid" : ""));
            i5 = iB;
            jArr = jArrCopyOf;
            iArr = iArrCopyOf;
            jArr2 = jArrCopyOf2;
            iArr2 = iArrCopyOf2;
            i6 = i16;
            j = j8;
        }
        long jA = x82.a(j, 1000000L, o52Var2.c);
        long[] jArr6 = o52Var2.h;
        if (jArr6 == null) {
            x82.a(jArr2, o52Var2.c);
            return new u52(o52Var, jArr, iArr, i6, jArr2, iArr2, jA);
        }
        if (jArr6.length == 1 && o52Var2.b == 1 && jArr2.length >= 2) {
            long[] jArr7 = o52Var2.i;
            jArr7.getClass();
            long j9 = jArr7[0];
            long jA2 = x82.a(o52Var2.h[0], o52Var2.c, o52Var2.d) + j9;
            int length = jArr2.length - 1;
            int iMax = Math.max(0, Math.min(4, length));
            int iMax2 = Math.max(0, Math.min(jArr2.length - 4, length));
            long j10 = jArr2[0];
            if (j10 <= j9 && j9 < jArr2[iMax] && jArr2[iMax2] < jA2 && jA2 <= j) {
                long jA3 = x82.a(j9 - j10, o52Var2.f.A, o52Var2.c);
                long jA4 = x82.a(j - jA2, o52Var2.f.A, o52Var2.c);
                if ((jA3 != 0 || jA4 != 0) && jA3 <= 2147483647L && jA4 <= 2147483647L) {
                    fe0Var.f8887a = (int) jA3;
                    fe0Var.b = (int) jA4;
                    x82.a(jArr2, o52Var2.c);
                    return new u52(o52Var, jArr, iArr, i6, jArr2, iArr2, x82.a(o52Var2.h[0], 1000000L, o52Var2.d));
                }
            }
        }
        long[] jArr8 = o52Var2.h;
        if (jArr8.length == 1 && jArr8[0] == 0) {
            long[] jArr9 = o52Var2.i;
            jArr9.getClass();
            long j11 = jArr9[0];
            for (int i30 = 0; i30 < jArr2.length; i30++) {
                jArr2[i30] = x82.a(jArr2[i30] - j11, 1000000L, o52Var2.c);
            }
            return new u52(o52Var, jArr, iArr, i6, jArr2, iArr2, x82.a(j - j11, 1000000L, o52Var2.c));
        }
        boolean z3 = o52Var2.b == 1;
        int[] iArr7 = new int[jArr8.length];
        int[] iArr8 = new int[jArr8.length];
        long[] jArr10 = o52Var2.i;
        jArr10.getClass();
        int i31 = 0;
        int i32 = 0;
        boolean z4 = false;
        int i33 = 0;
        while (true) {
            long[] jArr11 = o52Var2.h;
            i8 = i6;
            if (i31 >= jArr11.length) {
                break;
            }
            int[] iArr9 = iArr;
            long j12 = jArr10[i31];
            if (j12 != -1) {
                int i34 = i32;
                boolean z5 = z4;
                long jA5 = x82.a(jArr11[i31], o52Var2.c, o52Var2.d);
                iArr7[i31] = x82.b(jArr2, j12, true);
                iArr8[i31] = x82.a(jArr2, j12 + jA5, z3);
                while (true) {
                    i10 = iArr7[i31];
                    i11 = iArr8[i31];
                    if (i10 >= i11 || (iArr2[i10] & 1) != 0) {
                        break;
                    }
                    iArr7[i31] = i10 + 1;
                }
                i9 = (i11 - i10) + i34;
                z4 = z5 | (i33 != i10);
                i33 = i11;
            } else {
                i9 = i32;
            }
            i31++;
            i6 = i8;
            i32 = i9;
            iArr = iArr9;
            jArr10 = jArr10;
        }
        int[] iArr10 = iArr;
        int i35 = i32;
        boolean z6 = z4 | (i35 != i5);
        long[] jArr12 = z6 ? new long[i35] : jArr;
        int[] iArr11 = z6 ? new int[i35] : iArr10;
        int i36 = z6 ? 0 : i8;
        int[] iArr12 = z6 ? new int[i35] : iArr2;
        long[] jArr13 = new long[i35];
        int i37 = 0;
        int i38 = 0;
        long j13 = 0;
        while (i37 < o52Var2.h.length) {
            long j14 = o52Var2.i[i37];
            int i39 = iArr7[i37];
            int i40 = iArr8[i37];
            int[] iArr13 = iArr8;
            if (z6) {
                int i41 = i40 - i39;
                System.arraycopy(jArr, i39, jArr12, i38, i41);
                iArr3 = iArr10;
                System.arraycopy(iArr3, i39, iArr11, i38, i41);
                System.arraycopy(iArr2, i39, iArr12, i38, i41);
            } else {
                iArr3 = iArr10;
            }
            while (i39 < i40) {
                int[] iArr14 = iArr12;
                int i42 = i37;
                long[] jArr14 = jArr2;
                int[] iArr15 = iArr2;
                int[] iArr16 = iArr3;
                jArr13[i38] = x82.a(j13, 1000000L, o52Var2.d) + x82.a(Math.max(0L, jArr2[i39] - j14), 1000000L, o52Var2.c);
                if (z6 && iArr11[i38] > i36) {
                    i36 = iArr16[i39];
                }
                i38++;
                i39++;
                i37 = i42;
                iArr12 = iArr14;
                iArr3 = iArr16;
                jArr2 = jArr14;
                iArr2 = iArr15;
            }
            int[] iArr17 = iArr3;
            int i43 = i37;
            j13 += o52Var2.h[i43];
            i37 = i43 + 1;
            jArr = jArr;
            iArr12 = iArr12;
            iArr10 = iArr17;
            jArr2 = jArr2;
            iArr8 = iArr13;
        }
        return new u52(o52Var, jArr12, iArr11, i36, jArr13, iArr12, x82.a(j13, 1000000L, o52Var2.d));
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0217  */
    /* JADX WARN: Code duplicated, block: B:329:0x0563  */
    /* JADX WARN: Code duplicated, block: B:331:0x056c  */
    /* JADX WARN: Code duplicated, block: B:332:0x056f  */
    /* JADX WARN: Code duplicated, block: B:334:0x0573  */
    /* JADX WARN: Code duplicated, block: B:336:0x0580  */
    /* JADX WARN: Code duplicated, block: B:339:0x0596  */
    /* JADX WARN: Code duplicated, block: B:341:0x059b  */
    /* JADX WARN: Code duplicated, block: B:347:0x05b3  */
    /* JADX WARN: Code duplicated, block: B:349:0x05c3  */
    /* JADX WARN: Code duplicated, block: B:351:0x05c8  */
    /* JADX WARN: Code duplicated, block: B:352:0x05d6  */
    /* JADX WARN: Code duplicated, block: B:354:0x05db  */
    /* JADX WARN: Code duplicated, block: B:356:0x05f6  */
    /* JADX WARN: Code duplicated, block: B:357:0x05fa  */
    /* JADX WARN: Code duplicated, block: B:359:0x0622  */
    /* JADX WARN: Code duplicated, block: B:361:0x0629 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:362:0x062b  */
    /* JADX WARN: Code duplicated, block: B:365:0x0649  */
    /* JADX WARN: Code duplicated, block: B:367:0x064e  */
    /* JADX WARN: Code duplicated, block: B:369:0x0677  */
    /* JADX WARN: Code duplicated, block: B:371:0x067c  */
    /* JADX WARN: Code duplicated, block: B:372:0x0697  */
    /* JADX WARN: Code duplicated, block: B:374:0x069e  */
    /* JADX WARN: Code duplicated, block: B:375:0x06c7  */
    /* JADX WARN: Code duplicated, block: B:377:0x06cc  */
    /* JADX WARN: Code duplicated, block: B:378:0x0715  */
    /* JADX WARN: Code duplicated, block: B:380:0x071f  */
    /* JADX WARN: Code duplicated, block: B:382:0x0722  */
    /* JADX WARN: Code duplicated, block: B:384:0x0728  */
    /* JADX WARN: Code duplicated, block: B:385:0x072a  */
    /* JADX WARN: Code duplicated, block: B:387:0x072d A[LOOP:4: B:387:0x072d->B:397:0x0749, LOOP_START, PHI: r4
  0x072d: PHI (r4v69 int) = (r4v68 int), (r4v71 int) binds: [B:386:0x072b, B:397:0x0749] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:389:0x0731  */
    /* JADX WARN: Code duplicated, block: B:391:0x073a  */
    /* JADX WARN: Code duplicated, block: B:392:0x073c  */
    /* JADX WARN: Code duplicated, block: B:394:0x073f  */
    /* JADX WARN: Code duplicated, block: B:397:0x0749 A[LOOP:4: B:387:0x072d->B:397:0x0749, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:402:0x0758  */
    /* JADX WARN: Code duplicated, block: B:404:0x0766  */
    /* JADX WARN: Code duplicated, block: B:406:0x076e  */
    /* JADX WARN: Code duplicated, block: B:407:0x0780  */
    /* JADX WARN: Code duplicated, block: B:409:0x078a  */
    /* JADX WARN: Code duplicated, block: B:410:0x078f A[PHI: r46 r47
  0x078f: PHI (r46v7 java.util.List<byte[]>) = (r0v62 java.util.List<byte[]>), (r46v10 java.util.List<byte[]>) binds: [B:401:0x0756, B:376:0x06ca] A[DONT_GENERATE, DONT_INLINE]
  0x078f: PHI (r47v5 int) = (r10v61 int), (r47v8 int) binds: [B:401:0x0756, B:376:0x06ca] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:424:0x07fd  */
    /* JADX WARN: Code duplicated, block: B:426:0x0809  */
    /* JADX WARN: Code duplicated, block: B:428:0x0838  */
    /* JADX WARN: Code duplicated, block: B:430:0x0842  */
    /* JADX WARN: Code duplicated, block: B:432:0x084e  */
    /* JADX WARN: Code duplicated, block: B:433:0x0850  */
    /* JADX WARN: Code duplicated, block: B:435:0x0863  */
    /* JADX WARN: Code duplicated, block: B:437:0x086a  */
    /* JADX WARN: Code duplicated, block: B:440:0x0876  */
    /* JADX WARN: Code duplicated, block: B:441:0x0879  */
    /* JADX WARN: Code duplicated, block: B:443:0x087e  */
    /* JADX WARN: Code duplicated, block: B:444:0x0881  */
    /* JADX WARN: Code duplicated, block: B:448:0x08a3  */
    /* JADX WARN: Code duplicated, block: B:450:0x08b2  */
    /* JADX WARN: Code duplicated, block: B:453:0x08cc  */
    /* JADX WARN: Code duplicated, block: B:455:0x08d0  */
    /* JADX WARN: Code duplicated, block: B:456:0x08d2  */
    /* JADX WARN: Code duplicated, block: B:458:0x08d5  */
    /* JADX WARN: Code duplicated, block: B:460:0x08e0 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:461:0x08e2  */
    /* JADX WARN: Code duplicated, block: B:462:0x08e4  */
    /* JADX WARN: Code duplicated, block: B:464:0x08e7  */
    /* JADX WARN: Code duplicated, block: B:466:0x08f6  */
    /* JADX WARN: Code duplicated, block: B:475:0x0920  */
    /* JADX WARN: Code duplicated, block: B:477:0x0925 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:478:0x0927  */
    /* JADX WARN: Code duplicated, block: B:479:0x0929  */
    /* JADX WARN: Code duplicated, block: B:481:0x092c  */
    /* JADX WARN: Code duplicated, block: B:483:0x093b  */
    /* JADX WARN: Code duplicated, block: B:487:0x0948  */
    /* JADX WARN: Code duplicated, block: B:489:0x094d  */
    /* JADX WARN: Code duplicated, block: B:624:0x0bc0  */
    /* JADX WARN: Code duplicated, block: B:626:0x0bdd  */
    /* JADX WARN: Code duplicated, block: B:634:0x0c1a  */
    /* JADX WARN: Code duplicated, block: B:635:0x0c23  */
    /* JADX WARN: Code duplicated, block: B:637:0x0c6b  */
    /* JADX WARN: Code duplicated, block: B:639:0x0c71 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:642:0x0c76  */
    /* JADX WARN: Code duplicated, block: B:645:0x0c7e  */
    /* JADX WARN: Code duplicated, block: B:646:0x0c83  */
    /* JADX WARN: Code duplicated, block: B:649:0x0c8c  */
    /* JADX WARN: Code duplicated, block: B:656:0x0cdf  */
    /* JADX WARN: Code duplicated, block: B:658:0x0cea  */
    /* JADX WARN: Code duplicated, block: B:660:0x0cf3  */
    /* JADX WARN: Code duplicated, block: B:661:0x0cf5  */
    /* JADX WARN: Code duplicated, block: B:663:0x0d0f  */
    /* JADX WARN: Code duplicated, block: B:665:0x0d12  */
    /* JADX WARN: Code duplicated, block: B:666:0x0d17  */
    /* JADX WARN: Code duplicated, block: B:669:0x0d1f  */
    /* JADX WARN: Code duplicated, block: B:670:0x0d24  */
    /* JADX WARN: Code duplicated, block: B:673:0x0d31 A[LOOP:7: B:662:0x0d0d->B:673:0x0d31, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:678:0x0d46  */
    /* JADX WARN: Code duplicated, block: B:679:0x0d51  */
    /* JADX WARN: Code duplicated, block: B:683:0x0d5c  */
    /* JADX WARN: Code duplicated, block: B:686:0x0d83  */
    /* JADX WARN: Code duplicated, block: B:687:0x0d88  */
    /* JADX WARN: Code duplicated, block: B:691:0x0cc6 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:693:0x07a1 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:694:0x0634 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:695:0x079b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:696:0x074e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:697:0x0bfb A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:698:0x091a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:699:0x0942 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:704:0x0d38 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:719:0x0754 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:720:0x0720 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:721:0x0c01 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:722:0x08bc A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:72:0x012a  */
    /* JADX WARN: Code duplicated, block: B:75:0x012f  */
    /* JADX WARN: Code duplicated, block: B:76:0x0132  */
    /* JADX WARN: Code duplicated, block: B:79:0x0145  */
    /* JADX WARN: Code duplicated, block: B:80:0x0148  */
    /* JADX WARN: Code duplicated, block: B:84:0x0156  */
    /* JADX WARN: Code duplicated, block: B:87:0x0190  */
    /* JADX WARN: Code duplicated, block: B:88:0x0193  */
    /* JADX WARN: Code duplicated, block: B:91:0x019e  */
    /* JADX WARN: Code duplicated, block: B:92:0x01a0  */
    /* JADX WARN: Code duplicated, block: B:95:0x01fe  */
    /* JADX WARN: Code duplicated, block: B:97:0x020e  */
    /* JADX WARN: Code duplicated, block: B:98:0x0211  */
    public static ArrayList a(jh.a aVar, fe0 fe0Var, long j, c40 c40Var, boolean z, boolean z2, ce0 ce0Var) throws ag1 {
        int i;
        long jV;
        int i2;
        int i3;
        long j2;
        wf1 wf1Var;
        int i4;
        long jV2;
        long jA;
        int iH;
        int i5;
        int i6;
        Pair pairCreate;
        wf1 wf1Var2;
        String str;
        int iH2;
        p52[] p52VarArr;
        int i7;
        gc0 gc0VarA;
        int i8;
        int i9;
        ArrayList arrayList;
        int i10;
        jh.a aVar2;
        Pair pair;
        int i11;
        long j3;
        p52[] p52VarArr2;
        gc0 gc0Var;
        o52 o52Var;
        long[] jArr;
        long[] jArr2;
        o52 o52Var2;
        jh.a aVarB;
        jh.b bVarC;
        wf1 wf1Var3;
        int iH3;
        int iX;
        long[] jArr3;
        long[] jArr4;
        int i12;
        Pair pairCreate2;
        long jV3;
        long jH;
        int i13;
        int iD;
        int i14;
        int iH4;
        ArrayList arrayList2;
        boolean z3;
        int iH5;
        int i15;
        int iZ;
        int iZ2;
        int iD2;
        int i16;
        c40 c40Var2;
        String str2;
        c40 c40Var3;
        boolean z4;
        gc0 gc0Var2;
        int i17;
        String str3;
        byte[] bArr;
        List<byte[]> list;
        ByteBuffer byteBufferOrder;
        b bVar;
        int i18;
        int i19;
        int i20;
        int i21;
        float fX;
        String str4;
        int i22;
        List<byte[]> listA;
        int i23;
        gc0.a aVarA;
        int i24;
        int i25;
        int i26;
        byte[] bArrArray;
        int iD3;
        int iH6;
        boolean z5;
        int iH7;
        float f;
        String str5;
        byte[] bArrCopyOfRange;
        q30 q30VarA;
        int i27;
        String str6;
        boolean z6;
        qf0 qf0VarA;
        List<byte[]> list2;
        int i28;
        String str7;
        String str8;
        boolean z7;
        mi miVarA;
        Pair pairA;
        c40 c40VarA;
        int iZ3;
        int iZ4;
        int i29;
        int i30;
        c40 c40Var4;
        String str9;
        int i31;
        int iIntValue;
        List<byte[]> listA2;
        String str10;
        int i32;
        gc0 gc0Var3;
        String str11;
        int i33;
        b bVar2;
        int iH8;
        boolean z8;
        int iH9;
        int i34;
        int iD4;
        boolean z9;
        int i35;
        int iH10;
        boolean z10;
        b bVarA;
        String str12;
        byte[] bArr2;
        gc0 gc0VarA2;
        int i36;
        gc0 gc0VarB;
        String str13;
        long j4;
        hk0 hk0VarA;
        o52 o52Var3;
        ArrayList arrayList3 = new ArrayList();
        int i37 = 0;
        while (i37 < aVar.d.size()) {
            jh.a aVar3 = (jh.a) aVar.d.get(i37);
            if (aVar3.f9316a != 1953653099) {
                i10 = i37;
            } else {
                jh.b bVarC2 = aVar.c(1836476516);
                bVarC2.getClass();
                jh.a aVarB2 = aVar3.b(1835297121);
                aVarB2.getClass();
                jh.b bVarC3 = aVarB2.c(1751411826);
                bVarC3.getClass();
                wf1 wf1Var4 = bVarC3.b;
                wf1Var4.e(16);
                int iH11 = wf1Var4.h();
                if (iH11 == 1936684398) {
                    i = 1;
                } else if (iH11 == 1986618469) {
                    i = 2;
                } else if (iH11 == 1952807028 || iH11 == 1935832172 || iH11 == 1937072756 || iH11 == 1668047728) {
                    i = 3;
                } else {
                    i = iH11 == 1835365473 ? 5 : -1;
                }
                if (i == -1) {
                    arrayList = arrayList3;
                    i10 = i37;
                    o52Var = null;
                } else {
                    jh.b bVarC4 = aVar3.c(1953196132);
                    bVarC4.getClass();
                    wf1 wf1Var5 = bVarC4.b;
                    wf1Var5.e(8);
                    int iH12 = (wf1Var5.h() >> 24) & 255;
                    wf1Var5.f(iH12 == 0 ? 8 : 16);
                    int iH13 = wf1Var5.h();
                    wf1Var5.f(4);
                    int iD5 = wf1Var5.d();
                    int i38 = iH12 == 0 ? 4 : 8;
                    int i39 = 0;
                    while (true) {
                        if (i39 < i38) {
                            if (wf1Var5.c()[iD5 + i39] != -1) {
                                jV = iH12 == 0 ? wf1Var5.v() : wf1Var5.y();
                                if (jV != 0) {
                                    break;
                                }
                                break;
                            }
                            i39++;
                        } else {
                            wf1Var5.f(i38);
                        }
                        jV = -9223372036854775807L;
                        break;
                    }
                    wf1Var5.f(16);
                    int iH14 = wf1Var5.h();
                    int iH15 = wf1Var5.h();
                    wf1Var5.f(4);
                    int iH16 = wf1Var5.h();
                    int iH17 = wf1Var5.h();
                    if (iH14 == 0 && iH15 == 65536) {
                        i2 = SupportMenu.CATEGORY_MASK;
                        if (iH16 == -65536 && iH17 == 0) {
                            i3 = 90;
                        }
                        if (j == -9223372036854775807L) {
                            j2 = jV;
                        } else {
                            j2 = j;
                        }
                        wf1Var = bVarC2.b;
                        wf1Var.e(8);
                        if (((wf1Var.h() >> 24) & 255) == 0) {
                            i4 = 8;
                        } else {
                            i4 = 16;
                        }
                        wf1Var.f(i4);
                        jV2 = wf1Var.v();
                        jA = j2 != -9223372036854775807L ? x82.a(j2, 1000000L, jV2) : -9223372036854775807L;
                        jh.a aVarB3 = aVarB2.b(1835626086);
                        aVarB3.getClass();
                        jh.a aVarB4 = aVarB3.b(1937007212);
                        aVarB4.getClass();
                        jh.b bVarC5 = aVarB2.c(1835296868);
                        bVarC5.getClass();
                        wf1 wf1Var6 = bVarC5.b;
                        wf1Var6.e(8);
                        iH = (wf1Var6.h() >> 24) & 255;
                        if (iH == 0) {
                            i5 = 8;
                        } else {
                            i5 = 16;
                        }
                        wf1Var6.f(i5);
                        long jV4 = wf1Var6.v();
                        if (iH == 0) {
                            i6 = 4;
                        } else {
                            i6 = 8;
                        }
                        wf1Var6.f(i6);
                        int iZ5 = wf1Var6.z();
                        pairCreate = Pair.create(Long.valueOf(jV4), "" + ((char) (((iZ5 >> 10) & 31) + 96)) + ((char) (((iZ5 >> 5) & 31) + 96)) + ((char) ((iZ5 & 31) + 96)));
                        jh.b bVarC6 = aVarB4.c(1937011556);
                        bVarC6.getClass();
                        wf1Var2 = bVarC6.b;
                        str = (String) pairCreate.second;
                        wf1Var2.e(12);
                        iH2 = wf1Var2.h();
                        p52VarArr = new p52[iH2];
                        i7 = 0;
                        gc0VarA = null;
                        i8 = 0;
                        i9 = 0;
                        while (i7 < iH2) {
                            i13 = iH2;
                            iD = wf1Var2.d();
                            i14 = i37;
                            iH4 = wf1Var2.h();
                            arrayList2 = arrayList3;
                            if (iH4 > 0) {
                                z3 = true;
                            } else {
                                z3 = false;
                            }
                            if (z3) {
                                long j5 = jV2;
                                iH5 = wf1Var2.h();
                                int i40 = i;
                                if (iH5 != 1635148593 || iH5 == 1635148595 || iH5 == 1701733238 || iH5 == 1831958048 || iH5 == 1836070006 || iH5 == 1752589105 || iH5 == 1751479857 || iH5 == 1932670515 || iH5 == 1211250227 || iH5 == 1987063864 || iH5 == 1987063865 || iH5 == 1635135537 || iH5 == 1685479798 || iH5 == 1685479729 || iH5 == 1685481573 || iH5 == 1685481521) {
                                    i7 = i7;
                                    i15 = i3;
                                    aVar3 = aVar3;
                                    pairCreate = pairCreate;
                                    p52VarArr = p52VarArr;
                                    wf1Var2.e(iD + 16);
                                    wf1Var2.f(16);
                                    iZ = wf1Var2.z();
                                    iZ2 = wf1Var2.z();
                                    wf1Var2.f(50);
                                    iD2 = wf1Var2.d();
                                    if (iH5 == 1701733238) {
                                        iH4 = iH4;
                                        i16 = iD;
                                        pairA = a(i16, iH4, wf1Var2);
                                        if (pairA != null) {
                                            int iIntValue2 = ((Integer) pairA.first).intValue();
                                            if (c40Var == null) {
                                                c40VarA = null;
                                            } else {
                                                c40VarA = c40Var.a(((p52) pairA.second).b);
                                            }
                                            p52VarArr[i7] = (p52) pairA.second;
                                            c40Var2 = c40VarA;
                                            iH5 = iIntValue2;
                                        } else {
                                            c40Var2 = c40Var;
                                        }
                                        wf1Var2.e(iD2);
                                    } else {
                                        iH4 = iH4;
                                        i16 = iD;
                                        c40Var2 = c40Var;
                                    }
                                    if (iH5 == 1831958048) {
                                        str2 = "video/mpeg";
                                    } else if (iH5 == 1211250227) {
                                        str2 = "video/3gpp";
                                    } else {
                                        str2 = null;
                                    }
                                    c40Var3 = c40Var2;
                                    str = str;
                                    z4 = false;
                                    gc0Var2 = gc0VarA;
                                    i17 = i9;
                                    str3 = null;
                                    bArr = null;
                                    list = null;
                                    byteBufferOrder = null;
                                    bVar = null;
                                    i18 = -1;
                                    i19 = -1;
                                    i20 = -1;
                                    i21 = iD2;
                                    fX = 1.0f;
                                    str4 = str2;
                                    i22 = -1;
                                    while (true) {
                                        if (i21 - i16 >= iH4) {
                                            i22 = i22;
                                            listA = list;
                                            break;
                                        }
                                        wf1Var2.e(i21);
                                        iD3 = wf1Var2.d();
                                        listA = list;
                                        iH6 = wf1Var2.h();
                                        if (iH6 == 0) {
                                            i22 = i22;
                                            if (wf1Var2.d() - i16 == iH4) {
                                                break;
                                            }
                                        } else {
                                            i22 = i22;
                                        }
                                        if (iH6 > 0) {
                                            z5 = true;
                                        } else {
                                            z5 = false;
                                        }
                                        if (z5) {
                                            iH7 = wf1Var2.h();
                                            int i41 = i16;
                                            if (iH7 == 1635148611) {
                                                if (str4 == null) {
                                                    z7 = true;
                                                } else {
                                                    z7 = false;
                                                }
                                                if (z7) {
                                                    wf1Var2.e(iD3 + 8);
                                                    miVarA = mi.a(wf1Var2);
                                                    list2 = miVarA.f9640a;
                                                    i28 = miVarA.b;
                                                    if (!z4) {
                                                        fX = miVarA.e;
                                                    }
                                                    str7 = miVarA.f;
                                                    str8 = "video/avc";
                                                } else {
                                                    throw ag1.a((String) null, (Exception) null);
                                                }
                                            } else {
                                                if (iH7 == 1752589123) {
                                                    if (str4 == null) {
                                                        z6 = true;
                                                    } else {
                                                        z6 = false;
                                                    }
                                                    if (z6) {
                                                        wf1Var2.e(iD3 + 8);
                                                        qf0VarA = qf0.a(wf1Var2);
                                                        list2 = qf0VarA.f10014a;
                                                        i28 = qf0VarA.b;
                                                        if (!z4) {
                                                            fX = qf0VarA.c;
                                                        }
                                                        str7 = qf0VarA.d;
                                                        str8 = "video/hevc";
                                                    } else {
                                                        throw ag1.a((String) null, (Exception) null);
                                                    }
                                                } else {
                                                    if (iH7 != 1685480259 || iH7 == 1685485123) {
                                                        iZ = iZ;
                                                        iZ2 = iZ2;
                                                        f = fX;
                                                        iH4 = iH4;
                                                        iH5 = iH5;
                                                        str5 = str3;
                                                        bArrCopyOfRange = bArr;
                                                        q30VarA = q30.a(wf1Var2);
                                                        if (q30VarA != null) {
                                                            str5 = q30VarA.f9977a;
                                                            str4 = "video/dolby-vision";
                                                        }
                                                    } else {
                                                        if (iH7 == 1987076931) {
                                                            if (str4 == null) {
                                                                str6 = iH5 == 1987063864 ? "video/x-vnd.on2.vp8" : "video/x-vnd.on2.vp9";
                                                            } else {
                                                                throw ag1.a((String) null, (Exception) null);
                                                            }
                                                        } else if (iH7 == 1635135811) {
                                                            if (str4 == null) {
                                                                str6 = "video/av01";
                                                            } else {
                                                                throw ag1.a((String) null, (Exception) null);
                                                            }
                                                        } else if (iH7 == 1668050025) {
                                                            if (byteBufferOrder == null) {
                                                                byteBufferOrder = ByteBuffer.allocate(25).order(ByteOrder.LITTLE_ENDIAN);
                                                            }
                                                            ByteBuffer byteBuffer = byteBufferOrder;
                                                            byteBuffer.position(21);
                                                            byteBuffer.putShort(wf1Var2.r());
                                                            byteBuffer.putShort(wf1Var2.r());
                                                            byteBufferOrder = byteBuffer;
                                                            str5 = str3;
                                                            bArrCopyOfRange = bArr;
                                                        } else {
                                                            if (iH7 == 1835295606) {
                                                                if (byteBufferOrder == null) {
                                                                    byteBufferOrder = ByteBuffer.allocate(25).order(ByteOrder.LITTLE_ENDIAN);
                                                                }
                                                                ByteBuffer byteBuffer2 = byteBufferOrder;
                                                                short sR = wf1Var2.r();
                                                                short sR2 = wf1Var2.r();
                                                                iH5 = iH5;
                                                                short sR3 = wf1Var2.r();
                                                                iH4 = iH4;
                                                                short sR4 = wf1Var2.r();
                                                                bArrCopyOfRange = bArr;
                                                                short sR5 = wf1Var2.r();
                                                                f = fX;
                                                                short sR6 = wf1Var2.r();
                                                                iZ2 = iZ2;
                                                                short sR7 = wf1Var2.r();
                                                                iZ = iZ;
                                                                short sR8 = wf1Var2.r();
                                                                long jV5 = wf1Var2.v();
                                                                long jV6 = wf1Var2.v();
                                                                str5 = str3;
                                                                byteBuffer2.position(1);
                                                                byteBuffer2.putShort(sR5);
                                                                byteBuffer2.putShort(sR6);
                                                                byteBuffer2.putShort(sR);
                                                                byteBuffer2.putShort(sR2);
                                                                byteBuffer2.putShort(sR3);
                                                                byteBuffer2.putShort(sR4);
                                                                byteBuffer2.putShort(sR7);
                                                                byteBuffer2.putShort(sR8);
                                                                byteBuffer2.putShort((short) (jV5 / 10000));
                                                                byteBuffer2.putShort((short) (jV6 / 10000));
                                                                byteBufferOrder = byteBuffer2;
                                                            } else {
                                                                iZ = iZ;
                                                                iZ2 = iZ2;
                                                                f = fX;
                                                                iH4 = iH4;
                                                                iH5 = iH5;
                                                                str5 = str3;
                                                                bArrCopyOfRange = bArr;
                                                                if (iH7 != 1681012275) {
                                                                    if (iH7 == 1702061171) {
                                                                        if (str4 == null) {
                                                                            b bVarA2 = a(iD3, wf1Var2);
                                                                            String str14 = bVarA2.f9416a;
                                                                            byte[] bArr3 = bVarA2.b;
                                                                            if (bArr3 != null) {
                                                                                listA = hk0.a(bArr3);
                                                                            }
                                                                            bVar = bVarA2;
                                                                            str4 = str14;
                                                                        } else {
                                                                            throw ag1.a((String) null, (Exception) null);
                                                                        }
                                                                    } else if (iH7 == 1885434736) {
                                                                        wf1Var2.e(iD3 + 8);
                                                                        fX = wf1Var2.x() / wf1Var2.x();
                                                                        i22 = i22;
                                                                        z4 = true;
                                                                    } else if (iH7 == 1937126244) {
                                                                        int i42 = iD3 + 8;
                                                                        while (true) {
                                                                            if (i42 - iD3 < iH6) {
                                                                                wf1Var2.e(i42);
                                                                                int iH18 = wf1Var2.h();
                                                                                if (wf1Var2.h() == 1886547818) {
                                                                                    bArrCopyOfRange = Arrays.copyOfRange(wf1Var2.c(), i42, iH18 + i42);
                                                                                } else {
                                                                                    i42 += iH18;
                                                                                }
                                                                            } else {
                                                                                i22 = i22;
                                                                                fX = f;
                                                                                bArrCopyOfRange = null;
                                                                            }
                                                                        }
                                                                    } else if (iH7 == 1936995172) {
                                                                        int iT = wf1Var2.t();
                                                                        wf1Var2.f(3);
                                                                        if (iT == 0) {
                                                                            int iT2 = wf1Var2.t();
                                                                            if (iT2 == 0) {
                                                                                fX = f;
                                                                                i22 = 0;
                                                                            } else if (iT2 == 1) {
                                                                                fX = f;
                                                                                i22 = 1;
                                                                            } else if (iT2 == 2) {
                                                                                fX = f;
                                                                                i22 = 2;
                                                                            } else if (iT2 == 3) {
                                                                                i22 = 3;
                                                                                fX = f;
                                                                            }
                                                                        }
                                                                    } else if (iH7 == 1668246642) {
                                                                        int iH19 = wf1Var2.h();
                                                                        if (iH19 != 1852009592 && iH19 != 1852009571) {
                                                                            at0.d("AtomParsers", "Unsupported color type: " + jh.a(iH19));
                                                                        } else {
                                                                            int iZ6 = wf1Var2.z();
                                                                            int iZ7 = wf1Var2.z();
                                                                            wf1Var2.f(2);
                                                                            boolean z11 = iH6 == 19 && (wf1Var2.t() & 128) != 0;
                                                                            jm.a<pq> aVar4 = pq.g;
                                                                            int i43 = 7;
                                                                            if (iZ6 == 1) {
                                                                                i27 = 1;
                                                                            } else if (iZ6 != 9) {
                                                                                i27 = (iZ6 == 4 || iZ6 == 5 || iZ6 == 6 || iZ6 == 7) ? 2 : -1;
                                                                            } else {
                                                                                i27 = 6;
                                                                            }
                                                                            int i44 = z11 ? 1 : 2;
                                                                            if (iZ7 != 1) {
                                                                                if (iZ7 == 16) {
                                                                                    i43 = 6;
                                                                                } else if (iZ7 != 18) {
                                                                                    if (iZ7 != 6 && iZ7 != 7) {
                                                                                        i43 = -1;
                                                                                    }
                                                                                }
                                                                                i20 = i27;
                                                                                i19 = i44;
                                                                                i18 = i43;
                                                                            }
                                                                            i43 = 3;
                                                                            i20 = i27;
                                                                            i19 = i44;
                                                                            i18 = i43;
                                                                        }
                                                                    }
                                                                    i22 = i22;
                                                                    fX = f;
                                                                } else if (str4 == null) {
                                                                    str4 = "video/3gpp";
                                                                } else {
                                                                    throw ag1.a((String) null, (Exception) null);
                                                                }
                                                            }
                                                            fX = f;
                                                        }
                                                        str4 = str6;
                                                        str5 = str3;
                                                        bArrCopyOfRange = bArr;
                                                    }
                                                    i22 = i22;
                                                    fX = f;
                                                }
                                                i21 += iH6;
                                                list = listA;
                                                i16 = i41;
                                                iH5 = iH5;
                                                iH4 = iH4;
                                                bArr = bArrCopyOfRange;
                                                iZ2 = iZ2;
                                                iZ = iZ;
                                                str3 = str5;
                                            }
                                            iZ = iZ;
                                            iZ2 = iZ2;
                                            str5 = str7;
                                            listA = list2;
                                            i17 = i28;
                                            str4 = str8;
                                            bArrCopyOfRange = bArr;
                                            i21 += iH6;
                                            list = listA;
                                            i16 = i41;
                                            iH5 = iH5;
                                            iH4 = iH4;
                                            bArr = bArrCopyOfRange;
                                            iZ2 = iZ2;
                                            iZ = iZ;
                                            str3 = str5;
                                        } else {
                                            throw ag1.a("childAtomSize must be positive", (Exception) null);
                                        }
                                    }
                                    if (str4 == null) {
                                        i3 = i15;
                                        gc0VarA = gc0Var2;
                                        i9 = i17;
                                    } else {
                                        gc0.a aVarB5 = new gc0.a().g(iH13).e(str4).a(str3).o(iZ).f(i23).b(fX);
                                        i3 = i15;
                                        aVarA = aVarB5.k(i3).a(bArr).n(i22).a(listA).a(c40Var3);
                                        i24 = i20;
                                        if (i24 == -1) {
                                            i26 = i19;
                                            i25 = i18;
                                            if (i26 == -1 || i25 != -1 || byteBufferOrder != null) {
                                            }
                                            if (bVar != null) {
                                                aVarA.b(dq0.b(bVar.c)).j(dq0.b(bVar.d));
                                            }
                                            gc0VarA = aVarA.a();
                                            i9 = i17;
                                        } else {
                                            i23 = iZ2;
                                            i25 = i18;
                                            i26 = i19;
                                        }
                                        i23 = iZ2;
                                        if (byteBufferOrder != null) {
                                            bArrArray = byteBufferOrder.array();
                                        } else {
                                            bArrArray = null;
                                        }
                                        aVarA.a(new pq(i24, i26, i25, bArrArray));
                                        if (bVar != null) {
                                            aVarA.b(dq0.b(bVar.c)).j(dq0.b(bVar.d));
                                        }
                                        gc0VarA = aVarA.a();
                                        i9 = i17;
                                    }
                                } else {
                                    if (iH5 == 1836069985 || iH5 == 1701733217 || iH5 == 1633889587 || iH5 == 1700998451 || iH5 == 1633889588 || iH5 == 1835823201 || iH5 == 1685353315 || iH5 == 1685353317 || iH5 == 1685353320 || iH5 == 1685353324 || iH5 == 1685353336 || iH5 == 1935764850 || iH5 == 1935767394 || iH5 == 1819304813 || iH5 == 1936684916 || iH5 == 1953984371 || iH5 == 778924082 || iH5 == 778924083 || iH5 == 1835557169 || iH5 == 1835560241 || iH5 == 1634492771 || iH5 == 1634492791 || iH5 == 1970037111 || iH5 == 1332770163 || iH5 == 1716281667) {
                                        wf1Var2.e(iD + 16);
                                        if (z2) {
                                            iZ3 = wf1Var2.z();
                                            wf1Var2.f(6);
                                        } else {
                                            wf1Var2.f(8);
                                            iZ3 = 0;
                                        }
                                        if (iZ3 == 0 || iZ3 == 1) {
                                            iZ4 = wf1Var2.z();
                                            wf1Var2.f(6);
                                            int iU = wf1Var2.u();
                                            wf1Var2.e(wf1Var2.d() - 4);
                                            int iH20 = wf1Var2.h();
                                            if (iZ3 == 1) {
                                                wf1Var2.f(16);
                                            }
                                            i29 = iH20;
                                            i30 = iU;
                                        } else if (iZ3 == 2) {
                                            wf1Var2.f(16);
                                            int iRound = (int) Math.round(Double.longBitsToDouble(wf1Var2.p()));
                                            iZ4 = wf1Var2.x();
                                            wf1Var2.f(20);
                                            i30 = iRound;
                                            i29 = 0;
                                        }
                                        int iD6 = wf1Var2.d();
                                        int i45 = iZ4;
                                        if (iH5 == 1701733217) {
                                            Pair pairA2 = a(iD, iH4, wf1Var2);
                                            if (pairA2 != null) {
                                                int iIntValue3 = ((Integer) pairA2.first).intValue();
                                                c40 c40VarA2 = c40Var == null ? null : c40Var.a(((p52) pairA2.second).b);
                                                p52VarArr[i7] = (p52) pairA2.second;
                                                c40Var4 = c40VarA2;
                                                iH5 = iIntValue3;
                                            } else {
                                                c40Var4 = c40Var;
                                            }
                                            wf1Var2.e(iD6);
                                        } else {
                                            c40Var4 = c40Var;
                                        }
                                        if (iH5 == 1633889587) {
                                            str9 = "audio/ac3";
                                        } else if (iH5 == 1700998451) {
                                            str9 = "audio/eac3";
                                        } else if (iH5 == 1633889588) {
                                            str9 = "audio/ac4";
                                        } else if (iH5 == 1685353315) {
                                            str9 = "audio/vnd.dts";
                                        } else if (iH5 == 1685353320 || iH5 == 1685353324) {
                                            str9 = "audio/vnd.dts.hd";
                                        } else if (iH5 == 1685353317) {
                                            str9 = "audio/vnd.dts.hd;profile=lbr";
                                        } else if (iH5 == 1685353336) {
                                            str9 = "audio/vnd.dts.uhd;profile=p2";
                                        } else if (iH5 == 1935764850) {
                                            str9 = "audio/3gpp";
                                        } else if (iH5 == 1935767394) {
                                            str9 = "audio/amr-wb";
                                        } else {
                                            if (iH5 == 1819304813 || iH5 == 1936684916) {
                                                str9 = "audio/raw";
                                                i31 = 2;
                                            } else if (iH5 == 1953984371) {
                                                str9 = "audio/raw";
                                                i31 = 268435456;
                                            } else if (iH5 == 778924082 || iH5 == 778924083) {
                                                str9 = "audio/mpeg";
                                            } else if (iH5 == 1835557169) {
                                                str9 = "audio/mha1";
                                            } else if (iH5 == 1835560241) {
                                                str9 = "audio/mhm1";
                                            } else if (iH5 == 1634492771) {
                                                str9 = "audio/alac";
                                            } else if (iH5 == 1634492791) {
                                                str9 = "audio/g711-alaw";
                                            } else if (iH5 == 1970037111) {
                                                str9 = "audio/g711-mlaw";
                                            } else if (iH5 == 1332770163) {
                                                str9 = "audio/opus";
                                            } else if (iH5 == 1716281667) {
                                                str9 = "audio/flac";
                                            } else {
                                                str9 = iH5 == 1835823201 ? "audio/true-hd" : null;
                                            }
                                            i7 = i7;
                                            int i46 = i3;
                                            iIntValue = i45;
                                            listA2 = null;
                                            str10 = null;
                                            aVar3 = aVar3;
                                            i32 = i30;
                                            gc0Var3 = gc0VarA;
                                            str11 = str9;
                                            i33 = iD6;
                                            bVar2 = null;
                                            while (i33 - iD < iH4) {
                                                wf1Var2.e(i33);
                                                iH8 = wf1Var2.h();
                                                if (iH8 > 0) {
                                                    z8 = true;
                                                } else {
                                                    z8 = false;
                                                }
                                                if (z8) {
                                                    int i47 = iH4;
                                                    iH9 = wf1Var2.h();
                                                    int i48 = iD;
                                                    if (iH9 == 1835557187) {
                                                        int i49 = iH8 - 13;
                                                        byte[] bArr4 = new byte[i49];
                                                        wf1Var2.e(i33 + 13);
                                                        wf1Var2.a(bArr4, 0, i49);
                                                        listA2 = hk0.a(bArr4);
                                                    } else {
                                                        if (iH9 != 1702061171) {
                                                            if (z2 || iH9 != 2002876005) {
                                                                if (iH9 == 1684103987) {
                                                                    wf1Var2.e(i33 + 8);
                                                                    gc0VarB = t.a(wf1Var2, Integer.toString(iH13), str, c40Var4);
                                                                } else if (iH9 == 1684366131) {
                                                                    wf1Var2.e(i33 + 8);
                                                                    gc0VarB = t.b(wf1Var2, Integer.toString(iH13), str, c40Var4);
                                                                } else {
                                                                    if (iH9 == 1684103988) {
                                                                        wf1Var2.e(i33 + 8);
                                                                        String string = Integer.toString(iH13);
                                                                        wf1Var2.f(1);
                                                                        listA2 = listA2;
                                                                        if (((wf1Var2.t() & 32) >> 5) == 1) {
                                                                            i36 = 48000;
                                                                        } else {
                                                                            i36 = 44100;
                                                                        }
                                                                        gc0VarA2 = new gc0.a().b(string).e("audio/ac4").c(2).l(i36).a(c40Var4).d(str).a();
                                                                    } else {
                                                                        listA2 = listA2;
                                                                        if (iH9 == 1684892784) {
                                                                            if (i29 > 0) {
                                                                                throw ag1.a("Invalid sample rate for Dolby TrueHD MLP stream: " + i29, (Exception) null);
                                                                            }
                                                                            i32 = i29;
                                                                            i29 = i32;
                                                                            listA2 = listA2;
                                                                            iIntValue = 2;
                                                                        } else if (iH9 == 1684305011) {
                                                                            gc0VarA2 = new gc0.a().g(iH13).e(str11).c(iIntValue).l(i32).a(c40Var4).d(str).a();
                                                                        } else if (iH9 == 1682927731) {
                                                                            int i50 = iH8 - 8;
                                                                            byte[] bArr5 = f9414a;
                                                                            byte[] bArrCopyOf = Arrays.copyOf(bArr5, bArr5.length + i50);
                                                                            i29 = i29;
                                                                            wf1Var2.e(i33 + 8);
                                                                            wf1Var2.a(bArrCopyOf, bArr5.length, i50);
                                                                            listA2 = ef1.a(bArrCopyOf);
                                                                        } else {
                                                                            i29 = i29;
                                                                            if (iH9 == 1684425825) {
                                                                                byte[] bArr6 = new byte[iH8 - 8];
                                                                                bArr6[0] = 102;
                                                                                bArr6[1] = 76;
                                                                                bArr6[2] = 97;
                                                                                bArr6[3] = 67;
                                                                                wf1Var2.e(i33 + 12);
                                                                                wf1Var2.a(bArr6, 4, iH8 - 12);
                                                                                listA2 = hk0.a(bArr6);
                                                                            } else {
                                                                                if (iH9 == 1634492771) {
                                                                                    int i51 = iH8 - 12;
                                                                                    byte[] bArr7 = new byte[i51];
                                                                                    wf1Var2.e(i33 + 12);
                                                                                    wf1Var2.a(bArr7, 0, i51);
                                                                                    wf1 wf1Var7 = new wf1(bArr7);
                                                                                    wf1Var7.e(9);
                                                                                    int iT3 = wf1Var7.t();
                                                                                    wf1Var7.e(20);
                                                                                    Pair pairCreate3 = Pair.create(Integer.valueOf(wf1Var7.x()), Integer.valueOf(iT3));
                                                                                    int iIntValue4 = ((Integer) pairCreate3.first).intValue();
                                                                                    iIntValue = ((Integer) pairCreate3.second).intValue();
                                                                                    listA2 = hk0.a(bArr7);
                                                                                    i32 = iIntValue4;
                                                                                }
                                                                                listA2 = listA2;
                                                                            }
                                                                        }
                                                                    }
                                                                    gc0Var3 = gc0VarA2;
                                                                    i29 = i29;
                                                                    listA2 = listA2;
                                                                }
                                                                gc0Var3 = gc0VarB;
                                                            } else {
                                                                i34 = 1702061171;
                                                            }
                                                            i33 += iH8;
                                                            iH4 = i47;
                                                            iD = i48;
                                                            i29 = i29;
                                                        } else {
                                                            i34 = 1702061171;
                                                        }
                                                        if (iH9 == i34) {
                                                            iD4 = i33;
                                                        } else {
                                                            iD4 = wf1Var2.d();
                                                            if (iD4 >= i33) {
                                                                z9 = true;
                                                            } else {
                                                                z9 = false;
                                                            }
                                                            if (z9) {
                                                                throw ag1.a((String) null, (Exception) null);
                                                            }
                                                            while (true) {
                                                                if (iD4 - i33 < iH8) {
                                                                    i35 = -1;
                                                                    iD4 = -1;
                                                                    break;
                                                                }
                                                                wf1Var2.e(iD4);
                                                                iH10 = wf1Var2.h();
                                                                if (iH10 > 0) {
                                                                    z10 = true;
                                                                } else {
                                                                    z10 = false;
                                                                }
                                                                if (z10) {
                                                                    if (wf1Var2.h() == 1702061171) {
                                                                        iD4 += iH10;
                                                                    }
                                                                } else {
                                                                    throw ag1.a("childAtomSize must be positive", (Exception) null);
                                                                }
                                                            }
                                                            if (iD4 != i35) {
                                                                bVarA = a(iD4, wf1Var2);
                                                                str12 = bVarA.f9416a;
                                                                bArr2 = bVarA.b;
                                                                if (bArr2 != null) {
                                                                    if ("audio/mp4a-latm".equals(str12)) {
                                                                        com.yandex.mobile.ads.impl.e.a aVarA2 = com.yandex.mobile.ads.impl.e.a(new vf1(bArr2.length, bArr2), false);
                                                                        i32 = aVarA2.f8746a;
                                                                        iIntValue = aVarA2.b;
                                                                        str10 = aVarA2.c;
                                                                    }
                                                                    bVar2 = bVarA;
                                                                    str11 = str12;
                                                                    listA2 = hk0.a(bArr2);
                                                                } else {
                                                                    bVar2 = bVarA;
                                                                    str11 = str12;
                                                                }
                                                                i33 += iH8;
                                                                iH4 = i47;
                                                                iD = i48;
                                                                i29 = i29;
                                                            }
                                                            listA2 = listA2;
                                                            i33 += iH8;
                                                            iH4 = i47;
                                                            iD = i48;
                                                            i29 = i29;
                                                        }
                                                        i35 = -1;
                                                        if (iD4 != i35) {
                                                            bVarA = a(iD4, wf1Var2);
                                                            str12 = bVarA.f9416a;
                                                            bArr2 = bVarA.b;
                                                            if (bArr2 != null) {
                                                                if ("audio/mp4a-latm".equals(str12)) {
                                                                    com.yandex.mobile.ads.impl.e.a aVarA3 = com.yandex.mobile.ads.impl.e.a(new vf1(bArr2.length, bArr2), false);
                                                                    i32 = aVarA3.f8746a;
                                                                    iIntValue = aVarA3.b;
                                                                    str10 = aVarA3.c;
                                                                }
                                                                bVar2 = bVarA;
                                                                str11 = str12;
                                                                listA2 = hk0.a(bArr2);
                                                            } else {
                                                                bVar2 = bVarA;
                                                                str11 = str12;
                                                            }
                                                            i33 += iH8;
                                                            iH4 = i47;
                                                            iD = i48;
                                                            i29 = i29;
                                                        }
                                                        listA2 = listA2;
                                                        i33 += iH8;
                                                        iH4 = i47;
                                                        iD = i48;
                                                        i29 = i29;
                                                    }
                                                    i29 = i29;
                                                    i33 += iH8;
                                                    iH4 = i47;
                                                    iD = i48;
                                                    i29 = i29;
                                                } else {
                                                    throw ag1.a("childAtomSize must be positive", (Exception) null);
                                                }
                                            }
                                            List<byte[]> list3 = listA2;
                                            int i52 = iH4;
                                            int i53 = iD;
                                            if (gc0Var3 == null || str11 == null) {
                                                gc0VarA = gc0Var3;
                                            } else {
                                                gc0.a aVarD = new gc0.a().g(iH13).e(str11).a(str10).c(iIntValue).l(i32).i(i31).a(list3).a(c40Var4).d(str);
                                                if (bVar2 != null) {
                                                    aVarD.b(dq0.b(bVar2.c)).j(dq0.b(bVar2.d));
                                                }
                                                gc0VarA = aVarD.a();
                                            }
                                            i3 = i46;
                                            iH4 = i52;
                                            i16 = i53;
                                        }
                                        i31 = -1;
                                        i7 = i7;
                                        int i410 = i3;
                                        iIntValue = i45;
                                        listA2 = null;
                                        str10 = null;
                                        aVar3 = aVar3;
                                        i32 = i30;
                                        gc0Var3 = gc0VarA;
                                        str11 = str9;
                                        i33 = iD6;
                                        bVar2 = null;
                                        while (i33 - iD < iH4) {
                                            wf1Var2.e(i33);
                                            iH8 = wf1Var2.h();
                                            if (iH8 > 0) {
                                                z8 = true;
                                            } else {
                                                z8 = false;
                                            }
                                            if (z8) {
                                                int i411 = iH4;
                                                iH9 = wf1Var2.h();
                                                int i412 = iD;
                                                if (iH9 == 1835557187) {
                                                    int i413 = iH8 - 13;
                                                    byte[] bArr8 = new byte[i413];
                                                    wf1Var2.e(i33 + 13);
                                                    wf1Var2.a(bArr8, 0, i413);
                                                    listA2 = hk0.a(bArr8);
                                                } else {
                                                    if (iH9 != 1702061171) {
                                                        if (z2) {
                                                        }
                                                        if (iH9 == 1684103987) {
                                                            wf1Var2.e(i33 + 8);
                                                            gc0VarB = t.a(wf1Var2, Integer.toString(iH13), str, c40Var4);
                                                        } else {
                                                            if (iH9 == 1684366131) {
                                                                wf1Var2.e(i33 + 8);
                                                                gc0VarB = t.b(wf1Var2, Integer.toString(iH13), str, c40Var4);
                                                            } else {
                                                                if (iH9 == 1684103988) {
                                                                    wf1Var2.e(i33 + 8);
                                                                    String string2 = Integer.toString(iH13);
                                                                    wf1Var2.f(1);
                                                                    listA2 = listA2;
                                                                    if (((wf1Var2.t() & 32) >> 5) == 1) {
                                                                        i36 = 48000;
                                                                    } else {
                                                                        i36 = 44100;
                                                                    }
                                                                    gc0VarA2 = new gc0.a().b(string2).e("audio/ac4").c(2).l(i36).a(c40Var4).d(str).a();
                                                                } else {
                                                                    listA2 = listA2;
                                                                    if (iH9 == 1684892784) {
                                                                        if (i29 > 0) {
                                                                            throw ag1.a("Invalid sample rate for Dolby TrueHD MLP stream: " + i29, (Exception) null);
                                                                        }
                                                                        i32 = i29;
                                                                        i29 = i32;
                                                                        listA2 = listA2;
                                                                        iIntValue = 2;
                                                                    } else if (iH9 == 1684305011) {
                                                                        gc0VarA2 = new gc0.a().g(iH13).e(str11).c(iIntValue).l(i32).a(c40Var4).d(str).a();
                                                                    } else if (iH9 == 1682927731) {
                                                                        int i54 = iH8 - 8;
                                                                        byte[] bArr9 = f9414a;
                                                                        byte[] bArrCopyOf2 = Arrays.copyOf(bArr9, bArr9.length + i54);
                                                                        i29 = i29;
                                                                        wf1Var2.e(i33 + 8);
                                                                        wf1Var2.a(bArrCopyOf2, bArr9.length, i54);
                                                                        listA2 = ef1.a(bArrCopyOf2);
                                                                    } else {
                                                                        i29 = i29;
                                                                        if (iH9 == 1684425825) {
                                                                            byte[] bArr10 = new byte[iH8 - 8];
                                                                            bArr10[0] = 102;
                                                                            bArr10[1] = 76;
                                                                            bArr10[2] = 97;
                                                                            bArr10[3] = 67;
                                                                            wf1Var2.e(i33 + 12);
                                                                            wf1Var2.a(bArr10, 4, iH8 - 12);
                                                                            listA2 = hk0.a(bArr10);
                                                                        } else {
                                                                            if (iH9 == 1634492771) {
                                                                                int i55 = iH8 - 12;
                                                                                byte[] bArr11 = new byte[i55];
                                                                                wf1Var2.e(i33 + 12);
                                                                                wf1Var2.a(bArr11, 0, i55);
                                                                                wf1 wf1Var8 = new wf1(bArr11);
                                                                                wf1Var8.e(9);
                                                                                int iT4 = wf1Var8.t();
                                                                                wf1Var8.e(20);
                                                                                Pair pairCreate4 = Pair.create(Integer.valueOf(wf1Var8.x()), Integer.valueOf(iT4));
                                                                                int iIntValue5 = ((Integer) pairCreate4.first).intValue();
                                                                                iIntValue = ((Integer) pairCreate4.second).intValue();
                                                                                listA2 = hk0.a(bArr11);
                                                                                i32 = iIntValue5;
                                                                            }
                                                                            listA2 = listA2;
                                                                        }
                                                                    }
                                                                }
                                                                gc0Var3 = gc0VarA2;
                                                                i29 = i29;
                                                                listA2 = listA2;
                                                            }
                                                            i33 += iH8;
                                                            iH4 = i411;
                                                            iD = i412;
                                                            i29 = i29;
                                                        }
                                                        gc0Var3 = gc0VarB;
                                                    } else {
                                                        i34 = 1702061171;
                                                    }
                                                    if (iH9 == i34) {
                                                        iD4 = i33;
                                                    } else {
                                                        iD4 = wf1Var2.d();
                                                        if (iD4 >= i33) {
                                                            z9 = true;
                                                        } else {
                                                            z9 = false;
                                                        }
                                                        if (z9) {
                                                            throw ag1.a((String) null, (Exception) null);
                                                        }
                                                        while (true) {
                                                            if (iD4 - i33 < iH8) {
                                                                i35 = -1;
                                                                iD4 = -1;
                                                                break;
                                                            }
                                                            wf1Var2.e(iD4);
                                                            iH10 = wf1Var2.h();
                                                            if (iH10 > 0) {
                                                                z10 = true;
                                                            } else {
                                                                z10 = false;
                                                            }
                                                            if (z10) {
                                                                if (wf1Var2.h() == 1702061171) {
                                                                    iD4 += iH10;
                                                                }
                                                            } else {
                                                                throw ag1.a("childAtomSize must be positive", (Exception) null);
                                                            }
                                                        }
                                                        if (iD4 != i35) {
                                                            bVarA = a(iD4, wf1Var2);
                                                            str12 = bVarA.f9416a;
                                                            bArr2 = bVarA.b;
                                                            if (bArr2 != null) {
                                                                if ("audio/mp4a-latm".equals(str12)) {
                                                                    com.yandex.mobile.ads.impl.e.a aVarA4 = com.yandex.mobile.ads.impl.e.a(new vf1(bArr2.length, bArr2), false);
                                                                    i32 = aVarA4.f8746a;
                                                                    iIntValue = aVarA4.b;
                                                                    str10 = aVarA4.c;
                                                                }
                                                                bVar2 = bVarA;
                                                                str11 = str12;
                                                                listA2 = hk0.a(bArr2);
                                                            } else {
                                                                bVar2 = bVarA;
                                                                str11 = str12;
                                                            }
                                                            i33 += iH8;
                                                            iH4 = i411;
                                                            iD = i412;
                                                            i29 = i29;
                                                        }
                                                        listA2 = listA2;
                                                        i33 += iH8;
                                                        iH4 = i411;
                                                        iD = i412;
                                                        i29 = i29;
                                                    }
                                                    i35 = -1;
                                                    if (iD4 != i35) {
                                                        bVarA = a(iD4, wf1Var2);
                                                        str12 = bVarA.f9416a;
                                                        bArr2 = bVarA.b;
                                                        if (bArr2 != null) {
                                                            if ("audio/mp4a-latm".equals(str12)) {
                                                                com.yandex.mobile.ads.impl.e.a aVarA5 = com.yandex.mobile.ads.impl.e.a(new vf1(bArr2.length, bArr2), false);
                                                                i32 = aVarA5.f8746a;
                                                                iIntValue = aVarA5.b;
                                                                str10 = aVarA5.c;
                                                            }
                                                            bVar2 = bVarA;
                                                            str11 = str12;
                                                            listA2 = hk0.a(bArr2);
                                                        } else {
                                                            bVar2 = bVarA;
                                                            str11 = str12;
                                                        }
                                                        i33 += iH8;
                                                        iH4 = i411;
                                                        iD = i412;
                                                        i29 = i29;
                                                    }
                                                    listA2 = listA2;
                                                    i33 += iH8;
                                                    iH4 = i411;
                                                    iD = i412;
                                                    i29 = i29;
                                                }
                                                i29 = i29;
                                                i33 += iH8;
                                                iH4 = i411;
                                                iD = i412;
                                                i29 = i29;
                                            } else {
                                                throw ag1.a("childAtomSize must be positive", (Exception) null);
                                            }
                                        }
                                        List<byte[]> list4 = listA2;
                                        int i56 = iH4;
                                        int i57 = iD;
                                        if (gc0Var3 == null) {
                                            gc0VarA = gc0Var3;
                                        } else {
                                            gc0VarA = gc0Var3;
                                        }
                                        i3 = i410;
                                        iH4 = i56;
                                        i16 = i57;
                                    } else {
                                        if (iH5 == 1414810956 || iH5 == 1954034535 || iH5 == 2004251764 || iH5 == 1937010800 || iH5 == 1664495672) {
                                            wf1Var2.e(iD + 16);
                                            long j6 = Long.MAX_VALUE;
                                            if (iH5 == 1414810956) {
                                                str13 = "application/ttml+xml";
                                            } else {
                                                if (iH5 == 1954034535) {
                                                    int i58 = iH4 - 16;
                                                    byte[] bArr12 = new byte[i58];
                                                    wf1Var2.a(bArr12, 0, i58);
                                                    j4 = Long.MAX_VALUE;
                                                    hk0VarA = hk0.a(bArr12);
                                                    str13 = "application/x-quicktime-tx3g";
                                                } else if (iH5 == 2004251764) {
                                                    str13 = "application/x-mp4-vtt";
                                                } else if (iH5 == 1937010800) {
                                                    str13 = "application/ttml+xml";
                                                    j6 = 0;
                                                } else if (iH5 == 1664495672) {
                                                    str13 = "application/x-mp4-cea-608";
                                                    j4 = Long.MAX_VALUE;
                                                    hk0VarA = null;
                                                    i8 = 1;
                                                } else {
                                                    throw new IllegalStateException();
                                                }
                                                gc0VarA = new gc0.a().g(iH13).e(str13).d(str).a(j4).a(hk0VarA).a();
                                            }
                                            j4 = j6;
                                            hk0VarA = null;
                                            gc0VarA = new gc0.a().g(iH13).e(str13).d(str).a(j4).a(hk0VarA).a();
                                        } else {
                                            if (iH5 == 1835365492) {
                                                wf1Var2.e(iD + 16);
                                                if (iH5 == 1835365492) {
                                                    wf1Var2.q();
                                                    String strQ = wf1Var2.q();
                                                    if (strQ != null) {
                                                        gc0VarA = new gc0.a().g(iH13).e(strQ).a();
                                                    }
                                                }
                                            } else if (iH5 == 1667329389) {
                                                gc0VarA = new gc0.a().g(iH13).e("application/x-camera-motion").a();
                                            }
                                            str = str;
                                            i16 = iD;
                                        }
                                        str = str;
                                        i16 = iD;
                                    }
                                    str = str;
                                    i16 = iD;
                                }
                                wf1Var2.e(i16 + iH4);
                                i7++;
                                c40Var = c40Var;
                                iH2 = i13;
                                i = i40;
                                i37 = i14;
                                arrayList3 = arrayList2;
                                jV2 = j5;
                                str = str;
                                aVar3 = aVar3;
                                pairCreate = pairCreate;
                                p52VarArr = p52VarArr;
                            } else {
                                throw ag1.a("childAtomSize must be positive", (Exception) null);
                            }
                        }
                        arrayList = arrayList3;
                        i10 = i37;
                        aVar2 = aVar3;
                        pair = pairCreate;
                        i11 = i;
                        j3 = jV2;
                        p52VarArr2 = p52VarArr;
                        gc0Var = gc0VarA;
                        o52Var = null;
                        if (z) {
                            aVar3 = aVar2;
                        } else {
                            aVar3 = aVar2;
                            aVarB = aVar3.b(1701082227);
                            if (aVarB == null) {
                                bVarC = aVarB.c(1701606260);
                                if (bVarC == null) {
                                    pairCreate2 = null;
                                } else {
                                    wf1Var3 = bVarC.b;
                                    wf1Var3.e(8);
                                    iH3 = (wf1Var3.h() >> 24) & 255;
                                    iX = wf1Var3.x();
                                    jArr3 = new long[iX];
                                    jArr4 = new long[iX];
                                    for (i12 = 0; i12 < iX; i12++) {
                                        if (iH3 == 1) {
                                            jV3 = wf1Var3.y();
                                        } else {
                                            jV3 = wf1Var3.v();
                                        }
                                        jArr3[i12] = jV3;
                                        if (iH3 == 1) {
                                            jH = wf1Var3.p();
                                        } else {
                                            jH = wf1Var3.h();
                                        }
                                        jArr4[i12] = jH;
                                        if (wf1Var3.r() == 1) {
                                            wf1Var3.f(2);
                                        } else {
                                            throw new IllegalArgumentException("Unsupported media rate.");
                                        }
                                    }
                                    pairCreate2 = Pair.create(jArr3, jArr4);
                                }
                                if (pairCreate2 != null) {
                                    long[] jArr5 = (long[]) pairCreate2.first;
                                    jArr = (long[]) pairCreate2.second;
                                    jArr2 = jArr5;
                                }
                            }
                            if (gc0Var == null) {
                                o52Var2 = new o52(iH13, i11, ((Long) pair.first).longValue(), j3, jA, gc0Var, i8, p52VarArr2, i9, jArr2, jArr);
                            }
                            o52Var3 = (o52) ce0Var.apply(o52Var2);
                            if (o52Var3 == null) {
                                arrayList3 = arrayList;
                            } else {
                                jh.a aVarB6 = aVar3.b(1835297121);
                                aVarB6.getClass();
                                jh.a aVarB7 = aVarB6.b(1835626086);
                                aVarB7.getClass();
                                jh.a aVarB8 = aVarB7.b(1937007212);
                                aVarB8.getClass();
                                u52 u52VarA = a(o52Var3, aVarB8, fe0Var);
                                arrayList3 = arrayList;
                                arrayList3.add(u52VarA);
                            }
                        }
                        jArr = null;
                        jArr2 = null;
                        if (gc0Var == null) {
                            o52Var2 = new o52(iH13, i11, ((Long) pair.first).longValue(), j3, jA, gc0Var, i8, p52VarArr2, i9, jArr2, jArr);
                        }
                        o52Var3 = (o52) ce0Var.apply(o52Var2);
                        if (o52Var3 == null) {
                            arrayList3 = arrayList;
                        } else {
                            jh.a aVarB9 = aVar3.b(1835297121);
                            aVarB9.getClass();
                            jh.a aVarB10 = aVarB9.b(1835626086);
                            aVarB10.getClass();
                            jh.a aVarB11 = aVarB10.b(1937007212);
                            aVarB11.getClass();
                            u52 u52VarA2 = a(o52Var3, aVarB11, fe0Var);
                            arrayList3 = arrayList;
                            arrayList3.add(u52VarA2);
                        }
                    } else {
                        i2 = SupportMenu.CATEGORY_MASK;
                    }
                    if (iH14 == 0 && iH15 == i2) {
                        if (iH16 == 65536 && iH17 == 0) {
                            i3 = 270;
                        } else {
                            i2 = SupportMenu.CATEGORY_MASK;
                            if (iH14 != i2) {
                                i3 = 0;
                            } else {
                                i3 = 0;
                            }
                        }
                    } else if (iH14 != i2 && iH15 == 0 && iH16 == 0 && iH17 == i2) {
                        i3 = 180;
                    } else {
                        i3 = 0;
                    }
                    if (j == -9223372036854775807L) {
                        j2 = jV;
                    } else {
                        j2 = j;
                    }
                    wf1Var = bVarC2.b;
                    wf1Var.e(8);
                    if (((wf1Var.h() >> 24) & 255) == 0) {
                        i4 = 8;
                    } else {
                        i4 = 16;
                    }
                    wf1Var.f(i4);
                    jV2 = wf1Var.v();
                    if (j2 != -9223372036854775807L) {
                    }
                    jh.a aVarB12 = aVarB2.b(1835626086);
                    aVarB12.getClass();
                    jh.a aVarB13 = aVarB12.b(1937007212);
                    aVarB13.getClass();
                    jh.b bVarC7 = aVarB2.c(1835296868);
                    bVarC7.getClass();
                    wf1 wf1Var9 = bVarC7.b;
                    wf1Var9.e(8);
                    iH = (wf1Var9.h() >> 24) & 255;
                    if (iH == 0) {
                        i5 = 8;
                    } else {
                        i5 = 16;
                    }
                    wf1Var9.f(i5);
                    long jV7 = wf1Var9.v();
                    if (iH == 0) {
                        i6 = 4;
                    } else {
                        i6 = 8;
                    }
                    wf1Var9.f(i6);
                    int iZ8 = wf1Var9.z();
                    pairCreate = Pair.create(Long.valueOf(jV7), "" + ((char) (((iZ8 >> 10) & 31) + 96)) + ((char) (((iZ8 >> 5) & 31) + 96)) + ((char) ((iZ8 & 31) + 96)));
                    jh.b bVarC8 = aVarB13.c(1937011556);
                    bVarC8.getClass();
                    wf1Var2 = bVarC8.b;
                    str = (String) pairCreate.second;
                    wf1Var2.e(12);
                    iH2 = wf1Var2.h();
                    p52VarArr = new p52[iH2];
                    i7 = 0;
                    gc0VarA = null;
                    i8 = 0;
                    i9 = 0;
                    while (i7 < iH2) {
                        i13 = iH2;
                        iD = wf1Var2.d();
                        i14 = i37;
                        iH4 = wf1Var2.h();
                        arrayList2 = arrayList3;
                        if (iH4 > 0) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        if (z3) {
                            long j7 = jV2;
                            iH5 = wf1Var2.h();
                            int i414 = i;
                            if (iH5 != 1635148593) {
                                i7 = i7;
                                i15 = i3;
                                aVar3 = aVar3;
                                pairCreate = pairCreate;
                                p52VarArr = p52VarArr;
                                wf1Var2.e(iD + 16);
                                wf1Var2.f(16);
                                iZ = wf1Var2.z();
                                iZ2 = wf1Var2.z();
                                wf1Var2.f(50);
                                iD2 = wf1Var2.d();
                                if (iH5 == 1701733238) {
                                    iH4 = iH4;
                                    i16 = iD;
                                    pairA = a(i16, iH4, wf1Var2);
                                    if (pairA != null) {
                                        int iIntValue6 = ((Integer) pairA.first).intValue();
                                        if (c40Var == null) {
                                            c40VarA = null;
                                        } else {
                                            c40VarA = c40Var.a(((p52) pairA.second).b);
                                        }
                                        p52VarArr[i7] = (p52) pairA.second;
                                        c40Var2 = c40VarA;
                                        iH5 = iIntValue6;
                                    } else {
                                        c40Var2 = c40Var;
                                    }
                                    wf1Var2.e(iD2);
                                } else {
                                    iH4 = iH4;
                                    i16 = iD;
                                    c40Var2 = c40Var;
                                }
                                if (iH5 == 1831958048) {
                                    str2 = "video/mpeg";
                                } else if (iH5 == 1211250227) {
                                    str2 = "video/3gpp";
                                } else {
                                    str2 = null;
                                }
                                c40Var3 = c40Var2;
                                str = str;
                                z4 = false;
                                gc0Var2 = gc0VarA;
                                i17 = i9;
                                str3 = null;
                                bArr = null;
                                list = null;
                                byteBufferOrder = null;
                                bVar = null;
                                i18 = -1;
                                i19 = -1;
                                i20 = -1;
                                i21 = iD2;
                                fX = 1.0f;
                                str4 = str2;
                                i22 = -1;
                                while (true) {
                                    if (i21 - i16 >= iH4) {
                                        i22 = i22;
                                        listA = list;
                                        break;
                                    }
                                    wf1Var2.e(i21);
                                    iD3 = wf1Var2.d();
                                    listA = list;
                                    iH6 = wf1Var2.h();
                                    if (iH6 == 0) {
                                        i22 = i22;
                                        if (wf1Var2.d() - i16 == iH4) {
                                            break;
                                            break;
                                        }
                                    } else {
                                        i22 = i22;
                                    }
                                    if (iH6 > 0) {
                                        z5 = true;
                                    } else {
                                        z5 = false;
                                    }
                                    if (z5) {
                                        iH7 = wf1Var2.h();
                                        int i415 = i16;
                                        if (iH7 == 1635148611) {
                                            if (str4 == null) {
                                                z7 = true;
                                            } else {
                                                z7 = false;
                                            }
                                            if (z7) {
                                                wf1Var2.e(iD3 + 8);
                                                miVarA = mi.a(wf1Var2);
                                                list2 = miVarA.f9640a;
                                                i28 = miVarA.b;
                                                if (!z4) {
                                                    fX = miVarA.e;
                                                }
                                                str7 = miVarA.f;
                                                str8 = "video/avc";
                                            } else {
                                                throw ag1.a((String) null, (Exception) null);
                                            }
                                        } else {
                                            if (iH7 == 1752589123) {
                                                if (str4 == null) {
                                                    z6 = true;
                                                } else {
                                                    z6 = false;
                                                }
                                                if (z6) {
                                                    wf1Var2.e(iD3 + 8);
                                                    qf0VarA = qf0.a(wf1Var2);
                                                    list2 = qf0VarA.f10014a;
                                                    i28 = qf0VarA.b;
                                                    if (!z4) {
                                                        fX = qf0VarA.c;
                                                    }
                                                    str7 = qf0VarA.d;
                                                    str8 = "video/hevc";
                                                } else {
                                                    throw ag1.a((String) null, (Exception) null);
                                                }
                                            } else if (iH7 != 1685480259) {
                                                iZ = iZ;
                                                iZ2 = iZ2;
                                                f = fX;
                                                iH4 = iH4;
                                                iH5 = iH5;
                                                str5 = str3;
                                                bArrCopyOfRange = bArr;
                                                q30VarA = q30.a(wf1Var2);
                                                if (q30VarA != null) {
                                                    str5 = q30VarA.f9977a;
                                                    str4 = "video/dolby-vision";
                                                }
                                                i22 = i22;
                                                fX = f;
                                            } else {
                                                iZ = iZ;
                                                iZ2 = iZ2;
                                                f = fX;
                                                iH4 = iH4;
                                                iH5 = iH5;
                                                str5 = str3;
                                                bArrCopyOfRange = bArr;
                                                q30VarA = q30.a(wf1Var2);
                                                if (q30VarA != null) {
                                                    str5 = q30VarA.f9977a;
                                                    str4 = "video/dolby-vision";
                                                }
                                                i22 = i22;
                                                fX = f;
                                            }
                                            i21 += iH6;
                                            list = listA;
                                            i16 = i415;
                                            iH5 = iH5;
                                            iH4 = iH4;
                                            bArr = bArrCopyOfRange;
                                            iZ2 = iZ2;
                                            iZ = iZ;
                                            str3 = str5;
                                        }
                                        iZ = iZ;
                                        iZ2 = iZ2;
                                        str5 = str7;
                                        listA = list2;
                                        i17 = i28;
                                        str4 = str8;
                                        bArrCopyOfRange = bArr;
                                        i21 += iH6;
                                        list = listA;
                                        i16 = i415;
                                        iH5 = iH5;
                                        iH4 = iH4;
                                        bArr = bArrCopyOfRange;
                                        iZ2 = iZ2;
                                        iZ = iZ;
                                        str3 = str5;
                                    } else {
                                        throw ag1.a("childAtomSize must be positive", (Exception) null);
                                    }
                                }
                                if (str4 == null) {
                                    i3 = i15;
                                    gc0VarA = gc0Var2;
                                    i9 = i17;
                                } else {
                                    gc0.a aVarB14 = new gc0.a().g(iH13).e(str4).a(str3).o(iZ).f(i23).b(fX);
                                    i3 = i15;
                                    aVarA = aVarB14.k(i3).a(bArr).n(i22).a(listA).a(c40Var3);
                                    i24 = i20;
                                    if (i24 == -1) {
                                        i26 = i19;
                                        i25 = i18;
                                        if (i26 == -1) {
                                        }
                                        if (bVar != null) {
                                            aVarA.b(dq0.b(bVar.c)).j(dq0.b(bVar.d));
                                        }
                                        gc0VarA = aVarA.a();
                                        i9 = i17;
                                    } else {
                                        i23 = iZ2;
                                        i25 = i18;
                                        i26 = i19;
                                    }
                                    i23 = iZ2;
                                    if (byteBufferOrder != null) {
                                        bArrArray = byteBufferOrder.array();
                                    } else {
                                        bArrArray = null;
                                    }
                                    aVarA.a(new pq(i24, i26, i25, bArrArray));
                                    if (bVar != null) {
                                        aVarA.b(dq0.b(bVar.c)).j(dq0.b(bVar.d));
                                    }
                                    gc0VarA = aVarA.a();
                                    i9 = i17;
                                }
                            } else {
                                i7 = i7;
                                i15 = i3;
                                aVar3 = aVar3;
                                pairCreate = pairCreate;
                                p52VarArr = p52VarArr;
                                wf1Var2.e(iD + 16);
                                wf1Var2.f(16);
                                iZ = wf1Var2.z();
                                iZ2 = wf1Var2.z();
                                wf1Var2.f(50);
                                iD2 = wf1Var2.d();
                                if (iH5 == 1701733238) {
                                    iH4 = iH4;
                                    i16 = iD;
                                    pairA = a(i16, iH4, wf1Var2);
                                    if (pairA != null) {
                                        int iIntValue7 = ((Integer) pairA.first).intValue();
                                        if (c40Var == null) {
                                            c40VarA = null;
                                        } else {
                                            c40VarA = c40Var.a(((p52) pairA.second).b);
                                        }
                                        p52VarArr[i7] = (p52) pairA.second;
                                        c40Var2 = c40VarA;
                                        iH5 = iIntValue7;
                                    } else {
                                        c40Var2 = c40Var;
                                    }
                                    wf1Var2.e(iD2);
                                } else {
                                    iH4 = iH4;
                                    i16 = iD;
                                    c40Var2 = c40Var;
                                }
                                if (iH5 == 1831958048) {
                                    str2 = "video/mpeg";
                                } else if (iH5 == 1211250227) {
                                    str2 = "video/3gpp";
                                } else {
                                    str2 = null;
                                }
                                c40Var3 = c40Var2;
                                str = str;
                                z4 = false;
                                gc0Var2 = gc0VarA;
                                i17 = i9;
                                str3 = null;
                                bArr = null;
                                list = null;
                                byteBufferOrder = null;
                                bVar = null;
                                i18 = -1;
                                i19 = -1;
                                i20 = -1;
                                i21 = iD2;
                                fX = 1.0f;
                                str4 = str2;
                                i22 = -1;
                                while (true) {
                                    if (i21 - i16 >= iH4) {
                                        i22 = i22;
                                        listA = list;
                                        break;
                                    }
                                    wf1Var2.e(i21);
                                    iD3 = wf1Var2.d();
                                    listA = list;
                                    iH6 = wf1Var2.h();
                                    if (iH6 == 0) {
                                        i22 = i22;
                                        if (wf1Var2.d() - i16 == iH4) {
                                            break;
                                            break;
                                        }
                                    } else {
                                        i22 = i22;
                                    }
                                    if (iH6 > 0) {
                                        z5 = true;
                                    } else {
                                        z5 = false;
                                    }
                                    if (z5) {
                                        iH7 = wf1Var2.h();
                                        int i416 = i16;
                                        if (iH7 == 1635148611) {
                                            if (str4 == null) {
                                                z7 = true;
                                            } else {
                                                z7 = false;
                                            }
                                            if (z7) {
                                                wf1Var2.e(iD3 + 8);
                                                miVarA = mi.a(wf1Var2);
                                                list2 = miVarA.f9640a;
                                                i28 = miVarA.b;
                                                if (!z4) {
                                                    fX = miVarA.e;
                                                }
                                                str7 = miVarA.f;
                                                str8 = "video/avc";
                                            } else {
                                                throw ag1.a((String) null, (Exception) null);
                                            }
                                        } else {
                                            if (iH7 == 1752589123) {
                                                if (str4 == null) {
                                                    z6 = true;
                                                } else {
                                                    z6 = false;
                                                }
                                                if (z6) {
                                                    wf1Var2.e(iD3 + 8);
                                                    qf0VarA = qf0.a(wf1Var2);
                                                    list2 = qf0VarA.f10014a;
                                                    i28 = qf0VarA.b;
                                                    if (!z4) {
                                                        fX = qf0VarA.c;
                                                    }
                                                    str7 = qf0VarA.d;
                                                    str8 = "video/hevc";
                                                } else {
                                                    throw ag1.a((String) null, (Exception) null);
                                                }
                                            } else if (iH7 != 1685480259) {
                                                iZ = iZ;
                                                iZ2 = iZ2;
                                                f = fX;
                                                iH4 = iH4;
                                                iH5 = iH5;
                                                str5 = str3;
                                                bArrCopyOfRange = bArr;
                                                q30VarA = q30.a(wf1Var2);
                                                if (q30VarA != null) {
                                                    str5 = q30VarA.f9977a;
                                                    str4 = "video/dolby-vision";
                                                }
                                                i22 = i22;
                                                fX = f;
                                            } else {
                                                iZ = iZ;
                                                iZ2 = iZ2;
                                                f = fX;
                                                iH4 = iH4;
                                                iH5 = iH5;
                                                str5 = str3;
                                                bArrCopyOfRange = bArr;
                                                q30VarA = q30.a(wf1Var2);
                                                if (q30VarA != null) {
                                                    str5 = q30VarA.f9977a;
                                                    str4 = "video/dolby-vision";
                                                }
                                                i22 = i22;
                                                fX = f;
                                            }
                                            i21 += iH6;
                                            list = listA;
                                            i16 = i416;
                                            iH5 = iH5;
                                            iH4 = iH4;
                                            bArr = bArrCopyOfRange;
                                            iZ2 = iZ2;
                                            iZ = iZ;
                                            str3 = str5;
                                        }
                                        iZ = iZ;
                                        iZ2 = iZ2;
                                        str5 = str7;
                                        listA = list2;
                                        i17 = i28;
                                        str4 = str8;
                                        bArrCopyOfRange = bArr;
                                        i21 += iH6;
                                        list = listA;
                                        i16 = i416;
                                        iH5 = iH5;
                                        iH4 = iH4;
                                        bArr = bArrCopyOfRange;
                                        iZ2 = iZ2;
                                        iZ = iZ;
                                        str3 = str5;
                                    } else {
                                        throw ag1.a("childAtomSize must be positive", (Exception) null);
                                    }
                                }
                                if (str4 == null) {
                                    i3 = i15;
                                    gc0VarA = gc0Var2;
                                    i9 = i17;
                                } else {
                                    gc0.a aVarB15 = new gc0.a().g(iH13).e(str4).a(str3).o(iZ).f(i23).b(fX);
                                    i3 = i15;
                                    aVarA = aVarB15.k(i3).a(bArr).n(i22).a(listA).a(c40Var3);
                                    i24 = i20;
                                    if (i24 == -1) {
                                        i26 = i19;
                                        i25 = i18;
                                        if (i26 == -1) {
                                        }
                                        if (bVar != null) {
                                            aVarA.b(dq0.b(bVar.c)).j(dq0.b(bVar.d));
                                        }
                                        gc0VarA = aVarA.a();
                                        i9 = i17;
                                    } else {
                                        i23 = iZ2;
                                        i25 = i18;
                                        i26 = i19;
                                    }
                                    i23 = iZ2;
                                    if (byteBufferOrder != null) {
                                        bArrArray = byteBufferOrder.array();
                                    } else {
                                        bArrArray = null;
                                    }
                                    aVarA.a(new pq(i24, i26, i25, bArrArray));
                                    if (bVar != null) {
                                        aVarA.b(dq0.b(bVar.c)).j(dq0.b(bVar.d));
                                    }
                                    gc0VarA = aVarA.a();
                                    i9 = i17;
                                }
                            }
                            wf1Var2.e(i16 + iH4);
                            i7++;
                            c40Var = c40Var;
                            iH2 = i13;
                            i = i414;
                            i37 = i14;
                            arrayList3 = arrayList2;
                            jV2 = j7;
                            str = str;
                            aVar3 = aVar3;
                            pairCreate = pairCreate;
                            p52VarArr = p52VarArr;
                        } else {
                            throw ag1.a("childAtomSize must be positive", (Exception) null);
                        }
                    }
                    arrayList = arrayList3;
                    i10 = i37;
                    aVar2 = aVar3;
                    pair = pairCreate;
                    i11 = i;
                    j3 = jV2;
                    p52VarArr2 = p52VarArr;
                    gc0Var = gc0VarA;
                    o52Var = null;
                    if (z) {
                        aVar3 = aVar2;
                        aVarB = aVar3.b(1701082227);
                        if (aVarB == null) {
                            bVarC = aVarB.c(1701606260);
                            if (bVarC == null) {
                                pairCreate2 = null;
                            } else {
                                wf1Var3 = bVarC.b;
                                wf1Var3.e(8);
                                iH3 = (wf1Var3.h() >> 24) & 255;
                                iX = wf1Var3.x();
                                jArr3 = new long[iX];
                                jArr4 = new long[iX];
                                while (i12 < iX) {
                                    if (iH3 == 1) {
                                        jV3 = wf1Var3.y();
                                    } else {
                                        jV3 = wf1Var3.v();
                                    }
                                    jArr3[i12] = jV3;
                                    if (iH3 == 1) {
                                        jH = wf1Var3.p();
                                    } else {
                                        jH = wf1Var3.h();
                                    }
                                    jArr4[i12] = jH;
                                    if (wf1Var3.r() == 1) {
                                        wf1Var3.f(2);
                                    } else {
                                        throw new IllegalArgumentException("Unsupported media rate.");
                                    }
                                }
                                pairCreate2 = Pair.create(jArr3, jArr4);
                            }
                            if (pairCreate2 != null) {
                                long[] jArr6 = (long[]) pairCreate2.first;
                                jArr = (long[]) pairCreate2.second;
                                jArr2 = jArr6;
                            }
                        }
                        if (gc0Var == null) {
                            o52Var2 = new o52(iH13, i11, ((Long) pair.first).longValue(), j3, jA, gc0Var, i8, p52VarArr2, i9, jArr2, jArr);
                        }
                        o52Var3 = (o52) ce0Var.apply(o52Var2);
                        if (o52Var3 == null) {
                            arrayList3 = arrayList;
                        } else {
                            jh.a aVarB16 = aVar3.b(1835297121);
                            aVarB16.getClass();
                            jh.a aVarB17 = aVarB16.b(1835626086);
                            aVarB17.getClass();
                            jh.a aVarB18 = aVarB17.b(1937007212);
                            aVarB18.getClass();
                            u52 u52VarA3 = a(o52Var3, aVarB18, fe0Var);
                            arrayList3 = arrayList;
                            arrayList3.add(u52VarA3);
                        }
                    } else {
                        aVar3 = aVar2;
                    }
                    jArr = null;
                    jArr2 = null;
                    if (gc0Var == null) {
                        o52Var2 = new o52(iH13, i11, ((Long) pair.first).longValue(), j3, jA, gc0Var, i8, p52VarArr2, i9, jArr2, jArr);
                    }
                    o52Var3 = (o52) ce0Var.apply(o52Var2);
                    if (o52Var3 == null) {
                        arrayList3 = arrayList;
                    } else {
                        jh.a aVarB19 = aVar3.b(1835297121);
                        aVarB19.getClass();
                        jh.a aVarB110 = aVarB19.b(1835626086);
                        aVarB110.getClass();
                        jh.a aVarB111 = aVarB110.b(1937007212);
                        aVarB111.getClass();
                        u52 u52VarA4 = a(o52Var3, aVarB111, fe0Var);
                        arrayList3 = arrayList;
                        arrayList3.add(u52VarA4);
                    }
                }
                o52Var2 = o52Var;
                o52Var3 = (o52) ce0Var.apply(o52Var2);
                if (o52Var3 == null) {
                    arrayList3 = arrayList;
                } else {
                    jh.a aVarB112 = aVar3.b(1835297121);
                    aVarB112.getClass();
                    jh.a aVarB113 = aVarB112.b(1835626086);
                    aVarB113.getClass();
                    jh.a aVarB114 = aVarB113.b(1937007212);
                    aVarB114.getClass();
                    u52 u52VarA5 = a(o52Var3, aVarB114, fe0Var);
                    arrayList3 = arrayList;
                    arrayList3.add(u52VarA5);
                }
            }
            i37 = i10 + 1;
        }
        return arrayList3;
    }
}
