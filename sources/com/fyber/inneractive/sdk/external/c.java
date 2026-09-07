package com.fyber.inneractive.sdk.external;

import android.content.SharedPreferences;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.network.C3146w;
import com.fyber.inneractive.sdk.network.EnumC3144u;
import com.fyber.inneractive.sdk.util.AbstractC3251o;

/* JADX INFO: loaded from: classes12.dex */
public final class c implements Runnable {
    @Override // java.lang.Runnable
    public final void run() {
        IAConfigManager iAConfigManager = IAConfigManager.O;
        SharedPreferences sharedPreferences = AbstractC3251o.f2370a.getSharedPreferences("IAConfigurationPreferences", 0);
        if (sharedPreferences == null || !sharedPreferences.contains("IAConfigFQE")) {
            IAConfigManager.g();
            new C3146w(EnumC3144u.FIRST_OPENED, (InneractiveAdRequest) null, (com.fyber.inneractive.sdk.response.e) null).a((String) null);
        }
    }
}
