package com.facebook.ads.redexgen.core;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.util.Arrays;
import java.util.HashMap;

/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class FH extends LinearLayout {
    public static byte[] A0A;
    public static final LinearLayout.LayoutParams A0B;
    public LinearLayout A00;
    public TextView A01;
    public String A02;
    public boolean A03;
    public final int A04;
    public final View.OnClickListener A05;
    public final RelativeLayout A06;
    public final C2699k1 A07;
    public final ViewOnClickListenerC2488gW A08;
    public final C1580Ff A09;

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0A, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 11);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A0A = new byte[]{-96, -93, -93, -92, -77, -96, -88, -85, -78};
    }

    public abstract void A0D(int i);

    static {
        A01();
        A0B = new LinearLayout.LayoutParams(-2, -2);
    }

    public FH(C2699k1 c2699k1, ViewOnClickListenerC2488gW viewOnClickListenerC2488gW, int i, C12622c c12622c, boolean z, String str, A7 a7, DR dr, JL jl, C1518Cv c1518Cv, C12672h c12672h, boolean z2, String str2) {
        super(c2699k1);
        this.A02 = A00(0, 0, 37);
        D3.A0I(this);
        this.A07 = c2699k1;
        this.A04 = i;
        this.A03 = z2;
        this.A02 = str2;
        this.A09 = new C1580Ff(c2699k1);
        D3.A0K(this.A09, 0);
        D3.A0I(this.A09);
        if (z2) {
            this.A00 = new LinearLayout(c2699k1);
            this.A01 = new TextView(c2699k1);
            D3.A0I(this.A01);
        }
        if (viewOnClickListenerC2488gW == null) {
            this.A08 = new ViewOnClickListenerC2488gW(c2699k1, str, c12622c, z, a7, dr, jl, c1518Cv, c12672h);
        } else {
            this.A08 = viewOnClickListenerC2488gW;
        }
        D3.A0E(1001, this.A08);
        this.A05 = AbstractC1591Fq.A03(this.A08, A00(0, 9, 52));
        this.A06 = new RelativeLayout(c2699k1);
        this.A06.setLayoutParams(A0B);
        D3.A0I(this.A06);
    }

    public void A0N() {
        this.A09.setOnClickListener(this.A05);
    }

    public final ViewOnClickListenerC2488gW getCTAButton() {
        return this.A08;
    }

    public View getExpandableLayout() {
        return null;
    }

    public final ImageView getIconView() {
        return this.A09;
    }

    public void setInfo(C12602a c12602a, C12632d c12632d, String str, String str2, CZ cz, FP fp) {
        this.A08.setCta(c12632d, str, new HashMap(), cz, fp);
        new AsyncTaskC2494gc(this.A09, this.A07).A05(this.A04, this.A04).A07(str2);
    }

    public void setTitleMaxLines(int i) {
    }
}
