package com.facebook.ads.redexgen.core;

import android.text.TextUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.hg, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2560hg extends FH {
    public final TextView A00;
    public final TextView A01;
    public static final int A02 = (int) (CP.A02 * 36.0f);
    public static final int A05 = (int) (CP.A02 * 4.0f);
    public static final int A03 = (int) (CP.A02 * 8.0f);
    public static final int A04 = (int) (CP.A02 * 4.0f);

    public C2560hg(C2699k1 c2699k1, int i, C12622c c12622c, boolean z, String str, A7 a7, DR dr, JL jl, C1518Cv c1518Cv, C12672h c12672h) {
        super(c2699k1, null, i, c12622c, z, str, a7, dr, jl, c1518Cv, c12672h, false, "");
        setOrientation(0);
        setPadding(A05, A05, A05, A05);
        this.A01 = A02(-16448251, 13, true);
        this.A00 = A02(-10131605, 12, false);
        this.A06.addView(A01(i), new LinearLayout.LayoutParams(-1, -2));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        addView(this.A06, layoutParams);
        this.A08.setPadding(A03, 0, A03, 0);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, A02);
        layoutParams2.gravity = 17;
        addView(this.A08, layoutParams2);
    }

    private LinearLayout A01(int i) {
        LinearLayout linearLayout = new LinearLayout(this.A07);
        linearLayout.setOrientation(1);
        linearLayout.setPadding(A04, 0, A04, 0);
        linearLayout.addView(this.A01, FH.A0B);
        linearLayout.addView(this.A00, FH.A0B);
        LinearLayout linearLayout2 = new LinearLayout(this.A07);
        linearLayout2.setOrientation(0);
        linearLayout2.addView(this.A09, new LinearLayout.LayoutParams(i, i));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 16;
        linearLayout2.addView(linearLayout, layoutParams);
        return linearLayout2;
    }

    private TextView A02(int i, int i2, boolean z) {
        TextView textView = new TextView(this.A07);
        textView.setTextColor(i);
        textView.setSingleLine(true);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        D3.A0W(textView, z, i2);
        return textView;
    }

    @Override // com.facebook.ads.redexgen.core.FH
    public final void A0D(int i) {
    }

    @Override // com.facebook.ads.redexgen.core.FH
    public final void A0N() {
        super.A0N();
        setOnClickListener(this.A05);
    }

    @Override // com.facebook.ads.redexgen.core.FH
    public void setInfo(C12602a c12602a, C12632d c12632d, String str, String str2, CZ cz, FP fp) {
        super.setInfo(c12602a, c12632d, str, str2, cz, fp);
        this.A01.setText(c12602a.A0F());
        this.A00.setText(c12602a.A0E());
        if (TextUtils.isEmpty(c12632d.A04())) {
            D3.A0F(this.A08);
        }
    }
}
