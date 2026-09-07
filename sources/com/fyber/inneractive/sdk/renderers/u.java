package com.fyber.inneractive.sdk.renderers;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import com.fyber.inneractive.sdk.R;
import com.fyber.inneractive.sdk.activities.InneractiveRichMediaVideoPlayerActivityCore;
import com.fyber.inneractive.sdk.config.C3082l;
import com.fyber.inneractive.sdk.config.C3083m;
import com.fyber.inneractive.sdk.config.C3085o;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.config.T;
import com.fyber.inneractive.sdk.config.U;
import com.fyber.inneractive.sdk.config.V;
import com.fyber.inneractive.sdk.config.Z;
import com.fyber.inneractive.sdk.config.enums.Orientation;
import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;
import com.fyber.inneractive.sdk.config.global.features.w;
import com.fyber.inneractive.sdk.external.InneractiveAdManager;
import com.fyber.inneractive.sdk.external.InneractiveAdSpot;
import com.fyber.inneractive.sdk.external.InneractiveContentController;
import com.fyber.inneractive.sdk.external.InneractiveFullScreenAdRewardedListener;
import com.fyber.inneractive.sdk.external.InneractiveFullscreenAdEventsListener;
import com.fyber.inneractive.sdk.external.InneractiveFullscreenUnitController;
import com.fyber.inneractive.sdk.external.InneractiveFullscreenVideoContentController;
import com.fyber.inneractive.sdk.external.InneractiveUnitController;
import com.fyber.inneractive.sdk.external.WebViewRendererProcessHasGoneError;
import com.fyber.inneractive.sdk.flow.G;
import com.fyber.inneractive.sdk.flow.K;
import com.fyber.inneractive.sdk.flow.N;
import com.fyber.inneractive.sdk.flow.Q;
import com.fyber.inneractive.sdk.flow.S;
import com.fyber.inneractive.sdk.flow.x;
import com.fyber.inneractive.sdk.network.B;
import com.fyber.inneractive.sdk.player.controller.F;
import com.fyber.inneractive.sdk.player.controller.InterfaceC3151b;
import com.fyber.inneractive.sdk.player.controller.z;
import com.fyber.inneractive.sdk.util.AbstractC3251o;
import com.fyber.inneractive.sdk.util.AbstractC3256u;
import com.fyber.inneractive.sdk.util.C3237a;
import com.fyber.inneractive.sdk.util.D;
import com.fyber.inneractive.sdk.util.EnumC3243g;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.h0;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes11.dex */
public final class u extends N implements F, com.fyber.inneractive.sdk.flow.storepromo.observer.a {
    public com.fyber.inneractive.sdk.external.g D;
    public v F;
    public com.fyber.inneractive.sdk.interfaces.e w;
    public com.fyber.inneractive.sdk.player.ui.m x;
    public InterfaceC3151b y;
    public WeakReference z;
    public boolean A = false;
    public boolean B = false;
    public boolean C = false;
    public UnitDisplayType E = UnitDisplayType.INTERSTITIAL;
    public boolean G = false;
    public final t H = new t(this);
    public final RelativeLayout.LayoutParams I = new RelativeLayout.LayoutParams(-1, -1);
    public boolean J = false;
    public boolean K = false;

    @Override // com.fyber.inneractive.sdk.flow.A
    public final boolean B() {
        com.fyber.inneractive.sdk.player.ui.m mVar = this.x;
        return mVar != null && mVar.a();
    }

