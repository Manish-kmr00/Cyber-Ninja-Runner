package com.fyber.inneractive.sdk.player;

import android.app.Application;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.config.T;
import com.fyber.inneractive.sdk.config.U;
import com.fyber.inneractive.sdk.config.V;
import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.flow.S;
import com.fyber.inneractive.sdk.util.AbstractC3251o;
import com.fyber.inneractive.sdk.util.IAlog;

/* JADX INFO: loaded from: classes12.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final S f1937a;
    public n b;

    public b(S s) {
        this.f1937a = s;
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0055  */
    public final a a() {
        com.fyber.inneractive.sdk.measurement.e eVar;
        V v;
        UnitDisplayType unitDisplayType;
        if (this.b == null) {
            Application application = AbstractC3251o.f2370a;
            S s = this.f1937a;
            com.fyber.inneractive.sdk.response.g gVar = (com.fyber.inneractive.sdk.response.g) s.b;
            U u = s.d;
            InneractiveAdRequest inneractiveAdRequest = s.f1840a;
            if (u == null) {
                eVar = null;
            } else {
                Boolean boolC = ((com.fyber.inneractive.sdk.config.global.features.m) s.c.a(com.fyber.inneractive.sdk.config.global.features.m.class)).c(com.json.mediationsdk.metadata.a.j);
                boolean zBooleanValue = boolC != null ? boolC.booleanValue() : false;
                IAlog.a("OMSDK AB %s", String.valueOf(zBooleanValue));
                if (zBooleanValue && (v = ((T) this.f1937a.d).f) != null && ((unitDisplayType = v.j) == UnitDisplayType.INTERSTITIAL || unitDisplayType == UnitDisplayType.REWARDED)) {
                    eVar = IAConfigManager.O.K;
                } else {
                    eVar = null;
                }
            }
            this.b = new n(application, gVar, u, inneractiveAdRequest, s, eVar);
        }
        return this.b;
    }
}
