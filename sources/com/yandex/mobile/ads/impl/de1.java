package com.yandex.mobile.ads.impl;

import javax.net.ssl.SSLSocketFactory;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class de1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f8686a;
    private final int b;
    private final SSLSocketFactory c;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof de1)) {
            return false;
        }
        de1 de1Var = (de1) obj;
        return this.f8686a == de1Var.f8686a && this.b == de1Var.b && Intrinsics.areEqual(this.c, de1Var.c);
    }

    public final int hashCode() {
        int iA = wx1.a(this.b, Integer.hashCode(this.f8686a) * 31, 31);
        SSLSocketFactory sSLSocketFactory = this.c;
        return iA + (sSLSocketFactory == null ? 0 : sSLSocketFactory.hashCode());
    }

    public final String toString() {
        return "OkHttpConfiguration(connectionTimeoutMs=" + this.f8686a + ", readTimeoutMs=" + this.b + ", sslSocketFactory=" + this.c + ")";
    }

    public de1(int i, int i2, SSLSocketFactory sSLSocketFactory) {
        this.f8686a = i;
        this.b = i2;
        this.c = sSLSocketFactory;
    }
}
