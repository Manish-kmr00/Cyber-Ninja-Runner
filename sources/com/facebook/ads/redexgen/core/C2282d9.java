package com.facebook.ads.redexgen.core;

import android.text.TextUtils;
import android.util.SparseBooleanArray;
import android.view.ViewGroup;
import java.lang.ref.WeakReference;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.d9, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2282d9 extends C6K implements DY {
    public static String[] A08 = {"biNTtjxa0xULALtZEUOcP", "rMVpYr4hwZgX", "y0rebd1hOaNR", "snwXdVXwO66aPvNuuMD2", "jxkMgVVp1g5", "Dcah1JX", "lglxOXHbCZFpcLf1TWQPAMUDis4zLCZx", "n80A5ryznQOlcAJIvKv7FeLq2ck19EHB"};
    public C12672h A00;
    public JK A01;
    public JL A02;
    public JL A03;
    public final int A04;
    public final SparseBooleanArray A05;
    public final C2699k1 A06;
    public final LU A07;

    public C2282d9(LU lu, SparseBooleanArray sparseBooleanArray, JL jl, int i, C2699k1 c2699k1, C12672h c12672h) {
        super(lu);
        this.A06 = c2699k1;
        this.A07 = lu;
        this.A05 = sparseBooleanArray;
        this.A02 = jl;
        this.A04 = i;
        this.A00 = c12672h;
    }

    private void A0A(A7 a7, C1518Cv c1518Cv, String str, C1629Hc c1629Hc) {
        if (this.A05.get(c1629Hc.A02())) {
            return;
        }
        if (this.A03 != null) {
            this.A03.A0V();
            String[] strArr = A08;
            if (strArr[1].length() != strArr[2].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A08;
            strArr2[3] = "sEemyGdXpNnP2WRBMWcD";
            strArr2[0] = "kawPFcVLuq3VyedHvbBIc";
            this.A03 = null;
        }
        this.A01 = new C2285dC(this, str, c1629Hc, a7, c1629Hc.A04(), c1518Cv);
        this.A03 = new JL(this.A07, 10, new WeakReference(this.A01), this.A06);
        this.A03.A0Y(false);
        this.A03.A0W(100);
        this.A03.A0X(100);
        this.A07.setOnAssetsLoadedListener(new C2284dB(this, c1629Hc));
    }

    public final void A0j(C1629Hc c1629Hc, A7 a7, C14067t c14067t, C1518Cv c1518Cv, String str, int i, int i2, int i3) {
        int iA02 = c1629Hc.A02();
        this.A07.setTag(-1593835536, Integer.valueOf(iA02));
        this.A07.setupNativeCtaExtension(c1629Hc);
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(i, -2);
        int rightMargin = iA02 == 0 ? i3 : i2;
        if (iA02 < this.A04 - 1) {
            i3 = i2;
        }
        String[] strArr = A08;
        if (strArr[1].length() != strArr[2].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A08;
        strArr2[1] = "ng4t5bAKqCWK";
        strArr2[2] = "n9xBZs9SEWUc";
        marginLayoutParams.setMargins(rightMargin, 0, i3, 0);
        String strA08 = c1629Hc.A03().A0F().A08();
        String strA09 = c1629Hc.A03().A0F().A09();
        this.A07.setIsVideo(!TextUtils.isEmpty(strA09));
        if (this.A07.A1F()) {
            this.A07.setVideoPlaceholderUrl(strA08);
            this.A07.setVideoUrl(c14067t.A0S(strA09));
        } else {
            this.A07.setImageUrl(strA08);
        }
        this.A07.setLayoutParams(marginLayoutParams);
        this.A07.setCTAInfo(c1629Hc.A03().A0H(), c1629Hc.A04());
        this.A07.A1G(c1629Hc.A04());
        A0A(a7, c1518Cv, str, c1629Hc);
    }

    public final void A0k(JL jl) {
        this.A02 = jl;
    }

    @Override // com.facebook.ads.redexgen.core.DY
    public final void AIL() {
        this.A07.A1A();
    }
}
