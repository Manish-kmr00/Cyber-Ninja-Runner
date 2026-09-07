package com.facebook.ads.redexgen.core;

import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.widget.LinearLayout;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ht, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1646Ht {
    public ViewOnClickListenerC2488gW A00;
    public final C2P A01;
    public final C12602a A02;
    public final C12642e A03;
    public final C12732n A04;
    public final C2699k1 A05;
    public final AF A06;
    public static final int A09 = (int) (CP.A02 * 4.0f);
    public static final int A07 = (int) (CP.A02 * 72.0f);
    public static final int A08 = (int) (CP.A02 * 8.0f);

    public C1646Ht(C2699k1 c2699k1, A7 a7, AbstractC2855md abstractC2855md) {
        this.A05 = c2699k1;
        this.A06 = new AF(abstractC2855md.A1g(), a7);
        this.A01 = abstractC2855md.A1a();
        this.A02 = abstractC2855md.A1b().A0G();
        this.A04 = abstractC2855md.A1e();
        this.A03 = abstractC2855md.A1b().A0I();
    }

    private View A00(ViewOnClickListenerC2488gW viewOnClickListenerC2488gW) {
        C1586Fl c1586Fl = new C1586Fl(this.A05, this.A01.A01(), true, false, false);
        c1586Fl.A04(this.A02.A0F(), this.A02.A04(), null, false, true);
        c1586Fl.setAlignment(17);
        C1580Ff c1580Ff = new C1580Ff(this.A05);
        D3.A0K(c1580Ff, 0);
        c1580Ff.setRadius(50);
        new AsyncTaskC2494gc(c1580Ff, this.A05).A04().A07(this.A04.A01());
        LinearLayout linearLayout = new LinearLayout(this.A05);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(17);
        linearLayout.addView(c1580Ff, new LinearLayout.LayoutParams(A07, A07));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, A08, 0, A08);
        linearLayout.addView(c1586Fl, layoutParams);
        if (viewOnClickListenerC2488gW != null) {
            D3.A0H(viewOnClickListenerC2488gW);
            linearLayout.addView(viewOnClickListenerC2488gW, layoutParams);
            if (TextUtils.isEmpty(viewOnClickListenerC2488gW.getText())) {
                D3.A0F(viewOnClickListenerC2488gW);
            }
        }
        return linearLayout;
    }

    private MG A01() {
        MG mg = new MG(this.A05);
        mg.setLayoutManager(new C2771lC(this.A05, 0, false));
        mg.setAdapter(new C2249cc(this.A05, this.A03.A02(), A09, this.A00));
        return mg;
    }

    private final EnumC1645Hs A02() {
        if (!this.A03.A02().isEmpty()) {
            return EnumC1645Hs.A03;
        }
        return EnumC1645Hs.A02;
    }

    public final Pair<EnumC1645Hs, View> A03(ViewOnClickListenerC2488gW viewOnClickListenerC2488gW) {
        View viewA01;
        this.A00 = viewOnClickListenerC2488gW;
        EnumC1645Hs enumC1645HsA02 = A02();
        switch (C1644Hr.A00[enumC1645HsA02.ordinal()]) {
            case 1:
                viewA01 = A01();
                break;
            default:
                viewA01 = A00(this.A00);
                break;
        }
        AH.A04(viewA01, this.A06, AE.A0S);
        return new Pair<>(enumC1645HsA02, viewA01);
    }
}
