package com.ogury.ad.internal;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class s0 implements r {
    @Override // com.ogury.ad.internal.r
    public final void a(j4 adController, h adLayout) {
        Intrinsics.checkNotNullParameter(adLayout, "adLayout");
        Intrinsics.checkNotNullParameter(adController, "adController");
        ViewGroup.LayoutParams layoutParams = adLayout.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        ((FrameLayout.LayoutParams) layoutParams).gravity = 0;
        adLayout.setLeft(0);
        adLayout.setTop(0);
        adLayout.a(adLayout.e);
    }
}
