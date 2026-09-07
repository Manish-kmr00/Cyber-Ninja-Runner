package com.yandex.mobile.ads.impl;

import android.view.View;
import android.widget.ProgressBar;
import com.yandex.mobile.ads.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class y41 implements x41 {
    @Override // com.yandex.mobile.ads.impl.x41
    public final ProgressBar a(View container) {
        Intrinsics.checkNotNullParameter(container, "container");
        return null;
    }

    @Override // com.yandex.mobile.ads.impl.x41
    public final View b(View container) {
        Intrinsics.checkNotNullParameter(container, "container");
        return null;
    }

    @Override // com.yandex.mobile.ads.impl.x41
    public final View c(View container) {
        Intrinsics.checkNotNullParameter(container, "container");
        return container.findViewById(R.id.close);
    }
}
