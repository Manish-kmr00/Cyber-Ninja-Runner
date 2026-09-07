package com.yandex.mobile.ads.impl;

import java.io.Closeable;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class oq1 implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final op1 f9849a;
    private final im1 b;
    private final String c;
    private final int d;
    private final ff0 e;
    private final nf0 f;
    private final sq1 g;
    private final oq1 h;
    private final oq1 i;
    private final oq1 j;
    private final long k;
    private final long l;
    private final y50 m;

    public oq1(op1 request, im1 protocol, String message, int i, ff0 ff0Var, nf0 headers, sq1 sq1Var, oq1 oq1Var, oq1 oq1Var2, oq1 oq1Var3, long j, long j2, y50 y50Var) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(protocol, "protocol");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(headers, "headers");
        this.f9849a = request;
        this.b = protocol;
        this.c = message;
        this.d = i;
        this.e = ff0Var;
        this.f = headers;
        this.g = sq1Var;
        this.h = oq1Var;
        this.i = oq1Var2;
        this.j = oq1Var3;
        this.k = j;
        this.l = j2;
        this.m = y50Var;
    }

    public final a k() {
        return new a(this);
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private op1 f9850a;
        private im1 b;
        private int c;
        private String d;
        private ff0 e;
        private nf0.a f;
        private sq1 g;
        private oq1 h;
        private oq1 i;
        private oq1 j;
        private long k;
        private long l;
        private y50 m;

        public final a c() {
            Intrinsics.checkNotNullParameter("Proxy-Authenticate", "name");
            Intrinsics.checkNotNullParameter("OkHttp-Preemptive", "value");
            nf0.a aVar = this.f;
            aVar.getClass();
            Intrinsics.checkNotNullParameter("Proxy-Authenticate", "name");
            Intrinsics.checkNotNullParameter("OkHttp-Preemptive", "value");
            nf0.b.b("Proxy-Authenticate");
            nf0.b.b("OkHttp-Preemptive", "Proxy-Authenticate");
            aVar.a("Proxy-Authenticate");
            aVar.a("Proxy-Authenticate", "OkHttp-Preemptive");
            return this;
        }

        public final a c(oq1 oq1Var) {
            if (oq1Var.a() == null) {
                this.j = oq1Var;
                return this;
            }
            throw new IllegalArgumentException("priorResponse.body != null".toString());
        }

        public final int b() {
            return this.c;
        }

        public a() {
            this.c = -1;
            this.f = new nf0.a();
        }

        public a(oq1 response) {
            Intrinsics.checkNotNullParameter(response, "response");
            this.c = -1;
            this.f9850a = response.o();
            this.b = response.m();
            this.c = response.d();
            this.d = response.i();
            this.e = response.f();
            this.f = response.g().b();
            this.g = response.a();
            this.h = response.j();
            this.i = response.b();
            this.j = response.l();
            this.k = response.p();
            this.l = response.n();
            this.m = response.e();
        }

        public final a a(sq1 sq1Var) {
            this.g = sq1Var;
            return this;
        }

        public final a b(oq1 oq1Var) {
            a(oq1Var, "networkResponse");
            this.h = oq1Var;
            return this;
        }

        public final oq1 a() {
            int i = this.c;
            if (i >= 0) {
                op1 op1Var = this.f9850a;
                if (op1Var != null) {
                    im1 im1Var = this.b;
                    if (im1Var != null) {
                        String str = this.d;
                        if (str != null) {
                            return new oq1(op1Var, im1Var, str, i, this.e, this.f.a(), this.g, this.h, this.i, this.j, this.k, this.l, this.m);
                        }
                        throw new IllegalStateException("message == null".toString());
                    }
                    throw new IllegalStateException("protocol == null".toString());
                }
                throw new IllegalStateException("request == null".toString());
            }
            throw new IllegalStateException(("code < 0: " + i).toString());
        }

        public final a b(long j) {
            this.k = j;
            return this;
        }

        public final a a(oq1 oq1Var) {
            a(oq1Var, "cacheResponse");
            this.i = oq1Var;
            return this;
        }

        private static void a(oq1 oq1Var, String str) {
            if (oq1Var != null) {
                if (oq1Var.a() == null) {
                    if (oq1Var.j() == null) {
                        if (oq1Var.b() == null) {
                            if (oq1Var.l() != null) {
                                throw new IllegalArgumentException((str + ".priorResponse != null").toString());
                            }
                            return;
                        }
                        throw new IllegalArgumentException((str + ".cacheResponse != null").toString());
                    }
                    throw new IllegalArgumentException((str + ".networkResponse != null").toString());
                }
                throw new IllegalArgumentException((str + ".body != null").toString());
            }
        }

        public final a a(int i) {
            this.c = i;
            return this;
        }

        public final a a(ff0 ff0Var) {
            this.e = ff0Var;
            return this;
        }

        public final a a(nf0 headers) {
            Intrinsics.checkNotNullParameter(headers, "headers");
            this.f = headers.b();
            return this;
        }

        public final void a(y50 deferredTrailers) {
            Intrinsics.checkNotNullParameter(deferredTrailers, "deferredTrailers");
            this.m = deferredTrailers;
        }

        public final a a(String message) {
            Intrinsics.checkNotNullParameter(message, "message");
            this.d = message;
            return this;
        }

        public final a a(im1 protocol) {
            Intrinsics.checkNotNullParameter(protocol, "protocol");
            this.b = protocol;
            return this;
        }

        public final a a(long j) {
            this.l = j;
            return this;
        }

        public final a a(op1 request) {
            Intrinsics.checkNotNullParameter(request, "request");
            this.f9850a = request;
            return this;
        }
    }

    public final op1 o() {
        return this.f9849a;
    }

    public final im1 m() {
        return this.b;
    }

    public final String i() {
        return this.c;
    }

    public final int d() {
        return this.d;
    }

    public final ff0 f() {
        return this.e;
    }

    public final nf0 g() {
        return this.f;
    }

    public final sq1 a() {
        return this.g;
    }

    public static String a(oq1 oq1Var, String name) {
        oq1Var.getClass();
        Intrinsics.checkNotNullParameter(name, "name");
        String strA = oq1Var.f.a(name);
        if (strA == null) {
            return null;
        }
        return strA;
    }

    public final oq1 j() {
        return this.h;
    }

    public final oq1 b() {
        return this.i;
    }

    public final oq1 l() {
        return this.j;
    }

    public final long p() {
        return this.k;
    }

    public final long n() {
        return this.l;
    }

    public final y50 e() {
        return this.m;
    }

    public final boolean h() {
        int i = this.d;
        return 200 <= i && i < 300;
    }

    public final List<fo> c() {
        String str;
        nf0 nf0Var = this.f;
        int i = this.d;
        if (i == 401) {
            str = "WWW-Authenticate";
        } else {
            if (i != 407) {
                return CollectionsKt.emptyList();
            }
            str = "Proxy-Authenticate";
        }
        return uh0.a(nf0Var, str);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        sq1 sq1Var = this.g;
        if (sq1Var != null) {
            y82.a((Closeable) sq1Var.c());
            return;
        }
        throw new IllegalStateException("response is not eligible for a body and must not be closed".toString());
    }

    public final String toString() {
        return "Response{protocol=" + this.b + ", code=" + this.d + ", message=" + this.c + ", url=" + this.f9849a.g() + "}";
    }
}
