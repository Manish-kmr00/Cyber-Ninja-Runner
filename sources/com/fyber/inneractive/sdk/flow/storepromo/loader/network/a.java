package com.fyber.inneractive.sdk.flow.storepromo.loader.network;

import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.network.C3136l;
import com.fyber.inneractive.sdk.network.O;
import com.fyber.inneractive.sdk.network.U;
import com.fyber.inneractive.sdk.network.c0;
import java.util.Map;

/* JADX INFO: loaded from: classes13.dex */
public final class a extends c0 {
    public int q;

    public a(String str, com.fyber.inneractive.sdk.flow.storepromo.loader.network.callbacks.b bVar) {
        super(bVar, str, null);
    }

    @Override // com.fyber.inneractive.sdk.network.c0, com.fyber.inneractive.sdk.network.U
    public final O a(C3136l c3136l, Map map, int i) throws com.fyber.inneractive.sdk.flow.storepromo.loader.network.exception.a {
        int iA;
        int iA2 = IAConfigManager.O.u.b.a("sp_max_size", 307200, 0);
        this.q = iA2;
        int i2 = iA2 + 10;
        if (c3136l != null && (iA = U.a(c3136l.d)) >= 0) {
            i2 = iA;
        }
        long j = i2;
        int i3 = this.q;
        if (j <= i3) {
            return super.a(c3136l, map, i);
        }
        throw new com.fyber.inneractive.sdk.flow.storepromo.loader.network.exception.a("The image exceeds the maximal size: " + i3 + ", actual size: " + i2);
    }
}
