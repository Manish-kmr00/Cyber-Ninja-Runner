package com.fyber.inneractive.sdk.config;

import com.fyber.inneractive.sdk.network.C3131g;
import com.fyber.inneractive.sdk.network.C3146w;
import com.fyber.inneractive.sdk.network.EnumC3143t;
import com.fyber.inneractive.sdk.util.IAlog;

/* JADX INFO: loaded from: classes13.dex */
public final class F implements com.fyber.inneractive.sdk.network.E {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IAConfigManager f1670a;

    public F(IAConfigManager iAConfigManager) {
        this.f1670a = iAConfigManager;
    }

    @Override // com.fyber.inneractive.sdk.network.E
    public final void a(Object obj, Exception exc, boolean z) {
        com.fyber.inneractive.sdk.config.global.l lVar = (com.fyber.inneractive.sdk.config.global.l) obj;
        if (lVar != null) {
            IAlog.a("calling mergeRemoteFeaturesConfig fromCache: %b", Boolean.valueOf(z));
            IAConfigManager iAConfigManager = this.f1670a;
            iAConfigManager.z.f1695a = lVar;
            if (z) {
                return;
            }
            iAConfigManager.M.a(true, "");
            IAConfigManager.O.E.a(iAConfigManager.M);
            return;
        }
        if (exc != null) {
            if (exc instanceof C3131g) {
                IAlog.a("remote features config not modified", new Object[0]);
                IAConfigManager iAConfigManager2 = this.f1670a;
                iAConfigManager2.M.a(true, "");
                IAConfigManager.O.E.a(iAConfigManager2.M);
                return;
            }
            IAlog.a("Config manager: Error getting or parsing remote config. Resetting configurable features", new Object[0]);
            IAConfigManager iAConfigManager3 = this.f1670a;
            IAConfigManager iAConfigManager4 = IAConfigManager.O;
            iAConfigManager3.getClass();
            new C3146w(EnumC3143t.FATAL_FEATURES_CONFIG_ERROR).a("exception", exc.getClass().getName(), "message", exc.getLocalizedMessage()).a((String) null);
        }
    }
}
