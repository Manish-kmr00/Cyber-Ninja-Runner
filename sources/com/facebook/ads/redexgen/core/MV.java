package com.facebook.ads.redexgen.core;

import android.graphics.drawable.Drawable;
import android.view.View;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class MV extends C2782lP {
    @Override // com.facebook.ads.redexgen.core.C13184g
    public final int A02(View view) {
        return view.getImportantForAccessibility();
    }

    @Override // com.facebook.ads.redexgen.core.C13184g
    public final int A04(View view) {
        return view.getMinimumHeight();
    }

    @Override // com.facebook.ads.redexgen.core.C13184g
    public final int A05(View view) {
        return view.getMinimumWidth();
    }

    @Override // com.facebook.ads.redexgen.core.C13184g
    public final void A09(View view) {
        view.postInvalidateOnAnimation();
    }

    @Override // com.facebook.ads.redexgen.core.C13184g
    public final void A0C(View view, Drawable drawable) {
        view.setBackground(drawable);
    }

    @Override // com.facebook.ads.redexgen.core.C13184g
    public final void A0F(View view, Runnable runnable) {
        view.postOnAnimation(runnable);
    }

    @Override // com.facebook.ads.redexgen.core.C13184g
    public final void A0G(View view, Runnable runnable, long j) {
        view.postOnAnimationDelayed(runnable, j);
    }

    @Override // com.facebook.ads.redexgen.core.C13184g
    public final boolean A0I(View view) {
        return view.hasTransientState();
    }
}
