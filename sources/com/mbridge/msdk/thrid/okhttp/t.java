package com.mbridge.msdk.thrid.okhttp;

import java.io.IOException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.Socket;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

/* JADX INFO: compiled from: OkHttpClient.java */
/* JADX INFO: loaded from: classes7.dex */
public class t implements Cloneable {
    static final List<u> A = com.mbridge.msdk.thrid.okhttp.internal.c.a(u.HTTP_2, u.HTTP_1_1);
    static final List<i> B = com.mbridge.msdk.thrid.okhttp.internal.c.a(i.h, i.j);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final l f5577a;

    @Nullable
    final Proxy b;
    final List<u> c;
    final List<i> d;
    final List<r> e;
    final List<r> f;
    final n.c g;
    final ProxySelector h;
    final k i;
    final SocketFactory j;
    final SSLSocketFactory k;
    final com.mbridge.msdk.thrid.okhttp.internal.tls.c l;
    final HostnameVerifier m;
    final e n;
    final com.mbridge.msdk.thrid.okhttp.b o;
    final com.mbridge.msdk.thrid.okhttp.b p;
    final h q;
    final m r;
    final boolean s;
    final boolean t;
    final boolean u;
    final int v;
    final int w;
    final int x;
    final int y;
    final int z;

    /* JADX INFO: compiled from: OkHttpClient.java */
    static class a extends com.mbridge.msdk.thrid.okhttp.internal.a {
        a() {
        }

        @Override // com.mbridge.msdk.thrid.okhttp.internal.a
        public void a(p.a aVar, String str) {
            aVar.a(str);
        }

        @Override // com.mbridge.msdk.thrid.okhttp.internal.a
        public void b(h hVar, com.mbridge.msdk.thrid.okhttp.internal.connection.c cVar) {
            hVar.b(cVar);
        }

        @Override // com.mbridge.msdk.thrid.okhttp.internal.a
        public void a(p.a aVar, String str, String str2) {
            aVar.b(str, str2);
        }

        @Override // com.mbridge.msdk.thrid.okhttp.internal.a
        public boolean a(h hVar, com.mbridge.msdk.thrid.okhttp.internal.connection.c cVar) {
            return hVar.a(cVar);
        }

        @Override // com.mbridge.msdk.thrid.okhttp.internal.a
        public com.mbridge.msdk.thrid.okhttp.internal.connection.c a(h hVar, com.mbridge.msdk.thrid.okhttp.a aVar, com.mbridge.msdk.thrid.okhttp.internal.connection.g gVar, a0 a0Var) {
            return hVar.a(aVar, gVar, a0Var);
        }

        @Override // com.mbridge.msdk.thrid.okhttp.internal.a
        public boolean a(com.mbridge.msdk.thrid.okhttp.a aVar, com.mbridge.msdk.thrid.okhttp.a aVar2) {
            return aVar.a(aVar2);
        }

        @Override // com.mbridge.msdk.thrid.okhttp.internal.a
        public Socket a(h hVar, com.mbridge.msdk.thrid.okhttp.a aVar, com.mbridge.msdk.thrid.okhttp.internal.connection.g gVar) {
            return hVar.a(aVar, gVar);
        }

        @Override // com.mbridge.msdk.thrid.okhttp.internal.a
        public com.mbridge.msdk.thrid.okhttp.internal.connection.d a(h hVar) {
            return hVar.e;
        }

        @Override // com.mbridge.msdk.thrid.okhttp.internal.a
        public int a(y.a aVar) {
            return aVar.c;
        }

        @Override // com.mbridge.msdk.thrid.okhttp.internal.a
        public void a(i iVar, SSLSocket sSLSocket, boolean z) {
            iVar.a(sSLSocket, z);
        }

        @Override // com.mbridge.msdk.thrid.okhttp.internal.a
        @Nullable
        public IOException a(d dVar, @Nullable IOException iOException) {
            return ((v) dVar).a(iOException);
        }
    }

    /* JADX INFO: compiled from: OkHttpClient.java */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        l f5578a;

        @Nullable
        Proxy b;
        List<u> c;
        List<i> d;
        final List<r> e;
        final List<r> f;
        n.c g;
        ProxySelector h;
        k i;
        SocketFactory j;

        @Nullable
        SSLSocketFactory k;

        @Nullable
        com.mbridge.msdk.thrid.okhttp.internal.tls.c l;
        HostnameVerifier m;
        e n;
        com.mbridge.msdk.thrid.okhttp.b o;
        com.mbridge.msdk.thrid.okhttp.b p;
        h q;
        m r;
        boolean s;
        boolean t;
        boolean u;
        int v;
        int w;
        int x;
        int y;
        int z;

