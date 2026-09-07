package com.fyber.inneractive.sdk.web;

import android.view.ViewTreeObserver;
import com.fyber.inneractive.sdk.util.AbstractC3251o;

/* JADX INFO: loaded from: classes12.dex */
public final class g0 implements ViewTreeObserver.OnPreDrawListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ j0 f2409a;

    public g0(j0 j0Var) {
        this.f2409a = j0Var;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        C3274m c3274m;
        C3274m c3274m2 = this.f2409a.b;
        if (c3274m2 == null) {
            return false;
        }
        c3274m2.getViewTreeObserver().removeOnPreDrawListener(this);
        this.f2409a.k();
        j0 j0Var = this.f2409a;
        j0Var.a(new com.fyber.inneractive.sdk.mraid.B(j0Var.G));
        j0 j0Var2 = this.f2409a;
        if (j0Var2.G == C.INTERSTITIAL && (c3274m = j0Var2.b) != null) {
            c3274m.a("if (window.showInterstitial) { showInterstitial(); }");
        }
        this.f2409a.j();
        j0 j0Var3 = this.f2409a;
        j0Var3.a(AbstractC3251o.a(j0Var3.b), true);
        this.f2409a.n();
        com.fyber.inneractive.sdk.util.r.b.postDelayed(this.f2409a.L, 100L);
        return false;
    }
}
