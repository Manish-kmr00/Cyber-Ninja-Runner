package com.fyber.inneractive.sdk.network;

import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.util.AbstractC3256u;
import com.fyber.inneractive.sdk.util.IAlog;
import java.io.InputStream;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes6.dex */
public final class Z extends U {
    public final String p;
    public final AtomicInteger q;

    public Z(E e, String str) {
        super(e, G.c.a(), null);
        this.q = new AtomicInteger();
        this.p = str;
    }

    public static void b(String str) {
        IAConfigManager.O.s.b(new Z(new Y(str, System.currentTimeMillis()), str));
    }

    @Override // com.fyber.inneractive.sdk.network.U
    public final O a(C3136l c3136l, Map map, int i) throws N {
        try {
            O o = new O();
            o.f1911a = String.valueOf(i);
            InputStream inputStream = c3136l.c;
            if (inputStream != null) {
                o.b = AbstractC3256u.a(inputStream).toString();
            }
            return o;
        } catch (Exception e) {
            IAlog.a("failed parse hit network request", e, new Object[0]);
            throw new N(e);
        }
    }

    @Override // com.fyber.inneractive.sdk.network.U
    public final int e() {
        return ((int) Math.pow(2.0d, this.q.get())) * 1000;
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
        return this.q.getAndIncrement() < 4;
    }
}
