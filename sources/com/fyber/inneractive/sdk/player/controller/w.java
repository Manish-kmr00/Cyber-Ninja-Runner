package com.fyber.inneractive.sdk.player.controller;

import android.view.View;
import com.fyber.inneractive.sdk.config.Y;
import com.fyber.inneractive.sdk.config.enums.Orientation;
import com.fyber.inneractive.sdk.player.enums.VideoClickOrigin;
import com.fyber.inneractive.sdk.ui.IAmraidWebViewController;
import com.fyber.inneractive.sdk.util.G;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.h0;
import com.fyber.inneractive.sdk.web.H;
import java.util.List;

/* JADX INFO: loaded from: classes13.dex */
public final class w extends H {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ z f1968a;

    public w(z zVar) {
        this.f1968a = zVar;
    }

    @Override // com.fyber.inneractive.sdk.web.k0
    public final void a(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        z zVar = this.f1968a;
        zVar.getClass();
        IAlog.a(sb.append(IAlog.a(zVar)).append("web view callback: onSuspiciousNoUserWebActionDetected").toString(), new Object[0]);
        F f = this.f1968a.g;
        if (f != null) {
            f.a(str, str2);
        }
    }

    @Override // com.fyber.inneractive.sdk.web.B
    public final void b() {
        z zVar = this.f1968a;
        if (zVar.g != null) {
            com.fyber.inneractive.sdk.player.ui.t tVar = zVar.d;
            this.f1968a.g.a(tVar != null ? tVar.getEndCardView() : null);
        }
    }

    @Override // com.fyber.inneractive.sdk.web.B
    public final void c() {
        z zVar = this.f1968a;
        if (zVar.g != null) {
            com.fyber.inneractive.sdk.player.ui.t tVar = zVar.d;
            this.f1968a.g.a(tVar != null ? tVar.getEndCardView() : null);
        }
    }

    @Override // com.fyber.inneractive.sdk.web.B
    public final void d() {
        z zVar = this.f1968a;
        zVar.getClass();
        IAlog.a("%sweb view callback: onClickedAndOpen", IAlog.a(zVar));
        this.f1968a.a(Y.COMPANION.a());
        z zVar2 = this.f1968a;
        if (zVar2.g != null) {
            com.fyber.inneractive.sdk.player.f fVar = zVar2.f1971a;
            if (fVar != null) {
                com.fyber.inneractive.sdk.flow.endcard.b bVarA = ((com.fyber.inneractive.sdk.player.n) fVar).t.a();
                if (bVarA instanceof com.fyber.inneractive.sdk.flow.endcard.c) {
                    fVar.a((com.fyber.inneractive.sdk.flow.endcard.c) bVarA, VideoClickOrigin.COMPANION, com.fyber.inneractive.sdk.model.vast.x.EVENT_CLICK);
                }
            }
            IAlog.d("AD_CLICKED", new Object[0]);
            this.f1968a.g.e();
        }
    }

    @Override // com.fyber.inneractive.sdk.web.B
    public final void onClose() {
        F f = this.f1968a.g;
        if (f != null) {
            f.i();
        }
    }

    @Override // com.fyber.inneractive.sdk.web.B
    public final void b(boolean z) {
        z zVar = this.f1968a;
        zVar.getClass();
        IAlog.a("%sonCustomCloseButtonAvailableEnabled : %s", IAlog.a(zVar), Boolean.valueOf(z));
        F f = this.f1968a.g;
        if (f == null || !z) {
            return;
        }
        f.f();
    }

