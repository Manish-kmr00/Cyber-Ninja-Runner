package com.yandex.mobile.ads.impl;

import javax.net.ssl.SSLSocketFactory;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class wu1 implements qv.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f10595a;
    private final SSLSocketFactory b;
    private final boolean c;

    public wu1(String userAgent, SSLSocketFactory sSLSocketFactory, boolean z) {
        Intrinsics.checkNotNullParameter(userAgent, "userAgent");
        this.f10595a = userAgent;
        this.b = sSLSocketFactory;
        this.c = z;
    }

    @Override // com.yandex.mobile.ads.impl.qv.a
    public final qv a() {
        if (this.c) {
            int i = ce1.c;
            return new fe1(ce1.a(8000, 8000, this.b), this.f10595a, new rh0());
        }
        return new tu1(this.f10595a, new rh0(), this.b);
    }
}
