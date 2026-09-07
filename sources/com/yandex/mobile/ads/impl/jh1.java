package com.yandex.mobile.ads.impl;

import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.yandex.mobile.ads.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class jh1<V extends ViewGroup> implements y00<V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ot f9318a;
    private final d41 b;
    private final g41 c;

    public jh1(ot nativeAdAssets, d41 nativeAdAdditionalViewProvider, g41 nativeAdAssetViewProvider) {
        Intrinsics.checkNotNullParameter(nativeAdAssets, "nativeAdAssets");
        Intrinsics.checkNotNullParameter(nativeAdAdditionalViewProvider, "nativeAdAdditionalViewProvider");
        Intrinsics.checkNotNullParameter(nativeAdAssetViewProvider, "nativeAdAssetViewProvider");
        this.f9318a = nativeAdAssets;
        this.b = nativeAdAdditionalViewProvider;
        this.c = nativeAdAssetViewProvider;
    }

    @Override // com.yandex.mobile.ads.impl.y00
    public final void a(V container) {
        Intrinsics.checkNotNullParameter(container, "container");
        this.b.getClass();
        Intrinsics.checkNotNullParameter(container, "container");
        ImageView imageView = (ImageView) container.findViewById(R.id.icon_placeholder);
        qt qtVarG = this.f9318a.g();
        qt qtVarE = this.f9318a.e();
        if (imageView != null && qtVarG == null && qtVarE == null) {
            this.c.getClass();
            Intrinsics.checkNotNullParameter(container, "container");
            ch2 ch2Var = new ch2((TextView) container.findViewById(R.id.title));
            imageView.setVisibility(0);
            imageView.setOnClickListener(ch2Var);
        }
    }

    @Override // com.yandex.mobile.ads.impl.y00
    public final void c() {
    }
}
