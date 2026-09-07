package com.facebook.ads.redexgen.core;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.google.common.base.Ascii;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class LJ extends FrameLayout implements DS, InterfaceC2411fG {
    public static byte[] A0I;
    public static String[] A0J = {"UTx0mthy689a2sWy4JVu0tmbo5tf7DAX", "DpQrJfF4GGVCKG366ycalUQvQmaAeTpv", "eTaJ9UlZkoiVo78onrsfkh8qyWU6l07Y", "ASk", "tRl9yBUHWghtVC3MTlEkON1DGIMHt5L9", "IjjI8eijgHBxehc5IxL2bCSmbEZHlZYm", "ajbOHBl4KDnxYMWXO0J67", "uiq3lL8JcMvDgND3txStxUQziaPHduab"};
    public C13656e A00;
    public InterfaceC13716k A01;
    public InterfaceC1625Gy A02;
    public boolean A03;
    public boolean A04;
    public boolean A05;
    public final AbstractC2855md A06;
    public final C2699k1 A07;
    public final A7 A08;
    public final AF A09;
    public final ViewOnSystemUiVisibilityChangeListenerC1513Cq A0A;
    public final C1518Cv A0B;
    public final DR A0C;
    public final EC A0D;
    public final C1610Gj A0E;
    public final C1618Gr A0F;
    public final JK A0G;
    public final JL A0H;

    public static String A0B(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0I, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 44);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A0D() {
        A0I = new byte[]{Ascii.CAN, 47, 47, 50, 47, 125, 62, 47, 56, 60, 41, 52, 51, 58, 125, 62, 50, 51, 59, 52, 58, 125, Ascii.ETB, Ascii.SO, Ascii.DC2, 19, 78, 69, 76, 68, 67, 72, 73, 114, 76, 73, 36, 47, 38, 46, 41, 34, 35, Ascii.CAN, 38, 35, Ascii.CAN, 46, 41, 35, 34, 63, 46, 37, 44, 36, 35, 40, 41, Ascii.DC2, 44, 41, Ascii.DC2, 57, 34, 57, 44, 33, 91, 80, 89, 81, 86, 93, 92, 103, 76, 81, 85, 93, 103, 75, 72, 93, 86, 76, 35, 44, 41, 35, 43, Ascii.US, 51, 47, 53, 50, 35, 37, 74, 76, 90, 77, 92, 83, 86, 92, 84};
    }

    static {
        A0D();
    }

    public LJ(C2699k1 c2699k1, A7 a7, DR dr, AbstractC2855md abstractC2855md, EC ec, int i) {
        super(c2699k1);
        this.A01 = new C2443fm(this);
        this.A0G = new C2442fl(this);
        this.A03 = true;
        this.A07 = c2699k1;
        this.A08 = a7;
        this.A0C = dr;
        this.A06 = abstractC2855md;
        this.A0D = ec;
        C1618Gr c1618GrA02 = AbstractC1619Gs.A02(abstractC2855md.A0r());
        if (c1618GrA02 == null) {
            this.A0F = new C1618Gr(this.A07, abstractC2855md, a7, i);
            this.A04 = false;
        } else {
            this.A0F = c1618GrA02;
            this.A04 = true;
        }
        this.A09 = this.A0F.A0K();
        this.A0B = this.A0F.A0L();
        this.A0F.A0c(new C2430fZ(this));
        D3.A0E(1003, this.A0F.A0O());
        if (this.A06.A17()) {
            this.A0E = new C1610Gj(this.A07, this.A08, this.A06, new C14067t(this.A07), this.A09, this.A0C, this.A0D, new C2421fQ(this));
            this.A0E.A0N();
            this.A0F.A0O().setOnTouchListener(new ViewOnTouchListenerC1606Gf(this));
            addView(this.A0E, new FrameLayout.LayoutParams(-1, -1));
        } else {
            this.A0E = null;
        }
        ViewGroup mediaView = getMediaView();
        this.A0H = new JL(mediaView, 1, new WeakReference(this.A0G), this.A07);
        this.A0H.A0W(this.A06.A0U());
        this.A0H.A0X(this.A06.A0V());
        this.A0F.A0e(this.A0H);
        this.A0A = new ViewOnSystemUiVisibilityChangeListenerC1513Cq(this);
        this.A0A.A05(EnumC1512Cp.A02);
        setBackgroundColor(0);
        if (C14499m.A1s(c2699k1)) {
            c2699k1.A0B().AJu(mediaView, abstractC2855md.A1g(), false, false, true);
        }
        try {
            JSONObject jSONObject = new JSONObject();
            boolean zA1m = abstractC2855md.A1m();
            String strA0B = A0B(68, 18, 20);
            String strA0B2 = A0B(36, 16, 107);
            String strA0B3 = A0B(52, 16, 97);
            String strA0B4 = A0B(26, 10, 1);
            if (zA1m) {
                jSONObject.put(strA0B4, true);
                jSONObject.put(strA0B3, 2);
                jSONObject.put(strA0B2, 0);
                jSONObject.put(strA0B, this.A06.A0b());
            } else if (C6.A05(abstractC2855md.A0h())) {
                jSONObject.put(strA0B4, true);
                jSONObject.put(strA0B3, 2);
                jSONObject.put(strA0B2, 1);
                jSONObject.put(strA0B, this.A06.A0b());
            }
            this.A0F.A0j(jSONObject);
        } catch (JSONException unused) {
            this.A0F.A0M().A04(AbstractC14128a.A15, A0B(0, 26, 113));
        }
    }

    private void A0C() {
        HM hmA0F = new HK(this.A07, this.A06.A1b().A0G(), this.A06.A1e()).A0A(this.A06.A1a().A01()).A0F();
        addView(hmA0F, new FrameLayout.LayoutParams(-1, -1));
        hmA0F.A04(new C2419fO(this));
    }

    private final void A0E() {
        this.A0F.A0d(this);
        if (!this.A04) {
            this.A07.A0F().A5w();
            this.A0F.A0X();
        } else {
            this.A07.A0F().A5x();
            if (this.A0F.A0k()) {
                AJI();
                if (C14499m.A1s(this.A07)) {
                    this.A07.A0B().ACq();
                }
            }
        }
        ViewGroup viewGroup = (ViewGroup) this.A0F.A0O().getParent();
        if (viewGroup != null) {
            C1618Gr c1618Gr = this.A0F;
            String[] strArr = A0J;
            if (strArr[0].charAt(1) != strArr[2].charAt(1)) {
                throw new RuntimeException();
            }
            A0J[6] = "m5i7x933C7hHEFpC39NkE";
            ViewGroup parent = c1618Gr.A0O();
            viewGroup.removeView(parent);
        }
        addView(this.A0F.A0O(), new FrameLayout.LayoutParams(-1, -1));
        this.A0C.A3v(this, new RelativeLayout.LayoutParams(-1, -1));
        if (this.A06.A18()) {
            this.A0A.A05(EnumC1512Cp.A03);
        }
    }

    private void A0F(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        FQ fq = new FQ(this.A07, this.A0D.A7C(), this.A0H, this.A0B, this.A08, this.A06.A1c(), this.A0C);
        HashMap map = new HashMap();
        map.put(A0B(86, 12, 108), A0B(98, 9, 19));
        fq.A08(this.A06.A1g(), str, map);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2411fG
    public final void A9V() {
        A0F(this.A06.A1b().A0H().A05());
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2411fG
    public final void A9W(String str) {
        A0F(str);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2411fG
    public final void A9a() {
        this.A0C.A4Z(this.A0D.A6b());
        I7 serverSideRewardHandler = new I7(this.A07, this.A0D, this.A06.A0s(), this.A0C);
        serverSideRewardHandler.A05();
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2411fG
    public final void AAb() {
        new Handler(Looper.getMainLooper()).post(new C2420fP(this));
    }

    @Override // com.facebook.ads.redexgen.core.DS
    public final void AAj(Intent intent, Bundle bundle, C13656e c13656e) {
        C1618Gr.A0B().incrementAndGet();
        c13656e.A0A(this.A01);
        this.A00 = c13656e;
        A0E();
        if (this.A06.A1b().A0S()) {
            A0C();
        } else {
            this.A0F.A0W();
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2411fG
    public final void ADF() {
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2411fG
    public final void ADJ() {
        if (this.A0E != null) {
            this.A0E.A0P();
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2411fG
    public final void AE9(boolean z) {
        if (this.A0E != null) {
            this.A0E.A0R(z);
        }
    }

    @Override // com.facebook.ads.redexgen.core.DS
    public final void AEP(boolean z) {
        if (this.A0E != null) {
            this.A0E.A0S(z);
        }
        if (z) {
            this.A0F.A0Q();
        } else {
            this.A0F.A0T();
        }
    }

    @Override // com.facebook.ads.redexgen.core.DS
    public final void AEs(boolean z) {
        if (this.A0E != null) {
            this.A0E.A0T(z);
        }
        if (this.A03) {
            this.A03 = false;
        } else if (z) {
            this.A0F.A0P();
        } else {
            this.A0F.A0Y();
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2411fG
    public final void AF8() {
        if (this.A0E != null) {
            this.A0E.A0Q();
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2411fG
    public final void AFf(boolean z) {
        if (this.A0E != null) {
            this.A0E.A0U(z);
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2411fG
    public final void AFh(boolean z) {
        if (this.A0E != null) {
            this.A0E.A0V(z);
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2411fG
    public final void AFw(String str) {
        String urlString = this.A06.A1h(str);
        if (urlString == null) {
            return;
        }
        C2.A0M(new C2(), this.A07, C5.A00(urlString), this.A06.A1g());
    }

    @Override // com.facebook.ads.redexgen.core.DS
    public final void AI1(Bundle bundle) {
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2411fG
    public final void AJI() {
        if (!this.A05) {
            this.A0H.A0U();
            this.A05 = true;
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2411fG
    public final void close() {
        if (this.A00 == null) {
            return;
        }
        this.A00.finish(4);
    }

    @Override // com.facebook.ads.redexgen.core.DS
    public String getCurrentClientToken() {
        return this.A06.A1g();
    }

    private ViewGroup getMediaView() {
        if (this.A0E != null) {
            return this.A0E;
        }
        return this.A0F.A0O();
    }

    @Override // com.facebook.ads.redexgen.core.DS
    public final boolean onActivityResult(int i, int i2, Intent intent) {
        return false;
    }

    @Override // com.facebook.ads.redexgen.core.DS
    public final void onDestroy() {
        if (C14499m.A1s(this.A07)) {
            this.A07.A0B().AJZ(getMediaView());
        }
        C1610Gj c1610Gj = this.A0E;
        String[] strArr = A0J;
        if (strArr[4].charAt(27) != strArr[5].charAt(27)) {
            throw new RuntimeException();
        }
        A0J[6] = "GZe1biqFkGajjfTMFdC84";
        if (c1610Gj != null) {
            this.A0E.A0O();
        }
        this.A0A.A03();
        this.A08.AAr(this.A06.A1g(), new FB().A02(this.A0B).A03(this.A0H).A05());
        this.A01 = null;
        this.A02 = null;
        this.A00 = null;
        AbstractC1619Gs.A04(this.A06.A0r());
        C1618Gr.A0B().decrementAndGet();
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        requestDisallowInterceptTouchEvent(true);
        return super.onTouchEvent(motionEvent);
    }

    public void setListener(DR dr) {
    }

    public void setRtfActionsJavascriptListener(InterfaceC1625Gy interfaceC1625Gy) {
        this.A02 = interfaceC1625Gy;
    }
}
