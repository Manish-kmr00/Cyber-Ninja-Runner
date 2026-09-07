package com.fyber.marketplace.fairbid.impl;

import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.marketplace.fairbid.bridge.MarketplaceOnUserAgentAvailableListener;

/* JADX INFO: loaded from: classes10.dex */
public final class l implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MarketplaceOnUserAgentAvailableListener f2437a;

    public l(MarketplaceOnUserAgentAvailableListener marketplaceOnUserAgentAvailableListener) {
        this.f2437a = marketplaceOnUserAgentAvailableListener;
    }

    @Override // java.lang.Runnable
    public final void run() {
        IAConfigManager iAConfigManager;
        int i = 0;
        while (true) {
            iAConfigManager = IAConfigManager.O;
            if (!iAConfigManager.y.f2378a.get() || iAConfigManager.y.d.compareAndSet(true, true) || i >= 100) {
                break;
            }
            IAlog.a("UserAgentProvider | waiting on user agent", new Object[0]);
            try {
                Thread.sleep(100L);
            } catch (InterruptedException unused) {
            }
            i++;
        }
        String strA = iAConfigManager.y.a();
        if (strA.isEmpty()) {
            return;
        }
        IAlog.a("UserAgentAvailable", new Object[0]);
        this.f2437a.onUserAgentAvailable(strA);
    }
}
