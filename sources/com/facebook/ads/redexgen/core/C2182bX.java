package com.facebook.ads.redexgen.core;

import android.animation.AnimatorListenerAdapter;
import android.os.Handler;
import android.view.View;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.bX, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2182bX implements IQ {
    public View A00;
    public C2232cL A01;
    public EnumC1658If A02;
    public boolean A03;
    public final Handler A04;
    public final AbstractC2214c3 A05;
    public final AbstractC2208bx A06;
    public final AbstractC2206bv A07;
    public final AbstractC2197bm A08;
    public final boolean A09;
    public final boolean A0A;

    public C2182bX(View view, EnumC1658If enumC1658If, boolean z) {
        this(view, enumC1658If, z, false);
    }

    public C2182bX(View view, EnumC1658If enumC1658If, boolean z, boolean z2) {
        this.A06 = new KN(this);
        this.A07 = new KM(this);
        this.A05 = new KL(this);
        this.A08 = new KK(this);
        this.A03 = true;
        this.A04 = new Handler();
        this.A09 = z;
        this.A0A = z2;
        A08(view, enumC1658If);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A05() {
        this.A00.animate().alpha(0.0f).setDuration(500L).setListener(new C1657Ie(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A06(int i, int i2) {
        this.A04.removeCallbacksAndMessages(null);
        this.A00.clearAnimation();
        this.A00.setAlpha(i);
        this.A00.setVisibility(i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A07(AnimatorListenerAdapter animatorListenerAdapter) {
        this.A00.setVisibility(0);
        this.A00.animate().alpha(1.0f).setDuration(500L).setListener(animatorListenerAdapter);
    }

    private final void A08(View view, EnumC1658If enumC1658If) {
        this.A02 = enumC1658If;
        this.A00 = view;
        this.A00.clearAnimation();
        if (enumC1658If == EnumC1658If.A03) {
            this.A00.setAlpha(0.0f);
            this.A00.setVisibility(8);
        } else {
            this.A00.setAlpha(1.0f);
            this.A00.setVisibility(0);
        }
    }

    @Override // com.facebook.ads.redexgen.core.IQ
    public final void AAk(C2232cL c2232cL) {
        this.A01 = c2232cL;
        c2232cL.getEventBus().A03(this.A06, this.A07, this.A08, this.A05);
    }

    @Override // com.facebook.ads.redexgen.core.IQ
    public final void AJa(C2232cL c2232cL) {
        A06(1, 0);
        c2232cL.getEventBus().A04(this.A05, this.A08, this.A07, this.A06);
        this.A01 = null;
    }
}