        public b() {
            this.e = new ArrayList();
            this.f = new ArrayList();
            this.f5578a = new l();
            this.c = t.A;
            this.d = t.B;
            this.g = n.factory(n.NONE);
            ProxySelector proxySelector = ProxySelector.getDefault();
            this.h = proxySelector;
            if (proxySelector == null) {
                this.h = new com.mbridge.msdk.thrid.okhttp.internal.proxy.a();
            }
            this.i = k.f5568a;
            this.j = SocketFactory.getDefault();
            this.m = com.mbridge.msdk.thrid.okhttp.internal.tls.d.f5566a;
            this.n = e.c;
            com.mbridge.msdk.thrid.okhttp.b bVar = com.mbridge.msdk.thrid.okhttp.b.f5498a;
            this.o = bVar;
            this.p = bVar;
            this.q = new h();
            this.r = m.f5570a;
            this.s = true;
            this.t = true;
            this.u = true;
            this.v = 0;
            this.w = 10000;
            this.x = 10000;
            this.y = 10000;
            this.z = 0;
        }

        public b a(long j, TimeUnit timeUnit) {
            this.v = com.mbridge.msdk.thrid.okhttp.internal.c.a("timeout", j, timeUnit);
            return this;
        }

        public b b(long j, TimeUnit timeUnit) {
            this.w = com.mbridge.msdk.thrid.okhttp.internal.c.a("timeout", j, timeUnit);
            return this;
        }

        public b c(long j, TimeUnit timeUnit) {
            this.z = com.mbridge.msdk.thrid.okhttp.internal.c.a("interval", j, timeUnit);
            return this;
        }

        public b d(long j, TimeUnit timeUnit) {
            this.x = com.mbridge.msdk.thrid.okhttp.internal.c.a("timeout", j, timeUnit);
            return this;
        }

        public b e(long j, TimeUnit timeUnit) {
            this.y = com.mbridge.msdk.thrid.okhttp.internal.c.a("timeout", j, timeUnit);
            return this;
        }

        public b a(m mVar) {
            if (mVar == null) {
                throw new NullPointerException("dns == null");
            }
            this.r = mVar;
            return this;
        }

        public b a(HostnameVerifier hostnameVerifier) {
            if (hostnameVerifier != null) {
                this.m = hostnameVerifier;
                return this;
            }
            throw new NullPointerException("hostnameVerifier == null");
        }

        public b a(h hVar) {
            if (hVar != null) {
                this.q = hVar;
                return this;
            }
            throw new NullPointerException("connectionPool == null");
        }

        public b a(boolean z) {
            this.u = z;
            return this;
        }

        public b a(l lVar) {
            if (lVar != null) {
                this.f5578a = lVar;
                return this;
            }
            throw new IllegalArgumentException("dispatcher == null");
        }

        public b a(List<u> list) {
            ArrayList arrayList = new ArrayList(list);
            u uVar = u.H2_PRIOR_KNOWLEDGE;
            if (!arrayList.contains(uVar) && !arrayList.contains(u.HTTP_1_1)) {
                throw new IllegalArgumentException("protocols must contain h2_prior_knowledge or http/1.1: " + arrayList);
            }
            if (arrayList.contains(uVar) && arrayList.size() > 1) {
                throw new IllegalArgumentException("protocols containing h2_prior_knowledge cannot use other protocols: " + arrayList);
            }
            if (!arrayList.contains(u.HTTP_1_0)) {
                if (!arrayList.contains(null)) {
                    arrayList.remove(u.SPDY_3);
                    this.c = Collections.unmodifiableList(arrayList);
                    return this;
                }
                throw new IllegalArgumentException("protocols must not contain null");
            }
            throw new IllegalArgumentException("protocols must not contain http/1.0: " + arrayList);
        }

        public b a(n nVar) {
            if (nVar != null) {
                this.g = n.factory(nVar);
                return this;
            }
            throw new NullPointerException("eventListener == null");
        }

        public t a() {
            return new t(this);
        }

