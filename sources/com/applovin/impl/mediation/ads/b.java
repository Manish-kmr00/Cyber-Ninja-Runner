package com.applovin.impl.mediation.ads;

import android.view.ViewGroup;
import com.applovin.impl.a3;
import com.applovin.impl.c8;
import com.applovin.impl.d8;
import com.applovin.impl.sdk.k;
import com.applovin.impl.sdk.o;

/* JADX INFO: loaded from: classes11.dex */
public class b implements d8.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final k f533a;
    private final a3 b;
    private final d8 c;
    private final c8 d;
    private final a.InterfaceC0135a e;

    public b(a3 a3Var, ViewGroup viewGroup, a.InterfaceC0135a interfaceC0135a, k kVar) {
        this.f533a = kVar;
        this.b = a3Var;
        this.e = interfaceC0135a;
        this.d = new c8(viewGroup, kVar);
        d8 d8Var = new d8(viewGroup, kVar, this);
        this.c = d8Var;
        d8Var.a(a3Var);
        kVar.O();
        if (o.a()) {
            kVar.O().a("MaxNativeAdView", "Created new MaxNativeAdView (" + this + ")");
        }
    }

    public void a() {
        this.c.b();
    }

    public a3 b() {
        return this.b;
    }

    public void c() {
        this.f533a.O();
        if (o.a()) {
            this.f533a.O().a("MaxNativeAdView", "Handling view attached to window");
        }
        if (this.b.o0().compareAndSet(false, true)) {
            this.f533a.O();
            if (o.a()) {
                this.f533a.O().a("MaxNativeAdView", "Scheduling impression for ad manually...");
            }
            if (this.b.getNativeAd().isExpired()) {
                o.h("MaxNativeAdView", "Attempting to display an expired native ad. Check if an ad is expired before displaying using `MaxAd.getNativeAd().isExpired()`");
            } else {
                this.f533a.f().a(this.b);
            }
            this.f533a.X().processRawAdImpression(this.b, this.e);
        }
    }

    @Override // com.applovin.impl.d8.a
    public void onLogVisibilityImpression() {
        a(this.d.a(this.b));
    }

    private void a(long j) {
        if (this.b.p0().compareAndSet(false, true)) {
            this.f533a.O();
            if (o.a()) {
                this.f533a.O().a("MaxNativeAdView", "Scheduling viewability impression for ad...");
            }
            this.f533a.X().processViewabilityAdImpressionPostback(this.b, j, this.e);
        }
    }
}
