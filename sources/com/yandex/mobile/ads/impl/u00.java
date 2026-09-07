package com.yandex.mobile.ads.impl;

import java.util.List;
import javax.net.ssl.SSLSocket;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class u00 implements e12 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a f10344a;
    private e12 b;

    public interface a {
        boolean a(SSLSocket sSLSocket);

        xd b(SSLSocket sSLSocket);
    }

    public u00(wd socketAdapterFactory) {
        Intrinsics.checkNotNullParameter(socketAdapterFactory, "socketAdapterFactory");
        this.f10344a = socketAdapterFactory;
    }

    @Override // com.yandex.mobile.ads.impl.e12
    public final void a(SSLSocket sslSocket, String str, List<? extends im1> protocols) {
        e12 e12Var;
        Intrinsics.checkNotNullParameter(sslSocket, "sslSocket");
        Intrinsics.checkNotNullParameter(protocols, "protocols");
        synchronized (this) {
            if (this.b == null && this.f10344a.a(sslSocket)) {
                this.b = this.f10344a.b(sslSocket);
            }
            e12Var = this.b;
        }
        if (e12Var != null) {
            e12Var.a(sslSocket, str, protocols);
        }
    }

    @Override // com.yandex.mobile.ads.impl.e12
    public final boolean a() {
        return true;
    }

    @Override // com.yandex.mobile.ads.impl.e12
    public final String b(SSLSocket sslSocket) {
        e12 e12Var;
        Intrinsics.checkNotNullParameter(sslSocket, "sslSocket");
        synchronized (this) {
            if (this.b == null && this.f10344a.a(sslSocket)) {
                this.b = this.f10344a.b(sslSocket);
            }
            e12Var = this.b;
        }
        if (e12Var != null) {
            return e12Var.b(sslSocket);
        }
        return null;
    }

    @Override // com.yandex.mobile.ads.impl.e12
    public final boolean a(SSLSocket sslSocket) {
        Intrinsics.checkNotNullParameter(sslSocket, "sslSocket");
        return this.f10344a.a(sslSocket);
    }
}
