package com.facebook.ads.redexgen.core;

import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.facebook.ads.AdExperienceType;
import com.facebook.ads.internal.dynamicloading.DynamicLoaderFactory;
import com.facebook.ads.internal.dynamicloading.FlashPreferences;
import com.facebook.ads.internal.protocol.AdErrorType;
import com.facebook.ads.internal.util.process.ProcessUtils;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.vungle.ads.internal.protos.Sdk;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.mI, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbstractC2835mI implements B8 {
    public static byte[] A0D;
    public static String[] A0E = {"mx9sJqsz4sgJcdPgoYbgRIW9VnwzqRx6", "rFbyGWP2Ub8PQhtH", "vlmOFoI5eqS6Nw0ENJhYNh6o4BRmenqE", "", "JTMxf3amnDxIP84vbXSIdB2jgXN5bQ", "LkG9NIMCA2H26FKF", "xLNm9V1ZNmyFYJ5qhdZubuzSePd6Iimu", "7SoM7bEoo8CKfR8pxc6QG8O9JCd0xBEh"};
    public static final Handler A0F;
    public static final AnonymousClass28 A0G = null;
    public static final B9 A0H = null;
    public static final String A0I;
    public AnonymousClass23 A00;
    public AnonymousClass23 A01;
    public C14318t A04;
    public B6 A05;
    public B9 A06;
    public AnonymousClass24 A07;
    public final AnonymousClass37 A08;
    public final A7 A09;
    public final AnonymousClass28 A0A;
    public final C2699k1 A0B;
    public volatile boolean A0C;
    public long A03 = -1;
    public String A02 = null;

    public static String A07(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0D, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 95);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A08() {
        A0D = new byte[]{-58, -23, -26, -11, -7, -22, -9, -91, -23, -12, -22, -8, -91, -13, -12, -7, -91, -22, -3, -18, -8, -7, -14, Ascii.NAK, Ascii.DC2, 33, 37, Ascii.SYN, 35, -47, Ascii.SUB, 36, -47, Ascii.US, 38, Ascii.GS, Ascii.GS, -47, -39, Ascii.DC4, Ascii.EM, Ascii.DC2, Ascii.SUB, Ascii.US, -47, Ascii.US, 32, 37, -47, Ascii.GS, 32, Ascii.DC2, Ascii.NAK, Ascii.SYN, Ascii.NAK, -38, -56, -21, -24, -9, -5, -20, -7, -89, -16, -6, -89, -11, -4, -13, -13, -89, -81, -22, -17, -24, -16, -11, -20, -21, -80, -91, -56, -59, -44, -40, -55, -42, -124, -51, -41, -124, -46, -39, -48, -48, -124, -116, -46, -45, -124, -57, -52, -59, -51, -46, -115, 6, 41, 38, 53, 57, 42, 55, -27, 46, 56, -27, 51, 58, 49, 49, -27, 52, 51, -27, 56, 57, 38, 55, 57, 6, 41, -21, Ascii.FF, -67, 10, Ascii.FF, Ascii.SI, 2, -67, -2, 1, -67, 0, -2, Ascii.VT, 1, 6, 1, -2, 17, 2, Ascii.DLE, -53, -50, -23, -26, -27, -34, -105, -40, -37, -40, -25, -21, -36, -23, -105, -21, -16, -25, -36, -91, 63, 66, -2, 63, 74, 80, 67, 63, 66, 87, -2, 81, 82, 63, 80, 82, 67, 66, 47, 50, 65, -51, -36, -43, 62, 67, 60, 68, 73, 58, 75, 60, 77, 60, 72, 78, -50, -33, -29, -32, -13, -32, -50, -31, -23, -28, -30, -13, -97, -24, -14, -97, -19, -12, -21, -21, 19, Ascii.FS, 17, 32, 39, Ascii.RS, 34, 19, Ascii.DC2, Ascii.CR, Ascii.ETB, Ascii.DC2, 60, 69, 77, SignedBytes.MAX_POWER_OF_TWO, 73, 70, 69, 68, 60, 69, 75, -9, SignedBytes.MAX_POWER_OF_TWO, 74, -9, 60, 68, 71, 75, 80, 51, 57, 46, SignedBytes.MAX_POWER_OF_TWO, 53, 44, 48, 60, 59, 51, 54, 52, Ascii.NAK, 33, Ascii.DC4, 32, 36, Ascii.DC4, Ascii.GS, Ascii.DC2, 40, Ascii.SO, Ascii.DC2, Ascii.DLE, Ascii.US, Ascii.US, Ascii.CAN, Ascii.GS, Ascii.SYN, -3, 2, 10, -11, 0, -3, -8, -76, 4, 0, -11, -9, -7, 1, -7, 2, 8, -76, -3, 2, -76, 6, -7, 7, 4, 3, 2, 7, -7, 36, 39, Ascii.EM, Ascii.FS, Ascii.ETB, 44, 33, 37, Ascii.GS, Ascii.ETB, 37, 43, 17, 4, Ascii.DLE, Ascii.DC4, 4, Ascii.DC2, 19, -2, 8, 3, 10, 5, -7, -10, 9, -6, -12, 9, -2, 2, -6, 8, 9, -10, 2, 5};
    }

    public abstract void A0P();

    public abstract void A0R(AnonymousClass23 anonymousClass23, C14318t c14318t, C14298r c14298r, AnonymousClass38 anonymousClass38);

    static {
        A08();
        D5.A02();
        A0I = AbstractC2835mI.class.getSimpleName();
        A0F = new Handler(Looper.getMainLooper());
    }

    public AbstractC2835mI(C2699k1 c2699k1, AnonymousClass37 anonymousClass37) {
        this.A0B = c2699k1;
        this.A08 = anonymousClass37;
        if (A0H != null) {
            this.A06 = A0H;
        } else {
            this.A06 = new B9(this.A0B);
        }
        this.A06.A0R(this);
        if (A0G != null) {
            this.A0A = A0G;
        } else {
            this.A0A = new AnonymousClass28();
        }
        DynamicLoaderFactory.makeLoader(this.A0B).getInitApi().onAdLoadInvoked(this.A0B);
        this.A09 = c2699k1.A0A();
        this.A0B.A0F().A5U();
    }

    private void A09(C14318t c14318t) {
        if (ProcessUtils.isRemoteRenderingProcess()) {
            return;
        }
        SharedPreferences sharedPreferences = FlashPreferences.getSharedPreferences(this.A0B);
        if (c14318t.A0C() != null) {
            sharedPreferences.edit().putString(A07(262, 12, 110), c14318t.A0C()).putLong(A07(342, 16, 54), System.currentTimeMillis()).apply();
            return;
        }
        sharedPreferences.edit().clear().apply();
    }

    private void A0A(C14318t c14318t) {
        this.A0B.A0F().AIY(c14318t.A0H());
    }

    private void A0B(C2602iR c2602iR) {
        C14318t placement = c2602iR.A00();
        if (placement == null || placement.A05() == null) {
            String strA07 = A07(291, 29, 53);
            C1468Ag error = new C1468Ag(AdErrorType.NO_AD_PLACEMENT, strA07);
            this.A0B.A0F().A5W(error.A03().getErrorCode(), strA07);
            if (this.A07 != null) {
                this.A07.A0G(error);
                return;
            }
            return;
        }
        this.A04 = placement;
        this.A00 = null;
        C14318t c14318t = this.A04;
        JSONObject jSONObjectA0E = c14318t.A0E();
        String strA08 = A07(195, 3, 13);
        if (jSONObjectA0E == null) {
            C14298r c14298rA04 = c14318t.A04();
            if (!A0F(c14318t, c14298rA04)) {
                return;
            }
            if (this.A00 == null) {
                this.A0B.A08().AAu(strA08, AbstractC14128a.A0a, new C14138b(A07(81, 26, 5), c14298rA04.A02()));
                AD4(C1468Ag.A00(AdErrorType.INTERNAL_ERROR));
                return;
            }
            A0R(this.A00, c14318t, c14298rA04, new AnonymousClass38(c14298rA04.A04(), c14318t.A05(), this.A08.A0A, c14318t.A05().A0C()));
        } else {
            ArrayList arrayList = new ArrayList();
            C14298r c14298rA05 = c14318t.A04();
            do {
                if (arrayList.isEmpty()) {
                    if (A0F(c14318t, c14298rA05)) {
                        arrayList.add(c14298rA05);
                    } else {
                        return;
                    }
                } else if (A0E(c14298rA05)) {
                    arrayList.add(c14298rA05);
                }
                c14298rA05 = c14318t.A04();
            } while (c14298rA05 != null);
            AnonymousClass23 anonymousClass23 = this.A00;
            String[] strArr = A0E;
            if (strArr[7].charAt(26) != strArr[6].charAt(26)) {
                throw new RuntimeException();
            }
            A0E[2] = "ioxWOihgwDfBac41kTr6w1CF9LpRHapv";
            if (anonymousClass23 == null) {
                this.A0B.A08().AAu(strA08, AbstractC14128a.A0a, new C14138b(A07(56, 25, 40), ((C14298r) arrayList.get(0)).A02()));
                AD4(C1468Ag.A00(AdErrorType.INTERNAL_ERROR));
                return;
            }
            boolean z = false;
            try {
                if (arrayList.size() > 1 && this.A00 != null && this.A00.AJQ()) {
                    JSONObject jSONObject = new JSONObject();
                    JSONArray jSONArray = new JSONArray();
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        jSONArray.put(((C14298r) it.next()).A04());
                    }
                    jSONObject.put(A07(192, 3, 111), jSONArray);
                    jSONObject.put(A07(198, 12, Sdk.SDKError.Reason.INVALID_LOG_ERROR_ENDPOINT_VALUE), c14318t.A0E());
                    A0R(this.A00, c14318t, c14298rA05, new AnonymousClass38(jSONObject, c14318t.A05(), this.A08.A0A, c14318t.A05().A0C()));
                    z = true;
                }
            } catch (Exception unused) {
                z = false;
            }
            if (!z) {
                if (arrayList.isEmpty()) {
                    C1468Ag c1468AgA01 = C1468Ag.A01(AdErrorType.NO_FILL, A07(0, 0, 103));
                    this.A0B.A0F().A5W(c1468AgA01.A03().getErrorCode(), A07(Sdk.SDKError.Reason.OMSDK_JS_WRITE_FAILED_VALUE, 22, 62));
                    if (this.A07 != null) {
                        this.A07.A0G(c1468AgA01);
                        return;
                    }
                    return;
                }
                if (this.A00 == null) {
                    this.A0B.A08().AAu(strA08, AbstractC14128a.A0a, new C14138b(A07(22, 34, 82), ((C14298r) arrayList.get(0)).A02()));
                    AD4(C1468Ag.A00(AdErrorType.INTERNAL_ERROR));
                    return;
                }
                C14298r c14298r = (C14298r) arrayList.get(0);
                A0R(this.A00, c14318t, c14298r, new AnonymousClass38(c14298r.A04(), c14318t.A05(), this.A08.A0A, c14318t.A05().A0C()));
            }
        }
        A09(placement);
        A0A(placement);
    }

    private final void A0C(String str, AdExperienceType adExperienceType) {
        this.A0B.A0F().A5X(str != null);
        this.A03 = System.currentTimeMillis();
        try {
            C1476Aq bidPayload = new C1476Aq(this.A0B, str, this.A08.A0A, this.A08.A09);
            this.A05 = this.A08.A00(this.A0B, bidPayload, adExperienceType);
            if (this.A06 != null) {
                this.A06.A0Q(this.A05);
            }
        } catch (C1469Ah e) {
            AD4(C1468Ag.A02(e));
        }
    }

    private void A0D(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.A02 = jSONObject.optString(A07(230, 12, 79));
            C2A.A01(this.A0B).A0O(jSONObject);
        }
    }

    private boolean A0E(C14298r c14298r) {
        return (c14298r == null || c14298r.A04() == null) ? false : true;
    }

    private boolean A0F(C14318t c14318t, C14298r c14298r) {
        String strA07 = A07(0, 0, 103);
        if (c14298r == null) {
            C1468Ag c1468AgA01 = C1468Ag.A01(AdErrorType.NO_FILL, strA07);
            this.A0B.A0F().A5W(c1468AgA01.A03().getErrorCode(), A07(Sdk.SDKError.Reason.OMSDK_JS_WRITE_FAILED_VALUE, 22, 62));
            if (this.A07 != null) {
                this.A07.A0G(c1468AgA01);
            }
            return false;
        }
        String strA02 = c14298r.A02();
        AnonymousClass23 anonymousClass23A00 = this.A0A.A00(this.A0B, c14318t.A05().A0D());
        if (anonymousClass23A00 == null) {
            this.A0B.A08().AAu(A07(195, 3, 13), AbstractC14128a.A0a, new C14138b(A07(0, 22, 38), strA02));
            AD4(C1468Ag.A00(AdErrorType.INTERNAL_ERROR));
            return false;
        }
        if (!this.A08.A01().contains(anonymousClass23A00.A8a())) {
            C1468Ag c1468AgA02 = C1468Ag.A01(AdErrorType.INTERNAL_ERROR, strA07);
            this.A0B.A0F().A5W(c1468AgA02.A03().getErrorCode(), A07(155, 19, 24));
            if (this.A07 != null) {
                AnonymousClass24 anonymousClass24 = this.A07;
                if (A0E[0].length() != 32) {
                    throw new RuntimeException();
                }
                String[] strArr = A0E;
                strArr[7] = "XDVsCbJ3K5v8dlUMGtS0uKtjThdAM1fs";
                strArr[6] = "AXbWkB0jI9efrJtSTWvCCcVR8Wd1ee9G";
                anonymousClass24.A0G(c1468AgA02);
            }
            return false;
        }
        this.A00 = anonymousClass23A00;
        JSONObject jSONObjectA04 = c14298r.A04();
        if (jSONObjectA04 != null) {
            String strOptString = jSONObjectA04.optString(A07(332, 10, 64));
            this.A0B.A0F().AIq(strOptString);
            this.A0B.A0D(strOptString);
            C2698k0 c2698k0A00 = AnonymousClass84.A00();
            if (c2698k0A00 != null) {
                c2698k0A00.A0D(strOptString);
            }
            JSONObject dataObject = jSONObjectA04.optJSONObject(A07(274, 17, 80));
            A0D(dataObject);
            if (this.A05 == null) {
                String strA08 = A07(242, 20, 120);
                C1468Ag c1468AgA03 = C1468Ag.A01(AdErrorType.UNKNOWN_ERROR, strA08);
                this.A0B.A0F().A5W(c1468AgA03.A03().getErrorCode(), strA08);
                if (this.A07 != null) {
                    this.A07.A0G(c1468AgA03);
                }
                return false;
            }
            return true;
        }
        String strA09 = A07(212, 18, 32);
        C1468Ag c1468AgA04 = C1468Ag.A01(AdErrorType.UNKNOWN_ERROR, strA09);
        this.A0B.A0F().A5W(c1468AgA04.A03().getErrorCode(), strA09);
        if (this.A07 != null) {
            this.A07.A0G(c1468AgA04);
        }
        return false;
    }

    public final long A0G() {
        if (this.A04 != null) {
            return this.A04.A03();
        }
        String[] strArr = A0E;
        if (strArr[7].charAt(26) != strArr[6].charAt(26)) {
            throw new RuntimeException();
        }
        A0E[2] = "cOTrI9DB0oxjTyLR1voyMrEgWVbVphTL";
        return -1L;
    }

    public final Handler A0H() {
        return A0F;
    }

    public C2S A0I() {
        if (this.A01 != null) {
            AnonymousClass23 anonymousClass23 = this.A01;
            if (A0E[2].charAt(15) == 'D') {
                return ((AbstractC2859mh) anonymousClass23).A0I();
            }
            A0E[0] = "oRXWb94touLPnP0lmqQIoCQNN81QkmVq";
            return ((AbstractC2859mh) anonymousClass23).A0I();
        }
        String[] strArr = A0E;
        if (strArr[3].length() == strArr[4].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0E;
        strArr2[7] = "c4mFc8cvcfHQyghvzrB7bYP2aMdrhGND";
        strArr2[6] = "OOjdStzIF6ducmayoMT1WxOsFGdjLtMG";
        return null;
    }

    public final C14328u A0J() {
        if (this.A04 == null) {
            return null;
        }
        return this.A04.A05();
    }

    public final void A0K() {
        if (!C14499m.A1o(this.A0B)) {
            return;
        }
        AnonymousClass23 anonymousClass23 = this.A01;
        String[] strArr = A0E;
        if (strArr[3].length() == strArr[4].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0E;
        strArr2[3] = "";
        strArr2[4] = "YS2d1pFjROLoYd3yH38ADYRoaACmCS";
        if (anonymousClass23 != null) {
            C1485Bh.A00(this.A0B).A0D(this.A01.A8a().toString(), this.A01.A7E());
        }
        if (this.A06 != null) {
            this.A06.A0R(null);
            this.A06 = null;
        }
        this.A07 = null;
        this.A00 = null;
        this.A01 = null;
    }

    public final void A0L() {
        String strA7E;
        this.A0B.A0F().A3H(C1517Cu.A01(this.A03));
        if (this.A01 == null || (strA7E = this.A01.A7E()) == null) {
            return;
        }
        HashMap map = new HashMap();
        String strA05 = C1517Cu.A05(this.A03);
        String clientToken = A07(320, 12, 89);
        map.put(clientToken, strA05);
        new AF(strA7E, this.A09).A04(AE.A08, map);
    }

    public final void A0M() {
        AnonymousClass23 anonymousClass23 = this.A01;
        String strA07 = A07(195, 3, 13);
        if (anonymousClass23 == null) {
            String strA08 = A07(107, 26, 102);
            this.A0B.A08().AAu(strA07, AbstractC14128a.A0Q, new C14138b(strA08));
            AdErrorType adErrorType = AdErrorType.INTERNAL_ERROR;
            this.A0B.A0F().A5W(adErrorType.getErrorCode(), strA08);
            if (this.A07 != null) {
                AnonymousClass24 anonymousClass24 = this.A07;
                String errorMessage = adErrorType.getDefaultErrorMessage();
                anonymousClass24.A0G(C1468Ag.A01(adErrorType, errorMessage));
            }
            this.A0B.A0F().A5Z();
            return;
        }
        if (this.A0C) {
            String strA09 = A07(174, 18, 127);
            this.A0B.A08().AAu(strA07, AbstractC14128a.A0M, new C14138b(strA09));
            AdErrorType adErrorType2 = AdErrorType.AD_ALREADY_STARTED;
            this.A0B.A0F().A5W(adErrorType2.getErrorCode(), strA09);
            if (this.A07 != null) {
                AnonymousClass24 anonymousClass25 = this.A07;
                String errorMessage2 = adErrorType2.getDefaultErrorMessage();
                anonymousClass25.A0G(C1468Ag.A01(adErrorType2, errorMessage2));
            }
            this.A0B.A0F().A5Y();
            return;
        }
        if (!TextUtils.isEmpty(this.A01.A7E())) {
            this.A09.ABN(this.A01.A7E());
        }
        this.A0B.A0F().A5a();
        this.A0C = true;
        A0P();
    }

    public final void A0N() {
        A0Y(false);
    }

    public final void A0O() {
        if (this.A02 != null) {
            C2A.A01(this.A0B).A0N(this.A02);
        }
    }

    public final void A0Q(AnonymousClass23 anonymousClass23) {
        if (anonymousClass23 != null) {
            anonymousClass23.onDestroy();
        }
    }

    public final void A0S(AnonymousClass24 anonymousClass24) {
        this.A07 = anonymousClass24;
    }

    public final void A0T(AnonymousClass38 anonymousClass38) {
        A0V(anonymousClass38.A03().optString(A07(210, 2, 12)));
    }

    public void A0U(String str) {
        A0C(str, null);
    }

    public final void A0V(String str) {
        this.A0B.A0F().A5T();
        if (!TextUtils.isEmpty(str)) {
            new AF(str, this.A09).A04(AE.A04, null);
        }
    }

    public final void A0W(String str) {
        A0U(str);
    }

    public final void A0X(String str, AdExperienceType adExperienceType) {
        A0C(str, adExperienceType);
    }

    public void A0Y(boolean z) {
        if (!z && !this.A0C) {
            return;
        }
        this.A0B.A0F().A5b();
        A0Q(this.A01);
        this.A0C = false;
    }

    public final boolean A0Z() {
        return this.A04 == null || this.A04.A0I();
    }

    @Override // com.facebook.ads.redexgen.core.B8
    public final synchronized void AD4(C1468Ag c1468Ag) {
        A0H().post(new C2836mJ(this, c1468Ag));
    }

    @Override // com.facebook.ads.redexgen.core.B8
    public final synchronized void AFG(C2602iR c2602iR) {
        try {
            A0B(c2602iR);
        } catch (Exception e) {
            this.A0B.A08().AAu(A07(195, 3, 13), AbstractC14128a.A0T, new C14138b(e));
        }
    }
}
