package com.facebook.ads.redexgen.core;

import android.content.Intent;
import android.provider.Settings;
import android.text.TextUtils;
import com.facebook.ads.AdError;
import com.facebook.ads.internal.util.activity.ActivityUtils;
import com.facebook.ads.internal.util.activity.AdActivityIntent;
import com.facebook.ads.internal.util.process.ProcessUtils;
import com.google.common.base.Ascii;
import com.vungle.ads.internal.protos.Sdk;
import java.util.Arrays;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class N0 extends AbstractC2859mh {
    public static C14067t A0D;
    public static byte[] A0E;
    public static String[] A0F = {"g9SdUg6XNSnvVCS02jX19aczyGq48qDV", "lGSQ9LsgX83H3UqklEPZgAjaPEKabNT0", "y0oXMo4BXc2on8MNFvJxgBv", "Ulfd9L14l0ScyK0QB689zsPu0EZ5wfqr", "W3xKKEfUMxBXJmvfztSkCM8j4ls7Vw3H", "lNYBpqeQZYlfeCveDiVEAZh", "rx8", "elj"};
    public long A00;
    public C2L A01;
    public C2M A02;
    public C2S A03;
    public C2699k1 A04;
    public BG A05;
    public C1618Gr A06;
    public String A07;
    public String A08;
    public String A09;
    public String A0A;
    public final String A0B = UUID.randomUUID().toString();
    public final AtomicBoolean A0C = new AtomicBoolean();

    public static String A05(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0E, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 51);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A09() {
        A0E = new byte[]{-98, -16, -14, -14, -12, -5, -12, 1, -2, -4, -12, 3, -12, 1, -18, 1, -2, 3, -16, 3, -8, -2, -3, -58, -45, -60, -58, -56, -39, -50, -37, -50, -39, -34, 1, 6, -1, 7, Ascii.FF, 3, 2, -33, 2, -30, -1, Ascii.DC2, -1, -32, 19, Ascii.FF, 2, 10, 3, Ascii.GS, Ascii.NAK, Ascii.DC4, Ascii.EM, 17, 36, Ascii.EM, Ascii.US, Ascii.RS, -12, 17, 36, 17, Ascii.DLE, Ascii.FF, 1, 3, 5, Ascii.CR, 5, Ascii.SO, Ascii.DC4, -23, 4, -68, -66, -79, -80, -79, -78, -75, -70, -79, -80, -101, -66, -75, -79, -70, -64, -83, -64, -75, -69, -70, -105, -79, -59, -17, -30, -18, -14, -30, -16, -15, -47, -26, -22, -30, -2, -15, 3, -19, -2, -16, -33, -15, -2, 2, -15, -2, -31, -34, -40, -13, -26, -8, -30, -13, -27, -26, -27, -41, -22, -27, -26, -16, -62, -27, -59, -30, -11, -30, -61, -10, -17, -27, -19, -26, Ascii.FS, Ascii.SI, 33, Ascii.VT, Ascii.FS, Ascii.SO, Ascii.SI, Ascii.SO, 9, 32, 19, Ascii.SO, Ascii.SI, Ascii.EM, -61, -68, -73, -65, -61, -77, -105, -78, -4, -17, -21, -3, -38, -1, -10, -21};
    }

    static {
        A09();
    }

    private void A07() {
        AnonymousClass42.A00(this.A04).A06(this.A02, this.A02.A00());
    }

    private void A08() {
        if (this.A02 != null) {
            try {
                AnonymousClass42.A00(this.A04).A05(this.A02);
            } catch (Exception unused) {
            }
        }
    }

    private void A0A(Intent intent) {
        int i = super.A00;
        String strA05 = A05(77, 24, 25);
        if (i != -1 && Settings.System.getInt(this.A04.getContentResolver(), A05(1, 22, 92), 0) != 1) {
            int i2 = super.A00;
            String[] strArr = A0F;
            if (strArr[4].charAt(19) == strArr[0].charAt(19)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0F;
            strArr2[5] = "RWC7frN5DjKRH0uo4BJmLzj";
            strArr2[2] = "FPcb0UYEDF6wwONX6Ty9E2F";
            intent.putExtra(strA05, i2);
            return;
        }
        C2699k1 c2699k1 = this.A04;
        String[] strArr3 = A0F;
        if (strArr3[7].length() == strArr3[6].length()) {
            String[] strArr4 = A0F;
            strArr4[5] = "O4w3do1khQsKhsE3USwlJ7C";
            strArr4[2] = "rALKIAVwphrvKmHx0hqaLzY";
            if (C14499m.A0g(c2699k1)) {
                return;
            }
        } else if (C14499m.A0g(c2699k1)) {
            return;
        }
        intent.putExtra(strA05, 6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0C(C2699k1 c2699k1, C2853mb c2853mb, int i) {
        if (i >= c2853mb.A1W()) {
            return;
        }
        C1769Mu c1769Mu = (C1769Mu) c2853mb.A1Z(i);
        A0D = new C14067t(c2699k1);
        A0D.A0d(new AF(c1769Mu.A1g(), c2699k1.A0A()));
        AnonymousClass36.A02(c2699k1, A0D, c1769Mu);
        A0D.A0W(new N1(this, i == 0, c2699k1, c1769Mu, c2853mb, i), new C13997m(c1769Mu.A0r(), A05(152, 14, Sdk.SDKError.Reason.JSON_ENCODE_ERROR_VALUE), i));
    }

    private void A0D(boolean z) {
        if (this.A05 == BG.A0F) {
            A0F(z);
            return;
        }
        if (this.A05 == BG.A0H) {
            A0G(z);
        } else if (this.A05 == BG.A0G) {
            A0E(z);
        } else {
            A0G(z);
        }
    }

    private void A0E(boolean z) {
        C14067t c14067t = new C14067t(this.A04);
        boolean z2 = C14499m.A28(this.A04) && C7J.A0A(this.A03.A0u());
        if (z2) {
            C7J unifiedAssetsLoader = new C7J(c14067t, this.A03.A0u(), this.A03.A0i(), this.A03.A0r(), z2, new C2868mq(this));
            c14067t.A0d(new AF(((AbstractC2855md) this.A03).A1g(), this.A04.A0A()));
            unifiedAssetsLoader.A0B();
            return;
        }
        AnonymousClass35.A02(this.A04, (AbstractC2855md) this.A03, z, new C2867mp(this));
    }

    private void A0F(boolean z) {
        C14067t c14067t = new C14067t(this.A04);
        c14067t.A0d(new AF(((AbstractC2855md) this.A03).A1g(), this.A04.A0A()));
        AnonymousClass36.A03(this.A04, c14067t, (C1769Mu) this.A03);
        c14067t.A0W(new C2872mu(this), new C13997m(this.A03.A0r(), A05(152, 14, Sdk.SDKError.Reason.JSON_ENCODE_ERROR_VALUE)));
    }

    private void A0G(boolean z) {
        boolean z2 = false;
        if (this.A03.A1B()) {
            C2853mb c2853mb = (C2853mb) this.A03;
            for (int i = 0; i < c2853mb.A1W(); i++) {
                if (TextUtils.isEmpty(c2853mb.A1Z(i).A1b().A0F().A09())) {
                    this.A01.AEz(this, AdError.INTERNAL_ERROR);
                    return;
                }
            }
            A0C(this.A04, c2853mb, 0);
            return;
        }
        C14067t c14067t = new C14067t(this.A04);
        c14067t.A0d(new AF(((AbstractC2855md) this.A03).A1g(), this.A04.A0A()));
        if (C14499m.A28(this.A04) && C7J.A0A(this.A03.A0u())) {
            z2 = true;
        }
        boolean zA1F = this.A03.A1F();
        if (z2) {
            C7J unifiedAssetsLoader = new C7J(c14067t, this.A03.A0u(), this.A03.A0i(), this.A03.A0r(), z2, new C2870ms(this, zA1F));
            unifiedAssetsLoader.A0B();
            return;
        }
        C1769Mu c1769Mu = (C1769Mu) this.A03;
        if (TextUtils.isEmpty(c1769Mu.A1b().A0F().A09())) {
            if (this.A05 == BG.A0I) {
                this.A04.A0F().ADf();
            }
            this.A01.AEz(this, AdError.INTERNAL_ERROR);
        } else {
            AnonymousClass36.A02(this.A04, c14067t, c1769Mu);
            c14067t.A0W(new N2(this, z, zA1F, c1769Mu, this), new C13997m(c1769Mu.A0r(), A05(152, 14, Sdk.SDKError.Reason.JSON_ENCODE_ERROR_VALUE)));
        }
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC2859mh
    public final int A0H() {
        if (this.A03 == null) {
            return -1;
        }
        return this.A03.A0Y();
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC2859mh
    public final C2S A0I() {
        return this.A03;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC2859mh
    public final boolean A0J() {
        C1489Bo cause;
        if (!this.A0C.get()) {
            return false;
        }
        this.A03.A0w(super.A01);
        String strA03 = I7.A03(super.A02, this.A0B, this.A07);
        this.A03.A0x(super.A02);
        this.A03.A11(strA03);
        AdActivityIntent adActivityIntentA05 = C1491Bq.A05(this.A04);
        adActivityIntentA05.putExtra(A05(174, 8, 83), this.A05);
        adActivityIntentA05.putExtra(A05(127, 25, 78), this.A03);
        adActivityIntentA05.putExtra(A05(34, 19, 107), this.A03);
        adActivityIntentA05.putExtra(A05(166, 8, 27), this.A0B);
        if (strA03 != null) {
            adActivityIntentA05.putExtra(A05(112, 15, 89), strA03);
        }
        adActivityIntentA05.putExtra(A05(66, 11, 109), this.A0A);
        adActivityIntentA05.putExtra(A05(101, 11, 74), this.A00);
        if (this.A09 != null) {
            adActivityIntentA05.putExtra(A05(53, 13, Sdk.SDKError.Reason.INVALID_METRICS_ENDPOINT_VALUE), this.A09);
        }
        A0A(adActivityIntentA05);
        if (!ProcessUtils.isRemoteRenderingProcess()) {
            adActivityIntentA05.setFlags(adActivityIntentA05.getFlags() | 268435456);
        }
        ActivityUtils.A03(this.A04);
        try {
            if (ProcessUtils.isRemoteRenderingProcess()) {
                if (!C1491Bq.A0I(this.A04, adActivityIntentA05)) {
                    this.A04.A0F().AHI();
                    if (this.A01 != null) {
                        this.A01.AEz(this, AdError.AD_PRESENTATION_ERROR);
                    }
                    return false;
                }
                return true;
            }
            C1491Bq.A0B(this.A04, adActivityIntentA05);
            return true;
        } catch (C1489Bo e) {
            String[] strArr = A0F;
            if (strArr[1].charAt(25) != strArr[3].charAt(25)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0F;
            strArr2[7] = "zr3";
            strArr2[6] = "zCM";
            if (e.getCause() != null) {
                cause = e;
                cause = e.getCause();
            }
            cause = e;
            this.A04.A08().AAu(A05(23, 11, 50), AbstractC14128a.A01, new C14138b(cause));
            return true;
        }
    }

    public final void A0K(C2699k1 c2699k1, C2L c2l, AnonymousClass38 anonymousClass38, boolean z, String str, String str2) {
        String strA05;
        this.A0C.set(false);
        this.A04 = c2699k1;
        this.A01 = c2l;
        this.A0A = anonymousClass38.A02();
        this.A00 = anonymousClass38.A00();
        this.A09 = str2;
        if (this.A0A != null) {
            String str3 = this.A0A;
            String strA06 = A05(0, 1, 12);
            String[] strArr = A0F;
            if (strArr[7].length() == strArr[6].length()) {
                String[] strArr2 = A0F;
                strArr2[7] = "x5W";
                strArr2[6] = "dMK";
                strA05 = str3.split(strA06)[0];
            }
            throw new RuntimeException();
        }
        strA05 = A05(0, 0, 100);
        this.A07 = strA05;
        this.A03 = C2S.A00(anonymousClass38.A03(), this.A04);
        this.A03.A0z(str);
        this.A03.A0v(anonymousClass38.A01().A06());
        if (this.A03.A1B()) {
            this.A08 = ((C2853mb) this.A03).A1c();
        } else {
            this.A08 = ((AbstractC2855md) this.A03).A1g();
        }
        if (this.A03.A1F()) {
            this.A05 = BG.A08;
            if (this.A03.A17()) {
                this.A04.A0F().AIz(EnumC12511r.A08);
            } else {
                this.A04.A0F().AIz(EnumC12511r.A0A);
            }
        } else {
            switch (this.A03.A0X()) {
                case 0:
                    this.A05 = BG.A0H;
                    this.A04.A0F().AIz(EnumC12511r.A0D);
                    break;
                case 1:
                    this.A05 = BG.A0G;
                    this.A04.A0F().AIz(EnumC12511r.A0C);
                    break;
                case 2:
                    this.A05 = BG.A05;
                    this.A04.A0F().AIz(EnumC12511r.A05);
                    break;
                case 3:
                    this.A05 = BG.A0F;
                    this.A04.A0F().AIz(EnumC12511r.A04);
                    break;
                case 4:
                    this.A05 = BG.A0I;
                    this.A04.A0F().AIz(EnumC12511r.A0E);
                    break;
            }
        }
        if (C14499m.A0u(c2699k1)) {
            C2S c2s = this.A03;
            String[] strArr3 = A0F;
            if (strArr3[4].charAt(19) != strArr3[0].charAt(19)) {
                String[] strArr4 = A0F;
                strArr4[4] = "c2SjyVfNFMTSQhwflPzyjFy3Fjr2snH4";
                strArr4[0] = "k4vT1WhZbJ1Mlr1eks5fTJscMmdnfo8D";
                if (c2s.A1B()) {
                    C2853mb c2853mb = (C2853mb) this.A03;
                    for (int iA1W = c2853mb.A1W() - 1; iA1W >= 0; iA1W--) {
                        AbstractC2855md abstractC2855mdA1Z = c2853mb.A1Z(iA1W);
                        if (AbstractC12591z.A06(this.A04, AbstractC12591z.A01(c2699k1, abstractC2855mdA1Z.A0u(), abstractC2855mdA1Z.A1g()), c2699k1.A0A())) {
                            this.A04.A0F().A4s();
                            c2853mb.A1e(iA1W);
                            return;
                        }
                    }
                    if (c2853mb.A1W() == 0) {
                        this.A01.AEz(this, AdError.NO_FILL);
                        return;
                    }
                } else if (AbstractC12591z.A06(this.A04, AbstractC12591z.A01(c2699k1, anonymousClass38.A03(), ((AbstractC2855md) this.A03).A1g()), c2699k1.A0A())) {
                    this.A04.A0F().A4s();
                    this.A01.AEz(this, AdError.NO_FILL);
                    return;
                }
            }
            throw new RuntimeException();
        }
        this.A02 = new C2M(this.A0B, this, c2l);
        A07();
        A0D(z);
    }

    @Override // com.facebook.ads.redexgen.core.AnonymousClass23
    public final String A7E() {
        return this.A08;
    }

    @Override // com.facebook.ads.redexgen.core.AnonymousClass23
    public final boolean AJQ() {
        return true;
    }

    @Override // com.facebook.ads.redexgen.core.AnonymousClass23
    public final void onDestroy() {
        A08();
    }
}
