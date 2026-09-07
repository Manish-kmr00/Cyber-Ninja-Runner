package com.smaato.sdk.video.vast.buildlight;

import com.smaato.sdk.core.util.collections.Lists;
import com.smaato.sdk.core.util.fi.NullableFunction;
import com.smaato.sdk.video.vast.model.Ad;
import com.smaato.sdk.video.vast.model.VastTree;
import com.smaato.sdk.video.vast.model.Wrapper;

/* JADX INFO: loaded from: classes12.dex */
final class ResolvedWrapperMergeUtils {
    static /* synthetic */ Ad lambda$mergeParsedResultWithParents$0(Ad ad, Ad ad2, Ad ad3) {
        return ad3 == ad ? ad2 : ad3;
    }

    static VastTree mergeParsedResultWithParents(VastTree vastTree, VastTree vastTree2, AdContainer<Wrapper> adContainer) {
        if (!vastTree2.ads.contains(adContainer.ad)) {
            throw new IllegalArgumentException("parentVastTree parameter should contains same ad that passed in parentWrapperContainer. Wrong argument passed for WrapperMergeUtilsTest::mergeParsedResultWithParents");
        }
        final Ad ad = adContainer.ad;
        final Ad adBuild = adContainer.ad.newBuilder().setWrapper(adContainer.model.newBuilder().setVastTree(vastTree).build()).build();
        return vastTree2.newBuilder().setAds(Lists.mapLazy(vastTree2.ads, new NullableFunction() { // from class: com.smaato.sdk.video.vast.buildlight.ResolvedWrapperMergeUtils$$ExternalSyntheticLambda0
            @Override // com.smaato.sdk.core.util.fi.NullableFunction
            public final Object apply(Object obj) {
                return ResolvedWrapperMergeUtils.lambda$mergeParsedResultWithParents$0(ad, adBuild, (Ad) obj);
            }
        })).build();
    }
}
