package com.applovin.impl;

import com.applovin.impl.sdk.AppLovinError;
import com.applovin.impl.sdk.nativeAd.AppLovinNativeAdLoadListener;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public abstract class x5 extends p5 {
    private final AppLovinNativeAdLoadListener i;

    public x5(u uVar, String str, AppLovinNativeAdLoadListener appLovinNativeAdLoadListener, com.applovin.impl.sdk.k kVar) {
        super(uVar, str, kVar);
        this.i = appLovinNativeAdLoadListener;
    }

    @Override // com.applovin.impl.p5
    protected g5 a(JSONObject jSONObject) {
        return new e6(jSONObject, this.i, this.f424a);
    }

    @Override // com.applovin.impl.p5
    protected String e() {
        return r0.d(this.f424a);
    }

    @Override // com.applovin.impl.p5
    protected String f() {
        return r0.e(this.f424a);
    }

    @Override // com.applovin.impl.p5
    protected void a(int i, String str) {
        super.a(i, str);
        this.i.onNativeAdLoadFailed(new AppLovinError(i, str));
    }
}