    @Override // com.fyber.inneractive.sdk.web.k0
    public final com.fyber.inneractive.sdk.util.D a(String str, h0 h0Var) {
        Object obj;
        com.fyber.inneractive.sdk.flow.endcard.c cVar;
        com.fyber.inneractive.sdk.flow.endcard.c cVar2;
        com.fyber.inneractive.sdk.flow.endcard.c cVar3;
        z zVar = this.f1968a;
        zVar.getClass();
        IAlog.a("%sweb view callback: onClicked", IAlog.a(zVar));
        this.f1968a.a(Y.COMPANION.a());
        z zVar2 = this.f1968a;
        if (zVar2.g != null) {
            com.fyber.inneractive.sdk.player.f fVar = zVar2.f1971a;
            if (fVar != null) {
                com.fyber.inneractive.sdk.player.n nVar = (com.fyber.inneractive.sdk.player.n) fVar;
                com.fyber.inneractive.sdk.flow.endcard.i iVar = nVar.t;
                com.fyber.inneractive.sdk.flow.endcard.b bVarA = iVar.a();
                if (bVarA != null && bVarA.i() && (cVar = (com.fyber.inneractive.sdk.flow.endcard.c) iVar.b.a(com.fyber.inneractive.sdk.model.vast.i.Other)) == null && (cVar2 = (com.fyber.inneractive.sdk.flow.endcard.c) iVar.b.a(com.fyber.inneractive.sdk.model.vast.i.Html)) == null && (cVar3 = (com.fyber.inneractive.sdk.flow.endcard.c) iVar.b.a(com.fyber.inneractive.sdk.model.vast.i.Iframe)) == null) {
                    obj = bVarA;
                    obj = bVarA;
                    obj = cVar;
                    obj = cVar2;
                    obj = cVar3;
                    obj = (com.fyber.inneractive.sdk.flow.endcard.c) iVar.b.a(com.fyber.inneractive.sdk.model.vast.i.Static);
                }
                obj = bVarA;
                obj = bVarA;
                obj = cVar;
                obj = cVar2;
                obj = cVar3;
                obj = bVarA;
                obj = bVarA;
                obj = cVar;
                obj = cVar2;
                obj = bVarA;
                obj = bVarA;
                obj = cVar;
                obj = bVarA;
                obj = bVarA;
                obj = bVarA;
                com.fyber.inneractive.sdk.flow.endcard.b bVarA2 = nVar.t.a();
                com.fyber.inneractive.sdk.model.vast.x xVar = com.fyber.inneractive.sdk.model.vast.x.EVENT_CLICK;
                com.fyber.inneractive.sdk.response.i iVar2 = obj instanceof com.fyber.inneractive.sdk.response.i ? (com.fyber.inneractive.sdk.response.i) obj : null;
                List listA = iVar2 != null ? iVar2.a(xVar) : null;
                if (listA != null && !listA.isEmpty()) {
                    fVar.a((com.fyber.inneractive.sdk.response.i) obj, VideoClickOrigin.COMPANION, xVar);
                } else {
                    this.f1968a.getClass();
                    if ((bVarA2 instanceof com.fyber.inneractive.sdk.flow.endcard.n) && ((com.fyber.inneractive.sdk.flow.endcard.n) bVarA2).f.b > 0) {
                        nVar.a(nVar.p, VideoClickOrigin.COMPANION, xVar);
                    }
                }
            }
            IAlog.d("AD_CLICKED", new Object[0]);
            com.fyber.inneractive.sdk.player.ui.t tVar = this.f1968a.d;
            if (tVar != null) {
                tVar.e();
            }
            return this.f1968a.g.a(str, h0Var, false);
        }
        return new com.fyber.inneractive.sdk.util.D(G.FAILED, new Exception("mListener is null, internal SDK fatal error"));
    }

    @Override // com.fyber.inneractive.sdk.web.k0
    public final void a() {
        F f = this.f1968a.g;
        if (f != null) {
            f.h();
        }
    }

    @Override // com.fyber.inneractive.sdk.web.B
    public final boolean a(String str) {
        View endCardView = this.f1968a.d.getEndCardView();
        F f = this.f1968a.g;
        if (f == null) {
            return false;
        }
        f.a(endCardView, str);
        return true;
    }

    @Override // com.fyber.inneractive.sdk.web.B
    public final void a(IAmraidWebViewController.MraidVideoFailedToDisplayError mraidVideoFailedToDisplayError) {
        F f = this.f1968a.g;
        if (f != null) {
            f.onPlayerError();
        }
    }

    @Override // com.fyber.inneractive.sdk.web.B
    public final void a(boolean z, Orientation orientation) {
        z zVar = this.f1968a;
        zVar.getClass();
        IAlog.a("%sonOrientationProperties: allowOrientationChange: %s, forceOrientationType: %s", IAlog.a(zVar), Boolean.valueOf(z), orientation.toString());
        F f = this.f1968a.g;
        if (f != null) {
            f.a(z, orientation);
        }
    }
}
