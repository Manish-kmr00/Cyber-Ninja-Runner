package com.fyber.inneractive.sdk.player.controller;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.view.ViewGroup;
import com.fyber.inneractive.sdk.activities.InneractiveFullscreenAdActivity;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.config.T;
import com.fyber.inneractive.sdk.config.enums.TapAction;
import com.fyber.inneractive.sdk.external.InneractiveAdSpot;
import com.fyber.inneractive.sdk.external.InneractiveAdViewEventsListener;
import com.fyber.inneractive.sdk.external.InneractiveUnitController;
import com.fyber.inneractive.sdk.player.enums.VideoClickOrigin;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.h0;
import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import com.safedk.android.internal.special.SpecialsBridge;
import com.safedk.android.utils.Logger;

/* JADX INFO: loaded from: classes13.dex */
public final class s extends z {
    public float A;
    public boolean B;
    public boolean C;
    public boolean D;
    public r y;
    public final float z;

    public s(com.fyber.inneractive.sdk.player.f fVar, com.fyber.inneractive.sdk.player.ui.i iVar, T t, com.fyber.inneractive.sdk.config.global.r rVar, boolean z, String str) {
        super(fVar, iVar, t, rVar, z, str);
        this.A = 0.0f;
        this.B = false;
        this.C = false;
        this.D = false;
        this.z = ((T) this.b).g.b.intValue() / 100.0f;
        C();
    }

    public static void safedk_Context_startActivity_97cb3195734cf5c9cc3418feeafa6dd6(Context p0, Intent p1) {
        Logger.d("SafeDK-Special|SafeDK: Call> Landroid/content/Context;->startActivity(Landroid/content/Intent;)V");
        if (p1 == null) {
            return;
        }
        BrandSafetyUtils.detectAdClick(p1, com.safedk.android.utils.h.p);
        p0.startActivity(p1);
    }

    public final void A() {
        com.fyber.inneractive.sdk.player.f fVar;
        q qVar;
        com.fyber.inneractive.sdk.player.ui.t tVar;
        if (this.A < this.z || (fVar = this.f1971a) == null || (qVar = fVar.f2210a) == null || qVar.e == com.fyber.inneractive.sdk.player.enums.b.Completed || (tVar = this.d) == null || tVar.h() || this.f1971a.f2210a.j == null) {
            return;
        }
        if (((T) this.b).f.f1682a.booleanValue() || this.B) {
            c(IAConfigManager.O.i.f1675a);
        }
    }

    public final void B() {
        if (this.y != null) {
            IAlog.a("%sCancelling play runnable", IAlog.a(this));
            this.d.removeCallbacks(this.y);
            this.y = null;
        }
    }

    public final void C() {
        q qVar;
        com.fyber.inneractive.sdk.player.f fVar = this.f1971a;
        if (fVar == null || (qVar = fVar.f2210a) == null || qVar.n) {
            return;
        }
        if (((T) this.b).f.d.booleanValue()) {
            this.f1971a.f2210a.b(false);
        } else {
            if (m()) {
                return;
            }
            this.f1971a.f2210a.d(false);
        }
    }

    @Override // com.fyber.inneractive.sdk.player.controller.z, com.fyber.inneractive.sdk.player.ui.n
    public final void a(boolean z) {
        if (z) {
            a(this.A);
        }
        super.a(z);
    }

    @Override // com.fyber.inneractive.sdk.player.controller.z, com.fyber.inneractive.sdk.player.controller.InterfaceC3151b
    public final boolean b() {
        return true;
    }

    public final void c(int i) {
        q qVar;
        com.fyber.inneractive.sdk.player.f fVar = this.f1971a;
        if (fVar == null || (qVar = fVar.f2210a) == null || qVar.e == com.fyber.inneractive.sdk.player.enums.b.Playing || this.y != null) {
            return;
        }
        IAlog.a("%splayVideo %s", IAlog.a(this), this.d);
        if (i == 0) {
            g(false);
            return;
        }
        r rVar = new r(this);
        this.y = rVar;
        this.d.postDelayed(rVar, i);
    }

    @Override // com.fyber.inneractive.sdk.player.controller.z, com.fyber.inneractive.sdk.player.controller.InterfaceC3151b
    public final void destroy() {
        B();
        this.g = null;
        super.destroy();
    }

