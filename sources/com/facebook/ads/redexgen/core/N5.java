package com.facebook.ads.redexgen.core;

import android.content.res.Resources;
import android.widget.LinearLayout;
import com.facebook.ads.internal.protocol.AdErrorType;
import com.facebook.ads.internal.protocol.AdPlacementType;
import com.facebook.ads.internal.settings.AdInternalSettings;
import com.google.common.base.Ascii;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.UUID;
import org.json.JSONObject;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class N5<NativeViewabilityLogger> implements InterfaceC2887n9 {
    public static byte[] A0J;
    public static String[] A0K = {"NhwOmA8H17maQr2Thm3XPPVG1xwEsLhZ", "rranxCubAcBFDRhPr2LDrxoK3htxcyeL", "LmhV8", "ZLGOK7uKxyyp5W3sNEqoBEODv8zXcPE1", "dNK0bBZMrDk2YJmjrhSzlk1RMTFmUAsD", "q33l17MPfjO0fzYSahPh7EE95Ux5x03H", "4VfBn9Mh4W5rafl7A4va0uDeREUgOp63", "NLrbv196ww605txiYhOndsfSQjY"};
    public static final String A0L;
    public C2B A00;
    public C2C A01;
    public C2864mm A02;
    public C1772Mx A03;
    public M5 A04;
    public A7 A05;
    public EnumC1470Aj A06;
    public F4 A08;
    public C2496ge A09;
    public LI A0A;
    public JK A0B;
    public JL A0C;
    public String A0E;
    public final String A0I = UUID.randomUUID().toString();
    public boolean A0F = false;
    public boolean A0G = false;
    public boolean A0H = false;
    public C1518Cv A07 = new C1518Cv();
    public Boolean A0D = false;

    public static String A08(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0J, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 106);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A0B() {
        A0J = new byte[]{Ascii.FS, 40, 38, -25, Ascii.US, Ascii.SUB, Ascii.FS, Ascii.RS, Ascii.ESC, 40, 40, 36, -25, Ascii.SUB, Ascii.GS, 44, -25, Ascii.ESC, Ascii.SUB, 39, 39, Ascii.RS, 43, -25, Ascii.FS, 37, 34, Ascii.FS, 36, Ascii.RS, Ascii.GS, -15, -30, -11, -15, -84, -27, -15, -22, -23, -21, -22, -36, -93, -82};
    }

    static {
        A0B();
        A0L = N5.class.getSimpleName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.N5 != com.facebook.ads.internal.adapters.FacebookBannerAdapter<NativeViewabilityLogger> */
    public void A0A() {
        if (this.A00 != null && this.A0A != null && this.A03 != null && this.A03.A1F()) {
            this.A00.ACV(this, this.A0A);
        }
        if (this.A00 != null) {
            boolean z = this.A0F;
            if (A0K[1].charAt(21) == 'I') {
                throw new RuntimeException();
            }
            String[] strArr = A0K;
            strArr[6] = "pcQhCrMOoUvf1wSUiS8eXhj7G6bioSrh";
            strArr[4] = "JWZBC7ZhFf7k7YrTz5pa22tV9NT1Mc4w";
            if (z && (this.A0G || !this.A0H)) {
                C2B c2b = this.A00;
                if (A0K[3].charAt(25) != 'G') {
                    A0K[3] = "irPj8aYnTZH6GsdLYSbTyVfXBLXHQnPh";
                    c2b.ACV(this, this.A09);
                } else {
                    A0K[3] = "5PA9hoTjlgD01Tr6eTkR8jxCvDfXc2RO";
                    c2b.ACV(this, this.A09);
                }
            }
        }
        this.A04.A0F().A4E(this.A00 != null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.N5 != com.facebook.ads.internal.adapters.FacebookBannerAdapter<NativeViewabilityLogger> */
    public void A0C(int i, C14328u c14328u) {
        C2884n6 c2884n6 = new C2884n6(this);
        this.A0A = new LI(this.A04, this.A05, c2884n6, this.A03, A08(0, 31, 79), 2, this.A07);
        this.A0B = new C2883n5(this);
        this.A0C = new JL(this.A0A, c14328u.A04(), c14328u.A09(), true, new WeakReference(this.A0B), this.A04);
        this.A0C.A0W(this.A03.A0U());
        this.A0C.A0X(this.A03.A0V());
        this.A0A.setVisibility(0);
        this.A04.getResources();
        this.A0A.setLayoutParams(new LinearLayout.LayoutParams(-1, i));
        this.A0A.AJI();
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.N5 != com.facebook.ads.internal.adapters.FacebookBannerAdapter<NativeViewabilityLogger> */
    private void A0F(C14328u c14328u, JSONObject jSONObject, EnumC1470Aj enumC1470Aj) {
        this.A0G = false;
        C2866mo c2866moA00 = C2866mo.A00(this.A04, jSONObject);
        this.A0E = c2866moA00.A7E();
        if (AbstractC12591z.A06(this.A04, c2866moA00, this.A05)) {
            this.A04.A0F().A4s();
            this.A00.ADc(this, C1468Ag.A00(AdErrorType.NO_FILL));
            return;
        }
        this.A08 = new N6(this, c2866moA00);
        this.A09 = new C2496ge(this.A04, (WeakReference<F4>) new WeakReference(this.A08), c14328u.A04(), A7E());
        this.A09.A0G(c14328u.A07(), c14328u.A08());
        AnonymousClass26 impressionHelper = new C2882n4(this);
        this.A02 = new C2864mm(this.A04, this.A05, this.A09, this.A09.getViewabilityChecker(), impressionHelper, enumC1470Aj);
        this.A02.A0A(c2866moA00);
        this.A09.loadDataWithBaseURL(F7.A01(AdInternalSettings.getUrlPrefix()), c2866moA00.A04(), A08(31, 9, 19), A08(40, 5, 12), null);
        this.A0F = true;
        A0A();
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0053 A[PHI: r1
  0x0053: PHI (r1v13 int) = (r1v10 int), (r1v17 int) binds: [B:20:0x0079, B:12:0x0051] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:15:0x005f  */
    /* JADX WARN: Code duplicated, block: B:17:0x0062  */
    /* JADX WARN: Code duplicated, block: B:23:0x007e  */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.N5 != com.facebook.ads.internal.adapters.FacebookBannerAdapter<NativeViewabilityLogger> */
    private void A0G(EnumC1470Aj enumC1470Aj, C14328u c14328u) {
        int i;
        int bannerHeight;
        if (this.A03 != null) {
            A7 a7 = this.A05;
            if (A0K[1].charAt(21) == 'I') {
                throw new RuntimeException();
            }
            String[] strArr = A0K;
            strArr[6] = "0asQ5nS3mEJJFXqECkaJp8czAINd5ojj";
            strArr[4] = "wkfCN0fAVUFan65EWCqz3ffd3K2ZXjjS";
            if (a7 == null) {
                return;
            }
            int iA03 = enumC1470Aj.A03();
            if (A0K[3].charAt(25) != 'G') {
                A0K[5] = "7AAzPingpmVfFCqSXKHauNoNKo9Xv93Z";
                i = (int) (iA03 * Resources.getSystem().getDisplayMetrics().density);
                if (C14499m.A28(this.A04)) {
                    bannerHeight = C7J.A0A(this.A03.A0u()) ? 1 : 0;
                }
                if (bannerHeight == 0) {
                    A0C(i, c14328u);
                } else {
                    new C7J(new C14067t(this.A04), this.A03.A0u(), this.A03.A0i(), this.A03.A0r(), true, new C2886n8(this, i, c14328u, this)).A0B();
                }
            }
            i = (int) (iA03 * Resources.getSystem().getDisplayMetrics().density);
            if (C14499m.A28(this.A04)) {
                if (C7J.A0A(this.A03.A0u())) {
                }
            }
            if (bannerHeight == 0) {
                A0C(i, c14328u);
            } else {
                new C7J(new C14067t(this.A04), this.A03.A0u(), this.A03.A0i(), this.A03.A0r(), true, new C2886n8(this, i, c14328u, this)).A0B();
            }
            if (bannerHeight == 0) {
                A0C(i, c14328u);
            } else {
                new C7J(new C14067t(this.A04), this.A03.A0u(), this.A03.A0i(), this.A03.A0r(), true, new C2886n8(this, i, c14328u, this)).A0B();
            }
        }
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.N5 != com.facebook.ads.internal.adapters.FacebookBannerAdapter<NativeViewabilityLogger> */
    @Override // com.facebook.ads.redexgen.core.AnonymousClass23
    public final String A7E() {
        return this.A0E;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.N5 != com.facebook.ads.internal.adapters.FacebookBannerAdapter<NativeViewabilityLogger> */
    @Override // com.facebook.ads.redexgen.core.AnonymousClass23
    public final AdPlacementType A8a() {
        if (C14499m.A18(this.A04)) {
            EnumC1470Aj enumC1470Aj = this.A06;
            String[] strArr = A0K;
            if (strArr[2].length() == strArr[7].length()) {
                throw new RuntimeException();
            }
            A0K[0] = "gRyzGCsQg6apk2eHBZ3N290V4KDgGwY2";
            if (enumC1470Aj != null && this.A06 == EnumC1470Aj.A09) {
                return AdPlacementType.MEDIUM_RECTANGLE;
            }
        }
        return AdPlacementType.BANNER;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.N5 != com.facebook.ads.internal.adapters.FacebookBannerAdapter<NativeViewabilityLogger> */
    @Override // com.facebook.ads.redexgen.core.InterfaceC2887n9
    public final void AAi(M5 m5, A7 a7, EnumC1470Aj enumC1470Aj, C2B c2b, JSONObject jSONObject, C14328u c14328u) {
        m5.A0F().A4D();
        this.A04 = m5;
        this.A05 = a7;
        this.A00 = c2b;
        this.A06 = enumC1470Aj;
        this.A0H = C14499m.A1h(this.A04.getApplicationContext());
        this.A03 = C1772Mx.A02(jSONObject, this.A04);
        if (this.A03.A1F()) {
            A0G(enumC1470Aj, c14328u);
        } else {
            A0F(c14328u, jSONObject, enumC1470Aj);
        }
        this.A01 = new C2C(this.A04, this.A0I, this, c2b);
        this.A01.A02();
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.N5 != com.facebook.ads.internal.adapters.FacebookBannerAdapter<NativeViewabilityLogger> */
    @Override // com.facebook.ads.redexgen.core.AnonymousClass23
    public final boolean AJQ() {
        return true;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.N5 != com.facebook.ads.internal.adapters.FacebookBannerAdapter<NativeViewabilityLogger> */
    @Override // com.facebook.ads.redexgen.core.AnonymousClass23
    public final void onDestroy() {
        this.A04.A0F().A4B(this.A09 != null);
        if (this.A09 != null) {
            this.A09.destroy();
            this.A09 = null;
            this.A08 = null;
        }
        if (this.A01 != null) {
            this.A01.A03();
        }
    }
}
