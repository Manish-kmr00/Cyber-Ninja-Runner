package com.bytedance.sdk.openadsdk.ML;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.component.omh.omh;
import com.bytedance.sdk.component.utils.WQf;
import com.bytedance.sdk.component.utils.WV;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerAdLoadListener;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerRequest;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerSize;
import com.bytedance.sdk.openadsdk.api.factory.IADLoader;
import com.bytedance.sdk.openadsdk.api.factory.IADTypeLoaderFactory;
import com.bytedance.sdk.openadsdk.api.interstitial.PAGInterstitialAdLoadListener;
import com.bytedance.sdk.openadsdk.api.interstitial.PAGInterstitialRequest;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAdLoadListener;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeRequest;
import com.bytedance.sdk.openadsdk.api.open.PAGAppOpenAdLoadListener;
import com.bytedance.sdk.openadsdk.api.open.PAGAppOpenRequest;
import com.bytedance.sdk.openadsdk.api.reward.PAGRewardedAdLoadListener;
import com.bytedance.sdk.openadsdk.api.reward.PAGRewardedRequest;
import com.bytedance.sdk.openadsdk.core.aBv;
import com.bytedance.sdk.openadsdk.core.omh.SD;
import com.bytedance.sdk.openadsdk.pA.ML.Og;
import com.bytedance.sdk.openadsdk.pA.Og.ML;
import com.bytedance.sdk.openadsdk.utils.gbA;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes4.dex */
public class pA implements IADTypeLoaderFactory {
    @Override // com.bytedance.sdk.openadsdk.api.factory.IADTypeLoaderFactory
    public IADLoader<PAGAppOpenRequest, PAGAppOpenAdLoadListener> createOpenAdLoader() {
        return new IADLoader<PAGAppOpenRequest, PAGAppOpenAdLoadListener>() { // from class: com.bytedance.sdk.openadsdk.ML.pA.1
            private int Og;

            @Override // com.bytedance.sdk.openadsdk.api.factory.IADLoader
            /* JADX INFO: renamed from: pA, reason: merged with bridge method [inline-methods] */
            public void loadAd(String str, PAGAppOpenRequest pAGAppOpenRequest, PAGAppOpenAdLoadListener pAGAppOpenAdLoadListener) {
                if (com.bytedance.sdk.openadsdk.pA.pA.pA(str, pAGAppOpenRequest, pAGAppOpenAdLoadListener)) {
                    return;
                }
                AdSlot.Builder builder = new AdSlot.Builder();
                com.bytedance.sdk.openadsdk.pA.pA.pA(builder, pAGAppOpenRequest);
                if (!TextUtils.isEmpty(pAGAppOpenRequest.getAdString())) {
                    builder.withBid(pAGAppOpenRequest.getAdString());
                }
                final AdSlot adSlotBuild = builder.setCodeId(str).setRequestExtraMap(pAGAppOpenRequest.getExtraInfo()).build();
                if (pAGAppOpenRequest != null) {
                    this.Og = pAGAppOpenRequest.getTimeout();
                }
                final com.bytedance.sdk.openadsdk.pA.ZZv.pA pAVar = new com.bytedance.sdk.openadsdk.pA.ZZv.pA(pAGAppOpenAdLoadListener);
                com.bytedance.sdk.openadsdk.pA.pA.pA(new omh("loadSplashAd") { // from class: com.bytedance.sdk.openadsdk.ML.pA.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            if (!aBv.ZZv().oX() && gbA.yFO()) {
                                pAVar.onError(-18, "Blind mode does not allow requesting ads");
                                return;
                            }
                            if (com.bytedance.sdk.openadsdk.pA.pA.pA(pAVar)) {
                                return;
                            }
                            if (adSlotBuild == null) {
                                pAVar.onError(-4, "adslot is null");
                                return;
                            }
                            Method methodPA = WQf.pA("com.bytedance.sdk.openadsdk.TTC2Proxy", "load", Context.class, AdSlot.class, PAGAppOpenAdLoadListener.class, Integer.TYPE);
                            if (methodPA != null) {
                                methodPA.invoke(null, aBv.pA(), adSlotBuild, pAVar, Integer.valueOf(AnonymousClass1.this.Og));
                            }
                        } catch (Throwable th) {
                            WV.pA("ADNFactory", "open component maybe not exist, please check", th);
                        }
                    }
                }, pAVar, adSlotBuild);
            }
        };
    }

    @Override // com.bytedance.sdk.openadsdk.api.factory.IADTypeLoaderFactory
    public IADLoader<PAGBannerRequest, PAGBannerAdLoadListener> createBannerAdLoader() {
        return new IADLoader<PAGBannerRequest, PAGBannerAdLoadListener>() { // from class: com.bytedance.sdk.openadsdk.ML.pA.2
            @Override // com.bytedance.sdk.openadsdk.api.factory.IADLoader
            /* JADX INFO: renamed from: pA, reason: merged with bridge method [inline-methods] */
            public void loadAd(String str, PAGBannerRequest pAGBannerRequest, PAGBannerAdLoadListener pAGBannerAdLoadListener) {
                if (com.bytedance.sdk.openadsdk.pA.pA.pA(str, pAGBannerRequest, pAGBannerAdLoadListener)) {
                    return;
                }
                AdSlot.Builder codeId = new AdSlot.Builder().setCodeId(str);
                com.bytedance.sdk.openadsdk.pA.pA.pA(codeId, pAGBannerRequest);
                if (!TextUtils.isEmpty(pAGBannerRequest.getAdString())) {
                    codeId.withBid(pAGBannerRequest.getAdString());
                }
                PAGBannerSize adSize = pAGBannerRequest != null ? pAGBannerRequest.getAdSize() : null;
                if (adSize != null) {
                    codeId.setExpressViewAcceptedSize(adSize.getWidth(), adSize.getHeight());
                }
                final AdSlot adSlotBuild = codeId.setRequestExtraMap(pAGBannerRequest.getExtraInfo()).build();
                final com.bytedance.sdk.openadsdk.pA.pA.pA pAVar = new com.bytedance.sdk.openadsdk.pA.pA.pA(pAGBannerAdLoadListener);
                com.bytedance.sdk.openadsdk.pA.pA.pA(new omh("loadBannerExpressAd") { // from class: com.bytedance.sdk.openadsdk.ML.pA.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!aBv.ZZv().oX() && gbA.yFO()) {
                            pAVar.onError(-18, "Blind mode does not allow requesting ads");
                            return;
                        }
                        if (com.bytedance.sdk.openadsdk.pA.pA.pA(pAVar)) {
                            return;
                        }
                        AdSlot adSlot = adSlotBuild;
                        if (adSlot == null) {
                            pAVar.onError(-4, "adslot is null");
                            return;
                        }
                        adSlot.setNativeAdType(1);
                        adSlotBuild.setDurationSlotType(1);
                        SD.pA(aBv.pA()).pA(adSlotBuild, 1, pAVar, 5000);
                    }
                }, pAVar, adSlotBuild);
            }
        };
    }

    @Override // com.bytedance.sdk.openadsdk.api.factory.IADTypeLoaderFactory
    public IADLoader<PAGNativeRequest, PAGNativeAdLoadListener> createNativeAdLoader() {
        return new IADLoader<PAGNativeRequest, PAGNativeAdLoadListener>() { // from class: com.bytedance.sdk.openadsdk.ML.pA.3
            @Override // com.bytedance.sdk.openadsdk.api.factory.IADLoader
            /* JADX INFO: renamed from: pA, reason: merged with bridge method [inline-methods] */
            public void loadAd(String str, PAGNativeRequest pAGNativeRequest, PAGNativeAdLoadListener pAGNativeAdLoadListener) {
                if (com.bytedance.sdk.openadsdk.pA.pA.pA(str, pAGNativeRequest, pAGNativeAdLoadListener)) {
                    return;
                }
                final ML ml = new ML(pAGNativeAdLoadListener);
                AdSlot.Builder builderWithBid = new AdSlot.Builder().setCodeId(str).withBid(pAGNativeRequest != null ? pAGNativeRequest.getAdString() : null);
                com.bytedance.sdk.openadsdk.pA.pA.pA(builderWithBid, pAGNativeRequest);
                final AdSlot adSlotBuild = builderWithBid.setRequestExtraMap(pAGNativeRequest.getExtraInfo()).build();
                com.bytedance.sdk.openadsdk.pA.pA.pA(new omh("loadFeedAd") { // from class: com.bytedance.sdk.openadsdk.ML.pA.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!aBv.ZZv().oX() && gbA.yFO()) {
                            ml.onError(-18, "Blind mode does not allow requesting ads");
                            return;
                        }
                        if (com.bytedance.sdk.openadsdk.pA.pA.pA(ml)) {
                            return;
                        }
                        if (adSlotBuild == null) {
                            ml.onError(-4, "adslot is null");
                            return;
                        }
                        try {
                            Method methodPA = WQf.pA("com.bytedance.sdk.openadsdk.TTC5Proxy", "loadFeed", Context.class, AdSlot.class, PAGNativeAdLoadListener.class);
                            if (methodPA != null) {
                                methodPA.invoke(null, aBv.pA(), adSlotBuild, ml);
                            }
                        } catch (Throwable unused) {
                        }
                    }
                }, ml, adSlotBuild);
            }
        };
    }

    @Override // com.bytedance.sdk.openadsdk.api.factory.IADTypeLoaderFactory
    public IADLoader<PAGRewardedRequest, PAGRewardedAdLoadListener> createRewardAdLoader() {
        return new IADLoader<PAGRewardedRequest, PAGRewardedAdLoadListener>() { // from class: com.bytedance.sdk.openadsdk.ML.pA.4
            @Override // com.bytedance.sdk.openadsdk.api.factory.IADLoader
            /* JADX INFO: renamed from: pA, reason: merged with bridge method [inline-methods] */
            public void loadAd(String str, PAGRewardedRequest pAGRewardedRequest, PAGRewardedAdLoadListener pAGRewardedAdLoadListener) {
                if (com.bytedance.sdk.openadsdk.pA.pA.pA(str, pAGRewardedRequest, pAGRewardedAdLoadListener)) {
                    return;
                }
                AdSlot.Builder codeId = new AdSlot.Builder().setCodeId(str);
                if (!TextUtils.isEmpty(pAGRewardedRequest.getAdString())) {
                    codeId.withBid(pAGRewardedRequest.getAdString());
                }
                com.bytedance.sdk.openadsdk.pA.pA.pA(codeId, pAGRewardedRequest);
                final AdSlot adSlotBuild = codeId.setRequestExtraMap(pAGRewardedRequest.getExtraInfo()).build();
                final Og og = new Og(pAGRewardedAdLoadListener);
                com.bytedance.sdk.openadsdk.pA.pA.pA(new omh("loadRewardVideoAd") { // from class: com.bytedance.sdk.openadsdk.ML.pA.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!aBv.ZZv().oX() && gbA.yFO()) {
                            og.onError(-18, "Blind mode does not allow requesting ads");
                            return;
                        }
                        if (com.bytedance.sdk.openadsdk.pA.pA.pA(og)) {
                            return;
                        }
                        if (adSlotBuild == null) {
                            og.onError(-4, "adslot is null");
                            return;
                        }
                        try {
                            Method methodPA = WQf.pA("com.bytedance.sdk.openadsdk.TTC3Proxy", "loadReward", Context.class, AdSlot.class, PAGRewardedAdLoadListener.class);
                            if (methodPA != null) {
                                methodPA.invoke(null, aBv.pA(), adSlotBuild, og);
                            }
                        } catch (Throwable unused) {
                        }
                    }
                }, og, adSlotBuild);
            }
        };
    }

    @Override // com.bytedance.sdk.openadsdk.api.factory.IADTypeLoaderFactory
    public IADLoader<PAGInterstitialRequest, PAGInterstitialAdLoadListener> createInterstitialAdLoader() {
        return new IADLoader<PAGInterstitialRequest, PAGInterstitialAdLoadListener>() { // from class: com.bytedance.sdk.openadsdk.ML.pA.5
            @Override // com.bytedance.sdk.openadsdk.api.factory.IADLoader
            /* JADX INFO: renamed from: pA, reason: merged with bridge method [inline-methods] */
            public void loadAd(String str, PAGInterstitialRequest pAGInterstitialRequest, PAGInterstitialAdLoadListener pAGInterstitialAdLoadListener) {
                if (com.bytedance.sdk.openadsdk.pA.pA.pA(str, pAGInterstitialRequest, pAGInterstitialAdLoadListener)) {
                    return;
                }
                AdSlot.Builder codeId = new AdSlot.Builder().setRequestExtraMap(pAGInterstitialRequest.getExtraInfo()).setCodeId(str);
                com.bytedance.sdk.openadsdk.pA.pA.pA(codeId, pAGInterstitialRequest);
                if (!TextUtils.isEmpty(pAGInterstitialRequest.getAdString())) {
                    codeId.withBid(pAGInterstitialRequest.getAdString());
                }
                final AdSlot adSlotBuild = codeId.build();
                final com.bytedance.sdk.openadsdk.pA.KZx.pA pAVar = new com.bytedance.sdk.openadsdk.pA.KZx.pA(pAGInterstitialAdLoadListener);
                com.bytedance.sdk.openadsdk.pA.pA.pA(new omh("loadInterstitialAd") { // from class: com.bytedance.sdk.openadsdk.ML.pA.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!aBv.ZZv().oX() && gbA.yFO()) {
                            pAVar.onError(-18, "Blind mode does not allow requesting ads");
                            return;
                        }
                        if (com.bytedance.sdk.openadsdk.pA.pA.pA(pAVar)) {
                            return;
                        }
                        if (adSlotBuild == null) {
                            pAVar.onError(-4, "adslot is null");
                            return;
                        }
                        try {
                            Method methodPA = WQf.pA("com.bytedance.sdk.openadsdk.TTC3Proxy", "loadFull", Context.class, AdSlot.class, PAGInterstitialAdLoadListener.class);
                            if (methodPA != null) {
                                methodPA.invoke(null, aBv.pA(), adSlotBuild, pAVar);
                            }
                        } catch (Throwable unused) {
                        }
                    }
                }, pAVar, adSlotBuild);
            }
        };
    }
}
