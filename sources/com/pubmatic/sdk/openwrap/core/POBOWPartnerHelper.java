package com.pubmatic.sdk.openwrap.core;

import android.content.Context;
import com.pubmatic.sdk.common.base.POBBaseBidder;
import com.pubmatic.sdk.common.models.POBProfileInfo;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class POBOWPartnerHelper {

    private static class a implements POBBaseBidder.CountryFilterConfig {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final POBProfileInfo f7730a;

        a(POBProfileInfo pOBProfileInfo) {
            this.f7730a = pOBProfileInfo;
        }

        @Override // com.pubmatic.sdk.common.base.POBBaseBidder.CountryFilterConfig
        public String getCountryFilteringMode() {
            return this.f7730a.getCountryFilteringMode();
        }

        @Override // com.pubmatic.sdk.common.base.POBBaseBidder.CountryFilterConfig
        public Set getFilteringCountries() {
            return this.f7730a.getFilteringCountries();
        }
    }

    public static POBManager createPOBManager(Context context, POBRequest pOBRequest, POBProfileInfo pOBProfileInfo) {
        POBManager pOBManager = new POBManager(pOBRequest, context);
        pOBManager.setIdentifier("OpenWrap");
        if (pOBProfileInfo != null) {
            pOBManager.setCountryFilterConfig(new a(pOBProfileInfo));
        }
        return pOBManager;
    }
}
