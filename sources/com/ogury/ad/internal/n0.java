package com.ogury.ad.internal;

import android.app.Application;
import android.content.Context;
import android.widget.FrameLayout;
import com.ogury.ad.common.OguryMediation;
import com.ogury.ad.interstitial.ui.InterstitialActivity;
import com.ogury.core.internal.IntegrationLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;

/* JADX INFO: loaded from: classes.dex */
public final class n0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f7361a;
    public final FrameLayout b;
    public final h0 c;
    public final o0 d;
    public final p0 e;
    public final OguryMediation f;
    public g0 g;
    public x h;
    public x i;
    public g0 j;
    public w8 k;

    public n0(Context context, FrameLayout container, OguryMediation oguryMediation) {
        InterstitialActivity.a aVar = InterstitialActivity.d;
        h0 adControllerFactory = new h0();
        o0 adsSourceFactory = new o0(context);
        p0 bannerCallback = new p0();
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(adControllerFactory, "adControllerFactory");
        Intrinsics.checkNotNullParameter(adsSourceFactory, "adsSourceFactory");
        Intrinsics.checkNotNullParameter(bannerCallback, "bannerCallback");
        this.f7361a = context;
        this.b = container;
        this.c = adControllerFactory;
        this.d = adsSourceFactory;
        this.e = bannerCallback;
        this.f = oguryMediation;
        bannerCallback.b = new k0(this);
    }

    public final void a(d adConfig, o oVar, w8 adSize, String str) throws JSONException {
        x xVar;
        Intrinsics.checkNotNullParameter(adConfig, "adConfig");
        Intrinsics.checkNotNullParameter(adSize, "adSize");
        x xVar2 = this.h;
        if (xVar2 != null && xVar2.c() && (xVar = this.h) != null) {
            xVar.g();
        }
        if (oVar == null) {
            IntegrationLogger.e("[Ads][Banner View][load][" + adConfig.a() + "] Failed to load (invalid banner ad size)");
            throw new IllegalArgumentException("Ad size must be set before loading an ad".toString());
        }
        if (!oVar.c()) {
            IntegrationLogger.e("[Ads][Banner View][load][" + adConfig.a() + "] Failed to load (invalid ad type: " + oVar.b() + ")");
            throw new IllegalArgumentException(("AdType " + oVar + " is not a banner type").toString());
        }
        if (adConfig.a().length() <= 0) {
            IntegrationLogger.e("[Ads][" + oVar.b() + "][load] Failed to load (invalid ad unit ID: \"" + adConfig.a() + "\")");
            throw new IllegalArgumentException("Ad unit must be set before loading an ad".toString());
        }
        this.k = adSize;
        x xVar3 = this.h;
        if (xVar3 == null || !xVar3.e()) {
            this.i = this.h;
            this.j = this.g;
        } else {
            g0 g0Var = this.g;
            if (g0Var != null) {
                g0Var.b();
            }
            x xVar4 = this.h;
            if (xVar4 != null) {
                xVar4.b();
            }
        }
        h0 h0Var = this.c;
        Context applicationContext = this.f7361a.getApplicationContext();
        Intrinsics.checkNotNull(applicationContext, "null cannot be cast to non-null type android.app.Application");
        h0Var.getClass();
        this.g = h0.a((Application) applicationContext);
        o0 o0Var = this.d;
        OguryMediation oguryMediation = this.f;
        x xVar5 = this.h;
        x xVarA = o0Var.a(adConfig, oVar, oguryMediation, xVar5 != null && xVar5.o);
        this.h = xVarA;
        xVarA.a(this.e);
        if (str != null) {
            x xVar6 = this.h;
            if (xVar6 != null) {
                xVar6.a(str);
                return;
            }
            return;
        }
        x xVar7 = this.h;
        if (xVar7 != null) {
            xVar7.a((String) null);
        }
    }

    public final void a() {
        g0 g0Var;
        d5 d5Var;
        w8 adSize = this.k;
        if (adSize == null || (g0Var = this.g) == null) {
            return;
        }
        Intrinsics.checkNotNullParameter(adSize, "adSize");
        j4 j4Var = g0Var.f;
        g0Var.e.a(adSize, g0Var.g, j4Var != null && ((d5Var = j4Var.q) == null || (!Intrinsics.areEqual(d5Var.getAdState(), "resized") && (j4Var.h.getParent() instanceof u0))));
    }
}
