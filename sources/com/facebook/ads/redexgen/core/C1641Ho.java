package com.facebook.ads.redexgen.core;

import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebSettings;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.vungle.ads.internal.protos.Sdk;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.io.encoding.Base64;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ho, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1641Ho extends FrameLayout {
    public static byte[] A0C;
    public static String[] A0D = {"5vYLtEaU9MAxDoI06TlJjFfWs8tiaGj", "TX23sib3Tj6X7eJy5cgYAILp0vVPLOiW", "Lxz50jZMaNdiu", "yIxUapHBf", "xsW4qvb7U5EMj5cNQbMl14i5qh6u6uOh", "8XLPt3rjq6gnj0Cd96o3z24ZTqMdgzej", "IIODaFrLnzdPntRGftRJpuPC", "ODWlzaCdU1siup4vWOfVQK22DnthNinE"};
    public static final float A0E;
    public static final RelativeLayout.LayoutParams A0F;
    public int A00;
    public long A01;
    public InterfaceC1639Hm A02;
    public Map<String, String> A03;
    public final AbstractC2855md A04;
    public final C12752p A05;
    public final C2699k1 A06;
    public final A7 A07;
    public final F4 A08;
    public final C2496ge A09;
    public final AtomicBoolean A0A;
    public final AtomicBoolean A0B;

    public static String A06(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0C, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 9);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A09() {
        String[] strArr = A0D;
        if (strArr[1].charAt(1) != strArr[5].charAt(1)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0D;
        strArr2[7] = "Af0WM9g7Nak7nSkWG18ndsMVC8MahONd";
        strArr2[4] = "VergmF1iO6RBn6aZ7U2vBdquKGl77VZm";
        A0C = new byte[]{54, Ascii.DC2, 32, Ascii.FS, 17, 9, 17, Ascii.DC2, Ascii.FS, Ascii.NAK, 49, Ascii.DC4, 19, 34, 49, 48, 42, 45, 36, 99, 38, 49, 49, 44, 49, 68, 120, 117, 109, 117, 118, 120, 113, 52, 112, 123, 87, 96, 117, 87, 120, 125, 119, 127, 52, 96, 102, 125, 115, 115, 113, 102, 113, 112, 52, 99, 125, 96, 124, 52, 100, 102, 113, 57, 113, 98, 113, 122, 96, 52, 119, 120, 125, 119, 127, 103, 52, 119, 123, 97, 122, 96, 52, 117, 122, 112, 52, 80, 113, 120, 117, 109, Ascii.CR, 49, 60, 36, 60, 63, 49, 56, Ascii.FS, 57, 46, Ascii.VT, 52, 56, 42, 114, 117, 119, 121, 126, 48, 124, 127, 113, 116, 121, 126, 119, 48, 98, 117, 125, 127, 100, 117, 48, 96, 124, 113, 105, 113, 114, 124, 117, 34, 45, 40, 34, 42, 50, 5, 4, Ascii.CR, 0, Ascii.CAN, 114, 110, 99, 123, 99, 96, 110, 103, 52, 40, 37, Base64.padSymbol, 37, 38, 40, 33, Ascii.ESC, 54, 33, 41, 43, 48, 33, 95, 72, SignedBytes.MAX_POWER_OF_TWO, 66, 89, 72, 114, 94, 72, 94, 94, 68, 66, 67, 114, 68, 73, 78, 85, 81, 95, 84, 119, 101, 98, 95, 118, 105, 101, 119};
    }

    static {
        A09();
        A0E = (int) (CP.A02 * 4.0f);
        A0F = new RelativeLayout.LayoutParams(-1, -1);
    }

    public C1641Ho(C2699k1 c2699k1, AbstractC2855md abstractC2855md, C12752p c12752p, A7 a7, InterfaceC1639Hm interfaceC1639Hm, Map<String, String> playableMetricsData) {
        super(c2699k1);
        this.A0A = new AtomicBoolean(false);
        this.A0B = new AtomicBoolean(false);
        this.A01 = -1L;
        this.A00 = 0;
        this.A08 = new C1712Kh(this);
        this.A06 = c2699k1;
        this.A04 = abstractC2855md;
        this.A05 = c12752p;
        this.A07 = a7;
        this.A02 = interfaceC1639Hm;
        this.A03 = playableMetricsData;
        this.A09 = A04();
        if (this.A05.A0M() && !this.A05.A0O()) {
            A0B();
        }
        if (C14499m.A1s(this.A06)) {
            this.A06.A0B().AJs(this.A09, this.A04.A1g(), false);
        }
        addView(this.A09, A0F);
    }

    public static /* synthetic */ int A00(C1641Ho c1641Ho) {
        int i = c1641Ho.A00;
        c1641Ho.A00 = i + 1;
        return i;
    }

    private C2496ge A04() {
        C2496ge c2496ge = new C2496ge(this.A06, (WeakReference<F4>) new WeakReference(this.A08), 10, C14499m.A20(this.A06));
        c2496ge.setCornerRadius(A0E);
        c2496ge.setLogMultipleImpressions(false);
        c2496ge.setCheckAssetsByJavascriptBridge(false);
        c2496ge.setWebViewTimeoutInMillis(this.A05.A09());
        c2496ge.setRequestId(this.A04.A0r());
        c2496ge.setOnTouchListener(new ViewOnTouchListenerC1640Hn(this, null));
        WebSettings settings = c2496ge.getSettings();
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(true);
        settings.setAllowFileAccess(true);
        settings.setAllowFileAccessFromFileURLs(true);
        c2496ge.addJavascriptInterface(new C1642Hp(this.A06, this, this.A07, this.A03, this.A04.A1g()), A06(0, 12, Sdk.SDKError.Reason.TPAT_ERROR_VALUE));
        return c2496ge;
    }

    public final void A0A() {
        long jCurrentTimeMillis = System.currentTimeMillis() - this.A01;
        C14138b c14138b = new C14138b(A06(25, 67, 29));
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(A06(136, 6, 72), this.A00);
            jSONObject.put(A06(142, 5, 104), jCurrentTimeMillis);
            jSONObject.put(A06(187, 5, 51), this.A04.A1g());
        } catch (JSONException e) {
            Log.e(A06(92, 15, 84), A06(12, 13, 74), e);
        }
        c14138b.A07(jSONObject);
        c14138b.A05(1);
        C8Z c8zA08 = this.A06.A08();
        int i = AbstractC14128a.A2D;
        String strA06 = A06(147, 8, 11);
        c8zA08.AAv(strA06, i, c14138b);
        this.A00 = 0;
        if (!C14499m.A1n(this.A06)) {
            if (this.A02 == null) {
                return;
            }
            this.A02.ACm();
            return;
        }
        if (jCurrentTimeMillis <= C14499m.A0K(this.A06)) {
            InterfaceC1639Hm interfaceC1639Hm = this.A02;
            String[] strArr = A0D;
            if (strArr[7].charAt(0) == strArr[4].charAt(0)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0D;
            strArr2[1] = "0XAlcIRGce3nNmobAWWNAzxTwWjfpKo1";
            strArr2[5] = "vX4VpuJxASYV4FwrDvVxGQ4QiWthZxUm";
            if (interfaceC1639Hm != null) {
                this.A02.ACm();
                return;
            }
            return;
        }
        c14138b.A05(0);
        this.A06.A08().AAu(strA06, AbstractC14128a.A2E, c14138b);
    }

    public final void A0B() {
        String strA0F;
        if (this.A05.A0O()) {
            C14138b c14138b = new C14138b(A06(107, 29, 25));
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(A06(170, 17, 36), this.A05.A0I());
                jSONObject.put(A06(187, 5, 51), this.A04.A1g());
            } catch (JSONException e) {
                String strA06 = A06(92, 15, 84);
                String strA07 = A06(12, 13, 74);
                String[] strArr = A0D;
                if (strArr[1].charAt(1) != strArr[5].charAt(1)) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A0D;
                strArr2[3] = "qKqF8GsLC";
                strArr2[6] = "yUBs4wOBB81EmWZp6CsNCuI0";
                Log.e(strA06, strA07, e);
            }
            c14138b.A07(jSONObject);
            c14138b.A05(1);
            C8Z c8zA08 = this.A06.A08();
            int i = AbstractC14128a.A2G;
            String strA08 = A06(155, 15, 77);
            c8zA08.AAv(strA08, i, c14138b);
            if (C14499m.A0q(this.A06) && AbstractC1515Cs.A00(this.A06) == EnumC1514Cr.A07) {
                this.A06.A08().AAv(strA08, AbstractC14128a.A2F, c14138b);
                this.A08.AD9(0, null);
                String[] strArr3 = A0D;
                if (strArr3[1].charAt(1) != strArr3[5].charAt(1)) {
                    String[] strArr4 = A0D;
                    strArr4[7] = "eYeTyqsAvkMxTzxGPJMzaaOJBs1WoRUE";
                    strArr4[4] = "DGSgvEgHkFrTWskIwQomZOyU4ros1fyW";
                    return;
                } else {
                    String[] strArr5 = A0D;
                    strArr5[1] = "QXwUk7ZcYbXDO6xLw92fyo5XHWgn18Du";
                    strArr5[5] = "iXthj0ZXJZZP0QlicLBvNNfJ4d5EWvqr";
                    return;
                }
            }
        }
        try {
            C2496ge c2496ge = this.A09;
            if (!TextUtils.isEmpty(this.A05.A0C())) {
                strA0F = this.A05.A0C();
            } else {
                strA0F = this.A05.A0F();
            }
            c2496ge.loadUrl(strA0F);
        } catch (Exception e2) {
            this.A06.A08().AAu(A06(192, 8, 9), AbstractC14128a.A2f, new C14138b(e2));
        }
    }

    public final void A0C() {
        if (C14499m.A1s(this.A06)) {
            this.A06.A0B().AJZ(this.A09);
        }
        this.A09.removeJavascriptInterface(A06(0, 12, Sdk.SDKError.Reason.TPAT_ERROR_VALUE));
        this.A09.destroy();
    }

    public C1518Cv getTouchDataRecorder() {
        return this.A09.getTouchDataRecorder();
    }

    public JL getViewabilityChecker() {
        return this.A09.getViewabilityChecker();
    }

    public void setPlayableAdsViewListener(InterfaceC1639Hm interfaceC1639Hm) {
        this.A02 = interfaceC1639Hm;
    }
}
