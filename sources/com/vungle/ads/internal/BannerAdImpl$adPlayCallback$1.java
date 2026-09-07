package com.vungle.ads.internal;

import com.json.nu;
import com.vungle.ads.AnalyticsClient;
import com.vungle.ads.BaseAdListener;
import com.vungle.ads.VungleError;
import com.vungle.ads.internal.presenter.AdPlayCallback;
import com.vungle.ads.internal.util.ThreadUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BannerAdImpl.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\t\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\n\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH\u0016¨\u0006\u000e"}, d2 = {"com/vungle/ads/internal/BannerAdImpl$adPlayCallback$1", "Lcom/vungle/ads/internal/presenter/AdPlayCallback;", "onAdClick", "", "id", "", "onAdEnd", "onAdImpression", nu.k, nu.i, "onAdStart", "onFailure", "error", "Lcom/vungle/ads/VungleError;", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class BannerAdImpl$adPlayCallback$1 implements AdPlayCallback {
    final /* synthetic */ BannerAdImpl this$0;

    @Override // com.vungle.ads.internal.presenter.AdPlayCallback
    public void onAdRewarded(String id) {
    }

    BannerAdImpl$adPlayCallback$1(BannerAdImpl bannerAdImpl) {
        this.this$0 = bannerAdImpl;
    }

    @Override // com.vungle.ads.internal.presenter.AdPlayCallback
    public void onAdStart(String id) {
        this.this$0.getSignalManager$vungle_ads_release().increaseSessionDepthCounter();
        this.this$0.getAdInternal$vungle_ads_release().getValidationToPresentMetric$vungle_ads_release().markEnd();
        AnalyticsClient.logMetric$vungle_ads_release$default(AnalyticsClient.INSTANCE, this.this$0.getAdInternal$vungle_ads_release().getValidationToPresentMetric$vungle_ads_release(), this.this$0.getLogEntry(), (String) null, 4, (Object) null);
        this.this$0.getPresentToDisplayMetric().markStart();
        ThreadUtil threadUtil = ThreadUtil.INSTANCE;
        final BannerAdImpl bannerAdImpl = this.this$0;
        threadUtil.runOnUiThread(new Runnable() { // from class: com.vungle.ads.internal.BannerAdImpl$adPlayCallback$1$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                BannerAdImpl$adPlayCallback$1.m6003onAdStart$lambda0(bannerAdImpl);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: onAdStart$lambda-0, reason: not valid java name */
    public static final void m6003onAdStart$lambda0(BannerAdImpl this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        BaseAdListener adListener = this$0.getAdListener();
        if (adListener != null) {
            adListener.onAdStart(this$0);
        }
    }

    @Override // com.vungle.ads.internal.presenter.AdPlayCallback
    public void onAdImpression(String id) {
        ThreadUtil threadUtil = ThreadUtil.INSTANCE;
        final BannerAdImpl bannerAdImpl = this.this$0;
        threadUtil.runOnUiThread(new Runnable() { // from class: com.vungle.ads.internal.BannerAdImpl$adPlayCallback$1$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                BannerAdImpl$adPlayCallback$1.m6001onAdImpression$lambda1(bannerAdImpl);
            }
        });
        this.this$0.getPresentToDisplayMetric().markEnd();
        AnalyticsClient.logMetric$vungle_ads_release$default(AnalyticsClient.INSTANCE, this.this$0.getPresentToDisplayMetric(), this.this$0.getLogEntry(), (String) null, 4, (Object) null);
        this.this$0.getDisplayToClickMetric().markStart();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: onAdImpression$lambda-1, reason: not valid java name */
    public static final void m6001onAdImpression$lambda1(BannerAdImpl this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        BaseAdListener adListener = this$0.getAdListener();
        if (adListener != null) {
            adListener.onAdImpression(this$0);
        }
    }

    @Override // com.vungle.ads.internal.presenter.AdPlayCallback
    public void onAdEnd(String id) {
        ThreadUtil threadUtil = ThreadUtil.INSTANCE;
        final BannerAdImpl bannerAdImpl = this.this$0;
        threadUtil.runOnUiThread(new Runnable() { // from class: com.vungle.ads.internal.BannerAdImpl$adPlayCallback$1$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                BannerAdImpl$adPlayCallback$1.m6000onAdEnd$lambda2(bannerAdImpl);
            }
        });
        this.this$0.getShowToCloseMetric().markEnd();
        AnalyticsClient.logMetric$vungle_ads_release$default(AnalyticsClient.INSTANCE, this.this$0.getShowToCloseMetric(), this.this$0.getLogEntry(), (String) null, 4, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: onAdEnd$lambda-2, reason: not valid java name */
    public static final void m6000onAdEnd$lambda2(BannerAdImpl this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        BaseAdListener adListener = this$0.getAdListener();
        if (adListener != null) {
            adListener.onAdEnd(this$0);
        }
    }

    @Override // com.vungle.ads.internal.presenter.AdPlayCallback
    public void onAdClick(String id) {
        ThreadUtil threadUtil = ThreadUtil.INSTANCE;
        final BannerAdImpl bannerAdImpl = this.this$0;
        threadUtil.runOnUiThread(new Runnable() { // from class: com.vungle.ads.internal.BannerAdImpl$adPlayCallback$1$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                BannerAdImpl$adPlayCallback$1.m5999onAdClick$lambda3(bannerAdImpl);
            }
        });
        this.this$0.getDisplayToClickMetric().markEnd();
        AnalyticsClient.logMetric$vungle_ads_release$default(AnalyticsClient.INSTANCE, this.this$0.getDisplayToClickMetric(), this.this$0.getLogEntry(), (String) null, 4, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: onAdClick$lambda-3, reason: not valid java name */
    public static final void m5999onAdClick$lambda3(BannerAdImpl this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        BaseAdListener adListener = this$0.getAdListener();
        if (adListener != null) {
            adListener.onAdClicked(this$0);
        }
    }

    @Override // com.vungle.ads.internal.presenter.AdPlayCallback
    public void onAdLeftApplication(String id) {
        ThreadUtil threadUtil = ThreadUtil.INSTANCE;
        final BannerAdImpl bannerAdImpl = this.this$0;
        threadUtil.runOnUiThread(new Runnable() { // from class: com.vungle.ads.internal.BannerAdImpl$adPlayCallback$1$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                BannerAdImpl$adPlayCallback$1.m6002onAdLeftApplication$lambda4(bannerAdImpl);
            }
        });
        AnalyticsClient.logMetric$vungle_ads_release$default(AnalyticsClient.INSTANCE, this.this$0.getLeaveApplicationMetric(), this.this$0.getLogEntry(), (String) null, 4, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: onAdLeftApplication$lambda-4, reason: not valid java name */
    public static final void m6002onAdLeftApplication$lambda4(BannerAdImpl this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        BaseAdListener adListener = this$0.getAdListener();
        if (adListener != null) {
            adListener.onAdLeftApplication(this$0);
        }
    }

    @Override // com.vungle.ads.internal.presenter.AdPlayCallback
    public void onFailure(final VungleError error) {
        Intrinsics.checkNotNullParameter(error, "error");
        ThreadUtil threadUtil = ThreadUtil.INSTANCE;
        final BannerAdImpl bannerAdImpl = this.this$0;
        threadUtil.runOnUiThread(new Runnable() { // from class: com.vungle.ads.internal.BannerAdImpl$adPlayCallback$1$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                BannerAdImpl$adPlayCallback$1.m6004onFailure$lambda5(bannerAdImpl, error);
            }
        });
        this.this$0.getShowToFailMetric().markEnd();
        AnalyticsClient.INSTANCE.logMetric$vungle_ads_release(this.this$0.getShowToFailMetric(), this.this$0.getLogEntry(), String.valueOf(error.getCode()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: onFailure$lambda-5, reason: not valid java name */
    public static final void m6004onFailure$lambda5(BannerAdImpl this$0, VungleError error) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(error, "$error");
        BaseAdListener adListener = this$0.getAdListener();
        if (adListener != null) {
            adListener.onAdFailedToPlay(this$0, error);
        }
    }
}
