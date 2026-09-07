package com.facebook.ads.redexgen.core;

import android.transition.ChangeBounds;
import android.transition.Explode;
import android.transition.TransitionSet;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.hF, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2533hF extends EH {
    public static String[] A03 = {"ps9u6Kn8p", "fRCCllxRFm9XYnsS5Nz0CDYYbd8rz98F", "veZY5LUK4HkumILqtvhVtf9OT9QK1Jmh", "8c6Edyt19YE2bwpDp37rWBgdyfN4I4si", "Dgwj6SSLqT", "biYcUlACC5CMDg3zbjwwDR7mq5XP76DA", "rp5V5gFYHfFnaijOqqdMDMWavMrEx7HP", "ycj43TNZcka4uMSCxDz6fuqQ2r9gi3g6"};
    public static final int A04 = (int) (CP.A02 * 8.0f);
    public final RelativeLayout A00;
    public final C12923g A01;
    public final C2699k1 A02;

    public C2533hF(C2699k1 c2699k1, A7 a7, String str, C12732n c12732n, DS ds, DR dr) {
        super(c2699k1, a7, str, c12732n, ds, dr);
        this.A02 = c2699k1;
        this.A01 = AbstractC12933h.A00(c2699k1.A02());
        this.A00 = new RelativeLayout(getContext());
        addView(this.A00, new RelativeLayout.LayoutParams(-1, -1));
        D3.A0K(this.A00, -1728053248);
        this.A00.setOnClickListener(new EM(this));
    }

    public static RelativeLayout.LayoutParams A0B(boolean z) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, z ? -1 : -2);
        layoutParams.addRule(12);
        return layoutParams;
    }

    private void A0C() {
        TransitionSet transitionSet = new TransitionSet();
        transitionSet.setOrdering(0);
        transitionSet.addTransition(new ChangeBounds()).addTransition(new Explode());
        D3.A0T(this, transitionSet);
    }

    @Override // com.facebook.ads.redexgen.core.EH
    public final void A0L() {
        C12963k c12963kA0A = this.A01.A0A();
        EW ew = new EW(this.A02);
        ew.setInfo(DB.HIDE_AD, this.A01.A0H(), this.A01.A0G());
        ew.setOnClickListener(new EN(this));
        C12963k c12963kA0B = this.A01.A0B();
        EW ew2 = new EW(this.A02);
        ew2.setInfo(DB.REPORT_AD, this.A01.A0L(), this.A01.A0K());
        ew2.setOnClickListener(new EO(this));
        EW ew3 = new EW(this.A02);
        ew3.setInfo(DB.AD_CHOICES_ICON, this.A01.A0M(), "");
        ew3.setOnClickListener(new EP(this));
        LinearLayout.LayoutParams itemParams = new LinearLayout.LayoutParams(-1, -2);
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setClickable(true);
        linearLayout.setOrientation(1);
        linearLayout.setPadding(A04 * 2, A04, A04 * 2, A04);
        D3.A0K(linearLayout, -1);
        if (!c12963kA0A.A05().isEmpty()) {
            linearLayout.addView(ew, itemParams);
        }
        if (!c12963kA0B.A05().isEmpty()) {
            linearLayout.addView(ew2, itemParams);
        }
        linearLayout.addView(ew3, itemParams);
        A0C();
        this.A00.removeAllViews();
        this.A00.addView(linearLayout, A0B(false));
    }

    @Override // com.facebook.ads.redexgen.core.EH
    public final void A0M() {
        D3.A0G(this);
        this.A00.removeAllViews();
        D3.A0H(this);
    }

    @Override // com.facebook.ads.redexgen.core.EH
    public final void A0N(C12963k c12963k, EnumC12943i enumC12943i) {
        String strA0E;
        int i;
        String strA01;
        if (enumC12943i == EnumC12943i.A05) {
            return;
        }
        boolean z = enumC12943i == EnumC12943i.A06;
        EF ef = new EF(this.A02, this.A0B);
        if (z) {
            C12923g c12923g = this.A01;
            if (A03[4].length() != 10) {
                throw new RuntimeException();
            }
            A03[6] = "KfE81dulHFmzGO7NxqDM7oaE1pV2dKkX";
            strA0E = c12923g.A0F();
        } else {
            strA0E = this.A01.A0E();
        }
        EF efA0E = ef.A0I(strA0E).A0H(this.A01.A0D()).A0F(c12963k.A04()).A0E(z ? DB.REPORT_AD : DB.HIDE_AD);
        if (z) {
            i = -552389;
        } else {
            i = -13272859;
        }
        EF efA0D = efA0E.A0D(i);
        if (this.A0A != null) {
            C12732n c12732n = this.A0A;
            if (A03[1].charAt(11) != 'X') {
                strA01 = c12732n.A01();
            } else {
                A03[0] = "vLdx3pZGf";
                strA01 = c12732n.A01();
            }
        } else {
            strA01 = "";
        }
        EG adHiddenView = efA0D.A0G(strA01).A0M();
        D3.A0K(adHiddenView, -1);
        D3.A0R(this);
        this.A00.removeAllViews();
        this.A00.addView(adHiddenView, A0B(true));
    }

    @Override // com.facebook.ads.redexgen.core.EH
    public final void A0O(C12963k c12963k, EnumC12943i enumC12943i) {
        String strA0H;
        boolean z = enumC12943i == EnumC12943i.A06;
        C2699k1 c2699k1 = this.A02;
        EJ ej = this.A0B;
        if (z) {
            strA0H = this.A01.A0L();
        } else {
            strA0H = this.A01.A0H();
        }
        EZ ez = new EZ(c2699k1, c12963k, ej, strA0H, z ? DB.REPORT_AD : DB.HIDE_AD);
        ez.setClickable(true);
        D3.A0K(ez, -1);
        ez.setPadding(A04 * 2, A04, A04 * 2, A04);
        A0C();
        this.A00.removeAllViews();
        RelativeLayout relativeLayout = this.A00;
        String[] strArr = A03;
        if (strArr[3].charAt(9) == strArr[5].charAt(9)) {
            throw new RuntimeException();
        }
        A03[1] = "OoQvJ70CiRWXlhIiWSDPNsGTFrOY4nX1";
        relativeLayout.addView(ez, A0B(false));
    }

    @Override // com.facebook.ads.redexgen.core.EH
    public final boolean A0P() {
        return false;
    }
}