        b(t tVar) {
            ArrayList arrayList = new ArrayList();
            this.e = arrayList;
            ArrayList arrayList2 = new ArrayList();
            this.f = arrayList2;
            this.f5578a = tVar.f5577a;
            this.b = tVar.b;
            this.c = tVar.c;
            this.d = tVar.d;
            arrayList.addAll(tVar.e);
            arrayList2.addAll(tVar.f);
            this.g = tVar.g;
            this.h = tVar.h;
            this.i = tVar.i;
            this.j = tVar.j;
            this.k = tVar.k;
            this.l = tVar.l;
            this.m = tVar.m;
            this.n = tVar.n;
            this.o = tVar.o;
            this.p = tVar.p;
            this.q = tVar.q;
            this.r = tVar.r;
            this.s = tVar.s;
            this.t = tVar.t;
            this.u = tVar.u;
            this.v = tVar.v;
            this.w = tVar.w;
            this.x = tVar.x;
            this.y = tVar.y;
            this.z = tVar.z;
        }
    }

    static {
        com.mbridge.msdk.thrid.okhttp.internal.a.f5510a = new a();
    }

    public t() {
        this(new b());
    }

    private static SSLSocketFactory a(X509TrustManager x509TrustManager) {
        try {
            SSLContext sSLContextE = com.mbridge.msdk.thrid.okhttp.internal.platform.g.d().e();
            sSLContextE.init(null, new TrustManager[]{x509TrustManager}, null);
            return sSLContextE.getSocketFactory();
        } catch (GeneralSecurityException e) {
            throw com.mbridge.msdk.thrid.okhttp.internal.c.a("No System TLS", (Exception) e);
        }
    }

    public SocketFactory A() {
        return this.j;
    }

    public SSLSocketFactory B() {
        return this.k;
    }

    public int C() {
        return this.y;
    }

    public int b() {
        return this.v;
    }

    public e c() {
        return this.n;
    }

    public int e() {
        return this.w;
    }

    public h f() {
        return this.q;
    }

    public List<i> g() {
        return this.d;
    }

    public k i() {
        return this.i;
    }

    public l j() {
        return this.f5577a;
    }

    public m k() {
        return this.r;
    }

    public n.c l() {
        return this.g;
    }

    public boolean m() {
        return this.t;
    }

    public boolean n() {
        return this.s;
    }

    public HostnameVerifier o() {
        return this.m;
    }

    public List<r> p() {
        return this.e;
    }

    com.mbridge.msdk.thrid.okhttp.internal.cache.c q() {
        return null;
    }

    public List<r> r() {
        return this.f;
    }

    public b s() {
        return new b(this);
    }

    public int t() {
        return this.z;
    }

    public List<u> u() {
        return this.c;
    }

    @Nullable
    public Proxy v() {
        return this.b;
    }

    public com.mbridge.msdk.thrid.okhttp.b w() {
        return this.o;
    }

    public ProxySelector x() {
        return this.h;
    }

    public int y() {
        return this.x;
    }

    public boolean z() {
        return this.u;
    }

    t(b bVar) {
        boolean z;
        this.f5577a = bVar.f5578a;
        this.b = bVar.b;
        this.c = bVar.c;
        List<i> list = bVar.d;
        this.d = list;
        this.e = com.mbridge.msdk.thrid.okhttp.internal.c.a(bVar.e);
        this.f = com.mbridge.msdk.thrid.okhttp.internal.c.a(bVar.f);
        this.g = bVar.g;
        this.h = bVar.h;
        this.i = bVar.i;
        this.j = bVar.j;
        Iterator<i> it = list.iterator();
        loop0: while (true) {
            z = false;
            while (true) {
                if (!it.hasNext()) {
                    break loop0;
                } else {
                    z = (z || it.next().b()) ? true : z;
                }
            }
        }
        SSLSocketFactory sSLSocketFactory = bVar.k;
        if (sSLSocketFactory == null && z) {
            X509TrustManager x509TrustManagerA = com.mbridge.msdk.thrid.okhttp.internal.c.a();
            this.k = a(x509TrustManagerA);
            this.l = com.mbridge.msdk.thrid.okhttp.internal.tls.c.a(x509TrustManagerA);
        } else {
            this.k = sSLSocketFactory;
            this.l = bVar.l;
        }
        if (this.k != null) {
            com.mbridge.msdk.thrid.okhttp.internal.platform.g.d().a(this.k);
        }
        this.m = bVar.m;
        this.n = bVar.n.a(this.l);
        this.o = bVar.o;
        this.p = bVar.p;
        this.q = bVar.q;
        this.r = bVar.r;
        this.s = bVar.s;
        this.t = bVar.t;
        this.u = bVar.u;
        this.v = bVar.v;
        this.w = bVar.w;
        this.x = bVar.x;
        this.y = bVar.y;
        this.z = bVar.z;
        if (this.e.contains(null)) {
            throw new IllegalStateException("Null interceptor: " + this.e);
        }
        if (this.f.contains(null)) {
            throw new IllegalStateException("Null network interceptor: " + this.f);
        }
    }

    public com.mbridge.msdk.thrid.okhttp.b a() {
        return this.p;
    }

    public d a(w wVar) {
        return v.a(this, wVar, false);
    }
}
