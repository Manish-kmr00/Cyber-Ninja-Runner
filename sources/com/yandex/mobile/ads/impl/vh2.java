package com.yandex.mobile.ads.impl;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class vh2 implements mp {
    @Override // com.yandex.mobile.ads.impl.mp
    public final void a(View closeView) {
        Intrinsics.checkNotNullParameter(closeView, "closeView");
        closeView.setVisibility(8);
    }

    @Override // com.yandex.mobile.ads.impl.mp
    public final void b(View closeView) {
        Intrinsics.checkNotNullParameter(closeView, "closeView");
        closeView.setVisibility(0);
    }
}
