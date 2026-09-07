package com.applovin.impl;

import com.applovin.sdk.AppLovinAdLoadListener;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class y5 extends w5 {
    private final k j;

    public y5(k kVar, AppLovinAdLoadListener appLovinAdLoadListener, com.applovin.impl.sdk.k kVar2) {
        super(u.a("adtoken_zone"), appLovinAdLoadListener, "TaskFetchTokenAd", kVar2);
        this.j = kVar;
    }

    @Override // com.applovin.impl.p5
    protected Map h() {
        HashMap map = new HashMap(2);
        map.put("adtoken", this.j.b());
        map.put("adtoken_prefix", this.j.d());
        return map;
    }
}
