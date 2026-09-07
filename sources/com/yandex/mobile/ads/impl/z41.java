package com.yandex.mobile.ads.impl;

import android.view.View;
import android.widget.ProgressBar;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class z41 implements x41 {
    @Override // com.yandex.mobile.ads.impl.x41
    public final ProgressBar a(View container) {
        Intrinsics.checkNotNullParameter(container, "container");
        return (ProgressBar) container.findViewWithTag("close_progress_view");
    }

    @Override // com.yandex.mobile.ads.impl.x41
    public final View b(View container) {
        Intrinsics.checkNotNullParameter(container, "container");
        return container.findViewWithTag("skip_button");
    }

    @Override // com.yandex.mobile.ads.impl.x41
    public final View c(View container) {
        Intrinsics.checkNotNullParameter(container, "container");
        return container.findViewWithTag("close");
    }
}
