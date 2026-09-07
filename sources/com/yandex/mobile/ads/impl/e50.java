package com.yandex.mobile.ads.impl;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class e50 implements mp {
    @Override // com.yandex.mobile.ads.impl.mp
    public final void a(View closeView) {
        Intrinsics.checkNotNullParameter(closeView, "closeView");
        closeView.setAlpha(0.4f);
        closeView.setEnabled(false);
    }

    @Override // com.yandex.mobile.ads.impl.mp
    public final void b(View closeView) {
        Intrinsics.checkNotNullParameter(closeView, "closeView");
        closeView.animate().alpha(1.0f).setDuration(200L);
        closeView.setEnabled(true);
    }
}
