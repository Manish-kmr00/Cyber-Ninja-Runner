package com.facebook.ads.redexgen.core;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import java.util.Arrays;
import java.util.HashMap;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.dT, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2302dT extends FrameLayout implements DS {
    public static byte[] A0B;
    public static final RelativeLayout.LayoutParams A0C;
    public C13656e A00;
    public Intent A01;
    public Bundle A02;
    public DS A03;
    public final AbstractC2855md A04;
    public final AbstractC2855md A05;
    public final C13656e A06;
    public final C2699k1 A07;
    public final A7 A08;
    public final ViewOnSystemUiVisibilityChangeListenerC1513Cq A09;
    public final DR A0A;

    public static String A08(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0B, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 32);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A0A() {
        A0B = new byte[]{117, 105, 100, 102, 96, 104, 96, 107, 113};
    }

    static {
        A0A();
        A0C = new RelativeLayout.LayoutParams(-1, -1);
    }

    public C2302dT(C2699k1 c2699k1, A7 a7, AbstractC2855md abstractC2855md, AbstractC2855md abstractC2855md2, DR dr, C13656e c13656e) {
        super(c2699k1);
        this.A07 = c2699k1;
        this.A08 = a7;
        this.A05 = abstractC2855md;
        this.A04 = abstractC2855md2;
        this.A0A = dr;
        this.A06 = c13656e;
        this.A09 = new ViewOnSystemUiVisibilityChangeListenerC1513Cq(this);
        this.A09.A05(EnumC1512Cp.A02);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public C2540hM A05(C1641Ho c1641Ho, EC ec) {
        return new C2540hM(this.A07, this.A08, this.A0A, this.A04, this.A04.A0s(), ec, true, c1641Ho);
    }

    private C1714Kj A06() {
        if (this.A04.A1b().A0F().A07() != null) {
            this.A05.A14(this.A04.A1b().A0F().A07().A0N());
            this.A05.A15(this.A04.A1b().A0F().A07().A0P());
        }
        C2535hH c2535hH = new C2535hH();
        C1641Ho c1641HoA07 = A07(c2535hH, this.A04);
        C1714Kj c1714Kj = new C1714Kj(this.A07, c2535hH, this.A08, this.A05, new C14067t(this.A07), this.A0A);
        c1714Kj.setVideoLeadingPlayableAdListener(new C2303dU(this, c1641HoA07, c2535hH));
        return c1714Kj;
    }

    private C1641Ho A07(EC ec, AbstractC2855md abstractC2855md) {
        C12752p c12752pA07 = abstractC2855md.A1b().A0F().A07();
        if (c12752pA07 == null || !c12752pA07.A0M()) {
            return null;
        }
        HashMap map = new HashMap();
        map.put(A08(0, 9, 37), ec.A8b());
        return new C1641Ho(this.A07, abstractC2855md, c12752pA07, this.A08, null, map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A09() {
        if (this.A03 != null) {
            this.A03.onDestroy();
            if (this.A03 instanceof View) {
                ((View) this.A03).setVisibility(8);
                removeView((View) this.A03);
            }
        }
    }

    private final void A0B(Intent intent, Bundle bundle, C13656e c13656e) {
        this.A03 = A06();
        this.A03.AAj(intent, bundle, c13656e);
    }

    @Override // com.facebook.ads.redexgen.core.DS
    public final void AAj(Intent intent, Bundle bundle, C13656e c13656e) {
        this.A01 = intent;
        this.A02 = bundle;
        this.A00 = c13656e;
        this.A0A.A3v(this, A0C);
        A0B(intent, bundle, c13656e);
    }

    @Override // com.facebook.ads.redexgen.core.DS
    public final void AEP(boolean z) {
    }

    @Override // com.facebook.ads.redexgen.core.DS
    public final void AEs(boolean z) {
    }

    @Override // com.facebook.ads.redexgen.core.DS
    public final void AI1(Bundle bundle) {
    }

    public DS getContentView() {
        return this.A03;
    }

    @Override // com.facebook.ads.redexgen.core.DS
    public String getCurrentClientToken() {
        return this.A05.A1g();
    }

    @Override // com.facebook.ads.redexgen.core.DS
    public final boolean onActivityResult(int i, int i2, Intent intent) {
        return false;
    }

    @Override // com.facebook.ads.redexgen.core.DS
    public final void onDestroy() {
    }

    public void setListener(DR dr) {
    }
}
