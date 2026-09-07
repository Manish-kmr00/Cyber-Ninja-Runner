package com.facebook.ads.redexgen.core;

import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Hb, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1628Hb extends LinearLayout {
    public static final int A04 = (int) (CP.A02 * 32.0f);
    public static final int A05 = (int) (CP.A02 * 8.0f);
    public TextView A00;
    public TextView A01;
    public C1580Ff A02;
    public final C2699k1 A03;

    public C1628Hb(C2699k1 c2699k1) {
        super(c2699k1);
        this.A03 = c2699k1;
        A00(c2699k1);
    }

    private final void A00(C2699k1 c2699k1) {
        setGravity(16);
        this.A02 = new C1580Ff(c2699k1);
        this.A02.setFullCircleCorners(true);
        LinearLayout.LayoutParams pageImageViewParams = new LinearLayout.LayoutParams(A04, A04);
        pageImageViewParams.setMargins(0, 0, A05, 0);
        addView(this.A02, pageImageViewParams);
        LinearLayout pageInfoView = new LinearLayout(c2699k1);
        pageInfoView.setOrientation(1);
        this.A00 = new TextView(c2699k1);
        ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        D3.A0W(this.A00, true, 16);
        this.A00.setEllipsize(TextUtils.TruncateAt.END);
        this.A00.setSingleLine(true);
        this.A01 = new TextView(c2699k1);
        D3.A0W(this.A01, false, 14);
        pageInfoView.addView(this.A00);
        pageInfoView.addView(this.A01);
        addView(pageInfoView, layoutParams);
    }

    public final void A01() {
        this.A02.setImageBitmap(null);
        this.A00.setText("");
        this.A01.setText("");
    }

    public final void A02(int i, int i2) {
        this.A00.setTextColor(i);
        this.A01.setTextColor(i2);
    }

    public void setPageDetails(C12732n c12732n) {
        AsyncTaskC2494gc asyncTaskC2494gc = new AsyncTaskC2494gc(this.A02, this.A03);
        asyncTaskC2494gc.A05(A04, A04);
        asyncTaskC2494gc.A07(c12732n.A01());
        this.A00.setText(c12732n.A02());
        this.A01.setText(c12732n.A03());
    }
}
