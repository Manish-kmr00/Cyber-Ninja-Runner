package com.fyber.inneractive.sdk.network;

import com.fyber.inneractive.sdk.util.IAlog;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes6.dex */
public final class X extends U {
    public final String p;
    public final String q;
    public final AtomicInteger r;

    public X(C3129e c3129e, String str, String str2) {
        super(c3129e, G.c.a(), null);
        this.r = new AtomicInteger();
        this.q = str;
        this.p = str2;
    }

    @Override // com.fyber.inneractive.sdk.network.U
    public final O a(C3136l c3136l, Map map, int i) throws N {
        try {
            O o = new O();
            o.f1911a = String.valueOf(i);
            return o;
        } catch (Exception e) {
            IAlog.a("failed parse event network request", e, new Object[0]);
            throw new N(e);
        }
    }

    @Override // com.fyber.inneractive.sdk.network.U
    public final byte[] d() {
        byte[] bArr = new byte[0];
        try {
            IAlog.a("NetworkRequestEvent: network request body %s", this.p);
            return this.p.getBytes(StandardCharsets.UTF_8);
        } catch (Exception unused) {
            return bArr;
        }
    }

    @Override // com.fyber.inneractive.sdk.network.U
    public final int e() {
        return ((int) Math.pow(2.0d, this.r.get())) * 1000;
    }

    @Override // com.fyber.inneractive.sdk.network.U
    public final M k() {
        return M.POST;
    }

    @Override // com.fyber.inneractive.sdk.network.U
    public final g0 m() {
        return g0.LOW;
    }

    @Override // com.fyber.inneractive.sdk.network.U
    public final String p() {
        return this.q;
    }

    @Override // com.fyber.inneractive.sdk.network.U
    public final boolean s() {
        return this.r.getAndIncrement() < 4;
    }
}
