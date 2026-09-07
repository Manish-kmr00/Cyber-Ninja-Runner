package com.applovin.impl;

import android.app.Activity;
import android.os.SystemClock;
import android.view.ViewGroup;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import com.iab.omid.library.applovin.adsession.FriendlyObstructionPurpose;
import com.safedk.android.internal.special.SpecialsBridge;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes4.dex */
public class w1 extends v1 {
    private final x1 M;
    private g0 N;
    private long O;
    private final AtomicBoolean P;

    public w1(com.applovin.impl.sdk.ad.b bVar, Activity activity, Map map, com.applovin.impl.sdk.k kVar, AppLovinAdClickListener appLovinAdClickListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener) {
        super(bVar, activity, map, kVar, appLovinAdClickListener, appLovinAdDisplayListener, appLovinAdVideoPlaybackListener);
        this.M = new x1(this.f715a, this.d, this.b);
        this.P = new AtomicBoolean();
    }

    private long B() {
        com.applovin.impl.sdk.ad.b bVar = this.f715a;
        if (!(bVar instanceof com.applovin.impl.sdk.ad.a)) {
            return 0L;
        }
        float fT1 = ((com.applovin.impl.sdk.ad.a) bVar).t1();
        if (fT1 <= 0.0f) {
            fT1 = this.f715a.s();
        }
        return (long) (k7.c(fT1) * (((double) this.f715a.I()) / 100.0d));
    }

    private int C() {
        g0 g0Var;
        int iMin = 100;
        if (g()) {
            if (!D() && (g0Var = this.N) != null) {
                iMin = (int) Math.min(100.0d, ((this.O - g0Var.b()) / this.O) * 100.0d);
            }
            if (com.applovin.impl.sdk.o.a()) {
                this.c.a("AppLovinFullscreenActivity", "Ad engaged at " + iMin + "%");
            }
        }
        return iMin;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void E() {
        if (com.applovin.impl.sdk.o.a()) {
            this.c.a("AppLovinFullscreenActivity", "Marking ad as fully watched");
        }
        this.P.set(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void F() {
        this.q = SystemClock.elapsedRealtime();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void G() {
        ArrayList arrayList = new ArrayList();
        com.applovin.impl.adview.g gVar = this.k;
        if (gVar != null) {
            arrayList.add(new e4(gVar, FriendlyObstructionPurpose.CLOSE_AD, "close button"));
        }
        com.applovin.impl.adview.k kVar = this.j;
        if (kVar != null && kVar.a()) {
            com.applovin.impl.adview.k kVar2 = this.j;
            arrayList.add(new e4(kVar2, FriendlyObstructionPurpose.NOT_VISIBLE, kVar2.getIdentifier()));
        }
        this.f715a.getAdEventTracker().b(this.i, arrayList);
    }

    protected boolean D() {
        if (!(this.J && this.f715a.n1()) && g()) {
            return this.P.get();
        }
        return true;
    }

    protected void H() {
        long jZ;
        long millis = 0;
        if (this.f715a.Y() >= 0 || this.f715a.Z() >= 0) {
            if (this.f715a.Y() >= 0) {
                jZ = this.f715a.Y();
            } else {
                if (this.f715a.j1()) {
                    int iT1 = (int) ((com.applovin.impl.sdk.ad.a) this.f715a).t1();
                    if (iT1 > 0) {
                        millis = TimeUnit.SECONDS.toMillis(iT1);
                    } else {
                        int iS = (int) this.f715a.s();
                        if (iS > 0) {
                            millis = TimeUnit.SECONDS.toMillis(iS);
                        }
                    }
                }
                jZ = (long) (millis * (((double) this.f715a.Z()) / 100.0d));
            }
            c(jZ);
        }
    }

    @Override // com.applovin.impl.v1
    public void a(ViewGroup viewGroup) {
        this.M.a(this.k, this.j, this.i, viewGroup);
        if (((Boolean) this.b.a(v4.L5)).booleanValue() || !a(false)) {
            com.applovin.impl.adview.k kVar = this.j;
            if (kVar != null) {
                kVar.b();
            }
            SpecialsBridge.appLovinAdViewRenderAd(this.i, this.f715a);
            a("javascript:al_onPoststitialShow();", this.f715a.H());
            if (g()) {
                long jB = B();
                this.O = jB;
                if (jB > 0) {
                    if (com.applovin.impl.sdk.o.a()) {
                        this.c.a("AppLovinFullscreenActivity", "Scheduling timer for ad fully watched in " + this.O + "ms...");
                    }
                    this.N = g0.a(this.O, this.b, new Runnable() { // from class: com.applovin.impl.w1$$ExternalSyntheticLambda0
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.E();
                        }
                    });
                }
            }
            if (this.k != null) {
                if (this.f715a.s() >= 0) {
                    a(this.k, this.f715a.s(), new Runnable() { // from class: com.applovin.impl.w1$$ExternalSyntheticLambda1
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.F();
                        }
                    });
                } else {
                    this.k.setVisibility(0);
                }
            }
            H();
            this.b.r0().a(new p6(this.b, "updateMainViewOM", new Runnable() { // from class: com.applovin.impl.w1$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.G();
                }
            }), b6.b.OTHER, TimeUnit.SECONDS.toMillis(1L));
            o();
            super.c(k7.e(this.b));
        }
    }

    @Override // com.applovin.impl.v1
    public void b(long j) {
    }

    @Override // com.applovin.impl.v1
    public void d() {
        super.d();
        z();
    }

    @Override // com.applovin.impl.v1
    public void e() {
        super.e();
        z();
    }

    @Override // com.applovin.impl.v1
    protected void l() {
        super.a(C(), false, D(), -2L);
    }

    @Override // com.applovin.impl.v1
    public void u() {
    }

    @Override // com.applovin.impl.v1
    public void v() {
        a((ViewGroup) null);
    }

    @Override // com.applovin.impl.v1
    protected void w() {
        super.w();
        this.P.set(true);
    }

    @Override // com.applovin.impl.v1
    protected void z() {
        this.M.a(this.l);
        this.q = SystemClock.elapsedRealtime();
        this.P.set(true);
    }

    @Override // com.applovin.impl.v1
    public void a(String str) {
        if (!((Boolean) this.b.a(v4.D6)).booleanValue()) {
            com.applovin.impl.sdk.ad.b bVar = this.f715a;
            if (bVar != null) {
                bVar.a(str);
            }
            l();
        }
        g0 g0Var = this.N;
        if (g0Var != null) {
            g0Var.a();
            this.N = null;
        }
        super.a(str);
    }
}
