package com.facebook.ads.redexgen.core;

import android.view.View;
import android.widget.LinearLayout;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.hn, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2566hn extends DQ {
    public static byte[] A03;
    public C2699k1 A00;
    public DP A01;
    public final E4 A02;

    static {
        A05();
    }

    public static String A02(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 75);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A05() {
        A03 = new byte[]{-75, -34, -31, -27, -41, -110, -77, -42};
    }

    public C2566hn(C2699k1 c2699k1, DR dr, AF af, int i) {
        super(c2699k1);
        this.A00 = c2699k1;
        setGravity(16);
        A04();
        this.A02 = new E4(this.A00, i);
        A03();
    }

    private void A03() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        this.A02.setContentDescription(A02(0, 8, 39));
        this.A02.setActionClickListener(new ViewOnClickListenerC1524Db(this));
        addView(this.A02, layoutParams);
    }

    private void A04() {
        View view = new View(this.A00);
        view.setLayoutParams(new LinearLayout.LayoutParams(0, 0, 1.0f));
        addView(view);
    }

    @Override // com.facebook.ads.redexgen.core.DQ
    public final void A06() {
    }

    @Override // com.facebook.ads.redexgen.core.DQ
    public final void A07() {
    }

    @Override // com.facebook.ads.redexgen.core.DQ
    public final void A08() {
    }

    @Override // com.facebook.ads.redexgen.core.DQ
    public final void A09(float f, int i) {
    }

    @Override // com.facebook.ads.redexgen.core.DQ
    public final void A0A(C12622c c12622c, boolean z) {
    }

    @Override // com.facebook.ads.redexgen.core.DQ
    public final boolean A0B() {
        return false;
    }

    @Override // com.facebook.ads.redexgen.core.DQ
    public int getToolbarActionMode() {
        return this.A02.getToolbarActionMode();
    }

    @Override // com.facebook.ads.redexgen.core.DQ
    public int getToolbarHeight() {
        return DQ.A01;
    }

    @Override // com.facebook.ads.redexgen.core.DQ
    public DP getToolbarListener() {
        return null;
    }

    @Override // com.facebook.ads.redexgen.core.DQ
    public void setAdReportingVisible(boolean z) {
    }

    @Override // com.facebook.ads.redexgen.core.DQ
    public void setCTAClickListener(View.OnClickListener onClickListener) {
    }

    @Override // com.facebook.ads.redexgen.core.DQ
    public void setCTAClickListener(ViewOnClickListenerC2488gW viewOnClickListenerC2488gW) {
    }

    @Override // com.facebook.ads.redexgen.core.DQ
    public void setFullscreen(boolean z) {
    }

    @Override // com.facebook.ads.redexgen.core.DQ
    public void setPageDetails(C12732n c12732n, String str, int i, C12792t c12792t) {
        this.A02.setInitialUnskippableSeconds(i);
    }

    @Override // com.facebook.ads.redexgen.core.DQ
    public void setPageDetailsVisible(boolean z) {
    }

    @Override // com.facebook.ads.redexgen.core.DQ
    public void setProgress(float f) {
    }

    @Override // com.facebook.ads.redexgen.core.DQ
    public void setProgressClickListener(View.OnClickListener onClickListener) {
    }

    @Override // com.facebook.ads.redexgen.core.DQ
    public void setProgressImage(DB db) {
    }

    @Override // com.facebook.ads.redexgen.core.DQ
    public void setProgressImmediate(float f) {
    }

    @Override // com.facebook.ads.redexgen.core.DQ
    public void setProgressSpinnerInvisible(boolean z) {
    }

    @Override // com.facebook.ads.redexgen.core.DQ
    public void setToolbarActionMessage(String str) {
    }

    @Override // com.facebook.ads.redexgen.core.DQ
    public void setToolbarActionMode(int i) {
        this.A02.setToolbarActionMode(i);
    }

    @Override // com.facebook.ads.redexgen.core.DQ
    public void setToolbarListener(DP dp) {
        this.A01 = dp;
    }
}
