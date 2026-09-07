package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.graphics.Bitmap;
import com.monetization.ads.mediation.nativeads.MediatedNativeAd;
import java.util.HashMap;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class b51 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final i41 f8476a;

    public final o8<u61> a(MediatedNativeAd mediatedNativeAd, Map<String, Bitmap> imageValues, zq1 responseNativeType) {
        Intrinsics.checkNotNullParameter(mediatedNativeAd, "mediatedNativeAd");
        Intrinsics.checkNotNullParameter(imageValues, "imageValues");
        Intrinsics.checkNotNullParameter(responseNativeType, "responseNativeType");
        return new o8.a().a(new u61(CollectionsKt.listOf(new c41(responseNativeType, this.f8476a.a(mediatedNativeAd.getMediatedNativeAdAssets(), imageValues), null, null, null, null, null, null, CollectionsKt.emptyList(), CollectionsKt.emptyList())), CollectionsKt.emptyList(), CollectionsKt.emptyList(), null, new HashMap(), CollectionsKt.emptyList(), CollectionsKt.emptyList(), null, null, null)).a();
    }

    public /* synthetic */ b51(Context context) {
        this(context, new i41(context));
    }

    public b51(Context context, i41 nativeAdAssetsConverter) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(nativeAdAssetsConverter, "nativeAdAssetsConverter");
        this.f8476a = nativeAdAssetsConverter;
    }
}
