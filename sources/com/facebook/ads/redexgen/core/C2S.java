package com.facebook.ads.redexgen.core;

import android.text.TextUtils;
import com.facebook.ads.RewardData;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.json.mediationsdk.logger.IronSourceError;
import com.json.mediationsdk.utils.IronSourceConstants;
import com.vungle.ads.internal.protos.Sdk;
import java.io.Serializable;
import java.util.Arrays;
import kotlin.io.encoding.Base64;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.2S, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class C2S implements Serializable {
    public static String A0o = null;
    public static byte[] A0p = null;
    public static final long serialVersionUID = -8352540727250859603L;
    public double A00;
    public int A01;
    public int A02;
    public int A03;
    public long A04;
    public long A05;
    public long A06;
    public RewardData A07;
    public String A08;
    public String A09;
    public String A0A;
    public String A0B;
    public String A0C;
    public String A0D;
    public String A0E;
    public String A0F;
    public String A0G;
    public String A0H;
    public String A0I;
    public String A0J;
    public String A0K;
    public String A0L;
    public String A0M;
    public String A0N;
    public boolean A0O;
    public boolean A0P;
    public boolean A0Q;
    public boolean A0R;
    public boolean A0S;
    public boolean A0T;
    public boolean A0U;
    public boolean A0V;
    public boolean A0W;
    public boolean A0X;
    public boolean A0Y;
    public boolean A0Z;
    public boolean A0a;
    public boolean A0b;
    public boolean A0c;
    public boolean A0d;
    public boolean A0e;
    public boolean A0f;
    public boolean A0g;
    public boolean A0h;
    public boolean A0i;
    public boolean A0j;
    public boolean A0k;
    public boolean A0l;
    public boolean A0m;
    public final int A0n;

    static {
        A02();
    }

    public static String A01(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0p, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 40);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A0p = new byte[]{88, 122, 107, 63, 102, 112, 106, 109, 63, 109, 122, 104, 126, 109, 123, 42, Ascii.CR, Ascii.DLE, Ascii.ETB, 2, Ascii.SI, Ascii.SI, 67, 2, 19, 19, 67, 2, Ascii.CR, 7, 67, Ascii.DLE, 8, 10, 19, 67, Ascii.ETB, Ascii.VT, 6, 67, 2, 7, 77, 102, 65, 92, 91, 78, 67, 67, Ascii.SI, 91, 71, 74, Ascii.SI, 78, 95, 95, Ascii.FF, 49, 99, 52, 34, 55, 32, 43, 99, 55, 43, 38, 99, 37, 54, 47, 47, 99, 34, 39, Ascii.US, 39, 37, 60, 108, 56, 36, 41, 108, 45, 40, 108, 46, 53, 108, 40, 35, 59, 34, 32, 35, 45, 40, 37, 34, 43, 108, 56, 36, 41, 108, 45, 60, 60, 108, 45, 34, 40, 108, 37, 34, 63, 56, 45, 34, 56, 32, 53, 108, 43, 41, 56, 108, 53, 35, 57, 62, 108, 62, 41, 59, 45, 62, 40, 109, 127, 73, 83, 84, 6, 84, 67, 81, 71, 84, 66, 6, 79, 85, 6, 84, 67, 71, 66, 95, 6, 82, 73, 6, 68, 67, 6, 83, 85, 67, 66, 7, 42, 47, 37, 60, Ascii.DC4, 62, 56, 46, Ascii.DC4, Base64.padSymbol, 34, 47, 46, 36, Ascii.DC4, Base64.padSymbol, 34, 46, 60, Ascii.DC4, Base64.padSymbol, 121, Ascii.DC4, 57, 46, 47, 46, 56, 34, 44, 37, 96, 98, 96, 92, 101, 106, 111, 119, 102, 113, 92, 96, 111, 106, 96, 104, 112, 92, 108, 109, 92, 96, 119, 98, 92, 102, 109, 98, 97, 111, 102, 103, 107, 105, 101, 120, 105, 97, 111, 102, 97, 108, 53, 127, 109, 106, 87, 105, 125, 124, 103, 87, 122, 109, 108, 97, 122, 109, 107, 124, 40, 105, 107, 124, 97, 103, 102, 53, 105, 102, 108, 122, 103, 97, 108, 38, 97, 102, 124, 109, 102, 124, 38, 105, 107, 124, 97, 103, 102, 38, 94, 65, 77, 95, 40, 120, 105, 107, 99, 105, 111, 109, 53, 107, 103, 101, 38, 105, 102, 108, 122, 103, 97, 108, 38, 126, 109, 102, 108, 97, 102, 111, 40, 97, 102, 124, 109, 102, 124, 50, 39, 39, 120, 100, 105, 113, 38, 111, 103, 103, 111, 100, 109, 38, 107, 103, 101, 39, 123, 124, 103, 122, 109, 79, 77, 94, 67, 89, 95, 73, SignedBytes.MAX_POWER_OF_TWO, 7, Ascii.FF, 5, Ascii.CR, 10, 59, Ascii.DC4, 5, Ascii.SYN, 5, 9, Ascii.ETB, 1, Ascii.SO, Ascii.VT, 1, 9, Base64.padSymbol, 6, 7, Ascii.SO, 3, Ascii.ESC, Base64.padSymbol, Ascii.SO, Ascii.CR, 5, 5, Ascii.VT, Ascii.FF, 5, Base64.padSymbol, Ascii.SI, 17, 42, 37, 32, 42, 34, Ascii.SYN, 32, 40, 43, Ascii.SYN, 47, 32, 37, Base64.padSymbol, 44, 59, 32, 39, 46, Ascii.SYN, 44, 39, 40, 43, 37, 44, 45, 110, 98, 96, 35, 107, 108, 110, 104, 111, 98, 98, 102, 35, 108, 105, 126, 35, 100, 99, 121, 104, 127, 126, 121, 100, 121, 100, 108, 97, 35, 110, 97, 100, 110, 102, 104, 105, 51, 34, 53, 49, 36, 57, 38, 53, Ascii.SI, 49, 35, Ascii.SI, 51, 36, 49, Ascii.SI, 53, 62, 49, 50, 60, 53, 52, 43, 58, 45, 41, 60, 33, 62, 45, Ascii.ETB, 41, 59, Ascii.ETB, 43, 60, 41, Ascii.ETB, 45, 38, 41, 42, 36, 45, 44, Ascii.ETB, 38, 41, 60, 33, 62, 45, Ascii.ETB, 42, 41, 38, 38, 45, 58, 114, 101, 112, 78, 114, 125, 120, 114, 122, 78, 117, 116, 125, 112, 104, 78, 125, 126, 118, 118, 120, 127, 118, 78, 124, 98, Ascii.DC2, 5, Ascii.SUB, 41, Ascii.RS, Ascii.US, Ascii.DC2, 19, 41, Ascii.CAN, Ascii.ETB, 0, Ascii.US, 17, Ascii.ETB, 2, Ascii.US, Ascii.EM, Ascii.CAN, 41, 19, Ascii.CAN, Ascii.ETB, Ascii.DC4, Ascii.SUB, 19, Ascii.DC2, 110, 121, 102, 85, 98, 121, 85, 111, 100, 107, 104, 102, 111, 110, 95, 72, 87, 100, 83, 66, 89, 73, 82, 95, 100, 94, 85, 90, 89, 87, 94, 95, 109, 112, 103, 104, 100, 96, 106, 86, 122, 109, 98, 86, 101, 104, 112, 108, 123, 86, 97, 125, 100, 101, 86, 124, 123, 101, 110, 101, 104, 121, 114, 123, 127, 110, 111, 84, 104, 123, 102, 98, 106, 106, 98, 105, 96, 90, 117, 105, 100, 124, 90, 109, 106, 118, 113, 90, 118, 113, 119, 108, 107, 98, Ascii.VT, 10, 7, 6, 60, 0, Ascii.FF, Ascii.SYN, Ascii.CR, Ascii.ETB, 7, Ascii.FF, Ascii.DC4, Ascii.CR, 60, 6, Ascii.CR, 2, 1, Ascii.SI, 6, 7, 4, 5, 8, 9, 51, Ascii.FS, Ascii.RS, 3, Ascii.VT, Ascii.RS, 9, Ascii.US, Ascii.US, 51, Ascii.SO, Ascii.CR, Ascii.RS, 51, 9, 2, Ascii.CR, Ascii.SO, 0, 9, 8, Ascii.DC2, Ascii.NAK, 8, Ascii.SI, Ascii.SUB, Ascii.ETB, Ascii.ETB, 36, Ascii.SUB, Ascii.NAK, Ascii.US, 36, Ascii.FS, Ascii.RS, Ascii.SI, 36, 9, Ascii.RS, Ascii.FF, Ascii.SUB, 9, Ascii.US, 36, Ascii.US, Ascii.RS, 8, Ascii.CAN, 9, Ascii.DC2, Ascii.VT, Ascii.SI, Ascii.DC2, Ascii.DC4, Ascii.NAK, 97, 102, 123, 124, 105, 100, 100, 87, 105, 102, 108, 87, 111, 109, 124, 87, 122, 109, 127, 105, 122, 108, 87, 109, 102, 105, 106, 100, 109, 108, Base64.padSymbol, 58, 32, 49, 38, 55, 49, 36, 32, Ascii.VT, 35, 49, 54, Ascii.VT, Base64.padSymbol, 58, 39, 32, 53, 56, 56, Ascii.VT, 54, 33, 32, 32, 59, 58, 8, Ascii.SI, Ascii.NAK, 4, 19, Ascii.DC2, Ascii.NAK, 8, Ascii.NAK, 8, 0, Ascii.CR, 59, 34, Ascii.SO, 38, 52, 51, Ascii.SO, 56, 63, 34, 37, 48, Base64.padSymbol, Base64.padSymbol, Ascii.SO, 51, 36, 37, 37, 62, 63, 51, 48, 60, 52, 0, 40, 62, 43, 60, 55, 0, 62, 49, 59, 0, Base64.padSymbol, 45, 48, 40, 44, 58, 0, 58, 49, 62, Base64.padSymbol, 51, 58, 59, 66, 74, 75, 70, 78, 112, 78, 92, 95, 74, 76, 91, 112, 93, 78, 91, 70, SignedBytes.MAX_POWER_OF_TWO, 63, 48, 37, 56, 39, 52, 124, 96, 109, 117, 34, 107, 99, 99, 107, 96, 105, 34, 111, 99, 97, 43, 41, 62, 4, 41, 62, 44, 58, 41, 63, 4, 56, 47, 58, 4, 57, 46, 47, 47, 52, 53, 4, 47, 62, 35, 47, 107, 105, 126, 68, 105, 126, 108, 122, 105, 127, 68, 127, 126, 104, 120, 105, 114, 107, 111, 114, 116, 117, 70, 68, 83, 105, 68, 83, 65, 87, 68, 82, 105, 83, 88, 87, 84, 90, 83, 82, 62, 60, 43, 17, 60, 43, 57, 47, 60, 42, 17, 58, 39, 58, 34, 43, Ascii.ESC, Ascii.EM, Ascii.SO, 52, Ascii.EM, Ascii.SO, 
        Ascii.FS, 10, Ascii.EM, Ascii.SI, 52, Ascii.FS, 10, Ascii.US, 8, 3, 52, 10, Ascii.SI, 52, 9, Ascii.RS, Ascii.US, Ascii.US, 4, 5, 52, Ascii.US, Ascii.SO, 19, Ascii.US, 97, 118, 99, 127, 114, 106, 76, 100, 123, 118, 125, 76, 96, 120, 122, 99, 76, 103, 122, 126, 118, 76, 118, 107, 112, 118, 118, 119, 96, 76, 101, 122, 119, 118, 124, 76, 119, 102, 97, 114, 103, 122, 124, 125, 76, 118, 125, 114, 113, 127, 118, 119, 84, 67, 87, 83, 67, 85, 82, 121, 79, 66, 116, 99, 113, 103, 116, 98, 89, 97, 116, 103, 104, 114, 99, 98, 89, 114, 99, 126, 114, 86, 65, 83, 69, 86, SignedBytes.MAX_POWER_OF_TWO, 65, SignedBytes.MAX_POWER_OF_TWO, 123, 82, 77, SignedBytes.MAX_POWER_OF_TWO, 65, 75, Ascii.US, Ascii.CAN, Ascii.RS, 5, 2, Ascii.VT, 51, Ascii.CAN, 3, 51, Ascii.SI, 4, 9, Ascii.SI, 7, 51, Ascii.VT, 3, 3, Ascii.VT, 0, 9, 51, Ascii.FS, 0, Ascii.CR, Ascii.NAK, 51, Ascii.CR, Ascii.EM, Ascii.CAN, 3, 51, Ascii.RS, 9, 8, 5, Ascii.RS, 9, Ascii.SI, Ascii.CAN, 119, 104, 101, 100, 110, 94, 98, 109, 104, 98, 106, 96, 99, 109, 100, 59, 36, 40, 58, 44, 47, 36, 33, 36, 57, 52, Ascii.DC2, 46, 37, 40, 46, 38, Ascii.DC2, 36, 35, 36, 57, 36, 44, 33, Ascii.DC2, 41, 40, 33, 44, 52, Ascii.RS, 1, Ascii.CR, Ascii.US, 9, 10, 1, 4, 1, Ascii.FS, 17, 55, Ascii.VT, 0, Ascii.CR, Ascii.VT, 3, 55, 1, 6, Ascii.FS, Ascii.CR, Ascii.SUB, Ascii.RS, 9, 4, 67, 85, SignedBytes.MAX_POWER_OF_TWO, 87, 92, 107, 85, 90, 80, 107, 86, 70, 91, 67, 71, 81, 107, 85, 90, 80, 70, 91, 93, 80, 107, 66, 6, 107, 65, 93, Ascii.FF, Ascii.SUB, Ascii.SI, Ascii.CAN, 19, 36, Ascii.SUB, Ascii.NAK, Ascii.US, 36, Ascii.EM, 9, Ascii.DC4, Ascii.FF, 8, Ascii.RS, 36, Ascii.CAN, Ascii.DC4, Ascii.SO, Ascii.NAK, Ascii.SI, Ascii.US, Ascii.DC4, Ascii.FF, Ascii.NAK, 36, Ascii.FF, 19, Ascii.RS, Ascii.NAK, 36, Ascii.DC2, Ascii.SUB, Ascii.EM, 36, Ascii.DC4, Ascii.VT, Ascii.RS, Ascii.NAK, 84, 66, 87, SignedBytes.MAX_POWER_OF_TWO, 75, 124, 66, 77, 71, 124, 74, 77, 80, 87, 66, 79, 79, 124, SignedBytes.MAX_POWER_OF_TWO, 87, 66, 124, 65, 86, 87, 87, 76, 77, 124, 70, 77, 66, 65, 79, 70, 71, 8, Ascii.RS, Ascii.VT, Ascii.FS, Ascii.ETB, 32, Ascii.RS, 17, Ascii.ESC, 32, Ascii.SYN, 17, Ascii.FF, Ascii.VT, Ascii.RS, 19, 19, 32, Ascii.SUB, 17, Ascii.RS, Ascii.GS, 19, Ascii.SUB, Ascii.ESC, 90, 76, 89, 78, 69, 114, 76, 67, 73, 114, 68, 67, 94, 89, 76, 65, 65, 114, 75, 95, 66, SignedBytes.MAX_POWER_OF_TWO, 114, 94, 89, 76, 95, 89, 114, 73, 72, 65, 76, 84, 81, 71, 82, 69, 78, 121, 71, 72, 66, 121, 79, 72, 85, 82, 71, 74, 74, 121, 73, 72, 121, 79, 72, 85, 82, 71, 72, 82, 121, 65, 71, 75, 67, 85, 121, 67, 72, 71, 68, 74, 67, 66};
    }

    public abstract int A0X();

    public abstract int A0Y();

    public C2S() {
        String strA01 = A01(0, 0, 51);
        this.A0F = strA01;
        this.A02 = 200;
        this.A0D = strA01;
        this.A0J = strA01;
        this.A0I = strA01;
        this.A0H = strA01;
        this.A0K = strA01;
        this.A0G = strA01;
        this.A0d = false;
        this.A0O = false;
        this.A0f = false;
        this.A0E = strA01;
        this.A0C = A01(897, 15, 36);
        this.A0N = strA01;
    }

    public static C2S A00(JSONObject jSONObject, C2699k1 c2699k1) {
        boolean zHas = jSONObject.has(A01(367, 12, 76));
        boolean z = false;
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(A01(359, 8, 4));
        if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
            z = true;
        }
        C2S c2sA02 = null;
        if (zHas) {
            try {
                c2sA02 = C2853mb.A02(jSONObject, c2699k1);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        if (c2sA02 == null) {
            zHas = false;
            c2sA02 = C1769Mu.A02(jSONObject, c2699k1);
        }
        c2sA02.A13(zHas);
        c2sA02.A0O(z);
        return c2sA02;
    }

    private void A03(double d) {
        this.A00 = d;
    }

    private void A04(int i) {
        this.A03 = i;
    }

    private final void A05(long j) {
        this.A04 = j;
    }

    private final void A06(long j) {
        this.A05 = j;
    }

    private void A07(String str) {
        this.A08 = str;
    }

    private void A08(String str) {
        this.A09 = str;
    }

    private void A09(String str) {
        this.A0L = str;
    }

    private final void A0A(String str) {
        this.A0D = str;
    }

    private final void A0B(String str) {
        this.A0G = str;
    }

    private final void A0C(String str) {
        this.A0H = str;
    }

    private final void A0D(String str) {
        this.A0I = str;
    }

    private final void A0E(String str) {
        this.A0J = str;
    }

    private final void A0F(String str) {
        this.A0K = str;
    }

    private void A0G(JSONObject jSONObject) {
        this.A0F = jSONObject.toString();
    }

    private final void A0H(boolean z) {
        this.A0U = z;
    }

    private final void A0I(boolean z) {
        this.A0X = z;
    }

    private final void A0J(boolean z) {
        this.A0Y = z;
    }

    private final void A0K(boolean z) {
        this.A0Z = z;
    }

    private final void A0L(boolean z) {
        this.A0S = z;
    }

    private final void A0M(boolean z) {
        this.A0T = z;
    }

    private final void A0N(boolean z) {
        this.A0a = z;
    }

    private final void A0O(boolean z) {
        this.A0V = z;
    }

    private final void A0P(boolean z) {
        this.A0l = z;
    }

    private final void A0Q(boolean z) {
        this.A0m = z;
    }

    private final void A0R(boolean z) {
        this.A0e = z;
    }

    private final void A0S(boolean z) {
        this.A0f = z;
    }

    public final double A0T() {
        return this.A00;
    }

    public final int A0U() {
        return this.A03;
    }

    public final int A0V() {
        return this.A0n;
    }

    public final int A0W() {
        return this.A01;
    }

    public final long A0Z() {
        return this.A04;
    }

    public final long A0a() {
        return this.A05;
    }

    public final long A0b() {
        return this.A06;
    }

    public final RewardData A0c() {
        return this.A07;
    }

    public final String A0d() {
        return A0o;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:4:0x0009  */
    public final String A0e() {
        byte b;
        String str = this.A0B;
        switch (str.hashCode()) {
            case -1364000502:
                if (!str.equals(A01(1106, 14, 12))) {
                    b = -1;
                } else {
                    b = 1;
                }
                break;
            case -1052618729:
                if (!str.equals(A01(891, 6, Sdk.SDKError.Reason.TPAT_ERROR_VALUE))) {
                    b = -1;
                } else {
                    b = 2;
                }
                break;
            case 604727084:
                if (!str.equals(A01(811, 12, 73))) {
                    b = -1;
                } else {
                    b = 0;
                }
                break;
            default:
                b = -1;
                break;
        }
        switch (b) {
            case 0:
                return A01(428, 37, 37);
            case 1:
                return IV.A04.A03();
            case 2:
                return IU.A03.A03();
            default:
                return A01(0, 0, 51);
        }
    }

    public final String A0f() {
        return this.A08;
    }

    public final String A0g() {
        return this.A09;
    }

    public final String A0h() {
        return this.A0A;
    }

    public final String A0i() {
        return this.A0B;
    }

    public final String A0j() {
        return this.A0C;
    }

    public final String A0k() {
        return this.A0D;
    }

    public final String A0l() {
        return this.A0E;
    }

    public final String A0m() {
        return this.A0G;
    }

    public final String A0n() {
        return this.A0H;
    }

    public final String A0o() {
        return this.A0I;
    }

    public final String A0p() {
        return this.A0J;
    }

    public final String A0q() {
        return this.A0K;
    }

    public final String A0r() {
        return this.A0L;
    }

    public final String A0s() {
        return this.A0M;
    }

    public final String A0t() {
        return this.A0N;
    }

    public final JSONObject A0u() {
        try {
            return new JSONObject(this.A0F);
        } catch (JSONException unused) {
            return new JSONObject();
        }
    }

    public final void A0v(int i) {
        this.A02 = i;
    }

    public final void A0w(long j) {
        this.A06 = j;
    }

    public final void A0x(RewardData rewardData) {
        this.A07 = rewardData;
    }

    public final void A0y(String str) {
        A0o = str;
    }

    public final void A0z(String str) {
        this.A0A = str;
    }

    public final void A10(String str) {
        this.A0B = str;
    }

    public final void A11(String str) {
        this.A0M = str;
    }

    public final void A12(JSONObject jSONObject) {
        String strA01 = A01(1077, 10, 14);
        String strA02 = A01(0, 0, 51);
        A09(jSONObject.optString(strA01, strA02));
        A08(jSONObject.optString(A01(636, 13, 35)));
        A0G(jSONObject);
        A04(jSONObject.optInt(A01(1176, 31, 101), 0));
        A0v(jSONObject.optInt(A01(IronSourceConstants.RV_INSTANCE_AVAILABILITY_TRUE, 26, 64), 1000));
        A07(jSONObject.optString(A01(610, 26, 33), strA02));
        A0J(jSONObject.optBoolean(A01(465, 23, 120), false));
        A0K(jSONObject.optBoolean(A01(488, 37, 96), false));
        A0H(jSONObject.optBoolean(A01(206, 32, 43), false));
        A0I(jSONObject.optBoolean(A01(401, 27, 97), false));
        A0Q(jSONObject.optBoolean(A01(1025, 52, 59), false));
        A0N(jSONObject.optBoolean(A01(753, 30, 32), false));
        A0A(jSONObject.optString(A01(719, 34, 83), A01(78, 65, 100)));
        A0P(jSONObject.optBoolean(A01(960, 18, 30), false));
        A0M(jSONObject.optBoolean(A01(694, 25, 68), false));
        A0L(jSONObject.optBoolean(A01(672, 22, 75), false));
        A0E(jSONObject.optString(A01(978, 16, 102), A01(0, 15, 55)));
        A0S(jSONObject.optBoolean(A01(175, 31, 99), false));
        A0R(jSONObject.optBoolean(A01(1161, 15, 41), false));
        A0C(jSONObject.optString(A01(912, 26, 115), A01(43, 15, 7)));
        A0F(jSONObject.optString(A01(994, 31, 67), A01(58, 20, 107)));
        A0D(jSONObject.optString(A01(938, 22, 51), A01(15, 28, 75)));
        A0B(jSONObject.optString(A01(1087, 19, 46), A01(143, 32, 14)));
        this.A0Q = jSONObject.optBoolean(A01(578, 14, 34));
        this.A0R = jSONObject.optBoolean(A01(592, 18, 19));
        this.A0P = jSONObject.optBoolean(A01(551, 27, 94), true);
        this.A0j = jSONObject.optBoolean(A01(1339, 25, 87), false);
        this.A01 = jSONObject.optInt(A01(1364, 34, 5), -1);
        this.A0k = jSONObject.optBoolean(A01(1398, 42, 14), false);
        this.A0i = jSONObject.optBoolean(A01(IronSourceConstants.RV_AD_UNIT_CAPPED, 36, 11), false);
        this.A0b = jSONObject.optBoolean(A01(783, 28, Sdk.SDKError.Reason.INVALID_LOG_ERROR_ENDPOINT_VALUE), false);
        this.A0E = jSONObject.optString(A01(823, 21, Sdk.SDKError.Reason.TPAT_ERROR_VALUE), strA02);
        A06(jSONObject.optLong(A01(379, 22, 74), -1L));
        A05(jSONObject.optLong(A01(IronSourceError.ERROR_AD_FORMAT_CAPPED, 26, 57), -1L));
        A03(jSONObject.optDouble(A01(873, 18, 7), 1.0d));
        if (TextUtils.isEmpty(this.A0E)) {
            this.A0E = C1589Fo.A00();
        }
        this.A0N = jSONObject.optString(A01(1120, 41, 68), A01(238, Sdk.SDKError.Reason.TPAT_ERROR_VALUE, 32));
        this.A0C = jSONObject.optString(A01(649, 23, 45), A01(897, 15, 36));
        this.A0c = jSONObject.optBoolean(A01(844, 29, Sdk.SDKError.Reason.JSON_ENCODE_ERROR_VALUE), false);
        this.A0h = jSONObject.optBoolean(A01(1233, 30, 28), false);
        this.A0g = jSONObject.optBoolean(A01(1263, 40, 83), false);
    }

    public final void A13(boolean z) {
        this.A0W = z;
    }

    public final void A14(boolean z) {
        this.A0d = z;
    }

    public final void A15(boolean z) {
        this.A0O = z;
    }

    public final boolean A16() {
        return this.A0Q;
    }

    public final boolean A17() {
        return this.A0R;
    }

    public final boolean A18() {
        return this.A0P;
    }

    public final boolean A19() {
        return this.A0U;
    }

    public final boolean A1A() {
        return this.A0V;
    }

    public final boolean A1B() {
        return this.A0W;
    }

    public final boolean A1C() {
        return this.A0X;
    }

    public final boolean A1D() {
        return this.A0Y;
    }

    public final boolean A1E() {
        return this.A0Z;
    }

    public final boolean A1F() {
        return !TextUtils.isEmpty(A0f());
    }

    public final boolean A1G() {
        return this.A0S;
    }

    public final boolean A1H() {
        return this.A0T;
    }

    public final boolean A1I() {
        return this.A0a;
    }

    public final boolean A1J() {
        return this.A0b;
    }

    public final boolean A1K() {
        return this.A0c;
    }

    public final boolean A1L() {
        return this.A0l;
    }

    public final boolean A1M() {
        return this.A0d;
    }

    public final boolean A1N() {
        return this.A0m;
    }

    public final boolean A1O() {
        return this.A0O;
    }

    public final boolean A1P() {
        return this.A0f;
    }

    public final boolean A1Q() {
        return this.A0g;
    }

    public final boolean A1R() {
        return this.A0h;
    }

    public final boolean A1S() {
        return this.A0i;
    }

    public final boolean A1T() {
        return this.A0j;
    }

    public final boolean A1U() {
        return this.A0k;
    }
}
