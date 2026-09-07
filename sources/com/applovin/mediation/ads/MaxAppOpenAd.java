package com.applovin.mediation.ads;

import android.content.Context;
import com.applovin.impl.k7;
import com.applovin.impl.mediation.ads.MaxFullscreenAdImpl;
import com.applovin.impl.mediation.ads.a;
import com.applovin.impl.sdk.k;
import com.applovin.mediation.MaxAdExpirationListener;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxAdListener;
import com.applovin.mediation.MaxAdRequestListener;
import com.applovin.mediation.MaxAdRevenueListener;
import com.applovin.mediation.MaxAdReviewListener;
import com.applovin.sdk.AppLovinSdk;

/* JADX INFO: loaded from: classes13.dex */
public class MaxAppOpenAd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MaxFullscreenAdImpl f787a;

    public MaxAppOpenAd(String str) {
        this(str, k.o());
    }

    public void destroy() {
        this.f787a.logApiCall("destroy()");
        this.f787a.destroy();
    }

    public String getAdUnitId() {
        return this.f787a.getAdUnitId();
    }

    public boolean isReady() {
        boolean zIsReady = this.f787a.isReady();
        this.f787a.logApiCall("isReady() " + zIsReady + " for ad unit id " + this.f787a.getAdUnitId());
        return zIsReady;
    }

    public void loadAd() {
        this.f787a.logApiCall("loadAd()");
        this.f787a.loadAd();
    }

    public void setAdReviewListener(MaxAdReviewListener maxAdReviewListener) {
        this.f787a.logApiCall("setAdReviewListener(listener=" + maxAdReviewListener + ")");
        this.f787a.setAdReviewListener(maxAdReviewListener);
    }

    public void setExpirationListener(MaxAdExpirationListener maxAdExpirationListener) {
        this.f787a.logApiCall("setExpirationListener(listener=" + maxAdExpirationListener + ")");
        this.f787a.setExpirationListener(maxAdExpirationListener);
    }

    public void setExtraParameter(String str, String str2) {
        this.f787a.logApiCall("setExtraParameter(key=" + str + ", value=" + str2 + ")");
        this.f787a.setExtraParameter(str, str2);
    }

    public void setListener(MaxAdListener maxAdListener) {
        this.f787a.logApiCall("setListener(listener=" + maxAdListener + ")");
        this.f787a.setListener(maxAdListener);
    }

    public void setLocalExtraParameter(String str, Object obj) {
        this.f787a.logApiCall("setLocalExtraParameter(key=" + str + ", value=" + obj + ")");
        this.f787a.setLocalExtraParameter(str, obj);
    }

    public void setRequestListener(MaxAdRequestListener maxAdRequestListener) {
        this.f787a.logApiCall("setRequestListener(listener=" + maxAdRequestListener + ")");
        this.f787a.setRequestListener(maxAdRequestListener);
    }

    public void setRevenueListener(MaxAdRevenueListener maxAdRevenueListener) {
        this.f787a.logApiCall("setRevenueListener(listener=" + maxAdRevenueListener + ")");
        this.f787a.setRevenueListener(maxAdRevenueListener);
    }

    public void showAd() {
        showAd(null);
    }

    public String toString() {
        return "" + this.f787a;
    }

    @Deprecated
    public MaxAppOpenAd(String str, Context context) {
        this(str, AppLovinSdk.getInstance(context), context);
    }

    public void showAd(String str) {
        showAd(str, null);
    }

    @Deprecated
    public MaxAppOpenAd(String str, AppLovinSdk appLovinSdk) {
        this(str, appLovinSdk, k.o());
    }

    public void showAd(String str, String str2) {
        this.f787a.logApiCall("showAd(placement=" + str + ", customData=" + str2 + ")");
        k7.b(str2, "MaxAppOpenAd");
        this.f787a.showAd(str, str2, null);
    }

    private MaxAppOpenAd(String str, AppLovinSdk appLovinSdk, Context context) {
        a.logApiCall("MaxAppOpenAd", "MaxAppOpenAd(adUnitId=" + str + ", sdk=" + appLovinSdk + ", context=" + context + ")");
        this.f787a = new MaxFullscreenAdImpl(str.trim(), MaxAdFormat.APP_OPEN, null, "MaxAppOpenAd", appLovinSdk.a(), context);
    }
}
