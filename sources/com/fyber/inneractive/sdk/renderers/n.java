package com.fyber.inneractive.sdk.renderers;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.fyber.inneractive.sdk.activities.InneractiveRichMediaVideoPlayerActivityCore;
import com.fyber.inneractive.sdk.config.enums.Orientation;
import com.fyber.inneractive.sdk.external.VideoContentListener;
import com.fyber.inneractive.sdk.external.WebViewRendererProcessHasGoneError;
import com.fyber.inneractive.sdk.flow.S;
import com.fyber.inneractive.sdk.flow.x;
import com.fyber.inneractive.sdk.network.B;
import com.fyber.inneractive.sdk.player.controller.A;
import com.fyber.inneractive.sdk.player.controller.z;
import com.fyber.inneractive.sdk.util.AbstractC3251o;
import com.fyber.inneractive.sdk.util.D;
import com.fyber.inneractive.sdk.util.EnumC3243g;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.h0;

/* JADX INFO: loaded from: classes11.dex */
public final class n implements A {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ o f2315a;

    public n(o oVar) {
        this.f2315a = oVar;
    }

    @Override // com.fyber.inneractive.sdk.player.controller.F
    public final void a(boolean z) {
    }

    @Override // com.fyber.inneractive.sdk.player.controller.F
    public final void a(boolean z, Orientation orientation) {
    }

    @Override // com.fyber.inneractive.sdk.player.controller.F
    public final void c() {
    }

    @Override // com.fyber.inneractive.sdk.player.controller.F
    public final void e() {
    }

    @Override // com.fyber.inneractive.sdk.player.controller.F
    public final void f() {
    }

    @Override // com.fyber.inneractive.sdk.player.controller.F
    public final void h() {
        this.f2315a.a(new WebViewRendererProcessHasGoneError());
    }

    @Override // com.fyber.inneractive.sdk.player.controller.F
    public final void i() {
    }

    @Override // com.fyber.inneractive.sdk.player.controller.F
    public final void j() {
        o oVar = this.f2315a;
        S s = (S) oVar.b;
        if (s.j) {
            return;
        }
        s.j = true;
        oVar.C();
    }

    @Override // com.fyber.inneractive.sdk.player.controller.F
    public final com.fyber.inneractive.sdk.ignite.m o() {
        return com.fyber.inneractive.sdk.ignite.m.NONE;
    }

    @Override // com.fyber.inneractive.sdk.player.controller.F
    public final void onCompleted() {
        com.fyber.inneractive.sdk.player.ui.m mVar;
        o oVar = this.f2315a;
        VideoContentListener videoContentListener = oVar.n;
        if (videoContentListener == null || (mVar = oVar.l) == null || !((com.fyber.inneractive.sdk.player.ui.e) mVar).e) {
            return;
        }
        videoContentListener.onCompleted();
    }

    @Override // com.fyber.inneractive.sdk.player.controller.F
    public final void onPlayerError() {
        com.fyber.inneractive.sdk.player.ui.m mVar;
        o oVar = this.f2315a;
        VideoContentListener videoContentListener = oVar.n;
        if (videoContentListener == null || (mVar = oVar.l) == null || !((com.fyber.inneractive.sdk.player.ui.e) mVar).e) {
            return;
        }
        videoContentListener.onPlayerError();
    }

    @Override // com.fyber.inneractive.sdk.player.controller.F
    public final void onProgress(int i, int i2) {
        com.fyber.inneractive.sdk.player.ui.m mVar;
        o oVar = this.f2315a;
        VideoContentListener videoContentListener = oVar.n;
        if (videoContentListener == null || (mVar = oVar.l) == null || !((com.fyber.inneractive.sdk.player.ui.e) mVar).e) {
            return;
        }
        videoContentListener.onProgress(i, i2);
    }

    @Override // com.fyber.inneractive.sdk.player.controller.F
    public final void a(String str, String str2) {
        o oVar = this.f2315a;
        oVar.getClass();
        IAlog.a("%s ad view video ad renderer callback: onSuspiciousNoUserWebActionDetected", IAlog.a(oVar));
        ViewGroup viewGroup = this.f2315a.p;
        if (viewGroup == null || viewGroup.getContext() == null) {
            return;
        }
        o oVar2 = this.f2315a;
        if (!oVar2.u) {
            B.a(oVar2.p.getContext(), str, str2, this.f2315a.b);
            o oVar3 = this.f2315a;
            oVar3.u = true;
            oVar3.getClass();
            IAlog.a("%s reporting auto redirect", IAlog.a(oVar3));
            return;
        }
        oVar2.getClass();
        IAlog.a("%s redirect already reported for this ad", IAlog.a(oVar2));
    }

    @Override // com.fyber.inneractive.sdk.player.controller.F
    public final void a(View view, String str) {
        if (view != null) {
            Context contextC = this.f2315a.c(view);
            InneractiveRichMediaVideoPlayerActivityCore.startRichMediaIntent(contextC, str);
            this.f2315a.a(contextC, Float.NaN, Float.NaN);
        }
    }

    @Override // com.fyber.inneractive.sdk.player.controller.F
    public final D a(h0 h0Var, EnumC3243g enumC3243g) {
        Context context;
        com.fyber.inneractive.sdk.response.e eVar;
        com.fyber.inneractive.sdk.model.vast.b bVar;
        o oVar = this.f2315a;
        if (oVar.l.getContext() == null) {
            context = AbstractC3251o.f2370a;
        } else {
            context = this.f2315a.l.getContext();
        }
        x xVar = this.f2315a.b;
        return oVar.a(context, (xVar == null || (eVar = ((S) xVar).b) == null || (bVar = ((com.fyber.inneractive.sdk.response.g) eVar).N) == null) ? null : bVar.b, h0Var, enumC3243g);
    }

    @Override // com.fyber.inneractive.sdk.player.controller.F
    public final D a(String str, h0 h0Var, boolean z) {
        v vVar;
        x xVar;
        com.fyber.inneractive.sdk.model.vast.b bVar;
        if (TextUtils.isEmpty(str) && (xVar = this.f2315a.b) != null) {
            com.fyber.inneractive.sdk.response.e eVar = ((S) xVar).b;
            str = (eVar == null || (bVar = ((com.fyber.inneractive.sdk.response.g) eVar).N) == null) ? null : bVar.b;
        }
        o oVar = this.f2315a;
        z zVar = oVar.m;
        if (zVar == null && (vVar = oVar.q) != null) {
            zVar = vVar.f2319a;
        }
        com.fyber.inneractive.sdk.flow.endcard.i iVarI = zVar != null ? zVar.i() : null;
        com.fyber.inneractive.sdk.flow.endcard.b bVarA = iVarI != null ? iVarI.a() : null;
        if (bVarA instanceof com.fyber.inneractive.sdk.flow.endcard.c) {
            String str2 = ((com.fyber.inneractive.sdk.flow.endcard.c) bVarA).e.g;
            if (!TextUtils.isEmpty(str2)) {
                str = str2;
            }
        }
        o oVar2 = this.f2315a;
        return oVar2.a(oVar2.c(oVar2.p), str, h0Var, z ? EnumC3243g.DEFAULT_ENDCARD : EnumC3243g.VAST_ENDCARD);
    }

    @Override // com.fyber.inneractive.sdk.player.controller.F
    public final void a(View view) {
        o oVar = this.f2315a;
        if (oVar.c != null) {
            oVar.a(oVar.c(view), Float.NaN, Float.NaN);
        }
    }
}