    @Override // com.fyber.inneractive.sdk.player.controller.z
    public final void e() {
        super.e();
        com.fyber.inneractive.sdk.player.f fVar = this.f1971a;
        if (fVar != null && fVar.f2210a != null) {
            IAlog.a("%sconnectToTextureView playing state = %s", IAlog.a(this), this.f1971a.f2210a.e);
            if (this.f1971a.f2210a.h()) {
                this.d.e(!this.f1971a.g);
                C();
            }
        }
        a(this.A);
    }

    @Override // com.fyber.inneractive.sdk.player.controller.z
    public final void f() {
        B();
        super.f();
    }

    @Override // com.fyber.inneractive.sdk.player.controller.z
    public final void g(boolean z) {
        com.fyber.inneractive.sdk.player.f fVar = this.f1971a;
        if (fVar == null || fVar.f2210a == null) {
            return;
        }
        C();
        super.g(false);
    }

    public final void h(boolean z) {
        com.fyber.inneractive.sdk.player.f fVar;
        q qVar;
        this.C = z;
        if (!z || (fVar = this.f1971a) == null || (qVar = fVar.f2210a) == null || qVar.j != null || !this.d.e || qVar.e == com.fyber.inneractive.sdk.player.enums.b.Completed) {
            return;
        }
        e();
        a(this.A);
    }

    @Override // com.fyber.inneractive.sdk.player.controller.z
    public final int l() {
        return 0;
    }

    @Override // com.fyber.inneractive.sdk.player.controller.z
    public final void o() {
        z();
    }

    @Override // com.fyber.inneractive.sdk.player.controller.z
    public final void p() {
        super.p();
        B();
    }

    @Override // com.fyber.inneractive.sdk.player.controller.z
    public final void q() {
        com.fyber.inneractive.sdk.player.f fVar = this.f1971a;
        if (fVar == null || fVar.f2210a == null) {
            return;
        }
        e();
        g(false);
    }

    @Override // com.fyber.inneractive.sdk.player.controller.z
    public final void r() {
        A();
    }

    @Override // com.fyber.inneractive.sdk.player.controller.z
    public final void s() {
        super.s();
        if (((T) this.b).f.i != TapAction.FULLSCREEN) {
            this.d.n();
        }
        w();
        this.B = true;
    }

    @Override // com.fyber.inneractive.sdk.player.controller.z
    public final void u() {
        B();
        super.u();
    }

    @Override // com.fyber.inneractive.sdk.player.controller.z
    public final boolean v() {
        return false;
    }

    public final void z() {
        if (this.g == null || this.D) {
            return;
        }
        B();
        super.f();
        com.fyber.inneractive.sdk.renderers.n nVar = (com.fyber.inneractive.sdk.renderers.n) ((A) this.g);
        com.fyber.inneractive.sdk.renderers.o oVar = nVar.f2315a;
        InneractiveUnitController.EventsListener eventsListener = oVar.c;
        if (eventsListener != null) {
            SpecialsBridge.fyberOnAdExpanded((InneractiveAdViewEventsListener) eventsListener, oVar.f1772a);
        }
        ViewGroup viewGroup = nVar.f2315a.p;
        if (viewGroup != null && viewGroup.getContext() != null) {
            com.fyber.inneractive.sdk.renderers.o oVar2 = nVar.f2315a;
            com.fyber.inneractive.sdk.display.a bVar = oVar2.b instanceof com.fyber.inneractive.sdk.dv.a ? new com.fyber.inneractive.sdk.display.b() : new com.fyber.inneractive.sdk.display.c();
            if (bVar instanceof com.fyber.inneractive.sdk.display.c) {
                Context context = oVar2.p.getContext();
                InneractiveAdSpot inneractiveAdSpot = nVar.f2315a.f1772a;
                Intent intent = new Intent(context, (Class<?>) InneractiveFullscreenAdActivity.class);
                intent.putExtra("spotId", inneractiveAdSpot.getLocalUniqueId());
                if (!(context instanceof Activity)) {
                    intent.setFlags(268435456);
                }
                try {
                    IAlog.a("%sIAInterstitialUtil: Opening interstitial for spot id: %s", IAlog.a(context), inneractiveAdSpot.getLocalUniqueId());
                    safedk_Context_startActivity_97cb3195734cf5c9cc3418feeafa6dd6(context, intent);
                } catch (ActivityNotFoundException unused) {
                    IAlog.c("%sIAInterstitialUtil: InneractiveFullscreenAdActivity.class not found. Did you declare InneractiveFullscreenAdActivity in your manifest?", IAlog.a(context));
                }
            }
        }
        IAlog.a("%sopening fullscreen", IAlog.a(this));
        this.D = true;
        com.fyber.inneractive.sdk.player.f fVar = this.f1971a;
        if (fVar != null) {
            com.fyber.inneractive.sdk.player.n nVar2 = (com.fyber.inneractive.sdk.player.n) fVar;
            nVar2.a(nVar2.p, VideoClickOrigin.InvalidOrigin, com.fyber.inneractive.sdk.model.vast.x.EVENT_FULLSCREEN, com.fyber.inneractive.sdk.model.vast.x.EVENT_EXPAND);
        }
    }

