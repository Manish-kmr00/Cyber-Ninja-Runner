package com.yandex.mobile.ads.impl;

import android.view.ViewGroup;
import android.widget.TextView;
import com.monetization.ads.fullscreen.template.view.CallToActionView;
import com.yandex.mobile.ads.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class rn<V extends ViewGroup> implements y00<V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final m61 f10124a;
    private final g41 b;

    public rn(m61 nativeAd, g41 nativeAdAssetViewProvider) {
        Intrinsics.checkNotNullParameter(nativeAd, "nativeAd");
        Intrinsics.checkNotNullParameter(nativeAdAssetViewProvider, "nativeAdAssetViewProvider");
        this.f10124a = nativeAd;
        this.b = nativeAdAssetViewProvider;
    }

    @Override // com.yandex.mobile.ads.impl.y00
    public final void a(V container) {
        Intrinsics.checkNotNullParameter(container, "container");
        this.b.getClass();
        Intrinsics.checkNotNullParameter(container, "container");
        TextView textView = (TextView) container.findViewById(R.id.call_to_action);
        zq1 adType = this.f10124a.getAdType();
        if (!(textView instanceof CallToActionView) || adType == zq1.d) {
            return;
        }
        ((CallToActionView) textView).a();
    }

    @Override // com.yandex.mobile.ads.impl.y00
    public final void c() {
    }
}
