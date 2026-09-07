package com.yandex.mobile.ads.impl;

import com.json.mediationsdk.logger.IronSourceError;
import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import java.util.Objects;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class ab {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final n30 f8387a;
    private final SocketFactory b;
    private final SSLSocketFactory c;
    private final HostnameVerifier d;
    private final eo e;
    private final bi f;
    private final Proxy g;
    private final ProxySelector h;
    private final di0 i;
    private final List<im1> j;
    private final List<or> k;

    public ab(String uriHost, int i, n30 dns, SocketFactory socketFactory, SSLSocketFactory sSLSocketFactory, ae1 ae1Var, eo eoVar, bi proxyAuthenticator, List protocols, List connectionSpecs, ProxySelector proxySelector) {
        Intrinsics.checkNotNullParameter(uriHost, "uriHost");
        Intrinsics.checkNotNullParameter(dns, "dns");
        Intrinsics.checkNotNullParameter(socketFactory, "socketFactory");
        Intrinsics.checkNotNullParameter(proxyAuthenticator, "proxyAuthenticator");
        Intrinsics.checkNotNullParameter(protocols, "protocols");
        Intrinsics.checkNotNullParameter(connectionSpecs, "connectionSpecs");
        Intrinsics.checkNotNullParameter(proxySelector, "proxySelector");
        this.f8387a = dns;
        this.b = socketFactory;
        this.c = sSLSocketFactory;
        this.d = ae1Var;
        this.e = eoVar;
        this.f = proxyAuthenticator;
        this.g = null;
        this.h = proxySelector;
        this.i = new di0.a().c(sSLSocketFactory != null ? "https" : "http").b(uriHost).a(i).a();
        this.j = y82.b(protocols);
        this.k = y82.b(connectionSpecs);
    }

    public final n30 c() {
        return this.f8387a;
    }

    public final SocketFactory i() {
        return this.b;
    }

    public final SSLSocketFactory j() {
        return this.c;
    }

    public final HostnameVerifier d() {
        return this.d;
    }

    public final eo a() {
        return this.e;
    }

    public final boolean a(ab that) {
        Intrinsics.checkNotNullParameter(that, "that");
        return Intrinsics.areEqual(this.f8387a, that.f8387a) && Intrinsics.areEqual(this.f, that.f) && Intrinsics.areEqual(this.j, that.j) && Intrinsics.areEqual(this.k, that.k) && Intrinsics.areEqual(this.h, that.h) && Intrinsics.areEqual(this.g, that.g) && Intrinsics.areEqual(this.c, that.c) && Intrinsics.areEqual(this.d, that.d) && Intrinsics.areEqual(this.e, that.e) && this.i.i() == that.i.i();
    }

    public final bi g() {
        return this.f;
    }

    public final Proxy f() {
        return this.g;
    }

    public final ProxySelector h() {
        return this.h;
    }

    public final di0 k() {
        return this.i;
    }

    public final List<im1> e() {
        return this.j;
    }

    public final List<or> b() {
        return this.k;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof ab) {
            ab abVar = (ab) obj;
            if (Intrinsics.areEqual(this.i, abVar.i) && a(abVar)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.e) + ((Objects.hashCode(this.d) + ((Objects.hashCode(this.c) + ((Objects.hashCode(this.g) + ((this.h.hashCode() + aa.a(this.k, aa.a(this.j, (this.f.hashCode() + ((this.f8387a.hashCode() + ((this.i.hashCode() + IronSourceError.ERROR_NON_EXISTENT_INSTANCE) * 31)) * 31)) * 31, 31), 31)) * 31)) * 31)) * 31)) * 31);
    }

    public final String toString() {
        StringBuilder sb;
        String strG = this.i.g();
        int i = this.i.i();
        Object obj = this.g;
        if (obj != null) {
            sb = new StringBuilder("proxy=");
        } else {
            obj = this.h;
            sb = new StringBuilder("proxySelector=");
        }
        return "Address{" + strG + ":" + i + ", " + sb.append(obj).toString() + "}";
    }
}
