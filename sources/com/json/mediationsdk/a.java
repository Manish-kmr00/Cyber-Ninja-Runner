package com.json.mediationsdk;

import android.app.Activity;
import android.text.TextUtils;
import com.json.mediationsdk.adunit.adapter.internal.AdapterAdFullScreenInterface;
import com.json.mediationsdk.adunit.adapter.internal.AdapterBannerInterface;
import com.json.mediationsdk.adunit.adapter.internal.AdapterBindAdViewInterface;
import com.json.mediationsdk.adunit.adapter.internal.AdapterNativeAdInterface;
import com.json.mediationsdk.adunit.adapter.internal.BaseAdAdapter;
import com.json.mediationsdk.adunit.adapter.internal.listener.AdapterAdListener;
import com.json.mediationsdk.adunit.adapter.utility.AdData;
import com.json.mediationsdk.bidding.BiddingDataCallback;
import com.json.mediationsdk.logger.IronLog;
import com.json.mediationsdk.model.NetworkSettings;
import com.json.mk;
import com.json.y7;
import com.safedk.android.analytics.brandsafety.creatives.discoveries.h;
import com.safedk.android.internal.partials.IronSourceNetworkBridge;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.UUID;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public abstract class a<Listener extends AdapterAdListener> extends BaseAdAdapter<u, Listener> implements AdapterAdFullScreenInterface<Listener>, AdapterBannerInterface<Listener>, AdapterNativeAdInterface<Listener>, AdapterBindAdViewInterface, y7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected AbstractAdapter f3931a;
    protected WeakReference<Listener> b;

    public a(AbstractAdapter abstractAdapter, NetworkSettings networkSettings, IronSource.AD_UNIT ad_unit, UUID uuid) {
        super(ad_unit, networkSettings, uuid);
        this.b = new WeakReference<>(null);
        this.f3931a = abstractAdapter;
    }

    public static a<?> a(AbstractAdapter abstractAdapter, NetworkSettings networkSettings, IronSource.AD_UNIT ad_unit, UUID uuid) {
        if (ad_unit == IronSource.AD_UNIT.REWARDED_VIDEO) {
            return new z(abstractAdapter, networkSettings, uuid);
        }
        if (ad_unit == IronSource.AD_UNIT.INTERSTITIAL) {
            return new o(abstractAdapter, networkSettings, uuid);
        }
        if (ad_unit == IronSource.AD_UNIT.BANNER) {
            return new j(abstractAdapter, networkSettings, uuid);
        }
        if (ad_unit == IronSource.AD_UNIT.NATIVE_AD) {
            return new t(abstractAdapter, networkSettings, uuid);
        }
        IronLog.INTERNAL.error("ad unit not supported - " + ad_unit);
        return null;
    }

    private void a(AdData adData, Listener listener) {
        this.b = new WeakReference<>(listener);
        a(mk.a(adData.getConfiguration()), mk.a(adData.getAdUnitData()), adData);
    }

    private void b(String str) {
        IronLog.INTERNAL.error(a("Method '" + str + "' is not supported for " + getClass().getName()));
    }

    protected String a() {
        return a((String) null);
    }

    protected String a(String str) {
        String string = b().toString();
        return TextUtils.isEmpty(str) ? string : string + " - " + str;
    }

    @Override // com.json.y7
    public Map<String, Object> a(AdData adData) {
        JSONObject jSONObjectA = mk.a(adData.getConfiguration());
        JSONObject jSONObjectA2 = mk.a(adData.getAdUnitData());
        IronSource.AD_UNIT ad_unit = (IronSource.AD_UNIT) adData.getAdUnitData().get("adUnit");
        if (ad_unit == IronSource.AD_UNIT.REWARDED_VIDEO) {
            return this.f3931a.getRewardedVideoBiddingData(jSONObjectA, jSONObjectA2);
        }
        if (ad_unit == IronSource.AD_UNIT.INTERSTITIAL) {
            return this.f3931a.getInterstitialBiddingData(jSONObjectA, jSONObjectA2);
        }
        if (ad_unit == IronSource.AD_UNIT.BANNER) {
            return this.f3931a.getBannerBiddingData(jSONObjectA, jSONObjectA2);
        }
        if (ad_unit == IronSource.AD_UNIT.NATIVE_AD) {
            return this.f3931a.getNativeAdBiddingData(jSONObjectA, jSONObjectA2);
        }
        IronLog.INTERNAL.error("ad unit not supported - " + ad_unit);
        return null;
    }

    @Override // com.json.y7
    public void a(AdData adData, BiddingDataCallback biddingDataCallback) {
        JSONObject jSONObjectA = mk.a(adData.getConfiguration());
        JSONObject jSONObjectA2 = mk.a(adData.getAdUnitData());
        IronSource.AD_UNIT ad_unit = (IronSource.AD_UNIT) adData.getAdUnitData().get("adUnit");
        if (ad_unit == IronSource.AD_UNIT.REWARDED_VIDEO) {
            this.f3931a.collectRewardedVideoBiddingData(jSONObjectA, jSONObjectA2, biddingDataCallback);
            return;
        }
        if (ad_unit == IronSource.AD_UNIT.INTERSTITIAL) {
            this.f3931a.collectInterstitialBiddingData(jSONObjectA, jSONObjectA2, biddingDataCallback);
            return;
        }
        if (ad_unit == IronSource.AD_UNIT.BANNER) {
            this.f3931a.collectBannerBiddingData(jSONObjectA, jSONObjectA2, biddingDataCallback);
        } else if (ad_unit == IronSource.AD_UNIT.NATIVE_AD) {
            this.f3931a.collectNativeAdBiddingData(jSONObjectA, jSONObjectA2, biddingDataCallback);
        } else {
            IronLog.INTERNAL.error("ad unit not supported - " + ad_unit);
        }
    }

    protected void a(JSONObject jSONObject) {
        b("destroyAd");
    }

    protected abstract void a(JSONObject jSONObject, JSONObject jSONObject2, AdData adData);

    protected abstract IronSource.AD_UNIT b();

    protected void b(JSONObject jSONObject) {
        b("disposeAd");
    }

    protected boolean c(JSONObject jSONObject) {
        b("isAdAvailable");
        return false;
    }

    public void d(JSONObject jSONObject) {
        b("onAdViewWillBind");
    }

    @Override // com.json.mediationsdk.adunit.adapter.internal.AdapterBannerInterface, com.json.mediationsdk.adunit.adapter.internal.AdapterNativeAdInterface
    public void destroyAd(AdData adData) {
        a(mk.a(adData.getConfiguration()));
    }

    @Override // com.json.mediationsdk.adunit.adapter.internal.AdapterAdFullScreenInterface
    public void disposeAd(AdData adData) {
        b(mk.a(adData.getConfiguration()));
    }

    public void e(JSONObject jSONObject) {
        b("onAdViewWillBind");
    }

    protected void f(JSONObject jSONObject) {
        b(h.ac);
    }

    @Override // com.json.mediationsdk.adunit.adapter.internal.AdapterAdFullScreenInterface
    public boolean isAdAvailable(AdData adData) {
        return c(mk.a(adData.getConfiguration()));
    }

    @Override // com.json.mediationsdk.adunit.adapter.internal.AdapterBannerInterface
    public void loadAd(AdData adData, Activity activity, ISBannerSize iSBannerSize, Listener listener) {
        a(adData, listener);
    }

    @Override // com.json.mediationsdk.adunit.adapter.internal.AdapterAdFullScreenInterface, com.json.mediationsdk.adunit.adapter.internal.AdapterNativeAdInterface
    public void loadAd(AdData adData, Activity activity, Listener listener) {
        a(adData, listener);
    }

    @Override // com.json.mediationsdk.adunit.adapter.internal.AdapterBindAdViewInterface
    public void onAdViewBound(AdData adData) {
        d(mk.a(adData.getConfiguration()));
    }

    @Override // com.json.mediationsdk.adunit.adapter.internal.AdapterBindAdViewInterface
    public void onAdViewWillBind(AdData adData) {
        e(mk.a(adData.getConfiguration()));
    }

    @Override // com.json.mediationsdk.adunit.adapter.internal.BaseAdAdapter
    public void releaseMemory() {
        IronLog.INTERNAL.verbose(a());
        AbstractAdapter abstractAdapter = this.f3931a;
        if (abstractAdapter != null) {
            abstractAdapter.releaseMemory(b(), IronSourceNetworkBridge.jsonObjectInit());
            this.f3931a = null;
        }
    }

    @Override // com.json.mediationsdk.adunit.adapter.internal.AdapterAdFullScreenInterface
    public void showAd(AdData adData, Listener listener) {
        this.b = new WeakReference<>(listener);
        f(mk.a(adData.getConfiguration()));
    }
}
