package com.facebook.ads.redexgen.core;

import com.vungle.ads.internal.protos.Sdk;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.dp, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2323dp {
    public static byte[] A0W;
    public final int A00;
    public final int A01;
    public final int A02;
    public final int A03;
    public final int A04;
    public final int A05;
    public final int A06;
    public final int A07;
    public final int A08;
    public final int A09;
    public final long A0A;
    public final long A0B;
    public final long A0C;
    public final long A0D;
    public final long A0E;
    public final long A0F;
    public final long A0G;
    public final C2322dn A0H;
    public final Cdo A0I;
    public final String A0J;
    public final String A0K;
    public final String A0L;
    public final String A0M;
    public final String A0N;
    public final String A0O;
    public final String A0P;
    public final Map<String, String> A0Q;
    public final boolean A0R;
    public final boolean A0S;
    public final boolean A0T;
    public final boolean A0U;
    public final boolean A0V;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0W, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 103);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A0W = new byte[]{-89, -101};
    }

    public C2323dp() {
        this(A00(0, 0, Sdk.SDKError.Reason.JSON_ENCODE_ERROR_VALUE), -1L, false, -1, -1, -1, -1, false, false, -1, -1L, new Cdo(), -1L, false, -1, -1, -1L, -1L, -1, null, -1, null, null, C2322dn.A03, -1, false, A00(0, 0, Sdk.SDKError.Reason.JSON_ENCODE_ERROR_VALUE), A00(0, 0, Sdk.SDKError.Reason.JSON_ENCODE_ERROR_VALUE), A00(0, 0, Sdk.SDKError.Reason.JSON_ENCODE_ERROR_VALUE), null, -1L, -1L);
    }

    public C2323dp(C2323dp c2323dp) {
        this(c2323dp, c2323dp.A0N);
    }

    public C2323dp(C2323dp c2323dp, String str) {
        this(c2323dp.A0M, c2323dp.A0A, c2323dp.A0T, c2323dp.A08, c2323dp.A07, c2323dp.A00, c2323dp.A09, c2323dp.A0V, c2323dp.A0S, c2323dp.A05, c2323dp.A0C, c2323dp.A0I, c2323dp.A0F, c2323dp.A0U, c2323dp.A06, c2323dp.A02, c2323dp.A0E, c2323dp.A0B, c2323dp.A01, c2323dp.A0Q, c2323dp.A04, c2323dp.A0K, c2323dp.A0J, c2323dp.A0H, c2323dp.A03, c2323dp.A0R, c2323dp.A0O, c2323dp.A0L, c2323dp.A0P, str, -1L, -1L);
    }

    public C2323dp(String str, long j, boolean z, int i, int i2, int i3, int i4, boolean z2, boolean z3, int i5, long j2, Cdo cdo, long j3, boolean z4, int i6, int i7, long j4, long j5, int i8, Map<String, String> map, int i9, String str2, String str3, C2322dn c2322dn, int i10, boolean z5, String str4, String str5, String str6, String str7, long j6, long j7) {
        this.A0Q = new HashMap();
        this.A0M = str;
        this.A0A = j;
        this.A0T = z;
        this.A08 = i;
        this.A07 = i2;
        this.A00 = i3;
        this.A09 = i4;
        this.A0V = z2;
        this.A0S = z3;
        this.A05 = i5;
        this.A0C = j2;
        this.A0I = cdo;
        this.A0F = j3;
        this.A0U = z4;
        this.A06 = i6;
        this.A02 = i7;
        this.A0E = j4;
        this.A0B = j5;
        this.A01 = i8;
        this.A04 = i9;
        this.A0J = str3;
        this.A0K = str2;
        if (map != null) {
            this.A0Q.putAll(map);
        }
        this.A0H = c2322dn;
        this.A03 = i10;
        this.A0R = z5;
        this.A0O = str4;
        this.A0L = str5;
        this.A0P = str6;
        this.A0N = str7;
        this.A0G = j6;
        this.A0D = j7;
    }

    public final String toString() {
        StringBuilder sbAppend = new StringBuilder().append(this.A0M);
        String strA00 = A00(0, 2, 20);
        return sbAppend.append(strA00).append(this.A0A).append(strA00).append(this.A0T).append(strA00).append(this.A08).append(strA00).append(this.A07).append(strA00).append(this.A00).append(strA00).append(this.A09).append(strA00).append(this.A0V).append(strA00).append(this.A0S).append(strA00).append(this.A05).append(strA00).append(this.A0E).append(strA00).append(this.A0B).append(strA00).append(this.A01).append(strA00).append(this.A04).append(strA00).append(this.A06).append(strA00).append(this.A02).append(strA00).append(this.A03).append(strA00).append(this.A0R).append(strA00).append(this.A0O).toString();
    }
}
