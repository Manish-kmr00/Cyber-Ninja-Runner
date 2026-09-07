package com.facebook.ads.redexgen.core;

import android.text.TextUtils;
import android.util.SparseBooleanArray;
import android.view.ViewGroup;
import java.lang.ref.WeakReference;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.ci, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2255ci extends C6K implements DY {
    public C12672h A00;
    public JK A01;
    public JL A02;
    public JL A03;
    public final int A04;
    public final int A05;
    public final int A06;
    public final int A07;
    public final SparseBooleanArray A08;
    public final C2699k1 A09;
    public final LK A0A;

    public C2255ci(LK lk, SparseBooleanArray sparseBooleanArray, JL jl, int i, int i2, int i3, int i4, C2699k1 c2699k1, C12672h c12672h) {
        super(lk);
        this.A09 = c2699k1;
        this.A0A = lk;
        this.A08 = sparseBooleanArray;
        this.A02 = jl;
        this.A04 = i;
        this.A05 = i2;
        this.A06 = i3;
        this.A07 = i4;
        this.A00 = c12672h;
    }

    private void A0A(A7 a7, C1518Cv c1518Cv, String str, C1629Hc c1629Hc) {
        if (this.A08.get(c1629Hc.A02())) {
            return;
        }
        if (this.A03 != null) {
            this.A03.A0V();
            this.A03 = null;
        }
        this.A01 = new C2257ck(this, str, c1629Hc, a7, c1629Hc.A04(), c1518Cv);
        this.A03 = new JL(this.A0A, 10, new WeakReference(this.A01), this.A09);
        this.A03.A0Y(false);
        this.A03.A0W(100);
        this.A03.A0X(100);
        this.A0A.setOnAssetsLoadedListener(new C2256cj(this, c1629Hc));
    }

    public final ViewOnClickListenerC2488gW A0j() {
        return this.A0A.getCtaButton();
    }

    public final void A0k(C1629Hc c1629Hc, A7 a7, C14067t c14067t, C1518Cv c1518Cv, String str) {
        int iA02 = c1629Hc.A02();
        this.A0A.setTag(-1593835536, Integer.valueOf(iA02));
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(this.A04, -2);
        int rightMargin = iA02 == 0 ? this.A05 : this.A06;
        int position = this.A07;
        marginLayoutParams.setMargins(rightMargin, 0, iA02 >= position + (-1) ? this.A05 : this.A06, 0);
        String imageUrl = c1629Hc.A03().A0F().A08();
        String strA09 = c1629Hc.A03().A0F().A09();
        this.A0A.setIsVideo(!TextUtils.isEmpty(strA09));
        if (this.A0A.A1F()) {
            this.A0A.setVideoPlaceholderUrl(imageUrl);
            this.A0A.setVideoUrl(c14067t.A0S(strA09));
        } else {
            this.A0A.setImageUrl(imageUrl);
        }
        this.A0A.setLayoutParams(marginLayoutParams);
        this.A0A.setAdTitleAndDescription(c1629Hc.A03().A0G().A0F(), c1629Hc.A03().A0G().A04());
        this.A0A.setCTAInfo(c1629Hc.A03().A0H(), c1629Hc.A04());
        this.A0A.A1I(c1629Hc.A04());
        A0A(a7, c1518Cv, str, c1629Hc);
    }

    @Override // com.facebook.ads.redexgen.core.DY
    public final void AIL() {
        this.A0A.A1A();
    }
}
