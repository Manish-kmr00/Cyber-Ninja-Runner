package com.fyber.inneractive.sdk.network.timeouts.request;

import com.fyber.inneractive.sdk.config.global.features.k;

/* JADX INFO: loaded from: classes6.dex */
public abstract class a extends com.fyber.inneractive.sdk.network.timeouts.a {
    public int h;
    public int i;
    public int j;
    public int k;
    public final String l;

    public a(String str, k kVar, String str2) {
        this.l = str2;
        d(kVar, str);
    }

    public int a(int i) {
        return 0;
    }

    public abstract int a(k kVar);

    public abstract int a(k kVar, String str);

    public int b() {
        return 0;
    }

    public abstract int b(k kVar, String str);

    public int c() {
        return 0;
    }

    public abstract int c(k kVar, String str);

    public void d(k kVar, String str) {
        int iB = b(kVar, "read");
        int iB2 = b(kVar, "conn");
        int iA = a(kVar, str);
        this.f = a(kVar);
        this.j = c(kVar, "read");
        int iC = c(kVar, "conn");
        this.k = iC;
        int i = (this.j * iA) / 100;
        this.h = i;
        this.i = (iA * iC) / 100;
        this.h = Math.max(iB, i);
        this.i = Math.max(iB2, this.i);
    }
}
