package com.yandex.mobile.ads.impl;

import android.view.ViewGroup;
import android.widget.ImageView;
import com.monetization.ads.nativeads.ExtendedNativeAdView;
import com.yandex.mobile.ads.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class ar implements y00<ExtendedNativeAdView> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ot f8435a;
    private final int b;

    public ar(ot nativeAdAssets, int i) {
        Intrinsics.checkNotNullParameter(nativeAdAssets, "nativeAdAssets");
        this.f8435a = nativeAdAssets;
        this.b = i;
    }

    @Override // com.yandex.mobile.ads.impl.y00
    public final void c() {
    }

    @Override // com.yandex.mobile.ads.impl.y00
    public final void a(ViewGroup viewGroup) {
        ExtendedNativeAdView adView = (ExtendedNativeAdView) viewGroup;
        Intrinsics.checkNotNullParameter(adView, "adView");
        br brVar = new br(this.f8435a, this.b, new d41());
        ImageView imageViewA = brVar.a(adView);
        ImageView imageViewB = brVar.b(adView);
        if (imageViewA != null) {
            imageViewA.setId(R.id.favicon);
        }
        if (imageViewB != null) {
            imageViewB.setId(R.id.icon);
        }
    }
}
