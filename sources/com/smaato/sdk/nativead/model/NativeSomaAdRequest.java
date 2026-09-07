package com.smaato.sdk.nativead.model;

import com.smaato.sdk.core.ad.AdFormat;
import com.smaato.sdk.core.mvvm.model.AdRequest;
import com.smaato.sdk.core.mvvm.model.soma.SomaAdRequest;
import com.smaato.sdk.nativead.NativeAdRequest;

/* JADX INFO: loaded from: classes13.dex */
public class NativeSomaAdRequest extends SomaAdRequest {
    private final boolean shouldFetchPrivacy;
    private final boolean shouldReturnUrlsForImageAssets;

    static /* synthetic */ void lambda$buildFrom$0() {
    }

    static /* synthetic */ void lambda$buildFrom$1() {
    }

    public NativeSomaAdRequest(AdRequest adRequest, boolean z, boolean z2) {
        super(adRequest);
        this.shouldFetchPrivacy = z;
        this.shouldReturnUrlsForImageAssets = z2;
    }

    public static NativeSomaAdRequest buildFrom(NativeAdRequest nativeAdRequest) {
        return new NativeSomaAdRequest(AdRequest.builder().setAdSpaceId(nativeAdRequest.adSpaceId()).setAdFormat(AdFormat.NATIVE).setMediationAdapterVersion(nativeAdRequest.mediationAdapterVersion()).setMediationNetworkName(nativeAdRequest.mediationNetworkName()).setMediationNetworkSdkVersion(nativeAdRequest.mediationNetworkSdkVersion()).setUBUniqueId(nativeAdRequest.uniqueUBId()).setOnCsmAdClicked(new Runnable() { // from class: com.smaato.sdk.nativead.model.NativeSomaAdRequest$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                NativeSomaAdRequest.lambda$buildFrom$0();
            }
        }).setOnCsmAdExpired(new Runnable() { // from class: com.smaato.sdk.nativead.model.NativeSomaAdRequest$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                NativeSomaAdRequest.lambda$buildFrom$1();
            }
        }).build(), nativeAdRequest.shouldFetchPrivacy(), nativeAdRequest.shouldReturnUrlsForImageAssets());
    }

    public boolean shouldFetchPrivacy() {
        return this.shouldFetchPrivacy;
    }

    public boolean shouldReturnUrlsForImageAssets() {
        return this.shouldReturnUrlsForImageAssets;
    }
}
