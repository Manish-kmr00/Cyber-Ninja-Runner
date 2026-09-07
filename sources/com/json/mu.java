package com.json;

import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.json.mediationsdk.IronSource;
import com.json.mediationsdk.adunit.adapter.utility.AdInfo;
import com.json.mediationsdk.logger.IronSourceError;
import com.json.mediationsdk.model.Placement;
import com.json.mediationsdk.sdk.LevelPlayBannerListener;
import com.json.mediationsdk.sdk.LevelPlayInterstitialListener;
import com.json.mediationsdk.sdk.LevelPlayRewardedVideoBaseListener;
import com.json.mediationsdk.sdk.LevelPlayRewardedVideoListener;
import com.json.mediationsdk.sdk.LevelPlayRewardedVideoManualListener;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\r¢\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J(\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u000e\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\tH\u0002J\u0006\u0010\f\u001a\u00020\u0002J\u0006\u0010\u000b\u001a\u00020\u0002R\u0014\u0010\u000f\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u000e¨\u0006\u0013"}, d2 = {"Lcom/ironsource/mu;", "", "", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "", "callbackName", "Lcom/ironsource/mediationsdk/IronSource$AD_UNIT;", "adUnit", "", "args", "a", "d", "Lcom/ironsource/du;", "Lcom/ironsource/du;", "mJavaScriptEvaluator", "javaScriptEvaluator", "<init>", "(Lcom/ironsource/du;)V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public final class mu {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final du mJavaScriptEvaluator;

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\n\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001c\u0010\u000b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\f\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\r\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u000e"}, d2 = {"com/ironsource/mu$a", "Lcom/ironsource/mediationsdk/sdk/LevelPlayInterstitialListener;", "Lcom/ironsource/mediationsdk/adunit/adapter/utility/AdInfo;", "adInfo", "", nu.f4097a, "Lcom/ironsource/mediationsdk/logger/IronSourceError;", "error", nu.b, nu.c, nu.d, nu.e, nu.f, nu.g, "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
    public static final class a implements LevelPlayInterstitialListener {
        a() {
        }

        @Override // com.json.mediationsdk.sdk.LevelPlayInterstitialListener
        public void onAdClicked(AdInfo adInfo) {
            mu.this.a(nu.f, IronSource.AD_UNIT.INTERSTITIAL, qu.f4209a.a(adInfo));
        }

        @Override // com.json.mediationsdk.sdk.LevelPlayInterstitialListener
        public void onAdClosed(AdInfo adInfo) {
            mu.this.a(nu.g, IronSource.AD_UNIT.INTERSTITIAL, qu.f4209a.a(adInfo));
        }

        @Override // com.json.mediationsdk.sdk.LevelPlayInterstitialListener
        public void onAdLoadFailed(IronSourceError error) {
            mu.this.a(nu.b, IronSource.AD_UNIT.INTERSTITIAL, qu.f4209a.a(error != null ? error.getErrorMessage() : null));
        }

        @Override // com.json.mediationsdk.sdk.LevelPlayInterstitialListener
        public void onAdOpened(AdInfo adInfo) {
            mu.this.a(nu.c, IronSource.AD_UNIT.INTERSTITIAL, qu.f4209a.a(adInfo));
        }

        @Override // com.json.mediationsdk.sdk.LevelPlayInterstitialListener
        public void onAdReady(AdInfo adInfo) {
            mu.this.a(nu.f4097a, IronSource.AD_UNIT.INTERSTITIAL, qu.f4209a.a(adInfo));
        }

        @Override // com.json.mediationsdk.sdk.LevelPlayInterstitialListener
        public void onAdShowFailed(IronSourceError error, AdInfo adInfo) {
            mu.this.a(nu.e, IronSource.AD_UNIT.INTERSTITIAL, qu.f4209a.a(error != null ? error.getErrorMessage() : null, adInfo));
        }

        @Override // com.json.mediationsdk.sdk.LevelPlayInterstitialListener
        public void onAdShowSucceeded(AdInfo adInfo) {
            mu.this.a(nu.d, IronSource.AD_UNIT.INTERSTITIAL, qu.f4209a.a(adInfo));
        }
    }

    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J\u0012\u0010\t\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\n\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u0010\u000b\u001a\u00020\u0005H\u0016J\u0012\u0010\f\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J\u001c\u0010\r\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J\u001c\u0010\u0010\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J\u001c\u0010\u0011\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J\u0012\u0010\u0012\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¨\u0006\u0013"}, d2 = {"com/ironsource/mu$b", "Lcom/ironsource/mediationsdk/sdk/LevelPlayRewardedVideoManualListener;", "Lcom/ironsource/mediationsdk/sdk/LevelPlayRewardedVideoListener;", "Lcom/ironsource/mediationsdk/adunit/adapter/utility/AdInfo;", "adInfo", "", nu.f4097a, "Lcom/ironsource/mediationsdk/logger/IronSourceError;", "error", nu.b, nu.h, nu.n, nu.c, nu.e, "Lcom/ironsource/mediationsdk/model/Placement;", "placement", nu.f, nu.i, nu.g, "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
    public static final class b implements LevelPlayRewardedVideoManualListener, LevelPlayRewardedVideoListener {
        b() {
        }

        @Override // com.json.mediationsdk.sdk.LevelPlayRewardedVideoListener
        public void onAdAvailable(AdInfo adInfo) {
            mu.this.a(nu.h, IronSource.AD_UNIT.REWARDED_VIDEO, qu.f4209a.a(adInfo));
        }

        @Override // com.json.mediationsdk.sdk.LevelPlayRewardedVideoBaseListener
        public void onAdClicked(Placement placement, AdInfo adInfo) {
            mu.this.a(nu.f, IronSource.AD_UNIT.REWARDED_VIDEO, qu.f4209a.a(lu.f3878a.a(placement), adInfo));
        }

        @Override // com.json.mediationsdk.sdk.LevelPlayRewardedVideoBaseListener
        public void onAdClosed(AdInfo adInfo) {
            mu.this.a(nu.g, IronSource.AD_UNIT.REWARDED_VIDEO, qu.f4209a.a(adInfo));
        }

        @Override // com.json.mediationsdk.sdk.LevelPlayRewardedVideoManualListener
        public void onAdLoadFailed(IronSourceError error) {
            mu.this.a(nu.b, IronSource.AD_UNIT.REWARDED_VIDEO, qu.f4209a.a(error != null ? error.getErrorMessage() : null));
        }

        @Override // com.json.mediationsdk.sdk.LevelPlayRewardedVideoBaseListener
        public void onAdOpened(AdInfo adInfo) {
            mu.this.a(nu.c, IronSource.AD_UNIT.REWARDED_VIDEO, qu.f4209a.a(adInfo));
        }

        @Override // com.json.mediationsdk.sdk.LevelPlayRewardedVideoManualListener
        public void onAdReady(AdInfo adInfo) {
            mu.this.a(nu.f4097a, IronSource.AD_UNIT.REWARDED_VIDEO, qu.f4209a.a(adInfo));
        }

        @Override // com.json.mediationsdk.sdk.LevelPlayRewardedVideoBaseListener
        public void onAdRewarded(Placement placement, AdInfo adInfo) {
            mu.this.a(nu.i, IronSource.AD_UNIT.REWARDED_VIDEO, qu.f4209a.a(lu.f3878a.a(placement), adInfo));
        }

        @Override // com.json.mediationsdk.sdk.LevelPlayRewardedVideoBaseListener
        public void onAdShowFailed(IronSourceError error, AdInfo adInfo) {
            mu.this.a(nu.e, IronSource.AD_UNIT.REWARDED_VIDEO, qu.f4209a.a(error != null ? error.getErrorMessage() : null, adInfo));
        }

        @Override // com.json.mediationsdk.sdk.LevelPlayRewardedVideoListener
        public void onAdUnavailable() {
            mu.this.a(nu.n, IronSource.AD_UNIT.REWARDED_VIDEO, qu.f4209a.a(new Object[0]));
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\n\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u000b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\f\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\r"}, d2 = {"com/ironsource/mu$c", "Lcom/ironsource/mediationsdk/sdk/LevelPlayBannerListener;", "Lcom/ironsource/mediationsdk/adunit/adapter/utility/AdInfo;", "adInfo", "", "onAdLoaded", "Lcom/ironsource/mediationsdk/logger/IronSourceError;", "error", nu.b, nu.f, nu.k, nu.l, nu.m, "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
    public static final class c implements LevelPlayBannerListener {
        c() {
        }

        @Override // com.json.mediationsdk.sdk.LevelPlayBannerListener
        public void onAdClicked(AdInfo adInfo) {
            mu.this.a(nu.f, IronSource.AD_UNIT.BANNER, qu.f4209a.a(adInfo));
        }

        @Override // com.json.mediationsdk.sdk.LevelPlayBannerListener
        public void onAdLeftApplication(AdInfo adInfo) {
            mu.this.a(nu.k, IronSource.AD_UNIT.BANNER, qu.f4209a.a(adInfo));
        }

        @Override // com.json.mediationsdk.sdk.LevelPlayBannerListener
        public void onAdLoadFailed(IronSourceError error) {
            mu.this.a(nu.b, IronSource.AD_UNIT.BANNER, qu.f4209a.a(error != null ? error.getErrorMessage() : null));
        }

        @Override // com.json.mediationsdk.sdk.LevelPlayBannerListener
        public void onAdLoaded(AdInfo adInfo) {
            mu.this.a("onAdLoaded", IronSource.AD_UNIT.BANNER, qu.f4209a.a(adInfo));
        }

        @Override // com.json.mediationsdk.sdk.LevelPlayBannerListener
        public void onAdScreenDismissed(AdInfo adInfo) {
            mu.this.a(nu.m, IronSource.AD_UNIT.BANNER, qu.f4209a.a(adInfo));
        }

        @Override // com.json.mediationsdk.sdk.LevelPlayBannerListener
        public void onAdScreenPresented(AdInfo adInfo) {
            mu.this.a(nu.l, IronSource.AD_UNIT.BANNER, qu.f4209a.a(adInfo));
        }
    }

    public mu(du javaScriptEvaluator) {
        Intrinsics.checkNotNullParameter(javaScriptEvaluator, "javaScriptEvaluator");
        this.mJavaScriptEvaluator = javaScriptEvaluator;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(String callbackName, IronSource.AD_UNIT adUnit, List<? extends Object> args) {
        this.mJavaScriptEvaluator.a(callbackName, adUnit, args);
    }

    private final void b() {
        lu luVar = lu.f3878a;
        luVar.a((LevelPlayInterstitialListener) null);
        luVar.a((LevelPlayRewardedVideoBaseListener) null);
        luVar.a((LevelPlayBannerListener) null);
    }

    private final void c() {
        lu.f3878a.i();
    }

    public final void a() {
        b();
        c();
    }

    public final void d() {
        lu luVar = lu.f3878a;
        luVar.a(new a());
        luVar.a(new b());
        luVar.a(new c());
    }
}
