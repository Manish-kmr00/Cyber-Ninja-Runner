package com.fyber.inneractive.sdk.flow.endcard;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.external.InneractiveInfrastructureError;
import com.fyber.inneractive.sdk.flow.V;
import com.fyber.inneractive.sdk.network.C3146w;
import com.fyber.inneractive.sdk.network.EnumC3143t;
import com.fyber.inneractive.sdk.network.EnumC3144u;
import com.fyber.inneractive.sdk.network.F;
import com.fyber.inneractive.sdk.network.L;
import com.fyber.inneractive.sdk.network.c0;
import com.fyber.inneractive.sdk.util.AbstractC3256u;
import com.fyber.inneractive.sdk.util.EnumC3243g;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.web.C3262a;
import com.fyber.inneractive.sdk.web.C3263b;
import com.fyber.inneractive.sdk.web.j0;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class n extends b {
    public final String e;
    public C3262a f;
    public F g;
    public final ArrayList h;

    public n(V v, String str) {
        super(v);
        this.f = new C3262a(null, 0);
        this.h = new ArrayList();
        this.e = str;
    }

    @Override // com.fyber.inneractive.sdk.flow.endcard.b
    public final void a(F f) {
        Context context = this.b.f1783a;
        this.g = f;
        String str = this.e;
        if (!TextUtils.isEmpty(str)) {
            IAlog.c("%s load FMP End-Card HTML %s", this.f1789a, "COMPANION_TYPE");
            ((L) f).b(new com.fyber.inneractive.sdk.network.V(new m(this, (o) f()), context, new com.fyber.inneractive.sdk.cache.c(str)));
        }
        ((o) f()).j = null;
        com.fyber.inneractive.sdk.model.vast.o oVar = this.b.e.f;
        if (oVar == null) {
            throw new com.fyber.inneractive.sdk.flow.vast.h("ErrorNoMediaFiles", "assets required");
        }
        for (String str2 : oVar.b) {
            if (!TextUtils.isEmpty(str2)) {
                IAlog.c("%s load FMP End-Card icon %s", this.f1789a, str2);
                c0 c0Var = new c0(new l(this, (o) f()), str2, this.b.b.c);
                this.h.add(c0Var.g);
                ((L) f).b(c0Var);
            }
        }
    }

    @Override // com.fyber.inneractive.sdk.flow.endcard.b
    public final k c() {
        return new o(this);
    }

    @Override // com.fyber.inneractive.sdk.flow.endcard.b
    public final com.fyber.inneractive.sdk.player.ui.c d() {
        View viewB = f().b();
        com.fyber.inneractive.sdk.player.ui.c cVarD = super.d();
        cVarD.g = viewB;
        return cVarD;
    }

    @Override // com.fyber.inneractive.sdk.flow.endcard.b, com.fyber.inneractive.sdk.flow.endcard.k
    public final void destroy() {
        super.destroy();
        if (this.g != null) {
            for (String str : this.h) {
                this.g.getClass();
            }
        }
        this.h.clear();
    }

    @Override // com.fyber.inneractive.sdk.flow.endcard.b
    public final EnumC3243g g() {
        C3262a c3262a = this.f;
        EnumC3243g enumC3243g = EnumC3243g.FMP_ENDCARD;
        enumC3243g.a(c3262a.f2400a);
        enumC3243g.a(c3262a.b);
        return enumC3243g;
    }

    @Override // com.fyber.inneractive.sdk.flow.endcard.b
    public final com.fyber.inneractive.sdk.model.vast.i h() {
        return com.fyber.inneractive.sdk.model.vast.i.FMP_End_Card;
    }

    @Override // com.fyber.inneractive.sdk.flow.endcard.b
    public final boolean i() {
        return this.d > 1;
    }

    @Override // com.fyber.inneractive.sdk.flow.endcard.b
    public final boolean j() {
        o oVar = (o) f();
        return oVar.f && oVar.b() != null;
    }

    @Override // com.fyber.inneractive.sdk.flow.endcard.b
    public final void a(ViewGroup viewGroup, com.fyber.inneractive.sdk.player.ui.b bVar) {
        o oVar = (o) f();
        View viewB = oVar.b();
        if (viewB != null) {
            AbstractC3256u.a(viewB);
            viewGroup.addView(viewB);
            j0 j0Var = oVar.d().f1954a;
            if (j0Var != null) {
                j0Var.a(true);
            }
        }
        a(this.d, this.b);
    }

    @Override // com.fyber.inneractive.sdk.flow.endcard.b
    public final void a(InneractiveInfrastructureError inneractiveInfrastructureError) {
        if (inneractiveInfrastructureError.isErrorAlreadyReported(EnumC3143t.FMP_COMPANION_FAILED_LOADING)) {
            return;
        }
        a(inneractiveInfrastructureError.getCause(), false);
    }

    public final void a(Throwable th, boolean z) {
        String message;
        p pVar;
        IAlog.a("%s sending FMP_COMPANION_FAILED_LOADING event", this.f1789a);
        JSONObject jSONObject = new JSONObject();
        if (th == null) {
            message = null;
        } else {
            do {
                message = th.getMessage();
                th = th.getCause();
            } while (th != null);
        }
        if (!TextUtils.isEmpty(message)) {
            try {
                jSONObject.put("error", message);
            } catch (Exception unused) {
                IAlog.f("Got exception adding param to json object: %s, %s", "error", message);
            }
        }
        C3263b c3263b = (C3263b) ((o) f()).d().f1954a;
        String str = (c3263b == null || (pVar = c3263b.N) == null) ? null : pVar.c;
        if (!TextUtils.isEmpty(str)) {
            try {
                jSONObject.put("version", str);
            } catch (Exception unused2) {
                IAlog.f("Got exception adding param to json object: %s, %s", "version", str);
            }
        }
        Boolean boolValueOf = Boolean.valueOf(z);
        try {
            jSONObject.put("loaded_from_cache", boolValueOf);
        } catch (Exception unused3) {
            IAlog.f("Got exception adding param to json object: %s, %s", "loaded_from_cache", boolValueOf);
        }
        V v = this.b;
        EnumC3143t enumC3143t = EnumC3143t.FMP_COMPANION_FAILED_LOADING;
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

    public final void a(int i, V v) {
        p pVar;
        C3263b c3263b = (C3263b) ((o) f()).d().f1954a;
        String str = (c3263b == null || (pVar = c3263b.N) == null) ? null : pVar.c;
        this.f = new C3262a(str, i);
        JSONObject jSONObject = new JSONObject();
        if (!TextUtils.isEmpty(str)) {
            try {
                jSONObject.put("version", str);
            } catch (Exception unused) {
                IAlog.f("Got exception adding param to json object: %s, %s", "version", str);
            }
        }
        Boolean boolValueOf = Boolean.valueOf(((o) f()).k);
        try {
            jSONObject.put("loaded_from_cache", boolValueOf);
        } catch (Exception unused2) {
            IAlog.f("Got exception adding param to json object: %s, %s", "loaded_from_cache", boolValueOf);
        }
        EnumC3144u enumC3144u = EnumC3144u.FMP_COMPANION_SUCCESSFULLY_SHOWN;
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
}
