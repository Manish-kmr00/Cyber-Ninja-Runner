package com.fyber.inneractive.sdk.renderers;

import android.view.View;
import com.fyber.inneractive.sdk.activities.InneractiveRichMediaVideoPlayerActivityCore;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.config.M;
import com.fyber.inneractive.sdk.config.T;
import com.fyber.inneractive.sdk.config.U;
import com.fyber.inneractive.sdk.config.Z;
import com.fyber.inneractive.sdk.config.enums.Orientation;
import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;
import com.fyber.inneractive.sdk.external.WebViewRendererProcessHasGoneError;
import com.fyber.inneractive.sdk.flow.N;
import com.fyber.inneractive.sdk.flow.S;
import com.fyber.inneractive.sdk.flow.x;
import com.fyber.inneractive.sdk.player.controller.F;
import com.fyber.inneractive.sdk.util.D;
import com.fyber.inneractive.sdk.util.EnumC3243g;
import com.fyber.inneractive.sdk.util.G;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.h0;

/* JADX INFO: loaded from: classes11.dex */
public final class p extends N implements F {
    public boolean w = false;

    @Override // com.fyber.inneractive.sdk.flow.N
    public final boolean G() {
        return false;
    }

    @Override // com.fyber.inneractive.sdk.flow.N
    public final int I() {
        return 0;
    }

    @Override // com.fyber.inneractive.sdk.flow.N
    public final int J() {
        return 0;
    }

    @Override // com.fyber.inneractive.sdk.flow.N
    public final long K() {
        return 0L;
    }

    @Override // com.fyber.inneractive.sdk.flow.N
    public final boolean L() {
        return false;
    }

    @Override // com.fyber.inneractive.sdk.flow.N
    public final long a(long j) {
        return 0L;
    }

    @Override // com.fyber.inneractive.sdk.interfaces.f
    public final void a() {
    }

    @Override // com.fyber.inneractive.sdk.interfaces.f
    public final void a(com.fyber.inneractive.sdk.external.g gVar) {
    }

    @Override // com.fyber.inneractive.sdk.player.controller.F
    public final void a(boolean z) {
    }

    @Override // com.fyber.inneractive.sdk.player.controller.F
    public final void a(boolean z, Orientation orientation) {
    }

    @Override // com.fyber.inneractive.sdk.flow.N
    public final /* bridge */ /* synthetic */ boolean b(x xVar) {
        return false;
    }

    @Override // com.fyber.inneractive.sdk.player.controller.F
    public final void c() {
    }

    @Override // com.fyber.inneractive.sdk.flow.N, com.fyber.inneractive.sdk.flow.A, com.fyber.inneractive.sdk.external.InneractiveAdRenderer
    public final void destroy() {
        if (!this.w) {
            k();
        }
        this.b = null;
        super.destroy();
    }

    @Override // com.fyber.inneractive.sdk.player.controller.F
    public final void e() {
    }

    @Override // com.fyber.inneractive.sdk.player.controller.F
    public final void h() {
        a(new WebViewRendererProcessHasGoneError());
    }

    @Override // com.fyber.inneractive.sdk.player.controller.F
    public final void i() {
    }

    @Override // com.fyber.inneractive.sdk.player.controller.F
    public final void j() {
    }

    @Override // com.fyber.inneractive.sdk.interfaces.f
    public final void k() {
        this.w = true;
        x xVar = this.b;
        if (xVar != null) {
        }
        IAlog.a("%sunit controller is null!", IAlog.a(this));
    }

    @Override // com.fyber.inneractive.sdk.flow.N, com.fyber.inneractive.sdk.interfaces.f
    public final void m() {
    }

    @Override // com.fyber.inneractive.sdk.player.controller.F
    public final void onCompleted() {
    }

    @Override // com.fyber.inneractive.sdk.player.controller.F
    public final void onPlayerError() {
    }

    @Override // com.fyber.inneractive.sdk.player.controller.F
    public final void onProgress(int i, int i2) {
    }

    @Override // com.fyber.inneractive.sdk.flow.N, com.fyber.inneractive.sdk.interfaces.f
    public final void r() {
    }

    @Override // com.fyber.inneractive.sdk.interfaces.f
    public final boolean t() {
        return false;
    }

    @Override // com.fyber.inneractive.sdk.player.controller.F
    public final void f() {
        IAlog.a("%snShownCloseButton", IAlog.a(this));
    }

    @Override // com.fyber.inneractive.sdk.player.controller.F
    public final D a(String str, h0 h0Var, boolean z) {
        return new D(G.FAILED, new Exception("No Companion clicked"));
    }

    @Override // com.fyber.inneractive.sdk.player.controller.F
    public final D a(h0 h0Var, EnumC3243g enumC3243g) {
        U u;
        M m;
        x xVar = this.b;
        if (xVar != null && (u = ((S) xVar).d) != null && (m = ((T) u).c) != null) {
            UnitDisplayType unitDisplayType = m.b;
            Z z = IAConfigManager.O.x;
            com.fyber.inneractive.sdk.cache.session.enums.c cVar = unitDisplayType == UnitDisplayType.REWARDED ? com.fyber.inneractive.sdk.cache.session.enums.c.REWARDED_VIDEO : com.fyber.inneractive.sdk.cache.session.enums.c.INTERSTITIAL_VIDEO;
            com.fyber.inneractive.sdk.cache.session.enums.a aVar = com.fyber.inneractive.sdk.cache.session.enums.a.CLICK;
            com.fyber.inneractive.sdk.cache.session.e eVar = z.f1684a;
            if (eVar != null) {
                com.fyber.inneractive.sdk.util.r.f2374a.execute(new com.fyber.inneractive.sdk.cache.session.d(eVar, aVar, cVar));
            }
        }
        throw null;
    }

    @Override // com.fyber.inneractive.sdk.player.controller.F
    public final void a(String str, String str2) {
        IAlog.a(IAlog.a(this) + "full screen video ad renderer callback: onSuspiciousNoUserWebActionDetected", new Object[0]);
    }

    @Override // com.fyber.inneractive.sdk.player.controller.F
    public final void a(View view, String str) {
        if (view == null || view.getContext() == null) {
            return;
        }
        InneractiveRichMediaVideoPlayerActivityCore.startRichMediaIntent(view.getContext(), str);
        a(c(view), Float.NaN, Float.NaN);
    }

    @Override // com.fyber.inneractive.sdk.player.controller.F
    public final void a(View view) {
        a(c(view), Float.NaN, Float.NaN);
    }
}
