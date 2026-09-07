package com.applovin.mediation.nativeAds;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.applovin.impl.mediation.ads.MaxNativeAdLoaderImpl;
import com.applovin.impl.mediation.ads.a;
import com.applovin.impl.sdk.k;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdRevenueListener;
import com.applovin.mediation.MaxAdReviewListener;
import com.applovin.sdk.AppLovinSdk;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.Logger;
import java.util.List;

/* JADX INFO: loaded from: classes13.dex */
public class MaxNativeAdLoader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MaxNativeAdLoaderImpl f792a;

    public MaxNativeAdLoader(String str) {
        this(str, k.o());
    }

    public void a(List<View> list, ViewGroup viewGroup, MaxAd maxAd) {
        this.f792a.logApiCall("a()");
        this.f792a.registerClickableViews(list, viewGroup, maxAd);
    }

    public void b(MaxAd maxAd) {
        this.f792a.logApiCall("b()");
        this.f792a.handleNativeAdViewRendered(maxAd);
    }

    public void destroy() {
        this.f792a.logApiCall("destroy()");
        this.f792a.destroy();
    }

    public String getAdUnitId() {
        return this.f792a.getAdUnitId();
    }

    public String getPlacement() {
        this.f792a.logApiCall("getPlacement()");
        return this.f792a.getPlacement();
    }

    public void loadAd() {
        loadAd(null);
    }

    public boolean render(MaxNativeAdView maxNativeAdView, MaxAd maxAd) {
        Logger.d("AppLovin|SafeDK: Execution> Lcom/applovin/mediation/nativeAds/MaxNativeAdLoader;->render(Lcom/applovin/mediation/nativeAds/MaxNativeAdView;Lcom/applovin/mediation/MaxAd;)Z");
        CreativeInfoManager.onMaxNativeAdLoaded(maxNativeAdView, maxAd);
        return safedk_MaxNativeAdLoader_render_15e187b196d84406225bb047dba3a142(maxNativeAdView, maxAd);
    }

    public boolean safedk_MaxNativeAdLoader_render_15e187b196d84406225bb047dba3a142(MaxNativeAdView p0, MaxAd p1) {
        this.f792a.logApiCall("render(adView=" + p0 + ", ad=" + p1 + ")");
        return this.f792a.render(p0, p1);
    }

    public void setAdReviewListener(MaxAdReviewListener maxAdReviewListener) {
        this.f792a.logApiCall("setAdReviewListener(listener=" + maxAdReviewListener + ")");
        this.f792a.setAdReviewListener(maxAdReviewListener);
    }

    public void setCustomData(String str) {
        this.f792a.logApiCall("setCustomData(value=" + str + ")");
        this.f792a.setCustomData(str);
    }

    public void setExtraParameter(String str, String str2) {
        this.f792a.logApiCall("setExtraParameter(key=" + str + ", value=" + str2 + ")");
        this.f792a.setExtraParameter(str, str2);
    }

    public void setLocalExtraParameter(String str, Object obj) {
        this.f792a.logApiCall("setLocalExtraParameter(key=" + str + ", value=" + obj + ")");
        this.f792a.setLocalExtraParameter(str, obj);
    }

    public void setNativeAdListener(MaxNativeAdListener maxNativeAdListener) {
        this.f792a.logApiCall("setNativeAdListener(listener=" + maxNativeAdListener + ")");
        this.f792a.setNativeAdListener(maxNativeAdListener);
    }

    public void setPlacement(String str) {
        this.f792a.logApiCall("setPlacement(placement=" + str + ")");
        this.f792a.setPlacement(str);
    }

    public void setRevenueListener(MaxAdRevenueListener maxAdRevenueListener) {
        this.f792a.logApiCall("setRevenueListener(listener=" + maxAdRevenueListener + ")");
        this.f792a.setRevenueListener(maxAdRevenueListener);
    }

    @Deprecated
    public MaxNativeAdLoader(String str, Context context) {
        this(str, AppLovinSdk.getInstance(context), context);
    }

    public void loadAd(MaxNativeAdView maxNativeAdView) {
        this.f792a.logApiCall("loadAd(adView=" + maxNativeAdView + ")");
        this.f792a.loadAd(maxNativeAdView);
    }

    @Deprecated
    public MaxNativeAdLoader(String str, AppLovinSdk appLovinSdk, Context context) {
        a.logApiCall("MaxNativeAdLoader", "MaxNativeAdLoader(adUnitId=" + str + ", sdk=" + appLovinSdk + ")");
        if (str != null) {
            if (TextUtils.isEmpty(str)) {
                throw new IllegalArgumentException("Empty ad unit ID specified");
            }
            if (appLovinSdk == null) {
                throw new IllegalArgumentException("No sdk specified");
            }
            if (context != null) {
                this.f792a = new MaxNativeAdLoaderImpl(str, appLovinSdk.a());
                return;
            }
            throw new IllegalArgumentException("No context specified");
        }
        throw new IllegalArgumentException("No ad unit ID specified");
    }

    public void destroy(MaxAd maxAd) {
        this.f792a.logApiCall("destroy(nativeAd=" + maxAd + ")");
        this.f792a.destroy(maxAd);
    }
}
