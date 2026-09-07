package com.applovin.impl;

import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.sdk.AppLovinAdLoadListener;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public class h6 extends g5 {
    private final JSONObject g;
    private final JSONObject h;
    private final AppLovinAdLoadListener i;

    public h6(JSONObject jSONObject, JSONObject jSONObject2, AppLovinAdLoadListener appLovinAdLoadListener, com.applovin.impl.sdk.k kVar) {
        super("TaskRenderAppLovinAd", kVar);
        this.g = jSONObject;
        this.h = jSONObject2;
        this.i = appLovinAdLoadListener;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (com.applovin.impl.sdk.o.a()) {
            this.c.a(this.b, "Rendering ad...");
        }
        com.applovin.impl.sdk.ad.a aVar = new com.applovin.impl.sdk.ad.a(this.g, this.h, this.f424a);
        boolean zBooleanValue = JsonUtils.getBoolean(this.g, "gs_load_immediately", Boolean.FALSE).booleanValue();
        boolean zBooleanValue2 = JsonUtils.getBoolean(this.g, "vs_load_immediately", Boolean.TRUE).booleanValue();
        k5 k5Var = new k5(aVar, this.f424a, this.i);
        k5Var.c(zBooleanValue2);
        k5Var.b(zBooleanValue);
        this.f424a.r0().a((g5) k5Var, b6.b.CACHING);
    }
}
