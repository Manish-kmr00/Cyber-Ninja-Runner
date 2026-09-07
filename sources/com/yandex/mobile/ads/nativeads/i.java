package com.yandex.mobile.ads.nativeads;

import com.yandex.mobile.ads.impl.a61;
import com.yandex.mobile.ads.impl.m61;
import com.yandex.mobile.ads.impl.uz1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class i extends e implements SliderAd {
    private final uz1 d;
    private final g e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(uz1 sliderAdPrivate, g nativeAdViewBinderAdapter) {
        super(sliderAdPrivate);
        Intrinsics.checkNotNullParameter(sliderAdPrivate, "sliderAdPrivate");
        Intrinsics.checkNotNullParameter(nativeAdViewBinderAdapter, "nativeAdViewBinderAdapter");
        this.d = sliderAdPrivate;
        this.e = nativeAdViewBinderAdapter;
    }

    @Override // com.yandex.mobile.ads.nativeads.SliderAd
    public final void bindSliderAd(NativeAdViewBinder viewBinder) throws a61 {
        Intrinsics.checkNotNullParameter(viewBinder, "viewBinder");
        this.e.getClass();
        this.d.a(g.a(viewBinder));
    }

    @Override // com.yandex.mobile.ads.nativeads.e
    public final boolean equals(Object obj) {
        return (obj instanceof i) && Intrinsics.areEqual(((i) obj).d, this.d);
    }

    @Override // com.yandex.mobile.ads.nativeads.SliderAd
    public final List<NativeAd> getNativeAds() {
        ArrayList arrayListD = this.d.d();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayListD, 10));
        Iterator it = arrayListD.iterator();
        while (it.hasNext()) {
            arrayList.add(new e((m61) it.next()));
        }
        return arrayList;
    }

    @Override // com.yandex.mobile.ads.nativeads.e
    public final int hashCode() {
        return this.d.hashCode();
    }
}
