package com.fyber.inneractive.sdk.flow.endcard;

import android.view.View;
import android.view.ViewGroup;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.flow.V;
import com.fyber.inneractive.sdk.network.C3146w;
import com.fyber.inneractive.sdk.network.EnumC3144u;
import com.fyber.inneractive.sdk.network.F;
import com.fyber.inneractive.sdk.util.AbstractC3256u;
import com.fyber.inneractive.sdk.util.EnumC3243g;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes.dex */
public final class d extends b {
    public d(V v) {
        super(v);
    }

    @Override // com.fyber.inneractive.sdk.flow.endcard.b
    public final void a(ViewGroup viewGroup, com.fyber.inneractive.sdk.player.ui.b bVar) {
        f fVar = (f) f();
        fVar.a(bVar, null);
        ViewGroup viewGroup2 = fVar.c;
        AbstractC3256u.a(viewGroup2);
        viewGroup.addView(viewGroup2);
        a(this.d, this.b);
    }

    @Override // com.fyber.inneractive.sdk.flow.endcard.b
    public final void a(F f) {
        throw null;
    }

    @Override // com.fyber.inneractive.sdk.flow.endcard.b
    public final k c() {
        return new f(this);
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0029  */
    @Override // com.fyber.inneractive.sdk.flow.endcard.b
    public final com.fyber.inneractive.sdk.player.ui.c d() {
        boolean z;
        V v = this.b;
        com.fyber.inneractive.sdk.config.global.features.w wVar = v.g;
        com.fyber.inneractive.sdk.config.global.features.i iVar = v.h;
        View viewB = f().b();
        com.fyber.inneractive.sdk.player.ui.c cVarD = super.d();
        cVarD.g = viewB;
        if (wVar == null) {
            z = false;
        } else {
            Boolean boolC = wVar.c("cta_text_all_caps");
            if (boolC != null ? boolC.booleanValue() : false) {
                z = true;
            } else {
                z = false;
            }
        }
        cVarD.c = z;
        boolean zB = b.b(wVar);
        Integer numValueOf = Integer.valueOf(b.a(wVar));
        if (zB) {
            cVarD.f = numValueOf;
        }
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
        if (iVar != null) {
            Boolean boolC2 = iVar.c("should_show_hand");
            cVarD.f2233a = boolC2 != null ? boolC2.booleanValue() : false;
            Double dA = iVar.a();
            float fDoubleValue = (float) (dA != null ? dA.doubleValue() : 1.2999999523162842d);
            if (fDoubleValue > 1.7f || fDoubleValue < 1.1f) {
                fDoubleValue = 1.3f;
            }
            cVarD.d = fDoubleValue;
        }
        return cVarD;
    }

    @Override // com.fyber.inneractive.sdk.flow.endcard.b
    public final EnumC3243g g() {
        return EnumC3243g.DEFAULT_ENDCARD;
    }

    @Override // com.fyber.inneractive.sdk.flow.endcard.b
    public final com.fyber.inneractive.sdk.model.vast.i h() {
        return com.fyber.inneractive.sdk.model.vast.i.Default_End_Card;
    }

    @Override // com.fyber.inneractive.sdk.flow.endcard.b
    public final boolean j() {
        return true;
    }

    public final void a(int i, V v) {
        EnumC3144u enumC3144u = EnumC3144u.VAST_DEFAULT_COMPANION_DISPLAYED;
        InneractiveAdRequest inneractiveAdRequest = v.c;
        com.fyber.inneractive.sdk.response.g gVar = v.d;
        JSONArray jSONArray = v.f;
        C3146w c3146w = new C3146w(gVar);
        c3146w.c = enumC3144u;
        c3146w.f1934a = inneractiveAdRequest;
        c3146w.d = jSONArray;
        c3146w.a((String) null);
    }
}