    @Override // com.fyber.inneractive.sdk.player.controller.z, com.fyber.inneractive.sdk.player.controller.InterfaceC3151b
    public final void b(boolean z) {
        q qVar;
        com.fyber.inneractive.sdk.player.f fVar = this.f1971a;
        if (fVar != null && (qVar = fVar.f2210a) != null && qVar.e != com.fyber.inneractive.sdk.player.enums.b.Completed) {
            if (((T) this.b).f.i != TapAction.FULLSCREEN) {
                this.d.n();
            }
            w();
        }
        super.b(z);
    }

    @Override // com.fyber.inneractive.sdk.player.controller.z
    public final void n() {
        IAlog.a("%s onBufferingTimeout reached. Skipping to end card", IAlog.a(this));
        if (this.d.e) {
            this.r = true;
            f(false);
        }
    }

    public final void a(float f) {
        q qVar;
        this.A = f;
        if (IAlog.f2345a >= 3) {
            IAlog.c("%sonVisibilityChanged called with: %s vfpl = %s vfpa = %s", IAlog.a(this), Float.valueOf(f), Float.valueOf(this.z), Float.valueOf(1.0f - this.z));
        }
        com.fyber.inneractive.sdk.player.f fVar = this.f1971a;
        if (fVar == null || (qVar = fVar.f2210a) == null) {
            return;
        }
        if (qVar.e != com.fyber.inneractive.sdk.player.enums.b.Playing) {
            A();
            return;
        }
        if (f <= this.z) {
            IAlog.e("%sonVisibilityChanged pausing player", IAlog.a(this));
            if (this.f1971a.f2210a.j != null) {
                this.B = false;
                B();
                super.u();
                e(false);
            }
        }
    }

    @Override // com.fyber.inneractive.sdk.player.controller.z
    public final int h() {
        return IAConfigManager.O.u.b.a("VideoAdBufferingTimeout", 5, 1) * 1000;
    }

    @Override // com.fyber.inneractive.sdk.player.controller.z
    public final void b(h0 h0Var) {
        q qVar;
        TapAction tapAction = ((T) this.b).f.i;
        com.fyber.inneractive.sdk.player.f fVar = this.f1971a;
        if (fVar == null || fVar.f2210a == null || this.A >= this.z) {
            if (tapAction == TapAction.CTR) {
                a(false, VideoClickOrigin.CTA, h0Var);
                return;
            }
            if (tapAction == TapAction.FULLSCREEN) {
                z();
                return;
            }
            if (tapAction != TapAction.DO_NOTHING) {
                IAlog.a("%sonVideoClicked called, but we recieved an unknown tap action %s", IAlog.a(this), tapAction);
                return;
            }
            if (fVar == null || (qVar = fVar.f2210a) == null) {
                return;
            }
            com.fyber.inneractive.sdk.player.enums.b bVar = qVar.e;
            if (bVar != com.fyber.inneractive.sdk.player.enums.b.Completed && bVar != com.fyber.inneractive.sdk.player.enums.b.Prepared) {
                qVar.j();
            } else {
                qVar.a(1, true);
            }
        }
    }
}
