package com.facebook.ads.internal.view;

import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.core.view.ViewCompat;
import com.facebook.ads.redexgen.core.AF;
import com.facebook.ads.redexgen.core.AbstractC1591Fq;
import com.facebook.ads.redexgen.core.C12622c;
import com.facebook.ads.redexgen.core.C12732n;
import com.facebook.ads.redexgen.core.C12792t;
import com.facebook.ads.redexgen.core.C1543Du;
import com.facebook.ads.redexgen.core.C1628Hb;
import com.facebook.ads.redexgen.core.C2699k1;
import com.facebook.ads.redexgen.core.CP;
import com.facebook.ads.redexgen.core.D3;
import com.facebook.ads.redexgen.core.DB;
import com.facebook.ads.redexgen.core.DO;
import com.facebook.ads.redexgen.core.DP;
import com.facebook.ads.redexgen.core.DQ;
import com.facebook.ads.redexgen.core.DR;
import com.facebook.ads.redexgen.core.E2;
import com.facebook.ads.redexgen.core.ViewOnClickListenerC1523Da;
import com.facebook.ads.redexgen.core.ViewOnClickListenerC2488gW;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class FullScreenAdToolbar extends DQ {
    public static byte[] A0B;
    public static String[] A0C = {"bFTGQZCDUsZohbmTeIVqSIHEteTzH9ln", "yXw5A2C", "1AgOSkHO0Pb00RrFT9UOiqy", "TxDFqDHdXRoHKl2DTNxbpTLqI26RISWJ", "CWbWmw8OaNX6ff1fhEYiHQW6wjCjGro9", "znIzyGoGhCcdAsXYdQkLlPNG9alZ5sNL", "lf2qO9K", "XEgUxEHpppw1PxIgjlcxmDWHelwWu1Ow"};
    public static final int A0D;
    public static final int A0E;
    public static final int A0F;
    public static final int A0G;
    public static final int A0H;
    public DO A00;
    public DP A01;
    public DP A02;
    public C1543Du A03;
    public boolean A04;
    public boolean A05;
    public final RelativeLayout A06;
    public final AF A07;
    public final DR A08;
    public final E2 A09;
    public final C1628Hb A0A;

    public static String A02(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0B, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 22);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A03() {
        byte[] bArr = {113, -102, -99, -95, -109, 78, 111, -110, -100, -81, -70, -71, -68, -66, 106, -117, -82, -71, -76, -76, -79, -89, -90, -73};
        if (A0C[5].charAt(20) != 'l') {
            throw new RuntimeException();
        }
        A0C[2] = "ATFpsL3dKIxr1CEZIKZeGPZ";
        A0B = bArr;
    }

    static {
        A03();
        A0D = (int) (CP.A02 * 10.0f);
        A0H = (int) (CP.A02 * 16.0f);
        A0F = A0H - A0D;
        A0G = (A0H * 2) - A0D;
        A0E = (int) (CP.A02 * 4.0f);
    }

    public FullScreenAdToolbar(C2699k1 c2699k1, DR dr, AF af, int i, int i2, boolean z) {
        super(c2699k1);
        this.A01 = null;
        this.A04 = true;
        this.A05 = z;
        this.A08 = dr;
        this.A07 = af;
        setGravity(16);
        this.A09 = new E2(c2699k1, i, z);
        this.A09.setContentDescription(A02(0, 8, 24));
        this.A09.setActionClickListener(new ViewOnClickListenerC1523Da(this));
        if (!this.A05) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(A0F, A0F, A0G, A0F);
            addView(this.A09, layoutParams);
            this.A06 = new RelativeLayout(c2699k1);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -2);
            layoutParams2.weight = 1.0f;
            this.A0A = new C1628Hb(c2699k1);
            D3.A0E(1006, this.A0A);
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams3.gravity = 17;
            this.A0A.setLayoutParams(layoutParams3);
            this.A06.addView(this.A0A);
            addView(this.A06, layoutParams2);
            if (i2 != -1) {
                A0D(c2699k1, i2);
                return;
            }
            return;
        }
        if (i2 != -1) {
            A0D(c2699k1, i2);
        }
        this.A06 = new RelativeLayout(c2699k1);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(0, -2);
        layoutParams4.weight = 1.0f;
        this.A0A = new C1628Hb(c2699k1);
        D3.A0E(1006, this.A0A);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams5.gravity = 17;
        this.A0A.setLayoutParams(layoutParams5);
        this.A06.addView(this.A0A);
        addView(this.A06, layoutParams4);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams6.setMargins(0, A0H / 2, A0H / 2, A0H / 2);
        addView(this.A09, layoutParams6);
    }

    private void A04(View view, boolean z) {
        if (view == null) {
            return;
        }
        view.setVisibility(z ? 0 : 8);
    }

    @Override // com.facebook.ads.redexgen.core.DQ
    public final void A06() {
        this.A09.A02();
    }

    @Override // com.facebook.ads.redexgen.core.DQ
    public final void A07() {
        if (this.A01 != null) {
            this.A02 = this.A01;
        }
    }

    @Override // com.facebook.ads.redexgen.core.DQ
    public final void A08() {
        this.A01 = getToolbarListener();
    }

    @Override // com.facebook.ads.redexgen.core.DQ
    public final void A09(float f, int i) {
        this.A09.A03(f, i);
    }

    @Override // com.facebook.ads.redexgen.core.DQ
    public final void A0A(C12622c c12622c, boolean z) {
        boolean z2 = this.A04;
        int iA05 = c12622c.A05(z2);
        this.A0A.A02(c12622c.A0B(z2), iA05);
        boolean z3 = this.A05;
        String strA02 = A02(8, 9, 52);
        if (!z3) {
            if (this.A00 != null) {
                this.A00.setIconColors(iA05);
                this.A00.setContentDescription(strA02);
            }
        } else if (this.A03 != null) {
            this.A03.setIconColors(iA05);
            this.A03.setContentDescription(strA02);
        }
        this.A09.A04(c12622c, z2, z);
        if (z2) {
            GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{-1778384896, 0});
            gradientDrawable.setCornerRadius(0.0f);
            D3.A0Q(this, gradientDrawable);
            boolean fullScreenEnabled = this.A05;
            setReportingViewColor(!fullScreenEnabled ? this.A00 : this.A03);
            return;
        }
        D3.A0K(this, 0);
    }

    @Override // com.facebook.ads.redexgen.core.DQ
    public final boolean A0B() {
        return this.A09.A05();
    }

    public final void A0C(C12732n c12732n, String str, int i) {
        this.A09.setInitialUnskippableSeconds(i);
        if (this.A05) {
            if (this.A03 != null) {
                this.A03.setAdDetails(c12732n, str, this.A07, this.A08);
            }
        } else {
            if (this.A00 == null) {
                return;
            }
            this.A00.setAdDetails(c12732n, str, this.A07, this.A08);
        }
    }

    public final void A0D(C2699k1 c2699k1, int i) {
        if (this.A00 != null) {
            D3.A0H(this.A00);
            this.A00.removeAllViews();
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        if (!this.A05) {
            this.A00 = new DO(c2699k1, i);
            layoutParams.setMargins(0, A0H / 2, A0H / 2, A0H / 2);
            addView(this.A00, layoutParams);
        } else {
            this.A03 = new C1543Du(c2699k1);
            layoutParams.setMargins(A0F, A0F, A0G, A0F);
            addView(this.A03, layoutParams);
        }
    }

    @Override // com.facebook.ads.redexgen.core.DQ
    public int getToolbarActionMode() {
        return this.A09.getToolbarActionMode();
    }

    @Override // com.facebook.ads.redexgen.core.DQ
    public int getToolbarHeight() {
        return DQ.A00;
    }

    @Override // com.facebook.ads.redexgen.core.DQ
    public DP getToolbarListener() {
        return this.A02;
    }

    @Override // com.facebook.ads.redexgen.core.DQ
    public void setAdReportingVisible(boolean z) {
        A04(!this.A05 ? this.A00 : this.A03, z);
    }

    @Override // com.facebook.ads.redexgen.core.DQ
    public void setCTAClickListener(View.OnClickListener onClickListener) {
        this.A0A.setOnClickListener(onClickListener);
    }

    @Override // com.facebook.ads.redexgen.core.DQ
    public void setCTAClickListener(ViewOnClickListenerC2488gW viewOnClickListenerC2488gW) {
        this.A0A.setOnClickListener(AbstractC1591Fq.A03(viewOnClickListenerC2488gW, A02(17, 7, 47)));
    }

    @Override // com.facebook.ads.redexgen.core.DQ
    public void setFullscreen(boolean z) {
        this.A04 = z;
    }

    public void setOnlyPageDetails(C12732n c12732n) {
        if (c12732n != null) {
            this.A0A.setPageDetails(c12732n);
        } else {
            this.A0A.A01();
        }
    }

    @Override // com.facebook.ads.redexgen.core.DQ
    public void setPageDetails(C12732n c12732n, String str, int i, C12792t c12792t) {
        this.A09.setInitialUnskippableSeconds(i);
        this.A0A.setPageDetails(c12732n);
        if (this.A05) {
            if (this.A03 != null) {
                this.A03.setAdDetails(c12732n, str, this.A07, this.A08);
            }
        } else {
            if (this.A00 == null) {
                return;
            }
            this.A00.setAdDetails(c12732n, str, this.A07, this.A08);
        }
    }

    @Override // com.facebook.ads.redexgen.core.DQ
    public void setPageDetailsVisible(boolean z) {
        this.A06.removeAllViews();
        if (z) {
            this.A06.addView(this.A0A);
        }
        this.A09.setToolbarMessageEnabled(!z);
    }

    @Override // com.facebook.ads.redexgen.core.DQ
    public void setProgress(float f) {
        this.A09.setProgress(f);
    }

    @Override // com.facebook.ads.redexgen.core.DQ
    public void setProgressClickListener(View.OnClickListener onClickListener) {
        this.A09.setProgressClickListener(onClickListener);
    }

    @Override // com.facebook.ads.redexgen.core.DQ
    public void setProgressImage(DB db) {
        this.A09.setProgressImage(db);
    }

    @Override // com.facebook.ads.redexgen.core.DQ
    public void setProgressImmediate(float f) {
        this.A09.setProgressImmediate(f);
    }

    @Override // com.facebook.ads.redexgen.core.DQ
    public void setProgressSpinnerInvisible(boolean z) {
        this.A09.setProgressSpinnerInvisible(z);
    }

    private void setReportingViewColor(View view) {
        if (view != null) {
            D3.A0O(view, 0, ViewCompat.MEASURED_STATE_MASK, A0E);
        }
    }

    @Override // com.facebook.ads.redexgen.core.DQ
    public void setToolbarActionMessage(String str) {
        this.A09.setToolbarMessage(str);
    }

    @Override // com.facebook.ads.redexgen.core.DQ
    public void setToolbarActionMode(int i) {
        this.A09.setToolbarActionMode(i);
    }

    @Override // com.facebook.ads.redexgen.core.DQ
    public void setToolbarListener(DP dp) {
        this.A02 = dp;
    }
}
