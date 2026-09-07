package com.fyber.inneractive.sdk.network;

import com.fyber.inneractive.sdk.util.AbstractC3256u;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: loaded from: classes13.dex */
public final class h0 extends U {
    public final String p;

    public h0(E e, String str) {
        super(e, G.c.a(), null);
        this.p = str;
    }

    @Override // com.fyber.inneractive.sdk.network.U
    public final O a(C3136l c3136l, Map map, int i) {
        O o = new O();
        com.fyber.inneractive.sdk.click.c cVar = new com.fyber.inneractive.sdk.click.c();
        if (c3136l != null) {
            ArrayList arrayList = c3136l.f;
            cVar.f1654a.clear();
            cVar.f1654a.addAll(arrayList);
            InputStream inputStream = c3136l.c;
            if (inputStream != null) {
                String string = AbstractC3256u.a(inputStream).toString();
                cVar.b = string;
                o.b = string;
            }
        }
        o.f1911a = cVar;
        return o;
    }

    @Override // com.fyber.inneractive.sdk.network.U
    public final int e() {
        return 0;
    }

    @Override // com.fyber.inneractive.sdk.network.U
    public final M k() {
        return M.GET;
    }

    @Override // com.fyber.inneractive.sdk.network.U
    public final g0 m() {
        return g0.LOW;
    }

    @Override // com.fyber.inneractive.sdk.network.U
    public final String p() {
        return this.p;
    }

    @Override // com.fyber.inneractive.sdk.network.U
    public final boolean s() {
        return false;
    }
}
