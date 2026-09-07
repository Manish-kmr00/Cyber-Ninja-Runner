package com.facebook.ads.redexgen.core;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.google.common.base.Ascii;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.gA, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2467gA extends AbstractC1594Ft implements CJ {
    public static byte[] A05;
    public static final int A06;
    public final AbstractC2855md A00;
    public final CL A01;
    public final DR A02;
    public final GP A03;
    public final C1628Hb A04;

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A05, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 86);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A05 = new byte[]{38, 42, Ascii.RS, 36, 34};
    }

    static {
        A01();
        A06 = Resources.getSystem().getDisplayMetrics().widthPixels;
    }

    public C2467gA(C1598Fx c1598Fx, boolean z) {
        int id;
        int iA01;
        super(c1598Fx, z);
        this.A02 = c1598Fx.A0C();
        this.A00 = c1598Fx.A04();
        this.A03 = new GP(c1598Fx.A05(), c1598Fx.A02());
        this.A03.A01(getTitleDescContainer(), z);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        layoutParams.setMargins(AbstractC1594Ft.A07, AbstractC1594Ft.A07, AbstractC1594Ft.A07, AbstractC1594Ft.A07);
        getCtaButton().setLayoutParams(layoutParams);
        if (c1598Fx.A0F()) {
            this.A04 = new C1628Hb(c1598Fx.A05());
            this.A04.setPageDetails(c1598Fx.A04().A1e());
            D3.A0E(1007, this.A04);
            RelativeLayout.LayoutParams pageDetailsParams = new RelativeLayout.LayoutParams(-2, -2);
            pageDetailsParams.addRule(2, getCtaButton().getId());
            pageDetailsParams.setMargins(AbstractC1594Ft.A07, AbstractC1594Ft.A07 - (AbstractC1594Ft.A07 / 2), AbstractC1594Ft.A07, 0);
            this.A04.setLayoutParams(pageDetailsParams);
            id = this.A04.getId();
            iA01 = c1598Fx.A01() - (AbstractC1594Ft.A07 / 2);
        } else {
            id = getCtaButton().getId();
            iA01 = c1598Fx.A01();
            this.A04 = null;
        }
        FrameLayout insideContainerLayout = new FrameLayout(c1598Fx.A05());
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams2.addRule(10);
        layoutParams2.addRule(2, id);
        layoutParams2.setMargins(0, iA01, 0, 0);
        insideContainerLayout.setLayoutParams(layoutParams2);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -2);
        layoutParams3.gravity = 17;
        layoutParams3.setMargins(AbstractC1594Ft.A07, 0, AbstractC1594Ft.A07, 0);
        insideContainerLayout.addView(this.A03, layoutParams3);
        addView(insideContainerLayout);
        if (this.A04 != null) {
            addView(this.A04);
        }
        addView(getCtaButton());
        getCtaButton().A0B(c1598Fx.A04(), c1598Fx.A0B());
        View viewA02 = c1598Fx.A02();
        this.A01 = CL.A01(c1598Fx.A05(), this.A00, this);
        CK ckA0A = this.A01.A0A(this.A00);
        c1598Fx.A05().A0H().A00(ckA0A.A01);
        getCtaButton().setCreativeAsCtaLoggingHelper(this.A01);
        if (viewA02 != null && ckA0A.A00) {
            viewA02.setOnClickListener(new View.OnClickListener() { // from class: com.facebook.ads.redexgen.X.G3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.A00.A1A(view);
                }
            });
        } else if (viewA02 != null && C14499m.A1G(getAdContextWrapper())) {
            FE.A00(viewA02, C14499m.A1H(getAdContextWrapper()), new G4(this));
        }
        if (C14499m.A16(c1598Fx.A05())) {
            getTitleDescContainer().setCTAClickListener(getCtaButton());
            if (c1598Fx.A0B() != null) {
                c1598Fx.A0B().setCTAClickListener(getCtaButton());
            }
        }
        if (this.A04 != null && C14499m.A17(c1598Fx.A05())) {
            this.A04.setOnClickListener(getCtaButton());
        }
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1594Ft
    public final boolean A02() {
        return false;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1594Ft
    public final boolean A0A() {
        return false;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1594Ft
    public final void A0z() {
        super.A0z();
        this.A01.A0B();
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1594Ft
    public final void A14(C2T c2t, String str, double d, Bundle bundle) {
        super.A14(c2t, str, d, bundle);
        if (d > 0.0d) {
            int mediaHeight = (int) (((double) (A06 - (AbstractC1594Ft.A07 * 2))) / d);
            this.A03.A00(mediaHeight);
        }
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1594Ft
    public final boolean A17() {
        return false;
    }

    public final /* synthetic */ void A1A(View view) {
        getCtaButton().A0A(A00(0, 5, 103));
    }

    @Override // com.facebook.ads.redexgen.core.CJ
    public final void ADz() {
        this.A02.A4Z(this.A00.A0e());
    }
}
