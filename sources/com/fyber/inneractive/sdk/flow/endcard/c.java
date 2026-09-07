package com.fyber.inneractive.sdk.flow.endcard;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.external.InneractiveInfrastructureError;
import com.fyber.inneractive.sdk.flow.V;
import com.fyber.inneractive.sdk.network.C3146w;
import com.fyber.inneractive.sdk.network.EnumC3143t;
import com.fyber.inneractive.sdk.network.EnumC3144u;
import com.fyber.inneractive.sdk.util.AbstractC3256u;
import com.fyber.inneractive.sdk.util.EnumC3243g;
import com.fyber.inneractive.sdk.util.IAlog;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class c extends b implements com.fyber.inneractive.sdk.response.i {
    public final com.fyber.inneractive.sdk.model.vast.c e;

    public c(V v, com.fyber.inneractive.sdk.model.vast.c cVar) {
        super(v);
        this.e = cVar;
    }

    public final void a(int i, V v) {
        com.fyber.inneractive.sdk.player.n.a(this, com.fyber.inneractive.sdk.model.vast.x.EVENT_CREATIVE_VIEW);
        EnumC3144u enumC3144u = EnumC3144u.VAST_COMPANION_DISPLAYED;
        InneractiveAdRequest inneractiveAdRequest = v.c;
        com.fyber.inneractive.sdk.response.g gVar = v.d;
        JSONArray jSONArray = v.f;
        C3146w c3146w = new C3146w(gVar);
        c3146w.c = enumC3144u;
        c3146w.f1934a = inneractiveAdRequest;
        c3146w.d = jSONArray;
        c3146w.a("companion_data", this.e.a()).a((String) null);
    }

    @Override // com.fyber.inneractive.sdk.flow.endcard.b
    public final com.fyber.inneractive.sdk.player.ui.c d() {
        com.fyber.inneractive.sdk.config.global.features.w wVar = this.b.g;
        View viewB = f().b();
        com.fyber.inneractive.sdk.player.ui.c cVarD = super.d();
        cVarD.g = viewB;
        boolean z = false;
        if (wVar != null) {
            Boolean boolC = wVar.c("cta_text_all_caps");
            if (boolC != null ? boolC.booleanValue() : false) {
                z = true;
            }
        }
        cVarD.c = z;
        com.fyber.inneractive.sdk.config.global.features.v vVarE = wVar != null ? wVar.e() : com.fyber.inneractive.sdk.config.global.features.w.f;
        int i = 500;
        if (wVar != null) {
            Integer numA = wVar.a("endcard_animation_duration");
            int iIntValue = numA != null ? numA.intValue() : 500;
            if (iIntValue >= 500 && iIntValue <= 3000) {
                i = iIntValue;
            }
        }
        cVarD.i = vVarE;
        cVarD.j = i;
        boolean zB = b.b(wVar);
        Integer numValueOf = Integer.valueOf(b.a(wVar));
        if (zB) {
            cVarD.f = numValueOf;
        }
        return cVarD;
    }

    @Override // com.fyber.inneractive.sdk.flow.endcard.b
    public final void e() {
        a();
        View viewB = f().b();
        if (viewB != null) {
            viewB.setVisibility(8);
        }
    }

    @Override // com.fyber.inneractive.sdk.flow.endcard.b
    public final EnumC3243g g() {
        return EnumC3243g.VAST_ENDCARD;
    }

    @Override // com.fyber.inneractive.sdk.flow.endcard.b
    public final com.fyber.inneractive.sdk.model.vast.i h() {
        return this.e.f1875a;
    }

    @Override // com.fyber.inneractive.sdk.flow.endcard.b
    public boolean j() {
        return f().b() != null;
    }

    @Override // com.fyber.inneractive.sdk.flow.endcard.b
    public final void k() {
        super.k();
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObjectA = this.e.a();
        try {
            jSONObject.put("companion_data", jSONObjectA);
        } catch (Exception unused) {
            IAlog.f("Got exception adding param to json object: %s, %s", "companion_data", jSONObjectA);
        }
        V v = this.b;
        EnumC3144u enumC3144u = EnumC3144u.VAST_COMPANION_LOADED;
        InneractiveAdRequest inneractiveAdRequest = v.c;
        com.fyber.inneractive.sdk.response.g gVar = v.d;
        JSONArray jSONArray = v.f;
        C3146w c3146w = new C3146w(gVar);
        c3146w.c = enumC3144u;
        c3146w.f1934a = inneractiveAdRequest;
        c3146w.d = jSONArray;
        c3146w.f.put(jSONObject);
        c3146w.a((String) null);
    }

    public final void l() {
        V v = this.b;
        EnumC3144u enumC3144u = EnumC3144u.VAST_COMPANION_LOAD_ATTEMPT;
        InneractiveAdRequest inneractiveAdRequest = v.c;
        com.fyber.inneractive.sdk.response.g gVar = v.d;
        JSONArray jSONArray = v.f;
        C3146w c3146w = new C3146w(gVar);
        c3146w.c = enumC3144u;
        c3146w.f1934a = inneractiveAdRequest;
        c3146w.d = jSONArray;
        c3146w.a((String) null);
    }

    @Override // com.fyber.inneractive.sdk.flow.endcard.b
    public final void a(InneractiveInfrastructureError inneractiveInfrastructureError) {
        IAlog.a("%s loading failed for %s", inneractiveInfrastructureError.getCause(), h(), this.f1789a);
        EnumC3143t enumC3143t = EnumC3143t.VAST_COMPANION_FAILED_LOADING;
        if (inneractiveInfrastructureError.isErrorAlreadyReported(enumC3143t)) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObjectA = this.e.a();
        try {
            jSONObject.put("companion_data", jSONObjectA);
        } catch (Exception unused) {
            IAlog.f("Got exception adding param to json object: %s, %s", "companion_data", jSONObjectA);
        }
        Throwable cause = inneractiveInfrastructureError.getCause();
        String strDescription = inneractiveInfrastructureError.description();
        if (TextUtils.isEmpty(strDescription)) {
            if (cause == null) {
                strDescription = null;
            } else {
                do {
                    strDescription = cause.getMessage();
                    cause = cause.getCause();
                } while (cause != null);
            }
        }
        if (!TextUtils.isEmpty(strDescription)) {
            try {
                jSONObject.put("reason", inneractiveInfrastructureError);
            } catch (Exception unused2) {
                IAlog.f("Got exception adding param to json object: %s, %s", "reason", inneractiveInfrastructureError);
            }
        }
        V v = this.b;
        InneractiveAdRequest inneractiveAdRequest = v.c;
        com.fyber.inneractive.sdk.response.g gVar = v.d;
        JSONArray jSONArray = v.f;
        C3146w c3146w = new C3146w(gVar);
        c3146w.b = enumC3143t;
        c3146w.f1934a = inneractiveAdRequest;
        c3146w.d = jSONArray;
        c3146w.f.put(jSONObject);
        c3146w.a((String) null);
    }

    @Override // com.fyber.inneractive.sdk.flow.endcard.b
    public final void a(ViewGroup viewGroup, com.fyber.inneractive.sdk.player.ui.b bVar) {
        View viewB = f().b();
        if (viewB != null) {
            AbstractC3256u.a(viewB);
            viewGroup.addView(viewB);
            viewB.requestFocus();
            a(this.d, this.b);
        }
    }

    @Override // com.fyber.inneractive.sdk.response.i
    public final List a(com.fyber.inneractive.sdk.model.vast.x xVar) {
        return this.e.a(xVar);
    }
}
