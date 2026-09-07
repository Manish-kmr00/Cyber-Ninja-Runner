package com.yandex.mobile.ads.impl;

import java.net.ProxySelector;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class be1 implements Cloneable, mn.a {
    public static final /* synthetic */ int B = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final p10 f8499a;
    private final mr b;
    private final List<ip0> c;
    private final List<ip0> d;
    private final t50.b e;
    private final boolean f;
    private final bi g;
    private final boolean h;
    private final boolean i;
    private final ns j;
    private final n30 k;
    private final ProxySelector l;
    private final bi m;
    private final SocketFactory n;
    private final SSLSocketFactory o;
    private final X509TrustManager p;
    private final List<or> q;
    private final List<im1> r;
    private final ae1 s;
    private final eo t;
    private final Cdo u;
    private final int v;
    private final int w;
    private final int x;
    private final ps1 y;
    private static final List<im1> z = y82.a(im1.g, im1.e);
    private static final List<or> A = y82.a(or.e, or.f);

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private p10 f8500a = new p10();
        private mr b = new mr();
        private final ArrayList c = new ArrayList();
        private final ArrayList d = new ArrayList();
        private t50.b e = y82.a(t50.f10269a);
        private boolean f = true;
        private bi g;
        private boolean h;
        private boolean i;
        private ns j;
        private n30 k;
        private bi l;
        private SocketFactory m;
        private SSLSocketFactory n;
        private X509TrustManager o;
        private List<or> p;
        private List<? extends im1> q;
        private ae1 r;
        private eo s;
        private Cdo t;
        private int u;
        private int v;
        private int w;

        public final a a(long j, TimeUnit unit) {
            Intrinsics.checkNotNullParameter(unit, "unit");
            this.u = y82.a(j, unit);
            return this;
        }

        public final ae1 n() {
            return this.r;
        }

        public final ArrayList o() {
            return this.c;
        }

        public final ArrayList p() {
            return this.d;
        }

        public a() {
            bi biVar = bi.f8511a;
            this.g = biVar;
            this.h = true;
            this.i = true;
            this.j = ns.f9750a;
            this.k = n30.f9694a;
            this.l = biVar;
            SocketFactory socketFactory = SocketFactory.getDefault();
            Intrinsics.checkNotNullExpressionValue(socketFactory, "getDefault(...)");
            this.m = socketFactory;
            int i = be1.B;
            this.p = b.a();
            this.q = b.b();
            this.r = ae1.f8398a;
            this.s = eo.c;
            this.u = 10000;
            this.v = 10000;
            this.w = 10000;
        }

        public final p10 i() {
            return this.f8500a;
        }

        public final mr f() {
            return this.b;
        }

        public final t50.b k() {
            return this.e;
        }

        public final boolean t() {
            return this.f;
        }

        public final bi b() {
            return this.g;
        }

        public final a b(long j, TimeUnit unit) {
            Intrinsics.checkNotNullParameter(unit, "unit");
            this.v = y82.a(j, unit);
            return this;
        }

        public final boolean l() {
            return this.h;
        }

        public final boolean m() {
            return this.i;
        }

        public final ns h() {
            return this.j;
        }

        public final n30 j() {
            return this.k;
        }

        public final bi r() {
            return this.l;
        }

        public final SocketFactory u() {
            return this.m;
        }

        public final SSLSocketFactory v() {
            return this.n;
        }

        public final X509TrustManager x() {
            return this.o;
        }

        public final List<or> g() {
            return this.p;
        }

        public final List<im1> q() {
            return this.q;
        }

        public final eo d() {
            return this.s;
        }

        public final Cdo c() {
            return this.t;
        }

        public final int e() {
            return this.u;
        }

        public final int s() {
            return this.v;
        }

        public final int w() {
            return this.w;
        }

        public final a a() {
            this.h = true;
            return this;
        }

        public final a a(SSLSocketFactory sslSocketFactory, X509TrustManager trustManager) {
            Intrinsics.checkNotNullParameter(sslSocketFactory, "sslSocketFactory");
            Intrinsics.checkNotNullParameter(trustManager, "trustManager");
            if (Intrinsics.areEqual(sslSocketFactory, this.n)) {
                Intrinsics.areEqual(trustManager, this.o);
            }
            this.n = sslSocketFactory;
            Intrinsics.checkNotNullParameter(trustManager, "trustManager");
            this.t = nh1.f9731a.a(trustManager);
            this.o = trustManager;
            return this;
        }
    }

    public static final class b {
        public static List a() {
            return be1.A;
        }

        public static List b() {
            return be1.z;
        }
    }

    @Override // com.yandex.mobile.ads.impl.mn.a
    public final sn1 a(op1 request) {
        Intrinsics.checkNotNullParameter(request, "request");
        return new sn1(this, request, false);
    }

    public final ae1 o() {
        return this.s;
    }

    public final Object clone() {
        return super.clone();
    }

    public final p10 i() {
        return this.f8499a;
    }

    public final mr f() {
        return this.b;
    }

    public final List<ip0> p() {
        return this.c;
    }

    public final List<ip0> q() {
        return this.d;
    }

    public final t50.b k() {
        return this.e;
    }

    public final boolean v() {
        return this.f;
    }

    public final bi c() {
        return this.g;
    }

    public final boolean l() {
        return this.h;
    }

    public final boolean m() {
        return this.i;
    }

    public final ns h() {
        return this.j;
    }

    public final n30 j() {
        return this.k;
    }

    public final ProxySelector t() {
        return this.l;
    }

    public final bi s() {
        return this.m;
    }

    public final SocketFactory w() {
        return this.n;
    }

    public final SSLSocketFactory x() {
        SSLSocketFactory sSLSocketFactory = this.o;
        if (sSLSocketFactory != null) {
            return sSLSocketFactory;
        }
        throw new IllegalStateException("CLEARTEXT-only client");
    }

    public final List<or> g() {
        return this.q;
    }

    public final List<im1> r() {
        return this.r;
    }

    public final eo d() {
        return this.t;
    }

    public final int e() {
        return this.v;
    }

    public final int u() {
        return this.w;
    }

    public final int z() {
        return this.x;
    }

    public final ps1 n() {
        return this.y;
    }

    public be1() {
        this(new a());
    }

    public be1(a builder) throws NoSuchAlgorithmException, KeyStoreException {
        Intrinsics.checkNotNullParameter(builder, "builder");
        this.f8499a = builder.i();
        this.b = builder.f();
        this.c = y82.b(builder.o());
        this.d = y82.b(builder.p());
        this.e = builder.k();
        this.f = builder.t();
        this.g = builder.b();
        this.h = builder.l();
        this.i = builder.m();
        this.j = builder.h();
        this.k = builder.j();
        ProxySelector proxySelector = ProxySelector.getDefault();
        this.l = proxySelector == null ? rd1.f10096a : proxySelector;
        this.m = builder.r();
        this.n = builder.u();
        List<or> listG = builder.g();
        this.q = listG;
        this.r = builder.q();
        this.s = builder.n();
        this.v = builder.e();
        this.w = builder.s();
        this.x = builder.w();
        this.y = new ps1();
        if (!(listG instanceof Collection) || !listG.isEmpty()) {
            Iterator<T> it = listG.iterator();
            while (it.hasNext()) {
                if (((or) it.next()).a()) {
                    if (builder.v() != null) {
                        this.o = builder.v();
                        Cdo cdoC = builder.c();
                        Intrinsics.checkNotNull(cdoC);
                        this.u = cdoC;
                        X509TrustManager x509TrustManagerX = builder.x();
                        Intrinsics.checkNotNull(x509TrustManagerX);
                        this.p = x509TrustManagerX;
                        eo eoVarD = builder.d();
                        Intrinsics.checkNotNull(cdoC);
                        this.t = eoVarD.a(cdoC);
                    } else {
                        int i = nh1.c;
                        nh1.a.a().getClass();
                        X509TrustManager x509TrustManagerC = nh1.c();
                        this.p = x509TrustManagerC;
                        nh1 nh1VarA = nh1.a.a();
                        Intrinsics.checkNotNull(x509TrustManagerC);
                        nh1VarA.getClass();
                        this.o = nh1.c(x509TrustManagerC);
                        Intrinsics.checkNotNull(x509TrustManagerC);
                        Cdo cdoA = Cdo.a.a(x509TrustManagerC);
                        this.u = cdoA;
                        eo eoVarD2 = builder.d();
                        Intrinsics.checkNotNull(cdoA);
                        this.t = eoVarD2.a(cdoA);
                    }
                }
            }
            this.o = null;
            this.u = null;
            this.p = null;
            this.t = eo.c;
        } else {
            this.o = null;
            this.u = null;
            this.p = null;
            this.t = eo.c;
        }
        y();
    }

    private final void y() {
        List<ip0> list = this.c;
        Intrinsics.checkNotNull(list, "null cannot be cast to non-null type kotlin.collections.List<com.monetization.ads.embedded.okhttp.src.main.kotlin.okhttp3.Interceptor?>");
        if (!list.contains(null)) {
            List<ip0> list2 = this.d;
            Intrinsics.checkNotNull(list2, "null cannot be cast to non-null type kotlin.collections.List<com.monetization.ads.embedded.okhttp.src.main.kotlin.okhttp3.Interceptor?>");
            if (!list2.contains(null)) {
                List<or> list3 = this.q;
                if (!(list3 instanceof Collection) || !list3.isEmpty()) {
                    Iterator<T> it = list3.iterator();
                    while (it.hasNext()) {
                        if (((or) it.next()).a()) {
                            if (this.o != null) {
                                if (this.u != null) {
                                    if (this.p == null) {
                                        throw new IllegalStateException("x509TrustManager == null".toString());
                                    }
                                    return;
                                }
                                throw new IllegalStateException("certificateChainCleaner == null".toString());
                            }
                            throw new IllegalStateException("sslSocketFactory == null".toString());
                        }
                    }
                }
                if (this.o == null) {
                    if (this.u == null) {
                        if (this.p == null) {
                            if (!Intrinsics.areEqual(this.t, eo.c)) {
                                throw new IllegalStateException("Check failed.".toString());
                            }
                            return;
                        }
                        throw new IllegalStateException("Check failed.".toString());
                    }
                    throw new IllegalStateException("Check failed.".toString());
                }
                throw new IllegalStateException("Check failed.".toString());
            }
            throw new IllegalStateException(("Null network interceptor: " + this.d).toString());
        }
        throw new IllegalStateException(("Null interceptor: " + this.c).toString());
    }
}
