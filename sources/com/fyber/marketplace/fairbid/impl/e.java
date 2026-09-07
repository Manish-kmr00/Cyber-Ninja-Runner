package com.fyber.marketplace.fairbid.impl;

import android.text.TextUtils;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.external.InneractiveErrorCode;
import com.fyber.inneractive.sdk.external.InneractiveUnitController;
import com.fyber.inneractive.sdk.network.C3146w;
import com.fyber.inneractive.sdk.network.EnumC3138n;
import com.fyber.inneractive.sdk.network.EnumC3143t;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.r;
import com.fyber.marketplace.fairbid.bridge.MarketplaceAdLoadError;
import com.fyber.marketplace.fairbid.bridge.MarketplaceAdLoadListener;
import com.fyber.marketplace.fairbid.bridge.MarketplaceAuctionParameters;
import com.fyber.marketplace.fairbid.bridge.MarketplaceBridgeAd;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public abstract class e {
    k adSpot;
    MarketplaceAuctionParameters mMarketplaceAuctionParameters;
    private h mMarketplaceAuctionResponse;
    private boolean mMuted;
    protected String mPlacementId;
    protected com.fyber.inneractive.sdk.dv.j mWrapperQueryInfo;

    public e(String str, JSONObject jSONObject, Map map, boolean z, MarketplaceAuctionParameters marketplaceAuctionParameters) {
        Map<String, String> mapLowerCaseHeaders = lowerCaseHeaders(map);
        com.fyber.inneractive.sdk.response.a responseAdType = getResponseAdType(mapLowerCaseHeaders);
        this.mMarketplaceAuctionParameters = marketplaceAuctionParameters;
        this.mPlacementId = str;
        if (responseAdType != null) {
            this.mMarketplaceAuctionResponse = new h(jSONObject, responseAdType, mapLowerCaseHeaders);
        }
        this.mMuted = z;
    }

    public static void access$000(e eVar, InneractiveUnitController inneractiveUnitController, MarketplaceAdLoadListener marketplaceAdLoadListener, com.fyber.inneractive.sdk.response.e eVar2, com.fyber.inneractive.sdk.interfaces.c cVar) {
        eVar.getClass();
        if (eVar2 == null || cVar == null) {
            return;
        }
        r.b.post(new c(eVar, inneractiveUnitController, marketplaceAdLoadListener, eVar2, cVar));
    }

    public com.fyber.inneractive.sdk.interfaces.c getAdContentLoader(MarketplaceAdLoadListener<? extends MarketplaceBridgeAd> marketplaceAdLoadListener, com.fyber.inneractive.sdk.response.a aVar) {
        com.fyber.inneractive.sdk.factories.e eVar = (com.fyber.inneractive.sdk.factories.e) com.fyber.inneractive.sdk.factories.d.f1768a.f1769a.get(aVar);
        com.fyber.inneractive.sdk.interfaces.c cVarA = eVar != null ? eVar.a() : null;
        if (cVarA != null) {
            return cVarA;
        }
        notifyFailToListener(MarketplaceAdLoadError.UNSUPPORTED_AD_TYPE, marketplaceAdLoadListener);
        return null;
    }

    public com.fyber.inneractive.sdk.response.a getResponseAdType(Map<String, String> map) {
        String str = map.get(EnumC3138n.RETURNED_AD_TYPE.a().toLowerCase(Locale.ENGLISH));
        if (str == null) {
            return null;
        }
        try {
            return com.fyber.inneractive.sdk.response.a.a(Integer.parseInt(str));
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    public abstract void internalOnAdLoaded(e eVar, k kVar);

    public abstract boolean isFullscreen();

    public boolean isMuted() {
        return this.mMuted;
    }

    public void loadAd(InneractiveUnitController<?> inneractiveUnitController, MarketplaceAdLoadListener<? extends MarketplaceBridgeAd> marketplaceAdLoadListener) {
        h hVar = this.mMarketplaceAuctionResponse;
        if (hVar == null) {
            notifyFailToListener(MarketplaceAdLoadError.FAILED_TO_PARSE_AD_CONTENT, marketplaceAdLoadListener);
            return;
        }
        com.fyber.inneractive.sdk.response.a aVar = hVar.b;
        String str = hVar.f2435a;
        Map map = hVar.c;
        if (aVar == null || str == null || map.isEmpty()) {
            notifyFailToListener(MarketplaceAdLoadError.FAILED_TO_PARSE_AD_CONTENT, marketplaceAdLoadListener);
        } else {
            r.f2374a.execute(new a(this, marketplaceAdLoadListener, aVar, str, map, inneractiveUnitController));
        }
    }

    public Map<String, String> lowerCaseHeaders(Map<String, String> map) {
        HashMap map2 = new HashMap();
        if (map != null) {
            for (String str : map.keySet()) {
                map2.put(TextUtils.isEmpty(str) ? str : str.toLowerCase(Locale.ENGLISH), map.get(str));
            }
        }
        return map2;
    }

    public void notifyFailToListener(MarketplaceAdLoadError marketplaceAdLoadError, MarketplaceAdLoadListener<? extends MarketplaceBridgeAd> marketplaceAdLoadListener) {
        if (isFullscreen()) {
            IAlog.a("Firing Event 801 - AdLoadFailed - errorCode - %s", marketplaceAdLoadError.getErrorMessage());
            C3146w c3146w = new C3146w(EnumC3143t.IA_AD_LOAD_FAILED, (InneractiveAdRequest) null, (com.fyber.inneractive.sdk.response.e) null);
            JSONObject jSONObject = new JSONObject();
            String string = marketplaceAdLoadError.toString();
            try {
                jSONObject.put("message", string);
            } catch (Exception unused) {
                IAlog.f("Got exception adding param to json object: %s, %s", "message", string);
            }
            String errorMessage = marketplaceAdLoadError.getErrorMessage();
            try {
                jSONObject.put("extra_description", errorMessage);
            } catch (Exception unused2) {
                IAlog.f("Got exception adding param to json object: %s, %s", "extra_description", errorMessage);
            }
            c3146w.f.put(jSONObject);
            c3146w.a((String) null);
        }
        marketplaceAdLoadListener.onAdLoadFailed(marketplaceAdLoadError);
    }

    public com.fyber.inneractive.sdk.response.e parseResponseData(MarketplaceAdLoadListener<? extends MarketplaceBridgeAd> marketplaceAdLoadListener, com.fyber.inneractive.sdk.response.a aVar, String str, Map<String, String> map) {
        com.fyber.inneractive.sdk.factories.e eVar = (com.fyber.inneractive.sdk.factories.e) com.fyber.inneractive.sdk.factories.d.f1768a.f1769a.get(aVar);
        com.fyber.inneractive.sdk.response.b bVarB = eVar != null ? eVar.b() : null;
        IAlog.a("IA Exchange response handler: final headers: %s", map);
        if (bVarB != null) {
            d dVar = new d(map, str);
            bVarB.f2320a = bVarB.a();
            bVarB.c = new com.fyber.inneractive.sdk.response.k(dVar);
        }
        try {
            com.fyber.inneractive.sdk.response.e eVarA = bVarB.a(str);
            com.fyber.inneractive.sdk.dv.j jVar = this.mWrapperQueryInfo;
            if (jVar != null) {
                eVarA.u = jVar;
            }
            InneractiveErrorCode inneractiveErrorCodeB = eVarA.b();
            if (inneractiveErrorCodeB == null) {
                return eVarA;
            }
            notifyFailToListener(MarketplaceAdLoadError.RESPONSE_VALIDATION_FAILED, marketplaceAdLoadListener);
            IAlog.a("failed parsing response data with error: %s", inneractiveErrorCodeB.toString());
            return null;
        } catch (Exception e) {
            notifyFailToListener(MarketplaceAdLoadError.FAILED_TO_PARSE_AD_CONTENT, marketplaceAdLoadListener);
            if (e.getMessage() != null) {
                IAlog.a("failed parsing response data with error: %s", e.getMessage());
            }
            return null;
        }
    }

    public void setQueryInfo(com.fyber.inneractive.sdk.dv.j jVar) {
        this.mWrapperQueryInfo = jVar;
    }
}
