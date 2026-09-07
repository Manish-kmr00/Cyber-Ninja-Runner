package com.applovin.impl;

import com.applovin.impl.sdk.AppLovinError;
import com.applovin.impl.sdk.ad.AppLovinAdImpl;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.sdk.AppLovinAdSize;
import java.util.HashMap;
import java.util.Map;
import net.pubnative.lite.sdk.analytics.Reporting;

/* JADX INFO: loaded from: classes6.dex */
public class f extends d2 {
    public f(com.applovin.impl.sdk.k kVar) {
        super(kVar, c2.b.AD);
    }

    public void a(c2 c2Var, com.applovin.impl.sdk.ad.b bVar) {
        a(c2Var, bVar, new HashMap());
    }

    public void a(c2 c2Var, com.applovin.impl.sdk.ad.b bVar, Map map) {
        a(c2Var, bVar != null ? bVar.getAdZone() : null, bVar, null, map);
    }

    public void a(c2 c2Var, u uVar, AppLovinError appLovinError) {
        a(c2Var, uVar, null, appLovinError, new HashMap());
    }

    private void a(c2 c2Var, u uVar, com.applovin.impl.sdk.ad.b bVar, AppLovinError appLovinError, Map map) {
        if (((Boolean) this.f392a.a(v4.H)).booleanValue() && this.f392a.H0()) {
            return;
        }
        if (bVar != null) {
            map.putAll(e2.a((AppLovinAdImpl) bVar));
        } else if (uVar != null) {
            CollectionUtils.putStringIfValid("ad_zone_id", uVar.e(), map);
            MaxAdFormat maxAdFormatD = uVar.d();
            if (maxAdFormatD != null) {
                CollectionUtils.putStringIfValid("ad_format", maxAdFormatD.getLabel(), map);
            }
        }
        AppLovinAdSize appLovinAdSizeA = a(uVar, bVar);
        if (appLovinAdSizeA != null) {
            CollectionUtils.putStringIfValid(Reporting.Key.AD_SIZE, appLovinAdSizeA.getLabel(), map);
        }
        if (appLovinError != null) {
            CollectionUtils.putStringIfValid("error_message", appLovinError.getMessage(), map);
            CollectionUtils.putStringIfValid("error_code", String.valueOf(appLovinError.getCode()), map);
        }
        d(c2Var, map);
    }

    private AppLovinAdSize a(u uVar, com.applovin.impl.sdk.ad.b bVar) {
        AppLovinAdSize appLovinAdSizeF = uVar != null ? uVar.f() : null;
        if (appLovinAdSizeF != null) {
            return appLovinAdSizeF;
        }
        if (bVar != null) {
            return bVar.getSize();
        }
        return null;
    }
}
