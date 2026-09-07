package com.yandex.mobile.ads.impl;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class bi2 implements ez1 {
    @Override // com.yandex.mobile.ads.impl.ez1
    public final void a(View skipView) {
        Intrinsics.checkNotNullParameter(skipView, "skipView");
        skipView.setVisibility(0);
        skipView.setAlpha(0.4f);
        skipView.setEnabled(false);
    }

    @Override // com.yandex.mobile.ads.impl.ez1
    public final void b(View skipView) {
        Intrinsics.checkNotNullParameter(skipView, "skipView");
        skipView.setVisibility(0);
        skipView.animate().alpha(1.0f).setDuration(200L);
        skipView.setEnabled(true);
    }
}
