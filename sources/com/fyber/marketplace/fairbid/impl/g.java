package com.fyber.marketplace.fairbid.impl;

import android.text.TextUtils;
import com.fyber.inneractive.sdk.config.AbstractC3081k;
import com.fyber.inneractive.sdk.config.AbstractC3090u;
import com.fyber.inneractive.sdk.config.C3091v;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.config.global.r;
import com.fyber.inneractive.sdk.external.InneractiveAdManager;
import com.fyber.inneractive.sdk.util.AbstractC3247k;
import com.fyber.inneractive.sdk.util.AbstractC3251o;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.a0;
import com.fyber.marketplace.fairbid.bridge.MarketplaceAuctionParameters;
import com.json.tr;
import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public final class g implements MarketplaceAuctionParameters {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap f2434a = new HashMap();
    public final HashMap b = new HashMap();
    public final com.fyber.inneractive.sdk.serverapi.d c;
    public String d;

    public g(com.fyber.inneractive.sdk.serverapi.c cVar) {
        this.c = cVar;
    }

    public static JSONObject a(HashMap map, f... fVarArr) {
        JSONObject jSONObject = new JSONObject();
        for (f fVar : fVarArr) {
            String str = (String) map.get(fVar.marketPlaceParam);
            if (!TextUtils.isEmpty(str)) {
                try {
                    Object objA = a(fVar.type, str);
                    if (objA != null) {
                        jSONObject.put(fVar.fairBidParam, objA);
                    }
                } catch (JSONException unused) {
                }
            }
        }
        return jSONObject;
    }

    @Override // com.fyber.marketplace.fairbid.bridge.MarketplaceAuctionParameters
    public final String getAdvertisingId() {
        C3091v c3091v = AbstractC3090u.f1727a.b;
        if (c3091v != null ? c3091v.c : false) {
            return null;
        }
        ((com.fyber.inneractive.sdk.serverapi.c) this.c).getClass();
        int i = AbstractC3081k.f1710a;
        String property = System.getProperty("ia.testEnvironmentConfiguration.device");
        if (TextUtils.isEmpty(property)) {
            C3091v c3091v2 = AbstractC3090u.f1727a.b;
            if (c3091v2 == null) {
                return null;
            }
            property = c3091v2.f1728a;
        }
        return property;
    }

    @Override // com.fyber.marketplace.fairbid.bridge.MarketplaceAuctionParameters
    public final String getAmazonAdvertisingId() {
        C3091v c3091v = AbstractC3090u.f1727a.b;
        if (!(c3091v != null ? c3091v.c : false)) {
            return null;
        }
        ((com.fyber.inneractive.sdk.serverapi.c) this.c).getClass();
        int i = AbstractC3081k.f1710a;
        String property = System.getProperty("ia.testEnvironmentConfiguration.device");
        if (TextUtils.isEmpty(property)) {
            C3091v c3091v2 = AbstractC3090u.f1727a.b;
            if (c3091v2 == null) {
                return null;
            }
            property = c3091v2.f1728a;
        }
        return property;
    }

    @Override // com.fyber.marketplace.fairbid.bridge.MarketplaceAuctionParameters
    public final String getAppVersion() {
        ((com.fyber.inneractive.sdk.serverapi.c) this.c).getClass();
        return AbstractC3247k.m();
    }

    @Override // com.fyber.marketplace.fairbid.bridge.MarketplaceAuctionParameters
    public final String getBundleId() {
        ((com.fyber.inneractive.sdk.serverapi.c) this.c).getClass();
        return AbstractC3251o.f2370a.getPackageName();
    }

    @Override // com.fyber.marketplace.fairbid.bridge.MarketplaceAuctionParameters
    public final String getCarrier() {
        return ((com.fyber.inneractive.sdk.serverapi.c) this.c).a();
    }

    @Override // com.fyber.marketplace.fairbid.bridge.MarketplaceAuctionParameters
    public final String getDeviceModel() {
        ((com.fyber.inneractive.sdk.serverapi.c) this.c).getClass();
        return AbstractC3247k.k();
    }

    @Override // com.fyber.marketplace.fairbid.bridge.MarketplaceAuctionParameters
    public final r getFeatureProvider(String str) {
        return (r) this.f2434a.get(str);
    }

    @Override // com.fyber.marketplace.fairbid.bridge.MarketplaceAuctionParameters
    public final int getHeight() {
        ((com.fyber.inneractive.sdk.serverapi.c) this.c).getClass();
        return AbstractC3251o.b(AbstractC3251o.e());
    }

    @Override // com.fyber.marketplace.fairbid.bridge.MarketplaceAuctionParameters
    public final String getHorizontalAccuracy() {
        return null;
    }

    @Override // com.fyber.marketplace.fairbid.bridge.MarketplaceAuctionParameters
    public final List getInputLanguages() {
        ((com.fyber.inneractive.sdk.serverapi.c) this.c).getClass();
        return IAConfigManager.O.p;
    }

    @Override // com.fyber.marketplace.fairbid.bridge.MarketplaceAuctionParameters
    public final String getLanguage() {
        ((com.fyber.inneractive.sdk.serverapi.c) this.c).getClass();
        return IAConfigManager.O.o;
    }

    @Override // com.fyber.marketplace.fairbid.bridge.MarketplaceAuctionParameters
    public final String getLatitudeLongitude() {
        return null;
    }

    @Override // com.fyber.marketplace.fairbid.bridge.MarketplaceAuctionParameters
    public final JSONObject getMarketplaceEntry() {
        HashMap map = new HashMap();
        ((com.fyber.inneractive.sdk.serverapi.c) this.c).a(this.d, map);
        if (!InneractiveAdManager.isCurrentUserAChild()) {
            String str = f.KEY_COUNTRY_CODE.marketPlaceParam;
            ((com.fyber.inneractive.sdk.serverapi.c) this.c).getClass();
            map.put(str, AbstractC3247k.j());
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("client_params", a(map, f.KEY_TIME_OF_DAY));
        } catch (Exception unused) {
        }
        try {
            jSONObject.put("device_params", a(map, f.KEY_AVAILABLE_DISK_SPACE, f.KEY_DO_NOT_DISTURB, f.KEY_AIRPLANE_MODE, f.KEY_ANDROID_LEVEL, f.KEY_IS_MUTED, f.KEY_HEADSET, f.KEY_BATTERY_CONNECTED, f.KEY_BATTERY_LEVEL, f.KEY_BLUETOOTH_CONNECTED, f.KEY_LOW_POWER_MODE, f.KEY_COUNTRY_CODE, f.KEY_DARK_MODE, f.KEY_TOTAL_DISK_SPACE, f.KEY_MEDIA_MUTED, f.KEY_AD_SERVICES_VERSION));
        } catch (Exception unused2) {
        }
        try {
            jSONObject.put("content_params", a(map, f.KEY_LAST_BUNDLE_SHOWED, f.KEY_LAST_DOMAIN_SHOWED));
        } catch (Exception unused3) {
        }
        r rVarA = r.a();
        this.f2434a.put(this.d, rVarA);
        rVarA.a(false, this.d);
        JSONArray jSONArrayA = com.fyber.inneractive.sdk.config.global.g.a(rVarA.b, true);
        IAlog.a("%s: active experiments json set = %s", "SupportedFeaturesProvider", jSONArrayA);
        if (jSONArrayA != null && jSONArrayA.length() > 0) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put(tr.d, jSONArrayA);
            } catch (Exception unused4) {
            }
            try {
                jSONObject.put("sdk_experiments", jSONObject2);
            } catch (Exception unused5) {
            }
        }
        com.fyber.inneractive.sdk.serverapi.d dVar = this.c;
        String str2 = this.d;
        ((com.fyber.inneractive.sdk.serverapi.c) dVar).getClass();
        IAConfigManager iAConfigManager = IAConfigManager.O;
        com.fyber.inneractive.sdk.dv.j jVarA = iAConfigManager.G.a(com.fyber.inneractive.sdk.serverapi.b.a(str2));
        String str3 = this.d;
        if (jVarA != null) {
            this.b.put(str3, jVarA);
            try {
                jSONObject.put("gdem_signal", jVarA.f1743a.getQuery());
            } catch (JSONException unused6) {
            }
        }
        ((com.fyber.inneractive.sdk.serverapi.c) this.c).getClass();
        StringBuilder sb = new StringBuilder("2.2.0-Android-8.3.6");
        if (!TextUtils.isEmpty(InneractiveAdManager.getDevPlatform())) {
            sb.append('-').append(InneractiveAdManager.getDevPlatform());
        }
        try {
            jSONObject.put("version", sb.toString());
        } catch (JSONException unused7) {
        }
        com.fyber.inneractive.sdk.ignite.h hVar = iAConfigManager.E;
        if (hVar != null) {
            com.fyber.inneractive.sdk.ignite.l lVar = hVar.p;
            String strI = lVar != null ? lVar.f1221a.i() : null;
            com.fyber.inneractive.sdk.ignite.l lVar2 = hVar.p;
            String strD = lVar2 != null ? lVar2.f1221a.d() : null;
            JSONObject jSONObject3 = new JSONObject();
            if (!TextUtils.isEmpty(strI) && !TextUtils.isEmpty(strD)) {
                try {
                    jSONObject3.put("version", strI);
                } catch (JSONException unused8) {
                }
                try {
                    jSONObject3.put("package_name", strD);
                } catch (JSONException unused9) {
                }
                try {
                    jSONObject.put("ignite_params", jSONObject3);
                } catch (Exception unused10) {
                }
            }
        }
        IAConfigManager.b();
        com.fyber.inneractive.sdk.topics.b bVar = iAConfigManager.F;
        if (bVar.i.get() && IAConfigManager.f()) {
            JSONArray jSONArrayB = bVar.b();
            if (jSONArrayB != null) {
                try {
                    jSONObject.put("topics", jSONArrayB);
                } catch (Exception unused11) {
                }
            }
            JSONArray jSONArrayA2 = bVar.a();
            if (jSONArrayA2 != null) {
                try {
                    jSONObject.put("encrypted_topics", jSONArrayA2);
                } catch (Exception unused12) {
                }
            }
        }
        if (!InneractiveAdManager.isCurrentUserAChild()) {
            ((com.fyber.inneractive.sdk.serverapi.c) this.c).getClass();
            try {
                jSONObject.put(CommonUrlParts.APP_SET_ID, iAConfigManager.r);
            } catch (JSONException unused13) {
            }
        }
        IAlog.a("getMarketplaceEntry:Json object - %s", jSONObject.toString());
        return jSONObject;
    }

    @Override // com.fyber.marketplace.fairbid.bridge.MarketplaceAuctionParameters
    public final String getMobileCountryCode() {
        String str = ((com.fyber.inneractive.sdk.serverapi.c) this.c).b;
        return str == null ? "" : str.substring(0, Math.min(3, str.length()));
    }

    @Override // com.fyber.marketplace.fairbid.bridge.MarketplaceAuctionParameters
    public final String getMobileNetworkCode() {
        String str = ((com.fyber.inneractive.sdk.serverapi.c) this.c).b;
        return str == null ? "" : str.substring(Math.min(3, str.length()));
    }

    @Override // com.fyber.marketplace.fairbid.bridge.MarketplaceAuctionParameters
    public final String getNetwork() {
        ((com.fyber.inneractive.sdk.serverapi.c) this.c).getClass();
        a0 a0VarA = a0.a();
        IAlog.a("ExchangeRequestParamsProvider: getNetwork : type: %s value: %s", a0VarA, a0VarA.b());
        return a0VarA.b();
    }

    @Override // com.fyber.marketplace.fairbid.bridge.MarketplaceAuctionParameters
    public final List getSupportedApis() {
        ((com.fyber.inneractive.sdk.serverapi.c) this.c).getClass();
        return com.fyber.inneractive.sdk.serverapi.c.c;
    }

    @Override // com.fyber.marketplace.fairbid.bridge.MarketplaceAuctionParameters
    public final List getSupportedProtocols() {
        ((com.fyber.inneractive.sdk.serverapi.c) this.c).getClass();
        return com.fyber.inneractive.sdk.serverapi.c.d;
    }

    @Override // com.fyber.marketplace.fairbid.bridge.MarketplaceAuctionParameters
    public final int getSupportedTypesBitwise() {
        this.c.getClass();
        return 372;
    }

    @Override // com.fyber.marketplace.fairbid.bridge.MarketplaceAuctionParameters
    public final String getTimeAccuracy() {
        return null;
    }

    @Override // com.fyber.marketplace.fairbid.bridge.MarketplaceAuctionParameters
    public final String getVerticalAccuracy() {
        return null;
    }

    @Override // com.fyber.marketplace.fairbid.bridge.MarketplaceAuctionParameters
    public final int getWidth() {
        ((com.fyber.inneractive.sdk.serverapi.c) this.c).getClass();
        return AbstractC3251o.b(AbstractC3251o.f());
    }

    @Override // com.fyber.marketplace.fairbid.bridge.MarketplaceAuctionParameters
    public final com.fyber.inneractive.sdk.dv.j getWrapperQueryInfo(String str) {
        com.fyber.inneractive.sdk.dv.j jVar = (com.fyber.inneractive.sdk.dv.j) this.b.get(this.d);
        this.b.remove(this.d);
        return jVar;
    }

    @Override // com.fyber.marketplace.fairbid.bridge.MarketplaceAuctionParameters
    public final boolean hasAmazonAdvertisingId() {
        C3091v c3091v = AbstractC3090u.f1727a.b;
        if (c3091v != null) {
            return c3091v.c;
        }
        return false;
    }

    @Override // com.fyber.marketplace.fairbid.bridge.MarketplaceAuctionParameters
    public final Boolean isLimitTrackingEnabled() {
        ((com.fyber.inneractive.sdk.serverapi.c) this.c).getClass();
        C3091v c3091v = AbstractC3090u.f1727a.b;
        return Boolean.valueOf(c3091v != null ? c3091v.b : false);
    }

    public static Object a(Object obj, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String string = obj.toString();
        if (TextUtils.equals(string, Integer.class.toString())) {
            try {
                return Integer.valueOf(str);
            } catch (NumberFormatException unused) {
                return null;
            }
        }
        if (TextUtils.equals(string, String.class.toString())) {
            return str;
        }
        if (TextUtils.equals(string, Boolean.class.toString())) {
            if (str.equalsIgnoreCase("1")) {
                return Boolean.TRUE;
            }
            if (str.equalsIgnoreCase("0")) {
                return Boolean.FALSE;
            }
        }
        return null;
    }
}
