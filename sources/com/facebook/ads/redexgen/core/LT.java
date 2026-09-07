package com.facebook.ads.redexgen.core;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class LT extends AbstractC2474gH {
    public static byte[] A02;
    public static String[] A03 = {"ccLmdgMtf", "50lpHgsnQSuWf1CWCacJGyiAwAWsDUud", "Nq2vo108Bdlpu7LWCjcAC5dDG31maruF", "TAe0PaklKNA7XHBVlxrhZCtyBfgeydAO", "ouUdcivF6", "IAXVD4SBpgtyrGYWX4yc8p2wBrUpSeUf", "nA5GNdAWyE31pAGlKcdnPdOQEY7Q2fwD", "a5Dyr8HKQP9cZfy0xnx35qJg31dQk6"};
    public static final int A04;
    public final View A00;
    public final boolean A01;

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i, i + i2);
        int i4 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            if (A03[7].length() != 30) {
                throw new RuntimeException();
            }
            String[] strArr = A03;
            strArr[0] = "FT3046kmt";
            strArr[4] = "J6Q3a22Lt";
            if (i4 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 71);
            i4++;
        }
    }

    public static void A01() {
        A02 = new byte[]{37, 33, 45, 43, 41};
    }

    static {
        A01();
        A04 = Resources.getSystem().getDisplayMetrics().widthPixels;
    }

    public LT(C1598Fx c1598Fx, boolean z) {
        super(c1598Fx, true);
        this.A01 = z;
        this.A00 = c1598Fx.A02();
        A1D();
        if (this.A01) {
            addView(c1598Fx.A02(), new RelativeLayout.LayoutParams(-1, -1));
        } else {
            FrameLayout frameLayout = new FrameLayout(c1598Fx.A05());
            RelativeLayout.LayoutParams insideContainerParams = new RelativeLayout.LayoutParams(-1, -1);
            insideContainerParams.addRule(2, getAdDetailsView().getId());
            frameLayout.setLayoutParams(insideContainerParams);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.gravity = 17;
            layoutParams.setMargins(AbstractC1594Ft.A07, 0, AbstractC1594Ft.A07, 0);
            frameLayout.addView(this.A00, layoutParams);
            addView(frameLayout);
        }
        CK ckA0A = this.A08.A0A(getAdDataBundle());
        c1598Fx.A05().A0H().A00(ckA0A.A01);
        getCtaButton().setCreativeAsCtaLoggingHelper(this.A08);
        if (this.A00 != null) {
            if (ckA0A.A00) {
                this.A00.setOnClickListener(new View.OnClickListener() { // from class: com.facebook.ads.redexgen.X.Fy
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.A00.A1F(view);
                    }
                });
            } else if (C14499m.A1G(getAdContextWrapper())) {
                FE.A00(this.A00, C14499m.A1H(getAdContextWrapper()), new ViewOnClickListenerC1600Fz(this));
            }
        }
        getAdDetailsView().bringToFront();
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1594Ft
    public final boolean A02() {
        return this.A01 && super.A02();
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1594Ft
    public final boolean A0A() {
        return this.A01 && super.A02();
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC2474gH, com.facebook.ads.redexgen.core.AbstractC1594Ft
    public final void A14(C2T c2t, String str, double d, Bundle bundle) {
        super.A14(c2t, str, d, bundle);
        if (!this.A01 && d > 0.0d) {
            int mediaHeight = (int) (((double) (A04 - (AbstractC1594Ft.A07 * 2))) / d);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, mediaHeight);
            layoutParams.gravity = 17;
            int i = AbstractC1594Ft.A07;
            int mediaHeight2 = AbstractC1594Ft.A07;
            layoutParams.setMargins(i, 0, mediaHeight2, 0);
            this.A00.setLayoutParams(layoutParams);
        }
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1594Ft
    public final boolean A17() {
        return this.A01;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC2474gH
    public final FH A1B(C1598Fx c1598Fx, C2T c2t, String str) {
        return new C2475gI(c1598Fx.A05(), getCtaButton(), AbstractC2474gH.A0F, c2t.A0G().A00() == C2Y.A05, getColors(), c2t.A0H().A06(), str, c1598Fx.A06(), c1598Fx.A0C(), c1598Fx.A0E(), c1598Fx.A09(), c1598Fx.A04());
    }

    public final /* synthetic */ void A1F(View view) {
        getCtaButton().A0A(A00(0, 5, 11));
    }
}