    @Override // com.fyber.inneractive.sdk.flow.A
    public final void E() {
        View view = this.j;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    @Override // com.fyber.inneractive.sdk.flow.N
    public final boolean G() {
        return this.J;
    }

    @Override // com.fyber.inneractive.sdk.flow.N
    public final int I() {
        Integer numA;
        x xVar = this.b;
        if (xVar == null) {
            return -1;
        }
        S s = (S) xVar;
        if (s.c == null || (numA = ((com.fyber.inneractive.sdk.config.global.features.s) s.c.a(com.fyber.inneractive.sdk.config.global.features.s.class)).a("close_clickable_area_dp")) == null) {
            return -1;
        }
        return numA.intValue();
    }

    @Override // com.fyber.inneractive.sdk.flow.N
    public final int J() {
        Integer numA;
        x xVar = this.b;
        if (xVar == null) {
            return -1;
        }
        S s = (S) xVar;
        if (s.c == null || (numA = ((com.fyber.inneractive.sdk.config.global.features.s) s.c.a(com.fyber.inneractive.sdk.config.global.features.s.class)).a("close_visible_size_dp")) == null) {
            return -1;
        }
        return numA.intValue();
    }

    /* JADX WARN: Code duplicated, block: B:38:0x009f  */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.fyber.inneractive.sdk.flow.N
    public final long K() {
        long j;
        com.fyber.inneractive.sdk.flow.endcard.b bVarA;
        Integer numA;
        i = 0;
        int i = 0;
        if (InneractiveAdManager.isCurrentUserAChild()) {
            if (A()) {
                Integer numA2 = ((com.fyber.inneractive.sdk.config.global.features.c) ((S) this.b).c.a(com.fyber.inneractive.sdk.config.global.features.c.class)).a("end_card_skip_time_sec");
                int iIntValue = numA2 != null ? numA2.intValue() : 0;
                if (iIntValue >= 0 && iIntValue <= 5) {
                    i = iIntValue;
                }
                if (i > 0) {
                    return i;
                }
            }
            return 0L;
        }
        IAConfigManager iAConfigManager = IAConfigManager.O;
        C3082l c3082lA = iAConfigManager.u.b.a(CampaignEx.JSON_NATIVE_VIDEO_ENDCARD);
        View viewB = null;
        long jIntValue = 3;
        if (c3082lA.f1711a.containsKey("endcard_cr") || c3082lA.f1711a.containsKey("endcard_ci")) {
            String str = this.E != UnitDisplayType.REWARDED ? "endcard_ci" : "endcard_cr";
            try {
                j = c3082lA.f1711a.containsKey(str) ? Long.parseLong((String) c3082lA.f1711a.get(str)) : 3L;
            } catch (Exception unused) {
            }
            if (j >= 0 && j <= 5) {
                this.t = true;
                jIntValue = j;
            }
        } else {
            try {
                jIntValue = Long.parseLong(iAConfigManager.u.b.a("vast_endcard_x_delay", Long.toString(3L)));
            } catch (Throwable unused2) {
            }
            com.fyber.inneractive.sdk.flow.endcard.b bVarN = N();
            if (bVarN != null && bVarN.h() == com.fyber.inneractive.sdk.model.vast.i.Static) {
                w wVar = bVarN.b.g;
                if (wVar != null) {
                    int i2 = com.fyber.inneractive.sdk.config.global.features.t.f1700a[this.E.ordinal()];
                    if (i2 == 1) {
                        numA = wVar.a("endcard_x_btn_delay_rv");
                    } else if (i2 != 2) {
                        numA = null;
                    } else {
                        numA = wVar.a("endcard_x_btn_delay_iv");
                    }
                } else {
                    numA = null;
                }
                if (numA != null) {
                    jIntValue = numA.intValue();
                }
            }
        }
        long j2 = jIntValue * 1000;
        InterfaceC3151b interfaceC3151b = this.y;
        if (interfaceC3151b != null) {
            z zVar = (z) interfaceC3151b;
            com.fyber.inneractive.sdk.player.f fVar = zVar.f1971a;
            com.fyber.inneractive.sdk.flow.endcard.i iVar = fVar != null ? ((com.fyber.inneractive.sdk.player.n) fVar).t : null;
            if (iVar != null && (bVarA = iVar.a()) != null) {
                viewB = bVarA.f().b();
            }
            zVar.d.a(viewB == null, j2);
        }
        return j2;
    }

    @Override // com.fyber.inneractive.sdk.flow.N
    public final boolean L() {
        com.fyber.inneractive.sdk.player.ui.m mVar = this.x;
        return mVar != null && ((com.fyber.inneractive.sdk.player.ui.t) mVar).h();
    }

    public final void M() {
        if (this.B || this.c == null) {
            return;
        }
        this.B = true;
        com.fyber.inneractive.sdk.interfaces.e eVar = this.w;
        if (eVar != null && (eVar.wasDismissedByUser() || IAConfigManager.O.u.b.a(CampaignEx.JSON_NATIVE_VIDEO_ENDCARD).a())) {
            com.fyber.inneractive.sdk.model.vast.x xVar = com.fyber.inneractive.sdk.model.vast.x.EVENT_CLOSE;
            x xVar2 = this.b;
            if (xVar2 != null) {
                S s = (S) xVar2;
                if (s.i != null) {
                    String[] strArr = {xVar.a()};
                    com.fyber.inneractive.sdk.player.t tVar = s.i;
                    if (tVar != null) {
                        tVar.a("EVENT_TRACKING", strArr);
                    }
                }
            }
            com.fyber.inneractive.sdk.model.vast.x xVar3 = com.fyber.inneractive.sdk.model.vast.x.EVENT_CLOSE_LINEAR;
            x xVar4 = this.b;
            if (xVar4 != null) {
                S s2 = (S) xVar4;
                if (s2.i != null) {
                    String[] strArr2 = {xVar3.a()};
                    com.fyber.inneractive.sdk.player.t tVar2 = s2.i;
                    if (tVar2 != null) {
                        tVar2.a("EVENT_TRACKING", strArr2);
                    }
                }
            }
        }
        ((InneractiveFullscreenAdEventsListener) this.c).onAdDismissed(this.f1772a);
    }

    public final com.fyber.inneractive.sdk.flow.endcard.b N() {
        v vVar;
        Object obj = this.y;
        if (obj == null && (vVar = this.F) != null) {
            obj = vVar.f2319a;
        }
        com.fyber.inneractive.sdk.flow.endcard.i iVarI = obj != null ? ((z) obj).i() : null;
        if (iVarI != null) {
            return iVarI.a();
        }
        return null;
    }

    public final void O() {
        U u;
        x xVar = this.b;
        if (xVar == null || (u = ((S) xVar).d) == null) {
            return;
        }
        T t = (T) u;
        if (t.c != null) {
            UnitDisplayType unitDisplayType = t.c.b;
            Z z = IAConfigManager.O.x;
            com.fyber.inneractive.sdk.cache.session.enums.c cVar = unitDisplayType == UnitDisplayType.REWARDED ? com.fyber.inneractive.sdk.cache.session.enums.c.REWARDED_VIDEO : com.fyber.inneractive.sdk.cache.session.enums.c.INTERSTITIAL_VIDEO;
            com.fyber.inneractive.sdk.cache.session.enums.a aVar = com.fyber.inneractive.sdk.cache.session.enums.a.CLICK;
            com.fyber.inneractive.sdk.cache.session.e eVar = z.f1684a;
            if (eVar != null) {
                com.fyber.inneractive.sdk.util.r.f2374a.execute(new com.fyber.inneractive.sdk.cache.session.d(eVar, aVar, cVar));
            }
        }
    }

    @Override // com.fyber.inneractive.sdk.interfaces.f
    public final void a() {
    }

    @Override // com.fyber.inneractive.sdk.flow.N
    public final boolean b(x xVar) {
        com.fyber.inneractive.sdk.flow.endcard.b bVarN;
        boolean zBooleanValue;
        Boolean boolC;
        com.fyber.inneractive.sdk.config.global.r rVar;
        IAConfigManager iAConfigManager = IAConfigManager.O;
        C3085o c3085o = iAConfigManager.u.b;
        c3085o.getClass();
        String str = iAConfigManager.d;
        if ((c3085o.b.containsKey(str) ? (C3083m) c3085o.b.get(str) : new C3083m()).f1712a.containsKey(CampaignEx.JSON_NATIVE_VIDEO_ENDCARD) || (bVarN = N()) == null || bVarN.h() != com.fyber.inneractive.sdk.model.vast.i.Static) {
            return false;
        }
        x xVar2 = this.b;
        w wVar = (xVar2 == null || (rVar = ((S) xVar2).c) == null) ? null : (w) rVar.a(w.class);
        UnitDisplayType unitDisplayType = this.E;
        wVar.getClass();
        int i = com.fyber.inneractive.sdk.config.global.features.t.f1700a[unitDisplayType.ordinal()];
        if (i == 1) {
            Boolean boolC2 = wVar.c("countdown_rv");
            if (boolC2 == null) {
                return false;
            }
            zBooleanValue = boolC2.booleanValue();
        } else {
            if (i != 2 || (boolC = wVar.c("countdown_iv")) == null) {
                return false;
            }
            zBooleanValue = boolC.booleanValue();
        }
        return zBooleanValue;
    }

    @Override // com.fyber.inneractive.sdk.player.controller.F
    public final void c() {
        if (!this.C) {
            this.u.a(true);
        }
        this.C = true;
    }

    @Override // com.fyber.inneractive.sdk.flow.N, com.fyber.inneractive.sdk.flow.A, com.fyber.inneractive.sdk.external.InneractiveAdRenderer
    public final void destroy() {
        com.fyber.inneractive.sdk.interfaces.e eVar = this.w;
        if (eVar != null) {
            eVar.destroy();
        }
        if (this.A) {
            M();
        }
        InterfaceC3151b interfaceC3151b = this.y;
        if (interfaceC3151b != null) {
            ((z) interfaceC3151b).b(this);
            this.y.destroy();
            this.y = null;
        }
        com.fyber.inneractive.sdk.player.ui.m mVar = this.x;
        if (mVar != null) {
            mVar.destroy();
            this.x = null;
        }
        this.w = null;
        this.z = null;
        super.destroy();
    }

    @Override // com.fyber.inneractive.sdk.player.controller.F
    public final void e() {
        O();
    }

    @Override // com.fyber.inneractive.sdk.player.controller.F
    public final void f() {
        this.J = true;
        K k = this.v;
        if (k != null) {
            k.cancel();
            this.v = null;
        }
        if (!this.s) {
            this.s = true;
            com.fyber.inneractive.sdk.interfaces.e eVar = this.w;
            if (eVar != null) {
                c(eVar.isCloseButtonDisplay());
            }
        }
        com.fyber.inneractive.sdk.interfaces.e eVar2 = this.w;
        if (eVar2 == null || !eVar2.isCloseButtonDisplay()) {
            return;
        }
        d(true ^ this.t);
    }

    @Override // com.fyber.inneractive.sdk.player.controller.F
    public final void h() {
        com.fyber.inneractive.sdk.interfaces.e eVar = this.w;
        if (eVar != null) {
            eVar.dismissAd(false);
        }
        a(new WebViewRendererProcessHasGoneError());
    }

    @Override // com.fyber.inneractive.sdk.player.controller.F
    public final void i() {
        com.fyber.inneractive.sdk.interfaces.e eVar = this.w;
        if (eVar != null) {
            eVar.dismissAd(true);
        }
    }

    @Override // com.fyber.inneractive.sdk.player.controller.F
    public final void j() {
        Z z = IAConfigManager.O.x;
        com.fyber.inneractive.sdk.cache.session.enums.c cVar = this.E == UnitDisplayType.INTERSTITIAL ? com.fyber.inneractive.sdk.cache.session.enums.c.INTERSTITIAL_VIDEO : com.fyber.inneractive.sdk.cache.session.enums.c.REWARDED_VIDEO;
        com.fyber.inneractive.sdk.cache.session.enums.a aVar = com.fyber.inneractive.sdk.cache.session.enums.a.IMPRESSION;
        com.fyber.inneractive.sdk.cache.session.e eVar = z.f1684a;
        if (eVar != null) {
            com.fyber.inneractive.sdk.util.r.f2374a.execute(new com.fyber.inneractive.sdk.cache.session.d(eVar, aVar, cVar));
        }
        C();
    }

    @Override // com.fyber.inneractive.sdk.interfaces.f
    public final void k() {
        M();
        InneractiveAdSpot inneractiveAdSpot = this.f1772a;
        if (inneractiveAdSpot == null || !(inneractiveAdSpot instanceof G)) {
            return;
        }
        ((G) inneractiveAdSpot).a();
    }

    @Override // com.fyber.inneractive.sdk.flow.N, com.fyber.inneractive.sdk.interfaces.f
    public final void m() {
        super.m();
        C3237a c3237a = this.u;
        if (!c3237a.b || c3237a.e <= 0) {
            return;
        }
        c3237a.f += System.currentTimeMillis() - c3237a.e;
        c3237a.e = 0L;
    }

    @Override // com.fyber.inneractive.sdk.player.controller.F
    public final void onCompleted() {
        InneractiveFullscreenVideoContentController inneractiveFullscreenVideoContentController = (InneractiveFullscreenVideoContentController) AbstractC3256u.a(this.z);
        if (inneractiveFullscreenVideoContentController != null) {
            inneractiveFullscreenVideoContentController.onCompleted();
        }
        Z z = IAConfigManager.O.x;
        UnitDisplayType unitDisplayType = this.E;
        UnitDisplayType unitDisplayType2 = UnitDisplayType.REWARDED;
        com.fyber.inneractive.sdk.cache.session.enums.c cVar = unitDisplayType == unitDisplayType2 ? com.fyber.inneractive.sdk.cache.session.enums.c.REWARDED_VIDEO : com.fyber.inneractive.sdk.cache.session.enums.c.INTERSTITIAL_VIDEO;
        com.fyber.inneractive.sdk.cache.session.enums.a aVar = com.fyber.inneractive.sdk.cache.session.enums.a.COMPLETION;
        com.fyber.inneractive.sdk.cache.session.e eVar = z.f1684a;
        if (eVar != null) {
            com.fyber.inneractive.sdk.util.r.f2374a.execute(new com.fyber.inneractive.sdk.cache.session.d(eVar, aVar, cVar));
        }
        if (this.E == unitDisplayType2) {
            com.fyber.inneractive.sdk.external.g gVar = this.D;
            if (gVar != null) {
                G g = (G) AbstractC3256u.a(((Q) gVar.f1765a).mAdSpot);
                InneractiveFullScreenAdRewardedListener inneractiveFullScreenAdRewardedListener = gVar.f1765a.b;
                if (inneractiveFullScreenAdRewardedListener != null && g != null) {
                    inneractiveFullScreenAdRewardedListener.onAdRewarded(g);
                }
            }
            F();
        }
        x xVar = this.b;
        if (xVar == null || ((S) xVar).i == null) {
            return;
        }
        H();
    }

    @Override // com.fyber.inneractive.sdk.player.controller.F
    public final void onPlayerError() {
        InneractiveFullscreenVideoContentController inneractiveFullscreenVideoContentController = (InneractiveFullscreenVideoContentController) AbstractC3256u.a(this.z);
        com.fyber.inneractive.sdk.interfaces.e eVar = this.w;
        if (eVar != null) {
            eVar.dismissAd(false);
        }
        if (inneractiveFullscreenVideoContentController != null) {
            inneractiveFullscreenVideoContentController.onPlayerError();
        }
    }

    @Override // com.fyber.inneractive.sdk.player.controller.F
    public final void onProgress(int i, int i2) {
        InneractiveFullscreenVideoContentController inneractiveFullscreenVideoContentController = (InneractiveFullscreenVideoContentController) AbstractC3256u.a(this.z);
        if (inneractiveFullscreenVideoContentController != null) {
            inneractiveFullscreenVideoContentController.onProgress(i, i2);
        }
    }

    @Override // com.fyber.inneractive.sdk.flow.N, com.fyber.inneractive.sdk.interfaces.f
    public final void r() {
        super.r();
        C3237a c3237a = this.u;
        if (c3237a.b) {
            c3237a.e = System.currentTimeMillis();
        }
    }

    @Override // com.fyber.inneractive.sdk.interfaces.f
    public final boolean t() {
        com.fyber.inneractive.sdk.player.t tVar;
        InterfaceC3151b interfaceC3151b;
        com.fyber.inneractive.sdk.interfaces.e eVar;
        com.fyber.inneractive.sdk.player.ui.m mVar;
        com.fyber.inneractive.sdk.flow.storepromo.controller.b bVar;
        com.fyber.inneractive.sdk.flow.storepromo.ui.c cVar;
        View view;
        com.fyber.inneractive.sdk.flow.storepromo.ui.c cVar2;
        View view2;
        x xVar = this.b;
        if (xVar == null || (tVar = ((S) xVar).i) == null || (interfaceC3151b = this.y) == null || (eVar = this.w) == null || (mVar = this.x) == null) {
            return false;
        }
        com.fyber.inneractive.sdk.player.n nVar = (com.fyber.inneractive.sdk.player.n) tVar.f;
        com.fyber.inneractive.sdk.flow.storepromo.b bVar2 = nVar.v;
        if (bVar2 != null && (bVar = bVar2.d) != null && (cVar = bVar.d) != null && cVar.b != null && (view = cVar.f1831a) != null && view.getParent() != null && cVar.b.getVisibility() == 0) {
            com.fyber.inneractive.sdk.flow.storepromo.b bVar3 = nVar.v;
            com.fyber.inneractive.sdk.flow.storepromo.controller.b bVar4 = bVar3.d;
            if (bVar4 == null || (cVar2 = bVar4.d) == null || cVar2.b == null || (view2 = cVar2.f1831a) == null || view2.getParent() == null || cVar2.b.getVisibility() != 0) {
                IAlog.f("StorePromoManager: hidePromo: unable hide promo: controller null or not ready", new Object[0]);
            } else {
                com.fyber.inneractive.sdk.flow.storepromo.ui.c cVar3 = bVar3.d.d;
                if (cVar3 != null) {
                    cVar3.a();
                }
            }
        } else if (((com.fyber.inneractive.sdk.player.ui.t) mVar).h()) {
            if (this.p) {
                eVar.dismissAd(true);
            }
        } else if (interfaceC3151b.b()) {
            ((z) interfaceC3151b).f(true);
        }
        return true;
    }

    @Override // com.fyber.inneractive.sdk.flow.A
    public final void v() {
        View view = this.j;
        if (view != null) {
            view.setVisibility(0);
        }
    }

    @Override // com.fyber.inneractive.sdk.flow.N, com.fyber.inneractive.sdk.interfaces.f
    public final void a(com.fyber.inneractive.sdk.interfaces.e eVar, Activity activity) throws InneractiveUnitController.AdDisplayError {
        V v;
        super.a(eVar, activity);
        this.w = eVar;
        this.A = false;
        this.B = false;
        this.K = false;
        InneractiveUnitController selectedUnitController = this.f1772a.getSelectedUnitController();
        if (selectedUnitController != null) {
            if (selectedUnitController instanceof InneractiveFullscreenUnitController) {
                InneractiveContentController selectedContentController = selectedUnitController.getSelectedContentController();
                if (selectedContentController != null) {
                    if (selectedContentController instanceof InneractiveFullscreenVideoContentController) {
                        this.z = new WeakReference((InneractiveFullscreenVideoContentController) selectedContentController);
                    } else {
                        IAlog.f("%sContent controller expected to be InneractiveFullscreenVideoContentController and is %s", IAlog.a(this), selectedContentController.getClass().getSimpleName());
                    }
                }
            } else {
                IAlog.f("%sWrong type of unit controller found. Expecting InneractiveFullscreenUnitController", IAlog.a(this));
            }
        }
        U u = this.f1772a.getAdContent().d;
        if (u != null && (v = ((T) u).f) != null) {
            this.E = v.j;
        }
        x xVar = this.b;
        if (xVar != null) {
            ((S) xVar).g();
        }
        x xVar2 = this.b;
        com.fyber.inneractive.sdk.player.t tVar = xVar2 != null ? ((S) xVar2).i : null;
        Context context = this.w.getLayout().getContext();
        if (tVar != null) {
            com.fyber.inneractive.sdk.player.a aVar = tVar.f;
            if (aVar != null) {
                com.fyber.inneractive.sdk.player.n nVar = (com.fyber.inneractive.sdk.player.n) aVar;
                if (nVar.f2210a != null) {
                    nVar.getClass();
                    e eVar2 = new e(tVar);
                    this.F = eVar2;
                    this.x = eVar2.a(context, ((S) this.b).c);
                    InterfaceC3151b interfaceC3151bA = this.F.a(this.f1772a, (S) this.b);
                    this.y = interfaceC3151bA;
                    this.F.b();
                    interfaceC3151bA.b(false);
                    z zVar = (z) this.y;
                    zVar.g = this;
                    zVar.a(this);
                    ((com.fyber.inneractive.sdk.player.ui.e) this.x).d();
                    this.I.addRule(13);
                    this.w.getLayout().addView((View) this.x, this.I);
                    this.j = ((View) this.x).findViewById(R.id.ia_click_overlay);
                    this.F.a(this.H);
                    this.A = true;
                    return;
                }
            }
            IAlog.f("%sFull screen video ad renderer is not valid.", IAlog.a(this));
            throw new InneractiveUnitController.AdDisplayError("Full screen video could not be loaded");
        }
    }

    public final void e(boolean z) {
        if (L() && this.J) {
            return;
        }
        if (z) {
            InterfaceC3151b interfaceC3151b = this.y;
            com.fyber.inneractive.sdk.flow.endcard.i iVarI = interfaceC3151b != null ? ((z) interfaceC3151b).i() : null;
            com.fyber.inneractive.sdk.flow.endcard.n nVar = iVarI != null ? (com.fyber.inneractive.sdk.flow.endcard.n) iVarI.b.a(com.fyber.inneractive.sdk.model.vast.i.FMP_End_Card) : null;
            this.u.a(nVar != null ? nVar.g().toString() : null);
            return;
        }
        C3237a c3237a = this.u;
        c3237a.d = 0L;
        c3237a.e = 0L;
        c3237a.f = 0L;
        c3237a.b = false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x003e, code lost:
    
        if (((r2 == null || (r2 = r2.E) == null || !android.text.TextUtils.equals(r2, "1")) ? false : true) != false) goto L46;
     */
    @Override // com.fyber.inneractive.sdk.flow.N, com.fyber.inneractive.sdk.interfaces.f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void b(boolean r6) {
        /*
            r5 = this;
            r5.e(r6)
            com.fyber.inneractive.sdk.player.controller.b r6 = r5.y
            r0 = 0
            if (r6 == 0) goto Lf
            com.fyber.inneractive.sdk.player.controller.z r6 = (com.fyber.inneractive.sdk.player.controller.z) r6
            com.fyber.inneractive.sdk.flow.endcard.i r6 = r6.i()
            goto L10
        Lf:
            r6 = r0
        L10:
            com.fyber.inneractive.sdk.player.ui.m r1 = r5.x
            if (r1 == 0) goto L22
            com.fyber.inneractive.sdk.player.ui.t r1 = (com.fyber.inneractive.sdk.player.ui.t) r1
            android.view.ViewGroup r1 = r1.q
            if (r1 == 0) goto L22
            int r1 = r1.getVisibility()
            if (r1 != 0) goto L22
            goto L92
        L22:
            boolean r1 = r5.G
            if (r1 != 0) goto L92
            r1 = 0
            if (r6 == 0) goto L41
            com.fyber.inneractive.sdk.flow.V r2 = r6.f1793a
            com.fyber.inneractive.sdk.response.g r2 = r2.d
            if (r2 == 0) goto L3d
            java.lang.String r2 = r2.E
            if (r2 == 0) goto L3d
            java.lang.String r3 = "1"
            boolean r2 = android.text.TextUtils.equals(r2, r3)
            if (r2 == 0) goto L3d
            r2 = 1
            goto L3e
        L3d:
            r2 = r1
        L3e:
            if (r2 == 0) goto L41
            goto L92
        L41:
            if (r6 == 0) goto L48
            com.fyber.inneractive.sdk.flow.endcard.b r6 = r6.b()
            goto L49
        L48:
            r6 = r0
        L49:
            if (r6 == 0) goto L8a
            r5.J = r1
            r5.p = r1
            com.fyber.inneractive.sdk.interfaces.e r2 = r5.k
            if (r2 == 0) goto L56
            r2.disableCloseButton()
        L56:
            com.fyber.inneractive.sdk.util.a r2 = r5.u
            r3 = 0
            r2.d = r3
            r2.e = r3
            r2.f = r3
            r2.b = r1
            java.lang.Runnable r1 = r5.l
            if (r1 == 0) goto L6d
            android.os.Handler r2 = com.fyber.inneractive.sdk.util.r.b
            r2.removeCallbacks(r1)
            r5.l = r0
        L6d:
            java.lang.Runnable r1 = r5.n
            if (r1 == 0) goto L78
            android.os.Handler r2 = com.fyber.inneractive.sdk.util.r.b
            r2.removeCallbacks(r1)
            r5.n = r0
        L78:
            r5.H()
            com.fyber.inneractive.sdk.renderers.v r0 = r5.F
            com.fyber.inneractive.sdk.player.controller.z r0 = r0.f2319a
            r0.a(r6)
            com.fyber.inneractive.sdk.interfaces.e r6 = r5.w
            if (r6 == 0) goto L99
            r6.secondEndCardWasDisplayed()
            goto L99
        L8a:
            com.fyber.inneractive.sdk.interfaces.e r6 = r5.w
            if (r6 == 0) goto L99
            r6.destroy()
            goto L99
        L92:
            com.fyber.inneractive.sdk.interfaces.e r6 = r5.w
            if (r6 == 0) goto L99
            r6.destroy()
        L99:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.renderers.u.b(boolean):void");
    }

    @Override // com.fyber.inneractive.sdk.interfaces.f
    public final void a(com.fyber.inneractive.sdk.external.g gVar) {
        this.D = gVar;
    }

    @Override // com.fyber.inneractive.sdk.player.controller.F
    public final D a(h0 h0Var, EnumC3243g enumC3243g) {
        Context context;
        com.fyber.inneractive.sdk.response.e eVar;
        com.fyber.inneractive.sdk.model.vast.b bVar;
        O();
        if (this.x.getContext() == null) {
            context = AbstractC3251o.f2370a;
        } else {
            context = this.x.getContext();
        }
        x xVar = this.b;
        return a(context, (xVar == null || (eVar = ((S) xVar).b) == null || (bVar = ((com.fyber.inneractive.sdk.response.g) eVar).N) == null) ? null : bVar.b, h0Var, enumC3243g);
    }

    @Override // com.fyber.inneractive.sdk.flow.N, com.fyber.inneractive.sdk.interfaces.f
    public final boolean b(com.fyber.inneractive.sdk.flow.storepromo.observer.a aVar) {
        InterfaceC3151b interfaceC3151b = this.y;
        if (interfaceC3151b == null) {
            IAlog.f("Unable to register store promo observer - ui controller unavailable", new Object[0]);
            return false;
        }
        return ((z) interfaceC3151b).a(aVar);
    }

    @Override // com.fyber.inneractive.sdk.player.controller.F
    public final void a(boolean z, Orientation orientation) {
        com.fyber.inneractive.sdk.interfaces.e eVar = this.w;
        if (eVar != null) {
            eVar.setActivityOrientation(z, orientation);
        }
    }

    @Override // com.fyber.inneractive.sdk.player.controller.F
    public final void a(String str, String str2) {
        IAlog.a(IAlog.a(this) + "full screen video ad renderer callback: onSuspiciousNoUserWebActionDetected", new Object[0]);
        com.fyber.inneractive.sdk.interfaces.e eVar = this.w;
        if (eVar == null || eVar.getLayout() == null || this.w.getLayout().getContext() == null) {
            return;
        }
        if (!this.K) {
            B.a(this.w.getLayout().getContext(), str, str2, this.b);
            this.K = true;
            IAlog.a(IAlog.a(this) + "reporting auto redirect", new Object[0]);
            return;
        }
        IAlog.a(IAlog.a(this) + "redirect already reported for this ad", new Object[0]);
    }

    @Override // com.fyber.inneractive.sdk.player.controller.F
    public final D a(String str, h0 h0Var, boolean z) {
        if (this.E == UnitDisplayType.INTERSTITIAL) {
            this.G = true;
        }
        com.fyber.inneractive.sdk.flow.endcard.b bVarN = N();
        if (bVarN != null) {
            O();
            D dA = a(bVarN.b.f1783a, str, h0Var, bVarN.g());
            if (dA.f2344a != com.fyber.inneractive.sdk.util.G.FAILED) {
                S s = bVarN.b.b;
                String[] strArr = {com.fyber.inneractive.sdk.model.vast.x.EVENT_CLICK.toString()};
                com.fyber.inneractive.sdk.player.t tVar = s.i;
                if (tVar != null) {
                    tVar.a("EVENT_TRACKING", strArr);
                }
            }
            return dA;
        }
        return new D(com.fyber.inneractive.sdk.util.G.FAILED, new Exception("No Companion clicked"));
    }

    @Override // com.fyber.inneractive.sdk.player.controller.F
    public final void a(boolean z) {
        com.fyber.inneractive.sdk.player.t tVar;
        com.fyber.inneractive.sdk.interfaces.e eVar;
        if (z) {
            com.fyber.inneractive.sdk.model.vast.x xVar = com.fyber.inneractive.sdk.model.vast.x.EVENT_SKIP;
            x xVar2 = this.b;
            if (xVar2 != null) {
                S s = (S) xVar2;
                if (s.i != null) {
                    String[] strArr = {xVar.a()};
                    com.fyber.inneractive.sdk.player.t tVar2 = s.i;
                    if (tVar2 != null) {
                        tVar2.a("EVENT_TRACKING", strArr);
                    }
                }
            }
        }
        x xVar3 = this.b;
        if (xVar3 == null || (tVar = ((S) xVar3).i) == null) {
            return;
        }
        tVar.a("TRACKING_COMPLETED", new String[0]);
        H();
        String[] strArr2 = new String[0];
        com.fyber.inneractive.sdk.player.t tVar3 = ((S) this.b).i;
        if (tVar3 != null) {
            tVar3.a("TRACKING_COMPLETED", strArr2);
        }
        if (IAConfigManager.O.u.b.a(CampaignEx.JSON_NATIVE_VIDEO_ENDCARD).a() && z && (eVar = this.w) != null) {
            eVar.destroy();
        }
        e(z);
    }

    @Override // com.fyber.inneractive.sdk.player.controller.F
    public final void a(View view, String str) {
        if (view != null) {
            InneractiveRichMediaVideoPlayerActivityCore.startRichMediaIntent(c(view), str);
            a(c(view), Float.NaN, Float.NaN);
        }
    }

    @Override // com.fyber.inneractive.sdk.player.controller.F
    public final void a(View view) {
        a(c(view), Float.NaN, Float.NaN);
    }

    @Override // com.fyber.inneractive.sdk.flow.N
    public final long a(long j) {
        if (this.t) {
            return j;
        }
        long j2 = 12;
        try {
            j2 = Long.parseLong(IAConfigManager.O.u.b.a("vast_endcard_x_fallback_delay", Long.toString(12L)));
        } catch (Throwable unused) {
        }
        return j2 * 1000;
    }

    @Override // com.fyber.inneractive.sdk.flow.N, com.fyber.inneractive.sdk.interfaces.f
    public final void a(com.fyber.inneractive.sdk.flow.storepromo.observer.a aVar) {
        InterfaceC3151b interfaceC3151b = this.y;
        if (interfaceC3151b == null) {
            IAlog.f("Unable to unregister store promo observer - ui controller unavailable", new Object[0]);
        } else {
            ((z) interfaceC3151b).b(aVar);
        }
    }

    @Override // com.fyber.inneractive.sdk.flow.storepromo.observer.a
    public final void a(com.fyber.inneractive.sdk.flow.storepromo.observer.b bVar) {
        if (this.E == UnitDisplayType.INTERSTITIAL) {
            IAlog.a("InneractiveFullscreenVideoAdRenderer: update: StorePromo isClicked: %s", Boolean.valueOf(bVar.b));
            this.G = bVar.b;
        }
    }
}
