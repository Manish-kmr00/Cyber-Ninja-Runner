package com.yandex.mobile.ads.impl;

import android.view.View;
import android.widget.TextView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class h52 implements g52 {
    @Override // com.yandex.mobile.ads.impl.g52
    public final TextView a(View container) {
        Intrinsics.checkNotNullParameter(container, "container");
        View viewFindViewWithTag = container.findViewWithTag("timer_value");
        if (viewFindViewWithTag instanceof TextView) {
            return (TextView) viewFindViewWithTag;
        }
        return null;
    }

    @Override // com.yandex.mobile.ads.impl.g52
    public final View b(View container) {
        Intrinsics.checkNotNullParameter(container, "container");
        View viewFindViewWithTag = container.findViewWithTag("timer_container");
        if (viewFindViewWithTag instanceof View) {
            return viewFindViewWithTag;
        }
        return null;
    }
}
