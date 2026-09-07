package com.fyber.inneractive.sdk.flow.endcard;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.flow.S;
import com.fyber.inneractive.sdk.flow.V;
import com.fyber.inneractive.sdk.player.controller.C3153d;
import com.fyber.inneractive.sdk.util.AbstractC3256u;
import com.fyber.inneractive.sdk.web.C3274m;
import com.fyber.inneractive.sdk.web.j0;

/* JADX INFO: loaded from: classes.dex */
public class s extends a {
    public final com.fyber.inneractive.sdk.flow.vast.a c;
    public C3153d d;
    public String e;
    public boolean f;
    public final r g;
    public ViewGroup h;

    public s(b bVar) {
        super(bVar);
        this.f = false;
        this.g = new r(this);
        V v = bVar.b;
        S s = v.b;
        InneractiveAdRequest inneractiveAdRequest = v.c;
        com.fyber.inneractive.sdk.response.g gVar = v.d;
        this.c = new com.fyber.inneractive.sdk.flow.vast.a(gVar.p, inneractiveAdRequest == null || inneractiveAdRequest.getAllowFullscreen(), gVar.e, gVar.f, s.d);
    }

    @Override // com.fyber.inneractive.sdk.flow.endcard.a, com.fyber.inneractive.sdk.flow.endcard.k
    public final void a() {
        AbstractC3256u.a(b());
        j0 j0Var = d().f1954a;
        if (j0Var != null) {
            j0Var.a(false);
        }
    }

    @Override // com.fyber.inneractive.sdk.flow.endcard.k
    public final View b() {
        ViewGroup viewGroup = this.h;
        if (viewGroup != null) {
            return viewGroup;
        }
        if (!this.f) {
            return null;
        }
        j0 j0Var = d().f1954a;
        C3274m c3274m = j0Var == null ? null : j0Var.b;
        if (c3274m == null) {
            return null;
        }
        ViewGroup viewGroupA = a.a(c3274m);
        this.h = viewGroupA;
        return viewGroupA;
    }

    public p c() {
        return null;
    }

    public final C3153d d() {
        C3153d c3153d = this.d;
        if (c3153d == null) {
            b bVar = this.b;
            c3153d = new C3153d(bVar.b.f1783a, this.c, bVar.h(), c());
            V v = this.b.b;
            j0 j0Var = c3153d.f1954a;
            if (j0Var != null) {
                if (j0Var.s == null) {
                    j0Var.setAdContent(v.b);
                }
                if (j0Var.r == null) {
                    j0Var.setAdRequest(v.c);
                }
                if (j0Var.t == null) {
                    j0Var.setAdResponse(v.d);
                }
            }
            this.d = c3153d;
        }
        return c3153d;
    }

    @Override // com.fyber.inneractive.sdk.flow.endcard.a, com.fyber.inneractive.sdk.flow.endcard.k
    public final void destroy() {
        a();
        C3153d c3153dD = d();
        j0 j0Var = c3153dD.f1954a;
        if (j0Var != null) {
            j0Var.e();
            c3153dD.f1954a = null;
        }
    }

    public void e() {
        String str = this.e;
        if (TextUtils.isEmpty(str)) {
            throw new com.fyber.inneractive.sdk.flow.vast.h("End-Card HTML not loaded", "No template");
        }
        C3153d c3153dD = d();
        j0 j0Var = c3153dD.f1954a;
        if (j0Var != null) {
            UnitDisplayType unitDisplayType = c3153dD.c;
            if (!UnitDisplayType.INTERSTITIAL.equals(unitDisplayType) && !UnitDisplayType.REWARDED.equals(unitDisplayType)) {
                UnitDisplayType.VERTICAL.equals(unitDisplayType);
            }
            j0Var.l();
        }
        c3153dD.a(str, this.g, !(this instanceof o));
    }
}
