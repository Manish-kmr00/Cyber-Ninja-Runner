package com.fyber.inneractive.sdk.player.controller;

import android.app.Application;
import android.content.Context;
import android.media.AudioManager;
import android.text.TextUtils;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.fyber.inneractive.sdk.R;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.config.T;
import com.fyber.inneractive.sdk.config.U;
import com.fyber.inneractive.sdk.config.V;
import com.fyber.inneractive.sdk.config.Y;
import com.fyber.inneractive.sdk.config.Z;
import com.fyber.inneractive.sdk.config.enums.Skip;
import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;
import com.fyber.inneractive.sdk.external.InneractiveAdManager;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.model.vast.C3117a;
import com.fyber.inneractive.sdk.network.C3146w;
import com.fyber.inneractive.sdk.network.EnumC3144u;
import com.fyber.inneractive.sdk.player.enums.VideoClickOrigin;
import com.fyber.inneractive.sdk.util.AbstractC3251o;
import com.fyber.inneractive.sdk.util.EnumC3243g;
import com.fyber.inneractive.sdk.util.G;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.h0;
import com.fyber.inneractive.sdk.web.j0;
import com.iab.omid.library.fyber.adsession.AdSession;
import com.iab.omid.library.fyber.adsession.FriendlyObstructionPurpose;
import com.iab.omid.library.fyber.adsession.media.InteractionType;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public abstract class z implements InterfaceC3151b, p, o, com.fyber.inneractive.sdk.player.ui.n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.fyber.inneractive.sdk.player.f f1971a;
    public final U b;
    public final com.fyber.inneractive.sdk.config.global.r c;
    public final com.fyber.inneractive.sdk.player.ui.t d;
    public x e;
    public F g;
    public Runnable j;
    public boolean k;
    public u m;
    public final boolean n;
    public com.fyber.inneractive.sdk.player.ui.g u;
    public final String v;
    public int f = 0;
    public boolean h = false;
    public float i = -0.1f;
    public boolean l = false;
    public boolean o = false;
    public boolean p = false;
    public boolean q = false;
    public boolean r = false;
    public boolean s = false;
    public com.fyber.inneractive.sdk.ignite.m t = com.fyber.inneractive.sdk.ignite.m.NONE;
    public boolean x = false;
    public final Skip w = null;

    public z(com.fyber.inneractive.sdk.player.f fVar, com.fyber.inneractive.sdk.player.ui.i iVar, U u, com.fyber.inneractive.sdk.config.global.r rVar, boolean z, String str) {
        q qVar;
        this.f1971a = fVar;
        this.b = u;
        this.c = rVar;
        this.d = iVar;
        this.n = z;
        this.v = str;
        iVar.setListener(this);
        if (fVar == null || (qVar = fVar.f2210a) == null) {
            return;
        }
        if (!qVar.b.contains(this)) {
            qVar.b.add(this);
        }
        q qVar2 = fVar.f2210a;
        if (qVar2.c.contains(this)) {
            return;
        }
        qVar2.c.add(this);
    }

    public static int j() {
        int i;
        try {
            i = Integer.parseInt(IAConfigManager.O.u.b.a("max_rv_tsec", Integer.toString(30)));
        } catch (Throwable unused) {
            i = 30;
        }
        if (i < 1) {
            return 30;
        }
        return i;
    }

    public void a() {
    }

    @Override // com.fyber.inneractive.sdk.player.controller.p
    public final void a(com.fyber.inneractive.sdk.player.mediaplayer.o oVar) {
    }

    public abstract void b(h0 h0Var);

    @Override // com.fyber.inneractive.sdk.player.controller.InterfaceC3151b
    public boolean b() {
        com.fyber.inneractive.sdk.player.ui.t tVar;
        com.fyber.inneractive.sdk.player.f fVar = this.f1971a;
        if (fVar == null) {
            return false;
        }
        if (!this.h && fVar.f2210a != null && ((tVar = this.d) == null || !tVar.i())) {
            int iC = this.f1971a.f2210a.c();
            com.fyber.inneractive.sdk.player.f fVar2 = this.f1971a;
            if (!com.fyber.inneractive.sdk.player.f.a(iC, com.fyber.inneractive.sdk.player.f.a(fVar2), ((com.fyber.inneractive.sdk.player.n) fVar2).s) || this.h || this.f != 0) {
                return false;
            }
        }
        return true;
    }

    @Override // com.fyber.inneractive.sdk.player.controller.p
    public final void c(boolean z) {
    }

    @Override // com.fyber.inneractive.sdk.player.controller.p
    public final void d() {
        if (this.o && !this.l) {
            this.l = true;
        }
    }

    @Override // com.fyber.inneractive.sdk.player.controller.InterfaceC3151b
    public void destroy() {
        q qVar;
        Application application;
        u uVar = this.m;
        if (uVar != null && (application = AbstractC3251o.f2370a) != null) {
            application.unregisterActivityLifecycleCallbacks(uVar);
        }
        IAlog.a("%sdestroy called", IAlog.a(this));
        com.fyber.inneractive.sdk.player.f fVar = this.f1971a;
        if (fVar != null && (qVar = fVar.f2210a) != null) {
            qVar.b.remove(this);
            this.f1971a.f2210a.c.remove(this);
        }
        f();
        Runnable runnable = this.j;
        if (runnable != null) {
            this.d.removeCallbacks(runnable);
            this.j = null;
        }
        this.g = null;
    }

    public final void e(boolean z) {
        q qVar;
        com.fyber.inneractive.sdk.player.f fVar = this.f1971a;
        if (fVar != null && (qVar = fVar.f2210a) != null) {
            qVar.b(z);
        }
        this.d.setMuteButtonState(true);
    }

    public void f() {
        if (this.u != null) {
            IAlog.a("%sdestroyTextureView", IAlog.a(this));
        }
    }

    public void g(boolean z) {
        q qVar;
        com.fyber.inneractive.sdk.player.f fVar = this.f1971a;
        if (fVar != null) {
            if (!fVar.g) {
                y();
                return;
            }
            if (z && (qVar = fVar.f2210a) != null) {
                qVar.a(0, true);
                return;
            }
            q qVar2 = fVar.f2210a;
            if (qVar2 != null) {
                com.fyber.inneractive.sdk.player.enums.b bVar = qVar2.e;
                if (bVar == com.fyber.inneractive.sdk.player.enums.b.Completed || bVar == com.fyber.inneractive.sdk.player.enums.b.Prepared) {
                    qVar2.a(1, true);
                } else {
                    qVar2.j();
                }
            }
        }
    }

    public abstract int h();

    public final com.fyber.inneractive.sdk.flow.endcard.i i() {
        com.fyber.inneractive.sdk.player.f fVar = this.f1971a;
        if (fVar != null) {
            return ((com.fyber.inneractive.sdk.player.n) fVar).t;
        }
        return null;
    }

    public final float k() {
        try {
            return ((AudioManager) this.d.getContext().getSystemService("audio")).getStreamVolume(3);
        } catch (Throwable unused) {
            return 1.0f;
        }
    }

    public abstract int l();

    public final boolean m() {
        q qVar;
        com.fyber.inneractive.sdk.player.f fVar = this.f1971a;
        if (fVar == null || (qVar = fVar.f2210a) == null) {
            return false;
        }
        return qVar.g() || ((double) k()) == 0.0d;
    }

    public abstract void n();

    public abstract void o();

    public void p() {
        Runnable runnable = this.j;
        if (runnable != null) {
            this.d.removeCallbacks(runnable);
            this.j = null;
        }
        this.d.a(false);
        y();
    }

    public abstract void q();

    public void r() {
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0064  */
    /* JADX WARN: Code duplicated, block: B:25:0x0068  */
    public void s() {
        q qVar;
        this.d.a(false);
        this.d.e(false);
        Runnable runnable = this.j;
        if (runnable != null) {
            this.d.removeCallbacks(runnable);
            this.j = null;
        }
        if (this.f1971a != null && v() && !this.h) {
            int iC = this.f1971a.f2210a.c();
            com.fyber.inneractive.sdk.player.f fVar = this.f1971a;
            if (com.fyber.inneractive.sdk.player.f.a(iC, com.fyber.inneractive.sdk.player.f.a(fVar), ((com.fyber.inneractive.sdk.player.n) fVar).s)) {
                if (this.f <= 0) {
                    this.d.g(true);
                    g();
                } else {
                    com.fyber.inneractive.sdk.player.f fVar2 = this.f1971a;
                    if (fVar2 == null || (qVar = fVar2.f2210a) == null) {
                        if (!this.p) {
                            this.d.g(true);
                            b(this.f);
                            this.p = true;
                        }
                    } else if (this.f >= qVar.c() / 1000) {
                        this.d.g(false);
                    } else if (!this.p) {
                        this.d.g(true);
                        b(this.f);
                        this.p = true;
                    }
                }
            }
        }
        F f = this.g;
        if (f != null && !this.k) {
            this.k = true;
            f.j();
        }
        this.q = false;
    }

    public final void t() {
        com.fyber.inneractive.sdk.player.ui.g gVar;
        com.fyber.inneractive.sdk.player.ui.t tVar = this.d;
        if (tVar != null) {
            tVar.o();
        }
        com.fyber.inneractive.sdk.player.f fVar = this.f1971a;
        if (fVar != null && fVar.f2210a != null && (gVar = this.u) != null) {
            gVar.invalidate();
            this.u.requestLayout();
        }
        com.fyber.inneractive.sdk.player.ui.t tVar2 = this.d;
        if (tVar2 != null) {
            tVar2.invalidate();
            this.d.requestLayout();
        }
    }

    public void u() {
        q qVar;
        com.fyber.inneractive.sdk.player.f fVar = this.f1971a;
        if (fVar == null || (qVar = fVar.f2210a) == null) {
            return;
        }
        if (qVar.e == com.fyber.inneractive.sdk.player.enums.b.Paused) {
            IAlog.a("%spauseVideo called in bad state! %s", IAlog.a(this), qVar.e);
            return;
        }
        IAlog.a("%spauseVideo %s", IAlog.a(this), this.d);
        TextureView textureView = qVar.j;
        if (textureView == null || textureView.getParent() == null || textureView.getParent() != this.d.getTextureHost()) {
            return;
        }
        qVar.i();
    }

    public abstract boolean v();

    public final void w() {
        Boolean boolC;
        com.fyber.inneractive.sdk.config.global.r rVar = this.c;
        com.fyber.inneractive.sdk.config.global.features.w wVar = rVar != null ? (com.fyber.inneractive.sdk.config.global.features.w) rVar.a(com.fyber.inneractive.sdk.config.global.features.w.class) : null;
        boolean zBooleanValue = (wVar == null || (boolC = wVar.c("show_cta")) == null) ? true : boolC.booleanValue();
        F f = this.g;
        if (f != null) {
            this.t = f.o();
        }
        com.fyber.inneractive.sdk.ignite.m mVar = this.t;
        this.d.a(mVar == com.fyber.inneractive.sdk.ignite.m.NONE ? zBooleanValue : true, mVar);
    }

    public final void x() {
        String str;
        com.fyber.inneractive.sdk.flow.storepromo.controller.c cVar;
        boolean z;
        com.fyber.inneractive.sdk.flow.storepromo.ui.c cVar2;
        com.fyber.inneractive.sdk.flow.storepromo.ui.c cVar3;
        View view;
        this.d.g();
        com.fyber.inneractive.sdk.flow.endcard.i iVarI = i();
        com.fyber.inneractive.sdk.flow.endcard.b bVarB = iVarI != null ? iVarI.b() : null;
        if (bVarB == null) {
            com.fyber.inneractive.sdk.flow.endcard.i iVarI2 = i();
            if (iVarI2 != null) {
                com.fyber.inneractive.sdk.response.g gVar = iVarI2.f1793a.d;
                if (!((gVar == null || (str = gVar.E) == null || !TextUtils.equals(str, "1")) ? false : true)) {
                    return;
                }
            }
            F f = this.g;
            if (f != null) {
                f.i();
                return;
            }
            return;
        }
        a(bVarB);
        com.fyber.inneractive.sdk.player.f fVar = this.f1971a;
        if ((fVar != null ? ((com.fyber.inneractive.sdk.player.n) fVar).v : null) != null) {
            com.fyber.inneractive.sdk.flow.storepromo.b bVar = fVar != null ? ((com.fyber.inneractive.sdk.player.n) fVar).v : null;
            com.fyber.inneractive.sdk.player.ui.t tVar = this.d;
            com.fyber.inneractive.sdk.flow.storepromo.controller.b bVar2 = bVar.d;
            if (bVar2 == null || (cVar = bVar2.c) == null || !(z = cVar.e)) {
                bVar.f1808a.a();
                bVar.a();
                bVar.a((bVar.d == null ? com.fyber.inneractive.sdk.flow.storepromo.events.a.CONTROLLER_NOT_INITIALIZED : com.fyber.inneractive.sdk.flow.storepromo.events.a.TEMPLATE_NOT_LOADED).name(), (String) null, (String) null);
                return;
            }
            if (cVar == null || !z || (cVar2 = bVar2.d) == null || bVar2.g) {
                return;
            }
            if (cVar2.b == null || cVar2.f1831a == null) {
                IAlog.f("StorePromoView: show: missing container or content", new Object[0]);
                return;
            }
            cVar2.b();
            tVar.addView(cVar2.b);
            cVar2.f1831a.setAnimation(cVar2.c);
            cVar2.b.setVisibility(0);
            com.fyber.inneractive.sdk.flow.storepromo.b bVar3 = cVar2.f;
            if (bVar3 != null) {
                com.fyber.inneractive.sdk.flow.storepromo.controller.b bVar4 = bVar3.d;
                com.fyber.inneractive.sdk.flow.storepromo.observer.b bVar5 = new com.fyber.inneractive.sdk.flow.storepromo.observer.b((bVar4 == null || (cVar3 = bVar4.d) == null || cVar3.b == null || (view = cVar3.f1831a) == null || view.getParent() == null || cVar3.b.getVisibility() != 0) ? false : true, bVar3.i);
                Iterator it = bVar3.h.iterator();
                while (it.hasNext()) {
                    ((com.fyber.inneractive.sdk.flow.storepromo.observer.a) it.next()).a(bVar5);
                }
                JSONObject jSONObject = new JSONObject();
                Integer numValueOf = Integer.valueOf(bVar3.g);
                try {
                    jSONObject.put("screenshots", numValueOf);
                } catch (Exception unused) {
                    IAlog.f("Got exception adding param to json object: %s, %s", "screenshots", numValueOf);
                }
                EnumC3144u enumC3144u = EnumC3144u.VAST_EVENT_SP_IMPRESSION;
                InneractiveAdRequest inneractiveAdRequest = bVar3.c;
                com.fyber.inneractive.sdk.response.e eVar = bVar3.b;
                String str2 = bVar3.f;
                C3146w c3146w = new C3146w(enumC3144u, inneractiveAdRequest, eVar);
                try {
                    jSONObject.put("templateURL", str2);
                } catch (Exception unused2) {
                    IAlog.f("Got exception adding param to json object: %s, %s", "templateURL", str2);
                }
                c3146w.f.put(jSONObject);
                c3146w.a((String) null);
            }
        }
    }

    public void y() {
        boolean z;
        q qVar;
        q qVar2;
        com.fyber.inneractive.sdk.measurement.g gVar;
        com.fyber.inneractive.sdk.player.f fVar = this.f1971a;
        if (fVar != null && ((((qVar2 = fVar.f2210a) != null && qVar2.e == com.fyber.inneractive.sdk.player.enums.b.Completed) || this.q) && (gVar = fVar.e) != null)) {
            if (gVar.f1861a != null) {
                IAlog.a("%s destroy", "OMVideo");
                try {
                    gVar.f1861a.finish();
                } catch (Throwable th) {
                    gVar.a(th);
                }
            }
            gVar.b = null;
            gVar.f1861a = null;
            gVar.c = null;
        }
        boolean zA = IAConfigManager.O.u.b.a(CampaignEx.JSON_NATIVE_VIDEO_ENDCARD).a();
        com.fyber.inneractive.sdk.player.ui.t tVar = this.d;
        com.fyber.inneractive.sdk.player.f fVar2 = this.f1971a;
        tVar.e((fVar2 == null || (qVar = fVar2.f2210a) == null || qVar.e != com.fyber.inneractive.sdk.player.enums.b.Completed) && !(((z = this.q) && !zA) || this.r || (z && zA)));
    }

    /* JADX WARN: Code duplicated, block: B:34:0x00aa  */
    public final void a(com.fyber.inneractive.sdk.flow.endcard.b bVar) {
        j0 j0Var;
        if (bVar instanceof com.fyber.inneractive.sdk.flow.endcard.c) {
            com.fyber.inneractive.sdk.flow.endcard.c cVar = (com.fyber.inneractive.sdk.flow.endcard.c) bVar;
            com.fyber.inneractive.sdk.player.ui.b bVar2 = new com.fyber.inneractive.sdk.player.ui.b(a(cVar.d()));
            if (bVar2.f2232a) {
                w wVar = new w(this);
                com.fyber.inneractive.sdk.flow.endcard.a aVar = (com.fyber.inneractive.sdk.flow.endcard.a) cVar.f();
                if ((aVar instanceof com.fyber.inneractive.sdk.flow.endcard.s) && (j0Var = ((com.fyber.inneractive.sdk.flow.endcard.s) aVar).d().f1954a) != null) {
                    j0Var.setListener(wVar);
                }
                this.d.e(false);
                this.d.a(cVar, bVar2);
                ViewGroup viewGroup = this.d.l;
                if (viewGroup != null) {
                    viewGroup.setVisibility(4);
                    return;
                }
                return;
            }
            return;
        }
        if (bVar instanceof com.fyber.inneractive.sdk.flow.endcard.n) {
            com.fyber.inneractive.sdk.flow.endcard.n nVar = (com.fyber.inneractive.sdk.flow.endcard.n) bVar;
            com.fyber.inneractive.sdk.player.ui.b bVar3 = new com.fyber.inneractive.sdk.player.ui.b(a(nVar.d()));
            if (bVar3.f2232a) {
                w wVar2 = new w(this);
                j0 j0Var2 = ((com.fyber.inneractive.sdk.flow.endcard.o) nVar.f()).d().f1954a;
                if (j0Var2 != null) {
                    j0Var2.setListener(wVar2);
                }
                this.d.a(nVar, bVar3);
                return;
            }
            return;
        }
        if (bVar instanceof com.fyber.inneractive.sdk.flow.endcard.d) {
            com.fyber.inneractive.sdk.flow.endcard.d dVar = (com.fyber.inneractive.sdk.flow.endcard.d) bVar;
            com.fyber.inneractive.sdk.player.ui.c cVarD = dVar.d();
            String str = this.v;
            if (str == null) {
                com.fyber.inneractive.sdk.config.global.r rVar = this.c;
                if (rVar != null) {
                    com.fyber.inneractive.sdk.config.global.features.d dVar2 = (com.fyber.inneractive.sdk.config.global.features.d) rVar.a(com.fyber.inneractive.sdk.config.global.features.d.class);
                    dVar2.d(IAConfigManager.O.o);
                    C3117a c3117a = dVar2.e;
                    if (c3117a == null || !c3117a.d) {
                        str = null;
                    } else {
                        str = c3117a.f1873a;
                    }
                } else {
                    str = null;
                }
            }
            cVarD.e = str;
            com.fyber.inneractive.sdk.player.ui.b bVar4 = new com.fyber.inneractive.sdk.player.ui.b(a(cVarD));
            if (bVar4.f2232a) {
                this.d.e(false);
                this.d.a(dVar, bVar4);
            }
        }
    }

    @Override // com.fyber.inneractive.sdk.player.ui.n
    public void c() {
        IAlog.a("%sonVideoViewDetachedFromWindow", IAlog.a(this));
        f();
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0073  */
    public final void f(boolean z) {
        com.fyber.inneractive.sdk.player.f fVar;
        q qVar;
        com.fyber.inneractive.sdk.config.global.features.c cVar;
        V v;
        U u = this.b;
        boolean z2 = (u == null || (v = ((T) u).f) == null || v.j != UnitDisplayType.REWARDED) ? false : true;
        if (InneractiveAdManager.isCurrentUserAChild() && z2 && this.d != null && (fVar = this.f1971a) != null && (qVar = fVar.f2210a) != null) {
            int iB = qVar.b() / 1000;
            int iJ = j();
            if ((this.f1971a.f2210a.c() / 1000) - iB <= 0 || iB < iJ) {
                Context context = this.d.getContext();
                com.fyber.inneractive.sdk.config.global.r rVar = this.c;
                if (rVar != null) {
                    com.fyber.inneractive.sdk.config.global.features.c cVar2 = (com.fyber.inneractive.sdk.config.global.features.c) rVar.a(com.fyber.inneractive.sdk.config.global.features.c.class);
                    cVar2.getClass();
                    if (new ArrayList(cVar2.c.values()).size() > 0) {
                        cVar = (com.fyber.inneractive.sdk.config.global.features.c) this.c.a(com.fyber.inneractive.sdk.config.global.features.c.class);
                    } else {
                        cVar = null;
                    }
                } else {
                    cVar = null;
                }
                new E(context, cVar, new v(this, z)).b.show();
                return;
            }
        }
        d(z);
    }

    /* JADX WARN: Code duplicated, block: B:64:0x00da  */
    public final void d(boolean z) {
        com.fyber.inneractive.sdk.player.f fVar;
        q qVar;
        q qVar2;
        V v;
        F f;
        com.fyber.inneractive.sdk.player.f fVar2;
        q qVar3;
        q qVar4;
        com.fyber.inneractive.sdk.measurement.g gVar;
        U u;
        V v2;
        this.q = true;
        Z z2 = IAConfigManager.O.x;
        if (z && z2 != null && (u = this.b) != null && (v2 = ((T) u).f) != null) {
            z2.a(v2.j, "LAST_VAST_SKIPED", "1");
        }
        com.fyber.inneractive.sdk.player.f fVar3 = this.f1971a;
        if (fVar3 != null && (qVar4 = fVar3.f2210a) != null) {
            qVar4.k();
            this.f1971a.f2210a.i();
            if (z && (gVar = this.f1971a.e) != null && gVar.c != null) {
                IAlog.a("%s skipped", "OMVideo");
                try {
                    gVar.c.skipped();
                } catch (Throwable th) {
                    gVar.a(th);
                }
            }
        }
        if (!this.d.h()) {
            this.d.a(false);
            Runnable runnable = this.j;
            if (runnable != null) {
                this.d.removeCallbacks(runnable);
                this.j = null;
            }
            this.k = false;
            this.h = true;
            U u2 = this.b;
            if (u2 != null && (v = ((T) u2).f) != null && v.j == UnitDisplayType.REWARDED && (f = this.g) != null) {
                if (this.q && (fVar2 = this.f1971a) != null && (qVar3 = fVar2.f2210a) != null) {
                    int iB = qVar3.b();
                    int iC = qVar3.c() - iB;
                    int iJ = j() * 1000;
                    if (iC > 0 && iB < iJ) {
                        this.x = true;
                    } else {
                        this.g.onCompleted();
                    }
                } else {
                    f.onCompleted();
                }
            }
        }
        if (z) {
            boolean zA = IAConfigManager.O.u.b.a(CampaignEx.JSON_NATIVE_VIDEO_ENDCARD).a();
            com.fyber.inneractive.sdk.player.f fVar4 = this.f1971a;
            if ((fVar4 != null && (qVar2 = fVar4.f2210a) != null && qVar2.e == com.fyber.inneractive.sdk.player.enums.b.Completed) || ((this.q && !zA) || this.r)) {
                x();
            }
        } else {
            x();
        }
        F f2 = this.g;
        if (f2 != null && (this.f <= 0 || this.h || ((fVar = this.f1971a) != null && (qVar = fVar.f2210a) != null && qVar.e == com.fyber.inneractive.sdk.player.enums.b.Completed))) {
            f2.a(z);
        }
        f();
    }

    public void e() {
        q qVar;
        q qVar2;
        com.fyber.inneractive.sdk.measurement.g gVar;
        if (this.u == null) {
            com.fyber.inneractive.sdk.player.ui.g gVar2 = new com.fyber.inneractive.sdk.player.ui.g(this.d);
            this.u = gVar2;
            gVar2.setId(R.id.ia_inn_texture_view);
            com.fyber.inneractive.sdk.player.f fVar = this.f1971a;
            if (fVar != null && (gVar = fVar.e) != null) {
                com.fyber.inneractive.sdk.player.ui.t tVar = this.d;
                View[] trackingFriendlyView = tVar.getTrackingFriendlyView();
                AdSession adSession = gVar.f1861a;
                if (adSession != null) {
                    try {
                        adSession.registerAdView(tVar);
                    } catch (Throwable th) {
                        gVar.a(th);
                    }
                }
                if (gVar.f1861a != null && trackingFriendlyView != null) {
                    for (View view : trackingFriendlyView) {
                        if (view != null) {
                            try {
                                gVar.f1861a.addFriendlyObstruction(view, FriendlyObstructionPurpose.VIDEO_CONTROLS, null);
                            } catch (Throwable th2) {
                                gVar.a(th2);
                            }
                        }
                    }
                }
                View[] trackingFriendlyViewObstructionPurposeOther = this.d.getTrackingFriendlyViewObstructionPurposeOther();
                if (gVar.f1861a != null) {
                    for (View view2 : trackingFriendlyViewObstructionPurposeOther) {
                        if (view2 != null) {
                            try {
                                gVar.f1861a.addFriendlyObstruction(view2, FriendlyObstructionPurpose.OTHER, null);
                            } catch (Throwable th3) {
                                gVar.a(th3);
                            }
                        }
                    }
                }
            }
        }
        IAlog.a("%sconnectToTextureView called %s", IAlog.a(this), this.d.getTextureHost());
        if (this.u != null && this.d.getTextureHost().equals(this.u.getParent())) {
            IAlog.a("%sconnectToTextureView called but already connected", IAlog.a(this));
            return;
        }
        com.fyber.inneractive.sdk.player.f fVar2 = this.f1971a;
        if (fVar2 != null && (qVar2 = fVar2.f2210a) != null) {
            qVar2.a(this.u);
        }
        com.fyber.inneractive.sdk.player.ui.g gVar3 = this.u;
        if (gVar3 != null && gVar3.getParent() == null) {
            IAlog.a("%supdateView adding texture to parent", IAlog.a(this));
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.gravity = 17;
            this.d.getTextureHost().addView(this.u, layoutParams);
        }
        this.l = false;
        x xVar = new x(this);
        this.e = xVar;
        com.fyber.inneractive.sdk.player.f fVar3 = this.f1971a;
        if (fVar3 == null || (qVar = fVar3.f2210a) == null) {
            return;
        }
        qVar.d = xVar;
    }

    @Override // com.fyber.inneractive.sdk.player.controller.InterfaceC3151b
    public void b(boolean z) {
        IAlog.a("%sinitUI", IAlog.a(this));
        com.fyber.inneractive.sdk.player.f fVar = this.f1971a;
        if (fVar == null || fVar.f2210a == null) {
            return;
        }
        this.d.setUnitConfig(this.b);
        this.d.a(this.n, this.f1971a.f2210a.f(), this.f1971a.f2210a.e());
        if (v()) {
            this.f = l();
        } else {
            this.d.g(false);
        }
        if (!z) {
            a(this.f1971a.f2210a.b());
            a(this.f1971a.f2210a.e, false);
        }
        this.d.setMuteButtonState(m());
    }

    public final void g() {
        if (v()) {
            com.fyber.inneractive.sdk.config.global.r rVar = this.c;
            String str = null;
            com.fyber.inneractive.sdk.config.global.features.d dVar = rVar != null ? (com.fyber.inneractive.sdk.config.global.features.d) rVar.a(com.fyber.inneractive.sdk.config.global.features.d.class) : null;
            if (dVar != null) {
                dVar.d(IAConfigManager.O.o);
                C3117a c3117a = dVar.e;
                if (c3117a != null && c3117a.d) {
                    str = c3117a.b;
                }
            }
            if (TextUtils.isEmpty(this.v) && str != null) {
                this.d.setSkipText(str);
            } else {
                com.fyber.inneractive.sdk.player.ui.t tVar = this.d;
                tVar.setSkipText(tVar.getContext().getString(R.string.ia_video_skip_text));
            }
            this.d.f();
            this.f = 0;
            F f = this.g;
            if (f != null) {
                f.c();
            }
        }
    }

    public final void b(int i) {
        if (this.d != null) {
            com.fyber.inneractive.sdk.config.global.r rVar = this.c;
            String str = null;
            com.fyber.inneractive.sdk.config.global.features.d dVar = rVar != null ? (com.fyber.inneractive.sdk.config.global.features.d) rVar.a(com.fyber.inneractive.sdk.config.global.features.d.class) : null;
            if (dVar != null) {
                dVar.d(IAConfigManager.O.o);
                C3117a c3117a = dVar.e;
                if (c3117a != null && c3117a.d) {
                    str = c3117a.c;
                }
            }
            if (TextUtils.isEmpty(this.v) && str != null) {
                this.d.setSkipText(str.replaceFirst("\\[TIME\\]", Integer.toString(i)));
            } else {
                this.d.setSkipText(String.valueOf(i));
            }
        }
    }

    public final com.fyber.inneractive.sdk.player.ui.c a(com.fyber.inneractive.sdk.player.ui.c cVar) {
        String string;
        cVar.l = this.f1971a != null && com.fyber.inneractive.sdk.player.f.a(this.c, this.t);
        com.fyber.inneractive.sdk.config.global.r rVar = this.c;
        com.fyber.inneractive.sdk.config.global.features.o oVar = rVar != null ? (com.fyber.inneractive.sdk.config.global.features.o) rVar.a(com.fyber.inneractive.sdk.config.global.features.o.class) : null;
        if (oVar != null) {
            string = oVar.a("app_info_button_text", "App Info");
            if (string != null && string.length() > 30) {
                string = string.substring(0, 30);
            }
        } else {
            string = this.d.getContext().getString(R.string.ia_video_app_info_text);
        }
        cVar.m = string;
        cVar.k = this.t;
        return cVar;
    }

    public final void b(com.fyber.inneractive.sdk.flow.storepromo.observer.a aVar) {
        com.fyber.inneractive.sdk.player.f fVar = this.f1971a;
        if (fVar != null) {
            com.fyber.inneractive.sdk.player.n nVar = (com.fyber.inneractive.sdk.player.n) fVar;
            if (nVar.v != null) {
                com.fyber.inneractive.sdk.flow.storepromo.b bVar = nVar.v;
                bVar.getClass();
                synchronized (com.fyber.inneractive.sdk.flow.storepromo.b.k) {
                    bVar.h.remove(aVar);
                }
                return;
            }
        }
        IAlog.f("Unable to remove store promo observer, promo manager is unavailable", new Object[0]);
    }

    @Override // com.fyber.inneractive.sdk.player.controller.p
    public final void a(com.fyber.inneractive.sdk.player.enums.b bVar) {
        IAlog.a("%sonPlayerStateChanged with %s", IAlog.a(this), bVar);
        a(bVar, true);
    }

    public final void a(com.fyber.inneractive.sdk.player.enums.b bVar, boolean z) {
        F f;
        String str;
        com.fyber.inneractive.sdk.player.ui.t tVar;
        switch (y.f1970a[bVar.ordinal()]) {
            case 1:
                if (this.o) {
                    y();
                    r();
                }
                break;
            case 2:
                if (this.o) {
                    this.d.a(true);
                    this.d.e(false);
                    Runnable runnable = this.j;
                    if (runnable == null) {
                        if (runnable == null) {
                            this.j = new t(this);
                        }
                        int iH = h();
                        IAlog.a("%s Starting buffering timeout with %d", IAlog.a(this), Integer.valueOf(iH));
                        this.d.postDelayed(this.j, iH);
                    }
                }
                break;
            case 3:
                if (this.o) {
                    s();
                }
                break;
            case 4:
                p();
                break;
            case 5:
                if (!this.o) {
                    com.fyber.inneractive.sdk.flow.endcard.i iVarI = i();
                    if (iVarI != null) {
                        com.fyber.inneractive.sdk.response.g gVar = iVarI.f1793a.d;
                        if (!((gVar == null || (str = gVar.E) == null || !TextUtils.equals(str, "1")) ? false : true)) {
                        }
                    }
                    if (this.s) {
                    }
                }
                this.s = true;
                if (!this.d.h()) {
                    this.d.a(false);
                    Runnable runnable2 = this.j;
                    if (runnable2 != null) {
                        this.d.removeCallbacks(runnable2);
                        this.j = null;
                    }
                    y();
                    x();
                    this.k = false;
                    this.h = true;
                }
                if (z && (f = this.g) != null) {
                    f.onCompleted();
                    break;
                }
                break;
            case 6:
                if (this.o || ((tVar = this.d) != null && tVar.isShown())) {
                    f(false);
                }
                break;
        }
    }

    /* JADX WARN: Code duplicated, block: B:53:0x00cb  */
    @Override // com.fyber.inneractive.sdk.player.controller.o
    public final void a(int i) {
        U u;
        V v;
        q qVar;
        q qVar2;
        com.fyber.inneractive.sdk.player.f fVar = this.f1971a;
        if (fVar == null || fVar.f2210a == null) {
            return;
        }
        float fK = k();
        com.fyber.inneractive.sdk.player.f fVar2 = this.f1971a;
        if (fVar2 != null && (qVar = fVar2.f2210a) != null && qVar.h()) {
            float f = this.i;
            if (fK != f) {
                if (fK > 0.0f && f >= 0.0f && m()) {
                    com.fyber.inneractive.sdk.player.f fVar3 = this.f1971a;
                    if (fVar3 != null && (qVar2 = fVar3.f2210a) != null) {
                        qVar2.d(true);
                    }
                    this.d.setMuteButtonState(false);
                } else if (fK == 0.0d) {
                    e(true);
                }
            }
            this.d.setMuteButtonState(m());
        }
        this.i = fK;
        int iC = this.f1971a.f2210a.c();
        int iB = this.f1971a.f2210a.b();
        int i2 = iB / 1000;
        int i3 = iC / 1000;
        int i4 = i3 - i2;
        if (i4 < 0 || (!this.f1971a.f2210a.h() && iB == iC)) {
            i4 = 0;
        }
        if (this.d.l()) {
            return;
        }
        this.d.setRemainingTime(Integer.toString(i4));
        if (this.f < i3) {
            if (v()) {
                int iC2 = this.f1971a.f2210a.c();
                com.fyber.inneractive.sdk.player.f fVar4 = this.f1971a;
                if (com.fyber.inneractive.sdk.player.f.a(iC2, com.fyber.inneractive.sdk.player.f.a(fVar4), ((com.fyber.inneractive.sdk.player.n) fVar4).s) && !this.h) {
                    int i5 = this.f;
                    if (i2 < i5) {
                        b(i5 - i2);
                    } else {
                        this.f = 0;
                        g();
                    }
                    this.d.g(true);
                } else {
                    this.d.g(false);
                }
            } else {
                this.d.g(false);
            }
        } else {
            this.d.g(false);
            b(i4);
        }
        if (this.f1971a.f2210a.e != com.fyber.inneractive.sdk.player.enums.b.Paused) {
            this.d.a(iC, iB);
            int iJ = j();
            if (i3 > iJ && i2 > iJ && (u = this.b) != null && (v = ((T) u).f) != null && v.j == UnitDisplayType.REWARDED) {
                g();
                this.d.g(true);
            }
        }
        F f2 = this.g;
        if (f2 != null) {
            f2.onProgress(iC, iB);
        }
    }

    public void a(boolean z) {
        com.fyber.inneractive.sdk.player.f fVar;
        q qVar;
        x xVar;
        com.fyber.inneractive.sdk.player.ui.t tVar;
        Application application;
        if (this.o == z || (fVar = this.f1971a) == null || fVar.f2210a == null) {
            return;
        }
        IAlog.a("%sonVisibilityChanged: %s my video view is%s", IAlog.a(this), Boolean.valueOf(z), this.d);
        if (z) {
            this.o = true;
            com.fyber.inneractive.sdk.player.enums.b bVar = this.f1971a.f2210a.e;
            if (bVar != com.fyber.inneractive.sdk.player.enums.b.Completed && !this.d.h()) {
                if (bVar != com.fyber.inneractive.sdk.player.enums.b.Error) {
                    if (bVar == com.fyber.inneractive.sdk.player.enums.b.Idle) {
                        this.f1971a.getClass();
                    } else {
                        if (bVar == com.fyber.inneractive.sdk.player.enums.b.Start_in_progress || bVar == com.fyber.inneractive.sdk.player.enums.b.Playing) {
                            s();
                        }
                        com.fyber.inneractive.sdk.player.f fVar2 = this.f1971a;
                        if (!fVar2.j) {
                            com.fyber.inneractive.sdk.player.n nVar = (com.fyber.inneractive.sdk.player.n) fVar2;
                            nVar.a(nVar.p, VideoClickOrigin.InvalidOrigin, com.fyber.inneractive.sdk.model.vast.x.EVENT_CREATIVE_VIEW);
                            fVar2.j = true;
                        }
                        e();
                        if (this.m != null || (application = AbstractC3251o.f2370a) == null) {
                            return;
                        }
                        u uVar = new u(this);
                        this.m = uVar;
                        application.registerActivityLifecycleCallbacks(uVar);
                        return;
                    }
                }
                f(false);
                return;
            }
            if (!this.s) {
                this.s = true;
                if (!this.x) {
                    if (!this.d.h()) {
                        this.d.a(false);
                        Runnable runnable = this.j;
                        if (runnable != null) {
                            this.d.removeCallbacks(runnable);
                            this.j = null;
                        }
                        y();
                        x();
                        this.k = false;
                        this.h = true;
                    }
                    F f = this.g;
                    if (f != null) {
                        f.onCompleted();
                    }
                }
            }
            com.fyber.inneractive.sdk.player.ui.t tVar2 = this.d;
            if (tVar2 != null) {
                tVar2.k();
                return;
            }
            return;
        }
        this.o = false;
        com.fyber.inneractive.sdk.player.f fVar3 = this.f1971a;
        if (fVar3 != null && (qVar = fVar3.f2210a) != null && (xVar = qVar.d) != null && xVar.equals(this.e)) {
            IAlog.a("%sonVisibilityChanged pausing video", IAlog.a(this));
            u();
            if (this.f1971a.f2210a.e == com.fyber.inneractive.sdk.player.enums.b.Completed || ((tVar = this.d) != null && tVar.h())) {
                this.d.j();
            }
        }
        com.fyber.inneractive.sdk.player.ui.t tVar3 = this.d;
        if (tVar3 == null || !tVar3.h) {
            f();
        }
    }

    public final void a(String str) {
        Z z = IAConfigManager.O.x;
        U u = this.b;
        if (u != null) {
            T t = (T) u;
            if (t.f != null) {
                z.a(t.f.j, "LAST_VAST_CLICKED_TYPE", str);
            }
        }
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$ArrayArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void a(int i, h0 h0Var) {
        q qVar;
        IAlog.a("onClicked called with %d", Integer.valueOf(i));
        switch (i) {
            case 1:
                if (m()) {
                    com.fyber.inneractive.sdk.player.f fVar = this.f1971a;
                    if (fVar != null && (qVar = fVar.f2210a) != null) {
                        qVar.d(true);
                    }
                    this.d.setMuteButtonState(false);
                    com.fyber.inneractive.sdk.player.f fVar2 = this.f1971a;
                    if (fVar2 != null) {
                        com.fyber.inneractive.sdk.player.n nVar = (com.fyber.inneractive.sdk.player.n) fVar2;
                        nVar.a(nVar.p, VideoClickOrigin.MUTE, com.fyber.inneractive.sdk.model.vast.x.EVENT_UNMUTE);
                    }
                } else {
                    e(true);
                    com.fyber.inneractive.sdk.player.f fVar3 = this.f1971a;
                    if (fVar3 != null) {
                        com.fyber.inneractive.sdk.player.n nVar2 = (com.fyber.inneractive.sdk.player.n) fVar3;
                        nVar2.a(nVar2.p, VideoClickOrigin.MUTE, com.fyber.inneractive.sdk.model.vast.x.EVENT_MUTE);
                    }
                }
                this.d.setMuteButtonState(m());
                break;
            case 2:
                q();
                break;
            case 3:
                a(Y.CTA_BUTTON.a());
                a(false, VideoClickOrigin.CTA, h0Var);
                break;
            case 4:
                a(Y.COMPANION.a());
                com.fyber.inneractive.sdk.player.f fVar4 = this.f1971a;
                String str = null;
                if (fVar4 != null) {
                    com.fyber.inneractive.sdk.player.n nVar3 = (com.fyber.inneractive.sdk.player.n) fVar4;
                    com.fyber.inneractive.sdk.flow.endcard.b bVarA = nVar3.t.a();
                    if (bVarA instanceof com.fyber.inneractive.sdk.flow.endcard.c) {
                        com.fyber.inneractive.sdk.flow.endcard.c cVar = (com.fyber.inneractive.sdk.flow.endcard.c) bVarA;
                        String str2 = cVar.e.g;
                        if (TextUtils.isEmpty(str2)) {
                            com.fyber.inneractive.sdk.model.vast.b bVar = nVar3.p;
                            if (bVar != null) {
                                str = bVar.b;
                            }
                        } else {
                            str = str2;
                        }
                        fVar4.a(cVar, VideoClickOrigin.COMPANION, com.fyber.inneractive.sdk.model.vast.x.EVENT_CLICK);
                    }
                }
                com.fyber.inneractive.sdk.player.ui.t tVar = this.d;
                if (tVar != null) {
                    tVar.e();
                }
                F f = this.g;
                if (f != null) {
                    f.a(str, h0Var, false);
                }
                break;
            case 5:
                o();
                break;
            case 6:
                f(true);
                break;
            case 7:
                b(h0Var);
                break;
            case 8:
                a(Y.COMPANION.a());
                a(true, VideoClickOrigin.COMPANION, h0Var);
                break;
            case 9:
                com.fyber.inneractive.sdk.player.f fVar5 = this.f1971a;
                if (fVar5 != null && !this.d.h) {
                    fVar5.g = true;
                    g(false);
                    break;
                }
                break;
            case 10:
                a(Y.APP_INFO.a());
                a(false, VideoClickOrigin.APP_INFO, h0Var);
                break;
            case 11:
                a(Y.STORE_PROMO.a());
                a(false, VideoClickOrigin.STORE_PROMO, h0Var);
                break;
        }
    }

    public final boolean a(boolean z, VideoClickOrigin videoClickOrigin, h0 h0Var) {
        EnumC3243g enumC3243g;
        com.fyber.inneractive.sdk.player.ui.t tVar = this.d;
        if (tVar != null) {
            tVar.e();
        }
        F f = this.g;
        boolean z2 = false;
        if (f != null) {
            if (z) {
                com.fyber.inneractive.sdk.player.f fVar = this.f1971a;
                if (fVar != null) {
                    com.fyber.inneractive.sdk.model.vast.b bVar = ((com.fyber.inneractive.sdk.player.n) fVar).p;
                    f.a(bVar != null ? bVar.b : null, h0Var, true);
                    com.fyber.inneractive.sdk.player.n nVar = (com.fyber.inneractive.sdk.player.n) this.f1971a;
                    nVar.a(nVar.p, videoClickOrigin, com.fyber.inneractive.sdk.model.vast.x.EVENT_CLICK);
                }
            } else {
                int i = y.b[videoClickOrigin.ordinal()];
                if (i == 1) {
                    enumC3243g = EnumC3243g.STORE_PROMO_CTA;
                } else if (i == 2) {
                    enumC3243g = EnumC3243g.VIDEO_CLICK;
                } else if (i != 3) {
                    enumC3243g = EnumC3243g.VIDEO_CTA;
                } else {
                    enumC3243g = EnumC3243g.VIDEO_APP_INFO;
                }
                com.fyber.inneractive.sdk.util.D dA = this.g.a(h0Var, enumC3243g);
                com.fyber.inneractive.sdk.player.f fVar2 = this.f1971a;
                if (fVar2 != null) {
                    com.fyber.inneractive.sdk.player.n nVar2 = (com.fyber.inneractive.sdk.player.n) fVar2;
                    nVar2.a(nVar2.p, videoClickOrigin, com.fyber.inneractive.sdk.model.vast.x.EVENT_CLICK);
                    com.fyber.inneractive.sdk.measurement.g gVar = this.f1971a.e;
                    if (gVar != null && gVar.c != null) {
                        IAlog.a("%s click", "OMVideo");
                        try {
                            gVar.c.adUserInteraction(InteractionType.CLICK);
                        } catch (Throwable th) {
                            gVar.a(th);
                        }
                    }
                }
                if (dA.f2344a != G.FAILED) {
                    z2 = true;
                }
            }
        }
        if (videoClickOrigin == VideoClickOrigin.VIDEO) {
            a(Y.VIDEO.a());
        }
        return z2;
    }

    public final boolean a(com.fyber.inneractive.sdk.flow.storepromo.observer.a aVar) {
        com.fyber.inneractive.sdk.player.f fVar = this.f1971a;
        if (fVar != null) {
            com.fyber.inneractive.sdk.player.n nVar = (com.fyber.inneractive.sdk.player.n) fVar;
            if (nVar.v != null) {
                com.fyber.inneractive.sdk.flow.storepromo.b bVar = nVar.v;
                bVar.getClass();
                synchronized (com.fyber.inneractive.sdk.flow.storepromo.b.k) {
                    bVar.h.add(aVar);
                }
                return true;
            }
        }
        IAlog.f("Unable to add store promo observer, promo manager is unavailable", new Object[0]);
        return false;
    }
}
