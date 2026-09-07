package com.applovin.impl;

import android.os.SystemClock;
import android.view.ViewGroup;
import com.applovin.mediation.nativeAds.MaxNativeAd;
import com.applovin.mediation.nativeAds.MaxNativeAdView;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public class a3 extends e3 implements s1 {
    private final AtomicBoolean u;
    private final AtomicBoolean v;

    public a3(x2 x2Var, JSONObject jSONObject, JSONObject jSONObject2, com.applovin.impl.sdk.k kVar) {
        super(x2Var, jSONObject, jSONObject2, null, kVar);
        this.u = new AtomicBoolean();
        this.v = new AtomicBoolean();
    }

    private long l0() {
        long jA = a("ad_expiration_ms", -1L);
        return jA < 0 ? b("ad_expiration_ms", ((Long) this.f436a.a(o3.J7)).longValue()) : jA;
    }

    @Override // com.applovin.impl.v2
    public v2 a(com.applovin.impl.mediation.h hVar) {
        return new a3(this, hVar);
    }

    @Override // com.applovin.impl.s1
    public long getTimeToLiveMillis() {
        return l0() - (SystemClock.elapsedRealtime() - H());
    }

    public MaxNativeAdView m0() {
        return this.n.f();
    }

    public ViewGroup n0() {
        return this.n.h();
    }

    public AtomicBoolean o0() {
        return this.u;
    }

    public AtomicBoolean p0() {
        return this.v;
    }

    public boolean q0() {
        return a("inacc", (Boolean) this.f436a.a(o3.c8)).booleanValue();
    }

    public boolean r0() {
        return this.n == null;
    }

    @Override // com.applovin.impl.s1
    public void setExpired() {
        MaxNativeAd nativeAd = getNativeAd();
        if (nativeAd != null) {
            nativeAd.setExpired();
        }
    }

    public void a(MaxNativeAdView maxNativeAdView) {
        this.n.a(maxNativeAdView);
    }

    public void a(ViewGroup viewGroup) {
        this.n.a(viewGroup);
    }

    private a3(a3 a3Var, com.applovin.impl.mediation.h hVar) {
        super(a3Var.M(), a3Var.a(), a3Var.g(), hVar, a3Var.f436a);
        this.u = new AtomicBoolean();
        this.v = new AtomicBoolean();
    }
}
