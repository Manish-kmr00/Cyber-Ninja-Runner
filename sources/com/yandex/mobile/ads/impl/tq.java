package com.yandex.mobile.ads.impl;

import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class tq {
    public static yq a(m61 nativeAd, wr contentCloseListener, pt nativeAdEventListener, y00 adTypeSpecificBinder, lp1 reporter) {
        Intrinsics.checkNotNullParameter(nativeAd, "nativeAd");
        Intrinsics.checkNotNullParameter(contentCloseListener, "contentCloseListener");
        Intrinsics.checkNotNullParameter(nativeAdEventListener, "nativeAdEventListener");
        Intrinsics.checkNotNullParameter(adTypeSpecificBinder, "adTypeSpecificBinder");
        Intrinsics.checkNotNullParameter(reporter, "reporter");
        ot adAssets = nativeAd.getAdAssets();
        return new yq(new yd0(nativeAd, contentCloseListener, nativeAdEventListener, reporter, new dh(CollectionsKt.emptyList()), new g41()), new yc(adAssets, new j51()), new tv0(adAssets, new w41()), new gn1(adAssets, new hn1(), new d41(), new w41()), adTypeSpecificBinder);
    }
}
