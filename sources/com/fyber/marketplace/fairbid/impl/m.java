package com.fyber.marketplace.fairbid.impl;

import android.app.Application;
import com.fyber.inneractive.sdk.config.B;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.util.AbstractC3251o;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.r;
import com.fyber.marketplace.fairbid.bridge.MarketplaceAdLoadError;
import com.fyber.marketplace.fairbid.bridge.MarketplaceAdLoadListener;
import com.fyber.marketplace.fairbid.bridge.MarketplaceBridgeAd;

/* JADX INFO: loaded from: classes10.dex */
public final class m implements IAConfigManager.OnConfigurationReadyAndValidListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MarketplaceBridgeAd f2438a;
    public final /* synthetic */ MarketplaceAdLoadListener b;
    public final /* synthetic */ n c;

    public m(n nVar, MarketplaceBridgeAd marketplaceBridgeAd, MarketplaceAdLoadListener marketplaceAdLoadListener) {
        this.c = nVar;
        this.f2438a = marketplaceBridgeAd;
        this.b = marketplaceAdLoadListener;
    }

    @Override // com.fyber.inneractive.sdk.config.IAConfigManager.OnConfigurationReadyAndValidListener
    public final void onConfigurationReadyAndValid(IAConfigManager iAConfigManager, boolean z, Exception exc) {
        IAConfigManager.removeListener(this);
        if (!IAConfigManager.e()) {
            MarketplaceAdLoadListener marketplaceAdLoadListener = this.b;
            if (marketplaceAdLoadListener != null) {
                marketplaceAdLoadListener.onAdLoadFailed(MarketplaceAdLoadError.FMP_NOT_READY_TO_LOAD_ADS);
                return;
            }
            return;
        }
        this.c.getClass();
        IAlog.a("maybeInitOmidSdk", new Object[0]);
        IAConfigManager iAConfigManager2 = IAConfigManager.O;
        com.fyber.inneractive.sdk.measurement.e eVar = iAConfigManager2.K;
        if (eVar == null || !eVar.f1859a) {
            Application application = AbstractC3251o.f2370a;
            IAlog.c("initOmidSdk", new Object[0]);
            r.f2374a.execute(new B(iAConfigManager2, application));
        }
        this.f2438a.load();
    }
}
