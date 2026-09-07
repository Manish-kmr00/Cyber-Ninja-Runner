package com.fyber.inneractive.sdk.network.timeouts.request;

import com.fyber.inneractive.sdk.config.global.features.k;

/* JADX INFO: loaded from: classes6.dex */
public final class b extends a {
    public b(k kVar, String str) {
        super(str, kVar, null);
    }

    @Override // com.fyber.inneractive.sdk.network.timeouts.request.a
    public final int a(k kVar, String str) {
        kVar.getClass();
        String str2 = str + "_global_timeout";
        int i = k.d(str) ? 30000 : 10000;
        Integer numA = kVar.a(str2);
        return numA != null ? numA.intValue() : i;
    }

    @Override // com.fyber.inneractive.sdk.network.timeouts.request.a
    public final int b(k kVar, String str) {
        kVar.getClass();
        String strA = k.a(str, "min", "rat");
        "read".equalsIgnoreCase(str);
        Integer numA = kVar.a(strA);
        if (numA != null) {
            return numA.intValue();
        }
        return 5000;
    }

    @Override // com.fyber.inneractive.sdk.network.timeouts.request.a
    public final int c(k kVar, String str) {
        kVar.getClass();
        String strA = k.a(str, "rat_perc");
        int i = "read".equalsIgnoreCase(str) ? 15 : 10;
        Integer numA = kVar.a(strA);
        return numA != null ? numA.intValue() : i;
    }

    @Override // com.fyber.inneractive.sdk.network.timeouts.request.a
    public final int a(k kVar) {
        kVar.getClass();
        Integer numA = kVar.a(k.a("timeout", "threshold"));
        if (numA != null) {
            return numA.intValue();
        }
        return 300;
    }
}
