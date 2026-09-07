package com.facebook.ads.redexgen.core;

import android.text.TextUtils;
import android.widget.FrameLayout;
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Gj, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1610Gj extends FrameLayout {
    public static byte[] A0L;
    public static String[] A0M = {"nL4f6tElOIWkWIMY", "pafc", "mmt", "r2KL", "cPD1EcNrMsc9Il", "HjHry0SxIHtlyHB0wW8GJ6CkWWRugdPq", "pjLQgfnHLp272wJByK44k5CENQyu64qM", "USuv5isgmNE5xLLzg"};
    public IP A00;
    public boolean A01;
    public boolean A02;
    public boolean A03;
    public boolean A04;
    public final AbstractC2855md A05;
    public final C14067t A06;
    public final C2699k1 A07;
    public final AF A08;
    public final DR A09;
    public final EC A0A;
    public final InterfaceC1609Gi A0B;
    public final C2237cQ A0C;
    public final C2232cL A0D;
    public final C1706Kb A0E;
    public final AbstractC2214c3 A0F;
    public final AbstractC2212c1 A0G;
    public final AbstractC2208bx A0H;
    public final AbstractC2206bv A0I;
    public final AbstractC2204bt A0J;
    public final AbstractC2203bs A0K;

    public static String A02(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0L, i, i + i2);
        int i4 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            if (A0M[0].length() != 16) {
                throw new RuntimeException();
            }
            A0M[0] = "7kRjpWt7kPSYf5Zn";
            if (i4 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 13);
            i4++;
        }
    }

    public static void A0C() {
        A0L = new byte[]{-112, -94, -97, -97, -110, -101, -95, -127, -106, -102, -110, -81, -64, -67, -84, -65, -76, -70, -71, -20, -12, -13, -28, -29, -14, -29, -9, -11, -25, -26, -60, -5, -41, -11, -25, -12, -19, -17, -20, -28, -17, -30, -16, -16};
    }

    static {
        A0C();
    }

    public C1610Gj(C2699k1 c2699k1, A7 a7, AbstractC2855md abstractC2855md, C14067t c14067t, AF af, DR dr, EC ec, InterfaceC1609Gi interfaceC1609Gi) {
        super(c2699k1);
        this.A0J = new LH(this);
        this.A0I = new LG(this);
        this.A0H = new LF(this);
        this.A0K = new LE(this);
        this.A0F = new LD(this);
        this.A0G = new LC(this);
        this.A03 = false;
        this.A04 = false;
        this.A02 = false;
        this.A01 = false;
        this.A07 = c2699k1;
        this.A05 = abstractC2855md;
        this.A06 = c14067t;
        this.A08 = af;
        this.A09 = dr;
        this.A0A = ec;
        this.A0D = new C2232cL(c2699k1);
        this.A0B = interfaceC1609Gi;
        this.A0D.setFunnelLoggingHandler(af);
        this.A0D.getEventBus().A03(this.A0J, this.A0I, this.A0H, this.A0K, this.A0F, this.A0G);
        this.A0E = new C1706Kb(c2699k1, a7, this.A0D, abstractC2855md.A1g());
        if (C14499m.A1t(this.A07)) {
            this.A0C = new C2237cQ(c2699k1, a7, this.A0D, abstractC2855md.A1g(), this.A0E, null);
        } else {
            this.A0C = null;
        }
        A0B();
        this.A0D.setVideoURI(this.A06.A0S(this.A05.A1b().A0F().A09()));
        A09();
        D3.A0K(this, this.A05.A1a().A01().A08(true));
        String videoUrl = abstractC2855md.A1b().A0F().A08();
        if (!TextUtils.isEmpty(videoUrl)) {
            AbstractC1587Fm.A00(c2699k1, this, videoUrl);
        }
        addView(this.A0D, new FrameLayout.LayoutParams(-1, -1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject A03() {
        return A04(this.A0D.getCurrentPositionInMillis());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject A04(int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(A02(0, 11, 32), i);
            jSONObject.put(A02(11, 8, 62), this.A0D.getDuration());
            jSONObject.put(A02(19, 5, 114), this.A0D.A0o());
            jSONObject.put(A02(24, 12, 117), this.A0D.A0q());
            return jSONObject;
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A07() {
        if (this.A02) {
            return;
        }
        this.A02 = true;
    }

    private void A08() {
        this.A0D.postDelayed(new C2415fK(this), C14499m.A0N(this.A07));
    }

    private void A09() {
        this.A0D.postDelayed(new C2414fJ(this), C14499m.A0O(this.A07));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0A() {
        this.A0B.AFZ(A02(36, 8, 112), A03());
    }

    private void A0B() {
        if (!TextUtils.isEmpty(this.A05.A1b().A0F().A08())) {
            KA ka = new KA(this.A07);
            this.A0D.A0h(ka);
            ka.setImage(this.A05.A1b().A0F().A08());
        }
        IX ix = new IX(this.A07, true, this.A08);
        this.A0D.A0h(ix);
        this.A0D.A0h(new C2182bX(ix, EnumC1658If.A02, true));
        this.A0D.A0h(new C1654Ib(this.A07));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0H(KX kx) {
        if (this.A0D.getState() == JI.A02 && C14499m.A1X(this.A07)) {
            this.A0D.postDelayed(new C2413fI(this, kx), 5000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0I(String str) {
        this.A07.A0F().A3Q(str);
        if (C14499m.A1Y(this.A07)) {
            A07();
        } else {
            this.A09.A4Z(this.A0A.A7r());
            this.A09.A4Z(this.A0A.A7m());
        }
    }

    public final void A0N() {
        this.A0D.setVolume(this.A05.A1b().A0F().A0A() ? 0.0f : 1.0f);
        this.A0D.A0g(IP.A02, 26);
        A08();
    }

    public final void A0O() {
        if (this.A0D != null) {
            if (!this.A02) {
                this.A0D.A0f(II.A03);
            }
            this.A0D.getEventBus().A04(this.A0J, this.A0I, this.A0H, this.A0K, this.A0F, this.A0G);
            this.A0D.A0Y();
        }
        if (this.A0C != null) {
            this.A0C.A05();
        }
        this.A0E.A0p();
    }

    public final void A0P() {
        this.A0D.A0d(9);
        D3.A0R(this);
        D3.A0F(this.A0D);
        D3.A0Z(this.A0D);
    }

    public final void A0Q() {
        this.A0D.A0f(II.A04);
    }

    public final void A0R(boolean z) {
        if (z) {
            this.A0D.setVolume(0.0f);
        } else {
            this.A0D.setVolume(1.0f);
        }
        A0A();
    }

    public final void A0S(boolean z) {
        if (this.A0D.A0p()) {
            return;
        }
        this.A00 = this.A0D.getVideoStartReason();
        this.A01 = z;
        this.A0D.A0k(false, 19);
    }

    public final void A0T(boolean z) {
        if (this.A0D.A0q() || this.A02 || this.A0D.getState() == JI.A06 || this.A00 == null) {
            return;
        }
        if (!this.A01 || z) {
            this.A0D.A0g(this.A00, 27);
        }
    }

    public final void A0U(boolean z) {
        this.A0D.A0k(z, 18);
    }

    public final void A0V(boolean z) {
        this.A0D.A0g(IP.A04, 25);
    }
}
