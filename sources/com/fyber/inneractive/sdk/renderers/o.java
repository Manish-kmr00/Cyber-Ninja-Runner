package com.fyber.inneractive.sdk.renderers;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.fyber.inneractive.sdk.external.InneractiveAdSpot;
import com.fyber.inneractive.sdk.external.InneractiveAdViewUnitController;
import com.fyber.inneractive.sdk.external.InneractiveAdViewVideoContentController;
import com.fyber.inneractive.sdk.external.InneractiveContentController;
import com.fyber.inneractive.sdk.external.InneractiveNativeVideoContentController;
import com.fyber.inneractive.sdk.external.InneractiveUnitController;
import com.fyber.inneractive.sdk.external.VideoContentListener;
import com.fyber.inneractive.sdk.flow.A;
import com.fyber.inneractive.sdk.flow.S;
import com.fyber.inneractive.sdk.flow.x;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.L;
import com.fyber.inneractive.sdk.util.M;
import com.fyber.inneractive.sdk.util.N;

/* JADX INFO: loaded from: classes11.dex */
public final class o extends A implements com.fyber.inneractive.sdk.interfaces.d, InneractiveNativeVideoContentController.Renderer, M {
    public FrameLayout k;
    public com.fyber.inneractive.sdk.player.ui.m l;
    public com.fyber.inneractive.sdk.player.controller.s m;
    public VideoContentListener n;
    public ViewGroup p;
    public v q;
    public m t;
    public final l o = new l(this);
    public float r = 0.0f;
    public final Rect s = new Rect();
    public boolean u = false;
    public final n v = new n(this);

    @Override // com.fyber.inneractive.sdk.interfaces.d
    public final void a(int i) {
    }

    @Override // com.fyber.inneractive.sdk.interfaces.d
    public final boolean b(View view) {
        return view.equals(this.p);
    }

    @Override // com.fyber.inneractive.sdk.interfaces.d
    public final int d() {
        return 0;
    }

    @Override // com.fyber.inneractive.sdk.flow.A, com.fyber.inneractive.sdk.external.InneractiveAdRenderer
    public final void destroy() {
        s();
        super.destroy();
    }

    @Override // com.fyber.inneractive.sdk.interfaces.d
    public final void l() {
        com.fyber.inneractive.sdk.player.controller.s sVar = this.m;
        if (sVar != null) {
            sVar.b(false);
        }
    }

    @Override // com.fyber.inneractive.sdk.interfaces.d
    public final int n() {
        return 0;
    }

    @Override // com.fyber.inneractive.sdk.interfaces.d
    public final void p() {
    }

    @Override // com.fyber.inneractive.sdk.external.InneractiveNativeVideoContentController.Renderer
    public final void pauseVideo() {
        com.fyber.inneractive.sdk.player.controller.s sVar = this.m;
        if (sVar != null) {
            sVar.u();
        }
    }

    @Override // com.fyber.inneractive.sdk.external.InneractiveNativeVideoContentController.Renderer
    public final void playVideo() {
        com.fyber.inneractive.sdk.player.controller.s sVar = this.m;
        if (sVar != null) {
            sVar.c(0);
        }
    }

    @Override // com.fyber.inneractive.sdk.interfaces.d
    public final void q() {
        com.fyber.inneractive.sdk.player.controller.q qVar;
        com.fyber.inneractive.sdk.player.controller.s sVar = this.m;
        if (sVar != null) {
            sVar.getClass();
            IAlog.a("%sfullscreenExited called", IAlog.a(sVar));
            sVar.D = false;
            sVar.h(sVar.C);
            com.fyber.inneractive.sdk.player.f fVar = sVar.f1971a;
            if (fVar == null || (qVar = fVar.f2210a) == null) {
                return;
            }
            sVar.a(qVar.e);
            sVar.a(sVar.f1971a.f2210a.b());
        }
    }

    @Override // com.fyber.inneractive.sdk.interfaces.d
    public final void s() {
        ViewGroup viewGroup;
        m mVar = this.t;
        if (mVar != null && (viewGroup = this.p) != null) {
            viewGroup.removeCallbacks(mVar);
            this.t = null;
        }
        L.f2347a.a(this.p);
        IAlog.a("%sunbind called. root is %s", IAlog.a(this), this.p);
        if (this.m != null) {
            IAlog.a("%sdestroying video ui controller", IAlog.a(this));
            com.fyber.inneractive.sdk.player.controller.s sVar = this.m;
            sVar.g = null;
            sVar.destroy();
            this.m = null;
        }
        if (this.l != null) {
            this.p.setLayoutTransition(null);
            this.p.removeView(this.k);
            this.l.destroy();
            this.l = null;
        }
    }

