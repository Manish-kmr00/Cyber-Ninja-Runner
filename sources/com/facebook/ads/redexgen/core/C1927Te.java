package com.facebook.ads.redexgen.core;

import android.net.Uri;
import android.util.Pair;
import android.util.SparseArray;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.google.android.exoplayer2.DrmInitData;
import com.google.android.exoplayer2.extractor.metadata.emsg.EventMessage;
import com.google.common.base.Ascii;
import com.vungle.ads.internal.protos.Sdk;
import io.bidmachine.protobuf.EventTypeExtended;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.io.encoding.Base64;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Te, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1927Te implements UK {
    public static byte[] A0e;
    public static String[] A0f = {"EevHyolFte0G1EnkLnRUTQFXdN8MLfPk", "QSPEwTNQ0RmhXbXcGdXVvlgO7iKYXnEx", "GidA194vrhacl8sOIXGNDds2Wjdh2DeM", "UW6wZdrFtIj6d44xYDZqFY4bxNAZwAPZ", "8Te35dNd8QvizhpjzChSxM3FvpaFw4ja", "1LGGtWGhgY1LpVrEZjBFoB", "4tmgHwu9atO3YgkZqxtGVdro9ECoMU5s", "mi"};
    public static final UO A0g;
    public static final ZM A0h;
    public static final byte[] A0i;
    public int A00;
    public int A01;
    public int A02;
    public int A03;
    public int A04;
    public int A05;
    public int A06;
    public long A07;
    public long A08;
    public long A09;
    public long A0A;
    public long A0B;
    public long A0C;
    public SparseArray<WI> A0D;
    public UL A0E;
    public WI A0F;
    public C2447fq A0G;
    public boolean A0H;
    public boolean A0I;
    public boolean A0J;
    public InterfaceC1957Uo[] A0K;
    public InterfaceC1957Uo[] A0L;
    public final int A0M;
    public final DrmInitData A0N;
    public final InterfaceC1957Uo A0O;
    public final VB A0P;
    public final WZ A0Q;
    public final C2447fq A0R;
    public final C2447fq A0S;
    public final C2447fq A0T;
    public final C2447fq A0U;
    public final C2447fq A0V;
    public final C2461g4 A0W;
    public final ArrayDeque<C1934Tm> A0X;
    public final ArrayDeque<WH> A0Y;
    public final List<ZM> A0Z;
    public final boolean A0a;
    public final boolean A0b;
    public final boolean A0c;
    public final byte[] A0d;

    /* JADX WARN: Code duplicated, block: B:18:0x0083  */
    /* JADX WARN: Code duplicated, block: B:36:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:73:0x0170  */
    /* JADX WARN: Code duplicated, block: B:83:0x01a6  */
    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static int A00(WI wi, int i, long j, int i2, C2447fq c2447fq, int i3) {
        boolean z;
        boolean z2;
        int iA0C;
        int i4 = i3;
        long j2 = j;
        c2447fq.A0f(8);
        int iA02 = W5.A02(c2447fq.A0C());
        WZ wz = wi.A05;
        C1994Wb c1994Wb = wi.A07;
        WC wc = c1994Wb.A06;
        c1994Wb.A0C[i] = c2447fq.A0L();
        c1994Wb.A0E[i] = c1994Wb.A04;
        if ((iA02 & 1) != 0) {
            long[] jArr = c1994Wb.A0E;
            long jA0C = jArr[i] + ((long) c2447fq.A0C());
            String[] strArr = A0f;
            if (strArr[6].charAt(21) != strArr[2].charAt(21)) {
                throw new RuntimeException();
            }
            A0f[1] = "TjSeAKI8wpq4Y3GUZTF2UTHLQ1EjUgJO";
            jArr[i] = jA0C;
        }
        boolean z3 = (iA02 & 4) != 0;
        int iA0L = wc.A01;
        if (z3) {
            iA0L = c2447fq.A0L();
        }
        int i5 = iA02 & 256;
        String[] strArr2 = A0f;
        if (strArr2[6].charAt(21) == strArr2[2].charAt(21)) {
            String[] strArr3 = A0f;
            strArr3[0] = "I4X2hWhFJw4jtEg1SvTPkJZmjnWvji4V";
            strArr3[3] = "7y2FErUF1vMRismW8iY76YBlm4AP6Tzq";
            if (i5 != 0) {
                z = true;
            } else {
                z = false;
            }
        } else if (i5 != 0) {
            z = true;
        } else {
            z = false;
        }
        boolean z4 = (iA02 & 512) != 0;
        boolean z5 = (iA02 & 1024) != 0;
        boolean z6 = (iA02 & 2048) != 0;
        long j3 = 0;
        if (wz.A08 != null && wz.A08.length == 1) {
            long[] jArr2 = wz.A08;
            if (A0f[4].charAt(11) == 'i') {
                String[] strArr4 = A0f;
                strArr4[0] = "QGC51g3FZ7WtAv4AtQbKocZiI3uGkVlk";
                strArr4[3] = "NPYewuQFsQur5JZHqAiwgU8EqYe7I5lH";
                if (jArr2[0] == 0) {
                    j3 = wz.A09[0];
                }
            } else if (jArr2[0] == 0) {
                j3 = wz.A09[0];
            }
        }
        int[] iArr = c1994Wb.A0B;
        long[] jArr3 = c1994Wb.A0D;
        boolean[] zArr = c1994Wb.A0G;
        if (wz.A03 == 2) {
            int i6 = i2 & 1;
            String[] strArr5 = A0f;
            if (strArr5[5].length() == strArr5[7].length()) {
                throw new RuntimeException();
            }
            A0f[4] = "EoifhK2GBM2iekIExd3q7yCnDDjd4ChM";
            if (i6 != 0) {
                z2 = true;
            } else {
                z2 = false;
            }
        } else {
            z2 = false;
        }
        int i7 = i4 + c1994Wb.A0C[i];
        long j4 = wz.A06;
        if (i > 0) {
            j2 = c1994Wb.A05;
        }
        while (i4 < i7) {
            int iA0L2 = z ? c2447fq.A0L() : wc.A00;
            int iA0L3 = z4 ? c2447fq.A0L() : wc.A03;
            if (i4 != 0 || !z3) {
                iA0C = z5 ? c2447fq.A0C() : wc.A01;
            } else if (A0f[1].charAt(24) != 'o') {
                String[] strArr6 = A0f;
                strArr6[6] = "GjRt1B4h3bcl7G6qh4e2md5WA5l5W1dz";
                strArr6[2] = "uvy21N87lfR6r3wtAneiJdd4eVNlZpBO";
                iA0C = iA0L;
            } else {
                String[] strArr7 = A0f;
                strArr7[6] = "WIjXQEFSqIEu9EQz29kB5dDclRfmrWc8";
                strArr7[2] = "kJc5Q6piWWIMR4q1qkFp6dAf41HWAzZJ";
                iA0C = iA0L;
            }
            jArr3[i4] = AbstractC2471gE.A0U((((long) (z6 ? c2447fq.A0C() : 0)) + j2) - j3, 1000000L, j4);
            zArr[i4] = ((iA0C >> 16) & 1) == 0 && (!z2 || i4 == 0);
            iArr[i4] = iA0L3;
            j2 += (long) iA0L2;
            i4++;
        }
        c1994Wb.A05 = j2;
        return i7;
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static Pair<Long, WY> A04(C2447fq c2447fq, long j) throws Q6 {
        long jA0R;
        long jA0R2;
        c2447fq.A0f(8);
        int iA03 = W5.A03(c2447fq.A0C());
        c2447fq.A0g(4);
        long jA0Q = c2447fq.A0Q();
        if (iA03 == 0) {
            jA0R = c2447fq.A0Q();
            jA0R2 = j + c2447fq.A0Q();
            String[] strArr = A0f;
            if (strArr[0].charAt(7) != strArr[3].charAt(7)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0f;
            strArr2[5] = "S5A8WZMRBjOOkYATnh9vwU";
            strArr2[7] = "px";
        } else {
            jA0R = c2447fq.A0R();
            jA0R2 = j + c2447fq.A0R();
        }
        long jA0U = AbstractC2471gE.A0U(jA0R, 1000000L, jA0Q);
        c2447fq.A0g(2);
        int iA0M = c2447fq.A0M();
        int[] iArr = new int[iA0M];
        long[] jArr = new long[iA0M];
        long[] jArr2 = new long[iA0M];
        long[] jArr3 = new long[iA0M];
        long jA0U2 = jA0U;
        for (int i = 0; i < iA0M; i++) {
            int iA0C = c2447fq.A0C();
            if ((Integer.MIN_VALUE & iA0C) != 0) {
                throw new Q6(A0B(634, 28, 30));
            }
            long jA0Q2 = c2447fq.A0Q();
            iArr[i] = Integer.MAX_VALUE & iA0C;
            jArr[i] = jA0R2;
            jArr3[i] = jA0U2;
            jA0R += jA0Q2;
            jA0U2 = AbstractC2471gE.A0U(jA0R, 1000000L, jA0Q);
            jArr2[i] = jA0U2 - jArr3[i];
            c2447fq.A0g(4);
            jA0R2 += (long) iArr[i];
        }
        return Pair.create(Long.valueOf(jA0U), new WY(iArr, jArr, jArr2, jArr3));
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static WI A09(C2447fq c2447fq, SparseArray<WI> sparseArray, boolean z) {
        c2447fq.A0f(8);
        int iA02 = W5.A02(c2447fq.A0C());
        WI wiA08 = A08(sparseArray, c2447fq.A0C(), z);
        if (wiA08 == null) {
            return null;
        }
        if ((iA02 & 1) != 0) {
            long jA0R = c2447fq.A0R();
            wiA08.A07.A04 = jA0R;
            wiA08.A07.A03 = jA0R;
        }
        WC wc = wiA08.A04;
        int iA0L = (iA02 & 2) != 0 ? c2447fq.A0L() - 1 : wc.A02;
        int iA0L2 = (iA02 & 8) != 0 ? c2447fq.A0L() : wc.A00;
        int i = iA02 & 16;
        if (A0f[1].charAt(24) == 'o') {
            throw new RuntimeException();
        }
        String[] strArr = A0f;
        strArr[6] = "qnuhCGCLhtAQyxSDy77Bkdg9YX36L1iE";
        strArr[2] = "fcfyB5Wa85KGu22CFrMwLdnjoHe57wIB";
        wiA08.A07.A06 = new WC(iA0L, iA0L2, i != 0 ? c2447fq.A0L() : wc.A03, (iA02 & 32) != 0 ? c2447fq.A0L() : wc.A01);
        return wiA08;
    }

    public static String A0B(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0e, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 82);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A0E() {
        byte[] bArr = {-25, -37, -89, -38, -43, -45, -122, -39, -49, -32, -53, -122, -46, -53, -39, -39, -122, -38, -50, -57, -44, -122, -50, -53, -57, -54, -53, -40, -122, -46, -53, -44, -51, -38, -50, -122, -114, -37, -44, -39, -37, -42, -42, -43, -40, -38, -53, -54, -113, -108, 8, 49, 55, 53, 60, -29, 38, 50, 56, 49, 55, -29, 44, 49, -29, 54, 37, 42, 51, -29, -28, 0, -29, -12, -29, -21, 56, 49, 54, 56, 51, 51, 50, 53, 55, 40, 39, -20, -15, -42, -1, 5, 3, 10, -79, -12, 0, 6, -1, 5, -79, -6, -1, -79, 4, -8, 1, -11, -79, -78, -50, -79, -62, -79, -71, 6, -1, 4, 6, 1, 1, 0, 3, 5, -10, -11, -70, -65, 19, 63, 46, 52, 58, 50, 59, 65, 50, 49, Ascii.SUB, Base64.padSymbol, 1, Ascii.DC2, 69, 65, 63, 46, 48, 65, 60, 63, -22, 8, Ascii.SI, Ascii.DLE, 19, 10, Ascii.SI, 8, -63, Ascii.SI, 6, 8, 2, Ascii.NAK, 10, Ascii.ETB, 6, -63, Ascii.DLE, 7, 7, Ascii.DC4, 6, Ascii.NAK, -63, Ascii.NAK, Ascii.DLE, -63, Ascii.DC4, 2, Ascii.SO, 17, Ascii.CR, 6, -63, 5, 2, Ascii.NAK, 2, -49, -25, Ascii.FF, Ascii.DC4, -1, 10, 7, 2, -66, -20, -33, -22, -66, 10, 3, Ascii.FF, 5, Ascii.DC2, 6, -31, -6, -10, -5, -75, -10, 9, 4, 2, -75, -7, -6, -5, -2, 3, -6, 8, -75, -6, Ascii.CR, 9, -6, 3, -7, -6, -7, -75, -10, 9, 4, 2, -75, 8, -2, Ascii.SI, -6, -75, -67, 10, 3, 8, 10, 5, 5, 4, 7, 9, -6, -7, -66, -61, -57, -32, -36, -31, -101, -36, -17, -22, -24, -101, -14, -28, -17, -29, -101, -25, -32, -23, -30, -17, -29, -101, -71, -101, -83, -84, -81, -78, -81, -77, -82, -79, -81, -78, -101, -93, -16, -23, -18, -16, -21, -21, -22, -19, -17, -32, -33, -92, -87, -12, Ascii.CR, Ascii.SYN, Ascii.SI, Ascii.FS, Ascii.DLE, -56, Ascii.NAK, 17, Ascii.ESC, Ascii.NAK, 9, Ascii.FS, Ascii.VT, Ascii.DLE, -30, -56, -56, -33, -33, -20, -34, -19, -103, -19, -24, -103, -34, -25, -36, -21, -14, -23, -19, -30, -24, -25, -103, -35, -38, -19, -38, -103, -16, -38, -20, -103, -25, -34, -32, -38, -19, -30, -17, -34, -89, -80, -57, -57, -44, -58, -43, -127, -43, -48, -127, -58, -49, -59, -127, -48, -57, -127, -50, -59, -62, -43, -127, -40, -62, -44, -127, -49, -58, -56, -62, -43, -54, -41, -58, -113, -72, -33, -50, -37, -37, -46, -51, -46, -41, -48, -119, -67, -37, -54, -52, -44, -82, -41, -52, -37, -30, -39, -35, -46, -40, -41, -85, -40, -31, -119, -39, -54, -37, -54, -42, -50, -35, -50, -37, -36, -119, -46, -36, -119, -34, -41, -36, -34, -39, -39, -40, -37, -35, -50, -51, -105, -58, -34, -36, -29, -29, -40, -41, -109, -29, -26, -26, -37, -109, -44, -25, -30, -32, -109, -101, -39, -44, -36, -33, -40, -41, -109, -25, -30, -109, -40, -21, -25, -27, -44, -42, -25, -109, -24, -24, -36, -41, -100, -5, 19, 17, Ascii.CAN, Ascii.CAN, 17, Ascii.SYN, Ascii.SI, -56, 9, Ascii.FS, Ascii.ETB, Ascii.NAK, -56, Ascii.US, 17, Ascii.FS, Ascii.DLE, -56, Ascii.DC4, Ascii.CR, Ascii.SYN, Ascii.SI, Ascii.FS, Ascii.DLE, -56, -26, -56, -38, -39, -36, -33, -36, -32, -37, -34, -36, -33, -56, -48, Ascii.GS, Ascii.SYN, Ascii.ESC, Ascii.GS, Ascii.CAN, Ascii.CAN, Ascii.ETB, Ascii.SUB, Ascii.FS, Ascii.CR, Ascii.FF, -47, -42, -50, -26, -28, -21, -21, -28, -23, -30, -101, -16, -23, -18, -16, -21, -21, -22, -19, -17, -32, -33, -101, -32, -24, -18, -30, -101, -15, -32, -19, -18, -28, -22, -23, -75, -101, -87, -62, -71, -52, -60, -71, -73, -56, -71, -72, 116, -63, -61, -61, -54, 116, -74, -61, -52, -126, -1, Ascii.CAN, Ascii.SI, 34, Ascii.SUB, Ascii.SI, Ascii.CR, Ascii.RS, Ascii.SI, Ascii.SO, -54, Ascii.GS, Ascii.VT, 19, Ascii.EM, -54, Ascii.SI, Ascii.CAN, Ascii.RS, Ascii.FS, 35, -54, Ascii.CR, Ascii.EM, Ascii.US, Ascii.CAN, Ascii.RS, -28, -54, -59, -34, -40, -47, -34, -44, -36, -43, -44, -112, -39, -34, -44, -39, -30, -43, -45, -28, -112, -30, -43, -42, -43, -30, -43, -34, -45, -43, 19, Ascii.RS, 47, 38, Ascii.RS, Ascii.US, 41, 34, -35, 41, 34, 43, 36, 49, 37, -35, 33, 34, 48, 32, 47, 38, 45, 49, 38, 44, 43, -35, 38, 43, -35, 48, 36, 45, 33, -35, 35, 44, 50, 43, 33, -35, -27, 50, 43, 48, 50, 45, 45, 44, 47, 49, 34, 33, -26, -33, -18, -18, -22, -25, -31, -33, -14, -25, -19, -20, -83, -10, -85, -29, -21, -15, -27, 34, 49, 49, 45, 42, 36, 34, 53, 42, 48, 47, -16, 57, -18, 46, 49, -11, -18, 55, 53, 53, Ascii.RS, 17, Ascii.FF, Ascii.CR, Ascii.ETB, -41, Ascii.DLE, Ascii.CR, Ascii.RS, Ascii.VT, Ascii.GS, Ascii.DLE, Ascii.VT, Ascii.FF, Ascii.SYN, -42, Ascii.DC4, Ascii.ETB, -37};
        String[] strArr = A0f;
        if (strArr[5].length() == strArr[7].length()) {
            throw new RuntimeException();
        }
        A0f[1] = "XzlsT9WICyFi4v7F4txdI5GHDh9gQrz1";
        A0e = bArr;
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    private void A0L(C1934Tm c1934Tm) throws Q6 {
        AbstractC2388es.A0A(this.A0Q == null, A0B(585, 20, 2));
        DrmInitData drmInitDataA05 = A05(c1934Tm.A02);
        C1934Tm c1934Tm2 = (C1934Tm) AbstractC2388es.A01(c1934Tm.A02(1836475768));
        SparseArray<WC> sparseArray = new SparseArray<>();
        long jA01 = -9223372036854775807L;
        int size = c1934Tm2.A02.size();
        for (int i = 0; i < size; i++) {
            C1933Tl c1933Tl = c1934Tm2.A02.get(i);
            if (((W5) c1933Tl).A00 == 1953654136) {
                Pair<Integer, WC> pairA03 = A03(c1933Tl.A00);
                sparseArray.put(((Integer) pairA03.first).intValue(), (WC) pairA03.second);
            } else if (((W5) c1933Tl).A00 == 1835362404) {
                jA01 = A01(c1933Tl.A00);
            }
        }
        SparseArray sparseArray2 = new SparseArray();
        int size2 = c1934Tm.A01.size();
        for (int i2 = 0; i2 < size2; i2++) {
            C1934Tm c1934Tm3 = c1934Tm.A01.get(i2);
            if (((W5) c1934Tm3).A00 == 1953653099) {
                WZ wzA0A = A0A(WB.A0J(c1934Tm3, c1934Tm.A03(1836476516), jA01, drmInitDataA05, (this.A0M & 16) != 0, false));
                if (wzA0A != null) {
                    sparseArray2.put(wzA0A.A00, wzA0A);
                }
            }
        }
        int size3 = sparseArray2.size();
        if (this.A0D.size() != 0) {
            AbstractC2388es.A08(this.A0D.size() == size3);
            for (int i3 = 0; i3 < size3; i3++) {
                WZ wz = (WZ) sparseArray2.valueAt(i3);
                this.A0D.get(wz.A00).A08(wz, A06(sparseArray, wz.A00));
            }
            return;
        }
        for (int i4 = 0; i4 < size3; i4++) {
            WZ wz2 = (WZ) sparseArray2.valueAt(i4);
            WI wi = new WI(this.A0E.AJX(i4, wz2.A03));
            wi.A08(wz2, A06(sparseArray, wz2.A00));
            this.A0D.put(wz2.A00, wi);
            this.A08 = Math.max(this.A08, wz2.A04);
        }
        A0D();
        this.A0E.A6E();
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static void A0N(C1934Tm c1934Tm, SparseArray<WI> sparseArray, int i, byte[] bArr, boolean z) throws Q6 {
        WI wiA09 = A09(c1934Tm.A03(1952868452).A00, sparseArray, z);
        if (wiA09 == null) {
            return;
        }
        C1994Wb c1994Wb = wiA09.A07;
        long jA02 = c1994Wb.A05;
        wiA09.A05();
        if (c1934Tm.A03(1952867444) != null && (i & 2) == 0) {
            jA02 = A02(c1934Tm.A03(1952867444).A00);
        }
        A0O(c1934Tm, wiA09, jA02, i);
        C1993Wa c1993WaA00 = wiA09.A05.A00(c1994Wb.A06.A02);
        C1933Tl c1933TlA03 = c1934Tm.A03(1935763834);
        if (c1933TlA03 != null) {
            C2447fq c2447fq = c1933TlA03.A00;
            String[] strArr = A0f;
            if (strArr[0].charAt(7) != strArr[3].charAt(7)) {
                throw new RuntimeException();
            }
            A0f[1] = "Sr9pWAk7BtPVrR8rbkWUazKj3QSNMXGS";
            A0Q(c1993WaA00, c2447fq, c1994Wb);
        }
        C1933Tl c1933TlA04 = c1934Tm.A03(1935763823);
        if (c1933TlA04 != null) {
            A0T(c1933TlA04.A00, c1994Wb);
        }
        C1933Tl c1933TlA05 = c1934Tm.A03(1936027235);
        if (c1933TlA05 != null) {
            A0U(c1933TlA05.A00, c1994Wb);
        }
        C1933Tl c1933TlA06 = c1934Tm.A03(1935828848);
        C1933Tl c1933TlA07 = c1934Tm.A03(1936158820);
        if (c1933TlA06 != null && c1933TlA07 != null) {
            A0W(c1933TlA06.A00, c1933TlA07.A00, c1993WaA00 != null ? c1993WaA00.A02 : null, c1994Wb);
        }
        int size = c1934Tm.A02.size();
        for (int i2 = 0; i2 < size; i2++) {
            C1933Tl c1933Tl = c1934Tm.A02.get(i2);
            if (((W5) c1933Tl).A00 == 1970628964) {
                A0V(c1933Tl.A00, c1994Wb, bArr);
            }
        }
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static void A0Q(C1993Wa c1993Wa, C2447fq c2447fq, C1994Wb c1994Wb) throws Q6 {
        int i = c1993Wa.A00;
        c2447fq.A0f(8);
        if ((W5.A02(c2447fq.A0C()) & 1) == 1) {
            c2447fq.A0g(8);
        }
        int iA0I = c2447fq.A0I();
        int iA0L = c2447fq.A0L();
        if (iA0L != c1994Wb.A00) {
            throw new Q6(A0B(308, 17, 86) + iA0L + A0B(0, 2, 105) + c1994Wb.A00);
        }
        int i2 = 0;
        if (iA0I == 0) {
            boolean[] zArr = c1994Wb.A0F;
            for (int i3 = 0; i3 < iA0L; i3++) {
                int iA0I2 = c2447fq.A0I();
                i2 += iA0I2;
                zArr[i3] = iA0I2 > i;
            }
        } else {
            boolean z = iA0I > i;
            i2 = 0 + (iA0I * iA0L);
            boolean[] zArr2 = c1994Wb.A0F;
            String[] strArr = A0f;
            if (strArr[6].charAt(21) != strArr[2].charAt(21)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0f;
            strArr2[6] = "PnVCLJYBlE9bOnV602QoUdMJp4Mo7QJx";
            strArr2[2] = "sYNUhpThMzT2vK5VQCJjpdIvHA5Cw7Wa";
            Arrays.fill(zArr2, 0, iA0L, z);
        }
        c1994Wb.A02(i2);
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    private void A0S(C2447fq c2447fq, Uri uri) {
        String str;
        String str2;
        long jA05;
        long jA0U;
        long jA0Q;
        if (this.A0L == null || this.A0L.length == 0) {
            return;
        }
        c2447fq.A0f(8);
        int iA03 = W5.A03(c2447fq.A0C());
        long jA0U2 = -9223372036854775807L;
        switch (iA03) {
            case 0:
                str = (String) AbstractC2388es.A01(c2447fq.A0U());
                str2 = (String) AbstractC2388es.A01(c2447fq.A0U());
                long jA0Q2 = c2447fq.A0Q();
                jA0U2 = AbstractC2471gE.A0U(c2447fq.A0Q(), 1000000L, jA0Q2);
                jA05 = this.A0C != -9223372036854775807L ? this.A0C + jA0U2 : -9223372036854775807L;
                jA0U = AbstractC2471gE.A0U(c2447fq.A0Q(), 1000L, jA0Q2);
                jA0Q = c2447fq.A0Q();
                break;
            case 1:
                long jA0Q3 = c2447fq.A0Q();
                jA05 = AbstractC2471gE.A0U(c2447fq.A0R(), 1000000L, jA0Q3);
                jA0U = AbstractC2471gE.A0U(c2447fq.A0Q(), 1000L, jA0Q3);
                jA0Q = c2447fq.A0Q();
                str = (String) AbstractC2388es.A01(c2447fq.A0U());
                str2 = (String) AbstractC2388es.A01(c2447fq.A0U());
                break;
            default:
                AbstractC2432fb.A07(A0B(128, 22, Sdk.SDKError.Reason.INVALID_RI_ENDPOINT_VALUE), A0B(550, 35, 41) + iA03);
                return;
        }
        byte[] bArr = new byte[c2447fq.A07()];
        c2447fq.A0k(bArr, 0, c2447fq.A07());
        int i = 0;
        C2447fq c2447fq2 = new C2447fq(this.A0P.A01(new EventMessage(str, str2, jA0U, jA0Q, bArr)));
        int iA07 = c2447fq2.A07();
        InterfaceC1957Uo[] interfaceC1957UoArr = this.A0L;
        int length = interfaceC1957UoArr.length;
        int i2 = 0;
        while (i2 < length) {
            InterfaceC1957Uo interfaceC1957Uo = interfaceC1957UoArr[i2];
            c2447fq2.A0f(i);
            interfaceC1957Uo.AJk(uri);
            interfaceC1957Uo.AHx(c2447fq2, iA07);
            i2++;
            i = 0;
        }
        if (jA05 == -9223372036854775807L) {
            this.A0Y.addLast(new WH(jA0U2, iA07));
            this.A03 += iA07;
            return;
        }
        if (this.A0W != null) {
            jA05 = this.A0W.A05(jA05);
        }
        if (this.A0b && this.A0A != -9223372036854775807L) {
            jA05 = this.A0A;
        }
        for (InterfaceC1957Uo interfaceC1957Uo2 : this.A0L) {
            interfaceC1957Uo2.AI0(jA05, 1, iA07, 0, null);
        }
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static void A0W(C2447fq c2447fq, C2447fq c2447fq2, String str, C1994Wb c1994Wb) throws Q6 {
        c2447fq.A0f(8);
        int iA0C = c2447fq.A0C();
        if (c2447fq.A0C() != 1936025959) {
            return;
        }
        if (W5.A03(iA0C) == 1) {
            c2447fq.A0g(4);
        }
        if (c2447fq.A0C() != 1) {
            throw new Q6(A0B(50, 39, 113));
        }
        c2447fq2.A0f(8);
        int iA0C2 = c2447fq2.A0C();
        if (A0f[1].charAt(24) == 'o') {
            throw new RuntimeException();
        }
        String[] strArr = A0f;
        strArr[5] = "t417Cca0I6YObHWsDP73PC";
        strArr[7] = "F8";
        if (c2447fq2.A0C() != 1936025959) {
            return;
        }
        int iA03 = W5.A03(iA0C2);
        if (iA03 != 1) {
            String[] strArr2 = A0f;
            if (strArr2[6].charAt(21) != strArr2[2].charAt(21)) {
                throw new RuntimeException();
            }
            A0f[4] = "SSmN8G5czCwiEyEBLCEM8L84Zx7CwlW0";
            if (iA03 >= 2) {
                c2447fq2.A0g(4);
            }
        } else if (c2447fq2.A0Q() == 0) {
            throw new Q6(A0B(EventTypeExtended.EVENT_TYPE_EXTENDED_SK_OVERLAY_PRESENTING_VALUE, 55, 107));
        }
        if (c2447fq2.A0Q() != 1) {
            throw new Q6(A0B(89, 39, 63));
        }
        c2447fq2.A0g(1);
        int iA0I = c2447fq2.A0I();
        int i = (iA0I & 240) >> 4;
        int i2 = iA0I & 15;
        boolean z = c2447fq2.A0I() == 1;
        if (z) {
            int iA0I2 = c2447fq2.A0I();
            byte[] bArr = new byte[16];
            c2447fq2.A0k(bArr, 0, bArr.length);
            byte[] bArr2 = null;
            if (iA0I2 == 0) {
                int iA0I3 = c2447fq2.A0I();
                bArr2 = new byte[iA0I3];
                c2447fq2.A0k(bArr2, 0, iA0I3);
            }
            c1994Wb.A08 = true;
            c1994Wb.A07 = new C1993Wa(z, str, iA0I2, bArr, i, i2, bArr2);
        }
    }

    static {
        A0E();
        A0g = new UO() { // from class: com.facebook.ads.redexgen.X.Ti
            @Override // com.facebook.ads.redexgen.core.UO
            public final UK[] A5D() {
                return C1927Te.A0b();
            }

            @Override // com.facebook.ads.redexgen.core.UO
            public final /* synthetic */ UK[] A5E(Uri uri, Map map) {
                return UN.A01(this, uri, map);
            }
        };
        A0i = new byte[]{-94, 57, 79, 82, 90, -101, 79, Ascii.DC4, -94, 68, 108, 66, 124, 100, -115, -12};
        A0h = new P5().A11(A0B(717, 18, 44)).A14();
    }

    public C1927Te() {
        this(0);
    }

    public C1927Te(int i) {
        this(i, null);
    }

    public C1927Te(int i, C2461g4 c2461g4) {
        this(i, c2461g4, null, null);
    }

    public C1927Te(int i, C2461g4 c2461g4, WZ wz, DrmInitData drmInitData) {
        this(i, c2461g4, wz, drmInitData, Collections.emptyList());
    }

    public C1927Te(int i, C2461g4 c2461g4, WZ wz, DrmInitData drmInitData, List<ZM> list) {
        this(i, c2461g4, wz, drmInitData, list, null, false, false, false);
    }

    public C1927Te(int i, C2461g4 c2461g4, WZ wz, DrmInitData drmInitData, List<ZM> list, InterfaceC1957Uo interfaceC1957Uo, boolean z, boolean z2, boolean z3) {
        this.A0A = -9223372036854775807L;
        this.A0M = (wz != null ? 8 : 0) | i;
        this.A0W = c2461g4;
        this.A0Q = wz;
        this.A0N = drmInitData;
        this.A0Z = Collections.unmodifiableList(list);
        this.A0O = interfaceC1957Uo;
        this.A0c = z;
        this.A0b = z2;
        this.A0a = z3;
        this.A0P = new VB();
        this.A0R = new C2447fq(16);
        this.A0U = new C2447fq(AbstractC1949Ud.A03);
        this.A0T = new C2447fq(5);
        this.A0S = new C2447fq();
        this.A0d = new byte[16];
        this.A0V = new C2447fq(this.A0d);
        this.A0X = new ArrayDeque<>();
        this.A0Y = new ArrayDeque<>();
        this.A0D = new SparseArray<>();
        this.A08 = -9223372036854775807L;
        this.A0B = -9223372036854775807L;
        this.A0C = -9223372036854775807L;
        A0C();
    }

    public static long A01(C2447fq c2447fq) {
        c2447fq.A0f(8);
        int fullAtom = c2447fq.A0C();
        return W5.A03(fullAtom) == 0 ? c2447fq.A0Q() : c2447fq.A0R();
    }

    public static long A02(C2447fq c2447fq) {
        c2447fq.A0f(8);
        int fullAtom = c2447fq.A0C();
        int version = W5.A03(fullAtom);
        return version == 1 ? c2447fq.A0R() : c2447fq.A0Q();
    }

    public static Pair<Integer, WC> A03(C2447fq c2447fq) {
        c2447fq.A0f(12);
        int defaultSampleDescriptionIndex = c2447fq.A0C();
        int trackId = c2447fq.A0L();
        int defaultSampleFlags = c2447fq.A0L();
        int defaultSampleSize = c2447fq.A0L();
        int defaultSampleDuration = c2447fq.A0C();
        return Pair.create(Integer.valueOf(defaultSampleDescriptionIndex), new WC(trackId - 1, defaultSampleFlags, defaultSampleSize, defaultSampleDuration));
    }

    public static DrmInitData A05(List<C1933Tl> list) {
        ArrayList arrayList = null;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            C1933Tl c1933Tl = list.get(i);
            int leafChildrenSize = ((W5) c1933Tl).A00;
            if (leafChildrenSize == 1886614376) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                byte[] bArr = c1933Tl.A00.A00;
                UUID uuidA02 = WS.A02(bArr);
                if (uuidA02 == null) {
                    AbstractC2432fb.A07(A0B(128, 22, Sdk.SDKError.Reason.INVALID_RI_ENDPOINT_VALUE), A0B(455, 42, 33));
                } else {
                    arrayList.add(new DrmInitData.SchemeData(uuidA02, A0B(766, 9, 85), bArr));
                }
            }
        }
        if (arrayList == null) {
            return null;
        }
        return new DrmInitData(arrayList);
    }

    private WC A06(SparseArray<WC> sparseArray, int i) {
        if (sparseArray.size() == 1) {
            WC wcValueAt = sparseArray.valueAt(0);
            String[] strArr = A0f;
            if (strArr[0].charAt(7) != strArr[3].charAt(7)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0f;
            strArr2[0] = "E9JlvB7FFYm2IdqIzB2u3etF1ohyBnc5";
            strArr2[3] = "HfyCbzKFUlOYvgUmzmPlUBmF6PSFOMgS";
            return wcValueAt;
        }
        return (WC) AbstractC2388es.A01(sparseArray.get(i));
    }

    public static WI A07(SparseArray<WI> sparseArray) {
        WI wi = null;
        long j = Long.MAX_VALUE;
        int size = sparseArray.size();
        for (int i = 0; i < size; i++) {
            WI wiValueAt = sparseArray.valueAt(i);
            if (wiValueAt.A02 != wiValueAt.A07.A01) {
                long nextTrackRunOffset = wiValueAt.A07.A0E[wiValueAt.A02];
                if (nextTrackRunOffset < j) {
                    wi = wiValueAt;
                    j = nextTrackRunOffset;
                }
            }
        }
        return wi;
    }

    public static WI A08(SparseArray<WI> sparseArray, int i, boolean z) {
        if (sparseArray.size() == 1 && !z) {
            return sparseArray.valueAt(0);
        }
        return sparseArray.get(i);
    }

    private final WZ A0A(WZ wz) {
        return wz;
    }

    private void A0C() {
        this.A02 = 0;
        this.A00 = 0;
    }

    private void A0D() {
        if (this.A0L == null) {
            this.A0L = new InterfaceC1957Uo[2];
            int i = 0;
            if (this.A0O != null) {
                InterfaceC1957Uo[] interfaceC1957UoArr = this.A0L;
                int i2 = 0 + 1;
                InterfaceC1957Uo interfaceC1957Uo = this.A0O;
                if (A0f[1].charAt(24) == 'o') {
                    throw new RuntimeException();
                }
                String[] strArr = A0f;
                strArr[6] = "Otao9S6B8JKRBRCJelyh5dyuagpQ7cPo";
                strArr[2] = "jKKhzqvWvDTveD7TkbWc2dM4REBiPpyn";
                interfaceC1957UoArr[0] = interfaceC1957Uo;
                i = i2;
            }
            int emsgTrackOutputCount = this.A0M;
            if ((emsgTrackOutputCount & 4) != 0) {
                this.A0L[i] = this.A0E.AJX(this.A0D.size(), 5);
                i++;
            }
            this.A0L = (InterfaceC1957Uo[]) Arrays.copyOf(this.A0L, i);
            for (InterfaceC1957Uo interfaceC1957Uo2 : this.A0L) {
                interfaceC1957Uo2.A6U(A0h);
            }
        }
        if (this.A0K == null) {
            this.A0K = new InterfaceC1957Uo[this.A0Z.size()];
            for (int i3 = 0; i3 < i; i3++) {
                UL ul = this.A0E;
                int i4 = this.A0D.size();
                InterfaceC1957Uo output = ul.AJX(i4 + 1 + i3, 3);
                output.A6U(this.A0Z.get(i3));
                this.A0K[i3] = output;
            }
        }
    }

    private void A0F(long j) {
        while (!this.A0Y.isEmpty()) {
            WH whRemoveFirst = this.A0Y.removeFirst();
            this.A03 -= whRemoveFirst.A00;
            long jA05 = j + whRemoveFirst.A01;
            if (this.A0W != null) {
                jA05 = this.A0W.A05(jA05);
            }
            for (InterfaceC1957Uo interfaceC1957Uo : this.A0L) {
                int i = whRemoveFirst.A00;
                int i2 = this.A03;
                String[] strArr = A0f;
                if (strArr[0].charAt(7) != strArr[3].charAt(7)) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A0f;
                strArr2[5] = "fQbfxQG6SMNXg0FhrXnOaI";
                strArr2[7] = "iA";
                interfaceC1957Uo.AI0(jA05, 1, i, i2, null);
            }
        }
    }

    private void A0G(long j) throws Q6 {
        while (true) {
            boolean zIsEmpty = this.A0X.isEmpty();
            if (A0f[1].charAt(24) == 'o') {
                throw new RuntimeException();
            }
            String[] strArr = A0f;
            strArr[5] = "rtOhTF8yR1NjovFJo2QA4K";
            strArr[7] = "sO";
            if (!zIsEmpty) {
                ArrayDeque<C1934Tm> arrayDeque = this.A0X;
                if (A0f[1].charAt(24) == 'o') {
                    throw new RuntimeException();
                }
                String[] strArr2 = A0f;
                strArr2[5] = "DdLoo1PiGVKxZaMTgZaVBC";
                strArr2[7] = "kP";
                if (arrayDeque.peek().A00 == j) {
                    ArrayDeque<C1934Tm> arrayDeque2 = this.A0X;
                    String[] strArr3 = A0f;
                    if (strArr3[6].charAt(21) != strArr3[2].charAt(21)) {
                        String[] strArr4 = A0f;
                        strArr4[5] = "9E3oRw3ViZYggqirEMBsZv";
                        strArr4[7] = "ZB";
                        A0J(arrayDeque2.pop());
                    } else {
                        String[] strArr5 = A0f;
                        strArr5[0] = "kUNHKxqFOXY4spNWtGdM6AEMGUmbTZDs";
                        strArr5[3] = "gxOLplHFDql1O9FrrqUV8k9xLLw9Tw5V";
                        A0J(arrayDeque2.pop());
                    }
                }
            }
            A0C();
            return;
        }
    }

    private void A0H(WJ wj) throws IOException {
        int i = ((int) this.A07) - this.A00;
        if (this.A0G != null) {
            wj.readFully(this.A0G.A00, 8, i);
            A0P(new C1933Tl(this.A01, this.A0G), wj);
        } else {
            wj.AJ9(i);
        }
        A0G(wj.A8d());
    }

    private void A0I(WJ wj) throws IOException {
        WI wiValueAt = null;
        long j = Long.MAX_VALUE;
        int size = this.A0D.size();
        for (int i = 0; i < size; i++) {
            WI nextTrackBundle = this.A0D.valueAt(i);
            C1994Wb c1994Wb = nextTrackBundle.A07;
            if (c1994Wb.A0A && c1994Wb.A03 < j) {
                j = c1994Wb.A03;
                wiValueAt = this.A0D.valueAt(i);
            }
        }
        if (wiValueAt == null) {
            this.A02 = 3;
            return;
        }
        long jA8d = j - wj.A8d();
        String[] strArr = A0f;
        if (strArr[6].charAt(21) != strArr[2].charAt(21)) {
            throw new RuntimeException();
        }
        A0f[1] = "gcAbbdIzqOcdZFeDnXSNnUh1mMsQxJRh";
        int i2 = (int) jA8d;
        if (i2 >= 0) {
            wj.AJ9(i2);
            wiValueAt.A07.A04(wj);
            return;
        }
        throw new Q6(A0B(325, 39, 39));
    }

    private void A0J(C1934Tm c1934Tm) throws Q6 {
        if (((W5) c1934Tm).A00 == 1836019574) {
            A0L(c1934Tm);
        } else if (((W5) c1934Tm).A00 == 1836019558) {
            A0K(c1934Tm);
        } else {
            if (this.A0X.isEmpty()) {
                return;
            }
            this.A0X.peek().A04(c1934Tm);
        }
    }

    private void A0K(C1934Tm c1934Tm) throws Q6 {
        DrmInitData drmInitDataA05;
        A0M(c1934Tm, this.A0D, this.A0M, this.A0d, this.A0c);
        if (this.A0N != null) {
            drmInitDataA05 = null;
        } else {
            List<C1933Tl> list = c1934Tm.A02;
            if (A0f[4].charAt(11) != 'i') {
                drmInitDataA05 = A05(list);
            } else {
                A0f[1] = "zo9UWr2fG4ODubRWxx7SWFCIumY3q8qe";
                drmInitDataA05 = A05(list);
            }
        }
        if (drmInitDataA05 != null) {
            SparseArray<WI> sparseArray = this.A0D;
            if (A0f[4].charAt(11) != 'i') {
                throw new RuntimeException();
            }
            String[] strArr = A0f;
            strArr[0] = "keKdPKZF29nnaWtRQ6tP4lqsuyeIeDxp";
            strArr[3] = "eJnCkFNFZhcQclYTVLGIuQ4G0Pq9G9XC";
            int size = sparseArray.size();
            for (int trackCount = 0; trackCount < size; trackCount++) {
                this.A0D.valueAt(trackCount).A07(drmInitDataA05);
            }
        }
        if (this.A0B != -9223372036854775807L) {
            int size2 = this.A0D.size();
            for (int i = 0; i < size2; i++) {
                this.A0D.valueAt(i).A06(this.A0B);
            }
            this.A0B = -9223372036854775807L;
        }
    }

    public static void A0M(C1934Tm c1934Tm, SparseArray<WI> sparseArray, int i, byte[] bArr, boolean z) throws Q6 {
        int size = c1934Tm.A01.size();
        for (int i2 = 0; i2 < size; i2++) {
            C1934Tm child = c1934Tm.A01.get(i2);
            int i3 = ((W5) child).A00;
            if (i3 == 1953653094) {
                boolean z2 = true;
                if (size <= 1 || !z) {
                    z2 = false;
                }
                A0N(child, sparseArray, i, bArr, z2);
            }
        }
    }

    public static void A0O(C1934Tm c1934Tm, WI wi, long j, int i) {
        int i2 = 0;
        int i3 = 0;
        List<C1933Tl> list = c1934Tm.A02;
        int size = list.size();
        for (int i4 = 0; i4 < size; i4++) {
            C1933Tl c1933Tl = list.get(i4);
            if (((W5) c1933Tl).A00 == 1953658222) {
                C2447fq trunData = c1933Tl.A00;
                trunData.A0f(12);
                int iA0L = trunData.A0L();
                if (iA0L > 0) {
                    i3 += iA0L;
                    i2++;
                }
            }
        }
        wi.A02 = 0;
        wi.A00 = 0;
        wi.A01 = 0;
        wi.A07.A03(i2, i3);
        int i5 = 0;
        int trunStartPosition = 0;
        for (int i6 = 0; i6 < size; i6++) {
            C1933Tl c1933Tl2 = list.get(i6);
            if (((W5) c1933Tl2).A00 == 1953658222) {
                trunStartPosition = A00(wi, i5, j, i, c1933Tl2.A00, trunStartPosition);
                i5++;
            }
        }
    }

    private void A0P(C1933Tl c1933Tl, WJ wj) throws Q6 {
        Uri uriA9F;
        if (!this.A0X.isEmpty()) {
            this.A0X.peek().A05(c1933Tl);
            return;
        }
        int i = ((W5) c1933Tl).A00;
        if (A0f[4].charAt(11) != 'i') {
            throw new RuntimeException();
        }
        A0f[4] = "Z8NuU1FJ3dWiSTg8IJ1adcUJAiKRKniR";
        if (i == 1936286840) {
            Pair<Long, WY> pairA04 = A04(c1933Tl.A00, wj.A8d());
            this.A0C = ((Long) pairA04.first).longValue();
            this.A0E.AID((Uj) pairA04.second);
            String[] strArr = A0f;
            if (strArr[0].charAt(7) == strArr[3].charAt(7)) {
                String[] strArr2 = A0f;
                strArr2[0] = "dPNwBoLFaS619S2FTWEMiGWz4f07WCVk";
                strArr2[3] = "pzdU5B9Fvj5vels0EudX6vPmZsHnZs5T";
                this.A0H = true;
                return;
            }
            this.A0H = true;
            return;
        }
        if (((W5) c1933Tl).A00 != 1701671783 || (uriA9F = wj.A9F()) == null) {
            return;
        }
        C2447fq c2447fq = c1933Tl.A00;
        if (A0f[4].charAt(11) != 'i') {
            A0f[4] = "pnEHoF2xq5OiEj5G1yHJ6GrD4oXbKKQQ";
            A0S(c2447fq, uriA9F);
        } else {
            String[] strArr3 = A0f;
            strArr3[5] = "y4mH3Z8Qw7jej47exD7OHE";
            strArr3[7] = "Ke";
            A0S(c2447fq, uriA9F);
        }
    }

    public static void A0R(C2447fq c2447fq, int i, C1994Wb c1994Wb) throws Q6 {
        c2447fq.A0f(i + 8);
        int fullAtom = c2447fq.A0C();
        int flags = W5.A02(fullAtom);
        int fullAtom2 = flags & 1;
        if (fullAtom2 == 0) {
            int fullAtom3 = flags & 2;
            boolean z = fullAtom3 != 0;
            int sampleCount = c2447fq.A0L();
            int fullAtom4 = c1994Wb.A00;
            if (sampleCount == fullAtom4) {
                Arrays.fill(c1994Wb.A0F, 0, sampleCount, z);
                int fullAtom5 = c2447fq.A07();
                c1994Wb.A02(fullAtom5);
                c1994Wb.A05(c2447fq);
                return;
            }
            StringBuilder sbAppend = new StringBuilder().append(A0B(308, 17, 86)).append(sampleCount).append(A0B(0, 2, 105));
            int fullAtom6 = c1994Wb.A00;
            throw new Q6(sbAppend.append(fullAtom6).toString());
        }
        throw new Q6(A0B(399, 56, 23));
    }

    public static void A0T(C2447fq c2447fq, C1994Wb c1994Wb) throws Q6 {
        c2447fq.A0f(8);
        int flags = c2447fq.A0C();
        int fullAtom = W5.A02(flags) & 1;
        if (fullAtom == 1) {
            c2447fq.A0g(8);
        }
        int iA0L = c2447fq.A0L();
        if (iA0L == 1) {
            int entryCount = W5.A03(flags);
            c1994Wb.A03 += entryCount == 0 ? c2447fq.A0Q() : c2447fq.A0R();
            return;
        }
        throw new Q6(A0B(605, 29, 88) + iA0L);
    }

    public static void A0U(C2447fq c2447fq, C1994Wb c1994Wb) throws Q6 {
        A0R(c2447fq, 0, c1994Wb);
    }

    public static void A0V(C2447fq c2447fq, C1994Wb c1994Wb, byte[] bArr) throws Q6 {
        c2447fq.A0f(8);
        c2447fq.A0k(bArr, 0, 16);
        if (!Arrays.equals(bArr, A0i)) {
            return;
        }
        A0R(c2447fq, 16, c1994Wb);
    }

    public static boolean A0X(int i) {
        return i == 1836019574 || i == 1953653099 || i == 1835297121 || i == 1835626086 || i == 1937007212 || i == 1836019558 || i == 1953653094 || i == 1836475768 || i == 1701082227;
    }

    public static boolean A0Y(int i) {
        return i == 1751411826 || i == 1835296868 || i == 1836476516 || i == 1936286840 || i == 1937011556 || i == 1952867444 || i == 1952868452 || i == 1953196132 || i == 1953654136 || i == 1953658222 || i == 1886614376 || i == 1935763834 || i == 1935763823 || i == 1936027235 || i == 1970628964 || i == 1935828848 || i == 1936158820 || i == 1701606260 || i == 1835362404 || i == 1701671783;
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0048  */
    /* JADX WARN: Code duplicated, block: B:15:0x0067  */
    /* JADX WARN: Code duplicated, block: B:17:0x0076  */
    /* JADX WARN: Code duplicated, block: B:19:0x007f A[LOOP:0: B:18:0x007d->B:19:0x007f, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:20:0x0092  */
    /* JADX WARN: Code duplicated, block: B:22:0x009a  */
    /* JADX WARN: Code duplicated, block: B:29:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:31:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:34:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:36:0x00f8  */
    /* JADX WARN: Code duplicated, block: B:39:0x010a  */
    /* JADX WARN: Code duplicated, block: B:41:0x0112  */
    /* JADX WARN: Code duplicated, block: B:43:0x0131  */
    /* JADX WARN: Code duplicated, block: B:45:0x0135  */
    /* JADX WARN: Code duplicated, block: B:46:0x0139  */
    /* JADX WARN: Code duplicated, block: B:48:0x0144  */
    /* JADX WARN: Code duplicated, block: B:50:0x0148  */
    /* JADX WARN: Code duplicated, block: B:52:0x014e  */
    /* JADX WARN: Code duplicated, block: B:53:0x0166  */
    /* JADX WARN: Code duplicated, block: B:55:0x016c  */
    /* JADX WARN: Code duplicated, block: B:57:0x0180  */
    /* JADX WARN: Code duplicated, block: B:58:0x018f  */
    /* JADX WARN: Code duplicated, block: B:60:0x019f  */
    /* JADX WARN: Code duplicated, block: B:62:0x01af  */
    /* JADX WARN: Code duplicated, block: B:64:0x01bf  */
    private boolean A0Z(WJ wj) throws IOException {
        long jA8E;
        int length;
        int trackCount;
        long jA8d;
        String[] strArr;
        long jA8d2;
        int size;
        int i;
        if (this.A00 != 0) {
            if (this.A07 == 1) {
                wj.readFully(this.A0R.A00, 8, 8);
                int headerBytesRemaining = this.A00;
                this.A00 = headerBytesRemaining + 8;
                this.A07 = this.A0R.A0R();
            } else if (this.A07 == 0) {
                jA8E = wj.A8E();
                if (jA8E == -1) {
                    jA8E = this.A0X.peek().A00;
                }
                String[] strArr2 = A0f;
                String str = strArr2[5];
                String str2 = strArr2[7];
                length = str.length();
                trackCount = str2.length();
                if (length != trackCount) {
                    String[] strArr3 = A0f;
                    strArr3[5] = "1vszd3IUu5CKcITvC9Vovs";
                    strArr3[7] = "Gu";
                    if (jA8E != -1) {
                        long jA8d3 = jA8E - wj.A8d();
                        int trackCount2 = this.A00;
                        this.A07 = jA8d3 + ((long) trackCount2);
                    }
                }
            }
            if (this.A07 >= this.A00) {
                jA8d = wj.A8d() - ((long) this.A00);
                if (this.A01 == 1836019558) {
                    size = this.A0D.size();
                    for (i = 0; i < size; i++) {
                        C1994Wb c1994Wb = this.A0D.valueAt(i).A07;
                        c1994Wb.A02 = jA8d;
                        c1994Wb.A03 = jA8d;
                        c1994Wb.A04 = jA8d;
                    }
                }
                if (this.A01 == 1835295092) {
                    this.A0F = null;
                    this.A09 = this.A07 + jA8d;
                    if (!this.A0H) {
                        this.A0E.AID(new C1991Vy(this.A08, jA8d));
                        this.A0H = true;
                    }
                    this.A02 = 2;
                    return true;
                }
                if (A0X(this.A01)) {
                    jA8d2 = (wj.A8d() + this.A07) - 8;
                    this.A0X.push(new C1934Tm(this.A01, jA8d2));
                    if (this.A07 == this.A00) {
                        A0G(jA8d2);
                    } else {
                        A0C();
                    }
                } else if (A0Y(this.A01)) {
                    if (this.A00 == 8) {
                        throw new Q6(A0B(208, 51, 67));
                    }
                    if (this.A07 <= 2147483647L) {
                        this.A0G = new C2447fq((int) this.A07);
                        System.arraycopy(this.A0R.A00, 0, this.A0G.A00, 0, 8);
                        this.A02 = 1;
                    } else {
                        throw new Q6(A0B(259, 49, 41));
                    }
                } else if (this.A07 <= 2147483647L) {
                    this.A0G = null;
                    strArr = A0f;
                    if (strArr[5].length() != strArr[7].length()) {
                        String[] strArr4 = A0f;
                        strArr4[0] = "bB1AQc0FjQuYWae1J5U5UzIuH4OZnupQ";
                        strArr4[3] = "6HEVKtbFPSbSK2HhHASpS7BShQYaKlDR";
                        this.A02 = 1;
                    }
                } else {
                    throw new Q6(A0B(497, 53, 86));
                }
                return true;
            }
            throw new Q6(A0B(2, 48, 20));
        }
        C2447fq c2447fq = this.A0R;
        if (A0f[1].charAt(24) != 'o') {
            A0f[4] = "lPKwuHzbm68idL8gtBFrrItTSb9iwKIX";
            if (!wj.AGZ(c2447fq.A00, 0, 8, true)) {
                return false;
            }
            this.A00 = 8;
            this.A0R.A0f(0);
            this.A07 = this.A0R.A0Q();
            this.A01 = this.A0R.A0C();
            if (this.A07 == 1) {
                wj.readFully(this.A0R.A00, 8, 8);
                int headerBytesRemaining2 = this.A00;
                this.A00 = headerBytesRemaining2 + 8;
                this.A07 = this.A0R.A0R();
            } else if (this.A07 == 0) {
                jA8E = wj.A8E();
                if (jA8E == -1 && !this.A0X.isEmpty()) {
                    jA8E = this.A0X.peek().A00;
                }
                String[] strArr5 = A0f;
                String str3 = strArr5[5];
                String str4 = strArr5[7];
                length = str3.length();
                trackCount = str4.length();
                if (length != trackCount) {
                    String[] strArr6 = A0f;
                    strArr6[5] = "1vszd3IUu5CKcITvC9Vovs";
                    strArr6[7] = "Gu";
                    if (jA8E != -1) {
                        long jA8d4 = jA8E - wj.A8d();
                        int trackCount3 = this.A00;
                        this.A07 = jA8d4 + ((long) trackCount3);
                    }
                }
            }
            if (this.A07 >= this.A00) {
                jA8d = wj.A8d() - ((long) this.A00);
                if (this.A01 == 1836019558) {
                    size = this.A0D.size();
                    while (i < size) {
                        C1994Wb c1994Wb2 = this.A0D.valueAt(i).A07;
                        c1994Wb2.A02 = jA8d;
                        c1994Wb2.A03 = jA8d;
                        c1994Wb2.A04 = jA8d;
                    }
                }
                if (this.A01 == 1835295092) {
                    this.A0F = null;
                    this.A09 = this.A07 + jA8d;
                    if (!this.A0H) {
                        this.A0E.AID(new C1991Vy(this.A08, jA8d));
                        this.A0H = true;
                    }
                    this.A02 = 2;
                    return true;
                }
                if (A0X(this.A01)) {
                    jA8d2 = (wj.A8d() + this.A07) - 8;
                    this.A0X.push(new C1934Tm(this.A01, jA8d2));
                    if (this.A07 == this.A00) {
                        A0G(jA8d2);
                    } else {
                        A0C();
                    }
                } else if (A0Y(this.A01)) {
                    if (this.A00 == 8) {
                        throw new Q6(A0B(208, 51, 67));
                    }
                    if (this.A07 <= 2147483647L) {
                        this.A0G = new C2447fq((int) this.A07);
                        System.arraycopy(this.A0R.A00, 0, this.A0G.A00, 0, 8);
                        this.A02 = 1;
                    } else {
                        throw new Q6(A0B(259, 49, 41));
                    }
                } else if (this.A07 <= 2147483647L) {
                    this.A0G = null;
                    strArr = A0f;
                    if (strArr[5].length() != strArr[7].length()) {
                        String[] strArr7 = A0f;
                        strArr7[0] = "bB1AQc0FjQuYWae1J5U5UzIuH4OZnupQ";
                        strArr7[3] = "6HEVKtbFPSbSK2HhHASpS7BShQYaKlDR";
                        this.A02 = 1;
                    }
                } else {
                    throw new Q6(A0B(497, 53, 86));
                }
                return true;
            }
            throw new Q6(A0B(2, 48, 20));
        }
        throw new RuntimeException();
    }

    /* JADX WARN: Code duplicated, block: B:105:0x035a  */
    /* JADX WARN: Code duplicated, block: B:107:0x0360  */
    /* JADX WARN: Code duplicated, block: B:110:0x0354 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:111:0x01ae A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:112:0x033e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:113:0x0192 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:114:0x0142 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:115:0x034e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:120:0x02ae A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:121:0x0296 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:33:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:35:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:38:0x010e  */
    /* JADX WARN: Code duplicated, block: B:41:0x0126  */
    /* JADX WARN: Code duplicated, block: B:43:0x0139  */
    /* JADX WARN: Code duplicated, block: B:47:0x0152  */
    /* JADX WARN: Code duplicated, block: B:56:0x0198  */
    /* JADX WARN: Code duplicated, block: B:57:0x01ac  */
    /* JADX WARN: Code duplicated, block: B:60:0x01b2  */
    /* JADX WARN: Code duplicated, block: B:62:0x01f6  */
    /* JADX WARN: Code duplicated, block: B:64:0x0230  */
    /* JADX WARN: Code duplicated, block: B:65:0x0238  */
    /* JADX WARN: Code duplicated, block: B:67:0x024c  */
    /* JADX WARN: Code duplicated, block: B:69:0x025a  */
    /* JADX WARN: Code duplicated, block: B:72:0x027f  */
    /* JADX WARN: Code duplicated, block: B:78:0x02cc  */
    /* JADX WARN: Code duplicated, block: B:81:0x02d6  */
    /* JADX WARN: Code duplicated, block: B:83:0x02ea  */
    /* JADX WARN: Code duplicated, block: B:95:0x0334  */
    /* JADX WARN: Code duplicated, block: B:98:0x033c  */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private boolean A0a(WJ wj) throws IOException {
        C1994Wb c1994Wb;
        WZ wz;
        InterfaceC1957Uo interfaceC1957Uo;
        int i;
        long jA00;
        boolean z;
        String[] strArr;
        int i2;
        int i3;
        String[] strArr2;
        int i4;
        C1956Um c1956Um;
        C1993Wa c1993WaA00;
        String[] strArr3;
        byte[] bArr;
        int i5;
        int i6;
        int i7;
        int iA0C;
        boolean z2;
        String[] strArr4;
        int iAHv;
        int iA02;
        C2447fq c2447fq;
        String str;
        int i8 = 4;
        int i9 = 1;
        int i10 = 0;
        if (this.A02 == 3) {
            if (this.A0F == null) {
                WI wiA07 = A07(this.A0D);
                if (wiA07 == null) {
                    int iA8d = (int) (this.A09 - wj.A8d());
                    if (iA8d >= 0) {
                        wj.AJ9(iA8d);
                        A0C();
                        return false;
                    }
                    throw new Q6(A0B(364, 35, 15));
                }
                int iA8d2 = (int) (wiA07.A07.A0E[wiA07.A02] - wj.A8d());
                if (iA8d2 < 0) {
                    String strA0B = A0B(128, 22, Sdk.SDKError.Reason.INVALID_RI_ENDPOINT_VALUE);
                    if (A0f[1].charAt(24) != 'o') {
                        A0f[4] = "TNyVZxDnlQNi1xjxhm5fj1vwXvJdJvvx";
                        AbstractC2432fb.A07(strA0B, A0B(150, 40, 79));
                        iA8d2 = 0;
                    }
                }
                wj.AJ9(iA8d2);
                this.A0F = wiA07;
            }
            this.A06 = this.A0F.A07.A0B[this.A0F.A01];
            if (this.A0F.A01 < this.A0F.A03) {
                wj.AJ9(this.A06);
                this.A0F.A02();
                if (!this.A0F.A09()) {
                    this.A0F = null;
                }
                this.A02 = 3;
                return true;
            }
            if (this.A0F.A05.A02 == 1) {
                this.A06 -= 8;
                wj.AJ9(8);
            }
            this.A04 = this.A0F.A04();
            this.A06 += this.A04;
            this.A02 = 4;
            this.A05 = 0;
            c1994Wb = this.A0F.A07;
            wz = this.A0F.A05;
            interfaceC1957Uo = this.A0F.A06;
            i = this.A0F.A01;
            jA00 = c1994Wb.A00(i);
            if (this.A0W != null) {
                jA00 = this.A0W.A05(jA00);
                if (A0f[1].charAt(24) != 'o') {
                    throw new RuntimeException();
                }
                String[] strArr5 = A0f;
                strArr5[6] = "LpYyw3Lgs3zE3WRmQllI9djHwhkxxKCg";
                strArr5[2] = "AMhLojMwcHCpwar3oWtcddGKHFOWYqQD";
            }
            if (wz.A01 != 0) {
                bArr = this.A0T.A00;
                bArr[0] = 0;
                bArr[1] = 0;
                bArr[2] = 0;
                i5 = wz.A01 + 1;
                i6 = 4 - wz.A01;
                while (this.A04 < this.A06) {
                    i7 = this.A05;
                    if (A0f[1].charAt(24) != 'o') {
                        throw new RuntimeException();
                    }
                    A0f[4] = "1qDKHw1P6vkipYaBOgzmBjmn0dXzYpTj";
                    if (i7 == 0) {
                        wj.readFully(bArr, i6, i5);
                        this.A0T.A0f(i10);
                        iA0C = this.A0T.A0C();
                        if (iA0C >= i9) {
                            this.A05 = iA0C - 1;
                            this.A0U.A0f(i10);
                            interfaceC1957Uo.AHx(this.A0U, i8);
                            interfaceC1957Uo.AHx(this.A0T, i9);
                            if (this.A0K.length > 0) {
                                z2 = false;
                            } else {
                                z2 = false;
                            }
                            this.A0J = z2;
                            this.A04 += 5;
                            strArr4 = A0f;
                            if (strArr4[0].charAt(7) != strArr4[3].charAt(7)) {
                                String[] strArr6 = A0f;
                                strArr6[6] = "rZ94R6P7RQqIK8D81rUFFdS2JFbRf80e";
                                strArr6[2] = "1aEdHpHZ0k9daaafV2wC4dc7qdVRqaRS";
                                this.A06 += i6;
                                i9 = 1;
                            }
                        } else {
                            throw new Q6(A0B(FacebookRequestErrorClassification.EC_INVALID_TOKEN, 18, 76));
                        }
                    } else {
                        if (this.A0J) {
                            this.A0S.A0d(this.A05);
                            wj.readFully(this.A0S.A00, i10, this.A05);
                            interfaceC1957Uo.AHx(this.A0S, this.A05);
                            iAHv = this.A05;
                            iA02 = AbstractC1949Ud.A02(this.A0S.A00, this.A0S.A0A());
                            c2447fq = this.A0S;
                            str = wz.A07.A0W;
                            if (A0f[1].charAt(24) != 'o') {
                                throw new RuntimeException();
                            }
                            String[] strArr7 = A0f;
                            strArr7[6] = "JZ6CEvSQuLHGlkYYaIfjXdg19IAA3WTq";
                            strArr7[2] = "SvqukunW2lA6zFJCBFc64ddUO6mmL63c";
                            c2447fq.A0f(A0B(756, 10, 86).equals(str) ? 1 : 0);
                            this.A0S.A0e(iA02);
                            X4.A03(jA00, this.A0S, this.A0K);
                        } else {
                            iAHv = interfaceC1957Uo.AHv(wj, this.A05, false);
                        }
                        this.A04 += iAHv;
                        this.A05 -= iAHv;
                        i8 = 4;
                        i9 = 1;
                        i10 = 0;
                    }
                }
            } else {
                z = this.A0I;
                strArr = A0f;
                if (strArr[5].length() != strArr[7].length()) {
                    throw new RuntimeException();
                }
                String[] strArr8 = A0f;
                strArr8[6] = "3oG3ro6c6C6dhlpRForIudcfaC8KH54O";
                strArr8[2] = "9WRqTQKssWtQllLMkZA1Hdma0ClRptku";
                if (z) {
                    U5.A07(this.A06, this.A0V);
                    int iA0A = this.A0V.A0A();
                    interfaceC1957Uo.AHx(this.A0V, iA0A);
                    this.A06 += iA0A;
                    this.A04 += iA0A;
                    this.A0I = false;
                }
                while (this.A04 < this.A06) {
                    i2 = this.A06;
                    i3 = this.A04;
                    strArr2 = A0f;
                    if (strArr2[0].charAt(7) != strArr2[3].charAt(7)) {
                        String[] strArr9 = A0f;
                        strArr9[5] = "kOKUbtThXAfVEbZBtV4o3t";
                        strArr9[7] = "sw";
                        this.A04 += interfaceC1957Uo.AHv(wj, i2 - i3, false);
                    } else {
                        String[] strArr10 = A0f;
                        strArr10[5] = "z6QhgG7wjRv1MMHSCe0HJl";
                        strArr10[7] = "m2";
                        this.A04 += interfaceC1957Uo.AHv(wj, i2 - i3, false);
                    }
                }
            }
            if (c1994Wb.A0G[i]) {
                i4 = 1;
            } else {
                i4 = 0;
            }
            c1956Um = null;
            c1993WaA00 = this.A0F.A00();
            if (c1993WaA00 != null) {
                strArr3 = A0f;
                if (strArr3[5].length() != strArr3[7].length()) {
                    A0f[1] = "mMKX3fta0GSDwUHHyjpVdf70h4DY7b7o";
                    i4 |= 1073741824;
                    c1956Um = c1993WaA00.A01;
                }
            }
            if (this.A0F != null) {
                i4 |= 1;
            }
            long j = jA00;
            interfaceC1957Uo.AI0(jA00, i4, this.A06, 0, c1956Um);
            this.A0A = j;
            A0F(j);
            if (!this.A0F.A09()) {
                this.A0F = null;
            }
            this.A02 = 3;
            return true;
        }
        c1994Wb = this.A0F.A07;
        wz = this.A0F.A05;
        interfaceC1957Uo = this.A0F.A06;
        i = this.A0F.A01;
        jA00 = c1994Wb.A00(i);
        if (this.A0W != null) {
            jA00 = this.A0W.A05(jA00);
            if (A0f[1].charAt(24) != 'o') {
                throw new RuntimeException();
            }
            String[] strArr11 = A0f;
            strArr11[6] = "LpYyw3Lgs3zE3WRmQllI9djHwhkxxKCg";
            strArr11[2] = "AMhLojMwcHCpwar3oWtcddGKHFOWYqQD";
        }
        if (wz.A01 != 0) {
            bArr = this.A0T.A00;
            bArr[0] = 0;
            bArr[1] = 0;
            bArr[2] = 0;
            i5 = wz.A01 + 1;
            i6 = 4 - wz.A01;
            while (this.A04 < this.A06) {
                i7 = this.A05;
                if (A0f[1].charAt(24) != 'o') {
                    throw new RuntimeException();
                }
                A0f[4] = "1qDKHw1P6vkipYaBOgzmBjmn0dXzYpTj";
                if (i7 == 0) {
                    wj.readFully(bArr, i6, i5);
                    this.A0T.A0f(i10);
                    iA0C = this.A0T.A0C();
                    if (iA0C >= i9) {
                        this.A05 = iA0C - 1;
                        this.A0U.A0f(i10);
                        interfaceC1957Uo.AHx(this.A0U, i8);
                        interfaceC1957Uo.AHx(this.A0T, i9);
                        if (this.A0K.length > 0 || !AbstractC1949Ud.A0I(wz.A07.A0W, bArr[i8])) {
                            z2 = false;
                        } else {
                            z2 = true;
                        }
                        this.A0J = z2;
                        this.A04 += 5;
                        strArr4 = A0f;
                        if (strArr4[0].charAt(7) != strArr4[3].charAt(7)) {
                            String[] strArr12 = A0f;
                            strArr12[6] = "rZ94R6P7RQqIK8D81rUFFdS2JFbRf80e";
                            strArr12[2] = "1aEdHpHZ0k9daaafV2wC4dc7qdVRqaRS";
                            this.A06 += i6;
                            i9 = 1;
                        }
                    } else {
                        throw new Q6(A0B(FacebookRequestErrorClassification.EC_INVALID_TOKEN, 18, 76));
                    }
                } else {
                    if (this.A0J) {
                        this.A0S.A0d(this.A05);
                        wj.readFully(this.A0S.A00, i10, this.A05);
                        interfaceC1957Uo.AHx(this.A0S, this.A05);
                        iAHv = this.A05;
                        iA02 = AbstractC1949Ud.A02(this.A0S.A00, this.A0S.A0A());
                        c2447fq = this.A0S;
                        str = wz.A07.A0W;
                        if (A0f[1].charAt(24) != 'o') {
                            throw new RuntimeException();
                        }
                        String[] strArr13 = A0f;
                        strArr13[6] = "JZ6CEvSQuLHGlkYYaIfjXdg19IAA3WTq";
                        strArr13[2] = "SvqukunW2lA6zFJCBFc64ddUO6mmL63c";
                        c2447fq.A0f(A0B(756, 10, 86).equals(str) ? 1 : 0);
                        this.A0S.A0e(iA02);
                        X4.A03(jA00, this.A0S, this.A0K);
                    } else {
                        iAHv = interfaceC1957Uo.AHv(wj, this.A05, false);
                    }
                    this.A04 += iAHv;
                    this.A05 -= iAHv;
                    i8 = 4;
                    i9 = 1;
                    i10 = 0;
                }
            }
        } else {
            z = this.A0I;
            strArr = A0f;
            if (strArr[5].length() != strArr[7].length()) {
                throw new RuntimeException();
            }
            String[] strArr14 = A0f;
            strArr14[6] = "3oG3ro6c6C6dhlpRForIudcfaC8KH54O";
            strArr14[2] = "9WRqTQKssWtQllLMkZA1Hdma0ClRptku";
            if (z) {
                U5.A07(this.A06, this.A0V);
                int iA0A2 = this.A0V.A0A();
                interfaceC1957Uo.AHx(this.A0V, iA0A2);
                this.A06 += iA0A2;
                this.A04 += iA0A2;
                this.A0I = false;
            }
            while (this.A04 < this.A06) {
                i2 = this.A06;
                i3 = this.A04;
                strArr2 = A0f;
                if (strArr2[0].charAt(7) != strArr2[3].charAt(7)) {
                    String[] strArr15 = A0f;
                    strArr15[5] = "kOKUbtThXAfVEbZBtV4o3t";
                    strArr15[7] = "sw";
                    this.A04 += interfaceC1957Uo.AHv(wj, i2 - i3, false);
                } else {
                    String[] strArr16 = A0f;
                    strArr16[5] = "z6QhgG7wjRv1MMHSCe0HJl";
                    strArr16[7] = "m2";
                    this.A04 += interfaceC1957Uo.AHv(wj, i2 - i3, false);
                }
            }
        }
        if (c1994Wb.A0G[i]) {
            i4 = 1;
        } else {
            i4 = 0;
        }
        c1956Um = null;
        c1993WaA00 = this.A0F.A00();
        if (c1993WaA00 != null) {
            strArr3 = A0f;
            if (strArr3[5].length() != strArr3[7].length()) {
                A0f[1] = "mMKX3fta0GSDwUHHyjpVdf70h4DY7b7o";
                i4 |= 1073741824;
                c1956Um = c1993WaA00.A01;
            }
        }
        if (this.A0F != null && this.A0F.A05 != null && this.A0F.A05.A07 != null && this.A0F.A05.A07.A0W == A0B(735, 21, 111)) {
            i4 |= 1;
        }
        long j2 = jA00;
        interfaceC1957Uo.AI0(jA00, i4, this.A06, 0, c1956Um);
        this.A0A = j2;
        A0F(j2);
        if (!this.A0F.A09()) {
            this.A0F = null;
        }
        this.A02 = 3;
        return true;
        throw new RuntimeException();
    }

    public static /* synthetic */ UK[] A0b() {
        return new UK[]{new C1927Te()};
    }

    @Override // com.facebook.ads.redexgen.core.UK
    public final void AA0(UL ul) {
        this.A0E = ul;
        if (this.A0Q != null) {
            WI wi = new WI(ul.AJX(0, this.A0Q.A03));
            wi.A08(this.A0Q, new WC(0, 0, 0, 0));
            this.A0D.put(0, wi);
            A0D();
            this.A0E.A6E();
        }
    }

    @Override // com.facebook.ads.redexgen.core.UK
    public final int AGT(WJ wj, C1952Ug c1952Ug) throws IOException {
        while (true) {
            switch (this.A02) {
                case 0:
                    if (!A0Z(wj)) {
                        return -1;
                    }
                    break;
                    break;
                case 1:
                    A0H(wj);
                    break;
                case 2:
                    A0I(wj);
                    break;
                default:
                    if (A0a(wj)) {
                        return 0;
                    }
                    break;
            }
        }
    }

    @Override // com.facebook.ads.redexgen.core.UK
    public final void AGj() {
    }

    @Override // com.facebook.ads.redexgen.core.UK
    public final void AIC(long j, long j2) {
        int size = this.A0D.size();
        for (int i = 0; i < size; i++) {
            this.A0D.valueAt(i).A05();
            int i2 = A0f[1].charAt(24);
            if (i2 == 111) {
                throw new RuntimeException();
            }
            String[] strArr = A0f;
            strArr[0] = "3tiJN5gF8ZGUW3QgkqSiZewttnV23Jud";
            strArr[3] = "35rgEDIFkTn7PAD1C9FSUFqT4oV91SWi";
        }
        this.A0Y.clear();
        this.A03 = 0;
        this.A0B = j2;
        this.A0X.clear();
        this.A0I = false;
        A0C();
    }

    @Override // com.facebook.ads.redexgen.core.UK
    public final boolean AJB(WJ wj) throws IOException {
        return WX.A01(wj);
    }
}
