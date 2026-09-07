package com.fyber.inneractive.sdk.flow.endcard;

import android.text.TextUtils;
import com.fyber.inneractive.sdk.flow.V;
import com.fyber.inneractive.sdk.network.F;
import com.fyber.inneractive.sdk.player.controller.C3153d;
import com.fyber.inneractive.sdk.util.AbstractC3251o;
import com.fyber.inneractive.sdk.util.AbstractC3257v;
import com.fyber.inneractive.sdk.util.EnumC3259x;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.web.j0;

/* JADX INFO: loaded from: classes2.dex */
public final class x extends c {
    public x(V v, com.fyber.inneractive.sdk.model.vast.c cVar) {
        super(v, cVar);
    }

    @Override // com.fyber.inneractive.sdk.flow.endcard.b
    public final void a(F f) {
        com.fyber.inneractive.sdk.model.vast.c cVar = this.e;
        boolean zContainsKey = false;
        if (cVar.f1875a != com.fyber.inneractive.sdk.model.vast.i.Static) {
            String str = cVar.f;
            int i = AbstractC3257v.f2379a[EnumC3259x.Mraid.ordinal()];
            if (i == 1) {
                zContainsKey = com.fyber.inneractive.sdk.factories.d.f1768a.f1769a.containsKey(com.fyber.inneractive.sdk.response.a.RETURNED_ADTYPE_HTML);
            } else if (i == 2) {
                zContainsKey = com.fyber.inneractive.sdk.factories.d.f1768a.f1769a.containsKey(com.fyber.inneractive.sdk.response.a.RETURNED_ADTYPE_VAST);
            }
            if (!zContainsKey) {
                IAlog.f("%s MRAID required", this.f1789a);
                return;
            }
            l();
            String strB = AbstractC3251o.b("fyb_iframe_endcard_tmpl.html");
            if (!TextUtils.isEmpty(strB)) {
                strB = strB.replace("$__SrcIframeUrl__$", str);
            }
            s sVar = (s) f();
            sVar.e = strB;
            sVar.e();
            return;
        }
        String str2 = cVar.f;
        String str3 = cVar.g;
        if (TextUtils.isEmpty(str3)) {
            com.fyber.inneractive.sdk.model.vast.b bVar = this.b.d.N;
            str3 = bVar != null ? bVar.b : null;
        }
        l();
        String strB2 = AbstractC3251o.b("fyb_static_endcard_tmpl.html");
        if (!TextUtils.isEmpty(strB2)) {
            strB2 = strB2.replace("$__IMGSRC__$", str2);
            if (str3 != null) {
                strB2 = strB2.replace("$__IMGHREF__$", str3.replace("\"", "\\\""));
            }
        }
        s sVar2 = (s) f();
        sVar2.e = strB2;
        if (TextUtils.isEmpty(strB2)) {
            throw new com.fyber.inneractive.sdk.flow.vast.h("End-Card HTML not loaded", "No template");
        }
        C3153d c3153dD = sVar2.d();
        c3153dD.a();
        j0 j0Var = c3153dD.f1954a;
        if (j0Var != null) {
            j0Var.F = false;
        }
        c3153dD.a(strB2, sVar2.g, !(sVar2 instanceof o));
    }

    @Override // com.fyber.inneractive.sdk.flow.endcard.b
    public final k c() {
        return new s(this);
    }
}
