package com.yandex.mobile.ads.impl;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class l00 implements ez1 {
    @Override // com.yandex.mobile.ads.impl.ez1
    public final void a(View skipView) {
        Intrinsics.checkNotNullParameter(skipView, "skipView");
        skipView.setVisibility(8);
        skipView.setEnabled(false);
    }

    @Override // com.yandex.mobile.ads.impl.ez1
    public final void b(View skipView) {
        Intrinsics.checkNotNullParameter(skipView, "skipView");
        skipView.setVisibility(0);
        skipView.setEnabled(true);
    }
}
