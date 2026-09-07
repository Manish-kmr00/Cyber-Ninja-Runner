package com.yandex.mobile.ads.impl;

import com.json.mediationsdk.logger.IronSourceError;
import java.net.InetSocketAddress;
import java.net.Proxy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class os1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ab f9854a;
    private final Proxy b;
    private final InetSocketAddress c;

    public os1(ab address, Proxy proxy, InetSocketAddress socketAddress) {
        Intrinsics.checkNotNullParameter(address, "address");
        Intrinsics.checkNotNullParameter(proxy, "proxy");
        Intrinsics.checkNotNullParameter(socketAddress, "socketAddress");
        this.f9854a = address;
        this.b = proxy;
        this.c = socketAddress;
    }

    public final ab a() {
        return this.f9854a;
    }

    public final Proxy b() {
        return this.b;
    }

    public final InetSocketAddress d() {
        return this.c;
    }

    public final boolean c() {
        return this.f9854a.j() != null && this.b.type() == Proxy.Type.HTTP;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof os1) {
            os1 os1Var = (os1) obj;
            if (Intrinsics.areEqual(os1Var.f9854a, this.f9854a) && Intrinsics.areEqual(os1Var.b, this.b) && Intrinsics.areEqual(os1Var.c, this.c)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.c.hashCode() + ((this.b.hashCode() + ((this.f9854a.hashCode() + IronSourceError.ERROR_NON_EXISTENT_INSTANCE) * 31)) * 31);
    }

    public final String toString() {
        return "Route{" + this.c + "}";
    }
}
