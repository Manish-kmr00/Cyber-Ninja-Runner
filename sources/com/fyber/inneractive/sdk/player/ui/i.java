package com.fyber.inneractive.sdk.player.ui;

import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.fyber.inneractive.sdk.config.U;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.flow.C3102g;
import com.fyber.inneractive.sdk.flow.S;
import com.fyber.inneractive.sdk.network.C3146w;
import com.fyber.inneractive.sdk.network.EnumC3143t;
import com.fyber.inneractive.sdk.network.EnumC3144u;
import com.fyber.inneractive.sdk.ui.IAsmoothProgressBar;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.i0;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public final class i extends t {
    public final o A;
    public p B;
    public final S C;

    /* JADX WARN: Code duplicated, block: B:60:0x00fa  */
    /* JADX WARN: Code duplicated, block: B:63:0x0139  */
    /* JADX WARN: Code duplicated, block: B:68:0x0147  */
    /* JADX WARN: Code duplicated, block: B:74:0x0156  */
    public i(Context context, a aVar, com.fyber.inneractive.sdk.player.n nVar, com.fyber.inneractive.sdk.config.global.r rVar, String str) {
        boolean zA;
        p pVar;
        IAsmoothProgressBar iAsmoothProgressBar;
        boolean z;
        String str2;
        Boolean boolValueOf;
        S s;
        S s2;
        super(context, rVar, null);
        this.C = null;
        this.C = nVar != null ? nVar.b : null;
        C3102g c3102g = (context == null || nVar == null || (s2 = nVar.b) == null) ? null : new C3102g(context, false, s2.f1840a, s2.b, rVar);
        if (nVar == null || (s = nVar.b) == null) {
            zA = false;
        } else {
            com.fyber.inneractive.sdk.response.e eVar = s.b;
            zA = com.fyber.inneractive.sdk.player.f.a(rVar, eVar != null ? ((com.fyber.inneractive.sdk.response.g) eVar).H : com.fyber.inneractive.sdk.ignite.m.NONE);
        }
        o oVar = new o(context, c3102g, aVar, rVar, zA, str);
        this.A = oVar;
        if (nVar != null) {
            com.fyber.inneractive.sdk.model.vast.b bVar = nVar.p;
            if (bVar == null || TextUtils.isEmpty(bVar.n)) {
                IAlog.a("%s : dynamic controls are not available", "IAVideoViewComposition");
            } else {
                com.fyber.inneractive.sdk.player.ui.remote.g gVar = nVar.u;
                if ((gVar != null ? gVar.f2246a : null) == null) {
                    IAlog.a("%s : dynamic controls are not available", "IAVideoViewComposition");
                } else {
                    com.fyber.inneractive.sdk.player.ui.remote.d dVar = gVar != null ? gVar.f2246a : null;
                    if (dVar.h) {
                        IAlog.a("%s : dynamic controls are already destroyed", "IAVideoViewComposition");
                    } else if (dVar.g) {
                        IAlog.a("%s : dynamic controls load process timed out", "IAVideoViewComposition");
                        com.fyber.inneractive.sdk.player.ui.remote.g gVar2 = nVar.u;
                        (gVar2 != null ? gVar2.f2246a : null).a(com.fyber.inneractive.sdk.network.events.b.TEMPLATE_LOAD_TIMEOUT, "Template loading is timed out", true, null);
                    } else if (dVar.b.j) {
                        pVar = new p(getContext().getApplicationContext(), aVar, dVar, oVar);
                    } else {
                        IAlog.a("%s : dynamic controls are not ready, yet", "IAVideoViewComposition");
                        com.fyber.inneractive.sdk.player.ui.remote.g gVar3 = nVar.u;
                        (gVar3 != null ? gVar3.f2246a : null).a(com.fyber.inneractive.sdk.network.events.b.TEMPLATE_ERROR, "Template isn't loaded yet", true, null);
                    }
                }
            }
            this.B = pVar;
            this.l = oVar.l;
            this.q = oVar.q;
            this.r = oVar.r;
            this.m = oVar.m;
            TextView textView = oVar.u;
            this.u = textView;
            a(textView, 10);
            a(this.m, 8);
            a(this.l, 7);
            a(this.q, -1);
            if (a()) {
                p pVar2 = this.B;
                iAsmoothProgressBar = oVar.Q;
                if (iAsmoothProgressBar == null && iAsmoothProgressBar.getVisibility() == 0) {
                    z = true;
                } else {
                    z = false;
                }
                f(z);
                ImageView imageView = oVar.O;
                d(imageView == null && imageView.getVisibility() == 0);
                oVar.g();
                attachViewToParent(pVar2, 0, new RelativeLayout.LayoutParams(-1, -1));
                EnumC3144u enumC3144u = EnumC3144u.VAST_EVENT_DVC_IMPRESSION;
                InneractiveAdRequest adRequest = getAdRequest();
                com.fyber.inneractive.sdk.response.e adResponse = getAdResponse();
                com.fyber.inneractive.sdk.player.ui.remote.d dVar2 = pVar2.N;
                str2 = dVar2.f;
                boolValueOf = Boolean.valueOf(dVar2.i);
                C3146w c3146w = new C3146w(enumC3144u, adRequest, adResponse);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("loaded_from_cache", boolValueOf);
                } catch (Exception unused) {
                    IAlog.f("Got exception adding param to json object: %s, %s", "loaded_from_cache", boolValueOf);
                }
                try {
                    jSONObject.put("templateURL", str2);
                } catch (Exception unused2) {
                    IAlog.f("Got exception adding param to json object: %s, %s", "templateURL", str2);
                }
                c3146w.f.put(jSONObject);
                c3146w.a((String) null);
            }
            View view = this.A;
            attachViewToParent(view, 0, view.getLayoutParams());
        }
        IAlog.a("%s : flow manager is missing, unexpected and dynamic controls status are unknown", "IAVideoViewComposition");
        com.fyber.inneractive.sdk.network.events.a.a(EnumC3143t.VAST_ERROR_DVC_FAILURE, com.fyber.inneractive.sdk.network.events.b.TEMPLATE_CONTENT_ERROR, getAdRequest(), getAdResponse(), "Missing flow manager", "", (Boolean) null);
        pVar = null;
        this.B = pVar;
        this.l = oVar.l;
        this.q = oVar.q;
        this.r = oVar.r;
        this.m = oVar.m;
        TextView textView2 = oVar.u;
        this.u = textView2;
        a(textView2, 10);
        a(this.m, 8);
        a(this.l, 7);
        a(this.q, -1);
        if (a()) {
            p pVar3 = this.B;
            iAsmoothProgressBar = oVar.Q;
            if (iAsmoothProgressBar == null) {
                z = false;
            } else {
                z = false;
            }
            f(z);
            ImageView imageView2 = oVar.O;
            d(imageView2 == null && imageView2.getVisibility() == 0);
            oVar.g();
            attachViewToParent(pVar3, 0, new RelativeLayout.LayoutParams(-1, -1));
            EnumC3144u enumC3144u2 = EnumC3144u.VAST_EVENT_DVC_IMPRESSION;
            InneractiveAdRequest adRequest2 = getAdRequest();
            com.fyber.inneractive.sdk.response.e adResponse2 = getAdResponse();
            com.fyber.inneractive.sdk.player.ui.remote.d dVar3 = pVar3.N;
            str2 = dVar3.f;
            boolValueOf = Boolean.valueOf(dVar3.i);
            C3146w c3146w2 = new C3146w(enumC3144u2, adRequest2, adResponse2);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("loaded_from_cache", boolValueOf);
            jSONObject2.put("templateURL", str2);
            c3146w2.f.put(jSONObject2);
            c3146w2.a((String) null);
        }
        View view2 = this.A;
        attachViewToParent(view2, 0, view2.getLayoutParams());
    }

    @Override // com.fyber.inneractive.sdk.player.ui.e, com.fyber.inneractive.sdk.player.ui.m
    public final boolean a() {
        p pVar = this.B;
        return pVar != null && pVar.a();
    }

    @Override // com.fyber.inneractive.sdk.player.ui.t
    public final void b(boolean z) {
        this.A.b(z);
        if (a(this.B)) {
            this.B.b(z);
        }
    }

    @Override // com.fyber.inneractive.sdk.player.ui.t
    public final void c(boolean z) {
        this.A.c(z);
        if (a(this.B)) {
            this.B.c(z);
        }
    }

    @Override // com.fyber.inneractive.sdk.player.ui.t
    public final void d(boolean z) {
        this.A.d(z);
        if (a(this.B)) {
            this.B.d(z);
        }
    }

    @Override // com.fyber.inneractive.sdk.player.ui.t, com.fyber.inneractive.sdk.player.ui.e, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(com.safedk.android.utils.h.p, this, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // com.fyber.inneractive.sdk.player.ui.t
    public final void e(boolean z) {
        if (a(this.B)) {
            this.B.e(z);
        } else {
            this.A.e(z);
        }
    }

    @Override // com.fyber.inneractive.sdk.player.ui.t
    public final void f(boolean z) {
        this.A.f(z);
        if (a(this.B)) {
            this.B.f(z);
        }
    }

    @Override // com.fyber.inneractive.sdk.player.ui.t
    public final void g(boolean z) {
        if (a(this.B)) {
            this.B.g(z);
        } else {
            this.A.g(z);
        }
    }

    public InneractiveAdRequest getAdRequest() {
        S s = this.C;
        if (s != null) {
            return s.f1840a;
        }
        return null;
    }

    public com.fyber.inneractive.sdk.response.e getAdResponse() {
        S s = this.C;
        if (s != null) {
            return s.b;
        }
        return null;
    }

    @Override // com.fyber.inneractive.sdk.player.ui.t
    public View getEndCardView() {
        return this.A.getEndCardView();
    }

    @Override // com.fyber.inneractive.sdk.player.ui.t
    public View[] getTrackingFriendlyView() {
        return a(this.B) ? this.B.getTrackingFriendlyView() : this.A.getTrackingFriendlyView();
    }

    @Override // com.fyber.inneractive.sdk.player.ui.t
    public View[] getTrackingFriendlyViewObstructionPurposeOther() {
        return a(this.B) ? this.B.getTrackingFriendlyViewObstructionPurposeOther() : this.A.getTrackingFriendlyViewObstructionPurposeOther();
    }

    @Override // com.fyber.inneractive.sdk.player.ui.t
    public final boolean i() {
        return a(this.B) ? this.B.N.n : this.A.i();
    }

    @Override // com.fyber.inneractive.sdk.player.ui.t
    public final void j() {
        this.A.j();
    }

    @Override // com.fyber.inneractive.sdk.player.ui.t
    public final void k() {
        this.A.k();
    }

    @Override // com.fyber.inneractive.sdk.player.ui.t
    public final boolean l() {
        return a(this.B) ? this.B.N.m : this.A.l();
    }

    @Override // com.fyber.inneractive.sdk.player.ui.t
    public final void m() {
        this.A.m();
    }

    @Override // com.fyber.inneractive.sdk.player.ui.t
    public final void n() {
        this.A.n();
    }

    @Override // com.fyber.inneractive.sdk.player.ui.t
    public final void o() {
        this.A.o();
        this.t = this.A.t;
    }

    @Override // com.fyber.inneractive.sdk.player.ui.t
    public void setAppInfoButtonRound(TextView textView) {
        this.A.setAppInfoButtonRound(textView);
    }

    @Override // com.fyber.inneractive.sdk.player.ui.e
    public void setListener(n nVar) {
        super.setListener(nVar);
        this.A.setListener(nVar);
        if (a(this.B)) {
            this.B.setListener(nVar);
        }
    }

    @Override // com.fyber.inneractive.sdk.player.ui.t
    public void setMuteButtonState(boolean z) {
        this.A.setMuteButtonState(z);
        if (a(this.B)) {
            this.B.setMuteButtonState(z);
        }
    }

    @Override // com.fyber.inneractive.sdk.player.ui.t
    public void setRemainingTime(String str) {
        this.A.setRemainingTime(str);
        if (a(this.B)) {
            this.B.setRemainingTime(str);
        }
    }

    @Override // com.fyber.inneractive.sdk.player.ui.t
    public void setSkipText(String str) {
        this.A.setSkipText(str);
        if (a(this.B)) {
            this.B.setSkipText(str);
        }
    }

    @Override // com.fyber.inneractive.sdk.player.ui.e
    public void setUnitConfig(U u) {
        super.setUnitConfig(u);
        this.A.setUnitConfig(u);
        if (a(this.B)) {
            this.B.setUnitConfig(u);
        }
    }

    @Override // com.fyber.inneractive.sdk.player.ui.t
    public final void a(com.fyber.inneractive.sdk.flow.endcard.d dVar, b bVar) {
        ViewGroup viewGroup;
        p pVar;
        this.A.a(dVar, bVar);
        if (!a(this.B) || (viewGroup = this.q) == null || viewGroup.getVisibility() != 0 || (pVar = this.B) == null) {
            return;
        }
        pVar.destroy();
        this.B = null;
    }

    @Override // com.fyber.inneractive.sdk.player.ui.t
    public final void f() {
        this.A.f();
        if (a(this.B)) {
            this.B.f();
        }
    }

    @Override // com.fyber.inneractive.sdk.player.ui.t
    public final void e() {
        o oVar = this.A;
        oVar.p();
        oVar.D = true;
    }

    @Override // com.fyber.inneractive.sdk.player.ui.t
    public final void g() {
        this.A.g();
        if (a(this.B)) {
            this.B.g();
        }
    }

    @Override // com.fyber.inneractive.sdk.player.ui.t
    public final void a(boolean z, com.fyber.inneractive.sdk.ignite.m mVar) {
        if (!a(this.B)) {
            this.A.a(z, mVar);
        } else {
            this.B.a(z, mVar);
        }
    }

    @Override // com.fyber.inneractive.sdk.player.ui.t
    public final void a(boolean z, String str) {
        this.A.a(z, str);
        if (a(this.B)) {
            this.B.a(z, str);
        }
    }

    @Override // com.fyber.inneractive.sdk.player.ui.t
    public final void a(boolean z, int i, int i2) {
        this.n = i;
        this.o = i2;
        this.p = z;
        o oVar = this.A;
        oVar.n = i;
        oVar.o = i2;
        oVar.p = z;
    }

    @Override // com.fyber.inneractive.sdk.player.ui.t
    public final void a(com.fyber.inneractive.sdk.flow.endcard.b bVar, b bVar2) {
        this.A.a(bVar, bVar2);
        p pVar = this.B;
        if (pVar != null) {
            pVar.destroy();
            this.B = null;
        }
    }

    @Override // com.fyber.inneractive.sdk.player.ui.t
    public final void a(boolean z) {
        if (a(this.B)) {
            this.B.a(z);
        } else {
            this.A.a(z);
        }
    }

    @Override // com.fyber.inneractive.sdk.player.ui.t
    public final void a(int i, int i2) {
        this.A.a(i, i2);
        if (a(this.B)) {
            this.B.a(i, i2);
        }
    }

    @Override // com.fyber.inneractive.sdk.player.ui.e
    public final void a(i0 i0Var, int i, int i2) {
        this.A.a(i0Var, i, i2);
    }

    public static boolean a(p pVar) {
        return (pVar == null || pVar.N.h || !pVar.a()) ? false : true;
    }
}
