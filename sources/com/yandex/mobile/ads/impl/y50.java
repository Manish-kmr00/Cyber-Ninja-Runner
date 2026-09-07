package com.yandex.mobile.ads.impl;

import java.io.IOException;
import java.net.ProtocolException;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.ForwardingSink;
import okio.ForwardingSource;
import okio.Okio;
import okio.Sink;
import okio.Source;

/* JADX INFO: loaded from: classes6.dex */
public final class y50 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final sn1 f10699a;
    private final t50 b;
    private final a60 c;
    private final z50 d;
    private boolean e;
    private final tn1 f;

    public y50(sn1 call, t50 eventListener, a60 finder, z50 codec) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(eventListener, "eventListener");
        Intrinsics.checkNotNullParameter(finder, "finder");
        Intrinsics.checkNotNullParameter(codec, "codec");
        this.f10699a = call;
        this.b = eventListener;
        this.c = finder;
        this.d = codec;
        this.f = codec.c();
    }

    public final IOException a(boolean z, boolean z2, IOException ioe) {
        if (ioe != null) {
            this.c.a(ioe);
            this.d.c().a(this.f10699a, ioe);
        }
        if (z2) {
            if (ioe != null) {
                t50 t50Var = this.b;
                sn1 call = this.f10699a;
                t50Var.getClass();
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(ioe, "ioe");
            } else {
                t50 t50Var2 = this.b;
                sn1 call2 = this.f10699a;
                t50Var2.getClass();
                Intrinsics.checkNotNullParameter(call2, "call");
            }
        }
        if (z) {
            if (ioe != null) {
                t50 t50Var3 = this.b;
                sn1 call3 = this.f10699a;
                t50Var3.getClass();
                Intrinsics.checkNotNullParameter(call3, "call");
                Intrinsics.checkNotNullParameter(ioe, "ioe");
            } else {
                t50 t50Var4 = this.b;
                sn1 call4 = this.f10699a;
                t50Var4.getClass();
                Intrinsics.checkNotNullParameter(call4, "call");
            }
        }
        return this.f10699a.a(this, z2, z, ioe);
    }

    public final sn1 e() {
        return this.f10699a;
    }

    public final t50 g() {
        return this.b;
    }

    public final a60 h() {
        return this.c;
    }

    public final boolean j() {
        return this.e;
    }

    public final tn1 f() {
        return this.f;
    }

    public final boolean i() {
        return !Intrinsics.areEqual(this.c.a().k().g(), this.f.k().a().k().g());
    }

    public final void d() throws IOException {
        try {
            this.d.b();
        } catch (IOException ioe) {
            t50 t50Var = this.b;
            sn1 call = this.f10699a;
            t50Var.getClass();
            Intrinsics.checkNotNullParameter(call, "call");
            Intrinsics.checkNotNullParameter(ioe, "ioe");
            this.c.a(ioe);
            this.d.c().a(this.f10699a, ioe);
            throw ioe;
        }
    }

    public final void c() throws IOException {
        try {
            this.d.a();
        } catch (IOException ioe) {
            t50 t50Var = this.b;
            sn1 call = this.f10699a;
            t50Var.getClass();
            Intrinsics.checkNotNullParameter(call, "call");
            Intrinsics.checkNotNullParameter(ioe, "ioe");
            this.c.a(ioe);
            this.d.c().a(this.f10699a, ioe);
            throw ioe;
        }
    }

    public final void m() {
        t50 t50Var = this.b;
        sn1 call = this.f10699a;
        t50Var.getClass();
        Intrinsics.checkNotNullParameter(call, "call");
    }

    public final void k() {
        this.d.c().j();
    }

    public final void b() {
        this.d.cancel();
        this.f10699a.a(this, true, true, null);
    }

    public final void b(oq1 response) {
        Intrinsics.checkNotNullParameter(response, "response");
        t50 t50Var = this.b;
        sn1 call = this.f10699a;
        t50Var.getClass();
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(response, "response");
    }

    public final void a() {
        this.d.cancel();
    }

    public final Sink a(op1 request) throws IOException {
        Intrinsics.checkNotNullParameter(request, "request");
        this.e = false;
        rp1 rp1VarA = request.a();
        Intrinsics.checkNotNull(rp1VarA);
        long jA = rp1VarA.a();
        t50 t50Var = this.b;
        sn1 call = this.f10699a;
        t50Var.getClass();
        Intrinsics.checkNotNullParameter(call, "call");
        return new a(this, this.d.a(request, jA), jA);
    }

    public final xn1 a(oq1 response) throws IOException {
        Intrinsics.checkNotNullParameter(response, "response");
        try {
            String strA = oq1.a(response, "Content-Type");
            long jB = this.d.b(response);
            return new xn1(strA, jB, Okio.buffer(new b(this, this.d.a(response), jB)));
        } catch (IOException ioe) {
            t50 t50Var = this.b;
            sn1 call = this.f10699a;
            t50Var.getClass();
            Intrinsics.checkNotNullParameter(call, "call");
            Intrinsics.checkNotNullParameter(ioe, "ioe");
            this.c.a(ioe);
            this.d.c().a(this.f10699a, ioe);
            throw ioe;
        }
    }

    public final void l() {
        this.f10699a.a(this, true, false, null);
    }

    private final class a extends ForwardingSink {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f10700a;
        private boolean b;
        private long c;
        private boolean d;
        final /* synthetic */ y50 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(y50 y50Var, Sink delegate, long j) {
            super(delegate);
            Intrinsics.checkNotNullParameter(delegate, "delegate");
            this.e = y50Var;
            this.f10700a = j;
        }

        @Override // okio.ForwardingSink, okio.Sink
        public final void write(Buffer source, long j) throws IOException {
            Intrinsics.checkNotNullParameter(source, "source");
            if (this.d) {
                throw new IllegalStateException("closed".toString());
            }
            long j2 = this.f10700a;
            if (j2 != -1 && this.c + j > j2) {
                throw new ProtocolException("expected " + this.f10700a + " bytes but received " + (this.c + j));
            }
            try {
                super.write(source, j);
                this.c += j;
            } catch (IOException e) {
                if (this.b) {
                    throw e;
                }
                this.b = true;
                throw this.e.a(false, true, e);
            }
        }

        @Override // okio.ForwardingSink, okio.Sink, java.io.Flushable
        public final void flush() throws IOException {
            try {
                super.flush();
            } catch (IOException e) {
                if (!this.b) {
                    this.b = true;
                    throw this.e.a(false, true, e);
                }
            }
        }

        @Override // okio.ForwardingSink, okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public final void close() throws IOException {
            if (this.d) {
                return;
            }
            this.d = true;
            long j = this.f10700a;
            if (j != -1 && this.c != j) {
                throw new ProtocolException("unexpected end of stream");
            }
            try {
                super.close();
                if (this.b) {
                    return;
                }
                this.b = true;
                this.e.a(false, true, null);
            } catch (IOException e) {
                if (!this.b) {
                    this.b = true;
                    throw this.e.a(false, true, e);
                }
            }
        }
    }

    public final void b(op1 request) throws IOException {
        Intrinsics.checkNotNullParameter(request, "request");
        try {
            t50 t50Var = this.b;
            sn1 call = this.f10699a;
            t50Var.getClass();
            Intrinsics.checkNotNullParameter(call, "call");
            this.d.a(request);
            t50 t50Var2 = this.b;
            sn1 call2 = this.f10699a;
            t50Var2.getClass();
            Intrinsics.checkNotNullParameter(call2, "call");
            Intrinsics.checkNotNullParameter(request, "request");
        } catch (IOException ioe) {
            t50 t50Var3 = this.b;
            sn1 call3 = this.f10699a;
            t50Var3.getClass();
            Intrinsics.checkNotNullParameter(call3, "call");
            Intrinsics.checkNotNullParameter(ioe, "ioe");
            this.c.a(ioe);
            this.d.c().a(this.f10699a, ioe);
            throw ioe;
        }
    }

    public final oq1.a a(boolean z) throws IOException {
        try {
            oq1.a aVarA = this.d.a(z);
            if (aVarA != null) {
                aVarA.a(this);
            }
            return aVarA;
        } catch (IOException ioe) {
            t50 t50Var = this.b;
            sn1 call = this.f10699a;
            t50Var.getClass();
            Intrinsics.checkNotNullParameter(call, "call");
            Intrinsics.checkNotNullParameter(ioe, "ioe");
            this.c.a(ioe);
            this.d.c().a(this.f10699a, ioe);
            throw ioe;
        }
    }

    public final class b extends ForwardingSource {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f10701a;
        private long b;
        private boolean c;
        private boolean d;
        private boolean e;
        final /* synthetic */ y50 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(y50 y50Var, Source delegate, long j) {
            super(delegate);
            Intrinsics.checkNotNullParameter(delegate, "delegate");
            this.f = y50Var;
            this.f10701a = j;
            this.c = true;
            if (j == 0) {
                a(null);
            }
        }

        @Override // okio.ForwardingSource, okio.Source
        public final long read(Buffer sink, long j) throws IOException {
            Intrinsics.checkNotNullParameter(sink, "sink");
            if (this.e) {
                throw new IllegalStateException("closed".toString());
            }
            try {
                long j2 = delegate().read(sink, j);
                if (this.c) {
                    this.c = false;
                    t50 t50VarG = this.f.g();
                    sn1 sn1VarE = this.f.e();
                    t50VarG.getClass();
                    t50.a(sn1VarE);
                }
                if (j2 == -1) {
                    a(null);
                    return -1L;
                }
                long j3 = this.b + j2;
                long j4 = this.f10701a;
                if (j4 != -1 && j3 > j4) {
                    throw new ProtocolException("expected " + this.f10701a + " bytes but received " + j3);
                }
                this.b = j3;
                if (j3 == j4) {
                    a(null);
                }
                return j2;
            } catch (IOException e) {
                throw a(e);
            }
        }

        @Override // okio.ForwardingSource, okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public final void close() throws IOException {
            if (this.e) {
                return;
            }
            this.e = true;
            try {
                super.close();
                a(null);
            } catch (IOException e) {
                throw a(e);
            }
        }

        public final <E extends IOException> E a(E e) {
            if (this.d) {
                return e;
            }
            this.d = true;
            if (e == null && this.c) {
                this.c = false;
                t50 t50VarG = this.f.g();
                sn1 call = this.f.e();
                t50VarG.getClass();
                Intrinsics.checkNotNullParameter(call, "call");
            }
            return (E) this.f.a(true, false, e);
        }
    }
}
