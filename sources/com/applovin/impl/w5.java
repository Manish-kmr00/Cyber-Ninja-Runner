package com.applovin.impl;

import com.applovin.impl.sdk.AppLovinError;
import com.applovin.sdk.AppLovinAdLoadListener;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class w5 extends p5 {
    private final AppLovinAdLoadListener i;

    public w5(u uVar, AppLovinAdLoadListener appLovinAdLoadListener, com.applovin.impl.sdk.k kVar) {
        this(uVar, appLovinAdLoadListener, "TaskFetchNextAd", kVar);
    }

    @Override // com.applovin.impl.p5
    protected g5 a(JSONObject jSONObject) {
        return new c6(jSONObject, this.g, this.i, this.f424a);
    }

    @Override // com.applovin.impl.p5
    protected String e() {
        return r0.a(this.f424a);
    }

    @Override // com.applovin.impl.p5
    protected String f() {
        return r0.b(this.f424a);
    }

    public w5(u uVar, AppLovinAdLoadListener appLovinAdLoadListener, String str, com.applovin.impl.sdk.k kVar) {
        super(uVar, str, kVar);
        this.i = appLovinAdLoadListener;
    }

    @Override // com.applovin.impl.p5
    protected void a(int i, String str) {
        super.a(i, str);
        AppLovinAdLoadListener appLovinAdLoadListener = this.i;
        if (!(appLovinAdLoadListener instanceof l2)) {
            appLovinAdLoadListener.failedToReceiveAd(i);
        } else {
            ((l2) this.i).failedToReceiveAdV2(new AppLovinError(i, str));
        }
    }
}
