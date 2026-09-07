package com.fyber.inneractive.sdk.mraid;

import com.fyber.inneractive.sdk.util.AbstractC3251o;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.h0;
import com.fyber.inneractive.sdk.web.I;
import com.fyber.inneractive.sdk.web.k0;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes11.dex */
public final class q extends AbstractC3122e {
    public q(LinkedHashMap linkedHashMap, I i, h0 h0Var) {
        super(linkedHashMap, i, h0Var);
    }

    @Override // com.fyber.inneractive.sdk.mraid.AbstractC3123f
    public final void a() {
        com.fyber.inneractive.sdk.util.D d;
        String str = (String) this.b.get("url");
        IAlog.e("IAmraidActionOpen: opening Internal Browser For Url: %s", str);
        I i = this.c;
        if (i != null) {
            h0 h0Var = this.d;
            k0 k0Var = i.g;
            if (k0Var != null) {
                d = ((com.fyber.inneractive.sdk.web.B) k0Var).a(str, h0Var);
            } else {
                com.fyber.inneractive.sdk.util.G g = com.fyber.inneractive.sdk.util.G.FAILED;
                Exception exc = new Exception("No webview listener available");
                if (AbstractC3251o.a(i.b) != null) {
                    AbstractC3251o.a(i.b).getClass();
                }
                d = new com.fyber.inneractive.sdk.util.D(g, exc);
            }
            if (d.f2344a == com.fyber.inneractive.sdk.util.G.FAILED) {
                I i2 = this.c;
                k kVar = k.OPEN;
                Throwable th = d.b;
                i2.a(kVar, th == null ? "unknown error" : th.getMessage());
            }
        }
    }

    @Override // com.fyber.inneractive.sdk.mraid.AbstractC3122e
    public final String c() {
        return (String) this.b.get("url");
    }

    @Override // com.fyber.inneractive.sdk.mraid.AbstractC3122e
    public final void d() {
        I i = this.c;
        if (i != null) {
            i.a(k.OPEN, "No native click was detected in a timely fashion");
        }
    }
}
