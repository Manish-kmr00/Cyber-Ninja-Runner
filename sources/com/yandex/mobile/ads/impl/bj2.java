package com.yandex.mobile.ads.impl;

import android.view.ViewGroup;
import android.widget.TextView;
import com.yandex.mobile.ads.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class bj2<V extends ViewGroup> implements y00<V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final g41 f8514a;

    @Override // com.yandex.mobile.ads.impl.y00
    public final void a(V container) {
        Intrinsics.checkNotNullParameter(container, "container");
        this.f8514a.getClass();
        Intrinsics.checkNotNullParameter(container, "container");
        TextView textView = (TextView) container.findViewById(R.id.warning);
        if (textView != null) {
            textView.setSelected(true);
        }
    }

    @Override // com.yandex.mobile.ads.impl.y00
    public final void c() {
    }

    public /* synthetic */ bj2() {
        this(new g41());
    }

    public bj2(g41 nativeAdAssetViewProvider) {
        Intrinsics.checkNotNullParameter(nativeAdAssetViewProvider, "nativeAdAssetViewProvider");
        this.f8514a = nativeAdAssetViewProvider;
    }
}
