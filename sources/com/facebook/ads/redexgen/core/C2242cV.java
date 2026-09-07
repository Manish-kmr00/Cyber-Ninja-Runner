package com.facebook.ads.redexgen.core;

import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.cV, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2242cV extends C1581Fg {
    public final ImageView A00;
    public final C2699k1 A01;

    public C2242cV(C2699k1 c2699k1) {
        super(c2699k1);
        this.A01 = c2699k1;
        setRadius(30);
        this.A00 = new ImageView(c2699k1);
        this.A00.setAdjustViewBounds(true);
        addView(this.A00, new RelativeLayout.LayoutParams(-2, -1));
    }

    public final /* synthetic */ void A00(boolean z) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.width = -2;
        ViewGroup viewGroup = (ViewGroup) getParent();
        if (viewGroup != null) {
            viewGroup.updateViewLayout(this, layoutParams);
        }
    }

    public void setUrl(String str) {
        AsyncTaskC2494gc asyncTaskC2494gc = new AsyncTaskC2494gc(this.A00, this.A01);
        asyncTaskC2494gc.A04();
        asyncTaskC2494gc.A07(str);
        asyncTaskC2494gc.A06(new FA() { // from class: com.facebook.ads.redexgen.X.cX
            @Override // com.facebook.ads.redexgen.core.FA
            public final void ADM(boolean z) {
                this.A00.A00(z);
            }
        });
    }
}
