package com.facebook.ads.redexgen.core;

import android.content.res.Configuration;
import android.os.Handler;
import android.os.Looper;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.facebook.ads.internal.view.FullScreenAdToolbar;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class LB extends AbstractC2402f6 {
    public static final RelativeLayout.LayoutParams A07 = new RelativeLayout.LayoutParams(-1, -1);
    public CH A00;
    public AbstractC1594Ft A01;
    public final int A02;
    public final ImageView A03;
    public final DQ A04;
    public final HI A05;
    public final AtomicBoolean A06;

    public LB(C2699k1 c2699k1, EC ec, int i, A7 a7, AbstractC2855md abstractC2855md, DR dr, FullScreenAdToolbar fullScreenAdToolbar, boolean z, boolean z2, HI hi, int i2) {
        super(c2699k1, ec, a7, abstractC2855md, i, z, z2, dr);
        this.A06 = new AtomicBoolean(false);
        this.A02 = i2;
        this.A05 = hi;
        this.A03 = new ImageView(getContext());
        this.A04 = fullScreenAdToolbar;
        this.A03.setScaleType(ImageView.ScaleType.CENTER);
        this.A03.setAdjustViewBounds(true);
        new AsyncTaskC2494gc(this.A03, c2699k1).A05(abstractC2855md.A1b().A0F().A00(), abstractC2855md.A1b().A0F().A01()).A06(new C2401f5(this)).A07(abstractC2855md.A1b().A0F().A08());
        A05(c2699k1.getResources().getConfiguration().orientation);
    }

    private AbstractC1594Ft A01(int i) {
        if (this.A03.getParent() != null) {
            D3.A0H(this.A03);
        }
        return AbstractC1595Fu.A00(new C1597Fw(super.A06, this.A07, this.A0A, super.A05, this.A03, this.A0C, this.A09).A0H(this.A04.getToolbarHeight()).A0N(this.A04).A0G(i).A0P(i != 2).A0Q(), null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A04() {
        if (this.A06.get()) {
            A12();
        }
    }

    private void A05(int i) {
        D3.A0H(this.A01);
        this.A01 = A01(i);
        if (this.A01 instanceof C2451fu) {
            ((C2451fu) this.A01).setChildChainedAd(true);
        }
        addView(this.A01, 0, A07);
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC2402f6
    public final void A11() {
        if (C14499m.A1s(super.A06)) {
            super.A06.A0B().AJZ(this.A03);
        }
        if (this.A01 != null) {
            this.A01.A0z();
        }
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC2402f6
    public final void A13() {
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC2402f6
    public final void A14() {
        if (this.A02 > 0) {
            this.A00 = new CH(this.A02, 100.0f, 100L, new Handler(Looper.getMainLooper()), new C2400f4(this));
            this.A00.A07();
        } else {
            this.A05.AF6(false);
        }
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC2402f6
    public final void A15(boolean z) {
        this.A01.setChainedWatchAndBrowseSkippableStatus(z);
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC2402f6
    public final void A16(boolean z) {
        if (this.A00 != null && this.A00.A05()) {
            this.A00.A06();
        }
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC2402f6
    public final void A17(boolean z) {
        if (this.A00 != null && !this.A00.A04()) {
            this.A00.A07();
        }
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC2402f6
    public final boolean A18() {
        return false;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC2402f6
    public final boolean A19() {
        return false;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC2402f6
    public final boolean A1A(String str) {
        return this.A01.A18(str);
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC2402f6
    public HG getFullScreenAdStyle() {
        C12622c colors = this.A01.getColors();
        return new HG(this.A01.A17(), HG.A07, colors, ViewOnClickListenerC2488gW.A09(super.A05), colors.A08(this.A01.A17() || (this.A01 instanceof AbstractC2474gH)), null);
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC2402f6, android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (!super.A05.A1b().A0Q()) {
            A05(configuration.orientation);
        }
    }
}