    @Override // com.fyber.inneractive.sdk.flow.A
    public final Context w() {
        return c(this.p);
    }

    @Override // com.fyber.inneractive.sdk.flow.A
    public final View x() {
        return this.k;
    }

    @Override // com.fyber.inneractive.sdk.interfaces.d
    public final boolean a(x xVar) {
        return xVar instanceof S;
    }

    @Override // com.fyber.inneractive.sdk.interfaces.d
    public final void a(ViewGroup viewGroup) {
        InneractiveAdSpot inneractiveAdSpot = this.f1772a;
        if (inneractiveAdSpot == null) {
            IAlog.f("%sYou must set the spot to render before calling renderAd", IAlog.a(this));
            return;
        }
        this.p = viewGroup;
        InneractiveUnitController selectedUnitController = inneractiveAdSpot.getSelectedUnitController();
        if (!(selectedUnitController instanceof InneractiveAdViewUnitController)) {
            IAlog.f("%sWrong type of unit controller found. Expecting InneractiveAdViewUnitController", IAlog.a(this));
        } else {
            InneractiveContentController selectedContentController = selectedUnitController.getSelectedContentController();
            if (selectedContentController != null) {
                if (selectedContentController instanceof InneractiveAdViewVideoContentController) {
                    this.n = (VideoContentListener) ((InneractiveAdViewVideoContentController) selectedContentController).getEventsListener();
                } else {
                    IAlog.f("%sContent controller expected to be InneractiveFullscreenVideoContentController and is %s", IAlog.a(this), selectedContentController.getClass().getSimpleName());
                }
            }
        }
        this.u = false;
        this.k = new FrameLayout(viewGroup.getContext());
        x xVar = this.b;
        com.fyber.inneractive.sdk.player.t tVar = xVar != null ? ((S) xVar).i : null;
        Context context = viewGroup.getContext();
        if (tVar != null) {
            ((com.fyber.inneractive.sdk.player.n) tVar.f).getClass();
            a aVar = new a(tVar);
            this.q = aVar;
            this.l = aVar.a(context, ((S) this.b).c);
            this.m = (com.fyber.inneractive.sdk.player.controller.s) this.q.a(this.f1772a, (S) this.b);
            this.p.addView(this.k, new ViewGroup.LayoutParams(-1, -2));
            this.p.setLayoutTransition(null);
            this.k.addView((View) this.l, new FrameLayout.LayoutParams(-2, -2, 17));
            com.fyber.inneractive.sdk.player.controller.s sVar = this.m;
            sVar.g = this.v;
            this.q.b();
            sVar.b(false);
            this.q.a(this.o);
            N n = L.f2347a;
            ViewGroup viewGroup2 = this.p;
            n.getClass();
            n.a(viewGroup2.getContext(), viewGroup2, this);
        }
    }

    @Override // com.fyber.inneractive.sdk.util.M
    public final void a(float f, Rect rect) {
        ViewGroup viewGroup;
        ViewGroup viewGroup2;
        if (this.r == f && this.s.equals(rect)) {
            return;
        }
        this.r = f;
        this.s.set(rect);
        com.fyber.inneractive.sdk.player.controller.s sVar = this.m;
        if (sVar != null) {
            sVar.C = false;
            ((com.fyber.inneractive.sdk.player.ui.e) this.l).d();
            this.m.a(f);
        }
        if (f > 0.0f) {
            m mVar = this.t;
            if (mVar != null && (viewGroup2 = this.p) != null) {
                viewGroup2.removeCallbacks(mVar);
                this.t = null;
            }
            m mVar2 = new m(this);
            this.t = mVar2;
            this.p.postDelayed(mVar2, 100L);
            return;
        }
        m mVar3 = this.t;
        if (mVar3 == null || (viewGroup = this.p) == null) {
            return;
        }
        viewGroup.removeCallbacks(mVar3);
        this.t = null;
    }
}
